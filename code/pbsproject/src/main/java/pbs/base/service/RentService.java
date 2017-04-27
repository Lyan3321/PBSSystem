package pbs.base.service;

import java.util.List;

import pbs.base.pojo.vo.PbsRentInfoCustom;
import pbs.base.pojo.vo.PbsRentInfoQueryVo;

public interface RentService {

	public List<PbsRentInfoCustom> findPbsRentInfoList (PbsRentInfoQueryVo pbsRentInfoQueryVo)throws Exception;
	
	public int findPbsRentInfoCount(PbsRentInfoQueryVo pbsRentInfoQueryVo) throws Exception;
	
	//插入站点信息
	public void insertPbsRentInfo(PbsRentInfoCustom pbsRentInfoCustom) throws Exception;
	
	//删除站点信息
	public void deletPbsRentInfo(Integer id) throws Exception;
	
	//修改站点信息
	public void updatePbsRentInfo(PbsRentInfoCustom pbsRentInfoCustom) throws Exception;
	
	
}
