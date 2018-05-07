<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DBHelper"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
//获取数据
request.setCharacterEncoding("utf-8");
String useNo = request.getParameter("useNo");
String usePass = request.getParameter("usePass");
boolean t=useNo.equals("999")&&usePass.equals("111");
if(t){
	return;
}%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息列表</title>
<style>
table{ background-color:#999;}
td{ background-color:white; text-align:center; height:40px; line-height:40px;}
a{ list-style-type: none;}
.headertdbg{ background-color:#CCC;}
</style>
</head>
<body>

<table width="800" border="0" align="center" cellpadding="0" cellspacing="1">
<caption>用户信息列表</caption>
  <tr>
    <td class="headertdbg">帐号</td>
    <td class="headertdbg">姓名</td>
    <td class="headertdbg">密码</td>
    <td class="headertdbg">性别</td>
    <td class="headertdbg">删除</td>
  </tr>
  <%
  
  String sql ="select * from userInformation where useNo=? and usePass=? ";
  DBHelper dbHelper=new DBHelper();
  Object values[] =new Object[]{useNo,usePass};
  ResultSet rs=dbHelper.executeQuery(sql,values);
  boolean result = rs.next();//移到第一行
  	String dbPass =null;
  	if(result){
  		dbPass = rs.getString("usePass");
  	}
  	if(result){
  		if(usePass.equals(dbPass)){
  			%>
  			<tr>
  		    <td><%=rs.getString("useNo") %></td>
  		    <td><%=rs.getString("useName")  %></td>
  		    <td><%=rs.getString("usePass") %></td>
  		    <td><%=rs.getString("gender") %></td>
  		     <td><a href="edit.jsp?useNo=<%=rs.getString("useNo")%>">编辑</a></td>
  		    </tr>
  <% 
  		}else{
  			//密码错误
  			dbHelper.close();
  			response.sendRedirect("intoStore.jsp?message=password");
  		}
  	}else{
  		//用户名不存在
  		dbHelper.close();
  		response.sendRedirect("intoStore.jsp?message=username");
  	}  	
  	%>
  </table>
  <table width="800" border="0" align="center" cellpadding="0" cellspacing="1">
<caption>用户书本列表（<a href="book.jsp?useNo=<%=useNo %>">进入书库</a>）</caption>
  <tr>
    <td class="headertdbg">收藏的书</td>
    <td class="headertdbg">看过的书</td>
    <td class="headertdbg">买过的书</td>
  </tr>
  <%
  
  sql ="select * from userBook where userNo=?  ";
  Object values1[] =new Object[]{useNo};
    ResultSet rm=dbHelper.executeQuery(sql,values1);
    while(rm.next()){//移到第一行
  	
  			%>
  			<tr>
  		    <td><%=rm.getString("useCollection") %></td>
  		    <td><%=rm.getString("useSeen")  %></td>
  		    <td><%=rm.getString("useBuy") %></td>
  		    </tr>
  <% }
     dbHelper.close();
    %>
</body>
</html>