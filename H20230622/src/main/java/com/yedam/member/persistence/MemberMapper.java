package com.yedam.member.persistence;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	public MemberVO login(MemberVO member);
	public int insert(MemberVO member);
	public MemberVO select(MemberVO member);
	public int update(MemberVO member);
	
}
