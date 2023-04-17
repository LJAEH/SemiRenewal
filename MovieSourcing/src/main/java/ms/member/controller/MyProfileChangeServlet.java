package ms.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import ms.member.model.service.MemberService;
import ms.member.model.vo.Member;
import oracle.net.aso.c;

/**
 * 패스워드 변경 서블렛
 *
 */
@WebServlet("/member/myPagechangeEnter")
public class MyProfileChangeServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/myProfileChangePg.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	
	
	
	
	// post방식 요청 : 프로필 수정 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  int maxSize = 1024*1024*5;
			
			String root = getServletContext().getRealPath("/");
			
			
			String folderPath = "/resources/images/memberProfile/";
			
			
			String filePath = root + folderPath;
		
			String encoding = "UTF-8";
			
			
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new ms.common.MyRenamePolicy());
			String img1 = mpReq.getFilesystemName("profileImage");
			String memberImg = folderPath + mpReq.getFilesystemName("profileImage");
			
			System.out.println("id : " + memberImg);
		HttpSession session = req.getSession();
	
			
		String memberNick = mpReq.getParameter("nicknameArea");
		String memberIntro = mpReq.getParameter("introduceArea");
	
		// ** 로그인 회원 번호 얻어오기 **
		Member loginMember = (Member)( session.getAttribute("loginMember") ) ;
		
		int memberNo = loginMember.getMemberNo(); // 로그인 회원 번호
		String memberEmail  = loginMember.getMemberEmail();
		String memberimg2  = loginMember.getMemberImg();
		MemberService service = new MemberService();
		Member mem = new Member();
		req.setAttribute("loginMember", mem); 
		
		
		if(img1== null || img1.length()==0 || img1.trim().isEmpty() )  {
			
		
			
			
			
			try {
			
				mem.setMemberNo(memberNo);
				mem.setMemberNick(memberNick);
				mem.setMemberIntro(memberIntro);
				mem.setMemberEmail(memberEmail);
				mem.setMemberImg(memberimg2);
				
				session.setAttribute("loginMember", mem);

				int result = service.changeElseNoImg(mem);
				System.out.println();
				
				String path = null; 
				
				if(result > 0) { 
					
					alertAndGo(resp, "변경 성공", "MyPageEnter");
					
					session.getAttribute("loginMember");
				
					
				} else {
					
					
					alertAndGo(resp, "변경 실패", "myPagechangeEnter");
				
					
				}
		
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
	
	
	
			
			
			
			
			
		}else {
			
			
			
			
			
			
			
			

			try {
			
				mem.setMemberNo(memberNo);
				mem.setMemberImg(memberImg);
				mem.setMemberNick(memberNick);
				mem.setMemberIntro(memberIntro);
				mem.setMemberEmail(memberEmail);
				
				session.setAttribute("loginMember", mem);

				int result = service.changeElse(mem);
				System.out.println();
				
				String path = null; 
				
				if(result > 0) { 
					
					alertAndGo(resp, "변경 성공!.", "MyPageEnter");
					
					session.getAttribute("loginMember");
				
					
				} else {
					
					
					alertAndGo(resp, "변경 실패", "myPagechangeEnter");
				
					
				}
		
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
	
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
