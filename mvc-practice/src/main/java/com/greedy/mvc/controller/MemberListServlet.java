package com.greedy.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.model.dto.MemberDTO;
import com.greedy.mvc.model.service.MemberService;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberService memSerivce = new MemberService();
		
		List<MemberDTO> allMember = memSerivce.memberList();
		
		String path = "";
		if(allMember != null) {
			path = "/WEB-INF/views/member/memberList.jsp";
			request.setAttribute("allMember", allMember);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "직원 조회 실패하였습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
