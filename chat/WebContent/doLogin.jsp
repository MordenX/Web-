<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%
request.setCharacterEncoding("utf-8");
String userName = request.getParameter("userName");
String userPass = request.getParameter("userPass");
if(!"".equals(userName)&&!"".equals(userPass)){
	session.setAttribute("userName", userName);
	Object online=application.getAttribute("online");
	if(online==null){
		application.setAttribute("online", 1);
	}else{
		int i=Integer.parseInt(application.getAttribute("online").toString());
		i++;
		application.setAttribute("online", i);
	}
	Object users=application.getAttribute("users");
	if(users==null){
		List<String> list=new ArrayList();
		list.add(userName);
		application.setAttribute("users", list);
	}else{
		List<String> lists=(List<String>) users;
		lists.add(userName);
		application.setAttribute("users", lists);
	}
	response.sendRedirect("index.jsp");
	
}else{
	response.sendRedirect("login.jsp");
}
%>
<title>Insert title here</title>

</head>
<body>

</body>
</html>