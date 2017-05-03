package pbs.business.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pbs.base.dao.mapper.PbsBikeInfoMapper;
import pbs.base.dao.mapper.PbsNodeInfoMapper;
import pbs.base.dao.mapper.PbsRentInfoMapper;
import pbs.base.pojo.po.PbsBikeInfo;
import pbs.base.pojo.po.PbsBikeInfoExample;
import pbs.base.pojo.po.PbsNodeInfo;
import pbs.base.pojo.po.PbsNodeInfoExample;
import pbs.base.pojo.po.PbsRentInfo;
import pbs.base.pojo.po.PbsRentInfoExample;
import pbs.business.dao.mapper.PbsWechatOrderMapper;
import pbs.business.dao.mapper.PbsWechatUserMapper;
import pbs.business.pojo.po.PbsWechatOrder;
import pbs.business.pojo.po.PbsWechatOrderExample;
import pbs.business.pojo.po.PbsWechatUser;
import pbs.business.pojo.po.PbsWechatUserExample;
import pbs.business.service.WechatService;

public class WechatServiceImpl implements WechatService{

	@Autowired
	private PbsWechatUserMapper userMapper;
	
	@Autowired
	private PbsBikeInfoMapper bikeMapper;
	
	@Autowired
	private PbsRentInfoMapper rentMapper;
	
	@Autowired
	private PbsNodeInfoMapper nodeMapper;
	
	@Autowired
	private PbsWechatOrderMapper orderMapper;
	
	private String openid;
	private long orderid;
	
	public static final int order_state_sucess = 1;
	public static final int order_state_fail = 2;
	public static final int order_state_process = 3;
	
	@Override
	public PbsWechatUser findUserByOpenid(String openid) throws Exception {
		PbsWechatUserExample pbsWechatUserExample = new PbsWechatUserExample();
		PbsWechatUserExample.Criteria criteria = pbsWechatUserExample.createCriteria();
		criteria.andOpenidEqualTo(openid);
		List<PbsWechatUser> list = userMapper.selectByExample(pbsWechatUserExample);
		if(list != null&& list.size() ==1){
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 1为已经注册，0为未注册
	 * @param openid
	 * @return
	 * @throws Exception
	 */
	public int checkOpenid(String openid)throws Exception{
		this.openid = openid;
		PbsWechatUser user = findUserByOpenid(openid);
		if(user != null){
			//String email = user.getEmail();
			String tel = user.getTel();
			if(tel == null||tel == ""){
				return 0;
			}else{
				return 1;
			}
		}else{
			PbsWechatUser user1 = new PbsWechatUser();
			user1.setOpenid(openid);
			userMapper.insert(user1);
			return 0;
		}
	}
	
	public void register(String tel)throws Exception{
//		System.out.println(openid);
//		System.out.println(tel);
		PbsWechatUser user = findUserByOpenid(openid);
		PbsWechatUser user2 = new PbsWechatUser();
		user2.setId(user.getId());
		user2.setOpenid(openid);
		user2.setTel(tel);
		userMapper.updateByPrimaryKeySelective(user2);
	}
	
	public PbsBikeInfo findPbsBikeInfo(String bikeid) throws Exception {
		PbsBikeInfoExample pbsBikeInfoExample = new PbsBikeInfoExample();
		PbsBikeInfoExample.Criteria criteria = pbsBikeInfoExample.createCriteria();
		criteria.andBikeIdEqualTo(bikeid);
		List<PbsBikeInfo> list = bikeMapper.selectByExample(pbsBikeInfoExample);
		if(list != null&& list.size() ==1){
			return list.get(0);
		}
		return null;
	}
	
	public PbsRentInfo findPbsRentInfo(int rentid) throws Exception {
		PbsRentInfoExample pbsRentInfoExample = new PbsRentInfoExample();
		PbsRentInfoExample.Criteria criteria = pbsRentInfoExample.createCriteria();
		criteria.andRentIdEqualTo(rentid);
		List<PbsRentInfo> list = rentMapper.selectByExample(pbsRentInfoExample);
		if(list != null&& list.size() ==1){
			return list.get(0);
		}
		return null;
	}
	
	public PbsNodeInfo findPbsNodeInfo(int nodeid) throws Exception {
		PbsNodeInfoExample pbsNodeInfoExample = new PbsNodeInfoExample();
		PbsNodeInfoExample.Criteria criteria = pbsNodeInfoExample.createCriteria();
		criteria.andNodeIdEqualTo(nodeid);
		List<PbsNodeInfo> list = nodeMapper.selectByExample(pbsNodeInfoExample);
		if(list != null&& list.size() ==1){
			return list.get(0);
		}
		return null;
	}
	
	public void updateBikeInfo(String openid,String bikeid) throws Exception{
		//PbsWechatUser user = findUserByOpenid(openid);
		PbsBikeInfo bike = findPbsBikeInfo(bikeid);
		if(bike==null){
			System.out.println("自行车不存在");
			return;
		}
		int rentid = bike.getRentId();
		int nodeid = bike.getNodeId();
		if(rentid==0||nodeid==0){
			//异常
			System.out.println("自行车不在车桩");
			return;
		}
		PbsRentInfo rentInfo = findPbsRentInfo(rentid);
		PbsNodeInfo nodeInfo = findPbsNodeInfo(nodeid);
		if(rentInfo==null||nodeInfo==null){
			//异常
			System.out.println("站点车桩不存在");
			return;
		}
		//更新自行车表数据
		bike.setNodeId(0);
		bike.setRentId(0);
		bike.setDynamicState(3);//3表示借出
		bikeMapper.updateByPrimaryKey(bike);
		
		//更新站点和 车桩表的数据
		nodeInfo.setState(1);
		nodeInfo.setBikeId(null);
		nodeMapper.updateByPrimaryKey(nodeInfo);
		//更新站点可用车辆数
		int temp = rentInfo.getOperNum();
		if(temp > 0 ){
			rentInfo.setOperNum(temp-1);
			rentMapper.updateByPrimaryKey(rentInfo);
			createOrder(nodeid,rentid);
		}else{
			System.out.println("站点无车可借");
			return;
		}
	}
	
	public PbsWechatOrder findPbsWechatOrder(long orderid) throws Exception {
		PbsWechatOrderExample pbsWechatOrderExample = new PbsWechatOrderExample();
		PbsWechatOrderExample.Criteria criteria = pbsWechatOrderExample.createCriteria();
		criteria.andOrderIdEqualTo(orderid);
		List<PbsWechatOrder> list = orderMapper.selectByExample(pbsWechatOrderExample);
		if(list != null&& list.size() ==1){
			return list.get(0);
		}
		return null;
	}
	
	//检查订单id是否重复
	public long checkOrderid(long orderid) throws Exception{
		PbsWechatOrder order2 = findPbsWechatOrder(orderid);
		if(order2 != null){
			System.out.println("存在订单id");
			orderid = orderid+1;
			//递归查询
			checkOrderid(orderid);
		}
		return orderid;
	}

	public void createOrder(int startNode,int startRent)throws Exception {
		PbsWechatOrder order = new PbsWechatOrder();
		orderid = orderid + 1;
		long orderid1 = checkOrderid(orderid);
		order.setOrderId(orderid1);
		order.setOpenid(openid);
		order.setStartNode(startNode);
		order.setStartRent(startRent);
		SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		order.setStartTime(format.format(System.currentTimeMillis()));
		order.setState(order_state_process);
		orderMapper.insert(order);
	}
}
