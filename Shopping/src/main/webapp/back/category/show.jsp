<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<html>
	<head>
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/back/css/btn.css" />
		<style type="text/css">
			table{
				margin:0px auto;
				border: 2px solid #898E90; 
			}
			tr,td{
				border: 1px solid #898E90; 
			}
		</style>
	</head>
	<body style="background-color: #f0f9fd;text-align: center;">
	
		<div style="font-size:25px">类别管理</div><hr/>
		<div style="margin-bottom: 10px;">
			<div class="button btn-p" onclick="location.href='${ pageContext.request.contextPath }/back/category/add-first.jsp'">添加一级类别&raquo;</div>
			<div class="button btn-p" onclick="location.href='${ pageContext.request.contextPath }/clazz/showFirst'">添加二级类别&raquo;</div>
		</div>
		<table >
			<tr bgcolor='lightblue'>
				<td>Id</td>
				<td>类别名</td>
				<td>所属类别</td>
				<td>级别</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${ requestScope.clazzs }" var="temp">
					<tr>
						<td>${ temp.id }</td>
						<td>${ temp.name}</td>
						<td>${ temp.p}</td>
						<td>${ temp.level }</td>
						<td>
							<div class="button" onclick="location.href='${ pageContext.request.contextPath }/clazz/remove?clazz.id=${ temp.id }' ">删除 &raquo;</div>	
						</td>
					</tr>
				<c:forEach items="${ temp.clazzs }" var="clazz">
					<tr>
						<td>${ clazz.id }</td>
						<td>${ clazz.name}</td>
						<td>${ temp.name}</td>
						<td>${ clazz.level }</td>
						<td>
							<div class="button" onclick="location.href='${ pageContext.request.contextPath }/clazz/remove?clazz.id=${ clazz.id }' ">删除 &raquo;</div>	
						</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
	</body>  
</html>



