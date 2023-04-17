package ms.simulation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ms.movie.model.vo.MovieInfo;
import ms.simulation.service.SimulationService;


@WebServlet("/simulation/SimulGenreNameServlet")
public class SimulGenreNameServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		   int index = Integer.parseInt(request.getParameter("index"));

		    
		    SimulationService service = new SimulationService();
		    
			List<String> genres = null;
		
			List<Integer> genreNumInt = new ArrayList<>();
				
			try {
				
			    genres = service.getAllGenres();
			
			    
			    
			    for (String num : genres) {
			        int intNum = Integer.parseInt(num);
			        genreNumInt.add(intNum);
			
			    }

			   int selectedGenre = genreNumInt.get(index);			   
			   
			   String genreName = service.getGenreName(selectedGenre);
			  
		
				request.setAttribute("genreName", genreName);
				response.setContentType("application/x-json; charset=utf-8");
				String gson = new Gson().toJson(genreName);
				response.getWriter().print(gson);
				System.out.println(gson);

		   
			   
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
	
	}

	
	
	

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	
	
	}

}
