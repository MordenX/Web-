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
			
			//��ѯ�ܼ�¼��
			int recordCount = service.findByPageCount();
			page.setRecordCount(recordCount);
			
			//��ȡ��ҳ��Ϣ
			page.setPageIndex(1);//Ĭ�ϻ�ȡ��һҳ
			//����û�ָ���˻�ȡ��ҳ�棬��ʹ���û�ָ�� �� ҳ��
			String str1 = request.getParameter("pageIndex");
			if(str1!=null && !"".equals(str1)) {
				page.setPageIndex(Integer.parseInt(str1));
			}
			
			
			
			
			
			//��ѯ��ǰҳ������
			List<UserInfoModel> list = service.findByPage(page.getPageIndex(),page.getPageSize());
			
			//�����ݱ��浽����Χ��
			request.setAttribute("datas", list);
			request.setAttribute("page", page);
			//ҳ��ת������ͼ
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
