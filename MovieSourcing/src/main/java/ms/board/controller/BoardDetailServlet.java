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

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			
			int comNo = Integer.parseInt(req.getParameter("comNo"));
			
			BoardService service = new BoardService();
			
			BoardDetail boardDetail = service.selectBoardDetail(comNo);
			
			req.setAttribute("boardDetail", boardDetail);
			
			String path = "/WEB-INF/views/board/boardDetail.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
