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
	<form action="${ctxPath}/admin/DictionaryAction.action?pageName=dict&method=save${id}" method="post">
		<table>
			<tbody>
				<tr>
					<td>字典id:</td>
					<td>${basDict.dictId}</td>
				</tr>
				<tr>
					<td>编码:</td>
					<td><input type="text" name="dictCode" value="${basDict.dictCode}"/></td>
				</tr>
				<tr>
					<td>标签:</td>
					<td><input type="text" name="dictLabel" value="${basDict.dictLabel}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>