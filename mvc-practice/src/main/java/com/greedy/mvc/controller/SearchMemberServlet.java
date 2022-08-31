package com.greedy.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.model.dto.MemberDTO;
import com.greedy.mvc.model.service.MemberService;

@WebServlet("/member/search")
public class SearchMemberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		MemberService memSerivce = new MemberService();
		
		MemberDTO searchMember = memSerivce.searchMember(name);
		
		String path = "";
		
		if(searchMember != null) {
			path = "/WEB-INF/views/member/memberInfo.jsp";
			request.setAttribute("searchMember", searchMember);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "회원 조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
}
