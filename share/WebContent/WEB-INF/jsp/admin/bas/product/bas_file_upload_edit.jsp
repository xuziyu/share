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
	<form action="${ctxPath}/admin/ProductSKUAction.action?pageName=fileUpload&method=save${id}" method="post" enctype="multipart/form-data" >
		<table>
			<tbody>
				<tr>
					<td>文件上传id:</td>
					<td>${basFileUpload.fileUploadId}</td>
				</tr>
				<tr>
					<td>规格:</td>
					<td>
						<select name="fileSpec">
							<option value="0" <c:if test="${basFileUpload.fileSpec}==0">selected="selected"</c:if>>原始</option>
							<option value="1" <c:if test="${basFileUpload.fileSpec}==1">selected="selected"</c:if>>大</option>
							<option value="2" <c:if test="${basFileUpload.fileSpec}==2">selected="selected"</c:if>>中</option>
							<option value="3" <c:if test="${basFileUpload.fileSpec}==3">selected="selected"</c:if>>小</option>
						</select>
<%-- 						<input type="text" name="fileSpec" value="${basFileUpload.fileSpec}"/> --%>
					</td>
				</tr>
				<tr>
					<td>完整路径:</td>
					<td><input type="file" name="fullPath" value="${basFileUpload.fullPath}"/></td>
				</tr>
				<tr>
					<td>文件名:</td>
					<td><input type="text" name="shortName" value="${basFileUpload.shortName}"/></td>
				</tr>
				<tr>
					<td>扩展名:</td>
					<td><input type="text" name="extName" value="${basFileUpload.extName}"/></td>
				</tr>
				<tr>
					<td>大小:</td>
					<td><input type="text" name="fileSize" value="${basFileUpload.fileSize}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>