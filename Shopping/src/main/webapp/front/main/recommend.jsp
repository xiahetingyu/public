<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<h2>编辑推荐</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<c:forEach items="${ requestScope.map.recommend }" var="product">
			<div class=second_c_02_b1>
				<div class=second_c_02_b1_1>
					<a href='${ pageContext.request.contextPath }/product/select?product.id=${ product.id }&product.other=detail' target='_blank'> <img class="img" src="${ product.cover }" width="70px" height="90px" border=0 />
					</a>
				</div>
				<div class=second_c_02_b1_2>
					<h3>
						<a href='${ pageContext.request.contextPath }/product/select?product.id=${ product.id }&product.other=detail' target='_blank' title='输赢'>${ product.name }</a>
					</h3>
					<h4>
						作者：${ product.author } 著 <br /> 出版社：${ product.press }&nbsp;&nbsp;&nbsp;&nbsp; 出版时间：<f:formatDate value="${ product.press_date }"
							pattern="yyyy-MM-dd" />
					</h4>
					<h5>${ product.content_abstract }</h5>
					<h6>
						定价：￥${ product.price }&nbsp;&nbsp; 当当价：￥${ product.dprice } 销量：<font color="red">${ product.sale }</font>
					</h6>
					<div class=line_xx></div>
				</div>
			</div>
		</c:forEach>

	</div>
</div>
