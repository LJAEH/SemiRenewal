package ms.list.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.list.model.service.mlistService;
import ms.list.model.vo.movie;

@WebServlet("/msList")
public class MlistServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		mlistService service = new mlistService();
		
		try {
			
			List<movie> mlist = service.selectMlist();
			
			req.setAttribute("mlist", mlist);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mlist.jsp");
			
			dispatcher.forward(req, resp);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	

	
	
}
