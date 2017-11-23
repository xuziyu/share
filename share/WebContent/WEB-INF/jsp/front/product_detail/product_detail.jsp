<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/admin/include/global_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>product_detail</title>
<meta charset="UTF-8">
		<link  rel="stylesheet" href="/share/resource/front/css/good.css" />
		<link  rel="stylesheet" href="/share/resource/front/cssm/iconfont.css" />
		<link  rel="stylesheet" href="/share/resource/front/cssm/search.css">
		<link  rel="stylesheet" href="/share/resource/front/cssm/guidance.css" />
		<link  rel="stylesheet" href="/share/resource/front/cssm/fixed.css" />
		<link  rel="stylesheet" href="/share/resource/front/cssm/foot.css" />
		<title></title>
<script type="text/javascript">
	function gid(id){
		return document.getElementById(id);
	}

	function goPageIndex(productSkuId){
		gid("pageIndex").value = productSkuId ;
	}

</script>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<script src="../js/jquery-1.8.2.js"></script> 
<script src="../js/xq_bigimg.js"></script> 
</head>
<body style="margin-top: 0px;">

<div id="header">
	<div class="w">
    	<ul class="fl">
    		<li id="ttbar-home"><i class="iconfont">&#xe608;</i><a href="/share/front/WomenAction.action" target="_blank">乐享首页</a></li>
    		<li class="dorpdown" id="ttbar-mycity"></li>
    	</ul>
    	<ul class="fr">
			<li class="fore1" id="ttbar-login">
				<c:choose>
					<c:when test="${sessionScope.id==null }">
					<a href="/share/front/LoginfAction.action" class="link-login">你好，请登录</a>&nbsp;&nbsp;<a href="/share/front/RegisterAction.action" class="link-regist style-red">免费注册</a>
					</c:when>
					<c:otherwise>
					<a href="/share/front/LoginfAction.action" class="link-login">${sessionScope.code }</a>
					</c:otherwise>
				</c:choose>
			</li>
			<li class="spacer"></li>
			<li class="fore2">
				<div class="dt">
					<a target="_blank" href="/share/SalOrderAction.Action">我的订单</a>
				</div>
			</li>
			<li class="spacer"></li>
			<li class="fore3 dorpdown" id="ttbar-myjd">
				<div class="dt cw-icon">

					<a target="_blank" href="">我的乐享</a>
				</div>
				<div class="dd dorpdown-layer"></div>
			</li>
			<li class="spacer"></li>
			<li class="fore4">
				<div class="dt">
					<a target="_blank" href="">乐享会员</a>
				</div>
			</li>
			<li class="spacer"></li>
			<li class="fore5">
				<div class="dt">
					<a target="_blank" href="">企业采购</a>
				</div>
			</li>
			<li class="spacer"></li>
			<li class="fore6 dorpdown" >
				<div class="dt cw-icon">

					客户服务
				</div>
				<div class="dd dorpdown-layer"></div>
			</li>
			<li class="spacer"></li>
			<li class="fore7 dorpdown" >
				<div class="dt cw-icon">

					网站导航
				</div>
				<div class="dd dorpdown-layer"></div>
			</li>
			<li class="spacer"></li>
			<li class="fore8 dorpdown" id="ttbar-apps">
				<div class="dt cw-icon">

					<a target="_blank" href="">手机乐享</a>
				</div>
			</li>
    	</ul>
		<span class="clr"></span>
    </div>
</div>

<div class="w">
            <div id="logo-2014">
                <a href="/front/WomenAction.action" class="logo">京东</a>
            </div>
            <div id="search-2014" >
                <ul id="shelper" class="hide"></ul>
                <div class="form">
                    <input type="text" onkeydown="javascript:if(event.keyCode==13) search('key');"  id="key" accesskey="s" class="text" />
                    <button onclick="search('key');return false;" class="button cw-icon"><i></i>搜索<tton>
                </div>
            </div>
            <span class="clr"></span>
