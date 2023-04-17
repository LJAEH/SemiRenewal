package ms.member.model.dao;


import static ms.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import ms.member.model.vo.Member;

public class MemberDAO {

	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	
	// 기본 생성자
	public MemberDAO() {
		try {
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/ms/sql/member-sql.xml").getPath();  
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/** 로그인 DAO
	 * @param conn
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Connection conn, Member mem) throws Exception {
		
		Member loginMember = null; // 결과 저장용 변수
		
		try {
			// SQL 얻어오기
			String sql = prop.getProperty("login");
			
			
			// PreparedStatment 생성 및 SQL 적재
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			
			// SQL 수행
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				
				loginMember = new Member();
				
				loginMember.setMemberNo( rs.getInt("MEM_NO"));
				loginMember.setMemberEmail(	rs.getString("MEM_EMAIL")  );
				loginMember.setMemberId(	rs.getString("MEM_ID")  );
				loginMember.setMemberPw(	rs.getString("MEM_PW")  );
				loginMember.setMemberImg(	rs.getString("MEM_IMG")  );
				loginMember.setMemberNick(	rs.getString("MEM_NICK")  );
				loginMember.setMemberBirth(	rs.getString("MEM_BIRTH")  );
				loginMember.setMemberGender(	rs.getString("MEM_GENDER")  );
				loginMember.setMemberIntro(	rs.getString("MEM_INTRO")  );
				loginMember.setMemberSignUpDate(rs.getString("MEM_SIGN_UP_DATE") );
				
			}

			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember; // null 또는 Member 객체 주소
	}

	
	
	
	
	
	
	


	/** 회원가입 DAO
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member mem) throws Exception {

		int result = 0; // 결과 저장용 변수
		
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberId());
			pstmt.setString(3, mem.getMemberPw());
			pstmt.setString(4, mem.getMemberNick());
			pstmt.setString(5, mem.getMemberBirth());
				
			pstmt.setString(6, mem.getMemberGender());
			pstmt.setString(7, mem.getMemberImg());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		
		// 결과 반환
		return result;
	}


	
	
	
	
	
	
	
	
	
	/**닉네임 이미지 자기소개 업데이트 
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int changeElse(Connection conn, Member mem) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateElseMember");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberNick());
			pstmt.setString(2, mem.getMemberImg());
			pstmt.setString(3, mem.getMemberIntro());
			pstmt.setInt(	4, mem.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
	
	

	/** 비밀번호 변경 DAO
	 * @param conn
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(Connection conn, String memberPw, String newPw1, int memberNo) throws Exception {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("changePw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newPw1);
			pstmt.setInt(2, memberNo);
			pstmt.setString(3, memberPw);
			
			result = pstmt.executeUpdate();
			
		}finally {
			// try - finally 왜 사용하는가?
			// ->  try 구문에서 JDBC 관련 예외가 발생하더라도
			//    사용중이던 JDBC 객체 자원을 무조건 반환하기 위해서
			close(pstmt);
		}
		
		return result;
	}



	
	
	
	

	/** 회원 탈퇴 DAO
	 * @param conn
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(Connection conn, int memberNo, String memberPw) throws Exception {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("secession");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, memberPw);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	
	
	
	/** 아이디  중복 검사 DAO
	 * @param conn
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String memberId) throws Exception{
		
		int result = 0; // 결과 저장용 변수
		
		try {
			// SQL 얻어오기
			String sql = prop.getProperty("iDDupCheck");
			
			// pstmt 생성
			pstmt = conn.prepareStatement(sql);
			
			// 위치홀더에 알맞은 값 세팅
			pstmt.setString(1, memberId);
			
			// SQL(SELECT) 수행 후 결과 반환 받기
			rs = pstmt.executeQuery();
			
			// rs.next() 로 조회결과를 확인
			if( rs.next() ) {
				result = rs.getInt(1); // 1번 컬럼 결과를 result에 대입
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}


	
	
	

	/** 닉네임 중복 검사
	 * @param conn
	 * @param memberNick
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(Connection conn, String memberNick) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("nicknameDupCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberNick);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}


	
	
	
	/** 인증번호 생성 DAO
	 * @param conn
	 * @param inputEmail
	 * @param cNumber
	 * @return result
	 * @throws Exception
	 */
	public int insertCertification(Connection conn, String inputEmail, String cNumber) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertCertification");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputEmail);
			pstmt.setString(2, cNumber);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
//

	/** 인증번호 확인 DAO
	 * @param conn
	 * @param inputEmail
	 * @param cNumber
	 * @return result
	 * @throws Exception
	 */
	public int checkNumber(Connection conn, String inputEmail, String cNumber) throws Exception{
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("checkNumber");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputEmail);
			pstmt.setString(2, cNumber);
			pstmt.setString(3, inputEmail);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	
	
	

	/** 아이디 찾기 
	 * @param conn
	 * @param memberEmail
	 * @return member
	 * @throws Exception
	 */
	public String searchId(Connection conn, String memberEmail) throws Exception{
		
		String memberId = null;
		try {
			String sql = prop.getProperty("searchId");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberEmail);
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				
				
				
			
				
				memberId = rs.getString("MEM_ID");
				
				
				
			
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return memberId; // null 또는 Member 객체 주소
	}



	/** 인증번호, 발급일 수정 DAO
	 * @param conn
	 * @param inputEmail
	 * @param cNumber
	 * @return result
	 * @throws Exception
	 */
	public int updateCertification(Connection conn, String inputEmail, String cNumber) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateCertification");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cNumber);
			pstmt.setString(2, inputEmail);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 본 영화 삽입
	 * @param conn
	 * @param memNo
	 * @param movieNo
	 * @return
	 * @throws Exception
	 */
	public int watchedMovieInsert(Connection conn, int memNo, int movieNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("watchedMovieInsert");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, movieNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	/** 본 영화 삭제
	 * @param conn
	 * @param memNo
	 * @param movieNo
	 * @return
	 */
	public int watchedMovieDelete(Connection conn, int memNo, int movieNo) throws Exception {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("watchedMovieDelete");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, movieNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	/** 보고싶은 영화 삽입
	 * @param conn
	 * @param memNo
	 * @param movieNo
	 * @return
	 */
	public int wannaMovieInsert(Connection conn, int memNo, int movieNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("wannaMovieInsert");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, movieNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	/** 보고 싶은 영화 삭제
	 * @param conn
	 * @param memNo
	 * @param movieNo
	 * @return
	 */
	public int wannaMovieDelete(Connection conn, int memNo, int movieNo) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("wannaMovieDelete");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, movieNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	/** 회원의 인생 영화 삽입
	 * @param conn
	 * @param memNo
	 * @param movieNo
	 * @param mode 
	 * @return
	 */
	public int lifeMovie(Connection conn, int memNo, int movieNo, String mode) throws Exception {
		
		int result = 0;
		
		try {
			if(mode.equals("insert")) {
				
				String sql = prop.getProperty("lifeMovieInsert");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, memNo);
				pstmt.setInt(2, movieNo);
				
				result = pstmt.executeUpdate();
				
			} else {
				
				String sql = prop.getProperty("lifeMovieDelete");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, memNo);
				pstmt.setInt(2, movieNo);
				
				result = pstmt.executeUpdate();
			}
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	

	public int changeElseNoImg(Connection conn, Member mem) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("changeElseNoImg");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberNick());
			pstmt.setString(2, mem.getMemberIntro());
			pstmt.setInt(	3, mem.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
//
//	/** 회원 정보 조회 DAO
//	 * @param conn
//	 * @param memberEmail
//	 * @return member
//	 * @throws Exception
//	 */
//	public Member selectOne(Connection conn, String memberEmail) throws Exception {
//		
//		Member member = null;
//		
//		try {
//			String sql = prop.getProperty("selectOne");
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, memberEmail);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) { // 조회 결과가 있는 경우
//				member = new Member();
//				
//				member.setMemberEmail(  	rs.getString(1)  );
//				member.setMemberNickname(  	rs.getString(2)  );
//				member.setMemberTel(  		rs.getString(3)  );
//				member.setMemberAddress(  	rs.getString(4)  );
//				member.setEnrollDate( 		rs.getString(5)	 );
//				
//			}
//			
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//		
//		return member;
//	}
//
//
//
//	/** 회원 목록 조회 DAO
//	 * @param conn
//	 * @return list
//	 * @throws Exception
//	 */
//	public List<Member> selectAll(Connection conn) throws Exception{
//		List<Member> list = new ArrayList<Member>();
//		
//		try {
//			String sql = prop.getProperty("selectAll");
//			
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			
//			while( rs.next() ) {
//				Member mem = new Member();
//				
//				mem.setMemberNo( 		rs.getInt(1) );
//				mem.setMemberEmail( 	rs.getString(2));
//				mem.setMemberNickname( 	rs.getString(3));
//				
//				list.add(mem); // 리스트 추가
//			}
//			
//		}finally {
//			close(rs);
//			close(stmt);
//		}
//		
//		return list;
//	}
//
//
//
//	/** 프로필 이미지 변경 DAO
//	 * @param conn
//	 * @param memberNo
//	 * @param profileImage
//	 * @return result
//	 * @throws Exception
//	 */
//	public int updateProfileImage(Connection conn, int memberNo, String profileImage) throws Exception {
//		int result = 0;
//		
//		try {
//			String sql = prop.getProperty("updateProfileImage");
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, profileImage);
//			pstmt.setInt(2, memberNo);
//
//			result = pstmt.executeUpdate();
//			
//		}finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}
//





}