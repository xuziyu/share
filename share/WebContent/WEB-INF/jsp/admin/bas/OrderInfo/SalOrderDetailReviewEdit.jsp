<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalOrderDetailReviewEdit</title>
</head>
<body>
	<form action="salOrderDetailReviewAction.Action" id="form"> 
	<input type="hidden" name="method" value="save" /> 
	订单明细评价ID:<input type="text" name="orderDetailReviewId" value="${salOrderDetailReview.orderDetailReviewId }" readonly="readonly"/><br/>
	订单明细ID:<input type="text" value="${salOrderDetailReview.orderDetailId }" name="orderDetailId" readonly="readonly"><br/>
	评价等级:<input type="text" value="${salOrderDetailReview.reviewGrade }" name="reviewGrade"><br/>
	评价内容:<input type="text" value="${salOrderDetailReview.content }" name="content"><br/>
	创建日期:<input type="text" value="${salOrderDetailReview.createDate }" name="createDate"><br/>
	<input type="submit" value="保存"  />
	</form>
</body>
</html>