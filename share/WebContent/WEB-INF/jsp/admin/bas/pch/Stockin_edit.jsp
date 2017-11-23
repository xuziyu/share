 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建入库物品</title>
</head>
<body>
<c:choose>
	<c:when test="${empty  pchStockin.stockinId}">
		<c:set var="operation" value="insert" />
	</c:when>
	<c:otherwise>
		<c:set var="operation" value="update" />
	</c:otherwise>
</c:choose>

<form action="${ctxPath}/admin/StockinsysAction.action?method=save" method="post">
		<input type="hidden" name="method" value="save" />
        <input type="hidden" name="stockinId" value="${pchStockin.stockinId}"/>
    
      供应商ID <select  name="supplierId">
         	<c:forEach items="${listbsBasSuppliers}" var="bsBasSuppliers">
         		<option value="${bsBasSuppliers.supplierId}" <c:if test="${bsBasSuppliers.supplierId==pchStockin.supplierId}">selected="selected" </c:if>>${bsBasSuppliers.name}</option>
         	</c:forEach>	
        </select><br/> 
        采购日期<input type="text " name="purchaseDate" value="${pchStockin.purchaseDate}"/><br/>
        采购金额 <input type="text " name="tatalMoney" value="${pchStockin.tatalMoney}"/><br/>
        本次付款金额 <input type="text " name="thisPayMoney" value="${pchStockin.thisPayMoney}"/><br/>   
        单据状态<input type="text " name="billStatus" value="${pchStockin.billStatus}"/><br/>  
        付款状态  <input type="text " name="payStatus" value="${pchStockin.payStatus}"/><br/>   
      创建员工ID <select  name="createEmployeeId">
         	<c:forEach items="${lisBasCustomers}" var="basCustomers">
         		<option value="${basCustomers.customerId}" <c:if test="${basCustomers.customerId==pchStockin.createEmployeeId}">selected="selected" </c:if>>${basCustomers.code}</option>
         	</c:forEach>	
        </select><br/> 
        创建日期<input type="text " name="createDatetime" value="${pchStockin.createDatetime}"/><br/>
      
<input type="submit" value="保存" />
</form>
</body>
</html>