</div>	



		<div style="background-color:#f1f1f1;height:30px;">
			<div class="guidance" style="margin:0 auto;width:1200px;">
				<div style="float:left;font-size:13px;color:#666666;margin-top:8px;">
					<a href="">商品类</a>
					>
					<a href="">大类名字：${s_ProductVoList.bigName }</a>
					>
					<a href="">小类名字：${s_ProductVoList.smallName }</a>
					>
					<a href="">品牌名：${s_ProductVoList.brandName }</a>
					>
					<a>${s_ProductVoList.name }</a>
				</div>
				<div style="float: right;font-size:13px;margin-top:8px;">
					<i class="iconfont icon-lingdang"></i>
					<a href="">联系卖家</a>
					<i class="iconfont icon-kefu"></i>
					<a href="">JIMI</a>
					<i class="iconfont icon-xing"></i>
					<a href="">关注店铺</a>

				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
		<div style="margin:0 auto;width:1200px;margin-top: 13px;">
			<div style="float: left;width:480px">
				
				<div><c:forEach items="${s_ProductSkuVoList}" var="pic">
				<img src="${pic.picpath}" xq_big="true" setting='{"pwidth":400,"pheight":400,"margin_top":0,"margin_left":0}' />
				<script src="D:/编程学习/资料/java2se/Wokrpace/share/WebContent/WEB-INF/jsp/front/product_detail/js/jquery-1.8.2.js"></script> 
				<script src="D:/编程学习/资料/java2se/Wokrpace/share/WebContent/WEB-INF/jsp/front/product_detail/js/xq_bigimg.js"></script> 
				</c:forEach></div>
				<div class="search" style="width: 350px;">
					<a href=""><i class="iconfont icon-xin-" style="color: #E3393C;"></i>关注</a>
					<a href=""><i class="iconfont icon-fenxiang" style="color: #E3393C;"></i>分享</a>
					<div style="float: right;"><a href="" >举报</a></div>
				</div>
			</div>
			<div style="float: left;width:580px;margin: 20px;">

				<div style="font-size:20px;color: #666666;">
					<strong>${s_ProductVoList.name }</strong>
				</div>
				<div style="margin-top:5px ;">
					<a href="" style="font-size: 8px;color: #5E69AD;">长款无袖V领连衣裙中</a>
				</div>
				<div style="border-bottom:1px solid #DFDFDE">
					<div >
						<span style="font-size: 8px;color: #666666;">乐 享 价</span>
						<span style="color: #C91423;">￥${s_ProductSkuVoList.get(0).getPriceReal()}</span>
						<a href="" style="color: #005AA0;text-decoration:none;font-size: 8px;">降价通知</a>
					</div>
					<div>
						<span style="font-size: 8px;color: #666666;">优 惠 券</span>
					</div>
					<div>
						<span style="font-size: 8px;color: #666666;">促　　销</span>
					</div>
					<div >
						<span style="font-size: 8px;color: #666666;">配 送 至</span>
					</div>
				</div>
				<div style="border-bottom:1px solid #DFDFDE">
					<form action="/share/front/CartfAction.action?method=insert&productSkuId=${s_ProductSkuVoList.get(0).productSkuId}" method="post">
					<input type="hidden" name="productId" value="${s_ProductVoList.productId }"/>
					<div><span style="font-size: 8px;color: #666666;">选择颜色</span>
						<c:forEach items="${s_ProductSkuVocolor}" var="productSku">		
						<input type="radio" value="${productSku.skuColorId }" name="productSkuId">${productSku.colorName }					
						</c:forEach>
					</div>
					<div><span style="font-size: 8px;color: #666666;">选择尺码</span>
							<c:forEach items="${s_ProductSkuVosize}" var="productSku">
							<input type="radio" value="${productSku.skuSizeId }" name="SkuId">${productSku.sizeName }				
							</c:forEach>
							</div>	
				
					<input type="submit" value="加入购物车" />
					</form>
				</div>
				<div>
					<div><!-- <input type="button" value="加入购物车" /> --></div>
					
					<div><span style="font-size: 8px;color: #666666;">温馨提示·支持7天无理由退货</span></div>
				</div>
			</div>
			<div style="float: left;text-align: center;">
				<!-- 看了又看 -->
				<div>
				<!-- 	<img src="img/04.jpg"  /> -->
				</div>
				<div></div>
				<div></div>
			</div>
			<div style="clear: both;">	</div>
		</div>
		<div style="margin:0 auto;width:1200px;margin-top: 13px;background-color: #F7F7F7;border-bottom:1px solid #E4393C  ;">
			<div style="background-color: #E4393C;color: #FFFFFF;float: left;height:40px;width: 100px;text-align: center">
				<span style="line-height: 40px;font-size: 15px;">乐享推荐</span>
			</div>
		
			<div style="clear: both;"></div>
		</div>
		<div style="margin: 0 auto; width: 1200px;">
			<div style="margin: 20px;"><!-- <img src="img/05..jpg"> --></div>
			
		</div>
		
		<div style="margin: 0 auto; width: 1200px;margin-top:20px ;">
			<div style="float: left;">
				<div style="width: 200px;padding: 10px;">
					<div style="background-color: #F7F7F7;">
						<span ><b><a href="" style="text-decoration: none; color: #666666;">Leioyda服饰官方旗舰</a></b></span>
					</div>
					<div>
						<div style="float: left;"></div>
						<div style="float: left;"></div>
						<div style="clear: both;"></div>
					</div>
				</div>
				
			</div>
			<div style="float: left;">
				<div>
					商品介绍</br>
					<table style="width: 800px">
					<tbody>
						<tr>
							<td>产品名字：${s_ProductVoList.name }</td>
							<td>原产地：${s_ProductVoList.productPlace }</td>
							<td>上市时间年份：${s_ProductVoList.marketYear }</td>
							<td>上市季节:春季</td>
						</tr>
						<tr>
							<td>流行元素：${s_ProductVoList.fashionElement }</td>
							<td>面料：${s_ProductVoList.fabric }</td>
							<td>版型：${s_ProductVoList.stereotype }</td>
							<td>毛重：${s_ProductVoList.grossWeight }</td>
						</tr>
						<tr>
							<td>品牌：${s_ProductVoList.brandName }</td>
							<td>${s_ProductVoList.bigName }</td>
							<td>${s_ProductVoList.smallName }</td>
						</tr>
					</tbody>
					</table>
				</div>
			</div>
			<div style="clear: both;"></div>
					<div style="padding-left: 100px;padding-top: 50px;padding-bottom: 20px">
					<table>
							<thead>
									<tr>
										<th style="width: 600px;">商品评价</th>
										<th style="width: 200px">商品评价时间</th>
										<th>评价等级</th>
										
									</tr>
									
							</thead>
							<tbody>
							 	<c:forEach items="${s_SalOrderDetailReviewList }" var="ReviewList" varStatus="orderIndex">
									<tr>
										<td>${ReviewList.content }</td>
										<td><fmt:formatDate value="${ReviewList.createDate }" pattern="yyyy-MM-dd"/></td>
										<td>${ReviewList.reviewGrade }</td>
									</tr>
								</c:forEach>
							</tbody>
					</table>
			</div>
		</div>
		
		
