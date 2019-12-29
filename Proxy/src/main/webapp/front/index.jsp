<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>Proxy</title>
    <link rel="shortcut icon" href="${ pageContext.request.contextPath}/img/favicon.png">
    <link href="${ pageContext.request.contextPath}/front/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/animate.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <strong class="font-bold">${sessionScope.user.username}</strong>
                                    </span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">${sessionScope.user.username}</div>
                </li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">首页</span>
                </li>
                <li>
                    <a class="J_menuItem" href="${ pageContext.request.contextPath}/front/help.jsp">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">主页</span>
                    </a>
                </li>
                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">充值与购买</span>
                </li>
                <li>
                    <a class="J_menuItem" href="${ pageContext.request.contextPath}/other/show.do?index=0">
                        <i class="fa fa-edit"></i>
                        <span class="nav-label">账户充值</span>
                    </a>
                    <a class="J_menuItem" href="${ pageContext.request.contextPath}/other/show.do?index=1">
                        <i class="fa fa-desktop"></i>
                        <span class="nav-label">购买代理</span>
                    </a>
                </li>
                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">历史</span>
                </li>
                <li>
                    <a class="J_menuItem"
                       href="${pageContext.request.contextPath}/recharge/selectps.do?size=10000&other=/front/rhistory.jsp">
                        <i class="fa fa-flask"></i>
                        <span class="nav-label">充值记录</span>
                    </a>
                    <a class="J_menuItem"
                       href="${pageContext.request.contextPath}/orderr/selectps.do?size=10000&other=/front/ohistory.jsp">
                        <i class="fa fa-table"></i>
                        <span class="nav-label">购买记录</span>
                    </a>
                </li>
                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">其它</span>
                </li>
                <li>
                    <a class="J_menuItem" href="${pageContext.request.contextPath}/front/api.jsp">
                        <i class="fa fa-envelope"></i>
                        <span class="nav-label">查看API</span>
                    </a>
                    <a class="J_menuItem" onclick="out()">
                        <i class="fa fa-table"></i>
                        <span class="nav-label">退出登陆</span>
                    </a>
                    <script>
                        function out() {
                            window.parent.location.href = "${pageContext.request.contextPath}/user/signout.do?permission=1";
                        }
                    </script>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row J_mainContent" id="content-main">
            <iframe id="J_iframe" width="100%" height="100%"
                    src="${ pageContext.request.contextPath}/${(empty param.page)?("other/show.do?index=0"):(param.page)}"
                    frameborder="0"
                    data-id="index_v1.html" seamless></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
</div>

<!-- 全局js -->
<script src="${ pageContext.request.contextPath}/front/js/jquery.min.js?v=2.1.4"></script>
<script src="${ pageContext.request.contextPath}/front/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${ pageContext.request.contextPath}/front/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${ pageContext.request.contextPath}/front/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${ pageContext.request.contextPath}/front/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="${ pageContext.request.contextPath}/front/js/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath}/front/js/index.js"></script>

<!-- 第三方插件 -->
<script src="${ pageContext.request.contextPath}/front/js/plugins/pace/pace.min.js"></script>

</body>

</html>
