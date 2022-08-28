package com.greedy.practice.crud;

import static com.greedy.practice.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.greedy.practice.model.dto.MemberDTO;

public class Application2 {

	public static void main(String[] args) {
		
		/* insert */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("추가할 회원 코드를 입력하세요 : ");
		int code = sc.nextInt();
		sc.nextLine();
		System.out.print("추가할 회원 아이디를 입력하세요 : ");
		String id = sc.nextLine();
		System.out.print("추가할 회원 비밀번호를 입력하세요 : ");
		String pwd = sc.nextLine();
		System.out.print("추가할 회원의 이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("추가할 회원의 성별을 입력하세요(F/M) : ");
		String gender = sc.nextLine();
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
			String query = prop.getProperty("insertMember");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, code);
			pstmt.setString(2, id);
			pstmt.setString(3, pwd);
			pstmt.setString(4, name);
			pstmt.setString(5, gender);
			
			result = pstmt.executeUpdate();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		if(result > 0) {
			System.out.println("회원 등록 성공.");
		} else {
			System.out.println("회원 등록 실패");
		}

	}

}
