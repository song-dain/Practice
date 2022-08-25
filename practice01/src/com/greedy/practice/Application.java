package com.greedy.practice;

import static com.greedy.common.JDBCPractice.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		Connection conn = getConnection();
		
		Statement stmt = null;
		ResultSet rest = null;
		
		try {
			stmt = conn.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("조회하려는 학생의 이름을 입력하세요 : ");
			String name = sc.nextLine();
			String query = "SELECT STUDENT_NAME, STUDENT_ADDRESS, ABSENCE_YN FROM TB_STUDENT WHERE STUDENT_NAME='" + name + "'";
			
			rest = stmt.executeQuery(query);
			
			while(rest.next()) {
				System.out.println(rest.getString("STUDENT_NAME") + " 학생의 주소와 휴학여부입니다.");
				System.out.println("주소 : " + rest.getString("STUDENT_ADDRESS"));
				System.out.println("휴학여부 : " + rest.getString("ABSENCE_YN"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rest);
			close(stmt);
			close(conn);
		}
	}
}
