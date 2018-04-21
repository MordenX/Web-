<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="95%" border="1" cellpadding="0" cellspacing="1" align="center">
  <tr>
    <th>用户名</th>
    <th>年龄</th>
    <th>性别</th>
    <th>爱好</th>
    <th>省份</th>
    <th>出生年月</th>
    <th>注册时间</th>
    <th>编辑</th>
    <th>删除</th>
  </tr>
  
 <c:forEach items="${datas }" var="m">
  <tr >
    <td>${m.username }</td>
    <td>${m.age}</td>
    <td>${m.gender}</td>
    <td>${m.hobby}</td>
    <td>${m.province}</td>
    <td><f:formatDate pattern="yyyy-MM-dd" value="${m.birthday}"/></td>
    <td><f:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${m.reg_date}"/></td>
    <td><a href="EditUserController?id=${m.id}&pageIndex=${pageUtil.pageIndex}"><img src="images/edit.gif"></a></td>
    <td><a href="DelUserController?id=${m.id}" onclick='return confirm("确定要删除 ${m.username}此用户吗？");'><img src="images/delimg.gif"></a></td>
  </tr>
 </c:forEach>
</table>
<c:if test="${page.pageIndex != 1 }">
<a href="FindUserinfoByPage?pageIndex=1&pageSize=${page.pageSize }">第一页</a>&nbsp;
<a href="FindUserinfoByPage?pageIndex=${page.pageIndex-1 }&pageSize=${page.pageSize }">上一页</a>
</c:if>
&nbsp;当前第${page.pageIndex }页,共${page.pageCount }页,共${page.recordCount }条记录&nbsp;
<c:if test="${page.pageIndex != page.pageCount }">
<a href="FindUserinfoByPage?pageIndex=${page.pageIndex+1}&pageSize=${page.pageSize}">下一页</a>&nbsp;
<a href="FindUserinfoByPage?pageIndex=${page.pageCount }&pageSize=${page.pageSize }">最后页</a>
</c:if>

<form action="FindUserinfoByPage" method="get">
<input type="submit" value="跳转到" />
<input type="text" name="pageIndex" value="${page.pageIndex }" style="width:80px;" />页
<input type="hidden" name="pageSize" value="4" />
</form>

</body>
</html>