package pbs.base.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pbs.base.dao.mapper.PbsRentInfoMapper;
import pbs.base.dao.mapper.PbsRentInfoMapperCustom;
import pbs.base.pojo.po.PbsRentInfo;
import pbs.base.pojo.vo.PbsRentInfoCustom;
import pbs.base.pojo.vo.PbsRentInfoQueryVo;
import pbs.base.process.context.Config;
import pbs.base.process.result.ResultUtil;
import pbs.base.service.RentService;

public class RentServiceImpl implements RentService{

	@Autowired
	private PbsRentInfoMapperCustom pbsRentInfoMapperCustom;
	
	@Autowired
	private PbsRentInfoMapper pbsRentInfoMapper;
	
	@Override
	public List<PbsRentInfoCustom> findPbsRentInfoList(
			PbsRentInfoQueryVo pbsRentInfoQueryVo) throws Exception {
		return pbsRentInfoMapperCustom.findPbsRentInfoList(pbsRentInfoQueryVo);
	}

	@Override
	public int findPbsRentInfoCount(PbsRentInfoQueryVo pbsRentInfoQueryVo)
			throws Exception {
		return pbsRentInfoMapperCustom.findPbsRentInfoCount(pbsRentInfoQueryVo);
	}

	@Override
	public void insertPbsRentInfo(PbsRentInfoCustom pbsRentInfoCustom)
			throws Exception {

		PbsRentInfo pbsRentInfo = pbsRentInfoMapper.selectByPrimaryKey(pbsRentInfoCustom.getId());
		
		if(pbsRentInfo!=null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 130, null));
		}
		
		pbsRentInfoMapper.insert(pbsRentInfoCustom);
		
	}
	
	public void deletPbsRentInfo(Integer id) throws Exception{
		PbsRentInfo pbsRentInfo = pbsRentInfoMapper.selectByPrimaryKey(id);
		if(pbsRentInfo==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 131, null));
		}
		pbsRentInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updatePbsRentInfo(PbsRentInfoCustom pbsRentInfoCustom)
			throws Exception {

		PbsRentInfo pbsRentInfo = pbsRentInfoMapper.selectByPrimaryKey(pbsRentInfoCustom.getId());
		if(pbsRentInfo==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 131, null));
		}
		
		BeanUtils.copyProperties(pbsRentInfoCustom, pbsRentInfo);
		
		pbsRentInfoMapper.updateByPrimaryKey(pbsRentInfo);
		
	}

	

}
