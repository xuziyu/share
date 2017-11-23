<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货物入库管理</title>
<script type="text/javascript">
   function gid(id){
	   return document.getElementById(id);
	  // return document.getElementById(id) 	  
   }
   function goPageIndex(index){
	   gid("pageIndex").value=index;
	   gid("form").submit();
   }

</script>
</head>
<body>
	<a href="${ctxPath}/admin/StockinsysAction.action?method=edit">新增</a><br/>
	
	<form action="${ctxPath}/admin/StockinsysAction.action?method=pageList" method="post"id="form">
	<input type="hidden" name="pageIndex" id="pageIndex" value="${page.pageIndex}" }/>
	操作者：员工ID<input type="text " name="createEmployeeId" value="${createEmployeeId}"/><br/>
	<input type="button" value="查询" onclick="goPageIndex(0);" /><br/>
	<table border="1 px">
	 	<thead>
	 		<tr>
	 			<th>入库单ID</th>
	 			<th>供应商ID</th>
	 			<th>采购日期</th>
	 			 <th>采购金额</th>
	 			<th>本次付款金额</th>
	 			<th>单据状态(0——未审核，1——已审核）</th>
	 			<th>付款状态(0——未付款，1——部分付款，2——已结清)</th> 
	 			<th>创建员工ID</th>
	 			<th>创建日期</th>
	 			<th>功能</th>
	 			
	 		</tr>
	 	</thead>
	 	<tbody>
	 	 <c:forEach items="${page.result}"  var="pchStockin">
	 		<tr>
	 		 	<td>${pchStockin.stockinId }</td>
	 		 	<td>${pchStockin.name }</td>
	 		 	<td>${pchStockin.purchaseDate }</td>
	 		 	<td>${pchStockin.tatalMoney }</td>
	 		 	<td>${pchStockin.thisPayMoney }</td>
	 		 	<td>${pchStockin.billStatus }</td>
	 		 	<td>${pchStockin.payStatus }</td> 
	 		 	<td>${pchStockin.code }</td>
	 		 	<td>${pchStockin.createDatetime }</td>
	 		 	<td>
	 		 	<a href="${ctxPath}/admin/StockinsysAction.action?method=edit&stockinId=${pchStockin.stockinId}">修改</a>&nbsp;&nbsp;&nbsp;
				<a href="${ctxPath}/admin/StockinsysAction.action?method=delete&stockinId=${pchStockin.stockinId}">删除</a></td>
	 		</tr>
	 	</c:forEach> 
	 	</tbody> 
	</table>
	<br/>
	<c:forEach begin="0" end="${page.pageCount-1 }" varStatus="status">
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