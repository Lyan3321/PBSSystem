package pbs.wechat.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pbs.base.dao.mapper.PbsBikeInfoMapper;
import pbs.base.dao.mapper.PbsNodeInfoMapper;
import pbs.base.dao.mapper.PbsNodeInfoMapperCustom;
import pbs.base.dao.mapper.PbsRentInfoMapper;
import pbs.base.dao.mapper.PbsRentInfoMapperCustom;
import pbs.base.pojo.po.PbsNodeInfo;
import pbs.base.pojo.vo.PageQuery;
import pbs.base.pojo.vo.PbsBikeInfoCustom;
import pbs.base.pojo.vo.PbsNodeInfoCustom;
import pbs.base.pojo.vo.PbsNodeInfoQueryVo;
import pbs.base.pojo.vo.PbsRentInfoCustom;
import pbs.base.pojo.vo.PbsRentInfoQueryVo;

public class DBTools {
	
	public static ApplicationContext applicationContext;
	
	public static void main(String[] args) throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(new String[] {
				"spring/applicationContext.xml", "spring/applicationContext-base-dao.xml"
		});
		//getNodeInfo();
		//getBikeNum();
		setBikeInfo();
	}
	
	public static void setBikeInfo()throws Exception{
		PbsNodeInfoQueryVo pbsNodeInfoQueryVo = new PbsNodeInfoQueryVo();
		PbsNodeInfoMapperCustom pbsNodeInfoMapperCustom = (PbsNodeInfoMapperCustom) applicationContext
				.getBean("pbsNodeInfoMapperCustom");
		PbsBikeInfoMapper pbsBikeInfoMapper = (PbsBikeInfoMapper) applicationContext
				.getBean("pbsBikeInfoMapper");
		List<PbsNodeInfoCustom> list = pbsNodeInfoMapperCustom.findBikeInfoByRentId(pbsNodeInfoQueryVo);
		System.out.println(list.get(0).getBikeId());
		for(PbsNodeInfoCustom node:list){
			//System.out.println("--------------------");
			if(node.getBikeId()!=null&&node.getBikeId()!=""){
			PbsBikeInfoCustom bike = new PbsBikeInfoCustom();
			bike.setBikeId(node.getBikeId());
			bike.setFactory("建诚");
			bike.setNodeId(node.getNodeId());
			bike.setRentId(node.getRentId());
			bike.setProDate("2017-04-28");
			bike.setState(2);
			bike.setDynamicState(2);
			pbsBikeInfoMapper.insertSelective(bike);
			}
		}
	}
	
	
	/*public static void getBikeNum()throws Exception{
		PbsNodeInfoQueryVo pbsNodeInfoQueryVo = new PbsNodeInfoQueryVo();
		PbsNodeInfoCustom pbsNodeInfoCustom = new PbsNodeInfoCustom();
		PbsRentInfoQueryVo pbsRentInfoQueryVo = new PbsRentInfoQueryVo();
		PbsRentInfoCustom pbsRentInfoCustom = new PbsRentInfoCustom();
		
		PbsRentInfoMapperCustom pbsRentInfoMapperCustom = (PbsRentInfoMapperCustom) applicationContext
				.getBean("pbsRentInfoMapperCustom");
		PbsNodeInfoMapperCustom pbsNodeInfoMapperCustom = (PbsNodeInfoMapperCustom) applicationContext
				.getBean("pbsNodeInfoMapperCustom");
		PbsRentInfoMapper pbsRentInfoMapper = (PbsRentInfoMapper) applicationContext
				.getBean("pbsRentInfoMapper");
		PbsNodeInfoMapper pbsNodeInfoMapper = (PbsNodeInfoMapper) applicationContext
				.getBean("pbsNodeInfoMapper");
		
		for(int i = 3458;i<3463;i++){
			pbsNodeInfoCustom.setRentId(i);
			pbsNodeInfoQueryVo.setPbsNodeInfoCustom(pbsNodeInfoCustom);
			int countBike = pbsNodeInfoMapperCustom.findBikeCountByRentId(pbsNodeInfoQueryVo);
			pbsRentInfoCustom.setRentId(i);
			pbsRentInfoQueryVo.setPbsRentInfoCustom(pbsRentInfoCustom);
			List<PbsRentInfoCustom> list = pbsRentInfoMapperCustom.findPbsRentInfoByRentId(pbsRentInfoQueryVo);
			PbsRentInfoCustom rent = list.get(0);
			rent.setOperNum(countBike);
			pbsRentInfoMapper.updateByPrimaryKeySelective(rent);
		}
		
	}

	public static void getNodeInfo() throws Exception{
		PbsRentInfoQueryVo pbsRentInfoQueryVo = new PbsRentInfoQueryVo();
		PageQuery pageQuery = new PageQuery();
		pageQuery.setStart(0);
		pageQuery.setRows(2360);
		pbsRentInfoQueryVo.setPageQuery(pageQuery);
		
		PbsRentInfoMapperCustom pbsRentInfoMapperCustom = (PbsRentInfoMapperCustom) applicationContext
				.getBean("pbsRentInfoMapperCustom");
		PbsNodeInfoMapperCustom pbsNodeInfoMapperCustom = (PbsNodeInfoMapperCustom) applicationContext
				.getBean("pbsNodeInfoMapperCustom");
		PbsNodeInfoMapper pbsNodeInfoMapper = (PbsNodeInfoMapper) applicationContext
				.getBean("pbsNodeInfoMapper");
		List<PbsRentInfoCustom> list = pbsRentInfoMapperCustom.findPbsRentInfoList(pbsRentInfoQueryVo);
		PbsNodeInfoQueryVo pbsNodeInfoQueryVo = new PbsNodeInfoQueryVo();
		PbsNodeInfoCustom pbsNodeInfoCustom = new PbsNodeInfoCustom();
//		int count = pbsNodeInfoMapperCustom.findPbsNodeInfoCountByRentId(pbsNodeInfoQueryVo);
//		System.out.println(count);
		for(PbsRentInfoCustom rent:list){
			int rentId = rent.getRentId();
			int maxNum = rent.getMaxNumber();
			pbsNodeInfoCustom.setRentId(rentId);
			pbsNodeInfoQueryVo.setPbsNodeInfoCustom(pbsNodeInfoCustom);
			int count = pbsNodeInfoMapperCustom.findPbsNodeInfoCountByRentId(pbsNodeInfoQueryVo);
			if(count<maxNum){
				int temp = maxNum - count;
				for(int i = 0;i<temp;i++){
					PbsNodeInfo node = new PbsNodeInfo();
					node.setNodeId((int)(System.currentTimeMillis()/1000)+(int)(Math.random()*100000000));
					node.setRentId(rentId);
					if(i%2==1){
						node.setState(1);
						pbsNodeInfoMapper.insert(node);
					}else{
					node.setState(2);
					node.setBikeId(String.valueOf((int)(Math.random()*100000000)));
					pbsNodeInfoMapper.insert(node);
					}
				}
			}
		}
	}*/
}
