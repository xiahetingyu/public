<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<%@page contentType="text/html;charset=utf-8"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach items="${ requestScope.map.new1 }" var="product">
		<div class="second_d_wai">
			<div class="img">
				<a href="${ pageContext.request.contextPath }/product/select?product.id=${ product.id }&product.other=detail" target='_blank'> <img class="img" src="${ product.cover }"
					border=0 />
				</a>
			</div>
			<div class="shuming">
				<a href="${ pageContext.request.contextPath }/product/select?product.id=${ product.id }&product.other=detail" target="_blank">${ product.name }</a><a href="#"
					target="_blank"></a>
			</div>
			<div class="price">定价：￥${ product.price }</div>
			<div class="price">当当价：￥${ product.dprice }</div>
			<div class="price">
				销量：<font color="red">${ product.sale }</font>
			</div>
		</div>
		<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>