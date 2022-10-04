package Board.service;

import java.util.List;

import Board.vo.BoardVO;

public interface BoardService {

	public int registerBoard(BoardVO bv);
		
	public boolean checkBoard(int boardNo);
	
	public int modifyBoard(BoardVO bv);
		
	public int removeBoard(int boardNo);
	
	public List<BoardVO> getAllBoardList();

	public List<BoardVO> searchBoardList(BoardVO bv); 
}
