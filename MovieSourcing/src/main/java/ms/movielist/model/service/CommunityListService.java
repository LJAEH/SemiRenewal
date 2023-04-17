package ms.movielist.model.service;

import static ms.common.JDBCTemplate.close;
import static ms.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ms.movielist.model.dao.CommunityDAO;
import ms.movielist.model.vo.CommunityListInfo;
import ms.movielist.model.vo.ListMemberInfo;

public class CommunityListService {
	
	public CommunityDAO dao = new CommunityDAO();

	public ListMemberInfo memberNick(int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		ListMemberInfo member = null;
		
		member = dao.memberNick(conn, memberNo);
		
		close(conn);
		
		return member;
	}

	public List<CommunityListInfo> communityList(int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = getConnection();
		
		List<CommunityListInfo> communityList = null;
		
		communityList = dao.communityList(conn, memberNo);
		
		close(conn);
		
		return communityList;
	}

}
