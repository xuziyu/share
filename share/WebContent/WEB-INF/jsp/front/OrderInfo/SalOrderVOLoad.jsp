<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalOrderVOLoad</title>
</head>
<body>
订单详情
订单ID：${salOrderVO.orderId }<br>
顾客ID:${salOrderVO.customerId } <br>
订单编码:${salOrderVO.orderCode }<br>
总金额:${salOrderVO.tatalMoney }<br>
优惠率:${salOrderVO.discountRate }<br>
实付金额：${salOrderVO.actualTatalMoney }<br>
付款日期："${salOrderVO.payDate }<br>
创建日期：${salOrderVO.createDatetime }<br>
付款状态：${salOrderVO.payStatus }<br>
订单明细ID：${salOrderVO.orderDetailId }<br>
产品SKUID：${salOrderVO.productSkuId } <br>
订单明细编码：${salOrderVO.orderDetailCode }<br>
名称：${salOrder.name } <br>
数量：${salOrderVO.amount }<br>
单价：${salOrderVO.price } <br>
备注：${salOrderVO.remark }<br>
出库日期：${salOrderVO.stockOutDate }<br>
物流状态：${salOrderVO.logisticsStatus }<br>
物流到达日期：${salOrderVO.logisticsArriveDate }<br>
物流签收日期：${salOrderVO.logisticsSignDate }<br>
评价状态：${salOrderDetail.reviewStatus }<br>
订单明细评价ID:${salOrderVO.orderDetailReviewId }<br>
评价等级:${salOrderVO.reviewGrade } <br>
评价内容:${salOrderVO.content }<br>
创建日期：${salOrderVO.createDate } <br>
</body>
</html>