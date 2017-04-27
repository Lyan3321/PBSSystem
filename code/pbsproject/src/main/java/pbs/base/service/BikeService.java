package pbs.base.service;

import java.util.List;

import pbs.base.pojo.po.PbsBikeInfo;
import pbs.base.pojo.vo.PbsBikeInfoCustom;
import pbs.base.pojo.vo.PbsBikeInfoQueryVo;

public interface BikeService {

	public List<PbsBikeInfoCustom> findPbsBikeInfoList(PbsBikeInfoQueryVo pbsBikeInfoQueryVo) throws Exception;
	
	public int findPbsBikeInfoCount(PbsBikeInfoQueryVo pbsBikeInfoQueryVo) throws Exception;
	
	public PbsBikeInfo findPbsBikeInfoByBikebm(String bikeId) throws Exception;
	
	public void insertPbsBikeInfo(PbsBikeInfoCustom pbsBikeInfoCustom) throws Exception;
	
	//删除用户
	public void deletPbsBikeInfo(String bikeId) throws Exception;
	
	//修改用户
	public void updatePbsBikeInfo(PbsBikeInfoCustom pbsBikeInfoCustom) throws Exception;
}
