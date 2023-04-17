package ms.board.model.service;

import ms.board.model.dao.ReplyDAO;
import ms.board.model.vo.Reply;
import static ms.common.JDBCTemplate.*;

import java.sql.Connection;

public class ReplyService {

	public String replyIUD(Reply reply, String mode) {
		
		String resultStr = "";
		
		int result = 0;
		
		Connection conn = getConnection();
		
		try {
			ReplyDAO replyDao = new ReplyDAO();
			
			result = replyDao.replyIUD(conn, reply, mode);
			
			if(result != 0) {
				resultStr = "댓글 등록 성공";
				commit(conn);
			} else {
				resultStr = "댓글 등록 실패";
				rollback(conn);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return resultStr;
	}

}
