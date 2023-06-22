package com.yedam;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.control.BoardAddControl;
import com.yedam.board.control.BoardFormControl;
import com.yedam.board.control.BoardListControl;
import com.yedam.board.control.BoardSearchControl;
import com.yedam.common.Controller;

public class FrontController extends HttpServlet{
	String enc;
	HashMap<String , Controller > menu;

	public FrontController() {
		menu =new HashMap<>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		enc = config.getInitParameter("charset");
		System.out.println("init실행");
		menu.put("/main.do", new MainControl());
		menu.put("/boardList.do", new BoardListControl());
		menu.put("/boardForm.do", new BoardFormControl());
		menu.put("/addBoard.do", new BoardAddControl());
		menu.put("/getBoard.do", new BoardSearchControl());
		menu.put("/member.do", new MemberControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc);
		
		
		String uri = req.getRequestURI();//uri값을 반환해주는 메소드 
		String cpath = req.getContextPath();//application이름 프로젝트이름
		String path = uri.substring(cpath.length()); //전체에서 젤 마지막 페이지만 출력
		System.out.println("uri: "+uri);
		System.out.println("cpath: "+cpath);
		System.out.println("path: "+path);
		
		Controller msg = menu.get(path);//put으로 넣은것들 반환 --url패턴 실행
		msg.exec(req, resp);
	}
}
