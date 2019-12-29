<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>购买历史</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="${ pageContext.request.contextPath}/img/favicon.png">
    <link href="${ pageContext.request.contextPath}/front/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${ pageContext.request.contextPath}/front/css/animate.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="wrapper wrapper-content animated fadeInUp">
    <div class="row">
        <div class="col-sm-12">

            <div class="ibox">
                <div class="ibox-title">
                    <h5>购买历史</h5>
                </div>
                <div class="ibox-content">
                    <div class="row m-b-sm m-t-sm">
                        <div class="col-md-11">
                            <div class="input-group">
                                <input type="text" placeholder="请输入搜索内容" value="${param.content}"
                                       class="input-sm form-control" id="content"
                                       style="width: 200px;float: right">
                                <select class="form-control" id="condition" style="width: 150px;float: right">
                                    <option ${requestScope.page.condition=="count"?"selected='selected'":""}
                                            value="count">
                                        购买数量
                                    </option>
                                    <option ${requestScope.page.condition=="amount"?"selected='selected'":""}
                                            value="amount">
                                        支付金额
                                    </option>
                                    <option ${requestScope.page.condition=="time"?"selected='selected'":""}
                                            value="time">
                                        Date
                                    </option>
                                </select>
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-sm btn-primary" onclick="search()"> 搜索</button>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="project-list">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <td class="project-status">
                                    编号
                                </td>
                                <td class="project-title">
                                    购买数量
                                </td>
                                <td class="project-completion">
                                    支付金额
                                </td>
                                <td class="project-completion">
                                    订单状态
                                </td>
                                <td class="project-people">
                                    订单日期
                                </td>
                                <td class="project-actions">
                                    删除订单
                                </td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${ requestScope.orderrs}" var="orderr" varStatus="e">
                                <tr>
                                    <td class="project-status">
                                            ${ e.index+1 }
                                    </td>
                                    <td class="project-title">
                                            ${ orderr.count }
                                    </td>
                                    <td class="project-completion">
                                            ${ orderr.amount }
                                    </td>
                                    <td class="project-completion">
                                            ${ orderr.status gt 0?"支付成功":"支付失败"}
                                    </td>
                                    <td class="project-people">
                                            ${ orderr.time }
                                    </td>
                                    <td class="project-actions">
                                        <a href="${ pageContext.request.contextPath}/orderr/deletes.do?ids=${orderr.id}&username=${sessionScope.user.username}&condition=${requestScope.page.condition}&content=${requestScope.page.content}&size=10000&other=/front/ohistory.jsp"
                                           class="btn btn-white btn-sm"><i
                                                class="fa fa-pencil"></i>
                                            删除 </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${ pageContext.request.contextPath}/front/js/jquery.min.js?v=2.1.4"></script>
<script src="${ pageContext.request.contextPath}/front/js/bootstrap.min.js?v=3.3.6"></script>


<!-- 自定义js -->
<script src="${ pageContext.request.contextPath}/front/js/content.js?v=1.0.0"></script>
<script>
    function search() {
        var condition = $("#condition").val();
        var content = $("#content").val();
        window.location.href = "${pageContext.request.contextPath}/orderr/selectps.do?username=${sessionScope.user.username}&condition=" + condition + "&content=" + content + "&size=10000&other=/front/ohistory.jsp";
    }<!--模糊查询-->
</script>

<script>
    $(document).ready(function () {

        $('#loading-example-btn').click(function () {
            btn = $(this);
            simpleLoad(btn, true);

            // Ajax example
//                $.ajax().always(function () {
//                    simpleLoad($(this), false)
//                });

            simpleLoad(btn, false)
        });
    });

    function simpleLoad(btn, state) {
        if (state) {
            btn.children().addClass('fa-spin');
            btn.contents().last().replaceWith(" Loading");
        } else {
            setTimeout(function () {
                btn.children().removeClass('fa-spin');
                btn.contents().last().replaceWith(" Refresh");
            }, 2000);
        }
    }
</script>


</body>
</html>
