<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品sku</title>
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
<a href="${ctxPath}/admin/ProductAction.action?pageName=productSKU&method=edit">新增</a>
<form action="${ctxPath}/admin/ProductAction.action?pageName=productSKU" id="form" method="post">
	<input type="hidden" id="pageIndex" name="pageIndex" value=""/>
	产品ID：<input type="text" name="productId"/>
	颜色ID：<input type="text" name="skuColorId"/>
	尺寸ID：<input type="text" name="skuSizeId"/>
	条码：<input type="text" name="barCode"/>
	实际价格：<input type="text" name="priceReal"/>
	原价：<input type="text" name="priceOld"/>
	成本价：<input type="text" name="priceCost"/>
	预计进价：<input type="text" name="pricePlanPurchase"/>
	库存数量：<input type="text" name="amountStock"/>
	初始数量：<input type="text" name="amountInit"/>
	最低库存数量：<input type="text" name="amountMinStock"/>
	最高库存数量：<input type="text" name="amountMaxStock"/>
	原图FileId：<input type="text" name="picOriFileId"/>
	大FileId：<input type="text" name="picBigFileId"/>
	中FileId：<input type="text" name="picMiddleFileId"/>
	小图FileId：<input type="text" name="picSmallFileId"/>
	是否主产品：<input type="text" name="productDefaultType"/>	
	<input type="button" value="查询" onclick="goPageIndex(0);"/>
	<table>
		<thead>
			<tr>
				<th>产品SKUID</th>
				<th>产品</th>
				<th>颜色</th>
				<th>尺寸</th>
				<th>条码</th>
				<th>实际价格</th>
				<th>原价</th>
				<th>成本价</th>
				<th>预计进价</th>
				<th>库存数量</th>
				<th>初始数量</th>
				<th>最低库存数量</th>
				<th>最高库存数量</th>
				<th>原图FileId</th>
				<th>大FileId</th>
				<th>中FileId</th>
				<th>小图FileId</th>
				<th>是否主产品</th>
				
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="basProductSku">
			<tr>
				<th>${basProductSku.productSkuId}</th>
				<th>${basProductSku.productName}</th>
				<th>${basProductSku.colorName}</th>
				<th>${basProductSku.sizeName}</th>
				<th>${basProductSku.barCode}</th>
				<th>${basProductSku.priceReal}</th>
				<th>${basProductSku.priceOld}</th>
				<th>${basProductSku.priceCost}</th>
				<th>${basProductSku.pricePlanPurchase}</th>
				<th>${basProductSku.amountStock}</th>
				<th>${basProductSku.amountInit}</th>
				<th>${basProductSku.amountMinStock}</th>
				<th>${basProductSku.amountMaxStock}</th>
				<th>${basProductSku.picOriFileId}</th>
				<th>${basProductSku.picBigFileId}</th>
				<th>${basProductSku.picMiddleFileId}</th>
				<th>${basProductSku.picSmallFileId}</th>
				<th>${basProductSku.productDefaultType}</th>
				<td>
					<a href="${ctxPath}/admin/ProductAction.action?pageName=productSKU&method=edit&id=${basProductSku.productSkuId}" >修改</a>
					<a href="${ctxPath}/admin/ProductAction.action?pageName=productSKU&method=delete&id=${basProductSku.productSkuId}" >删除</a>
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