package org.pyr.mapper;

import org.pyr.domain.MemberDTO;

public interface MemberMapper {
	//회원가입과 관련이 되어있는 DB작업 - 설계
	public void insert(MemberDTO mdto);
	
	//로그인과 관련이 되어있는 DB작업 - 설계
	public MemberDTO login(MemberDTO mdto);
}
