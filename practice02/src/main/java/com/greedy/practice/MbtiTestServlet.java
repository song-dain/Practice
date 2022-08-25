package com.greedy.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mbtitest")
public class MbtiTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		
		String ei = request.getParameter("ei");
		String sn = request.getParameter("sn");
		String tf = request.getParameter("tf");
		String jp = request.getParameter("jp");
		
		String mbti = ei + sn + tf + jp;
		String type = null;
		
		switch(mbti) {
		case "ISTJ" : type = "소금형"; break;
		case "ISFJ" : type = "권력형"; break;
		case "INFJ" : type = "예언자형"; break;
		case "INTJ" : type = "과학자형"; break;
		case "ISTP" : type = "백과사전형"; break;
		case "ISFP" : type = "성인군자형"; break;
		case "INFP" : type = "잔다르크형"; break;
		case "INTP" : type = "아이디어형"; break;
		case "ESTP" : type = "활동가형"; break;
		case "ESFP" : type = "사교형"; break;
		case "ENFP" : type = "스파크형"; break;
		case "ENTP" : type = "발명가형"; break;
		case "ESTJ" : type = "사업가형"; break;
		case "ESFJ" : type = "친선도모형"; break;
		case "ENFJ" : type = "언변능숙형"; break;
		case "ENTJ" : type = "지도자형"; break;
		}
		
		request.setAttribute("name", name);
		request.setAttribute("mbti", mbti);
		request.setAttribute("type", type);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/mbti.jsp");
		
		rd.forward(request, response);
		
	}

}
