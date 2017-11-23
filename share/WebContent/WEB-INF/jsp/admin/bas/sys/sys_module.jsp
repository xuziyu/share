<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
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
<a href="${ctxPath}/SysModuleAction.action?method=edit">新增</a>
<form action="${ctxPath}/SysModuleAction.action" id="form" method="post">
	<input type="hidden" id="pageIndex" name="pageIndex" value=""/>
	模块id：<input type="text" name="moduleId"/>
	编码：<input type="text" name="code"/>	
	名称：<input type="text" name="name"/>
	可用：<input type="text" name="enabled"/>
	<input type="button" value="查询" onclick="goPageIndex(0);"/>
	<table>
		<thead>
			<tr>
				<th>模块ID</th>
				<th>编码</th>
				<th>名称</th>
				<th>可用</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="sysModule">
			<tr>
				<td>${sysModule.moduleId}</td>
				<td>${sysModule.code}</td>
				<td>${sysModule.name}</td>
				<td>${sysModule.enabled}</td>
				<td>
					<a href="${ctxPath}/SysModuleAction.action?method=edit&id=${sysModule.moduleId}" >修改</a>
					<a href="${ctxPath}/SysModuleAction.action?method=delete&id=${sysModule.moduleId}" >删除</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<c:forEach begin="0" end="${page.pageCount-1}" varStatus="status">
		<a href="javascript:goPageIndex(${status.index});">${status.index+1 }</a>
	</c:forEach>
	<select name="pageSize" id="pageSize" onchange="javascript:goPageIndex(0);">
		<option value="5" <c:if test="${page.pageSize== 5}"> selected="selected"</c:if> >5</option>
		<option value="10" <c:if test="${page.pageSize== 10}"> selected="selected"</c:if> >10</option>
		<option value="100" <c:if test="${page.pageSize== 100}"> selected="selected"</c:if> >100</option>
	</select>
	${page.pageSize}
</form>
</body>
</html>