<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<jsp:include page="/back/header.jsp"/>

<!--main content start-->
<section id="main-content">
    <section class="wrapper">
        <div class="row">
            <div class="col-lg-12">
                <section class="panel">
                    <header class="panel-heading">
                        <label>代理资源</label>
                        <!-- 模糊查询||选框输入框搜索 -->
                        <div style="float: right;text-align: center;margin-right: 50px">
                            <button class="btn btn-primary" onclick="search()">搜索</button>
                        </div>
                        <div style="float: right;text-align: center">
                            <input type="text" class="form-control" placeholder="搜索内容" id="content"
                                   value="${param.content}">
                        </div>
                        <div style="float: right;text-align: center">
                            <select class="form-control" id="condition">
                                <option ${requestScope.page.condition=="ip"?"selected='selected'":""} value="ip">
                                    IP
                                </option>
                                <option ${requestScope.page.condition=="port"?"selected='selected'":""} value="port">
                                    Port
                                </option>
                                <option ${requestScope.page.condition=="time"?"selected='selected'":""} value="time">
                                    Date
                                </option>
                            </select>
                        </div>
                    </header>
                    <table class="table table-striped table-advance table-hover">
                        <tbody>
                        <tr><!--  表头 -->
                            <th><a onclick="selectAll(this)">全选</a></th>
                            <th><i class="icon_profile"></i> ID</th>
                            <th><i class="icon_mobile"></i> IP</th>
                            <th><i class="icon_pin_alt"></i> Port</th>
                            <th><i class="icon_mail_alt"></i> 可用性</th>
                            <th><i class="icon_calendar"></i> 更新时间</th>
                            <th><i class="icon_cogs"></i> 更新</th>
                            <th><i class="icon_cogs"></i> 删除</th>
                        </tr>
                        <form method="post" action="${ pageContext.request.contextPath}/proxy/deletes.do">
                            <input type="hidden" value="${requestScope.page.index}" name="index"/>
                            <input type="hidden" value="${requestScope.page.condition}" name="condition"/>
                            <input type="hidden" value="${requestScope.page.content}" name="content"/>

                            <c:forEach items="${ requestScope.proxyes}" var="proxy" varStatus="e">
                            <!-- 表体 -->
                            <tr>
                                <td><input type="checkbox" style="width: 20px" name="ids" class="checkbox form-control"
                                           value="${proxy.id}">
                                </td>
                                <td>${ e.index+1 }</td>
                                <td>${ proxy.ip }</td>
                                <td>${ proxy.port }</td>
                                <td>
                                        ${ proxy.ver gt 0?"可用":"不可用"}
                                </td>
                                <td>${ proxy.time }</td>
                                <!-- 表格的操作 -->
                                <td><a class="btn btn-primary"
                                       href="${ pageContext.request.contextPath}/proxy/update.do?id=${proxy.id}&index=${requestScope.page.index}&condition=${requestScope.page.condition}&content=${requestScope.page.content}">更新</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger"
                                       href="${ pageContext.request.contextPath}/proxy/deletes.do?ids=${proxy.id}&index=${requestScope.page.index}&condition=${requestScope.page.condition}&content=${requestScope.page.content}">删除</a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <!-- 分页按钮 -->
                    <div style="float: right;margin-right: 100px">
                        <ul class="pagination pagination-rg">
                            <li>
                                <a href="${ pageContext.request.contextPath}/proxy/selectps.do?index=0&condition=${requestScope.page.condition}&content=${requestScope.page.content}">首页</a>
                            </li>
                            <li>
                                <a ${(requestScope.page.index gt 0)?"":"style='pointer-events:none;'"}
                                        href="${ pageContext.request.contextPath}/proxy/selectps.do?index=${requestScope.page.index-1}&condition=${requestScope.page.condition}&content=${requestScope.page.content}">上一页</a>
                            </li>
                            <li>
                                <a ${(requestScope.page.index lt requestScope.page.count-1)?"":"style='pointer-events:none;'"}
                                        href="${ pageContext.request.contextPath}/proxy/selectps.do?index=${requestScope.page.index+1}&condition=${requestScope.page.condition}&content=${requestScope.page.content}">下一页</a>
                            </li>
                            <li>
                                <a href="${ pageContext.request.contextPath}/proxy/selectps.do?index=${requestScope.page.count-1}&condition=${requestScope.page.condition}&content=${requestScope.page.content}">尾页</a>
                            </li>
                        </ul>
                    </div>
                    <!--批量删除和页号展示-->
                    <div style="float: left;">
                        <div style="float: left;margin: 18px;margin-left:0px">
                            <input type="submit" class="btn btn-default" value="批量删除"/>
                        </div>
                        <div style="float: left; margin-right: 20px">
                            <h4 style="margin: 25px">
                                第${requestScope.page.index+(requestScope.page.count==0?0:1)}页/共${requestScope.page.count}页</h4>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </section>
</section>
</form>
<!--main content end-->

<script>
    function search() {
        var condition = $("#condition").val();
        var content = $("#content").val();
        window.location.href = "${pageContext.request.contextPath}/proxy/selectps.do?condition=" + condition + "&content=" + content;
    }<!--模糊查询-->

    <!--分页查询-->
    function selectAll(e) {
        var elementsByClassName = document.getElementsByClassName("checkbox form-control");
        for (var i = 0; i < elementsByClassName.length; i++) {
            elementsByClassName[i].checked = true;
        }
    }
</script>

<jsp:include page="/back/footer.jsp"/>