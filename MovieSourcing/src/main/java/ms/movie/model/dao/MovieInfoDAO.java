package ms.movie.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static ms.common.JDBCTemplate.*;

import ms.board.model.dao.BoardDAO;
import static ms.common.JDBCTemplate.*;
import ms.movie.model.vo.MovieInfo;
import ms.movie.model.vo.MovieInfoCheck;
import ms.movie.model.vo.MoviePeople;
import ms.movie.model.vo.MovieRecommend;
import ms.movie.model.vo.MovieReview;

/**
 * @author kjo63
 *
 */
public class MovieInfoDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	
	
	public MovieInfoDAO() {

		try {

			prop = new Properties();
			
			String filePath = MovieInfoDAO.class.getResource("/ms/sql/movie-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/** movieInfo DAO
	 * @param conn
	 * @param movieNo
	 * @return movieInfo
	 */
	public MovieInfo movieInfo(Connection conn, int movieNo) throws Exception{
		
		MovieInfo movieInfo = new MovieInfo();
		
		try {
			
			String sql = prop.getProperty("movieInfo");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				movieInfo.setMovieNo(movieNo);
				movieInfo.setMovieTitle(rs.getString(2));
				movieInfo.setMovieEngTitle(rs.getString(3));
				movieInfo.setMovieTime(rs.getInt(4));
				movieInfo.setMovieOpenDate(rs.getString(5));
				movieInfo.setMovieScore(rs.getInt(6));
				movieInfo.setMovieNational(rs.getString(7));
				movieInfo.setMovieGrade(rs.getString(8));
				movieInfo.setMoviePoster(rs.getString(9));
				movieInfo.setMoviePreview(rs.getString(10));
			}
			
			sql = prop.getProperty("genreSelect");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			List<String> genre = new ArrayList<>();
			
			while(rs.next()) {
				String genreTemp = rs.getString(1);
				
				genre.add(genreTemp);
			}
			
			movieInfo.setMovieGenre(genre);
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return movieInfo;
	}

	public MoviePeople moviePeople(Connection conn, int movieNo) throws Exception {
		
		MoviePeople moviePeople = new MoviePeople();
		
		try {
			
			String sql = prop.getProperty("pdSelect");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				moviePeople.setPdName(rs.getString(1));
				moviePeople.setPdPicture(rs.getString(2));
				moviePeople.setPdNo(rs.getInt(3));
			}
			
			sql = prop.getProperty("actSelect");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			List<String> act = new ArrayList<>();
			List<String> actPicture = new ArrayList<>();
			List<Integer> actNo = new ArrayList<>();
			
			while(rs.next()) {
				String actor = rs.getString(1);
				String actorPicture = rs.getString(2);
				int actorNo = rs.getInt(3);
				
				act.add(actor);
				actPicture.add(actorPicture);
				actNo.add(actorNo);
			}
			
			
			moviePeople.setAct1(act.get(0));
			moviePeople.setAct2(act.get(1));
			moviePeople.setAct3(act.get(2));
			moviePeople.setAct4(act.get(3));
			
			moviePeople.setAct1Picture(actPicture.get(0));
			moviePeople.setAct2Picture(actPicture.get(1));
			moviePeople.setAct3Picture(actPicture.get(2));
			moviePeople.setAct4Picture(actPicture.get(3));
			
			moviePeople.setAct1No(actNo.get(0));
			moviePeople.setAct2No(actNo.get(1));
			moviePeople.setAct3No(actNo.get(2));
			moviePeople.setAct4No(actNo.get(3));
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return moviePeople;
	}

	/** 리뷰
	 * @param conn
	 * @param movieNo
	 * @return
	 */
	public List<MovieReview> movieReview(Connection conn, int movieNo) throws Exception {
		
		List<MovieReview> movieReview = new ArrayList<>();
		
		MovieReview temp = null;
		
		try {
			
			String sql = prop.getProperty("movieReview");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				temp = new MovieReview(movieNo, rs.getInt(2), rs.getString(3), rs.getString(4), 
						rs.getInt(5), rs.getString(6), rs.getString(7));
				
				movieReview.add(temp);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return movieReview;
	}

	public List<MovieRecommend> movieRecommend(Connection conn, List<String> movieRecommendList) throws Exception {
		
		List<MovieRecommend> tempList = new ArrayList<>();
		List<MovieRecommend> movieRecommend = new ArrayList<>();
		
		try {
			
			String sql = "";
			
			int num = movieRecommendList.size();
			
			pstmt = null;
			
			switch(num) {
				case 1 :  
					sql = prop.getProperty("movieRecommend1");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, movieRecommendList.get(0));
					break;
					
				case 2 :
					sql = prop.getProperty("movieRecommend2");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, movieRecommendList.get(0));
					pstmt.setString(2, movieRecommendList.get(1));
					break;
			
				case 3 : 
					sql = prop.getProperty("movieRecommend3");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, movieRecommendList.get(0));
					pstmt.setString(2, movieRecommendList.get(1));
					pstmt.setString(3, movieRecommendList.get(2));
					break;
					
				default : 
					sql = prop.getProperty("movieRecommend3");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, movieRecommendList.get(0));
					pstmt.setString(2, movieRecommendList.get(1));
					pstmt.setString(3, movieRecommendList.get(2));
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieRecommend temp = new MovieRecommend();
				
				temp.setMovieNo(rs.getInt(1));
				temp.setMoviePoster(rs.getString(2));
				
				tempList.add(temp);
			}

			
			int[] randomNum = new int[4];
			for(int i = 0; i < 4; i++) {
				int tempNum = (int)(Math.random() * tempList.size());
				
				randomNum[i] = tempNum;
				
				for(int j = 0; j < i; j++) {
					if(randomNum[i] == randomNum[j]) {
						i--;
						break;
					}
				}
				
			}
			
			movieRecommend.add(tempList.get(randomNum[0]));
			movieRecommend.add(tempList.get(randomNum[1]));
			movieRecommend.add(tempList.get(randomNum[2]));
			movieRecommend.add(tempList.get(randomNum[3]));
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return movieRecommend;
	}

	public MovieInfoCheck movieInfoCheck(Connection conn, int memNo, int movieNo) throws Exception {
		
		MovieInfoCheck movieInfoCheck = new MovieInfoCheck();
		
		try {
			
			String sql = prop.getProperty("watchedMovie");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, movieNo); 
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int result = rs.getInt(1);
				
				if(result != 0) movieInfoCheck.setWatchedMovie("true");
			}
			
			sql = prop.getProperty("wannaMovie");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, movieNo); 
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int result = rs.getInt(1);
				
				if(result != 0) movieInfoCheck.setWannaMovie("true");
			}
			
			
			sql = prop.getProperty("lifeMovie");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, movieNo); 		
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int result = rs.getInt(1);
				
				if(result != 0) movieInfoCheck.setLifeMovie("true");
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return movieInfoCheck;
	}

	/** 영화정보창 리뷰 삽입 삭제
	 * @param conn
	 * @param movieReview
	 * @param mode
	 * @return
	 */
	public int movieReviewInsert(Connection conn, MovieReview movieReview, String mode) throws Exception{
		
		int result = 0;
		
		try {
			
			if(mode.equals("insert")) {
				String sql = prop.getProperty("movieReviewInsert");
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, movieReview.getMovieNo());
				pstmt.setInt(2, movieReview.getMemNo());
				pstmt.setString(3, movieReview.getReviewContent());
				pstmt.setInt(4, movieReview.getReviewScore());
				
				result = pstmt.executeUpdate();
				
			} else if(mode.equals("update")) {
				
				String sql = prop.getProperty("movieReviewUpdate");
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(3, movieReview.getReviewContent());
				pstmt.setInt(1, movieReview.getMovieNo());
				pstmt.setInt(2, movieReview.getMemNo());
				
				result = pstmt.executeUpdate();
				
			}else {
				String sql = prop.getProperty("movieReviewDelete");
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, movieReview.getMovieNo());
				pstmt.setInt(2, movieReview.getMemNo());
				
				result = pstmt.executeUpdate();
				
			}
			
		} finally {
			
			close(pstmt);
		}
		return result;
	}

	/** 영화 리뷰 더보기 리스트
	 * @param conn
	 * @param movieNo
	 * @return
	 */
	public List<MovieReview> movieReviewList(Connection conn, int movieNo) throws Exception {

		List<MovieReview> movieReviewList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("movieReviewList");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int memNo = rs.getInt(1);
				String reviewContent = rs.getString(2);
				String reviewDate = rs.getString(3);
				String movieTitle = rs.getString(4);
				int reviewScore = rs.getInt(5);
				String memPic = rs.getString(6);
				String memNic = rs.getString(7);
				
				movieReviewList.add(new MovieReview(movieNo, memNo, reviewContent, reviewDate, movieTitle, reviewScore, memPic, memNic));
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return movieReviewList;
	}

	public int movieReviewUD(Connection conn, int movieNo, int reviewermemNo, String mode) throws Exception{
		
		int result = 0;
		
		try {
			if(mode.equals("delete")) {
				String sql = prop.getProperty("movieReviewDelete");
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, movieNo);
				pstmt.setInt(2, reviewermemNo);
				
				result = pstmt.executeUpdate();
			}
			
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
