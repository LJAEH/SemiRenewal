package ms.list.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ms.list.model.dao.mlistDAO;
import ms.list.model.vo.movie;

import static ms.common.JDBCTemplate.*;


public class mlistService {
	
	private mlistDAO dao = new mlistDAO();
	
	
	
	public List<movie> selectMlist() throws Exception {
		
		Connection conn= getConnection();
		
		List<movie> mlist = dao.selectAll(conn);
		
	
		close(conn);
		
		return mlist;
	}



	public List<movie> Searchjanr(String input1) throws Exception{
		
		Connection conn = getConnection();
		
		List<movie> mlist = dao.searchjanr(conn, input1);
		
		close(conn);
		
		return mlist;
	}
	
	public List<movie> Searchnation(String input2) throws Exception{
		
		Connection conn = getConnection();
		
		List<movie> mlist = dao.searchnation(conn, input2);
		
		close(conn);
		
		return mlist;
	}
	
	
	public List<movie> Searchgrade(String input3) throws Exception{
		
		Connection conn = getConnection();
		
		List<movie> mlist = dao.searchgrade(conn, input3);
		
		close(conn);
		
		return mlist;
	}

	
public List<movie> Searchdata(String input4) throws Exception{
		
		Connection conn = getConnection();
		
		List<movie> mlist = dao.searchdata(conn, input4);
		
		close(conn);
		
		return mlist;
	}
	
	
	
	
}
