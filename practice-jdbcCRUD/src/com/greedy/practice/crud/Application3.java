package com.greedy.practice.crud;

import static com.greedy.practice.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Application3 {

	public static void main(String[] args) {
		
		/* update */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("비밀번호를 수정할 회원 아이디를 입력하세요 : ");
		String memberId = sc.nextLine();
		
		System.out.print("수정할 비밀번호를 입력하세요 : ");
		String newPwd = sc.nextLine();
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
			String query = prop.getProperty("changePwd");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		}  catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		if(result > 0) {
			System.out.println("비밀번호 수정 성공.");
		} else {
			System.out.println("비밀번호 수정 실패");
		}

	}

}
