<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>欢迎登录</title>
		<link rel="stylesheet" type="text/css" href="view/css/login.css"/>
		<script type="text/javascript" src="view/js/jquery-1.11.2.js"></script>
	</head>
	<body>

		<div class="login-main clearfloat">
			<div class="div-floatl login-left need-height">
				<div class="left-img need-height">
					<img src="view/img/0.jpg" class="img-show"/>
					<img src="view/img/1.jpg" class="img-hidden"/>
					<img src="view/img/3.jpg" class="img-hidden"/>
				</div>
			</div>
			<div class="div-floatr login-right need-height">
				<div class="login-title">
					<p>MordenX小说欢迎您</p>
					<span>用户登录</span>
				</div>
				<form action="LoginController" method="post">
				<div class="login-user">
						<input type="text" name="username" id="username" placeholder="用户名/电话/邮箱" required/>
						<input type="password" name="password" id="password" placeholder="密码" required/>
				</div>
				<div class="error-tips">
					<span></span>
				</div>
				<div class="login-active">
					<input type="checkbox" class="remenberme"/><span>记住我</span>
					<a href="javascript:;" class="forgetpw">忘记密码？</a>
					<input type="submit" class="login-true" value="登录">
				</div>
				</form>
			</div>
		</div>
	</body>
	<script>
	     
	    $(function(){
	    	//轮播图
	    	var cur=0;
	    	var $img=$("img");
	    	$img.eq(0).fadeIn();
	    	function lunbo(){
	    			$img.eq(cur).fadeIn(500).siblings().hide();
					cur++;
					cur = cur >= $img.length ? 0:cur;
					auto=setTimeout(lunbo,4000);
	    	}
	    	lunbo();
	    	//验证用户名或密码不能为空
	    	$("#logintrue").click(function(){
				if($("#username").val()=='' || $("#password").val()==''){
					$(".error-tips span").html("用户名或密码不能为空");
				}
		    })
	    	$("#username").focus(function(){
	    		$(".error-tips span").html(" ");
	    	})
	    	$("#password").focus(function(){
	    		$(".error-tips span").html(" ");
	    	})
	    })
	</script>
</html>
