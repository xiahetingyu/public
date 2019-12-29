<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<html>
<head>
	<title>图书详情</title>
	<link rel="stylesheet" type="text/css"
		href="${ pageContext.request.contextPath }/front/css/book_detail.css" />
	<link
		href="${ pageContext.request.contextPath }/front/css/public_footer.css"
		rel="stylesheet" type="text/css" />
	<style type="text/css">
		table {
			margin: 0px auto;
		}
		
		table td {
			padding: 10px;
			text-align: center;
		}
	</style>
</head>
<body>
	<br />
	<div>
		<h1>丛书名：${ product.name }</h1>
		<hr />
	</div>
	<table>
		<tr>
			<td rowspan="9" width="20%" valign="top"><img src="${ product.cover }"
				width="240px" height="340px" /></td>
			<td colspan="2">作者：${ product.author }</td>
		</tr>
		<tr>
			<td colspan="2">出版社：${ product.press }</td>
		</tr>
		<tr>
			<td>出版时间：<f:formatDate value="${ product.press_date }" pattern="yyyy-MM-dd" /></td>
			<td>字数：${ product.word_num }</td>
		</tr>
		<tr>
			<td>版次：${ product.edition }</td>
			<td>页数：${ product.page_num }</td>
		</tr>
		<tr>
			<td>印刷时间：<f:formatDate value="${ product.print_date }"
					pattern="yyyy-MM-dd" /></td>
			<td>开本：${ product.size }</td>
		</tr>
		<tr>
			<td>印次：${ product.impression }</td>
			<td>纸张：${ product.paper }</td>
		</tr>
		<tr>
			<td>ISBN：${ product.isbn }</td>
			<td>包装：${ product.pack }</td>
		</tr>
		<tr>
			<td colspan="2">定价：￥ ${ product.price }&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥ ${ product.dprice }</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥ ${ product.price- product.dprice}
			</td>
		</tr>
		<tr>
			<td colspan="2"><a href="${ pageContext.request.contextPath }/car/insert?product.id=${ product.id }"> <img
					src='${ pageContext.request.contextPath }/front/images/buttom_goumai.gif' />
			</a></td>
		</tr>
	</table>
	<hr style="border: 1px dotted #666" />
	<h2>编辑推荐</h2>
	<p>${ product.editor_recommend }</p>
	<hr style="border: 1px dotted #666" />
	<h2>内容简介</h2>
	<p>${ product.content_abstract }</p>
	<hr style="border: 1px dotted #666" />
	<h2>作者简介</h2>
	<p>${ product.author_abstract }</p>
	<hr style="border: 1px dotted #666" />
	<h2>目录</h2>
	<p>${ product.director }</p>
	<hr style="border: 1px dotted #666" />
	<h2>媒体评论</h2>
	<p>${ product.media_commentary }</p>
	<hr style="border: 1px dotted #666" />
	<h2>书摘插图</h2>
	<p>&nbsp;&nbsp;</p>
	<!--页尾开始 -->
	<div class="public_footer">
		<div class="public_footer_bottom">
			<div class="public_footer_icp" style="line-height: 48px;">
				Copyright (C) 当当网 2004-2008, All Rights Reserved <a href="#"
					target="_blank"><img
					src="${ pageContext.request.contextPath }/front/images/bottom/validate.gif"
					border="0" align="middle" /> </a> <a href="#" target="_blank"
					style="color: #666;">京ICP证041189号</a>
			</div>
		</div>
	</div>
	<!--页尾结束 -->
</body>
</html>
