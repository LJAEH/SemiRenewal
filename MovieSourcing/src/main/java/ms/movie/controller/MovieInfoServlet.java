package ms.movie.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.movie.model.service.MovieInfoService;
import ms.movie.model.vo.MovieInfo;
import ms.movie.model.vo.MoviePeople;
import ms.movie.model.vo.MovieRecommend;
import ms.movie.model.vo.MovieReview;

@WebServlet("/movieInfo")
public class MovieInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			int movieNo = Integer.parseInt(req.getParameter("movieNo"));
			
			MovieInfoService service = new MovieInfoService();
			
			// 영화 정보
			MovieInfo movieInfo = service.movieInfo(movieNo);
			
			// 영화 관련 사람
			MoviePeople moviePeople  = service.moviePeople(movieNo);
			
			// 리뷰
			List<MovieReview> movieReview = service.movieReview(movieNo);
			
			// 추천 영화
			List<String> movieRecommendList = new ArrayList<>();
			for(int i = 0; i < movieInfo.getMovieGenre().size(); i++) {
				movieRecommendList.add(movieInfo.getMovieGenre().get(i));
			}

			List<MovieRecommend> movieRecommend = service.movieRecommend(movieRecommendList);
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("movieInfo", movieInfo);
			map.put("moviePeople", moviePeople);
			map.put("movieReview", movieReview);
			map.put("movieRecommend", movieRecommend);

			req.setAttribute("map", map);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/movie/movieInfo.jsp");
			
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
