package ms.movie.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ms.movie.model.service.MovieInfoService;
import ms.movie.model.vo.MovieReview;

@WebServlet("/movieReview")
public class MovieReviewServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MovieInfoService service = new MovieInfoService();
		
		int movieNo = Integer.parseInt(req.getParameter("movieNo"));
		int ReviewermemNo = Integer.parseInt(req.getParameter("reviewerMemNo"));
		String mode = req.getParameter("mode");
		
		int result = service.movieReviewUD(movieNo, ReviewermemNo, mode);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MovieInfoService service = new MovieInfoService();
		
		int movieNo = Integer.parseInt(req.getParameter("movieNo"));
		int memNo = Integer.parseInt(req.getParameter("memNo"));
		String reviewContent = req.getParameter("reviewContent");
		int reviewScore = Integer.parseInt(req.getParameter("reviewScore"));
		
		String mode = req.getParameter("mode");

		
		MovieReview movieReview = new MovieReview();
		
		movieReview.setMovieNo(movieNo);
		movieReview.setMemNo(memNo);
		movieReview.setReviewContent(reviewContent);
		movieReview.setReviewScore(reviewScore);
		
		int result = service.movieReviewInsert(movieReview, mode);
		
		if(result != 0) {

			String returnStr = "true";
			
			new Gson().toJson(returnStr, resp.getWriter());
		
		} else {
			
			String returnStr = "false";
			
			new Gson().toJson(returnStr, resp.getWriter());
		}
		
		
		
		
		

		
		
	}
}
