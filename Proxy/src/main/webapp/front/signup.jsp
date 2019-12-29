<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>注册</title>
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
            <form method="post" action="${ pageContext.request.contextPath}/user/signup.do">
                <h4 class="no-margins">注册：</h4>
                <span style="color: red">${requestScope.message}</span>
                <input type="text" class="form-control uname" placeholder="手机号" name="username" id="username"/>
                <input type="text" class="form-control" placeholder="手机验证码" name="phoneCode"
                       style="width:180px;display: inline"/>
                <button id="phoneCode" style="width: 70px;display: inline">获取</button>
                <input type="password" class="form-control pword m-b" placeholder="密码" name="password"/>
                <input type="text" class="form-control" placeholder="系统验证码" required="" name="other"
                       style="width:180px;display: inline"/>
                <img id="systemCode" src="${ pageContext.request.contextPath}/user/systemCode.do" onclick="code()"
                     style="width: 70px;height: 30px;"/>
                <a href="${ pageContext.request.contextPath}/front/signin.jsp">已有账号？</a>
                <button class="btn btn-success btn-block">注册</button>
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
<!-- 全局js -->
<script src="${ pageContext.request.contextPath}/front/js/jquery.min.js?v=2.1.4"></script>
<script src="${ pageContext.request.contextPath}/front/js/bootstrap.min.js?v=3.3.6"></script>
<script>
    function code() {
        var elementById = document.getElementById("systemCode");
        elementById.src = "${ pageContext.request.contextPath}/user/systemCode.do?code=" + Math.random();
    }
    $(function () {

        $("#phoneCode").click(function () {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "${pageContext.request.contextPath}/user/phoneCode.do?username=" + $("#username").val());
            xhr.send(null);

            var count = 60;
            var time = function () {
                count--;
                if (count != 0) {
                    $("#phoneCode").html(count + "s");
                    setTimeout(time, 1000);
                    $("#phoneCode").attr("disabled", true);
                } else {
                    $("#phoneCode").html("获取");
                    $("#phoneCode").attr("disabled", false);
                }
            };
            time();
        });

    });
</script>
</html>
