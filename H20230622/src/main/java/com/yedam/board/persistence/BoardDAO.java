package com.yedam.board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.board.vo.BoardVO;
import com.yedam.common.DAO;

//목록,단건조회,등록,수정,삭제
public class BoardDAO {
	Connection conn ;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	
	private void close() {
		try {
			if(conn != null) {
				conn.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<BoardVO> boardList(){
		List<BoardVO> list = new ArrayList();
		conn = DAO.getConnect();
		sql = "select * from tbl_board order by brd_no desc";
		try {
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdNo(rs.getInt(1));
				vo.setBrdTitle(rs.getString(2));
				vo.setBrdWriter(rs.getString(3));
				vo.setBrdContent(rs.getString(4));
				vo.setCreateDate(rs.getDate(5));
				vo.setClickCnt(rs.getInt(6));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
		
	}

		
	
	public boolean insertBoard(BoardVO vo) {
		conn = DAO.getConnect();
		sql="insert into tbl_board(brd_no , brd_title , brd_writer,brd_content ) values(board_seq.nextval,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getBrdTitle());
			psmt.setString(2, vo.getBrdWriter());
			psmt.setString(3, vo.getBrdContent());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return false;
	}
	
	//수정
	public boolean updateBoard(BoardVO vo) {
		conn = DAO.getConnect();
		sql = "update tbl_board set brd_title = ? , brd_content = ? where brd_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBrdTitle());
			psmt.setString(2, vo.getBrdContent());
			psmt.setLong(3, vo.getBrdNo());
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return false;
		
	}
	
	//삭제 
	public boolean deleteBoard(long brdNo ) {
		conn = DAO.getConnect();
		sql = "delete from tbl_board where brd_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return false;
	}
	
	//단건조회
	public BoardVO selectBoard(long brdNo) {
		conn = DAO.getConnect();
		sql = "select * from tbl_board where brd_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBrdNo(rs.getInt(1));
				vo.setBrdTitle(rs.getString(2));
				vo.setBrdWriter(rs.getString(3));
				vo.setBrdContent(rs.getString(4));
				vo.setCreateDate(rs.getDate(5));
				vo.setClickCnt(rs.getInt(6));
				return vo;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	
	//조회수증가
	public void clickCount(long brdNo) {
		sql = "update tbl_board set click_cnt = click_cnt+1 where brd_no = ? ";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, brdNo);
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
}
