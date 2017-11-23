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
	<form action="${ctxPath}/admin/DictionaryAction.action?pageName=dictDetail&method=save${id}" method="post">
		<table>
			<tbody>
				<tr>
					<td>字典明细id:</td>
					<td>${basDictDetail.dictDetailId}</td>
				</tr>
				<tr>
					<td>数据字典id:</td>
					<td>
						<select name="dictId">
							<c:forEach items="${listBasDict}" var="basDict">
								<option value="${basDict.dictId}" <c:if test="${basDict.dictId==basDictDetail.dictId}">selected="selected"</c:if>>${basDict.dictCode}</option>
							</c:forEach>
						</select>
<%-- 						<input type="text" name="dictId" value="${basDictDetail.dictId}"/> --%>
					</td>
				</tr>
				<tr>
					<td>选项编码:</td>
					<td><input type="text" name="optionCode" value="${basDictDetail.optionCode}"/></td>
				</tr>
				<tr>
					<td>选项标签:</td>
					<td><input type="text" name="optionLabel" value="${basDictDetail.optionLabel}"/></td>
				</tr>
				<tr>
					<td>顺序号:</td>
					<td><input type="text" name="seqNum" value="${basDictDetail.seqNum}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>