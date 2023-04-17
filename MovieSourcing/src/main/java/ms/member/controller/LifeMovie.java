package ms.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.member.model.service.MemberService;

@WebServlet("/lifeMovie")
public class LifeMovie extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int memNo = Integer.parseInt(req.getParameter("memNo"));
		int movieNo = Integer.parseInt(req.getParameter("movieNo"));
		String mode = req.getParameter("mode");
		
		MemberService service = new MemberService();
		
		System.out.println("들어오냐?");
		System.out.println("memNo?" + memNo);
		System.out.println("movieNo?" + movieNo);
		System.out.println("mode?" + mode);
		
		int result = service.lifeMovie(memNo, movieNo, mode);
		
	}
}
