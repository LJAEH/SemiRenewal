package ms.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.member.model.service.MemberService;


@WebServlet("/member/cNumber")
public class CheckNumberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String cNumber = req.getParameter("cNumber");
			String memberEmail = req.getParameter("memberEmail");
			System.out.println(cNumber);
			System.out.println(memberEmail);
			// 1,2,3
			int result = new MemberService().checkNumber(memberEmail, cNumber);
			
			resp.getWriter().print(result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
