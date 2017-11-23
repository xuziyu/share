<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
</head>
<body>
<form action="SysEmployeeRoleAction.action?method=insert2" id="form" method="post">
<br/>
		<table border="red">
			<thead>
					<tr>
						<th>员工权限ID</th>
						<th>权限ID</th>
						<th>员工ID</th>
						
					</tr>
			</thead>
			<tbody>
					<tr>
						<td><input type="text" value="" name="employeeRoleId"/></td>
						<td><input type="text" value="" name="roleId"/></td>
						<td><input type="text" value="" name="employeeId"/></td>
					</tr>	
			</tbody>
		</table>
		<input type="submit" value="保存" />
</form>
</body>
</html>