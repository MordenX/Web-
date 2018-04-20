package cn.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HtttpSessionListenerImpl implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

		ServletContext application=arg0.getSession().getServletContext();
		Integer num=(Integer) application.getAttribute("online");
		if (num!=null) {
			int count=num;
			count+=1;
			application.setAttribute("online", count);
		}else {
			application.setAttribute("online", 1);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext application=arg0.getSession().getServletContext();
		Integer num=(Integer) application.getAttribute("online");
		int count=num;
		count-=1;
		application.setAttribute("online", count);
	}

}
