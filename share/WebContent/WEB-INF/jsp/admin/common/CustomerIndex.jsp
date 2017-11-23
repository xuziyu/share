<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CustomerIndex</title>
</head>
<body>
首页 ; 
${s_user.name }
${s_user.customerId } 
<a href="">我的购物车</a>
<a href="OrderInfoAction.action?method=pageList&customerId=${s_user.customerId }">订单查询</a>
<a href="CustomerAction.action?method=pageList&customerId=${s_user.customerId }">账号管理</a>
</body>
</html>