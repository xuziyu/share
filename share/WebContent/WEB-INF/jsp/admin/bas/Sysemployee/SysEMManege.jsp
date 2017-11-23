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
<a href="SysEmployeeManegerAction.action?method=insert"> 新增员工及其管理模块</a>
<form action="SysEmployeeManegerAction.action?method=list" id="form" method="post">
<input type="hidden" name="pageIndex" id="pageIndex" value="${page.pageIndex }" />
code:<input type="text" name="code" value="${code}" /><br/>
name:<input type="text" name="name" value="${name}" /><br/>
<input type="button" value="查询" onclick="goPageIndex(0);" />
<br/>
		<table border="red">
			<thead>
					<tr>
						<th>员工ID</th>
						<th>员工名字</th>
						<th>角色ID对应的名称</th>
						<th>模块名称</th>
						<th>系统管理</th>
						<th>密码</th>
						<th>性别</th>
						<th>生日</th>
						<th>在职状态</th>
					
						<th>头像FileID</th>
						<th>删除状态3</th>
						
					</tr>
			</thead>
			<tbody>
			<c:forEach items="${s_list}" var="employee" varStatus="employeeindex">
					<tr>
							<td>${employee.employeeId}</td>
							<td>${employee.jiaosename}</td>
							<td>${employee.roleName}</td>
							<td>${employee.moduleName}</td>
							<td>${employee.menuCode}</td>
							<td>${employee.menuName}</td>
							<td>${employee.enabled}</td>
							<td>${employee.menuUrl}</td>
							<td>${employee.roleId}</td>
							<td>${employee.moduleId}</td>
						<%-- <td><a href="SysEmployeeManegerAction.action?method=edit&employeeId=${employee.employeeId }">修改</a></td>	 --%>
						<td><a href="SysEmployeeManegerAction.action?method=delete&employeeId=${employee.employeeId }&roleId=${employee.roleId}">删除</a></td>	
					</tr>
			</c:forEach>
			</tbody>
		</table>

</form>
</body>
</html>