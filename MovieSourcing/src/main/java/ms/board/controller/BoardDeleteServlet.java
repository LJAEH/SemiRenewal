	package ms.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.board.model.service.BoardService;

@WebServlet("/delete")
public class BoardDeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int comNo = Integer.parseInt(req.getParameter("comNo"));
		
		BoardService service = new BoardService();
		
		int result = service.boardDelete(comNo);
		
		String boardDeleteMsg = "";
		
		if(result != 0) {
			boardDeleteMsg = "게시글 삭제 성공";
		} else {
			boardDeleteMsg = "게시글 삭제 실패";
		}
		
		req.setAttribute("boardDeleteMsg", boardDeleteMsg);
		
		try {
					int cp = 1;
					
					if(req.getParameter("cp") != null) {
						cp = Integer.parseInt(req.getParameter("cp"));
					}
					
					Map<String, Object> map = null;
					
					if(req.getParameter("query") == null) { // key는 검색창에서 제목, 내용, 제목+내용, 작성자의 카테고리에 관련된 값
						map = service.selectBoadList(cp);
				
		
					} else { // 검색 값이 있으면 
						String query = req.getParameter("query"); // 검색 내용, 검색 값
						
						map = service.selectBoadList(cp, query);
					}
					
					req.setAttribute("map", map);
					
					// 검색 없는 목록 객체 반환까지 완,, 검색 있는 목록 객체 반환 작성 필요, jsp 작성 필요
					
					RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/boardList.jsp");
					
					dispatcher.forward(req, resp);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

}
