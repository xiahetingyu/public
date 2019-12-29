<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html>
<html>
  <head>
    <title>order</title>
	<link rel="stylesheet" href="../css/btn.css" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	 <style type="text/css">
		table {
			border-right: 1px solid black;
			border-bottom: 1px solid black;
			margin: 0px auto;
			border: 2px solid #898E90;
		}
		
		tr, td {
			border: 1px solid #898E90;
		}
		
		table td {
			padding: 10px;
			text-align: center;
			border-left: 1px solid black;
			border-top: 1px solid black;
		}
	 </style>
  </head>
  <body style="background-color: #f0f9fd;">
  <div align=center style="font-size:25px">订单管理</div><hr/>
  	 <table >
          <tr bgcolor="lightblue" align="center"> 
              <td>订单id</td>
			  <td>订单编号</td>
			  <td>订单金额</td>
			  <td>订单状态</td>
              <td>收件人</td>
			  <td>收货地址</td>
			  <td>创建日期</td>
              <td>操作</td>
          </tr>
         
		  <tr align='center'> 
			  <td>a1001</td>
			  <td>1234567890</td>
			  <td>297</td>
			  <td>未付款</td>
			  <td>小黑</td>
			  <td>北京市昌平区</td>
			  <td>2012-12-12</td>
			  <td> 
				<input class="button btn-order" onclick="location.href=''" value="订单详细信息 &raquo;" />
			  </td>
		  </tr>
		  <tr align='center'> 
			  <td>a1001</td>
			  <td>1234567890</td>
			  <td>297</td>
			  <td>未付款</td>
			  <td>小黑</td>
			  <td>北京市昌平区</td>
			  <td>2012-12-12</td>
			  <td> 
				<input class="button btn-order" onclick="location.href=''" value="订单详细信息 &raquo;" />
			  </td>
		  </tr>
		  <tr align='center'> 
			  <td>a1001</td>
			  <td>1234567890</td>
			  <td>297</td>
			  <td>未付款</td>
			  <td>小黑</td>
			  <td>北京市昌平区</td>
			  <td>2012-12-12</td>
			  <td> 
				<input class="button btn-order" onclick="location.href=''" value="订单详细信息 &raquo;" />
			  </td>
		  </tr>
		  <tr align='center'> 
			  <td>a1001</td>
			  <td>1234567890</td>
			  <td>297</td>
			  <td>未付款</td>
			  <td>小黑</td>
			  <td>北京市昌平区</td>
			  <td>2012-12-12</td>
			  <td> 
				<input class="button btn-order" onclick="location.href=''" value="订单详细信息 &raquo;" />
			  </td>
		  </tr>
		  <tr align='center'> 
			  <td>a1001</td>
			  <td>1234567890</td>
			  <td>297</td>
			  <td>未付款</td>
			  <td>小黑</td>
			  <td>北京市昌平区</td>
			  <td>2012-12-12</td>
			  <td> 
				<input class="button btn-order" onclick="location.href=''" value="订单详细信息 &raquo;" />
			  </td>
		  </tr>
          
     </table> 
  </body>
</html>
