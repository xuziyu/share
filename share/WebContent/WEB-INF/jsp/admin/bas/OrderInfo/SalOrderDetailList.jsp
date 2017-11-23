<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalOrderDetailList</title>
<script type="text/javascript">
	function gid(id) {
		return document.getElementById(id);
	}
	function goPageIndex(index) {
		gid("pageIndex").value = index;
		gid("form").submit();
	}
</script>
</head>
<body>
	<form action="SalOrderDetailAction.Action" id="save">
	<input type="hidden" name="method" value="insert" />
		订单明细ID:<input type="text" name="orderDetailId"  /><br/>
		订单ID:<input type="text" name="orderId"  /><br/>
		产品SKUID:<input type="text" name="productSkuId"  /><br/>
		订单明细编码:<input type="text" name="orderDetailCode"  /><br/>
		名称：<input type="text" name="name"  /><br/>
		数量：<input type="text" name="amount"  /><br/>
		单价:<input type="text" name="price"  /><br/>
		备注:<input type="text" name="remark"  /><br/>
		出库状态:<input type="text" name="stockOutStatus"  /><br/>
		出库日期:<input type="text" name="stockOutDate"  /><br/>
		物流状态:<input type="text" name="logisticsStatus"  /><br/>
		物流到达日期:<input type="text" name="logisticsArriveDate"  /><br/>
		物流签收日期:<input type="text" name="logisticsSignDate"  /><br/>
		评价状态:<input type="text" name="reviewStatus"  /><br/>	
		<input type="submit" value="新建"  />		
	</form>
	<form action="SalOrderDetailAction.Action?method=pageList" id="form" method="post">
		<input type="hidden" name="pageIndex" id="pageIndex" value="${page.pageIndex }" /> 
		订单明细ID:<input type="text" name="orderDetailId" value="${order_detail_id}" />&nbsp;
		订单ID:<input type="text" name="orderId" value="${order_id}" /><br>
		<a href = "SalOrderDetailAction.Action?method=edit">新建</a>
		<input type="button" value="查询" onclick="goPageIndex(0);" /> <br />
		<table border="1">
			<thead>
				<tr>
					<td>订单明细ID</td>
					<td>订单ID</td>
					<td>产品SKUID</td>
					<td>订单明细编码</td>
					<td>名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>备注</td>
					<td>出库状态</td>
					<td>出库日期</td>
					<td>物流状态</td>
					<td>物流到达日期</td>
					<td>物流签收日期</td>
					<td>评价状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.result }" var="salOrderDetail">
					<tr>
						<td>${salOrderDetail.orderDetailId }</td>
						<td>${salOrderDetail.orderId } </td>
						<td>${salOrderDetail.productSkuId } </td>
						<td>${salOrderDetail.orderDetailCode }</td>
						<td>${salOrderDetail.name } </td>
						<td>${salOrderDetail.amount }</td>
						<td>${salOrderDetail.price } </td>
						<td>${salOrderDetail.remark }</td>
						<td>${salOrderDetail.stockOutStatus }</td>
						<td>${salOrderDetail.stockOutDate }</td>
						<td>${salOrderDetail.logisticsStatus }</td>
						<td>${salOrderDetail.logisticsArriveDate }</td>
						<td>${salOrderDetail.logisticsSignDate }</td>
						<td>${salOrderDetail.reviewStatus }</td>		
						<td>
						<a href ="SalOrderDetailAction.Action?method=edit&orderDetailId=${salOrderDetail.orderDetailId }">修改</a>&nbsp;&nbsp;&nbsp;
						<a href="salOrderDetailReviewAction.action?method=load&orderDetailId=${salOrderDetail.orderDetailId }">查看评价</a>&nbsp;&nbsp;&nbsp;
						<a href="SalOrderDetailAction.Action?method=delete&orderDetailId=${salOrderDetail.orderDetailId }">删除</a>
						</td>		
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<c:forEach begin="0" end="${page.pageCount-1 }" varStatus="status">
			<a href="javascript:goPageIndex(${status.index});">${status.index+1 }</a>
		</c:forEach>

		<select name="pageSize" id="pageSize" onchange="javascript:goPageIndex(0);">
			<option value="5"
				<c:if test="${page.pageSize== 5}"> selected="selected"</c:if>>5</option>
			<option value="10"
				<c:if test="${page.pageSize== 10}"> selected="selected"</c:if>>10</option>
			<option value="100"
				<c:if test="${page.pageSize== 100}"> selected="selected"</c:if>>100</option>
		</select>
	 </form>

</body>
</html>