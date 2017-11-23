<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增或修改界面</title>
</head>
<body>
	<form action="${ctxPath}/admin/SysMenuAction.action?method=save${id}" method="post">
		<table>
			<tbody>
				<tr>
					<td>菜单id:</td>
					<td>${sysMenu.menuId}</td>
				</tr>
				<tr>
					<td>模块id:</td>
					<td>
						<select name="moduleId">
							<c:forEach items="${listSysModule}" var="sysModule">
								<option value="${sysModule.moduleId}" <c:if test="${sysModule.moduleId==sysMenu.moduleId}">selected="selected"</c:if>>${sysModule.name}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="moduleId" value="${sysMenu.moduleId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>编码:</td>
					<td><input type="text" name="code" value="${sysMenu.code}"/></td>
				</tr>
				<tr>
					<td>名称:</td>
					<td><input type="text" name="name" value="${sysMenu.name}"/></td>
				</tr>
				<tr>
					<td>可用:</td>
					<td><input type="text" name="enabled" value="${sysMenu.enabled}"/></td>
				</tr>
				<tr>
					<td>地址:</td>
					<td><input type="text" name="menuUrl" value="${sysMenu.menuUrl}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>