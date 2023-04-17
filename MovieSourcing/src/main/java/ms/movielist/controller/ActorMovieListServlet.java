package ms.movielist.controller;

import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.movielist.model.service.*;
import ms.movielist.model.vo.ActorInfo;
import ms.movielist.model.vo.MovieListInfo;

@WebServlet("/actorMovie")
public class ActorMovieListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			// 타입 배우 일때
			
			int actorNo = Integer.parseInt(req.getParameter("actorNo"));
			
			MovieListService service = new MovieListService();
			
			ActorInfo actorInfo = service.actorInfo(actorNo);
			
			List<MovieListInfo> movieListInfo = service.movieListInfo(actorNo);
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("actorInfo", actorInfo);
			map.put("movieListInfo", movieListInfo);
			
			req.setAttribute("map", map);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/movie/actorMovie.jsp");
			
			dispatcher.forward(req,resp);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
