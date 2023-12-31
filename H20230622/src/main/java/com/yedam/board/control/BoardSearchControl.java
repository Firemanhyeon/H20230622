package com.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Controller;

public class BoardSearchControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String no = req.getParameter("bno");//값가져오기
		BoardService service = new BoardServiceMybatis();
		BoardVO vo = service.getBoard(Long.parseLong(no));//조회
		
		req.setAttribute("board", vo);//값을 넘겨준다 jsp에
		
		req.getRequestDispatcher("WEB-INF/jsp/boardOne.jsp").forward(req, res);
	}

}
