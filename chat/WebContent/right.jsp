<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="refresh" content="5" >
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
body,td,th {
	color: #000;
}
body {
	background-color: #CCC;
	font-size: 14px;
}

</style>
</head>

<body leftmargin="2">
<div align="center">
<span class="div"><span class="div">聊天人数：<%=application.getAttribute("online")==null?"1":application.getAttribute("online") %><br />
参与人员：</span>
</span>
<% 
	Object users=application.getAttribute("users");
	if(users!=null){
		List<String> lists=(List<String>) users;
		if(lists!=null&&lists.size()>0){
			for(int i=0;i<lists.size();i++){
				out.print(lists.get(i)+"<br/>");
			}
		}
	}
%>

</div>
</body>
</html>
