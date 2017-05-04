<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <title>WeUI</title>
        <script type="text/javascript" src="/pbsproject/js/jquery-1.4.4.min.js"></script>
        <!-- 引入 WeUI -->
        <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.1/weui.min.css"/>
        <script type="text/javascript">
        $(function(){
        	$('#btn').click(function(){
        		var nodeid = "nodeid="+$('#nodeid').val();
    			var bikeid = "&bikeid="+$('#bikeid').val();
    			var data = nodeid + bikeid;
        		$.ajax({
        			url:"${baseurl}riding_complete.action",
        			type:"get",
        			data:data,
        			dataType:"String",
        			success: function(data){
        				//console.log(data);
        				alert("成功");
        				alert('${bikeid}'+'---'+'${nodeid}');
        			},
        			error: function(data){
        				alert("失败");
        			}
        		});
        	});
    	});
        </script>
    </head>
    <body>
    	<p>车桩编号:</p>
		<input id="nodeid" type="text" name="nodeid" >
		<br>
		<p>自行车编号:</p>
		<input id="bikeid" type="text" name="bikeid" >
		<br>
		<button id="btn">自行车入桩</button>
        
    </body>
</html>