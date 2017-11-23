<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalOrderDetailReviewLoad</title>
</head>
<body>
订单明细评价 
订单明细评价ID:${salOrderDetailReview.orderDetailReviewId }<br>
订单明细ID:${salOrderDetailReview.orderDetailId }<br>
评价等级:${salOrderDetailReview.reviewGrade } <br>
评价内容:${salOrderDetailReview.content }<br>
创建日期：${salOrderDetailReview.createDate } 
<a href ="salOrderDetailReviewAction.action?method=edit&orderDetailReviewId=${salOrderDetailReview.orderDetailReviewId }">修改</a>&nbsp;&nbsp;&nbsp;
<a href="salOrderDetailReviewAction.action?method=delete&orderDetailReviewId=${salOrderDetailReview.orderDetailReviewId }">删除</a>
</body>
</html>