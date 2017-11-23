<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品</title>
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
<a href="${ctxPath}/admin/ProductAction.action?pageName=product&method=edit">新增</a>
<form action="${ctxPath}/admin/ProductAction.action?pageName=product" id="form" method="post">
	<input type="hidden" id="pageIndex" name="pageIndex" value=""/>
	编号：<input type="text" name="code"/>	
	名称：<input type="text" name="name"/>
	品牌id：<input type="text" name="brandId"/>
	产品大类id：<input type="text" name="categoryBigId"/>
	产品小类id：<input type="text" name="categorySmallId"/>
	商品产地：<input type="text" name="productPlace"/>
	上市年份：<input type="text" name="marketYear"/>
	上市季节：<input type="text" name="marketSeason"/>
	流行元素：<input type="text" name="fashionElement"/>
	面料：<input type="text" name="fabric"/>
	版型：<input type="text" name="stereotype"/>
	毛重：<input type="text" name="grossWeight"/>
	<input type="button" value="查询" onclick="goPageIndex(0);"/>
	<table>
		<thead>
			<tr>
				<th>产品ID</th>
				<th>编号</th>
				<th>名称</th>
				<th>品牌</th>
				<th>产品大类</th>
				<th>产品小类</th>
				<th>商品产地</th>
				<th>上市年份</th>
				<th>上市季节</th>
				<th>流行元素</th>
				<th>面料</th>
				<th>版型</th>
				<th>毛重</th>

				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="basProduct">
			<tr>
				<th>${basProduct.productId}</th>
				<th>${basProduct.code}</th>
				<th>${basProduct.name}</th>
				<th>${basProduct.brandName}</th>
				<th>${basProduct.bigName}</th>
				<th>${basProduct.smallName}</th>
				<th>${basProduct.productPlace}</th>
				<th>${basProduct.marketYear}</th>
				<th>${basProduct.marketSeason}</th>
				<th>${basProduct.fashionElement}</th>
				<th>${basProduct.fabric}</th>
				<th>${basProduct.stereotype}</th>
				<th>${basProduct.grossWeight}</th>
				<td>
					<a href="${ctxPath}/admin/ProductAction.action?pageName=product&method=edit&id=${basProduct.productId}" >修改</a>
					<a href="${ctxPath}/admin/ProductAction.action?pageName=product&method=delete&id=${basProduct.productId}" >删除</a>
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