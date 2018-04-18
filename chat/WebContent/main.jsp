<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="refresh" content="0.1">
<meta charset="utf-8">
<title></title>
</head>

<body>
<%
	Object says=application.getAttribute("says");
	if(says!=null){
		List<String> list=(List<String>) says;
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				out.print(list.get(i));
			}
		}
	}
%>
</body>
</html>
