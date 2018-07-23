<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河南省税务管理系统</title>
<link href="static/css/base.css" rel="stylesheet">
<link href="static/css/login/login.css" rel="stylesheet">
<link href="static/easyui/uimaker/easyui.css" rel="stylesheet">
<script type="text/javascript" src="static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
<style type="text/css">
#error {
	display: none;
}
</style>
</head>
<body>
	<div class="login-hd">
			<div class="left-bg"></div>
			<div class="right-bg"></div>
			<div class="hd-inner">
				<span class="sys-name">xx省国税税源信息管理系统</span>
			</div>
		</div>
		<div class="login-bd">
			<div class="bd-inner">
				<div class="inner-wrap">
					<div class="lg-zone">
						<div class="lg-box">
							<div class="lg-label">
								<h4>用户登录</h4>
							</div>
							<div id="error" class="alert alert-error">
								<i class="iconfont">&#xe62e;</i> <span id="info">请输入用户名</span>
							</div>
							<form method="post" id="form">
								<div class="lg-username input-item clearfix">
									<i class="iconfont">&#xe60d;</i> 
									<input type="text" name="username" id="username" placeholder="系统账号">
								</div>
								<div class="lg-password input-item clearfix">
									<i class="iconfont">&#xe634;</i> 
									<input type="password" name="password" id="password" placeholder="系统密码">
								</div>
								<div class="lg-check clearfix">
									<div class="input-item">
										<i class="iconfont">&#xe633;</i> 
										<input type="text" name="captcha" id="captcha" placeholder="验证码">
									</div>
									<span class="check-code"><img id="captchaimg" src="CaptchaServlet.jpg"></span>
								</div>
								<div class="tips clearfix">
									<label><input type="checkbox" id="rem" name="remUser" checked="checked">记住用户名</label> 
									<a href="javascript:;" class="forget-pwd">忘记密码？</a>
								</div>
								<div class="enter">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录" class="supplier" style="width: 145px;height: 50px;background-color:#1da02b;color: white;"/>&nbsp;&nbsp;
								<input type="reset" value="重置" class="purchaser" style="width: 145px;height: 50px;background-color: #f45438;color: white;"/>
								<!-- <a href="javascript:void(0);" class="supplier" id="supplier">登录</a> 
								<a href="javascript:void(0);" class="purchaser" id="purchaser">重置</a> -->
								</div>
							</form>
						</div>
					</div>
					<div class="lg-poster"></div>
				</div>
			</div>
		</div>
		<div class="login-ft">
			<div class="ft-inner">
				<div class="about-us">
					<a href="javascript:;">关于我们</a> <a href="javascript:;">法律声明</a> <a
						href="javascript:;">服务条款</a> <a href="javascript:;">联系方式</a>
				</div>
				<div class="address">地址：湖北省洪山区光谷国际广场B座24楼&nbsp;邮编：430070&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2015&nbsp;-&nbsp;2017&nbsp;专注系统集成&nbsp;版权所有</div>
				<div class="other-info">建议使用IE8及以上版本浏览器&nbsp;京ICP备&nbsp;17003078号&nbsp;E-mail：service@zhidisoft.com</div>
			</div>
		</div>
		<div id="dialog" style="padding: 20px; line-height: 1.5em;"></div>
</body>
<script type="text/javascript">

 function login(){
 		var username=$("#username").val();
		var password=$("#password").val();
		var captcha=$("#captcha").val();
		var remUser=$("#rem").val();
		if(!username||username.length<6){
			$("#error").show()
			$("#info").text("用户名输入错误").css("color","red");
			return;
		}else{
			$("#info").text("")
		}
	
		$(function() {
			$("#form").submit(function(e) {
				e.preventDefault();
				$.post(
					"LoginServlet.json",
					$(this).serialize(),
					function(data) {
						if (data.success) {
							document.location="manage/jsp/index.jsp";
						} else {
							var error = $("#error")
							error.show();
							error.text(data.msg)
						}
					},
					"json"
				);
			});
		});
};
  
  	$(function(){
  		var username = document.cookie.split("=")[1]
  		//放入cookie值
  		$("#username").val(username)
  		$("#error").hide()
  		$("#captchaimg").click(function(){
  			var num = Math.random()
  			this.src="CaptchaServlet.jpg?num="+Math.random()
  		})  		
  		$(".supplier").click(function(){
  			login();
  		})
  		
  		$("form").keydown(function() {
            if (event.keyCode == "13") {//keyCode=13是回车键
         		login();
            }
       });
  	}) 
</script>
</html>