<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<script type="text/javascript">
	function gid(id){
		return document.getElementById(id);
	}

	function goPageIndex(index){
		gid("pageIndex").value = index ;
		gid("form").submit() ;
	}
</script>
</head>
<body>
<a href="SysEmployeeRoleAction.action?method=insert"> 新增</a>
<form action="SysEmployeeRoleAction.action?method=list" id="form" method="post">
<input type="hidden" name="pageIndex" id="pageIndex" value="${page.pageIndex }" />
员工ID:<input type="text" name="code" value="${code}" /><br/>
<input type="button" value="查询" onclick="goPageIndex(0);" />
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
			<c:forEach items="${page.result}" var="employee" varStatus="employeeindex">
					<tr>
						<td>${employee.employeeRoleId}</td>
						<td>${employee.roleId}</td>
						<td>${employee.employeeId}</td>
						<td><a href="SysEmployeeRoleAction.action?method=edit&employeeId=${employee.employeeId }">修改</a></td>	
						<td><a href="SysEmployeeRoleAction.action?method=delete&employeeRoleId=${employee.employeeRoleId }">删除</a></td>	
					</tr>
			</c:forEach>
			</tbody>
		</table>
<c:forEach begin="0" end="${page.pageCount-1}" varStatus="status">
<a href="javascript:goPageIndex(${status.index})">${status.index+1}</a>
</c:forEach>
<select name="pageSize" id="pageSize" onchange="javascript:goPageIndex(0);">
<option value="5" <c:if test="${page.pageSize== 5}"> selected="selected"</c:if> >5</option>
<option value="10" <c:if test="${page.pageSize== 10}"> selected="selected"</c:if> >10</option>
<option value="100" <c:if test="${page.pageSize== 100}"> selected="selected"</c:if> >100</option>
</select>
</form>
</body>
</html>