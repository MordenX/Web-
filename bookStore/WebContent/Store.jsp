<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DBHelper"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员界面</title>
</head>
<style>
table{ background-color:#999;}
td{ background-color:white; text-align:center; height:40px; line-height:40px;}
.headertdbg{ background-color:#CCC;}
</style>
<body>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="1">
<caption>用户信息列表</caption>
  <tr>
    <td class="headertdbg">序号</td>
    <td class="headertdbg">帐号</td>
    <td class="headertdbg">姓名</td>
    <td class="headertdbg">密码</td>
    <td class="headertdbg">性别</td>
    <td class="headertdbg">编辑</td>
    <td class="headertdbg">删除</td>
  </tr>
  <%
  String sql="select * from userInformation";
  DBHelper dbHelper=new DBHelper();
  ResultSet rs= dbHelper.executeQuery(sql, null);
  int i = 0;
  while(rs.next()){
	  i++;
  %>
  <tr>
    <td><% out.print(i); %></td>
    <td><% out.print(rs.getString("useNo")); %></td>
    <td><% out.print(rs.getString("useName")); %></td>
    <td><% out.print(rs.getString("usePass")); %></td>
    <td><%=rs.getString("gender") %></td>
    <td><a href="edit.jsp?useNo=<%=rs.getString("useNo")%>">编辑</a></td>
    <td><a href="delete.jsp?useNo=<%=rs.getString("useNo")%>" onclick="javascript:return confirm('你确认删除吗？')">删除</a></td>
  </tr>
 	<%
  }
 	%>
</table>
<%
dbHelper.close(); 
%>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="1">
<caption>书本信息列表（<a href="addBook.jsp">添加书本</a>）</caption>
  <tr>
    <td class="headertdbg">序号</td>
    <td class="headertdbg">书号</td>
    <td class="headertdbg">书名</td>
    <td class="headertdbg">章节（字数）</td>
    <td class="headertdbg">价格</td>
    <td class="headertdbg">编辑</td>
    <td class="headertdbg">删除</td>
  </tr>
  	
  
  
   <%
    sql="select * from book";
   rs= dbHelper.executeQuery(sql, null);
    i = 0;
   while(rs.next()){
 	  i++;
   %>
   <tr>
     <td><% out.print(i); %></td>
     <td><% out.print(rs.getString("bookNo")); %></td>
     <td><% out.print(rs.getString("bookName")); %></td>
     <td><% out.print(rs.getString("bookSize")); %></td>
     <td><%=rs.getString("bookPrice") %></td>
     <td><a href="bookEdit.jsp?bookNo=<%=rs.getString("bookNo")%>">编辑</a></td>
     <td><a href="bookDelete.jsp?bookNo=<%=rs.getString("bookNo")%>" onclick="javascript:return confirm('你确认删除吗？')">删除</a></td>
   </tr>
  	<%
   }
  	%>
 </table>
 <%
dbHelper.close(); 
%>
</body>
</html>