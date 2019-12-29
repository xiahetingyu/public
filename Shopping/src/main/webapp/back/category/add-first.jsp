<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html>
<html>
  <head>
    <title>index.html</title>
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/back/css/btn.css" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">
    <script type="text/javascript" src="${ pageContext.request.contextPath }/back/js/jquery-3.3.1.js"></script>
  </head>
  
  <body style="background-color: #f0f9fd;text-align: center">
  	<div style="text-align: center;font-size: 18px">添加商品类别</div><hr/>
  	<form action="${ pageContext.request.contextPath }/clazz/add" method="post">
  		类别名:<input class="el-input__inner" type="text" name="clazz.name" id="fname"/><span id="fnameMsg"></span><br/><br/>
  		<input class="button btn-p" type="submit" value="提交">&emsp;
  		<input name="clazz.level" value="1" type="hidden"/>
		<input class="button btn-p" type="button" value="返回上级" onclick="location='${ pageContext.request.contextPath }/clazz/show'"/>
  	</form>
    	
  </body>
</html>
