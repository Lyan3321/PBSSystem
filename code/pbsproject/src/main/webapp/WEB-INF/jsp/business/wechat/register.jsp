<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <title>预约结果</title>
        <!-- 引入 WeUI -->
        <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.1/weui.min.css"/>
        <script src="../js/jquery-1.4.4.js"></script>
        <script type="text/javascript">
        	function register(){
        		var tel = "tel="+$('#tel').val();
        		alert(tel);
        		$.ajax({
        			url : '${baseurl}register_result.action',
        			type : 'get',
        			data : tel,
        			dataType : 'json',
        			success : function(data){
						var data_v = data.resultInfo;
						var type = data_v.type;
						var message = data_v.message;
						if(type==0){
							alert("error:"+message);
						}else if(type==1){
							alert("success:"+message);
						}
        			},
        			error : function(data){
        				alert("注册失败");
        			}
        		});
        	}
        </script>
    </head>
    <body>
		<div class="weui-cells weui-cells_form">
			<div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd">
                    <label class="weui-label">手机号</label>
                </div>
                <div class="weui-cell__bd">
                    <input id="tel" class="weui-input" type="tel" placeholder="请输入手机号">
                </div>
                <div class="weui-cell__ft">
                    <button class="weui-vcode-btn">获取验证码</button>
                </div>
            </div>
            
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">验证码</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="number" pattern="[0-9]*" placeholder="请输入验证码"/>
                </div>
            </div>
		</div>
		<br>
		<div class="page__bd page__bd_spacing">
			<a href="javascript:register();" class="weui-btn weui-btn_primary">注册</a>
		</div>
    </body>
</html>