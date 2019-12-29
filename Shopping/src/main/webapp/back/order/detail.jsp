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
  <body style="background-color: #f0f9fd;text-align: center">
  <div align=center style="font-size:25px">订单详细信息</div><hr/>
  	 <table >
          <tr bgcolor="lightblue" align="center"> 
             <td>订单号：1234567890</td>
             <td colspan="2">订单金额：¥：297</td>
             <td colspan="2">订单状态：未支付</td>
          </tr>
          
			<tr align='center'> 
				 <td>上课睡觉的故事</td>
				 <td style="width: 100px;"><img style="width:32px;height: 20px" src=""></td>
				 <td style="width: 180px;">单价：¥100</td>
				 <td style="width: 200px;">当当价：¥99</td>
				 <td style="width: 100px;">3本</td>
			</tr>
			<tr align='center'> 
				 <td>上课玩手机的故事</td>
				 <td style="width: 100px;"><img style="width:32px;height: 20px" src=""></td>
				 <td style="width: 180px;">单价：¥100</td>
				 <td style="width: 200px;">当当价：¥99</td>
				 <td style="width: 100px;">3本</td>
			</tr>
			<tr align='center'> 
				 <td>水浒传</td>
				 <td style="width: 100px;"><img style="width:32px;height: 20px" src=""></td>
				 <td style="width: 180px;">单价：¥100</td>
				 <td style="width: 200px;">当当价：¥99</td>
				 <td style="width: 100px;">3本</td>
			</tr>

          
     </table> 
	<input class="button btn-p" value="返回上级" onclick="history.go(-1);" style="margin-top: 10px"/>
  </body>
</html>
