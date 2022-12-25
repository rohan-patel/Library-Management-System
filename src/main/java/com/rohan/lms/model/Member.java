package com.rohan.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	@GeneratedValue
	private Long memberId;
	
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private String memberStreet;
	private String memberCity;
	private Gender memberGender;
//	private String memberGender;
	
	

	public Member() {
		super();
	}
	
	public Member(String memberName, String memberPhone, String memberEmail, String memberStreet, String memberCity,
			Gender memberGender) {
		super();
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberStreet = memberStreet;
		this.memberCity = memberCity;
		this.memberGender = memberGender;
	}



	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberStreet() {
		return memberStreet;
	}

	public void setMemberStreet(String memberStreet) {
		this.memberStreet = memberStreet;
	}

	public String getMemberCity() {
		return memberCity;
	}

	public void setMemberCity(String memberCity) {
		this.memberCity = memberCity;
	}

	public Gender getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(Gender memberGender) {
		this.memberGender = memberGender;
	}

}
