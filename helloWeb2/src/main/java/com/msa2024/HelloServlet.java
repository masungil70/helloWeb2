package com.msa2024;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

//@WebServlet(
//		urlPatterns = { "/hello" }, 
//		initParams = { 
//				@WebInitParam(name = "a", value = "10")
//		})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("HelloServlet 생성자 호출");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 System.out.println("init() 호출");
		 System.out.println("a = " + config.getInitParameter("a"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("get방법으로 호출할 때 실행됨");
		System.out.println("name = " + name);
		
		int a = 10;
		int b = 20;
		int result = a + b;
		
		Users users = new Users();
		users.setUserid("hong");
		users.setUserpassword("1004");
		users.setUsername("홍길동");
		users.setUserage(10);
		users.setUseremail("hong@naver.com");
		
		//배열로 객체 설정 
		List<Users> list = new ArrayList<>();
		for (int i=0;i<10;i++) {
			Users obj = new Users();
			obj.setUserid("hong" + i);
			obj.setUserpassword("1004");
			obj.setUsername("홍길동" + i);
			obj.setUserage(10 + i);
			obj.setUseremail("hong@naver.com");
//			if (i % 2 == 0) {
//				obj.setNumberLabel("짝수");
//			} else {
//				obj.setNumberLabel("홀수");
//			}
			//회원 객체를 생성해서 list 배열에 추가함 
			list.add(obj);
		}
		
		request.setAttribute("list", list);
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		request.setAttribute("result", result);
		request.setAttribute("users", users);
		
		Map<String, String> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", "200");
		map.put("job", "도적");
		
		request.setAttribute("map", map);
		
//		response.getWriter()
//				.append("Served at: ")
//				.append(request.getContextPath())
//				.append(" get 브라우저 name = " + name);
		//포워딩 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/getView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("post방법으로 호출할 때 실행됨");
		System.out.println("name = " + name);
		
//		response.getWriter()
//				.append("Served at: ")
//				.append(request.getContextPath())
//				.append(" post 브라우저 name = " + name);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/postView.jsp");
		rd.forward(request, response);
		
	}

}












