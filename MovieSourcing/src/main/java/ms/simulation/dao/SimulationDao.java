package ms.simulation.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import ms.common.JDBCTemplate;
import ms.member.model.dao.MemberDAO;
import ms.movie.model.vo.MovieInfo;

import static ms.common.JDBCTemplate.*;


public class SimulationDao {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	


	public SimulationDao() {
		try {
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/ms/sql/simulation-sql.xml").getPath();  
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public  List<String> getAllGenres(Connection conn) throws Exception{
		 List<String> genres = new ArrayList<String>();
		
		  
		 
		 try {
		       
		    	String sql = prop.getProperty("genre");
		        stmt = conn.createStatement();
		        rs = stmt.executeQuery(sql);
		        
		        while (rs.next()) {
		            genres.add(rs.getString("GENRE_NO"));
		        }
		 
		    } finally {
		    	close(rs);
				close(stmt);
				
		    }

		    return genres;
		}




	public MovieInfo movieInfo(Connection conn, int selectedGenre) throws Exception{
	MovieInfo movie = new MovieInfo();
		
		try {
			
			String sql = prop.getProperty("randommovie");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,selectedGenre );
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				movie.setMovieNo(rs.getInt(1));
				movie.setMovieTitle(rs.getString(2));
				movie.setMovieEngTitle(rs.getString(3));
				movie.setMovieTime(rs.getInt(4));
				movie.setMovieOpenDate(rs.getString(5));
				movie.setMovieScore(rs.getInt(6));
				movie.setMovieNational(rs.getString(7));
				movie.setMovieGrade(rs.getString(8));
				movie.setMoviePoster(rs.getString(9));
				movie.setMoviePreview(rs.getString(10));
		     }
			    } finally {
			        close(rs);
			        close(pstmt);
			    }

			    return movie;
			}


	public String getGenreName(Connection conn, int selectedGenre) throws Exception{
		String getGenreName = null ;
		  
		  try {
				
			String sql = prop.getProperty("genreName");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,selectedGenre );
			
			rs = pstmt.executeQuery();
			  if (rs.next()) {
				  getGenreName = rs.getString("GENRE");
			  }
		    } finally {
		        close(rs);
		        close(pstmt);
		    }

		    return getGenreName;
		}

}
