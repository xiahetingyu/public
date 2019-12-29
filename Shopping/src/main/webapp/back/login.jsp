<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>登录 - 当当网</title>
		<link href="${ pageContext.request.contextPath }/back/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${ pageContext.request.contextPath }/back/css/pop_cheat.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ pageContext.request.contextPath }/back/js/jquery-3.3.1.js"></script>
		<script type="text/javascript">
			function changeImage() {
				$("#imgVcode").attr({
					"src": "${ pageContext.request.contextPath }/user/ver?a=" + Math.random()
				});
			}
		</script>
	</head>
	<body>
		<div class="head">
			<a href="http://www.dangdang.com"> <img src="${ pageContext.request.contextPath }/back/images/signin_logo.png" /></a>
			<div class="improve">
				<img src="${ pageContext.request.contextPath }/back/images/bz.jpg" width="178" height="61" />
			</div>
		</div>

		<div class="login_bg" style="width: 960px; margin: 0 auto;">
			<div id="J_cheatProofTop" class="new_tip">
				<div id="component_2747856"></div>
				<div>
					为保障账户安全，请勿设置与邮箱及其他网站相同的账户登录密码或支付密码，<a href="javascript:;">谨防诈骗</a>！
				</div>
			</div>
			<div class="set_area clearfix">
				<div class="wrap clearfix">
					<div id="J_loginDiv">
						<form action="${ pageContext.request.contextPath }/user/signin" method="post">
							<span style="color: red; font-size: 21px; margin-left: 45px;">${requestScope.user.other}</span>
							<div id="J_loginCoreWrap" class="infro">
								<div class="username" id="username_div">
									<span></span> <input class="user" id="txtUsername" name="user.email" type="text" />
								</div>
								<br />
								<br />
								<div class="password" id="password_div">
									<span></span> <input class="pass" id="txtPassword" name="user.password" type="password" />
									<input name="user.permission" type="hidden" value="2" />
								</div>
								<br /> <br />
								<div id="J_captchVcodeWrap" style="" class="Captcha">
									<div class="code" style="width: 100px;">
										<input type="text" name="user.code" />
									</div>
									<div class="Captcha-operate">
										<div class="Captcha-imageConatiner">
											<a class="code_pic" id="vcodeImgWrap" href="javascript:void(0);"> <img id="imgVcode" src="${ pageContext.request.contextPath }/user/ver"
												 class="Ucc_captcha Captcha-image" onClick="changeImage()">
											</a>
										</div>
									</div>
								</div>
								<p class="btn">
									<input id="submitLoginBtn" type="submit" value="登&nbsp;录" />
								</p>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
