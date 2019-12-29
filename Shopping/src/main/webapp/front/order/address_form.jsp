<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>生成订单 - 当当网</title>
	<link href="${ pageContext.request.contextPath }/front/css/login.css"
		rel="stylesheet" type="text/css" />
	<link
		href="${ pageContext.request.contextPath }/front/css/page_bottom.css"
		rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
	<script>
		function a(e) {
			window.location.href = "${ pageContext.request.contextPath }/address/select?address.id="+ e.value;
		}
	</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		生成订单骤: 1.确认订单 > <span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
	</div>
	<div class="fill_message">
		<p>
			选择地址： <select id="address" onchange='a(this)'>
				<option value="" ${ (empty address.email) ?'selected':'' }>填写新地址</option>
				<c:forEach items="${ requestScope.addresses }" var="address">
					<option value="${address.id }" ${ (address.id==requestScope.address.id) ?'selected':'' }>${ address.name }</option>
				</c:forEach>
			</select>
		</p>
		<form name="ctl00" method="post" action="${ pageContext.request.contextPath }/address/update" id="f">
			<input type="hidden" name="address.id" value="${ requestScope.address.id }" />
			<input type="hidden" name="address.email" value="${ requestScope.address.email }" />

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1">收件人姓名：</td>
					<td><input type="text" class="text_input" name="address.nickname"
						id="receiveName" value="${ requestScope.address.nickname }" />
						<div class="text_left" id="nameValidMsg">
							<p>请填写有效的收件人姓名</p>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">收件人详细地址：</td>
					<td><input type="text" name="address.local" class="text_input"
						id="fullAddress" value="${ requestScope.address.local }" />
						<div class="text_left" id="addressValidMsg">
							<p>请填写有效的收件人的详细地址</p>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">邮政编码</td>
					<td><input type="text" class="text_input" name="address.zip"
						id="postalCode" value="${ requestScope.address.zip }" />
						<div class="text_left" id="codeValidMsg">
							<p>请填写有效的收件人的邮政编码</p>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">手机</td>
					<td><input type="text" class="text_input" name="address.phone"
						id="mobile" value="${ requestScope.address.phone }" />
						<div class="text_left" id="mobileValidMsg">
							<p>请填写有效的收件人的手机</p>
						</div></td>
				</tr>
			</table>

			<div class="login_in">
				<a href="${ pageContext.request.contextPath }/order/gorder"> <input
					id="btnClientRegister" class="button_1" name="submit" type="button"
					value="取消" />
				</a> 
				<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="下一步" />
			</div>
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

