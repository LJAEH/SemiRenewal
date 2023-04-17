package ms.main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ms.common.JDBCTemplate;
import ms.main.model.vo.Main;

public class MainDAO extends JDBCTemplate {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	/**
	 * 메인 영화 컨텐츠 조회
	 * @return List<MovieInfoVO>
	 * @throws SQLException
	 */
	public List<Main> selectMainContent() {
		
		String query = "SELECT MOVIE_NO, MOVIE_TITLE, MOVIE_ENG_TITLE, MOVIE_TIME, MOVIE_OPEN_DATE, MOVIE_SCORE, MOVIE_NATIONAL, MOVIE_GRADE, MOVIE_POSTER, MOVIE_PREVIEW FROM MOVIE_INFORMATION_TABLE";
		List<Main> list = new ArrayList<Main>();
		
		try {
			
			conn = getConnection();								
			pstmt = conn.prepareStatement(query);				
			rs = pstmt.executeQuery(query);						
			
			while (rs.next()) {
				Main vo = new Main(
						rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getString(5)
						, rs.getDouble(6)
						, rs.getString(7)
						, rs.getString(8)
						, rs.getString(9)
						, rs.getString(10)
				);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 메인 커뮤니티 컨텐츠 조회
	 * @return List<MovieInfoVO>
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectMainCommContent() {

		String query = "SELECT T1.MEM_IMG, T1.MEM_NICK, T2.COM_DATE, T2.COM_CONTENT, T2.COM_TITLE FROM MEMBER T1 INNER JOIN COMMUNITY_TABLE T2 ON T1.MEM_NO = T2.MEM_NO WHERE ROWNUM <= 2 ORDER BY COM_DATE DESC"; 
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			conn = getConnection();								
			pstmt = conn.prepareStatement(query);				
			rs = pstmt.executeQuery(query);						
			
			while (rs.next()) {
				list.add(
					new HashMap<String, Object>() {{
						put("memImg", rs.getString(1));
						put("memNick", rs.getString(2));
						put("comDate", rs.getString(3));
						put("comContent", rs.getString(4));
						put("comTitle", rs.getString(5));
					}}
				);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Map<String, Object>> selectMainReviews() {
		String query = "SELECT T1.MEM_IMG, T1.MEM_NICK, T2.REVIEW_CONTENT, T3.MOVIE_TITLE FROM MEMBER T1 INNER JOIN REVIEW T2 ON T1.MEM_NO = T2.MEM_NO INNER JOIN MOVIE_INFORMATION_TABLE T3 ON T2.MOVIE_NO = T3.MOVIE_NO WHERE ROWNUM <= 4 ORDER BY REVIEW_DATE DESC";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			conn = getConnection();								
			pstmt = conn.prepareStatement(query);				
			rs = pstmt.executeQuery(query);						
			
			while (rs.next()) {
				list.add(
					new HashMap<String, Object>() {{
						put("memImg", rs.getString(1));
						put("memNick", rs.getString(2));
						put("reviewContent", rs.getString(3));
						put("movieTitle", rs.getString(4));
					}}
				);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}

