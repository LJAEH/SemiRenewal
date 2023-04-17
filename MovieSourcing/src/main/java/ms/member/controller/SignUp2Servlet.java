package ms.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import ms.member.model.service.MemberService;
import ms.member.model.vo.Member;

@WebServlet("/member/signUp2")
public class SignUp2Servlet extends HttpServlet{

	// GET 방식 요청 시 JSP로 바로 응답할 수 있도록 요청 위임
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String path = "/WEB-INF/views/member/signUp2.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	


	// POST 방식 요청 시 회원가입 서비스 수행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		  int maxSize = 1024*1024*5;
			
			String root = getServletContext().getRealPath("/");
			
			
			String folderPath = "/resources/images/memberProfile/";
			
			
			String filePath = root + folderPath;
		
			String encoding = "UTF-8";
			
			
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new ms.common.MyRenamePolicy());
			String memberImg = folderPath + mpReq.getFilesystemName("memberImg");
		// 파라미터를 모두 변수에 저장
		String memberId = mpReq.getParameter("id");
		String memberPw = mpReq.getParameter("pw1");
		String memberNick = mpReq.getParameter("membeNickname");
		String memberGender = mpReq.getParameter("gender");
		
		
		String year =  mpReq.getParameter("yy");
		String month =  mpReq.getParameter("mm");
		
		String memberBirth = year + "-" + month;
		 
		
		
		HttpSession session = req.getSession();
		
	
		session.setAttribute("memberId",memberId);
		session.setAttribute("memberPw",memberPw);
		session.setAttribute("memberNick",memberNick);
		session.setAttribute("memberGender",memberGender);
		session.setAttribute("memberBirth",memberBirth);
		session.setAttribute("memberImg",memberImg);
		String path = "/WEB-INF/views/member/signUp3.jsp";
		req.getRequestDispatcher(path).forward(req, resp);

	}
}
