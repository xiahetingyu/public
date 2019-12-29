<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>


<html>
<head>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath }/back/css/btn.css" />
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
<body style="background-color: #f0f9fd;">
	<div align=center style="font-size: 25px">用户管理</div>
	<hr />
	<table>
		<tr bgcolor='lightblue' align='center'>
			<td>Id</td>
			<td>昵称</td>
			<td>邮箱</td>
			<td>状态</td>
			<td>激活码</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${ requestScope.users }" var="user">
			<tr align='center'>
				<td>${ user.id }</td>
				<td>${ user.nickname }</td>
				<td>${ user.email }</td>
				<td>${ user.permission > 0?'正常':'被锁定' }</td>
				<td>${ user.code }</td>
				<td><input type="button" onclick="location.href='${ pageContext.request.contextPath }/user/permission?user.email=${user.email }'" value="修改 " />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>



