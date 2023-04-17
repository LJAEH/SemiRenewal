package ms.board.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ms.board.model.dao.BoardDAO;
import ms.board.model.vo.Board;
import ms.board.model.vo.BoardDetail;
import ms.board.model.vo.Pagination;

import static ms.common.JDBCTemplate.*;

import static ms.common.JDBCTemplate.*;

public class BoardService {
	
	private BoardDAO dao = new BoardDAO();
	
	
	/** boardList 조회
	 * @param cp
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectBoadList(int cp) throws Exception {
		
		Connection conn = getConnection(); 
		
		int listCount = dao.getListCount(conn);
		
		Pagination pagination = new Pagination(cp, listCount);
		
		List<Board> boardList = dao.selectBoardList(conn, pagination); 
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		close(conn);
		
		return map;
	}
	
	
	/** boardDetail
	 * @param boardNo
	 * @param comNo
	 * @return detail
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(int comNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.roadCount(conn, comNo);
		
		if(result != 0) commit(conn);
		else rollback(conn);
		
		BoardDetail boardDetail = dao.selectBoardDetail(conn, comNo);
	
		close(conn);
		
		return boardDetail;
	}
	

	public Map<String, Object> selectBoadList(int cp, String query) {
		return null;
	}


	public BoardDetail updateDetail(BoardDetail updateDetail) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updateBoardDetail(conn, updateDetail);
		
		if(result == 0) conn.rollback();
		else conn.commit();
		
		BoardDetail boardDetail = null;

		if(result != 0) {
			
			boardDetail = dao.selectBoardDetail(conn, updateDetail.getComNo());
			
		}
		
		close(conn);
		
		return boardDetail;
	}


	public int boardDelete(int comNo) {
		int result = 0;
		
		Connection conn = getConnection();

		try {
			
			BoardDAO dao = new BoardDAO();
			
			result = dao.boardDelete(conn, comNo);
			
			if(result !=0 ) commit(conn);
			else rollback(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}


	public BoardDetail insertDetail(BoardDetail insertBoard) {
		BoardDetail boardDetail = null;
		
		Connection conn = getConnection();
		
		try {
			
			BoardDAO dao = new BoardDAO();
			
			int result = dao.insertDetail(conn, insertBoard);
			
			if(result != 0) {
				commit(conn);
				
				int currval = dao.currval(conn);
				
				boardDetail = dao.selectBoardDetail(conn, currval);
				
			} else {
				rollback(conn);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		return boardDetail;
	}

}
