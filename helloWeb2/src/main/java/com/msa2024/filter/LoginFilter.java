package com.msa2024.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.msa2024.step2.vo.UserVO;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("*.do")
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//사용자가 요청한 URL 얻기 
		
		if (request instanceof HttpServletRequest req) {
			HttpServletResponse resp = (HttpServletResponse) response;
			String url = req.getRequestURI();
			String action = req.getParameter("action");
			Set<String> actionSet = new HashSet<String>();
			actionSet.add("loginForm");
			actionSet.add("login");
			actionSet.add("insertForm");
			actionSet.add("insert");

			System.out.println("url = " + url);
			if (!(url.equals("/helloWeb2/user.do") && actionSet.contains(action))) {
			//if (!url.equals("/helloWeb2/user.do") || !actionSet.contains(action))) {
				HttpSession session = req.getSession();
				UserVO loginVO = (UserVO) session.getAttribute("loginVO");
				if (loginVO == null) {
					resp.sendRedirect(req.getContextPath() + "/user.do?action=loginForm");
					return;
				}
			} 
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
