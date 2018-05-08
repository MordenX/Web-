package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.UserInfoModel;
import service.LoginSrevice;
@SuppressWarnings("serial")
@WebServlet(name="LoginController",value="/LoginController")
public class LoginController extends HttpServlet {
	LoginSrevice login=new LoginSrevice();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		List<UserInfoModel> list = null;
		try {
			list=login.findByUserNameAndPassword(userName,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.size()>0) {
			System.out.println(list.get(0));
			HttpSession session=req.getSession();
			session.setAttribute("userInfo", list);
			resp.sendRedirect("index.jsp");
			return ;
		}else {
			req.setAttribute("message", "用户名与密码不匹配");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
			return ;
		}
		
	}
}
