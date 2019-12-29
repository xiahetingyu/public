<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> 首页</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="${ pageContext.request.contextPath}/img/favicon.png">
    <link href="${ pageContext.request.contextPath}/front/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/animate.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="wrapper wrapper-content animated fadeInRight">

                    <div class="ibox-content m-b-sm border-bottom">
                        <img src="${pageContext.request.contextPath}/front/img/help_process.png">
                    </div>
                    <div class="ibox-content m-b-sm border-bottom">
                        <img src="${pageContext.request.contextPath}/front/img/foru.png">
                    </div>

                    <div class="ibox-content forum-container">
                        <div class="forum-item">
                            <div class="row">
                                <div class="col-sm-9">
                                    <div class="forum-icon">
                                        <i class="fa fa-clock-o"></i>
                                    </div>
                                    <a class="forum-item-title">
                                        广告补量 </a>
                                    <div class="forum-sub-title">“我们最担心不是真实IP，我们更希望使用IP的接口能灵活，代理技术支持响应快，给他们点赞”
                                    </div>
                                </div>
                                <div class="col-sm-1 forum-info">
                                        <span class="views-number">
                                            1516
                                        </span>
                                    <div>
                                        <small>浏览</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="forum-item">
                            <div class="row">
                                <div class="col-sm-9">
                                    <div class="forum-icon">
                                        <i class="fa fa-bomb"></i>
                                    </div>
                                    <a class="forum-item-title">行业代理</a>
                                    <div class="forum-sub-title">“我们在这个行业十几年了，代理的技术架构是开创性的，是未来的方向，我们希望能够更深入的合作”
                                    </div>
                                </div>
                                <div class="col-sm-1 forum-info">
                                        <span class="views-number">
                                            1766
                                        </span>
                                    <div>
                                        <small>浏览</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="forum-item">
                            <div class="row">
                                <div class="col-sm-9">
                                    <div class="forum-icon">
                                        <i class="fa fa-bookmark"></i>
                                    </div>
                                    <a href="forum_post.html" class="forum-item-title">爬虫数据采集</a>
                                    <div class="forum-sub-title">
                                        “我们使用的IP地址量大，每天需要200万个，要求使用过程中不能中断，可用度要高。现在挺满意”
                                    </div>
                                </div>
                                <div class="col-sm-1 forum-info">
                                        <span class="views-number">
                                            765
                                        </span>
                                    <div>
                                        <small>浏览</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${ pageContext.request.contextPath}/front/js/jquery.min.js?v=2.1.4"></script>
<script src="${ pageContext.request.contextPath}/front/js/bootstrap.min.js?v=3.3.6"></script>


<!-- Peity -->
<script src="${ pageContext.request.contextPath}/front/js/plugins/peity/jquery.peity.min.js"></script>

<!-- 自定义js -->
<script src="${ pageContext.request.contextPath}/front/js/content.js?v=1.0.0"></script>


</body>

</html>
