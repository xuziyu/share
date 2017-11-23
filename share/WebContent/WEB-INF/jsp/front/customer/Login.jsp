<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入</title>
<link rel="stylesheet" href="../resource/front/css/login.css">
</head>
<body>
	<div style="margin:0 auto;width:1500px;height:700px;">
	   <div style="margin:0 auto;width:1500px;height:90px;">
	   		<div style="float:left;width:170px;height:60px;margin-left:260px;margin-top:10px;">
	   			<img src="/share/resource/front/image/logo.jpg" style="width:170px;height:60px;"></img>
	   		

	   		</div>
	   		<div style="float:left;margin-top:35px;margin-left:20px; "> 
	   			<marquee><b style="font-size: 25px;color: red;">欢迎登录</b></marquee>
	   		</div>
	   		<div style="clear:both"></div>
	   
	   </div>
	   <div style="margin-top:10px ;width:1500px;height:475px;">
	   	
	        <div style=" float:left;width:990px;height:475px;">
	   			 <img src="/share/resource/front/image/1.1.jpg" style="width:990px;height:475px;"></img>
	   		

	   		</div>
	   		<div style="float:left;width:507px;height: 475px;"> 
	   			<div style="width:350px;height: 360px;border: 1px solid silver;margin-top: 40px;margin-left: 20px;">
	   				<div style="width:350px;height: 55px;">
	   					<div style="float: left;border: 1px solid silver;width: 170px;height:40px;text-align: center;">
	   						<!--<input style="width:170px;height: 40px;"type="button"name="submit"value="扫码登录">-->
	   							<a style="font-size: 20px; "href="#">扫码登录</a>
	   					</div>
	   					<div style="float: left;border: 1px solid silver;width: 176px;height:40px;text-align: center;">
	   						<a style="font-size: 20px; "href="#">账户登录</a>
	   					</div>
	   					
	   					<div style="clear: both;">
	   						
	   					</div>
	   						
	   				</div>
	   			<form action="/share/front/LoginfAction.action?method=save" method="post">
	   				<div style="width: 305px;height: 40px;border: 1px solid silver;margin-top: 30px;">
	   					<div style="float: left;text-align: center;">
	   						<img src="/share/resource/front/image/1.2.png" style="width: 40px;height: 40px;"/>
	   					</div >
	   					<div style="float: left;">
	   						<input    type="text" name="code" style="border:none;line-height: 37px;outline: none;" />
	   					</div>
	   					<div style="clear: both;"></div>
	   				</div>
	   				<div style="width: 305px;height: 40px;border: 1px solid silver;margin-top: 20px;text-align: center;">
	   					<div style="float: left;text-align: center;">
	   						<img src="/share/resource/front/image/1.3.png" style="width: 40px;height: 40px;"/>
	   					</div >
	   					<div style="float: left;">
	   						<input    type="password" name="password" style="border:none;line-height: 37px;outline: none;"/>
	   					</div>
	   					<div style="clear: both;"></div>
	   				</div>
	   				<div style="width: 305px;height: 40px;margin-top: 60px; ">     
	   				 	<input style="width:305px;height: 40px;background:#E4393C;font-size: 20PX;"type="submit"name="submit"value="登&nbsp&nbsp&nbsp录">
	   				</div>
	   			</form>	
	   				
	   				<div style="width:100px;height:20px;margin-left:0px;margin-top: 40px;">
	   					<a href="https://graph.qq.com/oauth/show?which=Login&display=pc&response_type=code&client_id=100273020&redirect_uri=https%3A%2F%2Fqq.jd.com%2Fnew%2Fqq%2Fcallback.action%3Fview%3Dnull">qq</a>
	   					<a href="https://open.weixin.qq.com/connect/qrconnect?appid=wx827225356b689e24&redirect_uri=https%3A%2F%2Fqq.jd.com%2Fnew%2Fwx%2Fcallback.action%3Fview%3Dnull&response_type=code&scope=snsapi_login#wechat_redirect">微信</a>
	   					<a href="/share/front/RegisterAction.action">注册</a>
	   				</div>	
	   			</div>
	   			
	   				
	   		</div>		
	   </div>
	    
	</div>
</body>
</html>