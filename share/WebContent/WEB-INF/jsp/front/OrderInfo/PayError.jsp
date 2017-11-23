<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付失败</title>
<link rel="stylesheet" href="/share/resource/front/css/good.css" />
<link rel="stylesheet" href="/share/resource/front/cssm/iconfont.css" />
<link rel="stylesheet" href="/share/resource/front/cssm/search.css">
<link rel="stylesheet" href="/share/resource/front/cssm/guidance.css" />
<link rel="stylesheet" href="/share/resource/front/cssm/fixed.css" />
<link rel="stylesheet" href="/share/resource/front/cssm/foot.css" />
<link rel="stylesheet" href="/share/resource/front/css/women.css" />
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
支付失败
<a href="SalOrderAction.Action">返回</a>
</body>
</html>