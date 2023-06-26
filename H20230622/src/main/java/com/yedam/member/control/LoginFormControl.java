package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Controller;

public class LoginFormControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//WEB-INF/jsp/member 밑에 따로 멤버화면 넣어서저장
		req.getRequestDispatcher("WEB-INF/jsp/member/loginForm.jsp").forward(req, res);

	}

}
