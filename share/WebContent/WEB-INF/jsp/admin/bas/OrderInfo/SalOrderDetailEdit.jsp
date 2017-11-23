<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalOrderDetailEdit</title>
</head>
<body>
	<form action="SalOrderDetailAction.action" id="form">
		<input type="hidden" name="method" value="save" />
		订单明细ID:<input type="text" name="orderDetailId" value="${salOrderDetail.orderDetailId }"readonly="readonly" /><br/>
		订单ID:<input type="text" name="orderId" value="${salOrderDetail.orderId }" readonly="readonly"/><br/>
		产品SKUID:<input type="text" name="productSkuId" value="${salOrderDetail.productSkuId }" /><br/>
		订单明细编码:<input type="text" name="orderDetailCode" value="${salOrderDetail.orderDetailCode }" /><br/>
		名称：<input type="text" name="name" value="${salOrderDetail.name }" /><br/>
		数量：<input type="text" name="amount" value="${salOrderDetail.amount }" /><br/>
		单价:<input type="text" name="price" value="${salOrderDetail.price }" /><br/>
		备注:<input type="text" name="remark" value="${salOrderDetail.remark }" /><br/>
		出库状态:<input type="text" name="stockOutStatus" value="${salOrderDetail.stockOutStatus }" /><br/>
		出库日期:<input type="text" name="stockOutDate" value="${salOrderDetail.stockOutDate }" /><br/>
		物流状态:<input type="text" name="logisticsStatus" value="${salOrderDetail.logisticsStatus }" /><br/>
		物流到达日期:<input type="text" name="logisticsArriveDate" value="${salOrderDetail.logisticsArriveDate }" /><br/>
		物流签收日期:<input type="text" name="logisticsSignDate" value="${salOrderDetail.logisticsSignDate }" /><br/>
		评价状态:<input type="text" name="reviewStatus" value="${salOrderDetail.reviewStatus }" /><br/>	
		<input type="submit" value="保存"  />		
	</form>
</body>
</html>