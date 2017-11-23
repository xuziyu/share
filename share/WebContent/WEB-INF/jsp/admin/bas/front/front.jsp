<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
</head>
<body>
	employee_id:${employeeId}<br>
	code:${dbCode}<br>
	<a href="/share/AdminLoginAction.action?xxx=zhuxiao">注销</a>
	<table>
			<tr>
				<td>用户管理</td>	  	
				<td>供应商管理</td>
				<td>商品管理</td>	
				<td>订单管理</td>	
				<td>采购管理</td>	
				<td>系统管理</td>																											
			</tr>

			<tr>
				<td><a href="/share/admin/CustomerAction.action">用户查询</a></td>
				<td><a href="/share/admin/SupplierAction.action">供应商查询</a></td>
				<td><a href="/share/admin/ProductAction.action?pageName=brand">产品品牌</a></td>
				<td><a href="/share/admin/OrderInfoAction.action">订单查询</a></td>
				<td><a href="/share/admin/StockinsysAction.action">入库单查询</a></td>																		
				<td><a href="/share/admin/SysModuleAction.action">模块修改</a></td>
			</tr>
			
			<tr>
				<td><a href="/share/admin/CartAction.action">购物车查询</a></td>
				<td><a href=""></a></td>
				<td><a href="/share/admin/ProductSKUAction.action?pageName=skuSize">产品尺寸</a></td>
				<td><a href="/share/admin/SalOrderDetailAction.Action">查看明细</a></td>
				<td><a href="/share/admin/StockinDetailAction.action">入库明细</a></td>																		
				<td><a href="/share/admin/SysMenuAction.action">菜单管理</a></td>
				<td><a href=""></a></td>																		
			</tr>
			
			<tr>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href="/share/admin/ProductSKUAction.action?pageName=skuColor">产品颜色</a></td>
				<td><a href="/share/admin/salOrderDetailReviewAction.action">查看评价</a></td>
				<td><a href=""></a></td>																		
				<td><a href="/share/admin/SysEmployeeRoleAction.action">角色管理</a></td>
				<td><a href=""></a></td>																		
			</tr>

			<tr>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href="/share/admin/ProductAction.action?pageName=categoryBig">商品大类</a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>																		
				<td><a href="/share/admin/OrganizationAction.action">组织结构</a></td>
				<td><a href=""></a></td>																		
			</tr>

			<tr>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href="/share/admin/ProductAction.action?pageName=categorySmall">商品小类</a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>																		
				<td><a href="/share/admin/AdminAction.action">员工管理</a></td>
				<td><a href=""></a></td>																		
			</tr>

			<tr>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href="/share/admin/ProductAction.action?pageName=product">产品</a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>																		
				<td><a href="/share/admin/SysRoleAction.action">角色</a></td>
				<td><a href=""></a></td>																		
			</tr>
			<tr>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href="/share/admin/ProductAction.action?pageName=productSKU">产品sku</a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>																		
				<td><a href="/share/admin/SysRoleMenuAction.action">菜单</a></td>
				<td><a href=""></a></td>																		
			</tr>

			<tr>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>																		
				<td><a href="/share/admin/DictionaryAction.action?pageName=dict">数据字典</a></td>
				<td><a href=""></a></td>																		
			</tr>

			<tr>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>																		
				<td><a href="/share/admin/DictionaryAction.action?pageName=dictDetail">数据字典明细</a></td>
				<td><a href=""></a></td>																		
			</tr>
			
			<tr>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>
				<td><a href=""></a></td>																		
				<td><a href="/share/admin/ProductSKUAction.action?pageName=fileUpload">文件上传</a></td>																	
			</tr>
	</table>
	<br/>
</body>
</html>