package com.msa2024.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsersServlet
 */
public class BoardsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	BoardsDAO boardsDAO = new BoardsDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardsServlet() {
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
	
	//공통 처리 함수 
	private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 설정 
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		String jspPage = switch(action) {
		case "list" -> list(request, response);
		case "view" -> view(request, response);
		case "delete" -> delete(request, response);
		case "updateForm" -> updateForm(request, response);
		case "update" -> update(request, response);
		case "insertForm" -> insertForm(request, response);
		case "insert" -> insert(request, response);
		default -> "";
		};
		
		if (jspPage.startsWith("redirect:")) {
			//리다이렉드 
			response.sendRedirect(jspPage.substring("redirect:".length()));	
		} else {
			//3. jsp 포워딩 
			//포워딩 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/boards/"+ jspPage +".jsp");
			rd.forward(request, response);
		
		}
		
	}

	private String list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("목록");
		String searchKey = request.getParameter("searchKey");
		//1. 처리
		List<Boards> list = boardsDAO.list(searchKey);
		
		//2. jsp출력할 값 설정
		request.setAttribute("list", list);
		
		return "list";
	}
	
	private String view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("상세보기");
		String bno = request.getParameter("bno");
		//1. 처리
		Boards board = boardsDAO.read(bno);
		
		//2. jsp출력할 값 설정
		request.setAttribute("board", board);
		
		return "view";
	}
	
	private String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("삭제");
		String bno = request.getParameter("bno");
		//1. 처리
		int updated = boardsDAO.delete(bno);
		
		//2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
		
		return "delete";
	}
	
	private String updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("수정화면");
		String bno = request.getParameter("bno");
		//1. 처리
		Boards board = boardsDAO.read(bno);
		
		//2. jsp출력할 값 설정
		request.setAttribute("board", board);
		
		return "updateForm";
	}
	
	private String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("수정");
		String bno = request.getParameter("bno");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		Boards user = new Boards(bno, btitle, bcontent);
		
		//1. 처리
		int updated = boardsDAO.update(user);
		
		//2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
		
		return "update";
	}
	
	private String insertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("등록화면");
		//1. 처리
		
		//2. jsp출력할 값 설정
		
		return "insertForm";
	}
	
	private String insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("등록");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bwriter = request.getParameter("bwriter");
		
		Boards user = new Boards("", btitle, bcontent, bwriter, "");
		
		//1. 처리
		int updated = boardsDAO.insert(user);
		
		//2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
		
		return "redirect:boards?action=list";
		
	}
		
}











