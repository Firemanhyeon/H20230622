package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Controller;

public class LogoutControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();//처음 접속할때 세션을 하나 만듬
		
		
//		session.removeAttribute("loginId");//정보 지우기
//		session.removeAttribute("loginName");
		
		session.invalidate();//세션 정보들 전부 지우기 
		
		res.sendRedirect("memberLoginForm.do");//다시 로그인창으로
	}

}
