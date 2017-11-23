<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商管理</title>
</head>
<body>
<a href="${ctxPath}/admin/SupplierAction.action?pageName=Supplier&method=edit">新增</a>
<form action="${ctxPath}/admin/SupplierAction.action?pageName=Supplier" id="form" method="post">
	<input type="hidden" id="pageIndex" name="pageIndex" value=""/>
	供应商ID：<input type="text" name="supplierId"/></br>
	编号：<input type="text" name="code"/></br>
	名称：<input type="text" name="name"/></br>
	应收款：<input type="text" name="needPayMoney"/></br>
	联系人姓名：<input type="text" name="contactName"/></br>
	联系人电话：<input type="text" name="contactMobile"/></br>
	地址：<input type="text" name="address"/></br>
	<input type="button" value="查询" onclick="goPageIndex(0);"/>
	<table>
		<thead>
			<tr>
				<th>供应商ID</th>
				<th>编号</th>
				<th>名称</th>
				<th>应收款</th>
				<th>联系人姓名</th>
				<th>联系人电话</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="supplier">
			<tr>
				<td>${supplier.supplierId}</td>
				<td>${supplier.code}</td>
				<td>${supplier.name}</td>
				<td>${supplier.needPayMoney}</td>
				<td>${supplier.contactName}</td>
				<td>${supplier.contactMobile}</td>
				<td>${supplier.address}</td>
				<td>
					<a href="${ctxPath}/admin/SupplierAction.action?pageName=Supplier&method=edit&id=${supplier.supplierId}" >修改</a>
					<a href="${ctxPath}/admin/SupplierAction.action?pageName=Supplier&method=delete&id=${supplier.supplierId}" >删除</a>
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