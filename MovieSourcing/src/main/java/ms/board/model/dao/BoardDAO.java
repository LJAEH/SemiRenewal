package ms.board.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import ms.board.model.vo.BaordReply;
import ms.board.model.vo.Board;
import ms.board.model.vo.BoardDetail;
import ms.board.model.vo.Pagination;

import static ms.common.JDBCTemplate.*;

public class BoardDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public BoardDAO() {

		try {
			

			prop = new Properties();
			
			String filePath = BoardDAO.class.getResource("/ms/sql/board-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
	/** 게시글 수
	 * @param conn
	 * @return listCount
	 */
	public int getListCount(Connection conn) throws Exception {
		int listCount = 0;
		
		try {
			String sql = prop.getProperty("getListCount");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		
		return listCount;
	}



	public List<Board> selectBoardList(Connection conn, Pagination pagination) throws Exception {
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectBoardList");
			
			int start = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int end = start + pagination.getLimit() - 1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setComNo(rs.getInt("COM_NO"));
				board.setMemPic(rs.getString("MEM_IMG"));
				board.setMemNic(rs.getString("MEM_NICK"));
				board.setComDate(rs.getString("COM_DATE"));
				board.setComTitle(rs.getString("COM_TITLE"));
				board.setComContent(rs.getString("COM_CONTENT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setReplyCount(rs.getInt("REPLY_COUNT"));
				
				boardList.add(board);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}
	
	
	
	/** readConut
	 * @param conn
	 * @param comNo
	 * @return result
	 * @throws Exception
	 */
	public int roadCount(Connection conn, int comNo) throws Exception {
		int result = 0;
		int readCnt = 0;
		
		try {
			String sql = prop.getProperty("SelectReadCount");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				readCnt = rs.getInt("READ_COUNT");
			}
			
			sql = prop.getProperty("UpdatereadCount");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, readCnt + 1);
			pstmt.setInt(2, comNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
		}
	
		return result;
	}



	/** boardDetailSelect
	 * @param conn
	 * @param comNo
	 * @return boardDetail
	 */
	public BoardDetail selectBoardDetail(Connection conn, int comNo) throws Exception{
		BoardDetail boardDetail = null;
		
		try {
			String sql = prop.getProperty("selectBoardDetail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				boardDetail = new BoardDetail();
				
				boardDetail.setComNo(comNo);
				boardDetail.setMemPic(rs.getString("MEM_IMG"));
				boardDetail.setMemNic(rs.getString("MEM_NICK"));
				boardDetail.setComDate(rs.getString("CREATE_DT"));
				boardDetail.setComTitle(rs.getString("COM_TITLE"));
				boardDetail.setComContent(rs.getString("COM_CONTENT"));
				boardDetail.setReadCount(rs.getInt("READ_COUNT"));
				boardDetail.setReplyCount(rs.getInt("REPLY_COUNT"));
						
			}
			
			
			String sql2 = prop.getProperty("boardReply");
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, comNo);
			
			rs = pstmt.executeQuery();
			

			List<BaordReply> boardReplyList = new ArrayList<>();

			while(rs.next()) {
				BaordReply boardReply = new BaordReply();
				
				boardReply.setReplyNo(rs.getInt("COM_COMMENT_NO"));
				boardReply.setReplyContent(rs.getString("COM_COMMENT_CONTENT"));
				boardReply.setMemNic(rs.getString("MEM_NICK"));
				boardReply.setReplyDate(rs.getString("COM_COMMENT_DATE_CHAR"));
				
				boardReplyList.add(boardReply);
			}
			
			boardDetail.setReplyList(boardReplyList);

			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return boardDetail;
	}



	public int updateBoardDetail(Connection conn, BoardDetail updateDetail) throws Exception{
		int result = 0;

		try {
			String sql = prop.getProperty("updateBoardDetail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateDetail.getComTitle());
			pstmt.setString(2, updateDetail.getComContent());
			pstmt.setInt(3, updateDetail.getComNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	public int boardDelete(Connection conn, int comNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("boardDelete");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	public int insertDetail(Connection conn, BoardDetail insertBoard) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertDetail");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, insertBoard.getComTitle());
			//pstmt.setInt(2, insertBoard.getMemNo());
			pstmt.setInt(2, insertBoard.getMemNo());
			pstmt.setString(3, insertBoard.getComContent());
			
			result = pstmt.executeUpdate();
			
		}finally{
			close(pstmt);
		}
		
		return result;
	}



	public int currval(Connection conn) throws Exception {
		
		int currval = 0;
		
		try {
			String sql = prop.getProperty("currval");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				currval = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		 
		return currval;
	}





}
