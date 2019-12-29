<%@ page import="java.util.Date" %>
<%@ page import="java.util.Random" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>单据</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="${ pageContext.request.contextPath}/img/favicon.png">
    <link href="${ pageContext.request.contextPath}/front/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${ pageContext.request.contextPath}/front/css/animate.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <form method="post" action="${ pageContext.request.contextPath}/orderr/orderr.do">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox-content p-xl">
                    <div class="row">
                        <div class="col-sm-6"></div>
                        <div class="col-sm-6 text-right">
                            <h4>单据编号：</h4>
                            <h4 class="text-navy"><%=new Random().nextInt(999999999)%>
                            </h4>
                            <address>
                                <strong>夏荷听雨</strong><br>
                                郑州市郑州大学北校区3号楼<br>
                                <abbr title="Phone">联系方式：</abbr> 188 3894 7335
                            </address>
                            <p>
                            <span><strong>日期：</strong> <f:formatDate value="<%= new Date()%>"
                                                                     pattern="yyyy-MM-dd"/></span>
                            </p>
                        </div>
                    </div>

                    <div class="table-responsive m-t">
                        <table class="table invoice-table">
                            <thead>
                            <tr>
                                <th>清单</th>
                                <th>数量</th>
                                <th>单价</th>
                                <th>总价</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>
                                    <div><strong>代理IP购买</strong>
                                    </div>
                                </td>
                                <td>${requestScope.orderr.count}</td>
                                <td>&yen;${requestScope.orderr.amount}元</td>
                                <td>&yen;${requestScope.orderr.amount}元</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- /table-responsive -->

                    <table class="table invoice-total">
                        <tbody>
                        <tr>
                            <td><strong>总计</strong>
                            </td>
                            <td>&yen;${requestScope.orderr.amount}元</td>
                        </tr>
                        </tbody>
                    </table>
                    <input type="hidden" value="${requestScope.orderr.username}" name="username"/>
                    <input type="hidden" value="${requestScope.orderr.amount}" name="amount"/>
                    <input type="hidden" value="${requestScope.orderr.count}" name="count"/>
                    <input type="hidden" value="${requestScope.orderr.status}" name="status"/>
                    <div class="text-right">
                        <button class="btn btn-primary" type="submit"><i class="fa fa-dollar"></i>购买</button>
                    </div>

                    <div class="well m-t"><strong>注意：</strong> 请立即完成购买，否则订单会自动取消。
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

<!-- 全局js -->
<script src="${ pageContext.request.contextPath}/front/js/jquery.min.js?v=2.1.4"></script>
<script src="${ pageContext.request.contextPath}/front/js/bootstrap.min.js?v=3.3.6"></script>


<!-- 自定义js -->
<script src="${ pageContext.request.contextPath}/front/js/content.js?v=1.0.0"></script>


</body>

</html>
