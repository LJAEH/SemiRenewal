package ms.main.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.main.model.service.MainService;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	private MainService mainService;
	public MainServlet() {
		this.mainService = new MainService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			req.setAttribute("result", mainService.selectMainContent());
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main.jsp");
			dispatcher.forward(req, res);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
		
	}

}
