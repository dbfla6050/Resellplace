package org.pyr.service;

import org.pyr.domain.MemberDTO;
import org.pyr.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper mmapper;
	
	
	//회원가입하기  -구현
	public void insert(MemberDTO mdto) {
		mmapper.insert(mdto);
	}
	
	//로그인하기 설계 - 구현
	public MemberDTO login(MemberDTO mdto) {
		return mmapper.login(mdto);
	}
	
	
}
