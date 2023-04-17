package ms.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.member.model.service.MemberService;

@WebServlet("/watchedMovie")
public class WatchedMovie extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mode = req.getParameter("mode");
		
		int memNo = Integer.parseInt(req.getParameter("memNo"));
		int movieNo = Integer.parseInt(req.getParameter("movieNo"));
		
		MemberService service = new MemberService();
		
		int result = 0;
		
		if(mode.equals("insert")) {
			
			result = service.watchedMovieInsert(memNo, movieNo);
			
		} else {
			
			result = service.watchedMovieDelete(memNo, movieNo);
		}
	}
}
