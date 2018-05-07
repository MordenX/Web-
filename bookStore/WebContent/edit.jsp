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
String useNo = request.getParameter("useNo");
String sql ="select * from userInformation where useNo=?";
DBHelper dbHelper=new DBHelper();
Object values[]=new Object[]{useNo};
ResultSet rs=dbHelper.executeQuery(sql, values);
if(rs.next()){
%>
<form action="doedit.jsp" method="post">
学号<input type="text" readonly="readonly" name="useNo" value="<%=rs.getString("useNo")%>"/><br />
姓名<input type="text" name="useName" value="<%=rs.getString("useName")%>"/><br />
密码<input type="text" name="usePass" value="<%=rs.getString("usePass")%>"/><br />
性别<input type="radio" name="gender" value="男" <%if(rs.getString("gender").equals("男")){out.print("checked=\"checked\"");} %>/>男&nbsp;<input type="radio" name="gender" value="女" <%if(rs.getString("gender").equals("女")){out.print("checked=\"checked\"");} %>/>女<br />
<input type="submit"  value="·确认修改·"/>
</form>
<%} else{%>
该用户不存在
<%
		} 
dbHelper.close();
%>
</body>
</html>