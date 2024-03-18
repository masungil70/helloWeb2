package com.msa2024.step2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa2024.step2.dao.UserDAO;
import com.msa2024.step2.vo.UserVO;

/*
 * MVC 
 * Model : B/L 로직을 구현하는 부분(service + dao)  
 * View  : 출력(jsp) 
 * Controller : model와 view에 대한 제어를 담당 
 */
/**
 * Servlet implementation class UsersServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	UserController userController = new UserController(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	private Map<String, Object> convertMap(Map<String, String[]> map) {
		Map<String, Object> result = new HashMap<>();

		for (var entry : map.entrySet()) {
			if (entry.getValue().length == 1) {
				//문자열 1건  
				result.put(entry.getKey(), entry.getValue()[0]);
			} else {
				//문자열 배열을 추가한다  
				result.put(entry.getKey(), entry.getValue());
			}
		}
		
		return result;
	}
	
	//공통 처리 함수 
	private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 설정 
		request.setCharacterEncoding("utf-8");
		
		ObjectMapper objectMapper = new ObjectMapper();
		UserVO userVO = objectMapper.convertValue(convertMap(request.getParameterMap()), UserVO.class);
		System.out.println("userVO " + userVO);
		
		String action = request.getParameter("action");
		switch(action) {
		case "list" -> userController.list(request, userVO);
		case "view" -> userController.view(request, userVO);
		case "delete" -> userController.delete(request, userVO);
		case "updateForm" -> userController.updateForm(request, userVO);
		case "update" -> userController.update(request, userVO);
		case "insertForm" -> userController.insertForm(request);
		case "insert" -> userController.insert(request, userVO);
		}
		
		//3. jsp 포워딩 
		//포워딩 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/users2/"+action+".jsp");
		rd.forward(request, response);
		
	}

}











