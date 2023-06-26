package com.yedam.member.service;

import com.yedam.member.vo.MemberVO;
//인터페이스사용하면  구현객체를 다르게 할수있음 (jdbc , mybatis)
//버전을업그레이드한다거나 그럴때 바꾸기 쉽다 구현객체만 변경하면 됨
public interface MemberService {
	
	public MemberVO login(String id , String pw );
	public boolean addMember(MemberVO member);
	public MemberVO getMember(String userId);
	public boolean modifyMember(MemberVO member);
}
