<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalOrderDetailReviewList</title>
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
	<form action="salOrderDetailReviewAction.Action" id="save"> 
	<input type="hidden" name="method" value="insert" /> 
	订单明细评价ID:<input type="text" name="orderDetailReviewId"  /><br/>
	订单明细ID:<input type="text"  name="orderDetailId"><br/>
	评价等级:<input type="text"  name="reviewGrade"><br/>
	评价内容:<input type="text"  name="content"><br/>
	<input type="submit" value="新建"  />
	</form>
	<form action="salOrderDetailReviewAction?method=pageList" id="form" method="post">
		<input type="hidden" name="pageIndex" id="pageIndex" value="${page.pageIndex }" /> 
		订单明细评价ID:<input type="text" name="orderDetailReviewId" value="${order_detail_review_id}" />&nbsp;
		订单明细ID:<input type="text"name="orderDetailId" value="${order_detail_id}" /><br>
		<a href = "salOrderDetailReviewAction.Action?method=edit">新建</a>
		<input type="button" value="查询" onclick="goPageIndex(0);" /> <br />
		<table border="1">
			<thead>
				<tr>
					<td>订单明细评价ID</td>
					<td>订单明细ID</td>
					<td>评价等级</td>
					<td>评价内容</td>
					<td>创建日期</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.result }" var="salOrderDetailReview">
					<tr>
						<td>${salOrderDetailReview.orderDetailReviewId }</td>
						<td>${salOrderDetailReview.orderDetailId } </td>
						<td>${salOrderDetailReview.reviewGrade } </td>
						<td>${salOrderDetailReview.content }</td>
						<td>${salOrderDetailReview.createDate } </td>
						<td>
						<a href ="salOrderDetailReviewAction.action?method=edit&orderDetailReviewId=${salOrderDetailReview.orderDetailReviewId }">修改</a>&nbsp;&nbsp;&nbsp;
						<a href="salOrderDetailReviewAction.action?method=load&orderDetailReviewId=${salOrderDetailReview.orderDetailReviewId }">查看</a>
						<a href="salOrderDetailReviewAction.action?method=delete&orderDetailReviewId=${salOrderDetailReview.orderDetailReviewId }">删除</a>
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