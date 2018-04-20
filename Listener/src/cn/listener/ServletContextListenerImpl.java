package cn.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		ServletContext application=arg0.getServletContext();
		application.removeAttribute("online");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		int num=0;
		ServletContext application=arg0.getServletContext();
		application.setAttribute("online", num);
	}

}
