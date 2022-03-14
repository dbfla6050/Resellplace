package org.pyr.service;

import org.pyr.domain.MemberDTO;

public interface MemberService {
	//회원가입하기 -설계
	public void insert(MemberDTO mdto);
	
	//로그인하기 -설계
	public MemberDTO login(MemberDTO mdto);
	
}
