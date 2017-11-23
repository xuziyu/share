<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增或修改界面</title>
<script type="text/javascript">
	function onchange_province() {
		var array = new Array();
		var arrayModule =new Array();
		var arrayId = new Array();
		var arrayName =new Array();
		var bigSelected = document.getElementById("module").value ;
		<c:forEach items="${listSysMenu}" var="sysMenu">
			arrayModule.push("${sysMenu.moduleId}")
			arrayId.push("${sysMenu.menuId}")
			arrayName.push("${sysMenu.name}")
			array.push("${sysMenu}")
		</c:forEach>
		 document.getElementById("menu").options.length=0;
		for(var i = 0;i<arrayId.length;i++){
			if(bigSelected==arrayModule[i]){
				var optionObj = document.createElement("option");
				optionObj.value = arrayId[i]
				optionObj.innerHTML = arrayName[i];
				document.getElementById("menu").appendChild(optionObj);
			}
		}
	}
</script>
</head>
<body>
	<form action="${ctxPath}/admin/SysRoleMenuAction.action?method=save${id}" method="post">
		<table>
			<tbody>
				<tr>
					<td>角色id:</td>
					<td>${sysRoleMenu.roleMenuId}</td>
				</tr>
				<tr>
					<td>角色:</td>
					<td>
						<select name="roleId">
							<c:forEach items="${listSysRole}" var="sysRole">
								<option value="${sysRole.roleId}" <c:if test="${sysRole.roleId==sysRoleMenu.roleId}">selected="selected"</c:if>>${sysRole.name}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="roleId" value="${sysRoleMenu.roleId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>模块:</td>
					<td>
						<select name="moduleId" id="module" onchange="onchange_province();">
							<c:forEach items="${listSysModule}" var="sysModule">
								<option value="${sysModule.moduleId}" <c:if test="${sysModule.moduleId==sysRoleMenu.moduleId}">selected="selected"</c:if>>${sysModule.name}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="moduleId" value="${sysRoleMenu.moduleId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>菜单:</td>
					<td>
						<select name="menuId" id="menu">
							<c:forEach items="${listSysMenu}" var="sysMenu">
								<option value="${sysMenu.menuId}" <c:if test="${sysMenu.moduleId==listSysModule[0].moduleId}">selected="selected"</c:if>>${sysMenu.name}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="menuId" value="${sysRoleMenu.menuId}"/> --%>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>