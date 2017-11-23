<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/front/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/share/resource/front/css/product_show.css" />
<title>搜索界面</title>
<script type="text/javascript">
	function gid(id){
		return document.getElementById(id);
	}
	function goPageIndex(index){
		gid("pageIndex").value = index ;
		gid("form").submit() ;
	}
</script>
</head>
<body>
	<form action="/share/front/SerachPageAction.action" id="form" method="post">
	<div id="shortcut">
		<div class="w">
			<ul class="fl">
				<li id="t-home">
					<i class="iconfont"></i>
					<a target="_blank" href="/share/front/WomenAction.action">share首页</a>
				</li>
				<li class="dropdown" id="mycity">
					<i class="iconfont"></i>
					<span class="toptext" title="厦门">厦门</span>
				</li>
			</ul>
			<ul class="fr">
				<li class="fore1" id="login-register">
					<c:choose>
						<c:when test="${sessionScope.id==null}">
							<a class="login" href="/share/front/LoginfAction.action">你好，请登录</a>
						</c:when>
						<c:when test="${sessionScope.id!=null}">
							<span class="login" style="color:red;">${sessionScope.code}</span>
						</c:when>
					</c:choose>
					&nbsp;&nbsp;
					<a class="register" href="/share/front/RegisterAction.action">免费注册</a>
				</li>
				<li class="spacer"></li>
				<li class="fore2">
					<div class="dt">
						<a target="_blank" href="/share/SalOrderAction.Action">我的订单</a>
					</div>
				</li>
				<li class="spacer"></li>
				<li class="fore3-zz">
					<div class="dt-ss">
						<a target="_blank" href="">我的share</a>
						<i class="iconfont"></i>
					</div>
					<div class="dd-zz"></div>
				</li>
				<li class="spacer"></li>
				<li class="fore4">
					<div class="dt">
						<a target="_blank" href="">share会员</a>
					</div>
				</li>
				<li class="spacer"></li>
				<li class="fore5">
					<div class="dt">
						<a target="_blank" href="/share/front/WomenAction.action">企业采购</a>
					</div>
				</li>
				<li class="spacer"></li>
				<li class="fore6-zz">
					<div class="dt-ss">
						<span class="toptext">客户服务</span>
						<i class="iconfont"></i>
					</div>
					<div class="dd-zz"></div>
				</li>
				<li class="spacer"></li>
				<li class="fore7-zz">
					<div class="dt-ss">
						<span class="toptext">网站导航</span>
						<i class="iconfont"></i>
					</div>
					<div class="dd-zz"></div>
				</li>
				<li class="spacer"></li>
				<li class="fore8-zz">
					<div class="dt-ss">
						<a target="_blank" href="/share/front/WomenAction.action">share</a>
					</div>
					<div class="dd-zz"></div>
				</li>
			</ul>
			<span class="clr"></span>
		</div>
	</div>
	<!--
       	描述：logo 搜索框
   	-->
	<div class="w">
		<div id="logo">
			<a href="/share/front/WomenAction.action" class="logo-1">京东</a>
		</div>
		<div id="sousuo">
			<ul id="shelper" class="hide" style="display: none;"></ul>
			<div class="form">
				<input type="hidden" id="pageIndex" name="pageIndex" value=""/>
				<input type="text" name="name" class="text blurcolor">
				<input type="button" value="搜索" class="button dt-ss" onclick="goPageIndex(0);">
				<span class="clr"></span>
			</div>
		</div>
		
		<div id="gouwuche" class="dropdown">
			<div class="dt-ss">
				<i class="iconfont"></i>
				<i class="ci-count" id="shopping-amount"></i>
				<a target="_blank" href="/share/front/CartfAction.action">购物车</a>
			</div>
			<div class="dropdown-layer"></div>
		</div>
		<div id="hotwords" class="haveline">
			<a href="#">连衣裙秋</a>
			<b>|</b>
			<a href="#">连衣裙套装</a>
			<b>|</b>
			<a href="#">吊带连衣裙</a>
			<b>|</b>
			<a href="#">一字肩连衣裙</a>
			<b>|</b>
			<a href="#">连衣裙蕾丝</a>
			<b>|</b>
			<a href="#">连衣裙</a>
			<b>|</b>
			<a href="#">不对称连衣裙</a>
			<b>|</b>
			<a href="#">连衣裙雪纺</a>
			<b>|</b>	
		</div>
		<span class="clr"></span>
	</div>
			<!--
        	描述：导航菜单
        -->
	<div id="nav">
		<div class="w">
			<div class="spacer"></div>
			<div id="categorys-2014" class="dropdown" style="height: auto;left: 0px;">
				<div class="dt">
					<a target="_blank" href="#">全部商品分类</a>
				</div>
				<div class="dd" style="display: none;"></div>
			</div>
			<div id="navitems-2014">
				<ul id="navitems-group1">
					<li class="fore1">
						<a class="b" target="_blank" href="#">服装城</a>
					</li>
					<li class="fore2">
						<a class="b" target="_blank" href="#">美妆馆</a>
					</li>
					<li class="fore3">
						<a class="b" target="_blank" href="#">超市</a>
					</li>
					<li class="fore4">
						<a class="b" target="_blank" href="#">生鲜</a>
					</li>
				</ul>
				<div class="spacer"></div>
				<ul id="navitems-group2">
					<li class="fore1">
						<a class="b" target="_blank" href="#">全球购</a>
					</li>
					<li class="fore2">
						<a class="b" target="_blank" href="#">闪购</a>
					</li>
					<li class="fore3">
						<a class="b" target="_blank" href="#">拍卖</a>
					</li>
				</ul>
				<div class="spacer"></div>
				<ul id="navitems-group3">
					<li class="fore">
						<a class="b" target="_blank" href="#">金融</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<span class="clr"></span>
		<!--
       	描述：按条件搜索并显示结果
       -->
	<div id="J_searchWrap" class="w">
		<div id="J_crumbsBar">
			<div class="crumbs-nav">
				<div class="crumbs-nav-main clearfix">
					<div class="crumbs-nav-item">
						<a href="#">全部结果</a>
					</div>
					<i class="crumbs-arrow"></i>
					<div class="crumbs-nav-item">
