package ms.movielist.model.dao;

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
import ms.movielist.model.vo.CommunityListInfo;
import ms.movielist.model.vo.ListMemberInfo;
import ms.movielist.model.vo.ReviewListInfo;

public class CommunityDAO {
	

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public CommunityDAO() {
		try {
			prop = new Properties();
			
			String filePath = BoardDAO.class.getResource("/ms/sql/movieList-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListMemberInfo memberNick(Connection conn, int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		ListMemberInfo member = new ListMemberInfo();
		try {
			String sql = prop.getProperty("memberName");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,memberNo);
			
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

	public List<CommunityListInfo> communityList(Connection conn, int memberNo) throws SQLException {
		// TODO Auto-generated method stub
		
		List<CommunityListInfo> communityList = new ArrayList<>();
		
		CommunityListInfo temp = null;
		
		try {
			
			String sql = prop.getProperty("communityList");

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				temp = new CommunityListInfo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
						
				communityList.add(temp);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return communityList;
	}

}
