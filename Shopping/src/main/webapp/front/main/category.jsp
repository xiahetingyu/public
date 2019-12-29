<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>分类浏览</h2>

		<!--1级分类开始-->
		<c:forEach items="${ requestScope.map.clazzs }" var="clazz">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='${ pageContext.request.contextPath }/product/second?page.p=${clazz.id}&page.q=1'>${ clazz.name }</a>]
				</h3>
				<ul class="ul_left_list">
					<!--2级分类开始-->
					<c:forEach items="${ clazz.clazzs }" var="temp">
						<li><a href='${ pageContext.request.contextPath }/product/second?page.p=${clazz.id}&page.q=2&page.c=${ temp.id }'>${ temp.name }</a></li>
					</c:forEach>
					<!--2级分类结束-->
				</ul>
				<div class="empty_left"></div>
			</div>
		</c:forEach>


		<div class="more2"></div>
		<!--1级分类结束-->
		<div class="bg_old">
			<h3>&nbsp;</h3>
		</div>
	</div>
</div>
