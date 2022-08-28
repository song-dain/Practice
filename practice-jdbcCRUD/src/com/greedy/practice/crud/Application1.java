package com.greedy.practice.crud;

import static com.greedy.practice.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.greedy.practice.model.dto.MemberDTO;

public class Application1 {

	public static void main(String[] args) {
		
		/* select */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("조회할 회원 이름 : ");
		String name = sc.nextLine();
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MemberDTO member = null;
		List<MemberDTO> list = null;
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
			String query = prop.getProperty("selectMember");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			if(rset.next()) {
				
				member = new MemberDTO();
				
				member.setMemberCode(rset.getInt("MEMBER_CODE"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setName(rset.getString("NAME"));
				member.setGender(rset.getString("GENDER"));
				
				list.add(member);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		
		for(MemberDTO mlist : list) {
			System.out.println(mlist);
		}

	}

}
