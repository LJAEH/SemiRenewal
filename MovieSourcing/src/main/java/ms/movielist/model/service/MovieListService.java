package ms.movielist.model.service;

import static ms.common.JDBCTemplate.*;

import ms.member.model.vo.Member;
import ms.movielist.model.dao.*;
import ms.movielist.model.vo.ActorInfo;
import ms.movielist.model.vo.ListMemberInfo;
import ms.movielist.model.vo.MovieListInfo;
import ms.movielist.model.vo.PdInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @author jaehuyk
 *
 */
public class MovieListService {
	
	
	public MovieListDAO dao = new MovieListDAO();
	

	/** 해당 배우의 영화 리스트
	 * @param actorNo
	 * @return
	 * @throws SQLException 
	 */
	public List<MovieListInfo> movieListInfo(int actorNo) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		List<MovieListInfo> movieListInfo = null;
		
	
		movieListInfo = dao.movieListInfo(conn, actorNo);
			
		
		close(conn);
		
		
		return movieListInfo;
	}


	/** 해당 감독의 영화 리스트
	 * @param pdNo
	 * @return
	 * @throws SQLException
	 */
	public List<MovieListInfo> pdMovieListInfo(int pdNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		List<MovieListInfo> movieListInfo = null;
		
	
		movieListInfo = dao.pdMovieListInfo(conn, pdNo);
			
		
		close(conn);
		
		
		return movieListInfo;
	}


	/** 배우 정보
	 * @param actorNo
	 * @return
	 * @throws SQLException 
	 */
	public ActorInfo actorInfo(int actorNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		ActorInfo actorInfo = null;
		
		actorInfo = dao.actorInfo(conn, actorNo);
		
		close(conn);
		
		return actorInfo;
	}


	/** 감독 정보
	 * @param pdNo
	 * @return
	 * @throws SQLException 
	 */
	public PdInfo pdInfo(int pdNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		PdInfo pdInfo = null;
		
		pdInfo = dao.pdInfo(conn, pdNo);
		
		close(conn);
		
		return pdInfo;
	}


	public List<MovieListInfo> watchedList(int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		List<MovieListInfo> watchedList = null;
		
		watchedList = dao.watchedList(conn, memberNo);
		
		return watchedList;
	}


	public ListMemberInfo memberName(int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		ListMemberInfo member = null;
		
		member = dao.memberName(conn, memberNo);
		
		return member;
	}


	public List<MovieListInfo> wishList(int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		List<MovieListInfo> wishList = null;
		
		wishList = dao.wishList(conn, memberNo);
		
		return wishList;
	}


	public int deleteWatchedList(int movieNo, int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		

		int result = dao.deleteWatchedList(conn, movieNo, memberNo);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
	}


	public int deleteWishList(int movieNo, int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		

		int result = dao.deleteWishList(conn, movieNo, memberNo);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
	}


	public List<MovieListInfo> hateList(int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		List<MovieListInfo> hateList = null;
		
		hateList = dao.hateList(conn, memberNo);
		
		return hateList;
	}

}
