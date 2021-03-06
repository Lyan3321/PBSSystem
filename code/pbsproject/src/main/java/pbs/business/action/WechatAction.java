package pbs.business.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pbs.base.pojo.po.PbsOrderInfo;
import pbs.base.pojo.vo.GPSScope;
import pbs.base.pojo.vo.PageQuery;
import pbs.base.pojo.vo.PbsRentInfoCustom;
import pbs.base.pojo.vo.PbsRentInfoQueryVo;
import pbs.base.process.context.Config;
import pbs.base.process.result.DataGridResultInfo;
import pbs.base.process.result.OrderResult;
import pbs.base.process.result.ResultInfo;
import pbs.base.process.result.ResultUtil;
import pbs.base.process.result.SubmitResultInfo;
import pbs.base.service.OrderService;
import pbs.business.pojo.po.Locations;
import pbs.business.service.MapService;
import pbs.business.service.WechatService;
import pbs.util.ResourcesUtil;
import pbs.wechat.dispatcher.EventDispatcher;
import pbs.wechat.dispatcher.MsgDispatcher;
import pbs.wechat.util.HttpUtils;
import pbs.wechat.util.JSSDK_Config;
import pbs.wechat.util.Message;
import pbs.wechat.util.MessageUtil;
import pbs.wechat.util.WechatSignUtil;

@Controller
@RequestMapping("/wechat")
public class WechatAction {
	
	@Autowired
	private MapService mapService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private WechatService wechatService;
	
	private static Logger logger = Logger.getLogger(WechatSignUtil.class);
	
	@RequestMapping("/jssdkconfig")
	public String jssdk(){
		return "/business/wechat/mine";
	}
	
	@RequestMapping("wex5")
	public String wex5(){
		return "/business/wechat/map";
	}
	
	@RequestMapping("/wechatconfig")
	public @ResponseBody Message JSSDK_config(@RequestParam(value = "url",required = true) String url){
		try {
			System.out.println(url);
			Map<String,String> configMap = JSSDK_Config.jsSDK_Sign(url);
			return Message.success(configMap);
		} catch (Exception e) {
			return Message.error();
		}
	}

