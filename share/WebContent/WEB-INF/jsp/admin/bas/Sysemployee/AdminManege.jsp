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
<a href="AdminAction.action?method=insert"> 新增</a>
<form action="AdminAction.action?method=list" id="form" method="post">
<input type="hidden" name="pageIndex" id="pageIndex" value="${page.pageIndex }" />
code:<input type="text" name="code" value="${code}" /><br/>
name:<input type="text" name="name" value="${name}" /><br/>
<input type="button" value="查询" onclick="goPageIndex(0);" />
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
			<c:forEach items="${page.result}" var="employee" varStatus="employeeindex">
					<tr>
						<td>${employee.employeeId}</td>
						<td>${employee.organizationId}</td>
						<td>${employee.code}</td>
						<td>${employee.name}</td>
						<td>${employee.password}</td>
						<td>${employee.gender}</td>
						<td><fmt:formatDate value="${employee.birth}" pattern="yyyy-MM-dd"/></td>
						<td>${employee.onJobStatus}</td>
						<td>${employee.descr}</td>
						<td>${employee.headPhotoFileId}</td>
						<td>${employee.deleteStatus}</td>
						<td><a href="AdminAction.action?method=edit&employeeId=${employee.employeeId }">修改</a></td>	
						<td><a href="AdminAction.action?method=delete&employeeId=${employee.employeeId }">删除</a></td>	
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