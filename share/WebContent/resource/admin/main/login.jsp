<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统管理</title>
</head>
<body>
	<form action="/share/AdminLoginAction.action" method="post">
		<table>
			<tbody>
				<tr>
					<td>账号：</td>
					<td>
						<input type="text" name="user"/>
					</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td>
						<input type="password" name="password"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="登录"/>
					</td>
					<td>
						
					</td>
				</tr>
			</tbody>
		</table>
</form>
</body>
</html>