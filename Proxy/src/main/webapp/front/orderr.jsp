<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>购买代理</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="${ pageContext.request.contextPath}/img/favicon.png">
    <link href="${ pageContext.request.contextPath}/front/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${ pageContext.request.contextPath}/front/css/animate.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<form method="post" action="${ pageContext.request.contextPath}/orderr/generate.do">
    <div class="row">
        <div class="wrapper wrapper-content animated fadeInUp">
            <div class="ibox">
                <div class="ibox-content">
                    <div class="row m-t-sm">
                        <div class="col-sm-12">
                            <div class="panel blank-panel">
                                <div class="col-sm-12">
                                    <div class="m-b-md">
                                        <h2>购买代理</h2>
                                        <span class="label">当前账户代理余量：${(empty requestScope.other.count)?0:requestScope.other.count}个</span>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tab-1">
                                            <table class="table table-striped">
                                                <thead>
                                                <tr>
                                                    <th>可选套餐</th>
                                                    <th>编号</th>
                                                    <th>购买数量</th>
                                                    <th>消费金额</th>
                                                    <th>支付方式</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>
                                                        <input type="radio" value="100" name="other"/>
                                                    </td>
                                                    <td>
                                                        1
                                                    </td>
                                                    <td>
                                                        100
                                                    </td>
                                                    <td>
                                                        1
                                                    </td>
                                                    <td>
                                                        <p class="small">
                                                            账户余额
                                                        </p>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input type="radio" value="500" name="other"/>
                                                    </td>
                                                    <td>
                                                        2
                                                    </td>
                                                    <td>
                                                        500
                                                    </td>
                                                    <td>
                                                        5
                                                    </td>
                                                    <td>
                                                        <p class="small">
                                                            账户余额
                                                        </p>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input type="radio" value="1000" name="other"
                                                               checked="checked"/>
                                                    </td>
                                                    <td>
                                                        3
                                                    </td>
                                                    <td>
                                                        1000
                                                    </td>
                                                    <td>
                                                        10
                                                    </td>
                                                    <td>
                                                        <p class="small">
                                                            账户余额
                                                        </p>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input type="radio" value="2000" name="other"/>
                                                    </td>
                                                    <td>
                                                        4
                                                    </td>
                                                    <td>
                                                        2000
                                                    </td>
                                                    <td>
                                                        20
                                                    </td>
                                                    <td>
                                                        <p class="small">
                                                            账户余额
                                                        </p>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input type="radio" value="5000" name="other"/>
                                                    </td>
                                                    <td>
                                                        5
                                                    </td>
                                                    <td>
                                                        5000
                                                    </td>
                                                    <td>
                                                        50
                                                    </td>
                                                    <td>
                                                        <p class="small">
                                                            账户余额
                                                        </p>
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                            <table class="table table-striped">
                                                <tbody>
                                                <tr>
                                                    <td>
                                                        <div style="margin-left: 110px">
                                                            除了选择以上套餐你还可以自定义购买数量：<input type="text" name="username"/>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <button type="submit" class="btn btn-primary"
                                                                style="margin-right: 100px">
                                                            购买
                                                        </button>
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
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
</form>
<!-- 全局js -->
<script src="${ pageContext.request.contextPath}/front/js/jquery.min.js?v=2.1.4"></script>
<script src="${ pageContext.request.contextPath}/front/js/bootstrap.min.js?v=3.3.6"></script>


<!-- 自定义js -->
<script src="${ pageContext.request.contextPath}/front/js/content.js?v=1.0.0"></script>


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
