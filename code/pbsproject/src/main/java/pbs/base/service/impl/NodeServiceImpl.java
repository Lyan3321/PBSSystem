package pbs.base.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pbs.base.dao.mapper.PbsNodeInfoMapper;
import pbs.base.dao.mapper.PbsNodeInfoMapperCustom;
import pbs.base.pojo.po.PbsNodeInfo;
import pbs.base.pojo.po.PbsNodeInfoExample;
import pbs.base.pojo.vo.PbsNodeInfoCustom;
import pbs.base.pojo.vo.PbsNodeInfoQueryVo;
import pbs.base.process.context.Config;
import pbs.base.process.result.ResultUtil;
import pbs.base.service.NodeService;

public class NodeServiceImpl implements NodeService{

	@Autowired
	private PbsNodeInfoMapperCustom pbsNodeInfoMapperCustom;
	
	@Autowired
	private PbsNodeInfoMapper pbsNodeInfoMapper;
	
	@Override
	public List<PbsNodeInfoCustom> findPbsNodeInfoList(
			PbsNodeInfoQueryVo pbsNodeInfoQueryVo) throws Exception {
		return pbsNodeInfoMapperCustom.findPbsNodeInfoList(pbsNodeInfoQueryVo);
	}

	@Override
	public int findPbsNodeInfoCount(PbsNodeInfoQueryVo pbsNodeInfoQueryVo)
			throws Exception {
		return pbsNodeInfoMapperCustom.findPbsNodeInfoCount(pbsNodeInfoQueryVo);
	}

	//添加站点信息
	@Override
	public void insertPbsNodeInfo(PbsNodeInfoCustom pbsNodeInfoCustom)
			throws Exception {
		//判断桩号和站点不能为空
		Integer zh = null;
		Integer zd = null;
		if(zh==null || zd==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 132, null));
		}

		PbsNodeInfo pbsNodeInfo = this.findPbsBikeInfoByXX(zh,zd);
		
		if(pbsNodeInfo!=null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 130, null));
		}
		
		pbsNodeInfoMapper.insert(pbsNodeInfoCustom);
		
	}
	
	public void deletPbsNodeInfo(Integer id) throws Exception{
		PbsNodeInfo pbsNodeInfo = pbsNodeInfoMapper.selectByPrimaryKey(id);
		if(pbsNodeInfo==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 133, null));
		}
		pbsNodeInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updatePbsNodeInfo(PbsNodeInfoCustom pbsNodeInfoCustom)
			throws Exception {

		PbsNodeInfo pbsNodeInfo = pbsNodeInfoMapper.selectByPrimaryKey(pbsNodeInfoCustom.getId());
		if(pbsNodeInfo==null){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 131, null));
		}
		
		BeanUtils.copyProperties(pbsNodeInfoCustom, pbsNodeInfo);
		
		pbsNodeInfoMapper.updateByPrimaryKey(pbsNodeInfo);
		
	}
	
	public PbsNodeInfo findPbsBikeInfoByXX(Integer zh,Integer zd){
		PbsNodeInfoExample pbsNodeInfoExample = new PbsNodeInfoExample();
		PbsNodeInfoExample.Criteria criteria = pbsNodeInfoExample.createCriteria();
		List<PbsNodeInfo> list = pbsNodeInfoMapper.selectByExample(pbsNodeInfoExample);
		if(list!=null){
			return list.get(0);
		}
		return null;
	}

}
