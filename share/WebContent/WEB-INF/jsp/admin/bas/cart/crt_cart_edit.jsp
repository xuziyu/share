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
	<form action="${ctxPath}/admin/CartAction.action?method=save${id}" method="post">
		<table>
			<tbody>
				<tr>
					<td>购物车ID:</td>
					<td>${crtCart.cartId}</td>
				</tr>
				<tr>
					<td>客户ID:</td>
					<td>
						<select name="customerId">
							<c:forEach items="${listBasCustomer}" var="basCustomer">
								<option value="${basCustomer.customerId}" <c:if test="${crtCart.customerId==basCustomerDetail.customerId}">selected="selected"</c:if>>${basCustomer.name}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="customerId" value="${crtCart.customerId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>产品skuid:</td>
					<td>
						<select name="productSkuId">
							<c:forEach items="${listBasProductSku}" var="basProductSku">
								<option value="${basProductSku.productSkuId}" <c:if test="${crtCart.productSkuId==basProductSkuDetail.productSkuId}">selected="selected"</c:if>>${basProductSku.barCode}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="productSkuId" value="${crtCart.productSkuId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>创建日期:</td>
					<td><input type="text" name="createDate" value="${crtCart.createDate}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>