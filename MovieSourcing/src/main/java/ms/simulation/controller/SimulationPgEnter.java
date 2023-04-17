package ms.simulation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 시뮬레이션 들어가는 서블렛
 */
@WebServlet("/simulation/simulEnter")
public class SimulationPgEnter extends HttpServlet {

       


	@Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  this.doPost(request, response);
		
			request.getRequestDispatcher("/WEB-INF/views/simulation/simulIndex.jsp").forward(request, response);
		}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	
		
}
}
