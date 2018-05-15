package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BookInfoModel;
import service.GetBookInfoService;

/**
 * Servlet implementation class GetBookInfo
 */
@WebServlet("/GetBookInfo")
public class GetBookInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	GetBookInfoService bookInfoService=new GetBookInfoService();
	List<BookInfoModel> list=new ArrayList<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("bookType");
		if(type!=null) {
			try {
				list=bookInfoService.getBookInfo(type);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String str=type+".jsp";
			request.setAttribute("list", list);
			response.sendRedirect(str);
		}else {
			request.setAttribute("message", "暂无此类书籍");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	
	}

}
