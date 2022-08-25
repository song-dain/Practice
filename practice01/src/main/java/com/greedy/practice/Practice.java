package com.greedy.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/practice1")
public class Practice extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String nickname = request.getParameter("nickname");	
		String content = request.getParameter("content");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		StringBuilder responseBuilder = new StringBuilder();
		responseBuilder.append("<!doctype html>\n")
						.append("<html>\n")
						.append("<head>\n")
						.append("<body>\n")
						.append("제목 : " + title + "<br>")
						.append("닉네임 : " + nickname + "<br>")
						.append("내용 : " + content)
						.append("</body>\n")
						.append("<html>");
		
		out.print(responseBuilder.toString());
		out.flush();
		out.close();
	}

}
