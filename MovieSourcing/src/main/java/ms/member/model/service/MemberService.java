package ms.member.model.service;


import static ms.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import ms.member.model.dao.MemberDAO;
import ms.member.model.vo.Member;
public class MemberService {

	private MemberDAO dao = new MemberDAO();
	
	/** 로그인 서비스
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem) throws Exception{
		
		// Connection 얻어오기
		Connection conn = getConnection();
		
		// DAO 수행
		Member loginMember = dao.login(conn, mem);
		
		// Connection 반환
		close(conn);
		
		// 결과 반환
		return loginMember;
	}

	

	
	/** 회원가입 Service
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member mem) throws Exception {

		// 1) 커넥션 얻어오기
		Connection conn = getConnection(); // DBCP 에서 얻어옴
		
		// 2) DAO 메소드 호출 후 결과 반환 받기
		int result = dao.signUp(conn, mem);
		
		// 3) 트랜잭션 처리
		// result가 0인 경우 -> DAO return 구문 잘못 작성
		
		if(result > 0)	commit(conn);  
		else			rollback(conn);
		
		// 4) conn 반환(DBCP로 돌려주기)
		close(conn);
		
		// 5) 결과 반환
		return result;
	}



	
	

	/** 자기소개 프로필 이미지 변경 서비스 
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int changeElse(Member mem) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.changeElse(conn, mem);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	
	
	/** 비밀번호 변경 Service
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(String memberPw, String newPw1, int memberNo) throws Exception {
		
		Connection conn = getConnection(); // DBCP에서 얻어옴
		
		int result = dao.changePw(conn, memberPw, newPw1, memberNo);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	
	
	
	
	
	/** 회원 탈퇴 서비스
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(int memberNo, String memberPw) throws Exception{
		Connection conn = getConnection(); // DBCP에서 얻어옴
		
		int result = dao.secession(conn, memberNo, memberPw);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}



	/** 아이디 중복 검사 Service
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String memberId) throws Exception {
		
		Connection conn = getConnection(); // DBCP 에서 만들어둔 커넥션 얻어오기
		
		int result = dao.idDupCheck(conn, memberId);
		
		close(conn); 
		
		return result;
	}

	
	
	

	/** 닉네임 중복 검사 Service
	 * @param memberNickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(String memberNick) throws Exception{
		
		// DBCP에서 Connection 얻어오기
		Connection conn = getConnection();
		
		// DAO 메서드 수행 후 결과 반환 받기
		int result = dao.nicknameDupCheck(conn, memberNick);
		
		// Connection 반환
		close(conn);
		
		// 결과 반환
		return result;
	}

	


	/** 아이디 찾기 
	 * @param memberEmail
	 * @return member
	 * @throws Exception
	 */
	public String searchId(String memberEmail) throws Exception{
		// TODO Auto-generated method stub		Connection conn = getConnection(); // DBCP 에서 만들어둔 커넥션 얻어오기
		
		
		
		Connection conn = getConnection();
		
		// DAO 수행
		String memberId  = dao.searchId(conn, memberEmail);
		
		// Connection 반환
		close(conn);
		
		// 결과 반환
		return memberId;
	}

	
	
	
	
	
	

	
	/** 인증번호 확인 Service
	 * @param inputEmail
	 * @param cNumber
	 * @return
	 * @throws Exception
	 */
	public int checkNumber(String inputEmail, String cNumber) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.checkNumber(conn, inputEmail, cNumber);
		
		close(conn);
		return result;
	}

	
	

	/** 인증 번호 DB 추가 Service
	 * @param inputEmail
	 * @param cNumber
	 * @return
	 * @throws Exception
	 */
	public int insertCertification(String inputEmail, String cNumber) throws Exception {
		
		Connection conn = getConnection();
		
		// 1) 입력한 이메일과 일치하는 값이 있으면 수정(UPDATE)
		int result = dao.updateCertification(conn, inputEmail, cNumber);
		
		// 2) 일치하는 이메일이 없는겨우 -> 처음으로 인증번호를 발급 받음 -> 삽입(INSERT)
		if( result == 0 ) {
			result = dao.insertCertification(conn, inputEmail, cNumber);
		}
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
	}




	/** 본 영화 삽입
	 * @param memNo
	 * @param movieNo
	 * @return
	 */
	public int watchedMovieInsert(int memNo, int movieNo) {

		Connection conn = getConnection();
		
		int result = 0;

		try {
			
			result = dao.watchedMovieInsert(conn, memNo, movieNo);
			
			if(result != 0) commit(conn);
			else rollback(conn);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}




	/** 본 영화 삭제
	 * @param memNo
	 * @param movieNo
	 * @return
	 */
	public int watchedMovieDelete(int memNo, int movieNo) {
		
		int result = 0;
		
		Connection conn = getConnection();
		
		try {
			
			result = dao.watchedMovieDelete(conn, memNo, movieNo);
			
			if(result != 0) commit(conn);
			else rollback(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}




	/** 보고싶은 영화 삽입
	 * @param memNo
	 * @param movieNo
	 * @return
	 */
	public int wannaMovieInsert(int memNo, int movieNo) {
		int result = 0;
		
		Connection conn = getConnection();
		
		try {
			
			result = dao.wannaMovieInsert(conn, memNo, movieNo);
			
			if(result != 0) commit(conn);
			else rollback(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}


	/** 보고 싶은 영화 삭제
	 * @param memNo
	 * @param movieNo
	 * @return
	 */
	public int wannaMovieDelete(int memNo, int movieNo) {
		int result = 0;
		
		Connection conn = getConnection();
		
		try {
			
			result = dao.wannaMovieDelete(conn, memNo, movieNo);
			
			if(result != 0) commit(conn);
			else rollback(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}




	/** 회원의 인생 영화 삽입
	 * @param memNo
	 * @param movieNo
	 * @param mode 
	 * @return
	 */
	public int lifeMovie(int memNo, int movieNo, String mode) {
		
		int result = 0;
		
		Connection conn = getConnection();
		
		try {
			
			result = dao.lifeMovie(conn, memNo, movieNo, mode);
			
			if(result != 0) commit(conn);
			else rollback(conn);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		
		return result;
	}

	
	
	
	
	
	


	public int changeElseNoImg(Member mem)  throws Exception{
		Connection conn = getConnection();
		
		int result = dao.changeElseNoImg(conn, mem);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
//
//	/** 회원 정보 조회 Service
//	 * @param memberEmail
//	 * @return member
//	 * @throws Exception
//	 */
//	public Member selectOne(String memberEmail) throws Exception{
//		Connection conn = getConnection();
//		
//		Member member = dao.selectOne(conn, memberEmail);
//		
//		close(conn);
//		
//		return member;
//	}
//
//
//	/** 회원 목록 조회 Service
//	 * @return list
//	 * @throws Exception
//	 */
//	public List<Member> selectAll() throws Exception {
//		Connection conn = getConnection();
//		
//		List<Member> list = dao.selectAll(conn);
//		
//		close(conn);
//		
//		return list;
//	}
//
//
//	/** 프로필 이미지 변경 Service
//	 * @param memberNo
//	 * @param profileImage
//	 * @return result
//	 * @throws Exception
//	 */
//	public int updateProfileImage(int memberNo, String profileImage) throws Exception{
//		
//		Connection conn = getConnection();
//		
//		int result = dao.updateProfileImage(conn, memberNo, profileImage);
//		
//		// 트랜잭션 제어 처리
//		if(result > 0)	commit(conn);
//		else			rollback(conn);
//		
//		close(conn);
//		
//		return result;
//	}
//



	

}