	@RequestMapping(value="/security",method= RequestMethod.GET)
	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="signature",required=true) String signature,
			@RequestParam(value="timestamp",required=true) String timestamp,
			@RequestParam(value="nonce",required=true) String nonce,
			@RequestParam(value="echostr",required=true) String echostr){
		try {
			if(WechatSignUtil.checkSignature(signature, timestamp, nonce)){
				PrintWriter out = response.getWriter();
				out.print(echostr);
				out.close();
			}else{
				logger.info("这里存在非法请求！");
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	@RequestMapping(value="security",method=RequestMethod.POST)
	public void DoPost(HttpServletRequest request,HttpServletResponse response){
		String respMessage = null;
		PrintWriter out = null; 
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
            Map<String, String> map=MessageUtil.parseXml(request);
            String msgtype=map.get("MsgType");
            if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)){
            	respMessage = EventDispatcher.processEvent(map); //进入事件处理
            }else{
            	respMessage = MsgDispatcher.processMessage(map); //进入消息处理
            }
            out = response.getWriter();
            out.print(respMessage);
        }catch(Exception e){
            logger.error(e,e);
        }
	}
	
	@RequestMapping("/riding")
	public String riding(Model model,
			@RequestParam(value="rent",required=true) String rent,
			@RequestParam(value="node",required=true) String node){
		model.addAttribute("rent", rent);
		model.addAttribute("node", node);
		return "/business/wechat/riding";
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
	
	@RequestMapping("/convert")
	public @ResponseBody Locations convert(
			@RequestParam(value="lat",required=true) String lat,
			@RequestParam(value="lng",required=true) String lng)throws Exception{
		Locations lo = mapService.convertLocations(lat, lng);
		return lo;
	}
	
	//预约跳转
	@RequestMapping("/yuyue")
	public String yuyue()throws Exception{
		
		return "/business/wechat/yuyue";
	}
	
	//订单跳转
	@RequestMapping("/myorder")
	public String myorder()throws Exception{
		return "/business/wechat/myorder";
	}
	
	//加载订单数据
	@RequestMapping("/queryorder_result")
	public @ResponseBody OrderResult queryOrder_result(
			@RequestParam(value="openid",required=true) String openid)throws Exception{
		List<PbsOrderInfo> list = orderService.findPbsOrderInfoByOpenid(openid);
		//System.out.println(list);
		OrderResult orderResult = new OrderResult();
		orderResult.setRows(list);
		return orderResult;
	}
	
	@RequestMapping("/querymap_result_gps")
	public @ResponseBody DataGridResultInfo queryMap_result_gps(
			PbsRentInfoQueryVo pbsRentInfoQueryVo,
			Double lng,
			Double lat
			)throws Exception{

		//非空校验
		pbsRentInfoQueryVo = pbsRentInfoQueryVo!=null?pbsRentInfoQueryVo:new PbsRentInfoQueryVo();
		
		//获取定位精度
		String para = ResourcesUtil.getValue("wechat", "gpsscope");
		Double para_scope = Double.valueOf(para);
		//获取定位范围
		GPSScope gpsScope = new GPSScope();
		gpsScope.setLat(lat);
		gpsScope.setLng(lng);
		gpsScope.setLat_high(lat+para_scope);
		gpsScope.setLat_low(lat-para_scope);
		gpsScope.setLng_high(lng+para_scope);
		gpsScope.setLng_low(lng-para_scope);
		
		pbsRentInfoQueryVo.setGpsScope(gpsScope);
		//获取站点信息list
		List<PbsRentInfoCustom> list = mapService.findPbsRentInfoByGPS(pbsRentInfoQueryVo);
		
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
	
	//网页授权，得到用户的openid
	@RequestMapping("/authorize")
	public String authorize(
			HttpServletRequest request,
			@RequestParam(value="code",required=true) String code)throws Exception{
		Map<String,String> params = new HashMap<String,String>();
		params.put("appid", ResourcesUtil.getValue("wechat", "appid"));
		params.put("secret", ResourcesUtil.getValue("wechat", "AppSecret"));
		params.put("code", code);
		params.put("grant_type", "authorization_code");
		String message = HttpUtils.sendGet(ResourcesUtil.getValue("interface_url", "getOpenid"), params);
		System.out.println(message);
		String openid = JSONObject.fromObject(message).getString("openid");
		HttpSession session = request.getSession();
		session.setAttribute("openid", openid);
		return "/business/wechat/wechatfirst";
	}
	
	//跳转菜单
	@RequestMapping("/home")
	public String home(){
		return "/business/wechat/home";
	}
	
	//退出登录
	@RequestMapping("/logout")
	public String logout(){
		return "/business/wechat/login";
	}
	
	//扫描二维码的结果
	@RequestMapping("/scanner")
	public @ResponseBody String scanner(HttpSession session,String bikeId) throws Exception{
		
		//测试Exception
		//ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 131, null));
		
		System.out.println(bikeId);
		//session.setAttribute("bikeid", bikeId);
		String openid = (String) session.getAttribute("openid");
		System.out.println(openid);
		int temp = wechatService.checkOpenid(openid);
		if(temp == 0){//0为未注册
			return String.valueOf(temp);
			//return ResultUtil.createSubmitResult(ResultUtil.createFail(Config.MESSAGE, 134, null));
		}else{
			wechatService.updateBikeInfo(openid, bikeId);
			//return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 135, null));
			return "1";
		}
	}
	
	//注册界面
	@RequestMapping("/register")
	public String register()throws Exception{
		//ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 131, null));
		return "/business/wechat/register";
	}
	
	//注册结果反馈
	@RequestMapping("/register_result")
	public @ResponseBody SubmitResultInfo register_result(String tel) throws Exception{
		wechatService.register(tel);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
	}
	
	//结束骑行，自行车入桩
	@RequestMapping("/riding_complete")
	public @ResponseBody String ridingComplete(HttpSession session,String bikeid,String nodeid)throws Exception{
		//不在一个session中
		//session.setAttribute("bikeid", bikeid);
		//session.setAttribute("nodeid", nodeid);
		Config.bikeid=bikeid;
		Config.nodeid=nodeid;
		return "success";
	}
	
	//微信端确认
	@RequestMapping("/order_confirm")
	public @ResponseBody SubmitResultInfo orderConfirm(HttpSession session)throws Exception{
		if(Config.bikeid==null||Config.nodeid==null){
			System.out.println("车未入桩");
			return null;
		}
//		if(bikeid==null||bikeid==""||nodeid==null||nodeid==""){
//			System.out.println("异常");
//			return null;
//		}
		wechatService.completeOrder(Config.bikeid, Integer.valueOf(Config.nodeid));
		Config.bikeid=null;
		Config.nodeid=null;
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
	}
}
