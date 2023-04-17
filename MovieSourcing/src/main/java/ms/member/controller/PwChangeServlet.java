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

/**
 * Servlet implementation class PwChangeServlet
 */
@WebServlet("/member/pw")
public class PwChangeServlet extends HttpServlet {

       
  

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	// post방식 요청 : 비밀번호 변경
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		HttpSession session = req.getSession();
	
	
		String memberPw = 	req.getParameter("currentPw");
		String newPw1 =  req.getParameter("newPw1");
		
	
		
		

		
		// ** 로그인 회원 번호 얻어오기 **
		Member loginMember = (Member)( session.getAttribute("loginMember") ) ;
		
		int memberNo = loginMember.getMemberNo(); // 로그인 회원 번호
	
	
	
		

		
			
			try {
				
				MemberService service = new MemberService();
				Member mem = new Member();
				int result = service.changePw(memberPw, newPw1, memberNo);	
		
			
			
				
				String path = null; // 리다이렉트 주소
				
				if(result > 0) { // 성공
					
					session.setAttribute("message", "비밀번호 외 모두 변경 성공!" );
					
						path = "MyPageEnter";
					
					session.getAttribute("loginMember");
				
				} else { // 실패
					
					session.setAttribute("message", "현재 비밀번호가 일치하지 않습니다" );
					
					
					path ="myPagechangeEnter";
					session.getAttribute("loginMember");
					
				}
				
				resp.sendRedirect(path);
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
			
		}
		
		

	
	}
	
	
	
	
	