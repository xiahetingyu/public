<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当图书 – 全球最大的中文网上书店</title>
<link href="${ pageContext.request.contextPath }/front/css/book.css"
	rel="stylesheet" type="text/css" />
<link href="${ pageContext.request.contextPath }/front/css/second.css"
	rel="stylesheet" type="text/css" />
<link
	href="${ pageContext.request.contextPath }/front/css/secBook_Show.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js" ></script>
<script>
	$(function() {
		$(".img").mouseover(function(e) {
			var obj = "<img id='bigImg' src='" + $(this).attr('src') + "'/>";
			$("body").append(obj);
		}).mouseout(function() {
			$("#bigImg").remove();
		}).mousemove(function(e) {
			$("#bigImg").css({
				"top" : e.pageY + 5,
				"left" : e.pageX + 5,
				"position" : "absolute",
				"height" : 200
			});
		});
	});
</script>
</head>
<body>
	&nbsp;
	<!-- 头部开始 -->
	<jsp:include page="/front/common/head.jsp" />
	<!-- 头部结束 -->
	<div style="width: 962px; margin: auto;">
		<a href="#" target="_blank"><img
			src="${ pageContext.request.contextPath }/front/images/default/book_banner_081203.jpg"
			border="0" /> </a>
	</div>

	<div class="book">

		<!--左栏开始-->
		<div id="left" class="book_left">
			<jsp:include page="category.jsp" />
		</div>
		<!--左栏结束-->

		<!--中栏开始-->
		<div class="book_center">

			<!--推荐图书开始-->
			<div class="second_c_border1" id="recommend">
				<jsp:include page="recommend.jsp" />
			</div>

			<!--推荐图书结束-->

			<!--热销图书开始-->
			<div class="book_c_border2" id="hot">
				<jsp:include page="hot.jsp" />
			</div>
			<!--热销图书结束-->

			<!--最新上架图书开始-->
			<div class="book_c_border2" id="new">
				<jsp:include page="new.jsp" />
			</div>

			<!--最新上架图书结束-->

			<div class="clear"></div>
		</div>
		<!--中栏结束-->



		<!--右栏开始-->
		<div class="book_right">
			<div class="book_r_border2" id="__XinShuReMai">
				<div class="book_r_b2_1x" id="new_bang">
					<div id="NewProduct_1_o_t" onmouseover="">
						<jsp:include page="hotBoard.jsp" />
					</div>
				</div>
			</div>
		</div>
		<!--右栏结束-->
		<div class="clear"></div>
	</div>

	<!--页尾开始 -->
	<%@include file="../common/foot.jsp"%>
	<!--页尾结束 -->
</body>
</html>
