package com.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Controller;

public class BoardAddControl implements Controller {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//사용자타이틀,작성자,내용 각각정보를 읽어오기위해 req가 가지고있는 파라미터메소드 실행
		String wr = req.getParameter("writer");
		String tl= req.getParameter("title");
		String ctn= req.getParameter("content");
		
		if(wr.isEmpty() || tl.isEmpty()|| ctn.isEmpty()) {
			req.setAttribute("errorMsg", "필수값을 입력하세요!!");//트라이캐치 
			req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, res);
		} else {
			
			BoardVO vo = new BoardVO();
			vo.setBrdTitle(tl);
			vo.setBrdWriter(wr);
			vo.setBrdContent(ctn);
			
			
			BoardService service = new BoardServiceMybatis();
			if(service.addBoard(vo)){
				res.sendRedirect("boardList.do");
			}else {
				res.sendRedirect("addBoard.do");
			}
		}
		
	}

}

