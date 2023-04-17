package ms.main.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ms.main.model.dao.MainDAO;
import ms.main.model.vo.Main;


public class MainService {

	private MainDAO mainDAO = new MainDAO();
	
	public Map<String, Object> selectMainContent() throws SQLException {
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<Main> movieList = mainDAO.selectMainContent();		// 메인 컨텐츠 조회
		List<Map<String, Object>> communityList = mainDAO.selectMainCommContent();	// 메인 커뮤니티 조회
		List<Map<String, Object>> reviewList = mainDAO.selectMainReviews();	// 메인 리뷰 조회
		
		List<Main> copy = new ArrayList<>(movieList);
		result.put("netflixList", copy.subList(0, 5)); 			// 넷플 컨텐츠 리스트
		
		List<Main> copy1 = new ArrayList<>(movieList);
        Collections.shuffle(copy1);
		result.put("watchaList", copy1.subList(0, 5)); 				// 왓챠 컨텐츠 리스트

		List<Main> copy2 = new ArrayList<>(movieList);
        Collections.shuffle(copy2);
		result.put("disneyPlusList", copy2.subList(0, 5)); 			// 디+ 컨텐츠 리스트
		
		List<Main> copy3 = new ArrayList<>(movieList);
        Collections.shuffle(copy3);
		result.put("recommandList", copy3);							// 추천  컨텐츠 리스트\
		
		List<Main> copy4 = new ArrayList<>(movieList);
        Collections.shuffle(copy4);
		result.put("newList", copy4);								// 새로운 컨텐츠  리스트
		
		List<Main> copy5 = new ArrayList<>(movieList);
        Collections.shuffle(copy5);
		result.put("lifeList1", copy5.subList(0, 5));								// 인생1  컨텐츠 리스트
		
		List<Main> copy6 = new ArrayList<>(movieList);
        Collections.shuffle(copy6);
		result.put("lifeList2", copy6.subList(0, 5));								// 인생2 컨텐츠  리스트
		
		Collections.shuffle(communityList);
		result.put("communityList", communityList);						// 커뮤니티 리스트
		Collections.shuffle(reviewList);
		result.put("reviewList", reviewList);							// 리뷰 리스트
		
		return result;
	}

}
