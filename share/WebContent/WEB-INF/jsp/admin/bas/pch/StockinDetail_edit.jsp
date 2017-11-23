<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp" %> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建入库物品</title>
</head>
<body>
<c:choose>
	<c:when test="${empty  pchStockinDetail.stockinDetailId }">
		<c:set var="operation" value="insert" />
	</c:when>
	<c:otherwise>
		<c:set var="operation" value="update" />
	</c:otherwise>
</c:choose>

<form action="${ctxPath}/admin/StockinDetailAction.action?method=save" method="post">
		<input type="hidden" name="method" value="save" />
        <input type="hidden" name="stockinDetailId" value="${pchStockinDetail.stockinDetailId}"/>
    采购单ID <select  name="stockinId">
         	<c:forEach items="${pchstoList}" var="pchstoLists">
         		<option value="${pchstoLists.stockinId}" <c:if test="${pchstoLists.stockinId==pchStockinDetail.stockinId}">selected="selected" </c:if>>${pchstoLists.stockinId}</option>
         	</c:forEach>	
        </select><br/>
产品SKUID<select  name="productSkuId">
         	<c:forEach items="${listBasProductSku}" var="basProductSku">
         		<option value="${basProductSku.productSkuId}" <c:if test="${basProductSku.productSkuId==pchStockinDetail.productSkuId}">selected="selected" </c:if>>${basProductSku.barCode}</option>
         	</c:forEach>	
        </select><br/>    
<%--         产品SKUID<input type="text " name="productSkuId" value="${pchStockinDetail.productSkuId}"/><br/> --%>
       名称 <input type="text " name="name" value="${pchStockinDetail.name}"/><br/>
      数量 <input type="text " name="amount" value="${pchStockinDetail.amount}"/><br/>
      单价 <input type="text " name="price" value="${pchStockinDetail.price}"/><br/>      
     实际金额<input type="text " name="moneyReal" value="${pchStockinDetail.moneyReal}"/><br/>  
       备注 <input type="text " name="remark" value="${pchStockinDetail.remark}"/><br/>   

      
<input type="submit" value="保存" />
</form>
</body>
</html>