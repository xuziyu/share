<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>我的购物车 —— 乐享商城</title>
    </head>
    <body>
    	我的购物车
		<table border="1">
			<thead>
				<tr>
					<td>商品</td>
					<td>单价</td>
					<td>小计</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.result }" var="salOrderVO">
					<tr>
						<td>${salOrderVO.name }</td>
						<td>${salOrderVO.price } </td>
						<td>${salOrderVO.price } </td>
						<td>
						<a href="">删除</a><br />
						<a href="SalOrderAction.Action?method=gopay&">去结算</a>
						</td>		
					</tr>
				</c:forEach>
			</tbody>
		</table>
 	</body>
</html>