package ms.member.model.vo;

public class Member {

	private int memberNo;
	private String memberName;
	private String memberEmail;
	private String memberId;
	private String memberPw;
	private String memberNick;
	private String memberBirth;
	private String memberGender;
	private String memberSignUpDate;
	private String memberIntro;
	private String memberImg;
	
	public Member() {}

	public Member(int memberNo, String memberName, String memberEmail, String memberId, String memberPw,
			String memberNick, String memberBirth, String memberGender, String memberSignUpDate, String memberIntro,
			String memberImg) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNick = memberNick;
		this.memberBirth = memberBirth;
		this.memberGender = memberGender;
		this.memberSignUpDate = memberSignUpDate;
		this.memberIntro = memberIntro;
		this.memberImg = memberImg;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberSignUpDate() {
		return memberSignUpDate;
	}

	public void setMemberSignUpDate(String memberSignUpDate) {
		this.memberSignUpDate = memberSignUpDate;
	}

	public String getMemberIntro() {
		return memberIntro;
	}

	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}

	public String getMemberImg() {
		return memberImg;
	}

	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}
	
	
	
	
	
	
}
