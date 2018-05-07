<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <base href="${pageContext.request.contextPath }/">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><style >
a{ list-style-type: none;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
</head>
<body>
 <div class="login-title">账户登录</div>
                    <div class="login-content">
                        <form action="dointoStore.jsp" method="post" >
                            <input type="hidden" class="loginToPage" value="-2"/>

                            <div class="form-group" style="margin-bottom: 0;">
                                <div class="col-xs-12 errorTip">
                                   <%
                                   String message = request.getParameter("message");
                                   if(message!=null && (message.equals("password")||message.equals("username"))){
                                	   out.print("用户名与密码不匹配");
                                   }
                                   %>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                        <input type="text" id="useNo" name="useNo" class="form-control input-lg" value="" placeholder="请输入登录账号" maxlength="11"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                        <input type="password" id="usePass" name="usePass" class="form-control input-lg" value="" placeholder="请输入登录密码" maxlength="21"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <button type="submit" >立即登录</button>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6 link">
                                    <p class="remove-margin text-right"><a href="bookUser.jsp">免费注册</a></p>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
</body>
</html>