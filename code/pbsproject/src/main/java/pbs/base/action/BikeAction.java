package pbs.base.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pbs.base.pojo.po.PbsBikeInfo;
import pbs.base.pojo.vo.PageQuery;
import pbs.base.pojo.vo.PbsBikeInfoCustom;
import pbs.base.pojo.vo.PbsBikeInfoQueryVo;
import pbs.base.process.context.Config;
import pbs.base.process.result.DataGridResultInfo;
import pbs.base.process.result.ResultInfo;
import pbs.base.process.result.ResultUtil;
import pbs.base.process.result.SubmitResultInfo;
import pbs.base.service.BikeService;

@Controller
@RequestMapping("/bike")
public class BikeAction {
	
	@Autowired
	private BikeService bikeService;
	

	@RequestMapping("/querybike")
	public String queryBike(Model model)throws Exception{
		return "/base/bike/querybike";
	}
	
	@RequestMapping("/querybike_result")
	public @ResponseBody DataGridResultInfo queryBike_result(
			PbsBikeInfoQueryVo pbsBikeInfoQueryVo,
			int page,//页码
			int rows//每页显示个数
			)throws Exception{

		//非空校验
		pbsBikeInfoQueryVo = pbsBikeInfoQueryVo!=null?pbsBikeInfoQueryVo:new PbsBikeInfoQueryVo();
		int total = bikeService.findPbsBikeInfoCount(pbsBikeInfoQueryVo);
		
		PageQuery pageQuery = new PageQuery();
		pageQuery.handle(page,rows);
		pbsBikeInfoQueryVo.setPageQuery(pageQuery);
		List<PbsBikeInfoCustom> list = bikeService.findPbsBikeInfoList(pbsBikeInfoQueryVo);
		
		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		
		dataGridResultInfo.setTotal(total);
		dataGridResultInfo.setRows(list);
		return dataGridResultInfo;
	}
	
	//添加用户页面
	@RequestMapping("/addbike")
	public String addBike(Model model)throws Exception{
		
		return "/base/bike/addbike";
	}
	
	//添加用户提交
	@RequestMapping("/addbikesubmit")
	public @ResponseBody SubmitResultInfo addBikeSubmit(PbsBikeInfoQueryVo pbsBikeInfoQueryVo)throws Exception{
		
//		String message = "操作成功!!";
//		int type=0;//成功
		
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setType(ResultInfo.TYPE_RESULT_SUCCESS);
		resultInfo.setMessage("操作成功");
		/*try {
			bikeService.insertPbsBikeInfo(pbsBikeInfoQueryVo.getPbsBikeInfoCustom());
		} catch (Exception e) {
			e.printStackTrace();
//			message = e.getMessage();
//			type=1;//失败
			if(e instanceof ExceptionResultInfo){
				resultInfo = ((ExceptionResultInfo)e).getResultInfo();
			}else{
				//从新构造"未知错误"异常
				resultInfo = new ResultInfo();
				resultInfo.setMessage("未知错误");
				resultInfo.setType(ResultInfo.TYPE_RESULT_FAIL);
			}
		}*/
		bikeService.insertPbsBikeInfo(pbsBikeInfoQueryVo.getPbsBikeInfoCustom());
//		Map<String, Object> result_map = new HashMap<String, Object>();
//		result_map.put("type", type);
//		result_map.put("message", message);
		SubmitResultInfo submitResultInfo = new SubmitResultInfo(resultInfo);
		return submitResultInfo;
	}
	
	@RequestMapping("/deletebike")
	public @ResponseBody SubmitResultInfo deletePbsBikeInfo(String bikeId) throws Exception{
		bikeService.deletPbsBikeInfo(bikeId);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
	}
	
	@RequestMapping("/editbike")
	public String editPbsBikeInfo(Model model,String bikeId)throws Exception{
		
		PbsBikeInfo pbsBikeInfo = bikeService.findPbsBikeInfoByBikebm(bikeId);
		model.addAttribute("pbsBikeInfo", pbsBikeInfo);
		
		return "/base/bike/editbike";
	}
	
	@RequestMapping("/editbikesubmit")
	public @ResponseBody SubmitResultInfo editPbsBikeInfoSubmit(PbsBikeInfoQueryVo pbsBikeInfoQueryVo)throws Exception{
		
		bikeService.updatePbsBikeInfo(pbsBikeInfoQueryVo.getPbsBikeInfoCustom());
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
	}
}
