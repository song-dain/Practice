package com.greedy.mvc.model.service;

import static com.greedy.mvc.common.jdbc.JDBCTemplate.*;
import static com.greedy.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.greedy.mvc.model.dao.MemberDAO;
import com.greedy.mvc.model.dto.MemberDTO;

public class MemberService {
	
	private final MemberDAO dao;
	
	public MemberService() {
		dao = new MemberDAO();
	}
	
	public List<MemberDTO> memberList() {
		
		Connection conn = getConnection();
		
		List<MemberDTO> allMember = dao.memberList(conn);
		
		close(conn);
		
		return allMember;
	}
	

	public MemberDTO searchMember(String name) {
		
		Connection conn = getConnection();
		
		MemberDTO searchMember = dao.searchMember(conn, name);
		
		close(conn);
		
		return searchMember;
	}

	public int changeExpiryDate(MemberDTO mem) {
		
		Connection conn = getConnection();
		
		int result = dao.changeExpiryDate(conn, mem);
		
		close(conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}


	public int deleteMember(String name) {
		
		Connection conn = getConnection();
		
		int result = dao.deleteMember(conn, name);
		
		close(conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int joinMembership(MemberDTO member) {
		
		Connection conn = getConnection();
		
		int result = dao.joinMembership(conn, member);
		
		close(conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
}
