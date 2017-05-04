package pbs.business.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	//订单状态
	public static final int order_state_sucess = 1;
	public static final int order_state_fail = 2;
	public static final int order_state_process = 3;
	//自行车动态
	public static final int bike_dynamic_rent = 1;
	public static final int bike_dynamic_node = 2;
	public static final int bike_dynamic_out = 3;
	public static final int bike_dynamic_dispathc = 4;
	public static final int bike_dynamic_mend = 5;
	//车桩状态
	public static final int node_state_free = 1;
	public static final int node_state_used = 2;
	public static final int node_state_broken = 3;
	
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
		if(list != null){
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 完成了几张表的更新，但是需要有车桩数据接口
	 */
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
		bike.setDynamicState(bike_dynamic_out);//3表示借出
		bikeMapper.updateByPrimaryKey(bike);
		
		//更新站点和 车桩表的数据
		nodeInfo.setState(node_state_free);
		nodeInfo.setBikeId(null);
		nodeMapper.updateByPrimaryKey(nodeInfo);
		//更新站点可用车辆数
		int temp = rentInfo.getOperNum();
		if(temp > 0 ){
			rentInfo.setOperNum(temp-1);
			rentMapper.updateByPrimaryKey(rentInfo);
			createOrder(bikeid,nodeid,rentid);
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

	
	/**
	 * 创建订单
	 * @param startNode，开始车桩id
	 * @param startRent，开始站点id
	 * @throws Exception
	 */
	public void createOrder(String bikeId,int startNode,int startRent)throws Exception {
		PbsWechatOrder order = new PbsWechatOrder();
		orderid = checkOrderid(orderid+1);
		order.setOrderId(orderid);
		order.setOpenid(openid);
		order.setBikeId(bikeId);
		order.setStartNode(startNode);
		order.setStartRent(startRent);
		SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		order.setStartTime(format.format(System.currentTimeMillis()));
		order.setState(order_state_process);
		orderMapper.insert(order);
	}
	
	/**
	 * 完成骑行，更新订单
	 * @throws Exception
	 */
	public void completeOrder(String bikeid,int nodeid)throws Exception{
		PbsBikeInfo bike_back = findPbsBikeInfo(bikeid);
		PbsNodeInfo node_back = findPbsNodeInfo(nodeid);
		int rentid = node_back.getRentId();
		PbsRentInfo rent_back = findPbsRentInfo(rentid);
		//有问题。。。。。。订单查询
		PbsWechatOrder order_back = findPbsWechatOrder(orderid);
		if(bike_back==null||node_back==null||rent_back==null||order_back==null){
			System.out.println("异常");
			return;
		}
		
		//更新自行车状态
		bike_back.setDynamicState(bike_dynamic_node);
		bike_back.setRentId(rentid);
		bike_back.setNodeId(nodeid);
		bikeMapper.updateByPrimaryKey(bike_back);
		
		//更新车桩信息
		node_back.setBikeId(bikeid);
		node_back.setState(node_state_used);
		nodeMapper.updateByPrimaryKey(node_back);
		
		//更新站点信息
		rent_back.setOperNum(rent_back.getOperNum()+1);
		rentMapper.updateByPrimaryKey(rent_back);
		
		//更新订单
		order_back.setEndNode(node_back.getNodeId());
		order_back.setEndRent(rent_back.getRentId());
		String start_time = order_back.getStartTime();
		SimpleDateFormat format1 =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		Date date = format1.parse(start_time);
		long start_time1 = date.getTime();
		long end_time1 = System.currentTimeMillis();
		String end_time = format1.format(end_time1);
		order_back.setEndTime(end_time);
		//得到骑行时间，以秒为单位存入数据库
		int total_time = (int) ((end_time1-start_time1)/1000);
		order_back.setTotalTime(total_time);
		order_back.setState(order_state_sucess);
		orderMapper.updateByPrimaryKey(order_back);
	}
}