<div id="service-2017">
	<div class="w">
		<ol class="slogen">
			<li class="item fore1">
				<i>多</i>品类齐全，轻松购物
			</li>
			<li class="item fore2">
				<i>快</i>多仓直发，极速配送
			</li>
			<li class="item fore3">
				<i>好</i>正品行货，精致服务
			</li>
			<li class="item fore4">
				<i>省</i>天天低价，畅选无忧
			</li>
		</ol>
	</div>
	<div class="jd-help">
		<div class="w">
			<div class="wrap">
				<dl class="fore1">
					<dt>购物指南</dt>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">购物流程</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">会员介绍</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">生活旅行/团购</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">常见问题</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">大家电</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">联系客服</a></dd>
				</dl>
				<dl class="fore2">		
					<dt>配送方式</dt>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">上门自提</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">211限时达</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">配送服务查询</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">配送费收取标准</a></dd>				
					<dd><a target="_blank" href="">海外配送</a></dd>
				</dl>
				<dl class="fore3">
					<dt>支付方式</dt>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">货到付款</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">在线支付</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">分期付款</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">邮局汇款</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">公司转账</a></dd>
				</dl>
				<dl class="fore4">		
					<dt>售后服务</dt>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">售后政策</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">价格保护</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">退款说明</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">返修/退换货</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">取消订单</a></dd>
				</dl>
				<dl class="fore5">
					<dt>特色服务</dt>	
					<dd><a target="_blank" href="/share/front/WomenAction.action">夺宝岛</a></dd>
					<dd><a target="_blank" href="/share/front/WomenAction.action">DIY装机</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">延保服务</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">乐享E卡</a></dd>				
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">乐享通信</a></dd>
					<dd><a rel="nofollow" target="_blank" href="/share/front/WomenAction.action">乐享LG+</a></dd>
				</dl>
				<span class="clr"></span>
			</div>
		</div>
	</div>
