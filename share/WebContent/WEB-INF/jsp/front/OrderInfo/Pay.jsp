<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/share/resource/front/css/good.css" />
		<link rel="stylesheet" href="/share/resource/front/cssm/iconfont.css" />
		<link rel="stylesheet" href="/share/resource/front/cssm/search.css">
		<link rel="stylesheet" href="/share/resource/front/cssm/guidance.css" />
		<link rel="stylesheet" href="/share/resource/front/cssm/fixed.css" />
		<link rel="stylesheet" href="/share/resource/front/cssm/foot.css" />
		<link rel="stylesheet" href="/share/resource/front/css/women.css" />
		<title>乐享支付</title>
	</head>

	<body>
		<div id="header">
		<div class="w">
			<ul class="fl">
				<li id="ttbar-home"><i class="iconfont">&#xe608;</i><a
					href="/share/front/WomenAction.action" target="_blank">乐享首页</a></li>
				<li class="dorpdown" id="ttbar-mycity"></li>
			</ul>
			<ul class="fr">
				<li class="fore1" id="ttbar-login">
				<c:choose>
						<c:when test="${sessionScope.id==null}">
							<a class="login" href="/share/front/LoginfAction.action">你好，请登录</a>
						</c:when>
						<c:when test="${sessionScope.id!=null}">
							<span class="login" style="color:red;">${sessionScope.code}</span>
						</c:when>
					</c:choose>
					&nbsp;&nbsp;
				<a
					href="/share/front/RegisterAction.action"
					class="link-regist style-red">免费注册</a></li>
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
				<li class="fore6 dorpdown">
					<div class="dt cw-icon">客户服务</div>
					<div class="dd dorpdown-layer"></div>
				</li>
				<li class="spacer"></li>
				<li class="fore7 dorpdown">
					<div class="dt cw-icon">网站导航</div>
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
	
	<div style="margin: 0px auto;width: 1000px;">
		订单提交成功，请尽快付款！订单号：${salOrderVO.orderId} 应付金额：${salOrderVO.price}<br /> 请输入支付密码
		<br />
		<form action="/share/SalOrderAction.Action?method=pay&orderId=${salOrderVO.orderId}" method="post">
			<input type="password" name="paypassword" /><br />
			<input type="submit" value="立即支付">
		</form>
	</div>
	
	<div id="service-2017">
		<div class="w">
			<ol class="slogen">
				<li class="item fore1"><i>多</i>品类齐全，轻松购物</li>
				<li class="item fore2"><i>快</i>多仓直发，极速配送</li>
				<li class="item fore3"><i>好</i>正品行货，精致服务</li>
				<li class="item fore4"><i>省</i>天天低价，畅选无忧</li>
			</ol>
		</div>
		<div class="jd-help">
			<div class="w">
				<div class="wrap">
					<dl class="fore1">
						<dt>购物指南</dt>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">购物流程</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">会员介绍</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">生活旅行/团购</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">常见问题</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">大家电</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">联系客服</a>
						</dd>
					</dl>
					<dl class="fore2">
						<dt>配送方式</dt>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">上门自提</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">211限时达</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">配送服务查询</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">配送费收取标准</a>
						</dd>
						<dd>
							<a target="_blank" href="">海外配送</a>
						</dd>
					</dl>
					<dl class="fore3">
						<dt>支付方式</dt>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">货到付款</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">在线支付</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">分期付款</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">邮局汇款</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">公司转账</a>
						</dd>
					</dl>
					<dl class="fore4">
						<dt>售后服务</dt>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">售后政策</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">价格保护</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">退款说明</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">返修/退换货</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">取消订单</a>
						</dd>
					</dl>
					<dl class="fore5">
						<dt>特色服务</dt>
						<dd>
							<a target="_blank" href="/share/front/WomenAction.action">夺宝岛</a>
						</dd>
						<dd>
							<a target="_blank" href="/share/front/WomenAction.action">DIY装机</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">延保服务</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">乐享E卡</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">乐享通信</a>
						</dd>
						<dd>
							<a rel="nofollow" target="_blank"
								href="/share/front/WomenAction.action">乐享LG+</a>
						</dd>
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
				<p>
					<a href="/share/front/WomenAction.action" target="_blank">关于我们</a><span
						class="copyright_split">|</span><a
						href="/share/front/WomenAction.action" target="_blank">联系我们</a><span
						class="copyright_split">|</span><a
						href="/share/front/WomenAction.action" target="_blank">联系客服</a><span
						class="copyright_split">|</span><a
						href="/share/front/WomenAction.action" target="_blank">合作招商</a><span
						class="copyright_split">|</span><a
						href="/share/front/WomenAction.action" target="_blank">商家帮助</a><span
						class="copyright_split">|</span><a href="" target="_blank">营销中心</a><span
						class="copyright_split">|</span><a href="" target="_blank">手机乐享</a><span
						class="copyright_split">|</span><a href="" target="_blank">友情链接</a><span
						class="copyright_split">|</span><a href="" target="_blank">销售联盟</a><span
						class="copyright_split">|</span><a href="" target="_blank">乐享社区</a><span
						class="copyright_split">|</span><a href="" target="_blank">风险监测</a><span
						class="copyright_split">|</span><a href="" target="_blank">隐私政策</a><span
						class="copyright_split">|</span><a
						href="/share/front/WomenAction.action" target="_blank">乐享公益</a><span
						class="copyright_split">|</span><a
						href="/share/front/WomenAction.action" target="_blank">English
						Site</a><span class="copyright_split">|</span><a
						href="/share/front/WomenAction.action" target="_blank">Contact
						Us</a>
				</p>
			</div>
			<div class="copyright_info">
				<p>
					<a href="/share/front/WomenAction.action" target="_blank">京公网安备
						888888888888888888号</a><span class="copyright_split">|</span><span>京ICP证888888号</span><span
						class="copyright_split">|</span><a
						href="/share/front/WomenAction.action" target="_blank">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a><span
						class="copyright_split">|</span><span>新出发京零&nbsp;字第大120007号</span>
				</p>
				<p>
					<span>互联网出版许可证编号新出网证(京)字150号</span><span class="copyright_split">|</span><a
						href="/share/front/WomenAction.action" target="_blank">出版物经营许可证</a><span
						class="copyright_split">|</span><a href="" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a><span
						class="copyright_split">|</span><span>违法和不良信息举报电话：4006561155</span>
				</p>
				<p>
					<span class="copyright_text">Copyright&nbsp;&copy;&nbsp;2004&nbsp;-&nbsp;<em
						id="copyright_year">2017</em>&nbsp;&nbsp;乐享LX.com&nbsp;版权所有
					</span><span class="copyright_split">|</span><span>消费者维权热线：4006067733</span><a
						href="/share/front/WomenAction.action" target="_blank"
						class="copyright_license">经营证照</a>
				</p>
				<p>
					<span>乐享旗下网站：</span><a href="/share/front/WomenAction.action"
						target="_blank">乐享支付</a><span class="copyright_split">|</span><a
						href="/share/front/WomenAction.action" target="_blank">京东云</a>
				</p>
			</div>
			<p class="copyright_auth">
				<a class="copyright_auth_ico copyright_auth_ico_1"
					href="/share/front/WomenAction.action" target="_blank">经营性网站备案中心</a>
				<script type="text/JavaScript">
					function CNNIC_change(eleId) {
						var str = document.getElementById(eleId).href;
						var str1 = str.substring(0, (str.length - 6));
						str1 += CNNIC_RndNum(6);
						document.getElementById(eleId).href = str1;
					}
					function CNNIC_RndNum(k) {
						var rnd = "";
						for (var i = 0; i < k; i++)
							rnd += Math.floor(Math.random() * 10);
						return rnd;
					};
					(function() {
						var d = new Date;
						document.getElementById("copyright_year").innerHTML = d
								.getFullYear()
					})();
				</script>
				<a id="urlknet" class="copyright_auth_ico copyright_auth_ico_2"
					onclick="CNNIC_change('urlknet')" name="CNNIC_seal" href=""
					target="_blank">可信网站信用评估</a><a
					class="copyright_auth_ico copyright_auth_ico_3" href=""
					target="_blank">网络警察提醒你</a><a
					class="copyright_auth_ico copyright_auth_ico_4" href=""
					target="_blank">诚信网站</a><a
					class="copyright_auth_ico copyright_auth_ico_5"
					href="/share/front/WomenAction.action" target="_blank">中国互联网举报中心</a><a
					class="copyright_auth_ico copyright_auth_ico_6"
					href="/share/front/WomenAction.action" target="_blank">网络举报APP下载</a>
			</p>
		</div>
	</div>
		
	</body>

</html>