<!-- 						<strong class="search-key">"背带连衣裙"</strong> -->
					</div>
					<span class="clr"></span>
				</div>
			</div>
		</div>
		<div id="J_container">
			<div id="J_container_top">
				<div id="pinpai_p">
					<h3>品牌</h3>
				</div>
				<div id="pinpai">
					<c:forEach items="${listBasBrand}" var="basBrand">
					<div class="pinpai_1"><a href="/share/front/SerachPageAction.action?brandId=${basBrand.brandId}">${basBrand.name}</a></div>
					</c:forEach>
					<span class="clr"></span>	
				</div>
				<span class="clr"></span>
				<hr />
				<div id="xiaolei_p">
					<h3>小类</h3>
				</div>
				<div id="xiaolei">
					<c:forEach items="${listBasCategorySmall}" var="basCategorySmall">
						<div class="xiaolei_1"><a href="/share/front/SerachPageAction.action?categorySmallId=${basCategorySmall.categorySmallId}">${basCategorySmall.name}</a></div>
					</c:forEach>
					<span class="clr"></span>
				</div>
				<span class="clr"></span>
				<hr />
				<div id="chandi_p">
					<h3>产地</h3>
				</div>
				<div id="chandi">
					<c:forEach items="${listPlace}" var="pplace">
						<div class="chandi_1"><a href="/share/front/SerachPageAction.action?productPlace=${pplace.productPlace}">${pplace.productPlace}</a></div>
					</c:forEach>
					<span class="clr"></span>
				</div>
				<hr />
				<div id="jijie_p">
					<h3>季节</h3>
				</div>
				<div id="jijie">
					<div class="jijie_1"><a href="/share/front/SerachPageAction.action?marketSeason=1">春</a></div>
					<div class="jijie_1"><a href="/share/front/SerachPageAction.action?marketSeason=2">夏</a></div>
					<div class="jijie_1"><a href="/share/front/SerachPageAction.action?marketSeason=3">秋</a></div>
					<div class="jijie_1"><a href="/share/front/SerachPageAction.action?marketSeason=4">冬</a></div>
					<span class="clr"></span>
				</div>
				<span class="clr"></span>
				<hr />
				<div id="liuxingyuansu_p">
					<h3>元素</h3>
				</div>
				<div id="liuxingyuansu">
					<c:forEach items="${listFashionElement}" var="ffashionElement">
						<div class="liuxingyuansu_1"><a href="/share/front/SerachPageAction.action?fashionElement=${ffashionElement.fashionElement}">${ffashionElement.fashionElement}</a></div>
					</c:forEach>
					<span class="clr"></span>
				</div>
				<span class="clr"></span>
				<hr />
				<div id="liuxingmianliao_p">
					<h3>面料</h3>
				</div>
				<div id="liuxingmianliao">
					<c:forEach items="${listFabric}" var="ffabric">
						<div class="liuxingmianliao_1"><a href="/share/front/SerachPageAction.action?fabric=${ffabric.fabric}">${ffabric.fabric}</a></div>
					</c:forEach>
					<span class="clr"></span>
				</div>
				<span class="clr"></span>
				<hr />
				<div id="liuxingbanxing_p">
					<h3>版型</h3>
				</div>
				<div id="liuxingbanxing">
					<c:forEach items="${listStereotype}" var="sstereotype">
						<div class="banxing_1"><a href="/share/front/SerachPageAction.action?stereotype=${sstereotype.stereotype}">${sstereotype.stereotype}</a></div>
					</c:forEach>
					<span class="clr"></span>
				</div>
				<span class="clr"></span>
				<hr />
				<div id="maozhong_p">
					<h3>毛重</h3>
				</div>
				<div id="maozhong">
					<c:forEach items="${listGrossWeight}" var="ggrossWeight">
						<div class="miaoliao_1"><a href="/share/front/SerachPageAction.action?grossWeight=${ggrossWeight.grossWeight}">${ggrossWeight.grossWeight}</a></div>
					</c:forEach>
					<span class="clr"></span>
				</div>
				<span class="clr"></span>
				<hr />
			</div>
				<div id="shangpinjiemian">
					<div id="guanggao_p">
						<div class="guanggao_1">
							<a href="#"><img src="/share/resource/front/image/upload/59dcbbacN57236452.jpg" width="180px" height="280px"></a>
							<h3>¥399.00</h3>
							<span><a href="#" class="aaa">女性乐享自营牛仔外套中外合资产品</a></span><br />
							<span><a href="#" class="aa">10</a>+评价</span>
						</div>
						<div class="guanggao_1">
							<a href="#"><img src="/share/resource/front/image/upload/59dcbbacN57236452.jpg" width="180px" height="280px"></a>
							<h3>¥399.00</h3>
							<span><a href="#" class="aaa">女性乐享自营牛仔外套中外合资产品</a></span><br />
							<span><a href="#" class="aa">10</a>+评价</span>
						</div>
						<div class="guanggao_1">
							<a href="#"><img src="/share/resource/front/image/upload/59dcbbacN57236452.jpg" width="180px" height="280px"></a>
							<h3>¥399.00</h3>
							<span><a href="#" class="aaa">女性乐享自营牛仔外套中外合资产品</a></span><br />
							<span><a href="#" class="aa">10</a>+评价</span>
						</div>
						<div class="guanggao_1">
							<a href="#"><img src="/share/resource/front/image/upload/59dcbbacN57236452.jpg" width="180px" height="280px"></a>
							<h3>¥399.00</h3>
							<span><a href="#" class="aaa">女性乐享自营牛仔外套中外合资产品</a></span><br />
							<span><a href="#" class="aa">10</a>+评价</span>
						</div>
						<div class="guanggao_1">
							<a href="#"><img src="/share/resource/front/image/upload/59dcbbacN57236452.jpg" width="180px" height="280px"></a>
							<h3>¥399.00</h3>
							<span><a href="#" class="aaa">女性乐享自营牛仔外套中外合资产品</a></span><br />
							<span><a href="#" class="aa">10</a>+评价</span>
						</div>
						<div class="guanggao_1">
							<a href="#"><img src="/share/resource/front/image/upload/59dcbbacN57236452.jpg" width="180px" height="280px"></a>
							<h3>¥399.00</h3>
							<span><a href="#" class="aaa">女性乐享自营牛仔外套中外合资产品</a></span><br />
							<span><a href="#" class="aa">10</a>+评价</span>
						</div>
						<div class="guanggao_1">
							<a href="#"><img src="/share/resource/front/image/upload/59dcbbacN57236452.jpg" width="180px" height="280px"></a>
							<h3>¥399.00</h3>
							<span><a href="#" class="aaa">女性乐享自营牛仔外套中外合资产品</a></span><br />
							<span><a href="#" class="aa">10</a>+评价</span>
						</div>
					</div>
					<div id="shangpinjiemian_p">
						<div id="shangpinjiemian_t">
							<div class="shangpinjiemian_a">
								<a href="#">综合</a>
							</div>
							<div class="shangpinjiemian_a">
								<a href="#">销量</a>
							</div>
							<div class="shangpinjiemian_a">
								<a href="#">评论数</a>
							</div>
							<div class="shangpinjiemian_a">
								<a href="/share/front/SerachPageAction.action?orderBy=market_year">新品</a>
							</div>
							<div class="shangpinjiemian_a">
								<a href="/share/front/SerachPageAction.action?orderBy=price_real">价格</a>
							</div>
							<div class="shangpinjiemian_i">
								<input type="text" name="priceMin"/>
							</div>
							<div class="shangpinjiemian_i">
								<input type="text" name="priceMax"/>
							</div>
							<div class="shangpinjiemian_a">
								<a href="javascript:goPageIndex(0);">确定</a>
							</div>
							
							<span class="clr"></span>
							
						</div>
						<div id="shangpinjiemian_b">
							<c:forEach items="${page.result}" var="pageResult">
								<div class="shangping_1">
									<a href="/share/f/goodsDetailedAction.action?productId=${pageResult.productId}"><img src="${pageResult.fullPath}" width="180px" height="280px"></a>
									<h3>¥${pageResult.priceReal}</h3>
									<span><a href="/share/f/goodsDetailedAction.action?productId=${pageResult.productId}" class="aaa">${pageResult.name}</a></span><br />
									<span><a href="#" class="aa">10</a>+评价</span>
								</div>
							</c:forEach>
							<span class="clr"></span>
						</div>
					</div>
					<span class="clr"></span>
					<div id="yemian_p">
						<c:forEach begin="0" end="${page.pageCount-1}" varStatus="status">
							<a href="javascript:goPageIndex(${status.index});" class="yemian_a">${status.index+1 }</a>
						</c:forEach>
						<select name="pageSize" id="pageSize" onchange="javascript:goPageIndex(0);">
							<option value="42" <c:if test="${page.pageSize== 42}"> selected="selected"</c:if> >42</option>
							<option value="60" <c:if test="${page.pageSize== 60}"> selected="selected"</c:if> >60</option>
							<option value="120" <c:if test="${page.pageSize== 120}"> selected="selected"</c:if> >120</option>
						</select>
						${page.pageSize}
						<span class="clr"></span>
					</div>
					<span class="clr"></span>
				</div>
		</div>
	</div>
	<!--channle_floor_ok-->
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
					<dd><a rel="nofollow" target="_blank" href="">购物流程</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">会员介绍</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">生活旅行/团购</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">常见问题</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">大家电</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">联系客服</a></dd>
				</dl>
				<dl class="fore2">		
					<dt>配送方式</dt>
					<dd><a rel="nofollow" target="_blank" href="">上门自提</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">211限时达</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">配送服务查询</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">配送费收取标准</a></dd>				
					<dd><a target="_blank" href="">海外配送</a></dd>
				</dl>
				<dl class="fore3">
					<dt>支付方式</dt>
					<dd><a rel="nofollow" target="_blank" href="">货到付款</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">在线支付</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">分期付款</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">邮局汇款</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">公司转账</a></dd>
				</dl>
				<dl class="fore4">		
					<dt>售后服务</dt>
					<dd><a rel="nofollow" target="_blank" href="">售后政策</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">价格保护</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">退款说明</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">返修/退换货</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">取消订单</a></dd>
				</dl>
				<dl class="fore5">
					<dt>特色服务</dt>	
					<dd><a target="_blank" href="">夺宝岛</a></dd>
					<dd><a target="_blank" href="">DIY装机</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">延保服务</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">乐享E卡</a></dd>				
					<dd><a rel="nofollow" target="_blank" href="">乐享通信</a></dd>
					<dd><a rel="nofollow" target="_blank" href="">乐享LG+</a></dd>
				</dl>
				<span class="clr"></span>
			</div>
		</div>
	</div>
