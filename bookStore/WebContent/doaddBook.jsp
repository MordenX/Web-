<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DBHelper"%>
<%@page import="java.sql.*"%>


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
	//接收用户信息
	request.setCharacterEncoding("utf-8");
	String bookName=request.getParameter("bookName");
	String bookNo=request.getParameter("bookNo");
	String bookSize=request.getParameter("bookSize");
	String bookPrice=request.getParameter("bookPrice");
	//向数据库输入信息
	String sql="insert into book(bookName,bookNo,bookSize,bookPrice) values(?,?,?,?)";
	DBHelper dbHelper=new DBHelper();
    Object values[]=new Object[]{bookName,bookNo,bookSize,bookPrice};
	int i=dbHelper.executeUpdate(sql, values);
	dbHelper.close();
	if(i!=0){
		response.sendRedirect("Store.jsp");
	}else{
		response.sendRedirect("addBook.jsp");
	}
%>
</body>
</html>