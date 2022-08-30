package com.greedy.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.model.dto.MemberDTO;
import com.greedy.mvc.model.service.MemberService;

@WebServlet("/member/extend")
public class ExtensionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		java.sql.Date expiryDate = java.sql.Date.valueOf(request.getParameter("expiryDate"));
		
		MemberDTO mem = new MemberDTO();
		mem.setName(name);
		mem.setExpiryDate(expiryDate);
		
		int result = new MemberService().changeExpiryDate(mem);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("successCode", "updateExpiry");
			request.setAttribute("name", name);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "회원 정보 수정 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}
}
