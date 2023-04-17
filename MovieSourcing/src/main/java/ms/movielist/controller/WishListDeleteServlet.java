package ms.movielist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.movielist.model.service.MovieListService;

@WebServlet("/movielist/deleteWishList")
public class WishListDeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try {
			
			int movieNo = Integer.parseInt(req.getParameter("movieNo"));
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			
			MovieListService service = new MovieListService();
			
			int result = 0;
			
			result = service.deleteWishList(movieNo, memberNo);
			
			String message = null;
			String path = null;
			
			if(result > 0) { 
				message = "삭제되었습니다.";
				path = req.getHeader("referer"); 
			}else { 
				message = "오류입니다.";
				path = req.getHeader("referer"); 
			}
			
			req.setAttribute("message", message);
			
			resp.sendRedirect(path);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
