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
	<form action="${ctxPath}/admin/ProductAction.action?pageName=brand&method=save${id}" method="post">
		<table>
			<tbody>
				<tr>
					<td>品牌id:</td>
					<td>${basBrand.brandId}</td>
				</tr>
				<tr>
					<td>编号:</td><td><input type="text" name="code" value="${basBrand.code}"/></td>
				</tr>
				<tr>
					<td>名称:</td><td><input type="text" name="name" value="${basBrand.name}"/></td>
				</tr>
				<tr>
					<td>标语:</td><td><input type="text" name="slogan" value="${basBrand.slogan}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>