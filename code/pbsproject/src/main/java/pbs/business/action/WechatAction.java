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
import pbs.base.process.result.DataGridResultInfo;
import pbs.base.process.result.OrderResult;
import pbs.base.service.OrderService;
import pbs.business.pojo.po.Locations;
import pbs.business.service.MapService;
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
	
	private static Logger logger = Logger.getLogger(WechatSignUtil.class);
	
	@RequestMapping("/jssdkconfig")
	public String jssdk(){
		return "/business/wechat/mine";
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
	
}
