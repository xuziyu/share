<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/admin/include/global_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>CreateOrder</title>
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
				<li class="fore1" id="ttbar-login"><
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

	<div class="w">
		<div id="logo-2014">
			<a href="/front/WomenAction.action" class="logo">京东</a>
		</div>
		<div id="search-2014">
			<ul id="shelper" class="hide"></ul>
			<div class="form">
				<input type="text"
					onkeydown="javascript:if(event.keyCode==13) search('key');"
					id="key" accesskey="s" class="text" />
				<button onclick="search('key');return false;" class="button cw-icon">
					<i></i>搜索
					</button>
			</div>
		</div>
		<span class="clr"></span>
	</div>
	<div style="float:left;margin-top: 30px;">
					<div style="float:left;margin-left: 200px;">
						<a href="">
						</a>
					</div>
					<div style="float: left;margin-top: 20px;margin-left: 20px;font-size: 30px;font-family: '宋体';">
						<strong>
							Share结算页
						</strong>
					</div>
					<div style="float:left;margin-left: 400px;">
						<a href="">
						</a>
					</div>
					<div style="margin-top: 100px;margin-left: 200px;">
						填写并核对订单信息
					</div>
					<div style="margin-top: 30px;margin-left: 200px;height: 900px;border:1px solid lightgray;">
						<div style="height: 50px;">
							<div style="float: left;margin-left: 20px;margin-top: 15px;">
								收货人信息
							</div>
							<div style="float: right;margin-right: 20px;margin-top: 15px;">
								<a href="" style="text-decoration:none;color: red;">
									新增收货地址
								</a>
							</div>
						</div>
						<div style="height: 40px;">
							<div style="float: left;margin-left: 40px;">
								<input type="button" value="家里" style="width: 150px;height: 30px;border-color: red;background-color: #FFFFFF;float: left;"/>
							</div>
							<div style="float: left;margin-left: 30px;">
								${basCustomer.name} 
							</div>
							<div style="float: left;margin-left: 30px;">
								${basCustomer.address}
							</div>
							<div style="float: left;margin-left: 30px;">
								${basCustomer.contactMobile}
							</div>
						</div>
							<hr style="width: 1050px;"/>
						<div style="height: 50px;">
							<div style="float: left;margin-left: 20px;margin-top: 15px;">
								支付方式
							</div>
						</div>
						<div style="border:1px height: 50px;">
							<div style="float: left;margin-left: 40px;">
								<input type="button" value="货到付款" style="width: 150px;height: 30px;"/>
							</div>
							<div style="float: left;margin-left: 40px;">
								<input type="button" value="在线支付" style="width: 150px;height: 30px;border-color: red;background-color: #FFFFFF;"/>
							</div>
							<div style="float: left;margin-left: 30px;margin-top: 5px;">
								更多》
							</div>
						</div>
						<div style="height: 50px;">
							
						</div>
						<hr style="width: 1050px;"/>
						<div style="height: 50px;">
							<div style="float: left;margin-left: 20px;margin-top: 15px;">
								送货清单
							</div>
							
							<div style="float: right;margin-right: 20px;margin-top: 15px;">
								<a href="" style="text-decoration:none;color: cornflowerblue">
									返回修改购物车
								</a>
							</div>
							<div style="float: right;margin-right: 20px;margin-top: 15px;">
								<a href="" style="text-decoration:none;color: cornflowerblue">
									价格说明 
								</a>
							</div>
						</div>
						<div style="height: 50px;">
							<div style="float: left;margin-left: 50px;margin-top: 10px;">
								配送方式
							</div>
							<div style="float: left;margin-left:300px;margin-right: 20px;margin-top: 15px;">
								商家：
							</div>
						</div>
						<div style="float: left;height: 130px;width: 400px;">
							<div style="float: left;margin-left: 50px;margin-top: 10px;width: 300px;">
								<input type="button" value="快递运输" style="width: 150px;height: 30px;border-color: red;background-color: #FFFFFF;" />
							</div>
							<div style="float: left;margin-left: 50px;margin-top: 10px;">
								配送时间：工作日、双休日、节假日均可送货
							</div>
						</div>
						<div style="float: left;height: 150px;">
							<div style="float: left;margin-left: 50px;margin-top: 10px;">
								商品图片
							</div>
							<div style="float: left;margin-left: 50px;margin-top: 10px;">
								金额:${productSkuVO.priceReal}
							</div>
							<div style="float: left;margin-left: 50px;margin-top: 10px;">
								数量
							</div>
							<div style="float: left;margin-left: 50px;margin-top: 10px;">
								有货
							</div>
						</div>
						<div style="border:1px solid lightgray;height: 200px;">
							
						</div>
						<div style="height: 40px;">
							<div style="float: left;margin-left: 20px;margin-top: 15px;">
								添加订单备注
							</div>
						</div>
						<div style="height: 50px;">
							<div style="float: left;margin-left: 20px;margin-top: 15px;">
								<input type="text" name="remark" style="height: 25px;width: 500px;margin-left: 40px;margin-bottom: 30px;" />
							</div>
							<div style="float: right;margin-right: 20px;margin-top: 15px;">
								<span style="color: darkgray ;">
									提示：请勿填写有关支付、收货、发票方面的信息
								</span>
							</div>
						</div>
						<hr style="width: 1050px;"/>
						<div style="height: 50px;">
							<div style="float: right;margin-right:50px;margin-top: 15px;">
								<span>??</span>
								<span style="margin-right: 50px;">
										总金额：
								</span>
								<span style="float: right;width: 70px;">
									${productSkuVO.priceReal}
								</span>
							</div>
						</div>
						<div style="height: 30px;">
							<div style="float: right;margin-right: 50px;">
								<span style="margin-right: 50px;">
									返现：
								</span>
								<span style="float: right;width: 70px;">
									¥0.00
								</span>
							</div>
						</div>
						<div style="height: 30px;">
							<div style="float: right;margin-right: 50px;">
								<span style="margin-right: 50px;">
									运费：
								</span>
								<span style="float: right;width: 70px;color: coral">
									包邮
								</span>
							</div>
						</div>
						<div style="height: 30px;">
							<div style="float: right;margin-right: 50px;">
								<span style="margin-right: 50px;">
									服务费：
								</span>
								<span style="float: right;width: 70px;">
									¥0.00
								</span>
							</div>
						</div>
						<div style="height: 30px;">
							<div style="float: right;margin-right: 50px;">
								<span style="margin-right: 50px;">
									退换无忧：
								</span>
								<span style="float: right;width: 70px;">
									¥0.00
								</span>
							</div>
						</div>
						<div style="height: 80px;background-color: rgb(235,235,235);margin-top: 20px;">
							<div style="float: right;margin-right: 40px;margin-top: 20px;">
								<span style="margin-right: 50px;">
									应付总额：
								</span>
								<span style="float: right;font-size: 25px;width: 70px;color: red;margin-right: 10px;">
									${productSkuVO.priceReal}
								</span>
							</div>
						</div>
						<div style="height: 30px;background-color: rgb(235,235,235);margin-top: -20px;">
							<div style="float: right;margin-right: 3px;">
								<span style="margin-right: 50px;">
									${basCustomer.contactMobile }
								</span>
							</div>
							<div style="float: right;margin-right: 3px;">
								<span style="margin-right: 10px;">
									${basCustomer.name}
								</span>
							</div>
							<div style="float: right;margin-right: 3px;">
								<span style="margin-right: 10px;">
									${basCustomer.contactName}
								</span>
							</div>
							<div style="float: right;margin-right: 3px;">
								<span style="margin-right: 10px;">
									${basCustomer.address}
								</span>
							</div>
							<div style="float: right;margin-right: 3px;">
								<span style="margin-right: 10px;">
									寄送至：${basCustomer.address}
								</span>
							</div>
						</div>
						<div style="float: right;margin-right: 20px;margin-top: 10px;">
							<a href="/share/SalOrderAction.Action?method=insertall">提交订单</a>

						</div>
					</div>
			</div>	
</body>

</html>