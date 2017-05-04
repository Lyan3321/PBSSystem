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
   <script src="http://webapi.amap.com/maps?v=1.3&key=cfa08784f1be35f90f8b8f27f42b9999&plugin=AMap.Walking"></script>
   <script type="text/javascript">
   var latitude;
   var longitude;
   var map;
   var walking;
   var infoWindow;
   var params;
   //新建地图 
        var map = new AMap.Map('container',{
        	resizeEnable: true,
        	center: [120.3458,30.31276],//地图中心点
        	zoom:15
        	});
        walking = new AMap.Walking({
	        map: map,
	       // panel: "panel"
	    }); 
   
        map.plugin('AMap.Geolocation', function() {
	        geolocation = new AMap.Geolocation({
	            enableHighAccuracy: true,//是否使用高精度定位，默认:true
	            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
	            buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
	            zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
	            buttonPosition:'LB'
	        });
	        map.addControl(geolocation);
	        geolocation.getCurrentPosition();
	        AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
	        AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
	    });
	    //解析定位结果
	    function onComplete(data) {
	        var str=['定位成功'];
	        str.push('经度：' + data.position.getLng());
	        str.push('纬度：' + data.position.getLat());
	        latitude = data.position.getLat();
	        longitude = data.position.getLng();
	        params = {lng:longitude,lat:latitude};
	        loadData();
	        if(data.accuracy){
	             str.push('精度：' + data.accuracy + ' 米');
	        }//如为IP精确定位结果则没有精度信息
	        str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
	        document.getElementById('tip').innerHTML = str.join('<br>');
	    }
	    //解析定位错误信息
	    function onError(data) {
	        document.getElementById('tip').innerHTML = '定位失败';
	    }
   
	    function convertData(lat,lng){
			
			$.ajax({
				url : "${baseurl}convert.action",
				data : {'lat':lat,'lng':lng},
				dataType : 'json',
				success : function(data){
					//alert("转换坐标成功");	
					latitude = data.cLat;
					longitude = data.cLng;
					map.setCenter([longitude,latitude]);
				},
				error : function(data){
					alert("转换坐标失败");
				}
			});
		};
	    
		function loadData(){
			$.ajax({
				   url : "${baseurl}querymap_result_gps.action",
				   type : "post",
				   data : params,
				   dataType : "json",
				   success : function(data){
					   //测试总条数   2360  测试通过
					   console.log("记录总数=="+data.total);
					   console.log("rentnamelist=="+data.rows[0].id);
					   
					        infoWindow = new AMap.InfoWindow({
	    					offset: new AMap.Pixel(0, 10)  
	    				   });
					   //循环输出点位标记
					  for(var i = 0;i<data.total;i++){
						  var icon = new AMap.Icon({
		    					image: '../images/bike/blue.png',
		    					size: new AMap.Size(36, 36)
		    				});
		    				marker = new AMap.Marker({
		    					icon: icon,
		    					position: [data.rows[i].cLng,data.rows[i].cLat],
		    					offset: new AMap.Pixel(-10,10),
		    					title: data.rows[i].id+":"+data.rows[i].rentName+":"+data.rows[i].cLng+","+data.rows[i].cLat,
		    					map: map
		    				});
		    	        	
		    	        	marker.content = data.rows[i].rentName +"<br>"+"可用车辆:"+ data.rows[i].operNum +"<br>"+"<a href=javascript:yuyue("+data.rows[i].cLng+","+data.rows[i].cLat+")>预约</a>";
		    	            marker.on('click', markerClick);
		    	            //marker.emit('click', {target: marker});//触发事件
		    	            
		    	        	 
					  }
					  //添加标签
					  function markerClick(e) {
	    	                infoWindow.setContent(e.target.content);
	    	                infoWindow.open(map, e.target.getPosition());
	    	            }
				   },
				   error : function(){
					   alert("加载站点失败");
				   },
			   }); 
			
			
		}
		function yuyue(lng,lat){
			//location.href="${baseurl}yuyue.action";
			alert("预约车辆为您保留15分钟，开锁开始计费");
			//walking.search([120.35028, 30.315589], [120.348798828125, 30.318758138021]);
			walking.search([longitude, latitude], [lng, lat]);
			infoWindow.close();
			$('#mes').show();
			time();
			$('#btn').click(function(){
				$('#mes').hide();
				walking.clear();
				});
		}
    </script>
    
  </body>
</html>