package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.board.vo.BoardVO;
import com.yedam.common.Controller;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class ModifyMemberControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//id,phone,addr
		//service(modifyMember) / mapper(update)/ 처리후 게시글목록
		
		String id = req.getParameter("id");
		String phone =  req.getParameter("phone");
		String addr = req.getParameter("addr");
		
		MemberVO member = new MemberVO();
		member.setUserId(id);
		member.setUserPhone(phone);
		member.setUserAddr(addr);
		
		MemberService service = new MemberServiceImpl();
		
		if(service.modifyMember(member)) {
			res.sendRedirect("boardList.do");
		}else {
			res.sendRedirect("memberInfo.do");	
		}
	}

}
