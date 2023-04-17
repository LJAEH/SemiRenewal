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

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet{
	
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 기본 페이지 값
			int cp = 1;
			
			// 페이지 클릭하여 페이지 값이 있을 때
			if(req.getParameter("cp") != null) {
				cp = Integer.parseInt(req.getParameter("cp"));
			}
			
			// 서비스 호출
			BoardService service = new BoardService();
			
			// boardList.jsp에 보낼 Map 객체 생성
			// 키는 String 값은 객체형태(여기에 게시번호, 게시글, 작성자 등등)
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
