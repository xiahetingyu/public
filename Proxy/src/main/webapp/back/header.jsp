<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="${ pageContext.request.contextPath}/back/images/favicon.png">

    <title>Proxy</title>

    <!-- Bootstrap CSS -->
    <link href="${ pageContext.request.contextPath}/back/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="${ pageContext.request.contextPath}/back/css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="${ pageContext.request.contextPath}/back/css/elegant-icons-style.css" rel="stylesheet"/>
    <link href="${ pageContext.request.contextPath}/back/css/font-awesome.min.css" rel="stylesheet"/>
    <!-- full calendar css-->
    <link href="${ pageContext.request.contextPath}/back/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css"
          rel="stylesheet"/>
    <link href="${ pageContext.request.contextPath}/back/assets/fullcalendar/fullcalendar/fullcalendar.css"
          rel="stylesheet"/>
    <!-- easy pie chart-->
    <link href="${ pageContext.request.contextPath}/back/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
          rel="stylesheet" type="text/css"
          media="screen"/>
    <!-- owl carousel -->
    <link rel="${ pageContext.request.contextPath}/back/stylesheet" href="css/owl.carousel.css" type="text/css">
    <link href="${ pageContext.request.contextPath}/back/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
    <!-- Custom styles -->
    <link rel="${ pageContext.request.contextPath}/back/stylesheet" href="css/fullcalendar.css">
    <link href="${ pageContext.request.contextPath}/back/css/widgets.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/back/css/style.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/back/css/style-responsive.css" rel="stylesheet"/>
    <link href="${ pageContext.request.contextPath}/back/css/xcharts.min.css" rel=" stylesheet">
    <link href="${ pageContext.request.contextPath}/back/css/jquery-ui-1.10.4.min.css" rel="stylesheet">

</head>

<body>
<!-- container section start -->
<section id="container" class="">


    <header class="header dark-bg">
        <div class="toggle-nav">
            <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"></div>
        </div>

        <!--logo start-->
        <a href="${ pageContext.request.contextPath}/user/selectps.do" class="logo"><img
                src="${ pageContext.request.contextPath}/back/images/logo.png" alt="代理"></a>
        <!--logo end-->

        <div class="top-nav notification-row">
            <!-- notificatoin dropdown start-->
            <ul class="nav pull-right top-menu">
                <!-- user login dropdown start-->
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <img alt="" src="${ pageContext.request.contextPath}/back/images/avatar1_small.jpg">
                            </span>
                        <span class="username">${sessionScope.admin.username}</span>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu extended logout">
                        <div class="log-arrow-up"></div>
                        <li class="eborder-top">
                            <a href="#"><i class="icon_profile"></i>我的账号</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/user/signout.do?permission=2"><i
                                    class="icon_key_alt"></i> 登出</a>
                        </li>
                    </ul>
                </li>
                <!-- user login dropdown end -->
            </ul>
            <!-- notificatoin dropdown end-->
        </div>
    </header>
    <!--header end-->

    <!--sidebar start-->
    <aside>
        <div id="sidebar" class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu">
                <li>
                    <a href="${ pageContext.request.contextPath}/user/selectps.do">
                        <i class="icon_desktop"></i>
                        <span>用户管理</span>
                    </a>
                </li>
                <li>
                    <a href="${ pageContext.request.contextPath}/proxy/selectps.do">
                        <i class="icon_genius"></i>
                        <span>代理管理</span>
                    </a>
                </li>
                <li class="sub-menu">
                    <a href="${ pageContext.request.contextPath}/recharge/selectps.do" class="">
                        <i class="icon_document_alt"></i>
                        <span>充值订单</span>
                    </a>
                </li>
                <li>
                    <a class="" href="${ pageContext.request.contextPath}/orderr/selectps.do">
                        <i class="icon_piechart"></i>
                        <span>购买订单</span>
                    </a>
                </li>
            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->
