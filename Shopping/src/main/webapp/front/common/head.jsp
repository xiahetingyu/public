<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<link href="${ pageContext.request.contextPath }/front/css/book_head090107.css" rel="stylesheet" type="text/css" />
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> 
				<span class="little_n">
					| <a href="#"   class="head_black12a">我的当当</a> | 
					<a href="#"  class="head_black12a" target="_blank">帮助</a>| 
				</span> 
			</span>
			<div class="cart gray4012">
				<a href="${ pageContext.request.contextPath }/front/cart/cart_list.jsp">购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo">
		<c:if test="${!empty sessionScope.user }">
			<b>${sessionScope.user.nickname }你好呀!</b>
			[&nbsp;<a href="${ pageContext.request.contextPath }/user/signout?user.other=usersignin.jsp" class="b">登出</a>&nbsp;]
		</c:if>
		
		<c:if test="${empty sessionScope.user }">
			<b>您好，欢迎光临当当网</b>
			[&nbsp;<a href="${ pageContext.request.contextPath }/front/user/login_form.jsp" class="b">登录</a>|
			<a href="${ pageContext.request.contextPath }/front/user/register_form.jsp" class="b">注册</a>&nbsp;]
		</c:if>
		</span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo">
				<a href="#"  >
					<img src="${ pageContext.request.contextPath }/front/images/booksaleimg/book_logo.gif" /> 
				</a> 
			</span>
		</div>
		<div class="head_head_list_right">
			<div class="head_head_list_right_b"></div>
		</div>
	</div>
	<div class="head_search_div">

	</div>
	<div class="head_search_bg"></div>
</div>
