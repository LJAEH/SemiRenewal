package ms.member.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import ms.member.model.service.MyPageService;
import ms.member.model.vo.LifeMovieVO;
import ms.member.model.vo.Member;
import ms.member.model.vo.MemberCount;

/**

 * 마이페이지 들어가는 서블렛

 */

@WebServlet("/member/MyPageEnter")
public class MyPageEnter extends HttpServlet {
	@Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);

		}
	

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session = request.getSession();

		 try {
			 String memberNoStr = request.getParameter("memberNo");
			 if (memberNoStr != null) {
			     int memberNo = Integer.parseInt(memberNoStr);
			     // rest of the code
			 } else {
			     // handle the case where memberNo is not present in the request
			 }

			 Member loginMember = (Member)( session.getAttribute("loginMember") ) ;
			 int memberNo = loginMember.getMemberNo(); // 로그인 회원 번호
			//int memberNo = Integer.parseInt(request.getParameter("memberNo"));

			MyPageService service = new MyPageService();

			// 관심없어요 리뷰 커뮤니티 찜 본영화 순			
			List<MemberCount> memberCount = service.memberCount(memberNo);
			List<LifeMovieVO> lifeMovieList = service.lifeMovie(memberNo);
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("memberNo", memberNo);
			map.put("memberCount", memberCount);
			map.put("lifeMovieList", lifeMovieList);
			
			System.out.println(memberCount);
			System.out.println(lifeMovieList);
			
			String memberEmail  = loginMember.getMemberEmail();
			String memberimg2  = loginMember.getMemberImg();
			String memberIntro  = loginMember.getMemberIntro();
			String memberNick  = loginMember.getMemberNick();

			request.setAttribute("map",map);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp");
			dispatcher.forward(request, response);

		 } catch (Exception e) {
				e.printStackTrace();
		 }

	 }

}