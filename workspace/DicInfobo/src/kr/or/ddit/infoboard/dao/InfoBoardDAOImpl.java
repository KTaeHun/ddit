package kr.or.ddit.infoboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.infoboard.vo.InfoBoardVO;
import kr.or.ddit.util.MyBatisUtil;

public class InfoBoardDAOImpl implements InfoBoardDAO {

	private static InfoBoardDAO infoBoardDao;
	
	private SqlSession sqlSession;
	
	public InfoBoardDAOImpl() {
		sqlSession = MyBatisUtil.getInstance(true);
	}

	public static InfoBoardDAO getInstance() {
		if (infoBoardDao == null) {
			infoBoardDao = new InfoBoardDAOImpl();
		}
		return infoBoardDao;
	}
	
	@Override
	public int insertInfoBoard(InfoBoardVO ibv) {
		
		int cnt = sqlSession.insert("infoBoard.insertInfoBoard", ibv);
			
		return cnt;
	}

	@Override
	public boolean checkInfoBoard(int infoboNum) {
		boolean chk = false;
		
		int cnt = sqlSession.selectOne("infoBoard.checkInfoBoard", infoboNum);
		
		if (cnt > 0) {
			chk = true;
		}
		
		return chk;
	}

	@Override
	public int updateInfoBoard(InfoBoardVO ibv) {

		int cnt = sqlSession.update("infoBoard.updateInfoBoard", ibv);
		
		return cnt;
	}

	@Override
	public int deleteInfoBoard(int infoboNum) {

		int cnt = sqlSession.delete("infoBoard.deleteInfoBoard", infoboNum);
		
		return cnt;
	}

	@Override
	public List<InfoBoardVO> getAllInfoBoardList() {
		
		List<InfoBoardVO> infoBoardList = 
				sqlSession.selectList("infoBoard.infoBoardAllList");
		
		return infoBoardList;
	}

	@Override
	public List<InfoBoardVO> searchInfoBoardList(InfoBoardVO ibv) {
		
		List<InfoBoardVO> infoBoardList = 
				sqlSession.selectList("infoBoard.searchInfoBoardList", ibv);
		
		return infoBoardList;
	}

	@Override
	public InfoBoardVO getInfoBoard(int infoboNum) {
		
		InfoBoardVO infoBoardVO = sqlSession.selectOne("infoBoard.getInfoBoard", infoboNum);
	
		return infoBoardVO;
	}
}
