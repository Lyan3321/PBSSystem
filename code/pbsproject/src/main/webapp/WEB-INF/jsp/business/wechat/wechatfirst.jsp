<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width" />
    <style type="text/css">
      body,html,#container{
        height: 100%;
        margin: 0px;
      }
      .btn{
      position:fixed;
      left:40%;
      top:80%;
      }
      .class_scan{
      position:fixed;
      left:33%;
      top:70%;
      }
    </style>
<title>公共自行车助手</title>
<!-- 引入 WeUI -->
<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.1/weui.min.css"/>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="/pbsproject/js/jquery-1.4.4.min.js"></script>

<link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <style type="text/css">
        #panel {
            position: fixed;
            background-color: white;
            max-height: 90%;
            overflow-y: auto;
            top: 10px;
            right: 10px;
            width: 150px;
        }
    </style>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=cfa08784f1be35f90f8b8f27f42b9999&plugin=AMap.Walking"></script>
<script type="text/javascript">

var latitude;
var longitude;
var map;
var walking;
var infoWindow;
var params;

	//function jssdk() {
	$(function(){
		$.ajax({
			url : "${baseurl}wechatconfig.action",
			type : 'post',
			dataType : 'json',
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			data : {
				'url' : location.href.split('#')[0]
			},
			success : function(data) {
				wx.config({
					debug : false,
					appId : data.data.appId,
					timestamp : data.data.timestamp,
					nonceStr : data.data.nonceStr,
					signature : data.data.signature,
					jsApiList : [ 'checkJsApi', 'onMenuShareTimeline',
							'onMenuShareAppMessage', 'onMenuShareQQ',
							'onMenuShareWeibo', 'hideMenuItems',
							'showMenuItems', 'hideAllNonBaseMenuItem',
							'showAllNonBaseMenuItem', 'translateVoice',
							'startRecord', 'stopRecord', 'onRecordEnd',
							'playVoice', 'pauseVoice', 'stopVoice',
							'uploadVoice', 'downloadVoice', 'chooseImage',
							'previewImage', 'uploadImage', 'downloadImage',
							'getNetworkType', 'openLocation', 'getLocation',
							'hideOptionMenu', 'showOptionMenu', 'closeWindow',
							'scanQRCode', 'chooseWXPay',
							'openProductSpecificView', 'addCard', 'chooseCard',
							'openCard' ]
				});
			}
		});
		
		$("#scan").click(function(){
			wx.scanQRCode({
			    needResult: 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
			    scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有
			    success: function (res) {
			    var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
			    //alert(typeof result);
			    //var a = "{rent:1001,node:1}";
			    //location.href= "http://ry16704270.imwork.net/pbsproject/wechat/riding.action?message="+a;
			    //跳转
			    //location.href=result;
			    $('#mes1').show();
			    time1();
			    $('#btn1').click(function(){
					$('#mes1').hide();			    		
			    });
			}
			});
		});
		
		$("#home").click(function(){
			//alert(111);
			location.href="${baseurl}home.action";	
		});
		
	});
	
		wx.ready(function(){
			
			    map = new AMap.Map('container',{
	            resizeEnable: true,
	            zoom: 16,
	            //center: [longitude, latitude]
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
			
			/*wx.getLocation({
			      success: function (res) {
					//加载站点信息并标记
				    loadData();
					//转换用户经纬度
				    convertData(res.latitude,res.longitude);
				    
			      },
			      cancel: function (res) {
			        alert('用户拒绝授权获取地理位置');
			      }
			  });*/
			
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
			
			
		});
	
		
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
		
		function time(){
			var m=14;
		    var s=59;
		    setInterval(function(){
		        if(s<10){
		            $('#time').html(m+':0'+s);
		        }else{
		            $('#time').html(m+':'+s);
		        }
		        s--;
		        if(s<0){
		            s=59;
		            m--;
		        }
		    },1000);
		}
		
		//骑行时间计时
		function time1(){
			var h=00;
			var m=00;
		    var s=01;
		    setInterval(function(){
		        if(s<10){
		            $('#time1').html(h+':'+m+':0'+s);
		        }else{
		            $('#time1').html(h+':'+m+':'+s);
		        }
		        s++;
		        if(s==60){
		            s=0;
		            m++;
		        }
		    },1000);
		}

</script>
</head>
<body>

<div id="container" tabindex="0"></div>
<!--<canvas id="myCanvas" width="200" height="100" style="position:fixed;left:75px;top:400px;border:1px solid #d3d3d3;">
您的浏览器不支持 HTML5 canvas 标签。</canvas> -->  
<div id="panel"></div>
<img id="scan" class="class_scan" alt=".." src="/pbsproject/images/weixin/scan.png" width="120" height="120">
<div id="mes" style="background-color:white; position:fixed;width:100%;height:10%" hidden>
<p>还剩时间:</p>
<p id="time">15:00</p>
<button id="btn" style="position:fixed;right:10px;top:10px">取消预约</button>
</div>
<div id="mes1" style="background-color:white; position:fixed;width:100%;height:10%" hidden>
<p>正在骑行:</p>
<p id="time1">00:00:00</p>
<button id="btn1" style="position:fixed;right:10px;top:10px">结束骑行</button>
</div>
<img id="home" alt="菜单" src="/pbsproject/images/weixin/icon-link4.png" width="30" height="30" style="position:fixed;top:85%;right:10%">
</body>
</html>
