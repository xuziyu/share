<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>
</head>
<body>
<a href="${ctxPath}/admin/StockinDetailAction.action?method=edit">新增</a><br/>
<table border="1">
	<thead>
		<tr>
	 			<th>入库明细ID</th>
	 			<th>采购单ID</th>
	 			<th>产品SKUID</th>
	 			 <th>名称</th>
	 			<th>数量</th>
	 			<th>单价</th>
	 			<th>实际金额</th> 
	 			<th>备注</th>
	 			<th>功能</th>
	 			
	 		</tr>
	 	</thead>
	 	<tbody>
	 	 <c:forEach items="${page.result}"  var="pchStockinDetail">
	 		<tr>
	 		 	<td>${pchStockinDetail.stockinDetailId }</td>
	 		 	<td>${pchStockinDetail.stockinId }</td>
	 		 	<td>${pchStockinDetail.productSkuId }</td>
	 		 	 <td>${pchStockinDetail.name }</td>
	 		 	<td>${pchStockinDetail.amount }</td>
	 		 	<td>${pchStockinDetail.price }</td>
	 		 	<td>${pchStockinDetail.moneyReal}</td> 
	 		 	<td>${pchStockinDetail.remark}</td>
	 		 
	 		 	<td>
	 		 	<a href="${ctxPath}/admin/StockinDetailAction.action?method=edit&stockinDetailId=${pchStockinDetail.stockinDetailId}">修改</a>&nbsp;&nbsp;&nbsp;
				<a href="${ctxPath}/admin/StockinDetailAction.action?method=delete&stockinDetailId=${pchStockinDetail.stockinDetailId}">删除</a></td>
	 		</tr>
</c:forEach>
	</tbody>
</table>
</body>
</html>