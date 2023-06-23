package com.yedam.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.persistence.BoardMapper;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.DataSource;

public class BoardServiceMybatis implements BoardService{
	
	//SqlSessionFactory객체
	SqlSession session = DataSource.getInstance().openSession(true);
	BoardMapper mapper = session.getMapper(BoardMapper.class);//2번째방법
	@Override
	public boolean addBoard(BoardVO vo) {
		return mapper.insertBoard(vo)==1;
	}

	@Override
	public BoardVO getBoard(long brdNO) {
		BoardVO vo = mapper.selectBoard(brdNO);
		mapper.updateCnt(brdNO);
		
		return vo ;
		
	}

	@Override
	public boolean editBoard(BoardVO vo) {
		return mapper.updateBoard(vo)==1;
	}

	@Override
	public boolean delBoard(long brdNo) {
		return mapper.deleteCnt(brdNo)==1;
	}

	@Override
	public List<BoardVO> list(int page) {
		
//		return session.selectList("com.yedam.board.persistence.BoardMapper.boardList");//1번방법mapper.id 매퍼의 아이디값
	return mapper.boardList(page);//2번방법	

	}
	@Override
	public int totalCnt() {
		return mapper.totalCnt();
	}
	
}
