package com.yedam.member.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Controller;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class AddMemberControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//file 업로드 db저장 하는 
		//생성자:1)요청정보2)저장경로3)최대파일크기4)인코딩5)리네임정책.
		String savePath = req.getServletContext().getRealPath("/images");//저장경로
		int maxSize = 1024 * 1024 *10;//최대파일크기
		String enc = "UTF-8";//인코딩 
		
		
		MultipartRequest multi = new MultipartRequest(req,savePath,maxSize,enc, new DefaultFileRenamePolicy() );//req = 요청정보 DefaultFileRenamePolicy=리네임정책
	
		String id = multi.getParameter("uid");
		String pw = multi.getParameter("upw");
		String nm = multi.getParameter("uname");
		String bth = multi.getParameter("ubirth");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String img = multi.getFilesystemName("img");
		
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		vo.setUserPw(pw);
		vo.setUserName(nm);
		try {
			vo.setUserBirth(sdf.parse(bth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vo.setUserImg(img);
		
		MemberService service = new MemberServiceImpl();
		if(service.addMember(vo)) {
			res.sendRedirect("boardList.do");
		}else {
			res.sendRedirect("memberJoinForm.do");
		}
		//service 등록 - serviceimpl -mapper , mapper xml 순서 
	}

}
