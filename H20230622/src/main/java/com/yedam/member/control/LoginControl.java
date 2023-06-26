package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Controller;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class LoginControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//로그인하면 로그아웃하거나 창을 닫기전까지 해당 유저 정보를 담고있어야함
		HttpSession session = req.getSession();//처음 접속할때 세션을 하나 만듬
		
		
		
		String id = req.getParameter("uid");
		String pw = req.getParameter("upw");
		
		MemberService service = new MemberServiceImpl();
		MemberVO member = service.login(id, pw);
		
		if(member!=null) {//로그인성공
			session.setAttribute("loginId", member.getUserId());//처음접속했던 정보를 담아놓을수있다
			session.setAttribute("loginName", member.getUserName());//로그인정보유지.
			
			res.sendRedirect("boardList.do");
		}else {//로그인실패
			res.sendRedirect("memberLoginForm.do");
		}
		
		
	}

}
