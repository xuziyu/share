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
		var arrayBigId =new Array();
		var arrayId = new Array();
		var arrayName =new Array();
		var bigSelected = document.getElementById("big").value ;
		<c:forEach items="${listBasCategorySmall}" var="basCategorySmall">
			arrayBigId.push("${basCategorySmall.categoryBigId}")
			arrayId.push("${basCategorySmall.categorySmallId}")
			arrayName.push("${basCategorySmall.name}")
			array.push("${basCategorySmall}")
		</c:forEach>
		 document.getElementById("small").options.length=0;
		for(var i = 0;i<arrayId.length;i++){
			if(bigSelected==arrayBigId[i]){
				var optionObj = document.createElement("option");
				optionObj.value = arrayId[i]
				optionObj.innerHTML = arrayName[i];
				document.getElementById("small").appendChild(optionObj);
			}
		}
	}
</script>
</head>
<body>
	<form action="${ctxPath}/admin/ProductAction.action?pageName=product&method=save${id}" method="post">
		<table>
			<tbody>
				<tr>
					<td>产品id:</td>
					<td>${basProduct.productId}</td>
				</tr>
				<tr>
					<td>编号:</td>
					<td><input type="text" name="code" value="${basProduct.code}"/></td>
				</tr>
				<tr>
					<td>名称:</td>
					<td><input type="text" name="name" value="${basProduct.name}"/></td>
				</tr>
				<tr>
					<td>品牌id:</td>
					<td>
						<select name="brandId">
							<c:forEach items="${listBasBrand}" var="basBrand">
								<option value="${basBrand.brandId}" <c:if test="${basProduct.brandId==basBrand.brandId}">selected="selected"</c:if>>${basBrand.name}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="brandId" value="${basProduct.brandId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>产品大类id:</td>
					<td>
						<select name="categoryBigId" id="big"  onchange="onchange_province();">
							<c:forEach items="${listBasCategoryBig}" var="basCategoryBig">
								<option value="${basCategoryBig.categoryBigId}" <c:if test="${basProduct.categoryBigId==basCategoryBig.categoryBigId}">selected="selected"</c:if>>${basCategoryBig.name}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="categoryBigId" value="${basProduct.categoryBigId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>产品小类id:</td>
					<td>
						<select name="categorySmallId" id="small">
							<c:forEach items="${listBasCategorySmall}" var="basCategorySmall">
								<option value="${basCategorySmall.categorySmallId}" <c:if test="${listBasCategoryBig[0].categoryBigId==basCategorySmall.categoryBigId}">selected="selected"</c:if>>${basCategorySmall.name}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="categorySmallId" value="${basProduct.categorySmallId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>商品产地:</td>
					<td>
						<select name="productPlace">
							<option value="厦门" <c:if test="${basProduct.productPlace==厦门}"> selected="selected"</c:if>>厦门</option>
							<option value="广东" <c:if test="${basProduct.productPlace==广东}"> selected="selected"</c:if>>广东</option>
							<option value="深圳" <c:if test="${basProduct.productPlace==深圳}"> selected="selected"</c:if>>深圳</option>
							<option value="金华" <c:if test="${basProduct.productPlace==金华}"> selected="selected"</c:if>>金华</option>
						</select>
<%-- 					<input type="text" name="productPlace" value="${basProduct.productPlace}"/> --%>
					</td>
				</tr>
				<tr>
					<td>上市年份:</td>
					<td>
						<select name="marketYear">
							<option value="2017" <c:if test="${basProduct.marketYear== 2017}"> selected="selected"</c:if>>2017</option>
							<option value="2016" <c:if test="${basProduct.marketYear== 2016}"> selected="selected"</c:if>>2016</option>
							<option value="2015" <c:if test="${basProduct.marketYear== 2015}"> selected="selected"</c:if>>2015</option>
							<option value="2014" <c:if test="${basProduct.marketYear== 2014}"> selected="selected"</c:if>>2014</option>
						</select>
<%-- 						<input type="text" name="marketYear" value="${basProduct.marketYear}"/> --%>
					</td>
				</tr>
				<tr>
					<td>上市季节:</td>
					<td>
						<select name="marketSeason">
							<option value="1" <c:if test="${basProduct.marketSeason==1}"> selected="selected"</c:if>>春</option>
							<option value="2" <c:if test="${basProduct.marketSeason==2}"> selected="selected"</c:if>>夏</option>
							<option value="3" <c:if test="${basProduct.marketSeason==3}"> selected="selected"</c:if>>秋</option>
							<option value="4" <c:if test="${basProduct.marketSeason==4}"> selected="selected"</c:if>>冬</option>
						</select>
<%-- 					<input type="text" name="marketSeason" value="${basProduct.marketSeason}"/> --%>
					</td>
				</tr>
				<tr>
					<td>流行元素:</td>
					<td><input type="text" name="fashionElement" value="${basProduct.fashionElement}"/></td>
				</tr>
				<tr>
					<td>面料:</td>
					<td><input type="text" name="fabric" value="${basProduct.fabric}"/></td>
				</tr>
				<tr>
					<td>版型:</td>
					<td><input type="text" name="stereotype" value="${basProduct.stereotype}"/></td>
				</tr>
				<tr>
					<td>版型:</td>
					<td><input type="text" name="grossWeight" value="${basProduct.grossWeight}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>