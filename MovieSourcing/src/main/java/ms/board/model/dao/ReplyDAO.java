package ms.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import ms.board.model.vo.Reply;
import static ms.common.JDBCTemplate.*;

public class ReplyDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public ReplyDAO() {
		try {

			prop = new Properties();
			
			String filePath = BoardDAO.class.getResource("/ms/sql/reply-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public int replyIUD(Connection conn, Reply reply, String mode) throws Exception{
		int result = 0;

		try {
			
			String sql = prop.getProperty("insertReply");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getComNo());
			pstmt.setInt(3, reply.getMemNo());

			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
