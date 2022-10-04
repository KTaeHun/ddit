package Board.service;

import java.util.List;
import Board.dao.BoardDAO;
import Board.dao.BoardDAOImpl;
import Board.service.BoardService;
import Board.vo.BoardVO;

public class BoardServiceImpl implements BoardService{

		private BoardDAOImpl boardDao;
		
		public BoardServiceImpl() {
			boardDao = new BoardDAOImpl();
		}
		
		@Override
		public int registerBoard(BoardVO bv) {
			
			int cnt = boardDao.insertBoard(bv);
			
			return cnt;
		}

		@Override
		public boolean checkBoard(int boardNo) {
			
			boolean chk = boardDao.checkBoard(boardNo);
			
			return chk;
		}

		@Override
		public int modifyBoard(BoardVO bv) {
			
			int cnt = boardDao.updateBoard(bv);
			
			return cnt;
		}

		@Override
		public int removeBoard(int boardNo) {
			
			int cnt = boardDao.deleteBoard(boardNo);
			
			return cnt;
		}

		@Override
		public List<BoardVO> getAllBoardList() {
			
			List<BoardVO> boardList = boardDao.getAllBoardList();
			return boardList;
		}

		@Override
		public List<BoardVO> searchBoardList(BoardVO bv) {
			return boardDao.searchBoardList(bv);
		}
}
