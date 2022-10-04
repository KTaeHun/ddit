package kr.or.ddit.infoboard.controller;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class UpdateMemberController
 */
@MultipartConfig
@WebServlet("/infoBoard/update.do")
public class UpdateInfoBoardController extends HttpServlet {
	
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int infoboNum = Integer.parseInt(req.getParameter("infoboNum"));
		
		// 1. 서비스 객체 생성하기
		InfoBoardService infoBoardService = InfoBoardServiceImpl.getInstance();
		InfoBoardVO ibv = infoBoardService.getInfoBoard(infoboNum);
		

		if (ibv.getAtchFileId() > 0) { // 첨부파일 존재하면...
			// 1-2. 첨부파일 정보 조회
			IAtchFileService fileService = AtchFileServiceimpl.getInstance();
			AtchFileVO fileVO = new AtchFileVO();
			fileVO.setAtchFileId(ibv.getAtchFileId());

			List<AtchFileVO> atchFileList = 
					fileService.getAtchFileList(fileVO);

			req.setAttribute("atchFileList", atchFileList);
		}
		
		req.setAttribute("ibv", ibv);
		
		req.getRequestDispatcher("/view/infoBoard/updateForm.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청파라미터 정보 가져오기
		// int infoboNum = Integer.parseInt(req.getParameter("infoboNum"));
		String infoboTitle = req.getParameter("infoboTitle");
		int infoboLike = Integer.parseInt(req.getParameter("infoboLike"));
		String infoboCon = req.getParameter("infoboCon");
		
		String atchFileId = req.getParameter("fileId");
		
		// 2.서비스 객체 생성하기
	    InfoBoardService infoBoardService = InfoBoardServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceimpl.getInstance();

		// 첨부파일 저장하기
		AtchFileVO atchFileVO = fileService.saveAtchFileList(req);
	    
	    
	    // 3.회원정보 수정하기
	    InfoBoardVO ibv = new InfoBoardVO();
	    // ibv.setInfoboNum(infoboNum);
	    ibv.setInfoboTitle(infoboTitle);
	    ibv.setInfoboLike(infoboLike);
	    ibv.setInfoboCon(infoboCon);
	      	
	    if (atchFileVO == null) {  // 새로운 첨부파일이 존재하지 않으면...
	    	// 기존 첨부파일ID 설정하기
	    	ibv.setAtchFileId(Long.parseLong(atchFileId));
	    } else {
	    	// 신규 첨부파일ID 설정하기
	    	ibv.setAtchFileId(atchFileVO.getAtchFileId());
	    }
	    	    
		int cnt = infoBoardService.modifyInfoBoard(ibv);	
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		// req.setAttribute("msg", msg);
		
		HttpSession session = req.getSession();
		session.setAttribute("msg", msg);
		
		
		// 4. 목록 조회 화면으로 이동
		String redirectUrl = req.getContextPath() + "/infoBoard/list.do";
		
		resp.sendRedirect(redirectUrl);
	}
}
