package cn.itlaobing.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itlaobing.models.UserInfoModel;
import cn.itlaobing.services.UserInfoService;
import cn.itlaobing.util.PageUtil;

@WebServlet("/FindUserinfoByPage")
public class FindUserinfoByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FindUserinfoByPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserInfoService service =new UserInfoService();
			PageUtil page =new PageUtil();
			
			page.setPageSize(4);
			String str2 = request.getParameter("pageSize");
			if(str2!=null && !"".equals(str2)) {
				page.setPageSize( Integer.parseInt(str2));
			}
			
			//查询总记录数
			int recordCount = service.findByPageCount();
			page.setRecordCount(recordCount);
			
			//获取分页信息
			page.setPageIndex(1);//默认获取第一页
			//如果用户指定了获取的页面，则使用用户指定 的 页面
			String str1 = request.getParameter("pageIndex");
			if(str1!=null && !"".equals(str1)) {
				page.setPageIndex(Integer.parseInt(str1));
			}
			
			
			
			
			
			//查询当前页的数据
			List<UserInfoModel> list = service.findByPage(page.getPageIndex(),page.getPageSize());
			
			//将数据保存到请求范围中
			request.setAttribute("datas", list);
			request.setAttribute("page", page);
			//页面转发到视图
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
