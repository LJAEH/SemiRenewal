package ms.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.board.model.service.BoardService;
import ms.board.model.vo.BoardDetail;



@WebServlet("/write")
public class BoardWriteController extends HttpServlet {
	
	// 나중에 필터 걸어서 로그인이 안되어 있으면 메인으로 이동하게 설정해야 함(로그인필터)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mode = req.getParameter("mode");
		
		if(mode.equals("update")) {
			try {
				int comNo = Integer.parseInt(req.getParameter("comNo"));
				
				BoardService service = new BoardService();
				
				BoardDetail boardDetail;
				
				boardDetail = service.selectBoardDetail(comNo);

				req.setAttribute("boardDetail", boardDetail);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		req.setAttribute("mode", mode);
			
		String path = "/WEB-INF/views/board/boardWrite.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
	
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mode = req.getParameter("mode");
		int memNo = Integer.parseInt(req.getParameter("memNo"));
		
		try {
			
			if(mode.equals("update")) {
				
				int comNo = Integer.parseInt(req.getParameter("comNo"));
				String comTitle = req.getParameter("comTitle");
				String comContent = req.getParameter("comContent");
				
				BoardService service = new BoardService();
				
				BoardDetail updateDetail = new BoardDetail();
				
				updateDetail.setComNo(comNo);
				updateDetail.setComTitle(comTitle);
				updateDetail.setComContent(comContent);
				updateDetail.setMemNo(memNo);
				
				BoardDetail boardDetail = service.updateDetail(updateDetail);
				
				req.setAttribute("boardDetail", boardDetail);
				
			} else {
				
				String comTitle = req.getParameter("comTitle");
				String comContent = req.getParameter("comContent");
				
				BoardService service = new BoardService();
				
				BoardDetail insertBoard = new BoardDetail();
				insertBoard.setComTitle(comTitle);
				insertBoard.setComContent(comContent);
				insertBoard.setMemNo(memNo);
				// 유저 닉 정보 불러오기 필요
				
				BoardDetail boardDetail = service.insertDetail(insertBoard);
				
				req.setAttribute("boardDetail", boardDetail);
			}
			
			String path = "/WEB-INF/views/board/boardDetail.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
