package com.greedy.practice.crud;

import static com.greedy.practice.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Application4 {

	public static void main(String[] args) {
		
		/* delete */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정보를 삭제할 회원 아이디를 입력하세요 : ");
		String id = sc.nextLine();
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
			String query = prop.getProperty("deleteInfo");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
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
			System.out.println("회원 삭제 성공.");
		} else {
			System.out.println("회원 삭제 실패");
		}
		
	}

}
