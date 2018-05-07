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
<style>
table{ background-color:#999;}
td{ background-color:white; text-align:center; height:40px; line-height:40px;}
.headertdbg{ background-color:#CCC;}
</style>
<body>
<% 
String useNo=request.getParameter("useNo");
%>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="1">
<caption>书本信息列表</caption>
  <tr>
    <td class="headertdbg">序号</td>
    <td class="headertdbg">书号</td>
    <td class="headertdbg">书名</td>
    <td class="headertdbg">章节（字数）</td>
    <td class="headertdbg">价格</td>
    <td class="headertdbg">加入</td>
  </tr>
   <%
    String sql="select * from book";
   DBHelper dbHelper=new DBHelper();
   ResultSet rs= dbHelper.executeQuery(sql, null);
   int i = 0;
   while(rs.next()){
 	  i++;
   %>
   <tr>
     <td><% out.print(i); %></td>
     <td><% out.print(rs.getString("bookNo")); %></td>
     <td><% out.print(rs.getString("bookName")); %></td>
     <td><% out.print(rs.getString("bookSize")); %></td>
     <td><%=rs.getString("bookPrice") %></td>
     <td><select name="sss"  >
     <%int j=1; %>
    <option value="<%=rs.getString("bookName") %>"><%out.print("加入："); %></option>
    <option value="<%=rs.getString("bookName")%>"<%j++; %>><%out.print("我的收藏"); %></option>
    <option  value="<%=rs.getString("bookName")%>"<%j++; %>><%out.print("我看过的书"); %></option>
    <option  value="<%=rs.getString("bookName")%>"<%j++; %>><%out.print("我买过的书"); %></option>
  </select></td>
     <td ><a href="doaddUseBook.jsp?useNo=<%=useNo+" "+rs.getString("bookName")+" "+j %>">确认添加</a></td>
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