package com.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.common.Controller;

public class BoardRemoveControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String no = req.getParameter("bno");
		
		BoardService service = new BoardServiceMybatis();
		service.delBoard(Long.parseLong(no));
		
		res.sendRedirect("boardList.do");
	}

}
