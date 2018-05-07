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
String useNo=request.getParameter("useNo");
String[] com=useNo.split(" ");
DBHelper dbHelper=new DBHelper();
Object[] values=new Object[]{com[0],com[1]};
if(com[2].equals("3")){
	String sql="insert into userBook(userNo,useCollection) values(?,?)";
	dbHelper.executeUpdate(sql, values);
}else if(com[2].equals("4")){
	String sql="insert into userBook(userNo,useSeen) values(?,?)";
	dbHelper.executeUpdate(sql, values);
}else if(com[2].equals("5")){
	String sql="insert into userBook(userNo,useBuy) values(?,?)";
	dbHelper.executeUpdate(sql, values);
}
dbHelper.close();
response.sendRedirect("book.jsp");
%>
</body>
</html>