<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalOrderPageList</title>
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
    <form action="OrderInfoAction.action?method=insert" id="save"> 
	<input type="hidden" name="method" value="insert" /> 
	订单ID：<input type="text" name="orderId"  /><br/>
	顾客ID:<input type="text" name="customerId"><br/>
	订单编码:<input type="text" name="orderCode"><br/>
	总金额:<input type="text" name="tatalMoney"><br/>
	优惠率:<input type="text" name="discountRate"><br/>
	实付金额：<input type="text" name="actualTatalMoney"><br/>
	付款日期：<input type="text" name="payDate"><br/>
	创建日期：<input type="text" name="createDatetime"><br/>
	付款状态：<select name="payStatus"> 
	<option>0</option>
	<option>1</option>
	</select><br/>
	<input type="submit" value="新建"  />
	</form>
	<a href="SalOrderVOAction.Action?method=insertall" >新建全部</a>
	
	<form action="OrderInfoAction.action?method=pageList" id="form" method="post">
		<input type="hidden" name="pageIndex" id="pageIndex" value="${page.pageIndex }" /> 
		订单ID:<input type="text" name="orderId"  />&nbsp;
		顾客ID:<input type="text"name="customerId"  /><br>
		<input type="button" value="查询" onclick="goPageIndex(0);" /> <br />
		<table border="1">
			<thead>
				<tr>
					<td>订单ID</td>
					<td>顾客ID</td>
					<td>订单编码</td>
					<td>总金额</td>
					<td>优惠率</td>
					<td>实付金额</td>
					<td>付款日期</td>
					<td>创建日期</td>
					<td>付款状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.result }" var="salOrder">
					<tr>
						<td>${salOrder.orderId }</td>
						<td>${salOrder.customerId } </td>
						<td>${salOrder.orderCode } </td>
						<td>${salOrder.tatalMoney }</td>
						<td>${salOrder.discountRate } </td>
						<td>${salOrder.actualTatalMoney }</td>
						<td>${salOrder.payDate } </td>
						<td>${salOrder.createDatetime }</td>
						<td>${salOrder.payStatus }</td>
						<td>
						<a href ="OrderInfoAction.action?method=edit&orderId=${salOrder.orderId }">修改</a>&nbsp;&nbsp;&nbsp;
						<a href ="SalOrderVOAction.Action?method=joinselect&orderId=${salOrder.orderId }">查看详情</a>&nbsp;&nbsp;&nbsp;
						<a href="SalOrderDetailAction.Action?method=load&orderId=${salOrder.orderId }">查看明细</a>&nbsp;&nbsp;&nbsp;
						<a href="OrderInfoAction.action?method=delete&orderId=${salOrder.orderId }">删除</a>
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