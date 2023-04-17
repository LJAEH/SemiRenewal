package ms.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.board.model.service.BoardService;
import ms.board.model.service.ReplyService;
import ms.board.model.vo.BoardDetail;
import ms.board.model.vo.Reply;

@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int comNo = Integer.parseInt(req.getParameter("comNo"));
		String replyContent = req.getParameter("content");
		String memNic = req.getParameter("loginMemNic");
		int memNo = Integer.parseInt(req.getParameter("loginMemNo"));
		
		String mode = req.getParameter("mode");
		
		Reply reply = new Reply();
		
		System.out.println("replyContent : " + replyContent);
		System.out.println("comNo : " + comNo);
		
		
		reply.setComNo(comNo);
		reply.setMemNic(memNic);
		reply.setMemNo(memNo);
		reply.setReplyContent(replyContent);
		
		ReplyService replyService = new ReplyService();
		
		String msg = replyService.replyIUD(reply, mode);
		
		req.setAttribute("msg", msg);
		
		BoardService service = new BoardService();
		
		BoardDetail boardDetail;
		try {
			boardDetail = service.selectBoardDetail(comNo);
			
			req.setAttribute("boardDetail", boardDetail);
			
			String path = "/WEB-INF/views/board/boardDetail.jsp";

			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
