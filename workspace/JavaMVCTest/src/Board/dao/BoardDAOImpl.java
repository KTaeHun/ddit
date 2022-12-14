package Board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Board.vo.BoardVO;
import kr.or.ddit.util.JDBCUtil3;

public class BoardDAOImpl implements BoardDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int insertBoard(BoardVO bv) {

		int cnt = 0;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = " INSERT INTO JDBC_BOARD ( board_no, board_title, board_writer, board_date, board_content)"
					+ " VALUES (?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bv.getBoardNo());
			pstmt.setString(2, bv.getBoardTitle());
			pstmt.setString(3, bv.getBoardWriter());
			pstmt.setString(4, bv.getBoardDate());
			pstmt.setString(5, bv.getBoardContent());
			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("새글 등록 과정중 예외발생!", ex);
		} finally {
			// 자원반납...
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public boolean checkBoard(int boardNo) {

		boolean chk = false;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = " select count(*) as cnt from JDBC_BOARD " + " where board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();
			// return 값이 ResultSet이므로 resultSet 변수에 담음.

			int cnt = 0;

			if (rs.next()) {
				cnt = rs.getInt("cnt");
				// 컬럼 이름을 주어도, 컬럼 인덱스 번호를 주어도된다.
			}

			if (cnt > 0) {
				chk = true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("체크 과정중 예외발생!", ex);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return chk;
	}

	@Override
	public int updateBoard(BoardVO bv) {

		int cnt = 0;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = " UPDATE JDBC_BOARD " + " SET board_title = ? " 
			           + " , board_writer = ? " + " , board_date = ? " + 
					   " , board_content = ? " + " WHERE board_no = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bv.getBoardTitle());
			pstmt.setString(2, bv.getBoardWriter());
			pstmt.setString(3, bv.getBoardDate());
			pstmt.setString(4, bv.getBoardContent());
			pstmt.setInt(5, bv.getBoardNo());

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("글 수정 과정중 예외발생!", ex);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {

		int cnt = 0;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "delete from JDBC_BOARD where board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("글 삭제 과정중 예외발생!", ex);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardList() {

		List<BoardVO> boardList = new ArrayList<BoardVO>();

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "select * from JDBC_BOARD";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardVO bv = new BoardVO();
				bv.setBoardNo(rs.getInt("board_no"));
				bv.setBoardTitle(rs.getString("board_title"));
				bv.setBoardWriter(rs.getString("board_writer"));
				bv.setBoardDate(rs.getString("board_date"));
				bv.setBoardContent(rs.getString("board_content"));

				boardList.add(bv);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("전체 게시판 조회 중 예외발생!", ex);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return boardList;
	}

	@Override
	public List<BoardVO> searchBoardList(BoardVO bv) {
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "select * from JDBC_Board where 1=1 ";
			
			if(bv.getBoardNo() != 0) {
				sql += " and board_no = ? ";
			}
			if(bv.getBoardTitle() != null && !bv.getBoardTitle().equals("")) {
				sql += " and board_title like '%' || ? || '%' ";
			}
			if(bv.getBoardWriter() != null && !bv.getBoardWriter().equals("")) {
				sql += " and board_writer like '%' || ? || '%' ";
			}
			if(bv.getBoardDate() != null && !bv.getBoardDate().equals("")) {
				sql += " and board_date like '%' || ? || '%' ";
			}
			if(bv.getBoardContent() != null && !bv.getBoardContent().equals("")) {
				sql += " and board_content like '%' || ? || '%' ";
			}
								
			pstmt = conn.prepareStatement(sql);
			int index = 1;  // '?' 위치를 지정해 주려고 index변수를 지정
			
			if(bv.getBoardNo() != 0) {
				pstmt.setInt(index++, bv.getBoardNo());
			}
			if(bv.getBoardTitle() != null && !bv.getBoardTitle().equals("")) {
				pstmt.setString(index++, bv.getBoardTitle());
			}
			if(bv.getBoardWriter() != null && !bv.getBoardWriter().equals("")) {
				pstmt.setString(index++, bv.getBoardWriter());
			}
			if(bv.getBoardDate() != null && !bv.getBoardDate().equals("")) {
				pstmt.setString(index++, bv.getBoardDate());
			}
			if(bv.getBoardContent() != null && !bv.getBoardContent().equals("")) {
				pstmt.setString(index++, bv.getBoardContent());
			}
		
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO bv2 = new BoardVO();
				bv2.setBoardNo(rs.getInt("board_no"));
				bv2.setBoardTitle(rs.getString("board_title"));
				bv2.setBoardWriter(rs.getString("board_writer"));
				bv2.setBoardDate(rs.getString("board_date"));
				bv2.setBoardContent(rs.getString("board_content"));
				
				boardList.add(bv2);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
		return boardList;
	}
}
