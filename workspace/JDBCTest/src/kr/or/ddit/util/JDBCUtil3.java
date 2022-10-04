package kr.or.ddit.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 *  db.properties파일의 내용으로 DB정보를 설정하는 방법
 *  방법2) ResourceBundle 객체 이용하기
 */
public class JDBCUtil3 {
	
	static ResourceBundle bundle;  // ResourceBundle 객체 변수 선언
	
	static {
		
		bundle = ResourceBundle.getBundle("db");
				
		try {
						
			Class.forName(bundle.getString("driver"));
			System.out.println("드라이버 로딩 완료!!");
			
		} catch (ClassNotFoundException ex) {
			System.out.println("드라이버 로딩 실패!!!");
		} 
	}
	
	/**
	 * 커넥션 객체 생성하기
	 * @return
	 */
	public static Connection getConnection() {
		try {
			
			return DriverManager.getConnection(
					bundle.getString("url"),          
					bundle.getString("username"),                             
					bundle.getString("password"));   
		} catch (SQLException ex) {
			System.out.println("DB 연결 실패!!!");
			ex.printStackTrace();
			return null;
		}
	}
	/**
	 * 자원 반납
	 * @param conn
	 * @param stmt
	 * @param pstmt
	 * @param rs
	 */
	public static void close(Connection conn, 
			                 Statement stmt, 
			                 PreparedStatement pstmt, 
			                 ResultSet rs) {
		if (rs != null) try {rs.close();} catch (SQLException ex) {}
		if (stmt != null) try {stmt.close();} catch (SQLException ex) {}
		if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
		if (conn != null) try {conn.close();} catch (SQLException ex) {}
	}
}

// ResourceBundle은 properties editor를 업데이트 한 후에 일정한 형식의 
// 명칭으로 properties 파일을 만들고 파일안에 적은 내용을 Local에 맞도록 언어를
// 적용해 그 나라의 언어로 번역해서 보여준다.   
