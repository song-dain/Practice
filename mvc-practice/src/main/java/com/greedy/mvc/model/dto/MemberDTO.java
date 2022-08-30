package com.greedy.mvc.model.dto;

import java.sql.Date;

public class MemberDTO {
	
	private int code;
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String level;
	private java.sql.Date registDate;
	private String extendYn;
	private java.sql.Date expiryDate;
	
	public MemberDTO() {}

	public MemberDTO(int code, String id, String pwd, String name, String gender, String level, Date registDate,
			String extendYn, Date expiryDate) {
		super();
		this.code = code;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.level = level;
		this.registDate = registDate;
		this.extendYn = extendYn;
		this.expiryDate = expiryDate;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public java.sql.Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(java.sql.Date registDate) {
		this.registDate = registDate;
	}

	public String getExtendYn() {
		return extendYn;
	}

	public void setExtendYn(String extendYn) {
		this.extendYn = extendYn;
	}

	public java.sql.Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(java.sql.Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [code=" + code + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender
				+ ", level=" + level + ", registDate=" + registDate + ", extendYn=" + extendYn + ", expiryDate="
				+ expiryDate + "]";
	}
	
}
