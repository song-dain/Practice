package com.greedy.practice.model.dto;

public class MemberDTO {
	
	private int memberCode;
	private String memberId;
	private String memberPwd;
	private String name;
	private String gender;
	
	public MemberDTO() {};
	
	public MemberDTO(int memberCode, String memberId, String memberPwd, String name, String gender) {
		super();
		this.memberCode = memberCode;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.name = name;
		this.gender = gender;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberCode=" + memberCode + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", name="
				+ name + ", gender=" + gender + "]";
	}
	

}
