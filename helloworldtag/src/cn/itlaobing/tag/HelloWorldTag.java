package cn.itlaobing.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloWorldTag extends TagSupport {
	
	private String URL;
	private String pageCount;
	
	@Override
	public int doStartTag() throws JspException {
		try {
			//通过jsp内置对象pageContext得到JspWriter对象，命名为out
			JspWriter out = pageContext.getOut();
			//out对象用于向jsp页面输出内容
			//out.print("HelloWorld");
			out.print("总页数为"+pageCount+"<br />");
			out.print("<a href='"+URL+"?pageIndex=1'>1</a>&nbsp");
			out.print("<a href='"+URL+"?pageIndex=2'>2</a>&nbsp");
			out.print("<a href='"+URL+"?pageIndex=3'>3</a>&nbsp");
			out.print("<a href='"+URL+"?pageIndex=4'>4</a>&nbsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	
	
	
	
}
