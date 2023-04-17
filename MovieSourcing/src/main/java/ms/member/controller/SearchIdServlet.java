package ms.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ms.member.model.service.MemberService;
import ms.member.model.vo.Member;

/**
 * Servlet implementation class SerachIdServlet
 */
@WebServlet("/member/searchId")
public class SearchIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
			request.getRequestDispatcher("/WEB-INF/views/member/searchId.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String inputEmail = request.getParameter("email"); // 입력 받은 이메일
		
		MemberService service = new MemberService();
		 
		
		HttpSession session = request.getSession();
		
		
		
	try {
		
			 
		String memberId = service.searchId(inputEmail);
		System.out.println(memberId);
		PrintWriter out = response.getWriter();
		if(memberId==null) {
			int emailResult = 0;
			 out.print("Fail");
			 out.flush();
			    out.close();
			System.out.println("emailResult" + emailResult);
			session.setAttribute("emailResult",emailResult);
			response.sendRedirect("sendIdEmail");
		}else {
			int emailResult = 1;
			out.print("Success");
			 out.flush();
			    out.close();
			session.setAttribute("inputEmail",inputEmail);
			session.setAttribute("emailResult",emailResult);
			session.setAttribute("memberId",memberId);
			response.sendRedirect("sendIdEmail");
		}
		

			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	

	public static void alertAndGo(HttpServletResponse response, String message, String url) {
	    try {
	        response.setContentType("text/html; charset=utf-8");
	        PrintWriter w = response.getWriter();
	        w.write("<script>alert('"+message+"');location.href='"+url+"';</script>");
	        w.flush();
	        w.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	
	
}