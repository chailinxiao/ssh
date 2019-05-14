package studio.lingye.book.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		String url = request.getRequestURI();
		if (url.endsWith("/login2")) {
			arg2.doFilter(arg0, arg1);
		} else if (url.endsWith(".js") || url.endsWith(".css")) {
			arg2.doFilter(arg0, arg1);
		} else if (url.contains("api")) {
			arg2.doFilter(arg0, arg1);
		} else {
	        HttpSession session = request.getSession();//取得session借口对象
	        if(session.getAttribute("aid")!=null) {//表示有内容存在
	            arg2.doFilter(arg0, arg1);
	        }else {
	        	request.setAttribute("msg", "您还未登录，请先登录后操作");
	        	request.setAttribute("url", "/login2");
	        	request.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
	        }
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
