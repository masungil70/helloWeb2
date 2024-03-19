package com.msa2024;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchServlet
 */
@WebServlet("/fetch")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("name = " + name);
		
		if ("text".equals(name)) {
			//응답결과 text로 전달
			response.getWriter().append("hongjildong,20");
		} else if ("json".equals(name)) {
			//응답을 json을 전달 
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().append("{\"result\":true, \"name\":\"홍길동\", \"age\" : 20}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//브라우저에서 전달한 값 얻기 
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String age = request.getParameter("age");

		//브라우저에서 전달한 값 출력 
		System.out.println("type = " + type);
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		
		//응답 데이터 텍스트로 전달 
		response.getWriter().append("1");
	}

}







