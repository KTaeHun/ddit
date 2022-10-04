package kr.or.ddit.infoboard.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.comm.service.AtchFileServiceimpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.infoboard.service.InfoBoardService;
import kr.or.ddit.infoboard.service.InfoBoardServiceImpl;
import kr.or.ddit.infoboard.vo.InfoBoardVO;

@MultipartConfig
@WebServlet("/infoBoard/insert.do")
public class InsertInfoBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/infoBoard/InsertForm.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		// 1. 파라미터 데이터 가져오기
		// int infoboNum = Integer.parseInt(req.getParameter("infoboNum"));
		String infoboTitle = req.getParameter("infoboTitle");
		int infoboLike = Integer.parseInt(req.getParameter("infoboLike"));
		String infoboCon = req.getParameter("infoboCon");
		String infoboDate = req.getParameter("sysdate");
		
		// 2. 서비스 객체 생성하기
		InfoBoardService infoBoardService = InfoBoardServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceimpl.getInstance();
		
		// 첨부파일 저장하기
		AtchFileVO atchFileVO = fileService.saveAtchFileList(req);
		
		// 3. 회원정보 등록하기
		InfoBoardVO ibv = new InfoBoardVO();
		// ibv.setInfoboNum(infoboNum);
		ibv.setInfoboTitle(infoboTitle);
		ibv.setInfoboLike(infoboLike);
		ibv.setInfoboCon(infoboCon);
		ibv.setInfoboDate(infoboDate);
		ibv.setAtchFileId(atchFileVO.getAtchFileId());
		
		int cnt = infoBoardService.registerInfoBoard(ibv);
		
		String msg = "";
		if (cnt > 0) {
			// 성공
			msg = "성공";
		} else {
			// 실패
			msg = "실패";
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("msg", msg);
		
		// 4. 목록 조회 화면으로 이동
		// req.getRequestDispatcher("/infoBoard/list.do").forward(req, resp);
		
		String redirectUrl = req.getContextPath() + "/infoBoard/list.do";
		
		resp.sendRedirect(redirectUrl);
	}
}
