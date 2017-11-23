<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" href="../resource/front/css/login.css">
<script type="text/javascript">
	function flushCode() {
    // 每次刷新的时候获取当前时间，防止浏览器缓存刷新失败
    var time = new Date();
    document.getElementById("scode").src = "<%=request.getContextPath()%>/ImageAction?time=" + time;
}
</script>
</head>
<body>
	<div style="margin:0 auto;width:1500px;height:730px;">
	       <div style="margin:0 auto;width:1500px;height:90px;">
	   		   <div style="float:left;width:170px;height:60px;margin-left:260px;margin-top:10px;">
	   		 	  <img src="/share/resource/front/image/logo.jpg" style="width:170px;height:60px;"></img>

	   		    </div>
	   		    <div style="float:left;margin-top:35px;margin-left:20px;"> 
	   		    <marquee><b style="font-size: 25px;color: red;">欢迎注册</b></marquee>
	   		    </div>
	   		    <div style="float:left;margin-left:700px;margin-top:30px;width: 200px;height: 20px;">
	   		    	已有账号？<a href="/share/front/LoginfAction.action">请登入</a>	
	   		    </div>
	   		    <div style="clear:both"></div>
	    
	       </div>
	       <div style="margin:0 auto;width:1500px;height:640px;">
	       	  <form action="/share/front/RegisterAction.action?method=save" method="post">
	       	 	<div style="width:400px;height:50px;border:1px solid silver ;margin-top:60px;margin-left: 335px;">
	       	 		用户名<input type="text" name="user" style="line-height: 47px;border:none;outline: none;"/>
	       	 	</div>
	       	 	<div style="width:400px;height:50px;border:1px solid silver ;margin-top:30px;margin-left: 335px;">
	       	 		设置密码<input type="password" name="password"style="line-height: 47px;border:none;outline: none;"/>
	       	 	</div>
	       	 	<div style="width:400px;height:50px;border:1px solid silver;margin-top:30px;margin-left: 335px;">
	       	 		确认密码<input type="password" name="rpassword"style="line-height: 47px;border:none;outline: none;"/>
	       	 	</div>
	       	 	<div style="width:400px;height:50px;border:1px solid silver ;margin-top:30px;margin-left: 335px;">
	       	 	      电话号码<input type="text" name="telephone"style="line-height: 47px;border:none;outline: none;"/>
	       	 	</div>
	       	 	
	       	 	<div style="width:400px;height:50px;border:1px solid silver;margin-top:30px;margin-left: 335px;">
	       	 		<span style="position: relative;left: 4px;top:-20px;">验证码</span><input type="text" style="line-height: 47px;border:none;outline: none;position: relative;left: 4px;top:-20px;" name="code"/>
	       	 		<a href="#" onclick="javascript:flushCode();"><img alt="验证码" id="scode" src="<%=request.getContextPath() %>/ImageAction" style="width:178px;height:50px;"></a>
	       	 	</div>
	       	 	<div style="width:400px;height:50px;border:1px solid silver;margin-top:30px;margin-left: 335px;">
	       	 		手机验证码<input type="text" style="line-height: 47px;border:none;outline: none;"/>验证码
	       	 	</div>
	       	 	<div style="width:400px;height:50px;margin-top:60px;margin-left: 335px;">
	       	 		<input style="width:400px;height: 50px;background:#E4393C;font-size: 20PX;"type="submit"name="submit"value="注&nbsp&nbsp&nbsp册">
	       	 	</div>
	       	 </form>
	       </div>
	       
	       
	     </div>

</body>
</html>