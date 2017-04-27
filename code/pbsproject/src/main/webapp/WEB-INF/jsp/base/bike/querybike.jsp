<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引用jquery easy ui的js库及css -->
<LINK rel="stylesheet" type="text/css"
	href="${baseurl}js/easyui/styles/default.css">
<%@ include file="/WEB-INF/jsp/base/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/base/common_js.jsp"%>
<title>自行车管理</title>

<script type="text/javascript">
	//datagrid列定义
	var columns_v = [ [ {
		field : 'bikeId',//对应json中的key
		title : '编号',
		width : 250
	}, {
		field : 'proDate',//对应json中的key
		title : '日期 ',
		width : 120
	}, {
		field : 'factory',//对应json中的key
		title : '厂家',
		width : 120,
	}, {
		title : '状态',
		field : 'state',//对应json中的key
		width : 120,
		formatter : function(value, row, index) {//通过此方法格式化显示内容,value表示从json中取出该单元格的值，row表示这一行的数据，是一个对象,index:行的序号
			if(value =='1'){
				return "入库";
			}else if(value =='2'){
				return "在用";
			}else if(value =='3'){
				return "故障";
			}else if(value =='4'){
				return "丢失";
			}else if(value =='5'){
				return "报废";
			}
		}
	},{
		field : 'dynamicState',//对应json中的key
		title : '动态',
		width : 120,
		formatter : function(value, row, index) {//通过此方法格式化显示内容,value表示从json中取出该单元格的值，row表示这一行的数据，是一个对象,index:行的序号
			if(value =='1'){
				return "在站";
			}else if(value =='2'){
				return "在桩";
			}else if(value =='3'){
				return "借出";
			}else if(value =='4'){
				return "调度中";
			}else if(value =='5'){
				return "维护保养中";
			}
		}
	},{
		field : 'rentId',//对应json中的key
		title : '站点',
		width : 120
	},{
		field : 'nodeId',//对应json中的key
		title : '车桩',
		width : 120
	},{
		field : 'opt1',//对应json中的key
		title : '删除',
		width : 120,
		formatter : function(value, row, index){
			return "<a href=javascript:deletebike('"+row.bikeId+"')>删除</a>"
		}
	},{
		field : 'opt2',//对应json中的key
		title : '修改',
		width : 120,
		formatter : function(value, row, index){
			return "<a href=javascript:editbike('"+row.bikeId+"')>修改</a>"
		}
	}] ];

	//定义 datagird工具
	var toolbar_v = [ {//工具栏
		id : 'btnadd',
		text : '添加',
		iconCls : 'icon-add',
		handler : function() {
			//打开一个窗口，用户添加页面
			//参数：窗口的title、宽、高、url地址
			createmodalwindow("添加自行车", 800, 250, '${baseurl}bike/addbike.action');
		}
	} ];

	//加载datagrid

	$(function() {
		$('#bikeinfolist').datagrid({
			title : '自行车查询',//数据列表标题
			nowrap : true,//单元格中的数据不换行，如果为true表示不换行，不换行情况下数据加载性能高，如果为false就是换行，换行数据加载性能不高
			striped : true,//条纹显示效果
			url : '${baseurl}bike/querybike_result.action',//加载数据的连接，引连接请求过来是json数据
			idField : 'id',//此字段很重要，数据结果集的唯一约束(重要)，如果写错影响 获取当前选中行的方法执行
			loadMsg : '',
			columns : columns_v,
			pagination : true,//是否显示分页
			rownumbers : true,//是否显示行号
			pageList:[5,10,15],
			toolbar : toolbar_v
		});
	});
	
	//查询方法
	function querybike(){
		//datagrid的方法load方法要求传入json数据，最终将 json转成key/value数据传入action
		//将form表单数据提取出来，组成一个json
		var formdata = $("#bikequeryForm").serializeJson();
		//console.log(formdata);
		$('#bikeinfolist').datagrid('load',formdata);
	}
	
	//删除用户方法
	function deletebike(bikeId){

		//第一个参数是提示信息，第二个参数，取消执行的函数指针，第三个参是，确定执行的函数指针
		_confirm('您确认删除吗？',null,function (){

			//将要删除的id赋值给deleteid，deleteid在sysuserdeleteform中
			$("#delete_bikeId").val(bikeId);
			//使用ajax的from提交执行删除
			//sysuserdeleteform：form的id，userdel_callback：删除回调函数，
			//第三个参数是url的参数
			//第四个参数是datatype，表示服务器返回的类型
			jquerySubByFId('sysuserdeleteform',bikedel_callback,null,"json");
			
			
		});
	}
	
	//删除用户的回调
	function bikedel_callback(data){
		message_alert(data);
		//刷新 页面
		//在提交成功后重新加载 datagrid
		//取出提交结果
		var type=data.resultInfo.type;
		if(type==1){
			//成功结果
			//重新加载 datagrid
			querybike();
		}
	}
	
	//修改用户
	function editbike(bikeId){
		
		//打开修改窗口
		createmodalwindow("修改自行车信息", 800, 250, '${baseurl}bike/editbike.action?bikeId='+bikeId);
	}
</script>

</head>
<body>

	<!-- html的静态布局 -->
  <form id="bikequeryForm">
	<!-- 查询条件 -->
	<TABLE class="table_search">
		<TBODY>
			<TR>
				<TD class="left">自行车编码：</td>
				<td><INPUT type="text" name="pbsBikeInfoCustom.bikeId" /></TD>
				<TD class="left">自行车厂家：</TD>
				<td><INPUT type="text" name="pbsBikeInfoCustom.factory" /></TD>

				<TD class="left">自行车动态：</TD>
				<td><select name="pbsBikeInfoCustom.dynamicState">
						<option value="">请选择</option>
						<option value="1">在站</option>
						<option value="2">在桩</option>
						<option value="3">借出</option>
						<option value="4">调度中</option>
						<option value="5">维修保养中</option>

				</select></TD>
				<TD class="left">自行车状态：</TD>
				<td><select name="pbsBikeInfoCustom.state">
						<option value="">请选择</option>
						<option value="1">入库</option>
						<option value="2">在用</option>
						<option value="3">故障</option>
						<option value="4">丢失</option>
						<option value="5">报废</option>

				</select></TD>
				<td><a id="btn" href="#" onclick="querybike()"
					class="easyui-linkbutton" iconCls='icon-search'>查询</a></td>
			</TR>


		</TBODY>
	</TABLE>

	<!-- 查询列表 -->
	<TABLE border=0 cellSpacing=0 cellPadding=0 width="99%" align=center>
		<TBODY>
			<TR>
				<TD>
					<table id="bikeinfolist"></table>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
</form>
<form id="sysuserdeleteform" action="${baseurl}bike/deletebike.action" method="post">
  <input type="hidden" id="delete_bikeId" name="bikeId" />
</form>
</body>
</html>