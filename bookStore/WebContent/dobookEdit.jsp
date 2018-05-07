<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@page import="java.sql.ResultSet"%>
<%@page import="dao.DBHelper"%>
<%@page import="java.sql.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String bookNo = request.getParameter("bookNo");
String bookName = request.getParameter("bookName");
String bookSize = request.getParameter("bookSize");
String bookPrice = request.getParameter("bookPrice");


String sql ="update book set bookName=? ,bookSize=? ,bookPrice=? where bookNo=?";
DBHelper dbHelper=new DBHelper();
Object values[]=new Object[]{bookName,bookSize,bookPrice,bookNo};
dbHelper.executeUpdate(sql, values);
dbHelper.close();
response.sendRedirect("Store.jsp");

%>
</body>
</html>