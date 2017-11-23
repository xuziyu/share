<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误提示</title>
</head>
<body>
<a href="javascript:history.back(-1)">返回</a>
异常信息:
<%
Exception exception = (Exception)request.getAttribute("exception") ;
out.print(exception.getMessage()) ;
out.flush();
%>
<hr/>
栈轨迹
<%

exception.printStackTrace(new java.io.PrintWriter(out)) ;
out.flush();
%>
<hr/>
</body>
</html>