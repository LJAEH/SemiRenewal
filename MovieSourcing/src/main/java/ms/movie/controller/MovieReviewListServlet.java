package ms.movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.movie.model.service.MovieInfoService;
import ms.movie.model.vo.MovieReview;

@WebServlet("/movieReviewList")
public class MovieReviewListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int movieNo = Integer.parseInt(req.getParameter("movieNo"));
		
		MovieInfoService service = new MovieInfoService();
		
		List<MovieReview> movieReviewList = service.movieReviewList(movieNo);
		
		req.setAttribute("movieReviewList", movieReviewList);
		
		String path = "WEB-INF/views/movie/movieReview.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
	}
}
