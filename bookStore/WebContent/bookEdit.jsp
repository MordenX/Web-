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
String bookNo = request.getParameter("bookNo");
String sql ="select * from book where bookNo=?";
DBHelper dbHelper=new DBHelper();
Object values[]=new Object[]{bookNo};
ResultSet rs=dbHelper.executeQuery(sql, values);
if(rs.next()){
%>
<form action="dobookEdit.jsp" method="post">
编号<input type="text" readonly="readonly" name="bookNo" value="<%=rs.getString("bookNo")%>"/><br />
书名<input type="text" name="bookName" value="<%=rs.getString("bookName")%>"/><br />
章节<input type="text" name="bookSize" value="<%=rs.getString("bookSize")%>"/><br />
价格<input type="text" name="bookPrice" value="<%=rs.getString("bookPrice")  %>"/><br />
<input type="submit"  value="·确认修改·"/>
</form>
<%} else{%>
该书不存在
<%
		} 
dbHelper.close();
%>
</body>
</html>