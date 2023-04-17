package ms.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ms.member.model.dao.MyPageDAO;
import ms.member.model.vo.LifeMovieVO;
import ms.member.model.vo.MemberCount;

import static ms.common.JDBCTemplate.*;


public class MyPageService {
	
	public MyPageDAO dao = new MyPageDAO();

	public List<MemberCount> memberCount(int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		List<MemberCount> memberCount = null;
		
		memberCount = dao.memberCount(conn, memberNo);
		
		close(conn);
		
		return memberCount;
	}

	public List<LifeMovieVO> lifeMovie(int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		List<LifeMovieVO> lifeMovieList = null;
		
		lifeMovieList = dao.lifeMovie(conn, memberNo);
		
		close(conn);
		
		return lifeMovieList;
	}

}
