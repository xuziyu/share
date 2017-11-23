<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
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
<a href="${ctxPath}/admin/CartAction.action?method=edit">新增</a>
<form action="${ctxPath}/admin/CartAction.action" id="form" method="post">
	<input type="hidden" id="pageIndex" name="pageIndex" value=""/>
	客户ID:<input type="text" name="customerId" value=""/>
	产品skuid：<input type="text" name="productSkuId"/>
	创建日期：<input type="text" name="createDate"/>	
	<input type="button" value="查询" onclick="goPageIndex(0);"/>
	<table>
		<thead>
			<tr>
				<th>购物车ID</th>
				<th>客户名称</th>
				<th>产品条码</th>
				<th>创建日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="crtCart">
			<tr>
				<th>${crtCart.cartId}</th>
				<td>${crtCart.customerName}</td>
				<td>${crtCart.barCode}</td>
				<td>${crtCart.createDate}</td>
				<td>
					<a href="${ctxPath}/admin/CartAction.action?method=edit&id=${crtCart.cartId}" >修改</a>
					<a href="${ctxPath}/admin/CartAction.action?method=delete&id=${crtCart.cartId}" >删除</a>
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