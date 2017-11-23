<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增或修改界面</title>
</head>
<body>
	<form action="${ctxPath}/admin/ProductAction.action?pageName=categorySmall&method=save${id}" method="post">
		<table>
			<tbody>
				<tr>
					<td>小类类id:</td>
					<td>${basCategorySmall.categorySmallId}</td>
				</tr>
				<tr>
					<td>大类id:</td>
					<td>
						<select name="categoryBigId">
							<c:forEach items="${listBasCategoryBig}" var="basCategoryBig">
								<option value="${basCategoryBig.categoryBigId}" <c:if test="${basCategorySmall.categoryBigId==basCategoryBig.categoryBigId}">selected="selected"</c:if>>${basCategoryBig.name}</option>
							</c:forEach>
						</select>				
<%-- 						<input type="text" name="categoryBigId" value="${basCategorySmall.categoryBigId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>名称:</td>
					<td><input type="text" name="name" value="${basCategorySmall.name}"/></td>
				</tr>
				<tr>
					<td>描述:</td>
					<td><input type="text" name="descr" value="${basCategorySmall.descr}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>