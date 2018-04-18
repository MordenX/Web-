<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<%
String s=null;
String time=null;
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(int i=0;i<cookies.length;i++){
		Cookie cookie=cookies[i];
		if("userName".equals(cookie.getName())){
			s=URLDecoder.decode(cookies[i].getValue(),"utf-8");
		}else if("time".equals(cookie.getName())){
			time=URLDecoder.decode(cookies[i].getValue(),"utf-8");
		}
	}
}%>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath }/doLogin.jsp">
用户名:<input type="text" name="userName" value="<%=s==null?" ":s%>" /><br />
密   码:<input type="password" name="userPass" value="" /><br />
<input type="submit" value="登录" /><br />
</form>
<%
if(time!=null){
%>
上次登录时间为：<%=time %>

<%
}
%>
</body>
</html>