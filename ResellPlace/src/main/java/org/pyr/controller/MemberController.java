package org.pyr.controller;

import javax.servlet.http.HttpSession;

import org.pyr.domain.MemberDTO;
import org.pyr.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
@RequestMapping("resellplace")
public class MemberController {
	
	@Autowired
	private MemberService mservice; 
	
	//회원가입 화면 이동
	@GetMapping("member")
	public void member() {
		System.out.println("resellplace/member");
	}
	
	//회원가입화면을 통해 얻어진 데이터 insert
	@PostMapping("member")
	public String memberPost(MemberDTO mdto) {
		System.out.println("resellplace/member:"+mdto);
		mservice.insert(mdto);
		return "redirect:/resellplace/main";
	}
	
	//로그인 화면 이동
	@GetMapping("login")
	public void login() {
		System.out.println("resellplace/login");
	}
	
	//로그인화면을 통해 얻어진 데이터를 활용하여 select
	//로그인 유지된 상태로 여러화면을 실행하려면 session이 필요하다
	@PostMapping("login")
	public String loginPost(MemberDTO mdto, HttpSession session) {
		System.out.println("resellplace/login:"+mdto);
		MemberDTO login=mservice.login(mdto);
		
		//MemberDTO에 있는 MemberDTO[id=dbfla6050, password=aaaa, name=박유림]를 세션 영역에 login이라는 변수에 저장
		//세션객체(session)에       login변수에,login값을 저장(setAttribute)
		session.setAttribute("login", login);
		
		//세션을 초기화하겠다,로그아웃을하겠다
		//session.invalidate();
		
		//session영역에 login이라는 변수에 값이 있으면 로그인 된채로
		if(session.getAttribute("login")!=null) {
			//main페이지로 이동
			return "redirect:/resellplace/main";
			
		}else {  //session영역에 login이라는 변수에 값이 없으면(null)
			//다시 로그인 할 수 있게 로그인 페이지로 이동
			return "redirect:/resellplace/login";
		}
	}
	
	//로그아웃하기
	@GetMapping("logout")
	public String logout(HttpSession session) {
		System.out.println("resellplace/logout");
		//세션을 초기화하겠다,로그아웃을하겠다
		session.invalidate();
		
		return "redirect:/resellplace/main";
		
	}
	
	
}
