<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>登录</title>
    <link href="${ pageContext.request.contextPath}/front/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/animate.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/style.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/login.css" rel="stylesheet">
    <link rel="shortcut icon" href="${ pageContext.request.contextPath}/img/favicon.png">
</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-12">
            <form method="post" action="${ pageContext.request.contextPath}/user/signin.do">
                <h4 class="no-margins">登录：</h4>
                <span style="color: red">${requestScope.message}</span>
                <input type="text" class="form-control uname" placeholder="手机号" name="username"/>
                <input type="password" class="form-control pword m-b" placeholder="密码" name="password"/>
                <input type="text" class="form-control" placeholder="验证码" required="" name="other"
                       style="width:180px;display: inline"/>
                <img id="systemCode" src="${ pageContext.request.contextPath}/user/systemCode.do" onclick="code()"
                     style="width: 70px;height: 30px;"/>
                <a href="${ pageContext.request.contextPath}/front/signup.jsp">没有账号？</a>
                <button class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; PROXY
        </div>
    </div>
</div>

</body>
<script>
    function code() {
        var elementById = document.getElementById("systemCode");
        elementById.src = "${ pageContext.request.contextPath}/user/systemCode.do?code=" + Math.random();
    }
</script>
</html>
