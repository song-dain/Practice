package com.greedy.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.model.dto.MemberDTO;
import com.greedy.mvc.model.service.MemberService;

@WebServlet("/member/join")
public class JoinMembershipServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String memberLevel = request.getParameter("memberLevel");
		java.sql.Date registDate = java.sql.Date.valueOf(request.getParameter("registDate"));
		java.sql.Date expiryDate = java.sql.Date.valueOf(request.getParameter("expiryDate"));
		
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setGender(gender);
		member.setLevel(memberLevel);
		member.setRegistDate(registDate);
		member.setExpiryDate(expiryDate);
		
		System.out.println(member);
		
		int result = new MemberService().joinMembership(member);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("succCode", "joinMembership");
			request.setAttribute("name", name);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "회원 가입에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
