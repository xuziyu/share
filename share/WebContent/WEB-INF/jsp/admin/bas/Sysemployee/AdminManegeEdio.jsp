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
<form action="AdminAction.action?method=save" id="form" method="post">
<br/>
		<table border="red">
			<thead>
					<tr>
						<th>员工ID</th>
						<th>组织id</th>
						<th>编号</th>
						<th>姓名</th>
						<th>密码</th>
						<th>性别</th>
						<th>生日</th>
						<th>在职状态</th>
						<th>个人简介</th>
						<th>头像FileID</th>
						<th>删除状态</th>
						
					</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="employee" varStatus="employeeindex">
					<tr>
						<td><input type="hidden" value="${employee.employeeId}" name="employeeId"/>${employee.employeeId}</td>
						<td><input type="text" value="${employee.organizationId}" name="organizationId"/></td>
						<td><input type="text" value="${employee.code}" name="code"/></td>
						<td><input type="text" value="${employee.name}" name="name"/></td>
						<td><input type="text" value="${employee.password}" name="password"/></td>
						<td><input type="text" value="${employee.gender}" name="gender"/></td>
						<td><input type="text" value="<fmt:formatDate value="${employee.birth}" pattern="yyyy-MM-dd"/>" name="birth"/></td>
						<td><input type="text" value="${employee.onJobStatus}" name="onJobStatus"/></td>
						<td><input type="text" value="${employee.descr}" name="descr"/></td>
						<td><input type="text" value="${employee.headPhotoFileId}" name="headPhotoFileId"/></td>
						<td><input type="text" value="${employee.deleteStatus}" name="deleteStatus"/></td>
					</tr>
			</c:forEach>
			
			</tbody>
		</table>
		<input type="submit" value="保存" />
</form>
</body>
</html>