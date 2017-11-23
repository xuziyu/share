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
	<form action="${ctxPath}/admin/SupplierAction.action?pageName=Supplier&method=save${id}" method="post">
		<table>
			<tbody>
				<tr>
					<td>供应商ID:</td>
					<td>${supplier.supplierId}</td>
				</tr>
				<tr>
					<td>编号:</td>
					<td><input type="text" name="code" value="${supplier.code}"/></td>
				</tr>
				<tr>
					<td>名称:</td>
					<td><input type="text" name="name" value="${supplier.name}"/></td>
				</tr>
				<tr>
					<td>应收款:</td>
					<td><input type="text" name="needPayMoney" value="${supplier.needPayMoney}"/></td>
				</tr>
				<tr>
					<td>联系人姓名:</td>
					<td><input type="text" name="contactName" value="${supplier.contactName}"/></td>
				</tr>
				<tr>
					<td>联系人电话:</td>
					<td><input type="text" name="contactMobile" value="${supplier.contactMobile}"/></td>
				</tr>
				<tr>
					<td>地址:</td>
					<td><input type="text" name="address" value="${supplier.address}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>