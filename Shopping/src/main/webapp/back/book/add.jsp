<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/back/css/btn.css" />

<style type="text/css">
td {
	padding-top: 8px;
}

#file_upload1 {
	display: none;
}

#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}

</style>


</head>

<body
	style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">添加图书</div>
	<hr />
	<div align="center">
		<form action="${ pageContext.request.contextPath }/product/insert" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>名称：</td>
					<td><input type="text" name="product.name" class="el-input__inner"></td>
					<td rowspan="14" style="width: 300px">
					<td>页数：</td>
					<td><input type="number" name="product.page_num" class="el-input__inner"></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
						<select name="product.c_id" class="el-select__inner inner2">
							<c:forEach items="${ clazzs }" var="clazz">
								<option value="${ clazz.id }">${ clazz.name }</option>
							</c:forEach>
						</select>
					</td>
					<td>字数：</td>
					<td><input type="number" name="product.word_num" class="el-input__inner"></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="number" name="product.price" class="el-input__inner"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<span id="uploadtip">添加图书封面</span> 
							<img id="uploadimg" src="" alt="" width="118px" height="143px" />
						</label> 
						<input type="file" name="image" class="" id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				
				<tr>
					<td>当当价：</td>
					<td><input type=number name="product.dprice" class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="product.stock" class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="product.author" class="el-input__inner"></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="product.editor_recommend"></textarea></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="product.press" class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="product.press_date" class="el-input__inner"></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="product.content_abstract"></textarea></td>
				</tr>
				<tr>
					<td>版次：</td>
					<td><input type="text" name="product.edition" class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>印刷时间：</td>
					<td><input type="date" name="product.print_date" class="el-input__inner"></td>
					<td>作者简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="product.author_abstract"></textarea></td>
				</tr>
				<tr>
					<td>印次：</td>
					<td><input type="text" name="product.impression" class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="product.isbn" class="el-input__inner"></td>
					<td>基本目录：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="product.director"></textarea></td>
				</tr>
				<tr>
					<td>开本：</td>
					<td><input type="text" name="product.size" class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>纸张：</td>
					<td><input type="text" name="product.paper" class="el-input__inner"></td>
					<td>媒体评论：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="product.media_commentary"></textarea></td>
				</tr>
				<tr>
					<td>包装：</td>
					<td><input type="text" name="product.pack" class="el-input__inner"></td>
					<td></td>
				</tr>
			</table>
			<input type="submit" class="button btn-p" value="提交" />&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="location='${ pageContext.request.contextPath }/product/show'" />
		</form>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>
