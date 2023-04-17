package ms.movie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ms.movie.model.service.MovieInfoService;
import ms.movie.model.vo.MovieInfoCheck;

@WebServlet("/movieInfoLoginCheck")
public class MovieInfoCheckServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int memNo =  Integer.parseInt(req.getParameter("memNo"));
		int movieNo = Integer.parseInt(req.getParameter("movieNo"));
		
		MovieInfoService service = new MovieInfoService();
		
		MovieInfoCheck movieInfoCheck = service.movieInfoCheck(memNo, movieNo);
		
		new Gson().toJson(movieInfoCheck, resp.getWriter());
	}
}
