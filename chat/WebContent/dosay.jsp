<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String say=request.getParameter("textfield");
Object says=application.getAttribute("says");
if(says==null){
	List<String> chat=new ArrayList();
	chat.add(session.getAttribute("userName")+"  "+new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date())+"<br/>"+say+"<br/>");
	application.setAttribute("says", chat);
}else{
	List<String> chat=(List<String>) says;
	chat.add(session.getAttribute("userName")+"  "+new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date())+"<br/>"+say+"<br/>");
	application.setAttribute("says", chat);
}
response.sendRedirect("under.jsp");
%>

</body>
</html>