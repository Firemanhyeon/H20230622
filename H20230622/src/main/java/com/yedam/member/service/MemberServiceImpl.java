package com.yedam.member.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.member.persistence.MemberMapper;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	
	@Override
	public MemberVO login(String id, String pw) {//xml파일에서 파라미터값을 안주고싶으면 
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		vo.setUserPw(pw);
		return mapper.login(vo);
	}


	@Override
	public boolean addMember(MemberVO member) {
		return mapper.insert(member)==1;
	}
	
	public MemberVO getMember(String userId) {
		MemberVO vo = new MemberVO();
		vo.setUserId(userId);
		return mapper.select(vo);
	}


	@Override
	public boolean modifyMember(MemberVO member) {
		return mapper.update(member) == 1;
	}

}
