<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DBHelper"%>
<%@page import="java.sql.* "%>
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
String useNo = request.getParameter("useNo");
String useName = request.getParameter("useName");
String usePass = request.getParameter("usePass");
String gender = request.getParameter("gender");


String sql ="update userInformation set useName=? ,usePass=? ,gender=? where useNo=?";
DBHelper dbHelper=new DBHelper();
Object values[]=new Object[]{useName,usePass,gender,useNo};
dbHelper.executeUpdate(sql, values);
dbHelper.close();
response.sendRedirect("Store.jsp");

%>

</body>
</html>