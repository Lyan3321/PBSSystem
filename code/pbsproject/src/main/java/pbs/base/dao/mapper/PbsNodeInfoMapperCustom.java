package pbs.base.dao.mapper;

import java.util.List;

import pbs.base.pojo.vo.PbsNodeInfoCustom;
import pbs.base.pojo.vo.PbsNodeInfoQueryVo;

public interface PbsNodeInfoMapperCustom {

	public List<PbsNodeInfoCustom> findPbsNodeInfoList(PbsNodeInfoQueryVo pbsNodeInfoQueryVo) throws Exception;
	
	public int findPbsNodeInfoCount(PbsNodeInfoQueryVo pbsNodeInfoQueryVo) throws Exception;
	
	public List<PbsNodeInfoCustom> findBikeInfoByRentId(PbsNodeInfoQueryVo pbsNodeInfoQueryVo) throws Exception;
}