</div>
<!--service end-->
<div id="footer-2017">
	<div class="w">
		<div class="copyright_links">
		<p><a href="" target="_blank">关于我们</a><span class="copyright_split">|</span><a href="" target="_blank">联系我们</a><span class="copyright_split">|</span><a href="" target="_blank">联系客服</a><span class="copyright_split">|</span><a href="" target="_blank">合作招商</a><span class="copyright_split">|</span><a href="" target="_blank">商家帮助</a><span class="copyright_split">|</span><a href="" target="_blank">营销中心</a><span class="copyright_split">|</span><a href="" target="_blank">手机乐享</a><span class="copyright_split">|</span><a href="" target="_blank">友情链接</a><span class="copyright_split">|</span><a href="" target="_blank">销售联盟</a><span class="copyright_split">|</span><a href="" target="_blank">乐享社区</a><span class="copyright_split">|</span><a href="" target="_blank">风险监测</a><span class="copyright_split">|</span><a href="" target="_blank">隐私政策</a><span class="copyright_split">|</span><a href="" target="_blank">乐享公益</a><span class="copyright_split">|</span><a href="" target="_blank">English Site</a><span class="copyright_split">|</span><a href="" target="_blank">Contact Us</a></p>
	</div>	
		<div class="copyright_info">
			<p><a href="" target="_blank">京公网安备 888888888888888888号</a><span class="copyright_split">|</span><span>京ICP证888888号</span><span class="copyright_split">|</span><a href="" target="_blank">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a><span class="copyright_split">|</span><span>新出发京零&nbsp;字第大120007号</span></p><p><span>互联网出版许可证编号新出网证(京)字150号</span><span class="copyright_split">|</span><a href="" target="_blank">出版物经营许可证</a><span class="copyright_split">|</span><a href="" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a><span class="copyright_split">|</span><span>违法和不良信息举报电话：4006561155</span></p><p><span class="copyright_text">Copyright&nbsp;&copy;&nbsp;2004&nbsp;-&nbsp;<em id="copyright_year">2017</em>&nbsp;&nbsp;乐享LX.com&nbsp;版权所有</span><span class="copyright_split">|</span><span>消费者维权热线：4006067733</span><a href="" target="_blank" class="copyright_license">经营证照</a></p><p><span>乐享旗下网站：</span><a href="" target="_blank">乐享支付</a><span class="copyright_split">|</span><a href=" " target="_blank">京东云</a></p>
		</div>
		<p class="copyright_auth"><a class="copyright_auth_ico copyright_auth_ico_1" href="" target="_blank">经营性网站备案中心</a><script type="text/JavaScript">function CNNIC_change(eleId){var str= document.getElementById(eleId).href;var str1 =str.substring(0,(str.length-6));str1+=CNNIC_RndNum(6); document.getElementById(eleId).href=str1;}function CNNIC_RndNum(k){var rnd=""; for (var i=0;i < k;i++) rnd+=Math.floor(Math.random()*10); return rnd;};(function(){var d=new Date;document.getElementById("copyright_year").innerHTML=d.getFullYear()})();</script><a id="urlknet" class="copyright_auth_ico copyright_auth_ico_2" onclick="CNNIC_change('urlknet')" name="CNNIC_seal" href="" target="_blank">可信网站信用评估</a><a class="copyright_auth_ico copyright_auth_ico_3" href="" target="_blank">网络警察提醒你</a><a class="copyright_auth_ico copyright_auth_ico_4" href="" target="_blank">诚信网站</a><a class="copyright_auth_ico copyright_auth_ico_5" href="" target="_blank">中国互联网举报中心</a><a class="copyright_auth_ico copyright_auth_ico_6" href="" target="_blank">网络举报APP下载</a></p>
	</div>
</div>
</form>
</body>
</html>