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

import ms.movielist.model.service.MovieListService;
import ms.movielist.model.vo.ListMemberInfo;
import ms.movielist.model.vo.MovieListInfo;

@WebServlet("/movielist/hateList")
public class HateListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try {
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			
			MovieListService service = new MovieListService();
			
			ListMemberInfo member = service.memberName(memberNo);
			
			List<MovieListInfo> hateList = service.hateList(memberNo);
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("member", member);
			map.put("hateList", hateList);
			
			req.setAttribute("map", map);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/movie/hateList.jsp");
			
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
