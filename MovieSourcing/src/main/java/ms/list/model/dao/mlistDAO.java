package ms.list.model.dao;

import static ms.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import ms.list.model.vo.movie;

public class mlistDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public mlistDAO() {
		try {
			prop = new Properties();
			
			String filePath = mlistDAO.class.getResource("/ms/sql/mlist-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	
	public List<movie> selectAll(Connection conn) throws Exception{
		
		List<movie> mlist = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				
				int movieNo = rs.getInt("MOVIE_NO");
				String movieTitle = rs.getString("MOVIE_TITLE");
				String movieGrade = rs.getString("MOVIE_GRADE");
				String national = rs.getString("MOVIE_NATIONAL");
				String moviePoster = rs.getString("MOVIE_POSTER");
				String movieJanr = rs.getString("GENRE");
				
				mlist.add(new movie(movieNo, movieTitle, movieGrade, national, moviePoster, movieJanr));
				
			}
			
			
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		return mlist;
	}



	public List<movie> searchjanr(Connection conn, String input1) throws Exception {
		
		List<movie> mlist = new ArrayList<>();
		
		try {
			
			int num = 0;
			
			
			
			String sql = prop.getProperty("searchJanr");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, input1);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				
				int movieNo = rs.getInt("MOVIE_NO");
				String movieTitle = rs.getString("MOVIE_TITLE");
				String movieGrade = rs.getString("MOVIE_GRADE");
				String national = rs.getString("MOVIE_NATIONAL");
				String moviePoster = rs.getString("MOVIE_POSTER");
				String movieJanr = rs.getString("GENRE");
				
				mlist.add(new movie(movieNo, movieTitle, movieGrade, national, moviePoster, movieJanr));
				
				
				
				
				
			}
			
		}finally {
			close(pstmt);
			close(rs);
			
		}
		
		return mlist;
	}
	
	
public List<movie> searchnation(Connection conn, String input2) throws Exception {
		
		List<movie> mlist = new ArrayList<>();
		
		try {
			
			int num = 0;
			
			
			
			String sql = prop.getProperty("searchNational");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, input2);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				
				int movieNo = rs.getInt("MOVIE_NO");
				String movieTitle = rs.getString("MOVIE_TITLE");
				String movieGrade = rs.getString("MOVIE_GRADE");
				String national = rs.getString("MOVIE_NATIONAL");
				String moviePoster = rs.getString("MOVIE_POSTER");
				String movieJanr = rs.getString("GENRE");
				
				mlist.add(new movie(movieNo, movieTitle, movieGrade, national, moviePoster, movieJanr));
				
				
				
				
				
			}
			
		}finally {
			close(pstmt);
			close(rs);
			
		}
		
		return mlist;
	}
public List<movie> searchgrade(Connection conn, String input3) throws Exception {
	
	List<movie> mlist = new ArrayList<>();
	
	try {
		
		int num = 0;
		
		
		
		String sql = prop.getProperty("searchGrade");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, input3);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			
			
			int movieNo = rs.getInt("MOVIE_NO");
			String movieTitle = rs.getString("MOVIE_TITLE");
			String movieGrade = rs.getString("MOVIE_GRADE");
			String national = rs.getString("MOVIE_NATIONAL");
			String moviePoster = rs.getString("MOVIE_POSTER");
			String movieJanr = rs.getString("GENRE");
			
			mlist.add(new movie(movieNo, movieTitle, movieGrade, national, moviePoster, movieJanr));
			
			
			
			
			
		}
		
	}finally {
		close(pstmt);
		close(rs);
		
	}
	
	return mlist;
}


public List<movie> searchdata(Connection conn, String input4) throws Exception {
	
	List<movie> mlist = new ArrayList<>();
	
	try {
		
		int num = 0;		
		
		String sql = prop.getProperty("searchdata");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, input4);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {		
			
			int movieNo = rs.getInt("MOVIE_NO");
			String movieTitle = rs.getString("MOVIE_TITLE");
			String movieGrade = rs.getString("MOVIE_GRADE");
			String national = rs.getString("MOVIE_NATIONAL");
			String moviePoster = rs.getString("MOVIE_POSTER");
			String movieJanr = rs.getString("GENRE");
			
			mlist.add(new movie(movieNo, movieTitle, movieGrade, national, moviePoster, movieJanr));		
		}
		
	}finally {
		close(pstmt);
		close(rs);
		
	}
	
	return mlist;
}




	
}
