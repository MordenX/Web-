<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript">
  function changeImage(){
	  document.getElementById("validcode").src="validcode?d="+new Date().getTime();
  }
</script>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath }/servlet">
用户名:<input type="text" name="userName" value="" /><br />
密   码:<input type="password" name="userPass" value="" /><br />
验证码:<input type="text" name="yzm"><a href="javascript:void(0)" onclick="changeImage()"><img id="validcode" src="imageServlet"></a><br/>
<input type="submit" value="登录" /><br />
</form>
</body>
</html>