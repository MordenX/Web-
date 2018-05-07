<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@page import="java.sql.ResultSet"%>
<%@page import="dao.DBHelper"%>
<%@page import="java.sql.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<% 
String bookNo= request.getParameter("bookNo");

String sql="delete from book where bookNo=?";
DBHelper dbHelper=new DBHelper();
Object values[]=new Object[]{bookNo};
int i = dbHelper.executeUpdate(sql, values);
dbHelper.close();
if(i!=0){
	response.sendRedirect("Store.jsp");
	}else{
		out.print("输入有误！！！");
	}
%>
</body>
</html>