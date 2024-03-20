package com.msa2024.board.step2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BoardController {
	private static final long serialVersionUID = 1L;

	//xml 또는 어노터이션 처리하면 스프링 
	//어노터이션 처리하면 스프링 부트   
	BoardService boardService = new BoardService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public Object list(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("목록");
		
		//1. 처리
		List<BoardVO> list = boardService.list(board);
		
		//2. jsp출력할 값 설정
		request.setAttribute("list", list);
		
		return "list";
	}
	
	public Object view(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("상세보기");
		//String boardid = request.getParameter("boardid");
		//1. 처리
		
		//2. jsp출력할 값 설정
		request.setAttribute("board", boardService.view(board));
		return "view";
	}
	
	public Object delete(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("삭제");
		//1. 처리
		int updated = boardService.delete(board);
		
		Map<String, Object> map = new HashMap<>();
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "게시물 정보 삭제 실패하였습니다");
		}
		
		return map;
	}
	
	public Object updateForm(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("수정화면");
		//1. 처리
		//boardsDAO.read(board);
		
		//2. jsp출력할 값 설정
		request.setAttribute("board", boardService.updateForm(board));
		
		return "updateForm"; 
	}
	
	public Object update(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("수정");
		
		//1. 처리
		int updated = boardService.update(board);
		
		Map<String, Object> map = new HashMap<>();
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "게시물 정보 수정 실패하였습니다");
		}
		
		return map;
	}
	
	public Object insertForm(HttpServletRequest request) throws ServletException, IOException {
		System.out.println("등록화면");
		//1. 처리
		
		//2. jsp출력할 값 설정
		return "insertForm";
	}
	
	public Object insert(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("등록");
		Map<String, Object> map = new HashMap<>();
		
		//전처리 
		//로그인 사용자 설정 
		
		//1. 처리
		int updated = boardService.insert(board);
		
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "회원 가입이 실패하였습니다");
		}
		return map;
	}
	
}











