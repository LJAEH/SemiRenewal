package ms.member.model.dao;

import static ms.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import ms.board.model.dao.BoardDAO;
import ms.member.model.vo.LifeMovieVO;
import ms.member.model.vo.MemberCount;

public class MyPageDAO {
	

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MyPageDAO() {
		try {
			prop = new Properties();
			
			String filePath = BoardDAO.class.getResource("/ms/sql/movieList-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberCount> memberCount(Connection conn, int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		
		List<MemberCount> memberCount = new ArrayList<>();
		
		MemberCount temp = null;
		
		try {
			String sql = prop.getProperty("memberCount");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,memberNo);
			pstmt.setInt(2,memberNo);
			pstmt.setInt(3,memberNo);
			pstmt.setInt(4,memberNo);
			pstmt.setInt(5,memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				temp = new MemberCount(rs.getInt(1));
				
				memberCount.add(temp);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return memberCount;
	}

	public List<LifeMovieVO> lifeMovie(Connection conn, int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		
		List<LifeMovieVO> lifeMovieList = new ArrayList<>();
		
		LifeMovieVO temp = null;
		
		try {
			String sql = prop.getProperty("lifeMovie");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				temp = new LifeMovieVO
						(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3));
				
				lifeMovieList.add(temp);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return lifeMovieList;
	}

}
