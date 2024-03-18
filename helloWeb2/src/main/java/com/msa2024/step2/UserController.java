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
import com.msa2024.UsersServlet;
import com.msa2024.step2.dao.UserDAO;
import com.msa2024.step2.vo.UserVO;

public class UserController {
	private static final long serialVersionUID = 1L;

	//xml 또는 어노터이션 처리하면 스프링 
	//어노터이션 처리하면 스프링 부트   
	UserService userService = new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void list(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("목록");
		
		//1. 처리
		List<UserVO> list = userService.list(user);
		
		//2. jsp출력할 값 설정
		request.setAttribute("list", list);
		
	}
	
	public void view(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("상세보기");
		//String userid = request.getParameter("userid");
		//1. 처리
		
		//2. jsp출력할 값 설정
		request.setAttribute("user", userService.view(user));
	}
	
	public void delete(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("삭제");
		//1. 처리
		int updated = userService.delete(user);
		
		//2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
	}
	
	public void updateForm(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("수정화면");
		//1. 처리
		//usersDAO.read(user);
		
		//2. jsp출력할 값 설정
		request.setAttribute("user", userService.updateForm(user));
	}
	
	public void update(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("수정");
		
		//1. 처리
		int updated = userService.update(user);
		
		//2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
	}
	
	public void insertForm(HttpServletRequest request) throws ServletException, IOException {
		System.out.println("등록화면");
		//1. 처리
		
		//2. jsp출력할 값 설정
	}
	
	public void insert(HttpServletRequest request, UserVO user) throws ServletException, IOException {
		System.out.println("등록");
		
		//1. 처리
		int updated = userService.insert(user);
		
		//2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
	}
	
}











