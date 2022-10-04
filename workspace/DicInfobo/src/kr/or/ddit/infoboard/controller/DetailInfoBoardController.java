package kr.or.ddit.infoboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.service.AtchFileServiceimpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.infoboard.service.InfoBoardService;
import kr.or.ddit.infoboard.service.InfoBoardServiceImpl;
import kr.or.ddit.infoboard.vo.InfoBoardVO;


@WebServlet("/infoBoard/detail.do")
public class DetailInfoBoardController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int infoboNum = Integer.parseInt(req.getParameter("infoboNum"));
		
		// 1. 서비스 객체 생성하기
		InfoBoardService infoBoardService = InfoBoardServiceImpl.getInstance();
		InfoBoardVO ibv = infoBoardService.getInfoBoard(infoboNum);
			
		IAtchFileService fileService = AtchFileServiceimpl.getInstance();
		
		if(ibv.getAtchFileId() > 0) {  // 첨부파일 존재하면...
			// 1-2. 첨부파일 정보 조회
			AtchFileVO fileVO = new AtchFileVO();
			fileVO.setAtchFileId(ibv.getAtchFileId());
			
			List<AtchFileVO> atchFileList = 
					fileService.getAtchFileList(fileVO);
		
			req.setAttribute("atchFileList", atchFileList);
		}
		
		req.setAttribute("ibv", ibv);
		
		req.getRequestDispatcher("/view/infoBoard/detail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
	}
}
