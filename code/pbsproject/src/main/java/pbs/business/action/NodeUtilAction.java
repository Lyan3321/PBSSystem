package pbs.business.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wechat")
public class NodeUtilAction {

	@RequestMapping("/util")
	public String util()throws Exception{
		return "/business/wechat/nodeutil";
	}
	
	@RequestMapping("/nodeutil")
	public void nodeutil(String nodeid,String rentid,String bikeid)throws Exception{
		System.out.println(nodeid+"-"+rentid+"-"+bikeid);
	}
}
