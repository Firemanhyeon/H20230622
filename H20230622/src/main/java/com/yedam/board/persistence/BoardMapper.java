package com.yedam.board.persistence;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardMapper {

	//목록
	public List<BoardVO> boardList(int page);
	//한건조회
	public BoardVO selectBoard(long bno);
	
	//조회수+1
	public int updateCnt(long bno);
	
	public int deleteCnt(long bno);
	
	public int updateBoard(BoardVO board);
	
	public int insertBoard(BoardVO board);
	
	public int totalCnt();
}
