<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
        <!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <style type="text/css">
      body,html,#container{
        height: 100%;
        margin: 0px;
        font:12px Arial;
      }
      .taiwan{
      	border: solid 1px red;
      	color: red;
      	float: left;
      	width: 50px;
      	background-color: rgba(255,0,0,0.1)
      }
    </style>
    <title>Marker example</title>
    
   <script src="../js/marker.js"></script>
   <script src="../js/jquery-1.4.4.js"></script>
  </head>
  <body>
   <div id="container" tabindex="0"></div>
   <script src="http://webapi.amap.com/maps?v=1.3&key=ee1710c4e180567b17806859073595cc"></script>
   <script type="text/javascript">
   //新建地图 
        var map = new AMap.Map('container',{
        	resizeEnable: true,
        	center: [120.3458,30.31276],//地图中心点
        	zoom:15
        	});
   
		   $.ajax({
			   url : "${baseurl}querymap_result.action",
			   type : "post",
			   dataType : "json",
			   success : function(data){
				   console.log(data);
				   //测试总条数   2360  测试通过
				   console.log("记录总数=="+data.total);
				   console.log("rentnamelist=="+data.rows[0].id);
				   //循环输出点位标记
				  for(var i = 0;i<data.total;i++){
					  var icon = new AMap.Icon({
	    					image: '../images/bike/blue.png',
	    					size: new AMap.Size(36, 36)
	    				});
					  var lng = data.rows[i].cLng;
					  var lat = data.rows[i].cLat;
					  
	    				marker = new AMap.Marker({
	    					icon: icon,
	    					position: [lng,lat],
	    					offset: new AMap.Pixel(-10,10),
	    					title: data.rows[i].id+":"+data.rows[i].rentName+":"+data.rows[i].lng+","+data.rows[i].lat,
	    					map: map
	    				});
				  }
			   },
			   error : function(){
				   alert("加载站点失败");
			   },
		   });
       
    </script>
    
  </body>
</html>