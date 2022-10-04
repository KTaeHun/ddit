package Board.dao;

import java.util.List;

import Board.vo.BoardVO;

public interface BoardDAO {

	public int insertBoard(BoardVO bv);
	
	public boolean checkBoard(int boardNo);
	
	public int updateBoard(BoardVO bv);
	
	public int deleteBoard(int boardNo);
	
	public List<BoardVO> getAllBoardList();
	
	public List<BoardVO> searchBoardList(BoardVO bv);
}
