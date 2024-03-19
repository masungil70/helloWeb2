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

/**
 * Servlet implementation class UsersServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	UserDAO usersDAO = new UserDAO();
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
		case "list" -> list(request, userVO);
		case "view" -> view(request, userVO);
		case "delete" -> delete(request, userVO);
		case "updateForm" -> updateForm(request, userVO);
		case "update" -> update(request, userVO);
		case "insertForm" -> insertForm(request);
		case "insert" -> insert(request, userVO);
		}
		
		//3. jsp 포워딩 
		//포워딩 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/users2/"+action+".jsp");
		rd.forward(request, response);
		
	}

	private void list(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("목록");
		
		//1. 처리
		List<UserVO> list = usersDAO.list();
		
		//2. jsp출력할 값 설정
		request.setAttribute("list", list);
		
	}
	
	private void view(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("상세보기");
		//String userid = request.getParameter("userid");
		//1. 처리
		
		//2. jsp출력할 값 설정
		request.setAttribute("user", usersDAO.read(user));
	}
	
	private void delete(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("삭제");
		//1. 처리
		int updated = usersDAO.delete(user);
		
		//2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
	}
	
	private void updateForm(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("수정화면");
		//1. 처리
		//usersDAO.read(user);
		
		//2. jsp출력할 값 설정
		request.setAttribute("user", usersDAO.read(user));
	}
	
	private void update(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("수정");
		
		//1. 처리
		int updated = usersDAO.update(user);
		
		//2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
	}
	
	private void insertForm(HttpServletRequest request) throws ServletException, IOException {
		System.out.println("등록화면");
		//1. 처리
		
		//2. jsp출력할 값 설정
	}
	
	private void insert(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("등록");
		
		//1. 처리
		int updated = usersDAO.insert(user);
		
		//2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
	}
	
}











