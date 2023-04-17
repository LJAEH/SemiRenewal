package ms.list.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ms.list.model.service.mlistService;
import ms.list.model.vo.movie;

@WebServlet("/SearchData")
public class SearchData extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("서블릿 들어오는거 체크");
		
		mlistService service = new mlistService();
		
		String input4 = req.getParameter("input4");
			
		try {
			
			
			List<movie> mlist = service.Searchdata(input4);
			
			System.out.println(mlist);
			
			new Gson().toJson(mlist, resp.getWriter());
			
		
			
		
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

	
}
