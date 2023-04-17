package ms.movielist.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;

import ms.board.model.dao.BoardDAO;
import ms.member.model.vo.Member;
import ms.movielist.model.vo.ActorInfo;
import ms.movielist.model.vo.ListMemberInfo;
import ms.movielist.model.vo.MovieListInfo;
import ms.movielist.model.vo.PdInfo;

import static ms.common.JDBCTemplate.*;

public class MovieListDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MovieListDAO() {
		try {
			prop = new Properties();
			
			String filePath = BoardDAO.class.getResource("/ms/sql/movieList-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/** 배우 영화 리스트
	 * @param conn
	 * @param actorNo
	 * @return
	 * @throws SQLException
	 */
	public List<MovieListInfo> movieListInfo(Connection conn, int actorNo) throws SQLException {
		// TODO Auto-generated method stub
		
		List<MovieListInfo> movieListInfo = new ArrayList<>();
		
		MovieListInfo temp = null;
		
		try {
			String sql = prop.getProperty("actorMovieList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, actorNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				temp = new MovieListInfo
						(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getInt(4));
				
				movieListInfo.add(temp);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return movieListInfo;
	}


	/** 감독 영화 리스트
	 * @param conn
	 * @param pdNo
	 * @return
	 * @throws SQLException
	 */
	public List<MovieListInfo> pdMovieListInfo(Connection conn, int pdNo) throws SQLException {
		// TODO Auto-generated method stub
		List<MovieListInfo> movieListInfo = new ArrayList<>();
		
		MovieListInfo temp = null;
		
		try {
			String sql = prop.getProperty("pdMovieList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pdNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				temp = new MovieListInfo
						(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getInt(4));
				
				movieListInfo.add(temp);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return movieListInfo;
	}


	/** 배우 정보
	 * @param conn
	 * @param actorNo
	 * @return
	 * @throws SQLException 
	 */
	public ActorInfo actorInfo(Connection conn, int actorNo) throws SQLException {
		// TODO Auto-generated method stub
		
		ActorInfo actorInfo = new ActorInfo();
		
		try {
			
			String sql = prop.getProperty("actorInfo");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, actorNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				actorInfo.setActorNo(actorNo);
				actorInfo.setActorName(rs.getString(2));
				actorInfo.setActorImg(rs.getString(3));
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return actorInfo;
	}


	public PdInfo pdInfo(Connection conn, int pdNo) throws SQLException {
		// TODO Auto-generated method stub

		PdInfo pdInfo = new PdInfo();
		
		try {
			
			String sql = prop.getProperty("pdInfo");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pdNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pdInfo.setPdNo(pdNo);
				pdInfo.setPdName(rs.getString(2));
				pdInfo.setPdImg(rs.getString(3));
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return pdInfo;
	}


	/** 마이페이지 본영화
	 * @param conn
	 * @param memberNo
	 * @return
	 * @throws SQLException
	 */
	public List<MovieListInfo> watchedList(Connection conn, int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		
		List<MovieListInfo> watchedList = new ArrayList<>();
		
		MovieListInfo watchedTemp = null;
		
		try {
			String sql = prop.getProperty("watchedList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				watchedTemp = new MovieListInfo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5));
				watchedList.add(watchedTemp);			
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return watchedList;
	}


	public ListMemberInfo memberName(Connection conn, int memberNo) throws SQLException {
		// TODO Auto-generated method stub

		ListMemberInfo member = new ListMemberInfo();
		
		try {
			
			String sql = prop.getProperty("memberName");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setMemberNo(memberNo);
				member.setMemberNick(rs.getString(2));
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return member;
		
	}


	public List<MovieListInfo> wishList(Connection conn, int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		List<MovieListInfo> wishList = new ArrayList<>();
		
		MovieListInfo wishTemp = null;
		
		try {
			String sql = prop.getProperty("wishList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				wishTemp = new MovieListInfo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5));
				wishList.add(wishTemp);			
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return wishList;
	}


	public int deleteWatchedList(Connection conn, int movieNo, int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteWatchedList");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, movieNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteWishList(Connection conn, int movieNo, int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteWishList");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, movieNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public List<MovieListInfo> hateList(Connection conn, int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		List<MovieListInfo> hateList = new ArrayList<>();
		
		MovieListInfo temp = null;
		
		try {
			String sql = prop.getProperty("hateList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				temp = new MovieListInfo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5));
				hateList.add(temp);			
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return hateList;
	}
	

}
