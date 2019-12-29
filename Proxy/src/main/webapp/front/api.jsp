<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>查看AIP</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="${ pageContext.request.contextPath}/img/favicon.png">
    <link href="${ pageContext.request.contextPath}/front/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/animate.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/plugins/codemirror/codemirror.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/plugins/codemirror/ambiance.css" rel="stylesheet">
    <link href="${ pageContext.request.contextPath}/front/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="ibox ">
            <div class="ibox-title">
                <h5>API示例</h5>
            </div>
            <div class="ibox-content">

                <p class="m-b-lg">
                    <strong>你的API调用地址是：</strong>http://localhost:8989/Proxy/proxy/take.do?username=${sessionScope.user.username}&password=${sessionScope.user.password}&phoneCode=${sessionScope.user.phoneCode}
                </p>
                <p class="text-danger">此API会随着账户密码的更改而更改，使用时请注意。</p>
                <p class="text-danger">访问此地址即可以JSON格式获取代理IP，使用示例参考以下代码：</p>
                <textarea id="code2">
package other;

import org.junit.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class API {

    @Test//获取代理IP
    public void api() throws Exception {
        String api = "http://localhost:8989/Proxy/proxy/take.do?username=xxx&password=xxx&phoneCode=xxx";
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(api).openConnection();
        httpURLConnection.setRequestMethod("GET");
        Scanner scanner = new Scanner(httpURLConnection.getInputStream());
        String result = scanner.nextLine();
        System.out.println(result);
    }

}
                </textarea>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${ pageContext.request.contextPath}/front/js/jquery.min.js?v=2.1.4"></script>
<script src="${ pageContext.request.contextPath}/front/js/bootstrap.min.js?v=3.3.6"></script>

<!-- Peity -->
<script src="${ pageContext.request.contextPath}/front/js/plugins/peity/jquery.peity.min.js"></script>

<!-- CodeMirror -->
<script src="${ pageContext.request.contextPath}/front/js/plugins/codemirror/codemirror.js"></script>
<script src="${ pageContext.request.contextPath}/front/js/plugins/codemirror/mode/javascript/javascript.js"></script>

<!-- 自定义js -->
<script src="${ pageContext.request.contextPath}/front/js/content.js?v=1.0.0"></script>

<script>
    $(document).ready(function () {
        var editor_two = CodeMirror.fromTextArea(document.getElementById("code2"), {
            lineNumbers: true,
            matchBrackets: true,
            styleActiveLine: true
        });

    });
</script>


</body>

</html>
