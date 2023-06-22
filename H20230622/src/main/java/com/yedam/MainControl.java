package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Controller;

public class MainControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//보드리스트라고하는 jsp페이지를 열어주고싶다 
		//url에 보드리스트.do를 치면 페이지로 연결하고싶음
		RequestDispatcher rd = 
				req.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		rd.forward(req, resp);
		
	}

}
