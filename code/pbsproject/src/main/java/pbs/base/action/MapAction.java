package pbs.base.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pbs.base.pojo.po.PbsBikeInfo;
import pbs.base.pojo.vo.PageQuery;
import pbs.base.pojo.vo.PbsBikeInfoCustom;
import pbs.base.pojo.vo.PbsBikeInfoQueryVo;
import pbs.base.pojo.vo.PbsRentInfoCustom;
import pbs.base.pojo.vo.PbsRentInfoQueryVo;
import pbs.base.process.context.Config;
import pbs.base.process.result.DataGridResultInfo;
import pbs.base.process.result.ResultInfo;
import pbs.base.process.result.ResultUtil;
import pbs.base.process.result.SubmitResultInfo;
import pbs.base.service.BikeService;
import pbs.business.service.MapService;

@Controller
@RequestMapping("/map")
public class MapAction {
	
	@Autowired
	private MapService mapService;
	
	int start = 0;

	
	@RequestMapping("/querymap")
	public String queryMap(Model model)throws Exception{
		return "/base/map/querymap";
	}
	
	@RequestMapping("/querymap_result")
	public @ResponseBody DataGridResultInfo queryMap_result(
			PbsRentInfoQueryVo pbsRentInfoQueryVo
			)throws Exception{

		//非空校验
		pbsRentInfoQueryVo = pbsRentInfoQueryVo!=null?pbsRentInfoQueryVo:new PbsRentInfoQueryVo();
		
		//获取查询记录总条数
		int total = mapService.findPbsRentInfoCount(pbsRentInfoQueryVo);
		
		PageQuery pageQuery = new PageQuery();
		pageQuery.setStart(0);
		pageQuery.setRows(total);
		pbsRentInfoQueryVo.setPageQuery(pageQuery);
		//获取站点信息list
		List<PbsRentInfoCustom> list = mapService.findPbsRentInfoList(pbsRentInfoQueryVo);
		
		//新建DataGridResultInfo数据存储查询信息
		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		
		//设置总条数进入dataGridResultInfo
		dataGridResultInfo.setTotal(list.size());
		
		//设置结果集进入Row
		dataGridResultInfo.setRows(list);
		
		//System.out.println(dataGridResultInfo.getTotal());
		//返回
		return dataGridResultInfo;
	}
}
