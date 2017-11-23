<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalOrderDetailLoad</title>
</head>
<body>
订单明细
订单明细ID：${salOrderDetail.orderDetailId }<br>
订单ID：${salOrderDetail.orderId }<br>
产品SKUID：${salOrderDetail.productSkuId } <br>
订单明细编码：${salOrderDetail.orderDetailCode }<br>
名称：${salOrderDetail.name } <br>
数量：${salOrderDetail.amount }<br>
单价：${salOrderDetail.price } <br>
备注：${salOrderDetail.remark }<br>
出库日期：${salOrderDetail.stockOutDate }<br>
物流状态：${salOrderDetail.logisticsStatus }<br>
物流到达日期：${salOrderDetail.logisticsArriveDate }<br>
物流签收日期：${salOrderDetail.logisticsSignDate }<br>
评价状态：${salOrderDetail.reviewStatus }<br>
<a href ="SalOrderDetailAction.Action?method=edit&orderDetailId=${salOrderDetail.orderDetailId }">修改</a>
<a href="salOrderDetailReviewAction.action?method=load&orderDetailId=${salOrderDetail.orderDetailId }">查看评价</a>&nbsp;&nbsp;&nbsp;
<a href="SalOrderDetailAction.Action?method=delete&orderDetailId=${salOrderDetail.orderDetailId }">删除</a>								
</body>
</html>