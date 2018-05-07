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
String useNo= request.getParameter("useNo");

String sql="delete from userInformation where useNo=?";
DBHelper dbHelper=new DBHelper();
Object values[]=new Object[]{useNo};
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