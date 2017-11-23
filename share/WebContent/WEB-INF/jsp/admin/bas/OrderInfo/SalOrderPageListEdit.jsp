<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalOrderPageListEdit</title>
</head>
<body>
	<form action="OrderInfoAction.action" id="form"> 
	<input type="hidden" name="method" value="save" /> 
	订单ID：<input type="text" name="orderId" value="${salOrder.orderId }" readonly="readonly"/><br/>
	顾客ID:<input type="text" value="${salOrder.customerId }" name="customerId" readonly="readonly"><br/>
	订单编码:<input type="text" value="${salOrder.orderCode }" name="orderCode" readonly="readonly"><br/>
	总金额:<input type="text" value="${salOrder.tatalMoney }" name="tatalMoney" ><br/>
	优惠率:<input type="text" value="${salOrder.discountRate }" name="discountRate"><br/>
	实付金额：<input type="text" value="${salOrder.actualTatalMoney }" name="actualTatalMoney"><br/>
	付款日期：<input type="text" value="${salOrder.payDate }"  name="payDate"><br/>
	创建日期：<input type="text" value="${salOrder.createDatetime }" name="createDatetime"><br/>
	付款状态：<input type="text" name="payStatus"value="${salOrder.payStatus }"><br/>
	<input type="submit" value="保存"  />&nbsp;&nbsp;&nbsp;
	</form>
</body>
</html>