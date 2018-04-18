<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>聊天界面</title>
</head>
<frameset cols="*,80" frameborder="no" border="0" framespacing="0">
  <frameset rows="*,80" frameborder="no" border="0" framespacing="0">
    <frame src="main.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
    <frame src="under.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" title="bottomFrame" />
  </frameset>
  <frame src="right.jsp" name="rightFrame" scrolling="no" noresize="noresize" id="rightFrame" title="rightFrame" />
</frameset>
<noframes><body>
</body></noframes>
</html>
