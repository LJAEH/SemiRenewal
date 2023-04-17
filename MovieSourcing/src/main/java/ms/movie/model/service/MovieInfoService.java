package ms.movie.model.service;

import static ms.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import ms.movie.model.dao.MovieInfoDAO;
import ms.movie.model.vo.MovieInfo;
import ms.movie.model.vo.MovieInfoCheck;
import ms.movie.model.vo.MoviePeople;
import ms.movie.model.vo.MovieRecommend;
import ms.movie.model.vo.MovieReview;

/**
 * @author kjo63
 *
 */
public class MovieInfoService {
	
	private MovieInfoDAO dao = new MovieInfoDAO();

	/** 영화정보
	 * @param movieNo
	 * @return
	 */
	public MovieInfo movieInfo(int movieNo) {
		
		Connection conn = getConnection();
		
		MovieInfoDAO dao = new MovieInfoDAO();
		
		MovieInfo movieInfo = null;
		
		try {
			
			movieInfo = dao.movieInfo(conn, movieNo);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(conn);
		}
		
		return movieInfo;
	}

	
	
	/** 감독, 배우
	 * @param movieNo
	 * @return
	 */
	public MoviePeople moviePeople(int movieNo) {
		
		Connection conn = getConnection();
		
		MoviePeople moviePeople = null;
		
		try {
			
			moviePeople = dao.moviePeople(conn, movieNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return moviePeople;
	}

	
	
	/** 리뷰
	 * @param movieNo
	 * @return
	 */
	public List<MovieReview> movieReview(int movieNo) {
		
		Connection conn = getConnection();
		
		List<MovieReview> movieReview = null;
		
		try {
			
			movieReview = dao.movieReview(conn, movieNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return movieReview;
	}



	public List<MovieRecommend> movieRecommend(List<String> movieRecommendList) {
		
		Connection conn = getConnection();
		
		List<MovieRecommend> movieRecommend = null;
		
		try {
			
			movieRecommend = dao.movieRecommend(conn, movieRecommendList);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return movieRecommend;
	}



	/** 영화 정보창 회원 셋팅
	 * @param memNo
	 * @param movieNo
	 * @return
	 */
	public MovieInfoCheck movieInfoCheck(int memNo, int movieNo) {
		
		MovieInfoCheck movieInfoCheck = null;
		
		Connection conn = getConnection();
		
		try {
			
			movieInfoCheck = dao.movieInfoCheck(conn, memNo, movieNo);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return movieInfoCheck;
	}



	/** 영화정보창 리뷰 삽입 삭제
	 * @param movieReview
	 * @param mode
	 * @return
	 */
	public int movieReviewInsert(MovieReview movieReview, String mode) {

		int result = 0;
		
		Connection conn = getConnection();
		
		try {
			
			result = dao.movieReviewInsert(conn, movieReview, mode);
			
			if(result != 0) commit(conn);
			else rollback(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}



	/** 영화 리뷰 더보기 리스트
	 * @param movieNo
	 * @return
	 */
	public List<MovieReview> movieReviewList(int movieNo) {
		
		List<MovieReview> movieReviewList = null;
		
		Connection conn = getConnection();
		
		try {
			
			movieReviewList = dao.movieReviewList(conn, movieNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		
		return movieReviewList;
	}



	public int movieReviewUD(int movieNo, int reviewermemNo, String mode) {
		
		int result = 0;
		
		Connection conn = getConnection();
		
		try {
			
			result = dao.movieReviewUD(conn, movieNo, reviewermemNo, mode);
			
			if(result != 0) commit(conn);
			else rollback(conn);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		
		
		return result;
	}



}
