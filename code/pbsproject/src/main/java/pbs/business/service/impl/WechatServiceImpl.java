package pbs.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pbs.business.dao.mapper.PbsWechatUserMapper;
import pbs.business.pojo.po.PbsWechatUser;
import pbs.business.pojo.po.PbsWechatUserExample;
import pbs.business.service.WechatService;

public class WechatServiceImpl implements WechatService{

	@Autowired
	private PbsWechatUserMapper userMapper;
	
	private String openid;
	
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
}
