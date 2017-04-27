package pbs.business.service;

import java.util.List;

import pbs.base.pojo.po.PbsRentInfo;
import pbs.base.pojo.vo.PbsRentInfoCustom;
import pbs.base.pojo.vo.PbsRentInfoQueryVo;
import pbs.business.pojo.po.Locations;

public interface MapService {
	//查询站点信息，返回list集合
	public List<PbsRentInfoCustom> findPbsRentInfoList(PbsRentInfoQueryVo pbsRentInfoQueryVo) 
					throws Exception;
	
	public int findPbsRentInfoCount(PbsRentInfoQueryVo pbsRentInfoQueryVo) throws Exception;
	
	public PbsRentInfo findPbsRentInfoById(int id) throws Exception;
	
	//将gps坐标转换为高德地图坐标
	public Locations convertLocations(String lat,String lng) throws Exception;
	
	//根据定位查询站点
	public List<PbsRentInfoCustom> findPbsRentInfoByGPS (PbsRentInfoQueryVo pbsRentInfoQueryVo)throws Exception;
}
