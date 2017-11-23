<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${ctxPath}/admin/StockinsysAction.action?method=edit">新增</a><br/>
<table border="1">
	<thead>
		<tr>
        <th>入库单ID</th>
	 			<th>供应商ID</th>
	 			<th>采购日期</th>
	 			 <th>采购金额</th>
	 			<th>本次付款金额</th>
	 			<th>单据状态</th>
	 			<th>付款状态</th> 
	 			<th>创建员工ID</th>
	 			<th>创建日期</th>     
		</tr>
	</thead>
	
	<tbody>
<c:forEach items="${pchStockin }" var="pchStockin">
		<tr>
                <td>${pchStockin.stockinId }</td>
	 		 	<td>${pchStockin.supplierId }</td>
	 		 	<td>${pchStockin.purchaseDate }</td>
	 		    <td>${pchStockin.tatalMoney }</td>
	 		 	<td>${pchStockin.thisPayMoney }</td>
	 		 	<td>${pchStockin.billStatus }</td>
	 		 	<td>${pchStockin.payStatus }</td> 
	 		 	<td>${pchStockin.createEmployeeId }</td>
	 		 	<td>${pchStockin.createDatetime }</td>
				<a href="${ctxPath}/admin/StockinsysAction.action?method=edit&stockinId=${pchStockin.stockinId}">修改</a>&nbsp;&nbsp;&nbsp;
				<a href="${ctxPath}/admin/StockinsysAction.action?method=delete&stockinId=${pchStockin.stockinId}">删除</a></td>
		</tr>
</c:forEach>
	</tbody>
</table>
</body>
</html>