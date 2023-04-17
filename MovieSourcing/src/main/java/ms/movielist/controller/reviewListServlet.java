package ms.movielist.controller;

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

import ms.movielist.model.service.ReviewListService;
import ms.movielist.model.vo.ListMemberInfo;
import ms.movielist.model.vo.ReviewListInfo;

@WebServlet("/movielist/reviewList")
public class reviewListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		try {
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			
			ReviewListService rService = new ReviewListService();
			
			ListMemberInfo member = rService.memberNick(memberNo);
			
			List<ReviewListInfo> reviewList = rService.reviewList(memberNo);
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("member", member);
			map.put("reviewList", reviewList);
			
			req.setAttribute("map",map);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/movie/reviewList.jsp");
			
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
