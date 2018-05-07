<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DBHelper"%>
<%@page import="java.sql.* "%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
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
	String useName=request.getParameter("useName");
	String useNo=request.getParameter("useNo");
	String usePass=request.getParameter("usePass");
	String gender=request.getParameter("gender");
	//向数据库输入信息
	String sql="insert into userInformation(useName,useNo,usePass,gender) values(?,?,?,?)";
	DBHelper dbHelper=new DBHelper();
    Object values[]=new Object[]{useName,useNo,usePass,gender};
	int i=dbHelper.executeUpdate(sql, values);
	sql="insert into userBook(userNo) values(?)";
	Object values1[]=new Object[]{useNo};
	dbHelper.executeUpdate(sql, values1);
	dbHelper.close();
	if(i!=0){
		out.println("注册成功！！！");
		response.sendRedirect("intoStore.jsp");
	}else{
		out.println("注册失败！！！");
		out.println("请检查信息重新注册！！！");
		response.sendRedirect("bookUser.jsp");
	}
%>
</body>
