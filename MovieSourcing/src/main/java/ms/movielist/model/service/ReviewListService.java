package ms.movielist.model.service;

import ms.movielist.model.dao.ReviewListDAO;
import ms.movielist.model.vo.ListMemberInfo;
import ms.movielist.model.vo.ReviewListInfo;

import static ms.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReviewListService {
	
	public ReviewListDAO rDao = new ReviewListDAO();

	public ListMemberInfo memberNick(int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		ListMemberInfo member = null;
		
		member = rDao.memberNick(conn, memberNo);
		
		close(conn);
		
		return member;
	}

	public List<ReviewListInfo> reviewList(int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		List<ReviewListInfo> reviewList = null;
		
		reviewList = rDao.reviewList(conn, memberNo);

		close(conn);
		
		return reviewList;
	}

}
