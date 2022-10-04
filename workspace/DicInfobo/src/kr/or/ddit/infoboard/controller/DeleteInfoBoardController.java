package kr.or.ddit.infoboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.infoboard.service.InfoBoardService;
import kr.or.ddit.infoboard.service.InfoBoardServiceImpl;


@WebServlet("/infoBoard/delete.do")
public class DeleteInfoBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int infoboNum = Integer.parseInt(req.getParameter("infoboNum"));
		
		// 1. 서비스 객체 생성하기
		InfoBoardService infoBoardService = InfoBoardServiceImpl.getInstance();
		
		// 2. 삭제처리
		int cnt = infoBoardService.removeInfoBoard(infoboNum);
		
		String msg = "";
		
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("msg", msg);
		
		// 3. 목록화면으로 이동하기
		String redirectUrl = req.getContextPath() + "/infoBoard/list.do";
		
		resp.sendRedirect(redirectUrl);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
