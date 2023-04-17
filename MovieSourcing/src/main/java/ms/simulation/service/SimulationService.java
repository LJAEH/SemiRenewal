package ms.simulation.service;

import static ms.common.JDBCTemplate.close;
import static ms.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

import ms.movie.model.dao.MovieInfoDAO;
import ms.movie.model.vo.MovieInfo;
import ms.movie.model.vo.MovieRecommend;
import ms.simulation.dao.SimulationDao;


public class SimulationService {
	


	
	private SimulationDao dao = new SimulationDao();

	
	

	public List<String> getAllGenres() throws Exception{
		Connection conn = getConnection();
	
		
		List<String> getAllGenres =  dao.getAllGenres(conn);
					
		
			close(conn);
		
		
		return getAllGenres;
	}






	
	
	
	


	public MovieInfo movieInfo(int selectedGenre) {
	Connection conn = getConnection();
		
	SimulationDao dao = new SimulationDao();
		
		MovieInfo movie = null;
		
		try {
			
			movie = dao.movieInfo(conn, selectedGenre);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(conn);
		}
		
		return movie;
	}





	public String getGenreName(int selectedGenre) {
		Connection conn = getConnection();
		String getGenreName = null ;
		SimulationDao dao = new SimulationDao();
	try {
			
		getGenreName  = dao.getGenreName (conn, selectedGenre);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(conn);
		}
		
		return getGenreName;
	}


}


