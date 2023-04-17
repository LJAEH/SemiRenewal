package ms.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 로그아웃 서블렛
 *
 */
@WebServlet("/member/logout")
public class LogoutServlet extends HttpServlet{
	
	// a태그를 이용한 요청은 무조건 GET 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// *** 로그아웃 ***
		// Session Scope에 세팅된 회원 정보를 없앰
		
		
		// Session 얻어오기
		HttpSession session = req.getSession();
		
		
		// 1) Session에서 회원 정보만 없앰
		// session.removeAttribute("loginMember");
		
		
		// 2) Session 전체를 없애고 새로운 Session 만들기 (더 많이 사용되는 방법)
		session.invalidate(); // 세션 무효화
							  // 현재 세션을 없앰 -> 자동으로 새로운 세션이 생성됨
		
		
		// 메인 페이지로 돌아가기
		// 1) forward : 로그아웃 응답 화면을 만든다 (부적절)
		// 2) redirect : 메인페이지 재요청 (이거다!)
			//			메인페이지 == 최상위 주소(/community)로 요청했을 때 화면
		alertAndGo(resp, "로그아웃 하셨습니다", req.getContextPath());
		//resp.sendRedirect( req.getContextPath() );
		
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
