package com.yedam.common;

import java.util.List;

import com.yedam.board.persistence.BoardDAO;
import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;

public class TestMain {

	public static void main(String[] args) {
		BoardService service = new BoardServiceMybatis();
		
		
//		for(BoardVO vo : list ) {목록보기 
//			System.out.println(vo.toString());
//		}
		
		//단건조회
//		List<BoardVO> list = service.list(3);
//		System.out.println(service.delBoard(906));
		
		BoardVO vo = new BoardVO();
		vo.setBrdTitle("aa");
		vo.setBrdContent("ddd");
		vo.setBrdWriter("dfd");
		System.out.println(service.addBoard(vo));
		}
	}


