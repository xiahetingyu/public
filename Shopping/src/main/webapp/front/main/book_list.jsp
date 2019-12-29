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
<link href="${ pageContext.request.contextPath }/front/css/list.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${ pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>

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
	
	function a(e){
		window.location.href="${ pageContext.request.contextPath }/product/second?page.p=${map.page.p}&page.c=${map.page.c}&page.q=${map.page.q}&page.index=${map.page.index}&page.order="+e.value;
	}
</script>
<style type="text/css">
table {
	border-right: 1px solid black;
	border-bottom: 1px solid black;
	margin: 0px auto;
	border: 2px solid #898E90;
}

tr, td {
	border: 1px solid #898E90;
}

table td {
	padding: 10px;
	text-align: center;
	border-left: 1px solid black;
	border-top: 1px solid black;
}
</style>
</head>
<body>
	&nbsp;
	<!-- 头部开始 -->
	<%@include file="../common/head.jsp"%>
	<!-- 头部结束 -->

	<div style="width: 962px; margin: auto;">
		<a href="#"><img
			src="${ pageContext.request.contextPath }/front/images/default/book_banner_081203.jpg"
			border="0" /> </a>
	</div>
	<div class='your_position'>
		您现在的位置:&nbsp; <a
			href='${ pageContext.request.contextPath }/product/index'>当当图书</a>
		&gt;&gt; <font style='color: #cc3300'><strong>${ map.clazz.name }</strong></font>
	</div>

	<div class="book">

		<!--左栏开始-->
		<div id="left" class="book_left">
			<div id="__fenleiliulan">
				<div class="second_l_border2">
					<h2>分类浏览</h2>
					<ul>
						<li>
							<div>
								<div class="second_fenlei">
									<a
										href="${ pageContext.request.contextPath }/product/second?page.p=${map.clazz.id}&page.q=1">
										&middot; <c:if test="${ map.page.q==1 }">
											<font style='color: #cc3300'><strong>全部</strong></font>
										</c:if> <c:if test="${ map.page.q!=1 }">
											<strong>全部</strong>
										</c:if> &nbsp;
									</a>
								</div>
							</div>
							<div class="clear"></div>
						</li>

						<!--  开始  -->
						<c:forEach items="${ map.clazz.clazzs }" var="clazz">
							<li>
								<div>
									<div class="second_fenlei">&middot;</div>
									<div class="second_fenlei">
										<a
											href="${ pageContext.request.contextPath }/product/second?page.p=${map.clazz.id}&page.q=2&page.c=${ clazz.id }">
											<c:if
												test="${ map.page.q==2 && map.page.c==clazz.id}">
												<font style='color: #cc3300'>${ clazz.name }</font>
											</c:if> <c:if
												test="${ !( map.page.q==2 && map.page.c==clazz.id) }">
											${ clazz.name }
										</c:if>
										</a>
									</div>
								</div>
								<div class="clear"></div>
							</li>
						</c:forEach>
						<!--2级分类结束-->

					</ul>
				</div>
			</div>
		</div>

		<!--左栏结束-->

		<!--中栏开始-->
		<div class="book_center">

			<!--图书列表开始-->
			<div id="divRight" class="list_right">

				<div id="book_list" class="list_r_title">
					<div class="list_r_title_text">排序方式</div>
					<select onchange='a(this)' name='page.order' size='1'
						class='list_r_title_ml'>
						<option value="create_date desc" ${ (map.page.order eq 'create_date desc') ? 'selected':'' }>按上架时间 降序</option>
						<option value="create_date asc" ${ (map.page.order eq 'create_date asc') ? 'selected':'' }>按上架时间 升序</option>
						<option value="sale desc" ${ (map.page.order eq 'sale desc') ? 'selected':'' }>按销量 降序</option>
						<option value="sale asc" ${ (map.page.order eq 'sale asc') ? 'selected':'' }>按销量 升序</option>
					</select>
					<div id="divTopPageNavi" class="list_r_title_text3">

						<!--分页导航开始-->

						<div class='list_r_title_text3a'>
							<c:if test="${!(map.page.index gt 1) }">
								<img src='${ pageContext.request.contextPath }/front/images/page_up_gray.gif' />
							</c:if>
							<c:if test="${map.page.index gt 1 }">
								<a name="link_page_next" href="${ pageContext.request.contextPath }/product/second?page.p=${map.page.p}
								&page.c=${map.page.c}&page.q=${map.page.q}&page.index=1&page.order=${map.page.order}">
									<img src='${ pageContext.request.contextPath }/front/images/page_up.gif' />
								</a>
							</c:if>
						</div>

						<div class='list_r_title_text3a'>
							<c:if test="${!(map.page.index gt 1) }">
								<img src='${ pageContext.request.contextPath }/front/images/page_up_gray.gif' />
							</c:if>
							<c:if test="${map.page.index gt 1 }">
								<a name="link_page_next" href="${ pageContext.request.contextPath }/product/second?page.p=${map.page.p}
								&page.c=${map.page.c}&page.q=${map.page.q}&page.index=${map.page.index-1 }&page.order=${map.page.order}">
									<img src='${ pageContext.request.contextPath }/front/images/page_up.gif' />
								</a>
							</c:if>
						</div>

						<div class='list_r_title_text3b'>第${ map.page.index }页/共${ map.page.page }页</div>

						<div class='list_r_title_text3a'>
							<c:if test="${!(map.page.index lt map.page.page) }">
								<img src='${ pageContext.request.contextPath }/front/images/page_down_gray.gif' />
							</c:if>
							<c:if test="${map.page.index lt map.page.page }">
								<a name="link_page_next" href="${ pageContext.request.contextPath }/product/second?page.p=${map.page.p}
								&page.c=${map.page.c}&page.q=${map.page.q}&page.index=${map.page.index+1 }&page.order=${map.page.order}">
								 <img src='${ pageContext.request.contextPath }/front/images/page_down.gif' />
								</a>
							</c:if>
						</div>

						<div class='list_r_title_text3a'>
							<c:if test="${!(map.page.index lt map.page.page) }">
								<img src='${ pageContext.request.contextPath }/front/images/page_down_gray.gif' />
							</c:if>
							<c:if test="${map.page.index lt map.page.page }">
									<a name="link_page_next" href="${ pageContext.request.contextPath }/product/second?page.p=${map.page.p}
									&page.c=${map.page.c}&page.q=${map.page.q}&page.index=${map.page.page}&page.order=${map.page.order}">
										<img src='${ pageContext.request.contextPath }/front/images/page_down.gif' />
									</a>
							</c:if>
						</div>

						<!--分页导航结束-->
					</div>
				</div>

				<!--商品条目开始-->

				<div class="list_r_line"></div>

				<c:forEach items="${ map.products }" var="product">
					<div class="clear"></div>
					<div class="list_r_list">
						<span class="list_r_list_book"> <a name="link_prd_img"
							href="${ pageContext.request.contextPath }/product/select?product.id=${ product.id }&product.other=detail"><img
								class="img" src="${ product.cover }" /> </a>
						</span>
						<h2>
							<a name="link_prd_name"
								href='${ pageContext.request.contextPath }/product/select?product.id=${ product.id }&product.other=detail'>${ product.name }</a>
						</h2>
						<h3>顾客评分：100</h3>
						<h4 class="list_r_list_h4">
							作 者: <a href='#' name='作者'>${ product.author }</a>
						</h4>
						<h4>
							出版社： <a href='#' name='出版社'>${ product.press }</a>
						</h4>
						<h4>
							出版时间：
							<f:formatDate value="${ product.press_date }"
								pattern="yyyy-MM-dd" />
						</h4>
						<h5>${ product.content_abstract }</h5>
						<div class="clear"></div>
						<h6>
							<span class="del">￥ ${ product.price }</span> <span class="red">￥${ product.dprice }</span>
							节省：￥ ${ product.price- product.dprice}
						</h6>
						<span class="list_r_list_button"> <a href="${ pageContext.request.contextPath }/car/insert?product.id=${ product.id }"> <img
								src='${ pageContext.request.contextPath }/front/images/buttom_goumai.gif' />
						</a></span> <span id="cartinfo"></span>
					</div>
					<div class="clear"></div>
				</c:forEach>
				<!--商品条目结束-->
				<div id="divBottomPageNavi" class="fanye_bottom"></div>

			</div>
			<!--图书列表结束-->

		</div>
		<!--中栏结束-->
		<div class="clear"></div>
	</div>

	<!--页尾开始 -->
	<%@include file="../common/foot.jsp"%>
	<!--页尾结束 -->
</body>
</html>
