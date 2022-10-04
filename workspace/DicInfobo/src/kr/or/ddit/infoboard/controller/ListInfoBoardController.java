package kr.or.ddit.infoboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.infoboard.service.InfoBoardService;
import kr.or.ddit.infoboard.service.InfoBoardServiceImpl;
import kr.or.ddit.infoboard.vo.InfoBoardVO;

@WebServlet(value = "/infoBoard/list.do")
public class ListInfoBoardController extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 서비스 객체 생성하기
		InfoBoardService infoBoardService = InfoBoardServiceImpl.getInstance();
		
		// 2. 회원목록 조회
		List<InfoBoardVO> infoBoardList = infoBoardService.getAllInfoBoardList();
		
		req.setAttribute("infoBoardList", infoBoardList);
		
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/view/infoBoard/list.jsp");
		
		dispatcher.forward(req, resp);  // 뷰 페이지로 전달.
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
