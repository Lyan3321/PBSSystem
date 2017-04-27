<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK rel="stylesheet" type="text/css" href="${baseurl}js/easyui/styles/default.css">
<%@ include file="/WEB-INF/jsp/base/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/base/common_js.jsp"%>
<title>添加自行车</title>
<script type="text/javascript">
  function sysusersave(){
	  jquerySubByFId('bikeform',bikesave_callback,null,"json");
	  
  }
  //ajax调用的回调函数，ajax请求完成调用此函数，传入的参数是action返回的结果
  function bikesave_callback(data){
	  
	  message_alert(data);
	 
	  
  }
 
</script>
</head>
<body>


<form id="bikeform" action="${baseurl}bike/editbikesubmit.action" method="post">
<input type="hidden" name="bikeId" value="${pbsBikeInfo.bikeId}"/>
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" bgColor=#c4d8ed>

   <TBODY>
   <TR>
				<TD background=images/r_0.gif width="100%">
					<TABLE cellSpacing=0 cellPadding=0 width="100%">
						<TBODY>
							<TR>
								<TD>&nbsp;自行车信息</TD>
								<TD align=right>&nbsp;</TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
			</TR>
			
			<TR>
				<TD>
					<TABLE class="toptable grid" border=1 cellSpacing=1 cellPadding=4
						align=center>
						<TBODY>
							
							<TR>
								<TD height=30 width="15%" align=right >自行车编码：</TD>
								<TD class=category width="35%">
								<div>
								<input type="text" id="bike_bikeId" name="pbsBikeInfoCustom.bikeId" value="${pbsBikeInfo.bikeId }" readonly/>
								</div>
								<!-- sysuser_useridTip用于显示提示信息，提示div的id等于校验input的id+Tip -->
								<div id="sysuser_useridTip"></div>
								</TD>
								<TD height=30 width="15%" align=right >日期：</TD>
								<TD class=category width="35%">
								<div>
								<input type="date" id="bike_proDate" name="pbsBikeInfoCustom.proDate" value="${pbsBikeInfo.proDate }" />
								</div>
								<div id="sysuser_usernameTip"></div>
								</TD>
							</TR>
							<TR>
								<TD height=30 width="15%" align=right >厂家：</TD>
								<TD class=category width="35%">
								<div>
									<input type="text" id="bike_factory" name="pbsBikeInfoCustom.factory" value="${pbsBikeInfo.factory }"/>
								</div>
								<div id="sysuser_passwordTip"></div>
								</TD>
								<TD height=30 width="15%" align=right >状态：</TD>
								<TD class=category width="35%">
								<div>
								<select name="pbsBikeInfoCustom.state" id="bike_state">
										<option value="">请选择</option>
										<option value="1">入库</option>
										<option value="2">在用</option>
										<option value="3">故障</option>
										<option value="4">丢失</option>
										<option value="5">报废</option>
				
								</select>
								</div>
								<div id="sysuser_groupidTip"></div>
								</TD>
								
								
							</TR>
							<tr>
							  <td colspan=4 align=center class=category>
								<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="sysusersave()">提交</a>
								<a id="closebtn"  class="easyui-linkbutton" iconCls="icon-cancel" href="#" onclick="parent.closemodalwindow()">关闭</a>
							  </td>
							</tr>
						
							</TBODY>
						</TABLE>
					</TD>
				</TR>
   </TBODY>
</TABLE>
</form>
</body>
</html>