</div>



<div id="footer-2017">
	<div class="w">
		<div class="copyright_links">
		<p><a href="/share/front/WomenAction.action" target="_blank">关于我们</a><span class="copyright_split">|</span><a href="/share/front/WomenAction.action" target="_blank">联系我们</a><span class="copyright_split">|</span><a href="/share/front/WomenAction.action" target="_blank">联系客服</a><span class="copyright_split">|</span><a href="/share/front/WomenAction.action" target="_blank">合作招商</a><span class="copyright_split">|</span><a href="/share/front/WomenAction.action" target="_blank">商家帮助</a><span class="copyright_split">|</span><a href="" target="_blank">营销中心</a><span class="copyright_split">|</span><a href="" target="_blank">手机乐享</a><span class="copyright_split">|</span><a href="" target="_blank">友情链接</a><span class="copyright_split">|</span><a href="" target="_blank">销售联盟</a><span class="copyright_split">|</span><a href="" target="_blank">乐享社区</a><span class="copyright_split">|</span><a href="" target="_blank">风险监测</a><span class="copyright_split">|</span><a href="" target="_blank">隐私政策</a><span class="copyright_split">|</span><a href="/share/front/WomenAction.action" target="_blank">乐享公益</a><span class="copyright_split">|</span><a href="/share/front/WomenAction.action" target="_blank">English Site</a><span class="copyright_split">|</span><a href="/share/front/WomenAction.action" target="_blank">Contact Us</a></p>
	</div>	
		<div class="copyright_info">
			<p><a href="/share/front/WomenAction.action" target="_blank">京公网安备 888888888888888888号</a><span class="copyright_split">|</span><span>京ICP证888888号</span><span class="copyright_split">|</span><a href="/share/front/WomenAction.action" target="_blank">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a><span class="copyright_split">|</span><span>新出发京零&nbsp;字第大120007号</span></p><p><span>互联网出版许可证编号新出网证(京)字150号</span><span class="copyright_split">|</span><a href="/share/front/WomenAction.action" target="_blank">出版物经营许可证</a><span class="copyright_split">|</span><a href="" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a><span class="copyright_split">|</span><span>违法和不良信息举报电话：4006561155</span></p><p><span class="copyright_text">Copyright&nbsp;&copy;&nbsp;2004&nbsp;-&nbsp;<em id="copyright_year">2017</em>&nbsp;&nbsp;乐享LX.com&nbsp;版权所有</span><span class="copyright_split">|</span><span>消费者维权热线：4006067733</span><a href="/share/front/WomenAction.action" target="_blank" class="copyright_license">经营证照</a></p><p><span>乐享旗下网站：</span><a href="/share/front/WomenAction.action" target="_blank">乐享支付</a><span class="copyright_split">|</span><a href="/share/front/WomenAction.action" target="_blank">京东云</a></p>
		</div>
		<p class="copyright_auth"><a class="copyright_auth_ico copyright_auth_ico_1" href="/share/front/WomenAction.action" target="_blank">经营性网站备案中心</a><script type="text/JavaScript">function CNNIC_change(eleId){var str= document.getElementById(eleId).href;var str1 =str.substring(0,(str.length-6));str1+=CNNIC_RndNum(6); document.getElementById(eleId).href=str1;}function CNNIC_RndNum(k){var rnd=""; for (var i=0;i < k;i++) rnd+=Math.floor(Math.random()*10); return rnd;};(function(){var d=new Date;document.getElementById("copyright_year").innerHTML=d.getFullYear()})();</script><a id="urlknet" class="copyright_auth_ico copyright_auth_ico_2" onclick="CNNIC_change('urlknet')" name="CNNIC_seal" href="" target="_blank">可信网站信用评估</a><a class="copyright_auth_ico copyright_auth_ico_3" href="" target="_blank">网络警察提醒你</a><a class="copyright_auth_ico copyright_auth_ico_4" href="" target="_blank">诚信网站</a><a class="copyright_auth_ico copyright_auth_ico_5" href="/share/front/WomenAction.action" target="_blank">中国互联网举报中心</a><a class="copyright_auth_ico copyright_auth_ico_6" href="/share/front/WomenAction.action" target="_blank">网络举报APP下载</a></p>
	</div>
</div>


</body>
</html>