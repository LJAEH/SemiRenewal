package ms.movielist.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.movielist.model.service.CommunityListService;
import ms.movielist.model.vo.CommunityListInfo;
import ms.movielist.model.vo.ListMemberInfo;

@WebServlet("/movielist/communityList")
public class CommunityListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			
			CommunityListService service = new CommunityListService();
			
			ListMemberInfo member = service.memberNick(memberNo);
		
			//COM_NO , COM_TITLE ,COM_DATE ,MEM_NO ,READ_COUNT 
			List<CommunityListInfo> communityList = service.communityList(memberNo);
		
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("member", member);
			map.put("communityList", communityList);
			
			req.setAttribute("map",map);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/movie/communityList.jsp");
			
			dispatcher.forward(req, resp);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
