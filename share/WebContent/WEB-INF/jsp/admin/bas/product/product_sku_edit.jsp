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
	<form action="${ctxPath}/admin/ProductAction.action?pageName=productSKU&method=save${id}" method="post">
		产品skuid:${basProductSku.productSkuId}<br>
		<table>
			<tbody>
				<tr>
					<td>产品id:</td>
					<td>
						<select name="productId">
							<c:forEach items="${listBasProduct}" var="basProduct">
								<option value="${basProduct.productId}" <c:if test="${basProductSku.productId==basProduct.productId}">selected="selected"</c:if>>${basProduct.name}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="productId" value="${basProductSku.productId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>颜色id:</td>
					<td>
						<select name="skuColorId">
							<c:forEach items="${listBasSkuColor}" var="basSkuColor">
								<option value="${basSkuColor.skuColorId}" <c:if test="${basProductSku.skuColorId==basSkuColor.skuColorId}">selected="selected"</c:if>>${basSkuColor.name}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="skuColorId" value="${basProductSku.skuColorId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>尺寸id:</td>
					<td>
						<select name="skuSizeId">
							<c:forEach items="${listBasSkuSize}" var="basSkuSize">
								<option value="${basSkuSize.skuSizeId}" <c:if test="${basProductSku.skuSizeId==basSkuSize.skuSizeId}">selected="selected"</c:if>>${basSkuSize.name}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="skuSizeId" value="${basProductSku.skuSizeId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>条码:</td>
					<td><input type="text" name="barCode" value="${basProductSku.barCode}"/></td>
				</tr>
				<tr>
					<td>实际价格:</td>
					<td><input type="text" name="priceReal" value="${basProductSku.priceReal}"/></td>
				</tr>
				<tr>
					<td>原价:</td>
					<td><input type="text" name="priceOld" value="${basProductSku.priceOld}"/></td>
				</tr>
				<tr>
					<td>成本价:</td>
					<td><input type="text" name="priceCost" value="${basProductSku.priceCost}"/></td>
				</tr>
				<tr>
					<td>预计进价:</td>
					<td><input type="text" name="pricePlanPurchase" value="${basProductSku.pricePlanPurchase}"/></td>
				</tr>
				<tr>
					<td>库存数量:</td>
					<td><input type="text" name="amountStock" value="${basProductSku.amountStock}"/></td>
				</tr>
				<tr>
					<td>初始数量:</td>
					<td><input type="text" name="amountInit" value="${basProductSku.amountInit}"/></td>
				</tr>
				<tr>
					<td>最低库存数量:</td>
					<td><input type="text" name="amountMinStock" value="${basProductSku.amountMinStock}"/></td>
				</tr>
				<tr>
					<td>最高库存数量:</td>
					<td><input type="text" name="amountMaxStock" value="${basProductSku.amountMaxStock}"/></td>
				</tr>
				<tr>
					<td>原图field id:</td>
					<td>
						<select name="picOriFileId">
							<c:forEach items="${listOri}" var="ori">
								<option value="${ori.fileUploadId}" <c:if test="${basProductSku.picOriFileId==ori.fileUploadId}">selected="selected"</c:if>>${ori.shortName}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="picOriFileId" value="${basProductSku.picOriFileId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>大图field id:</td>
					<td>
						<select name="picBigFileId">
							<c:forEach items="${listBig}" var="big">
								<option value="${big.fileUploadId}" <c:if test="${basProductSku.picBigFileId==big.fileUploadId}">selected="selected"</c:if>>${big.shortName}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="picBigFileId" value="${basProductSku.picBigFileId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>中图field id:</td>
					<td>
						<select name="picMiddleFileId">
							<c:forEach items="${listMid}" var="mid">
								<option value="${mid.fileUploadId}" <c:if test="${basProductSku.picMiddleFileId==mid.fileUploadId}">selected="selected"</c:if>>${mid.shortName}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="picMiddleFileId" value="${basProductSku.picMiddleFileId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>小图field id:</td>
					<td>
						<select name="picSmallFileId">
							<c:forEach items="${listSmall}" var="small">
								<option value="${small.fileUploadId}" <c:if test="${basProductSku.picSmallFileId==small.fileUploadId}">selected="selected"</c:if>>${small.shortName}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="picSmallFileId" value="${basProductSku.picSmallFileId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>是否主产品:</td>
					<td><input type="text" name="productDefaultType" value="${basProductSku.productDefaultType}"/></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="保存"/>
	</form>
</body>
</html>