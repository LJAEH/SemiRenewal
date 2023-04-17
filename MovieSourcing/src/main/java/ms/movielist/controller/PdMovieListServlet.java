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
import ms.movielist.model.vo.MovieListInfo;
import ms.movielist.model.vo.PdInfo;

@WebServlet("/pdMovie")
public class PdMovieListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			int pdNo = Integer.parseInt(req.getParameter("pdNo"));
			
			MovieListService service = new MovieListService();
			
			PdInfo pdInfo = service.pdInfo(pdNo);
			
			List<MovieListInfo> movieListInfo = service.pdMovieListInfo(pdNo);
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("pdInfo", pdInfo);
			map.put("movieListInfo", movieListInfo);
			
			req.setAttribute("map", map);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/movie/pdMovieList.jsp");
			
			dispatcher.forward(req,resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
