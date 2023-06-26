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

public class MemberInfoControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//"loginId"로그인할때 여기에 저장해놨음
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("loginId");
		
		//service(getMember) /mapper(select)/jsp등록
		MemberService service = new MemberServiceImpl();
		MemberVO vo= service.getMember(id);
		
		
		req.setAttribute("info", vo);
		
		req.getRequestDispatcher("WEB-INF/jsp/member/memberInfo.jsp").forward(req, res);
		
	}

}
