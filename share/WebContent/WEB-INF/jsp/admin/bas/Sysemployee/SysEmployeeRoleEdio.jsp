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
<form action="SysEmployeeRoleAction.action?method=save" id="form" method="post">
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
			<c:forEach items="${list}" var="employee" varStatus="employeeindex">
					<tr>
						<td><input type="hidden" value="${employee.employeeRoleId}" name="employeeRoleId"/>${employee.employeeRoleId}</td>
						<td><input type="text" value="${employee.roleId}" name="roleId"/></td>
						<td><input type="hidden" value="${employee.employeeId}" name="employeeId"/>${employee.employeeId}</td>
					</tr>
			</c:forEach>
			
			</tbody>
		</table>
		<input type="submit" value="保存" />
</form>
</body>
</html>