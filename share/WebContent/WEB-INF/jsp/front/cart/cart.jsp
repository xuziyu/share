<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/share/resource/front/css/crtcart.css" />
<title>购物车</title>
</head>
<body>
	<form action="/share/front/CartfAction.action?method=save" method="post">
		<div style=" width: 100%;">
			<div id="daohang" style="width: 100%;margin: auto;background-color: rgb(227,228,229);height: 30px;padding-top: 8px;">								
				<div style="float: left;margin-left: 200px;">
						<a href="/share/front/WomenAction.action" style="text-decoration:none;color: gray;" class="daohang_a">
							首页						
						</a>
					</div>
				<div style="margin-left: 20px;float: left;">
						<a href="#" style="text-decoration:none;color: gray;" class="daohang">
							北京							
						</a>
					</div>
				<div style="margin-left: 400px;float: left;">
						<a href="/share/front/LoginfAction.action" style="text-decoration:none;color: gray;" class="daohang_a">
							登录ｖ
						</a>	
					</div>
				<div style="margin-left: 20px; float: left;">
						<a href="/share/SalOrderAction.Action" style="text-decoration:none;color: gray;" class="daohang_a">
							丨我的订单丨
						</a>
					</div>
				<div style="margin-left: 20px; float: left;">
						<a href="/share/front/WomenAction.action" style="text-decoration:none;color: gray;" class="daohang_a">
							乐享商城ｖ
						</a>	
					</div>
				<div style="margin-left: 20px; float: left;">
						<a href="/share/front/WomenAction.action" style="text-decoration:none;color: gray;" class="daohang_a">
							丨乐享会员丨
						</a>
					</div>
				<div style="margin-left: 30px; float: left;">
						<a href="/share/front/WomenAction.action" style="text-decoration:none;color: gray;" class="daohang_a">
							网址导航ｖ丨
						</a>
					</div>
				<div style="margin-left: 30px; float: left;">
						<a href="#" style="text-decoration:none;color: gray;" class="daohang_a">
							手机乐享
						</a>
					</div>
				<div style="margin-left: 45px; float: left;">
						<a href="#" style="text-decoration:none;color: gray;" class="daohang_a">
							其他
						</a>
					</div>
				<div style="clear: both;"></div>
			</div>
		
            <div style="width: 1200px;margin: auto;padding-top: 30px;">
            	<div>
            		<marquee><b style="font-size: 18px;color: red;">欢迎来到的购物车</b></marquee>
            	</div>
            	<div style="float: left;">
            		<a href="/share/front/SerachPageAction.action"><img src="/share/resource/front/image/logo.jpg"></a>
            	</div>            	
            	<div style="float: left;margin-top: 35px;margin-left:20px;font-family: '楷体';font-size: 30px;">
            		<strong>购物车</strong>
            	</div>
            	<div style="float: right;margin-top: 45px;">
            		
            		<input type="text" name="search" style="border: 1px solid red;height: 30px;width: 270px;">
            		<input type="button" name="sousuo" value="搜搜" style="color: #FFFFFF;background-color: red;border: 0px;height: 32px;width: 60px;">            		
            	</div>
            	
            	<div style="clear: both;"></div>
            </div>
          
            <div style="width: 1200px;margin: auto;padding-top: 30px;color: grey;">
            	
            	<div style="float: left;font-family: '楷体';font-size: 25px;">
            		<strong><a href="/share/front/SerachPageAction.action" style="text-decoration:none;color: red;">全部商品</a></strong>
            	</div >
            	<div style="float: left;font-family: '楷体';font-size: 25px;margin-left: 20px;">
            		<strong><a href="/share/front/WomenAction.action" style="text-decoration:none;color: black;">乐享社区</a></strong>
            		
            	</div>
            	<div style="float: right;overflow: hidden;">
            		配送至：
            		<select name="address" style="font-size: 15px;">
            			<option value="2">北京朝阳区附近</option>
            			<option value="2">上海黄浦区附近</option>
            			<option value="2">福建省厦门市集美区</option>
            			<option value="2">北京朝阳区附近</option>
            			<option value="2">北京朝阳区附近</option>
            			<option value="2">北京朝阳区附近</option>
            			<option value="2">北京朝阳区附近</option>
            		</select>
            	</div>
            	<div style="clear: both;"></div>
            </div>
        
            <div style="width: 1200px;height: 35px;margin: auto;background-color: rgb(243,243,243);margin-top: 20px;color: rgb(102,102,102);padding-top: 10px;">
            	<input type="checkbox" name="choose" value="选择">全选
            	<span style="margin-left: 100px;">商品</span>
            	<span style="margin-left: 500px;">单价</span>
            	<span style="margin-left: 70px;">数量</span>
            	<span style="margin-left: 110px;">小计</span>
            	<span style="margin-left: 100px;">操作</span>
            </div>
         
            
            <div style="margin: auto;width: 1200px;margin-top: 20px;">
            	<input type="checkbox" value="xuanze">
            	<div style="float: right;color: gray;">已免运费</div>
            	<input type="submit" name="ziying" value="自营" style="color: #FFFFFF; background-color: red;border: 0px;"/>           	
            </div>
            
          
            <div style="margin: auto; width: 1200px;background-color: rgb(255,244,232);margin-top: 5px;min-height: 330px;">
            	<c:forEach items="${listCartVo}" var="cartVo">
	            	<div class="cart_chanpin">
	            		<input type="checkbox" checked="checked"  value="" name=""/>
	            		<input type="hidden" value="${cartVo.productSkuId}" name="ddd"/>
	            		<a href="/share/f/goodsDetailedAction.action?productId=${cartVo.productId}"><img src="${cartVo.fullPath}"></a>
	            		<a class="mingzi" href="/share/f/goodsDetailedAction.action?productId=${cartVo.productId}">${cartVo.productName}</a>
	            		<span class="yanse">颜色：${cartVo.colorName}</span>
	            		<span class="shicun">尺寸：${cartVo.sizeName}</span>
	            		<span class="jiage">价格：${cartVo.priceReal}</span>
	            		<input type="text" name="" class="shuliang" value="1"/>
	            		<span class="zongjiage">${cartVo.priceReal}</span>
	            		<a class="shanchu" href="/share/front/CartfAction.action?cartId=${cartVo.cartId}&method=delete">删除</a>
	            	</div> 	
	            </c:forEach>	
            </div>
       
            <div style="border: 1px solid rgb(240,204,204); width: 1200px; margin: auto;margin-top: 18px;height: 50px;">
            	<input type="checkbox" name="sanji" />全选
            	<span>删除选中的商品</span>
            	<span>移到我的关注</span>
            	<span>清除下柜商品</span>
            	<span style="margin-left: 478px;">商品</span>
            	总价:<input name="price" type="text" />
            	<input type="submit" name="jiesuan" value="去结算" style="color: #FFFFFF;background-color: red;width: 100px;height: 50px;font-size: 20px;border: 0px;"/>
            </div>
		</div> 
	</form>
</body>
</html>