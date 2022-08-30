package com.greedy.mvc.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.greedy.mvc.common.config.ConfigLocation;
import com.greedy.mvc.model.dto.MemberDTO;
import static com.greedy.mvc.common.jdbc.JDBCTemplate.*;
public class MemberDAO {
	
	private final Properties prop;
	
	public MemberDAO() {
		
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "member-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberDTO> memberList(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		
		String query = prop.getProperty("memberList");
		
		List<MemberDTO> list = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				MemberDTO mem = new MemberDTO();
				
				mem.setCode(rset.getInt("MEMBER_CODE"));
				mem.setId(rset.getString("MEMBER_ID"));
				mem.setPwd(rset.getString("MEMBER_PWD"));
				mem.setName(rset.getString("NAME"));
				mem.setGender(rset.getString("GENDER"));
				mem.setLevel(rset.getString("MEMBER_LEVEL"));
				mem.setRegistDate(rset.getDate("REGIST_DATE"));
				mem.setExtendYn(rset.getString("EXTEND_YN"));
				mem.setExpiryDate(rset.getDate("EXPIRY_DATE"));
				
				list.add(mem);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public MemberDTO searchMember(Connection conn, String name) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;
		String query = prop.getProperty("searchMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				member = new MemberDTO();
				
				member.setCode(rset.getInt("MEMBER_CODE"));
				member.setId(rset.getString("MEMBER_ID"));
				member.setName(rset.getString("NAME"));
				member.setGender(rset.getString("GENDER"));
	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public int changeExpiryDate(Connection conn, MemberDTO mem) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("changeExpiryDate");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, mem.getExpiryDate());
			pstmt.setString(2, mem.getName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String name) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
