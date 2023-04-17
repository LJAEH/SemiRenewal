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

@WebServlet("/member/signUp3")
public class SignUp3Servlet extends HttpServlet{

	
	
	// POST 방식 요청 시 회원가입 서비스 수행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String memberEmail = req.getParameter("memberEmail");
		String memberId = 	(String) session.getAttribute("memberId");
		String memberPw = (String) session.getAttribute("memberPw");
		String memberNick = (String) session.getAttribute("memberNick");
		String memberGender = (String) session.getAttribute("memberGender");
		String memberBirth = (String) session.getAttribute("memberBirth");
		String memberImg = (String) session.getAttribute("memberImg");
		
		
		try {
		
		// 파라미터를 하나의 Member 객체에 저장
		Member mem = new Member();
	
		mem.setMemberEmail(memberEmail);
		mem.setMemberId(memberId);
		mem.setMemberPw(memberPw);
		mem.setMemberNick(memberNick);
		mem.setMemberBirth(memberBirth);
		mem.setMemberGender(memberGender);
		mem.setMemberImg(memberImg);

		
		
	
			
			MemberService service = new MemberService();
			
			// 회원가입 서비스 호출 후 결과 반환 받기
			int result = service.signUp(mem);
			
			// 서비스 결과에 따라서 message를 다르게하여 메인 페이지 재요청(redirect)
			
		
			
			if(result > 0) { // 성공
				
				alertAndGo(resp, "회원 가입 성공!!", req.getContextPath());
			
			
				
			}else { // 실패
				alertAndGo(resp, "회원 가입 실패!", req.getContextPath());
				
			}
			
			//req.getRequestDispatcher("req.getContextPath()").forward(req, resp);
			
			
		}catch (Exception e) {
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
