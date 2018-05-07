<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<br />
<form action="dobookUser.jsp"  method="post">
姓名<input type="text" name="useName" value=""/><br />
账号<input type="text" name="useNo" value=""/><br />
密码<input type="text" name="usePass" value=""/><br />
性别<input type="radio" name="gender" value="男"/>男&nbsp;<input type="radio" name="gender" value="女"/>女<br />
<input type="submit"  value="注册"/>
</form>
</body>
</html>