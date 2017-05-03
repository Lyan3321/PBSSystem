package pbs.business.service;

import java.util.List;

import pbs.business.pojo.po.PbsWechatUser;

public interface WechatService {

	public PbsWechatUser findUserByOpenid(String openid)throws Exception;
	
	public int checkOpenid(String openid)throws Exception;
	
	public void register(String tel)throws Exception;
	
	public void updateBikeInfo(String openid,String bikeid)throws Exception;
}
