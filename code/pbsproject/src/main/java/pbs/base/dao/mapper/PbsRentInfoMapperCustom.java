package pbs.base.dao.mapper;

import java.util.List;

import pbs.base.pojo.vo.PbsRentInfoCustom;
import pbs.base.pojo.vo.PbsRentInfoQueryVo;

public interface PbsRentInfoMapperCustom {

	public List<PbsRentInfoCustom> findPbsRentInfoList(PbsRentInfoQueryVo pbsRentInfoQueryVo) throws Exception;
	
	public int findPbsRentInfoCount(PbsRentInfoQueryVo pbsRentInfoQueryVo) throws Exception;
	
	public List<PbsRentInfoCustom> findPbsRentInfoByGPS(PbsRentInfoQueryVo pbsRentInfoQueryVo) throws Exception;
}