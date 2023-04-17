package ms.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ms.member.model.service.MemberService;
import ms.member.model.vo.Member;

@WebServlet("/member/kakaoLogin")
public class KakaoLoginServlet extends HttpServlet{
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		
//		
//		
//		// TODO Auto-generated method stub
//		super.doGet(req, resp);
//	
//		String memberEmail = req.getParameter("email");
//	
//		try {
//			
//			MemberService service = new MemberService();
//			
//			
//			Member loginMember = service.kakaoLogin(memberEmail);
//			
//			HttpSession session = req.getSession();
//			
//			if(loginMember != null) {
//				
//				session.setAttribute("loginMember",loginMember);
//				
//				session.setMaxInactiveInterval(3600);
//				
//			} else { // 실패
//				
//				session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
//				
//				req.getRequestDispatcher("/WEB-INF/views/member/signUp1.jsp").forward(req, resp);
//				
//				resp.sendRedirect( req.getContextPath() );
//		
//			}
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//	}
}
