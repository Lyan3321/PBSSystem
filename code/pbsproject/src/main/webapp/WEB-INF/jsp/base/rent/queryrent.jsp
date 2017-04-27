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
		field : 'rentId',//对应json中的key
		title : '站点编号',
		width : 120
	}, {
		field : 'zoneName',//对应json中的key
		title : '所属区域',
		width : 120
	}, {
		field : 'road',//对应json中的key
		title : '所属街道',
		width : 120,
	}, {
		field : 'rentName',//对应json中的key
		title : '站点名称',
		width : 120
	},{
		field : 'rentPosition',//对应json中的key
		title : '站点位置',
		width : 250
	},{
		field : 'maxNumber',//对应json中的key
		title : '最大容量',
		width : 120
	},{
		field : 'lat',//对应json中的key
		title : '纬度',
		width : 120
	},{
		field : 'lng',//对应json中的key
		title : '经度',
		width : 120
	},{
		field : 'opt1',//对应json中的key
		title : '删除',
		width : 120,
		formatter : function(value, row, index){
			return "<a href=javascript:deleterent('"+row.rentId+"')>删除</a>"
		}
	},{
		field : 'opt2',//对应json中的key
		title : '修改',
		width : 120,
		formatter : function(value, row, index){
			return "<a href=javascript:editrent('"+row.rentId+"')>修改</a>"
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
			createmodalwindow("添加站点", 800, 250, '${baseurl}rent/addrent.action');
		}
	} ];

	//加载datagrid

	$(function() {
		$('#rentinfolist').datagrid({
			title : '站点查询',//数据列表标题
			nowrap : true,//单元格中的数据不换行，如果为true表示不换行，不换行情况下数据加载性能高，如果为false就是换行，换行数据加载性能不高
			striped : true,//条纹显示效果
			url : '${baseurl}rent/queryrent_result.action',//加载数据的连接，引连接请求过来是json数据
			idField : 'id',//此字段很重要，数据结果集的唯一约束(重要)，如果写错影响 获取当前选中行的方法执行
			loadMsg : '',
			columns : columns_v,
			pagination : true,//是否显示分页
			rownumbers : true,//是否显示行号
			pageList:[10,15,30],
			toolbar : toolbar_v
		});
	});
	
	//查询方法
	function queryrent(){
		//datagrid的方法load方法要求传入json数据，最终将 json转成key/value数据传入action
		//将form表单数据提取出来，组成一个json
		var formdata = $("#rentqueryForm").serializeJson();
		//console.log(formdata);
		$('#rentinfolist').datagrid('load',formdata);
	}
	
	//删除用户方法
	function deleterent(id){

		//第一个参数是提示信息，第二个参数，取消执行的函数指针，第三个参是，确定执行的函数指针
		_confirm('您确认删除吗？',null,function (){

			//将要删除的id赋值给deleteid，deleteid在sysuserdeleteform中
			$("#delete_id").val(id);
			//使用ajax的from提交执行删除
			//sysuserdeleteform：form的id，userdel_callback：删除回调函数，
			//第三个参数是url的参数
			//第四个参数是datatype，表示服务器返回的类型
			jquerySubByFId('rentdeleteform',rentdel_callback,null,"json");
			
			
		});
	}
	
	//删除用户的回调
	function rentdel_callback(data){
		message_alert(data);
		//刷新 页面
		//在提交成功后重新加载 datagrid
		//取出提交结果
		var type=data.resultInfo.type;
		if(type==1){
			//成功结果
			//重新加载 datagrid
			queryrent();
		}
	}
	
	//修改用户
	function editrent(rentId){
		
		//打开修改窗口
		createmodalwindow("修改站点信息", 800, 250, '${baseurl}rent/editrent.action?id='+id);
	}
</script>

</head>
<body>

	<!-- html的静态布局 -->
  <form id="rentqueryForm">
	<!-- 查询条件 -->
	<TABLE class="table_search">
		<TBODY>
			<TR>
				<TD class="left">站点编号：</td>
				<td><INPUT type="text" name="pbsRentInfoCustom.rentId" /></TD>
				<TD class="left">所属区域：</TD>
				<td><INPUT type="text" name="pbsRentInfoCustom.zoneName" /></TD>

				<TD class="left">所属街道：</TD>
				<td><INPUT type="text" name="pbsRentInfoCustom.road" /></TD>
				<TD class="left">站点名称：</TD>
				<td><INPUT type="text" name="pbsRentInfoCustom.rentName" /></TD>
				<td><a id="btn" href="#" onclick="queryrent()"
					class="easyui-linkbutton" iconCls='icon-search'>查询</a></td>
			</TR>


		</TBODY>
	</TABLE>

	<!-- 查询列表 -->
	<TABLE border=0 cellSpacing=0 cellPadding=0 width="99%" align=center>
		<TBODY>
			<TR>
				<TD>
					<table id="rentinfolist"></table>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
</form>
<form id="rentdeleteform" action="${baseurl}rent/deleterent.action" method="post">
  <input type="hidden" id="delete_Id" name="Id" />
</form>
</body>
</html>