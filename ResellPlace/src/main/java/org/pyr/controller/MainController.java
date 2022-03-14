package org.pyr.controller;

import org.pyr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
@RequestMapping("resellplace")
public class MainController {

	@Autowired
	private ProductService pservice;
	
	
	// 메인페이지로 이동
	// 메인페이지에 베스트상품과 신상품을 화면에 뿌린다
	@GetMapping("main")
	public void main(Model model) {
		System.out.println("resellplace/main");		
		//model함수를 써서 데이터베이스를 화면에 뿌린다
		//                  변수이름     데이터
		model.addAttribute("bestproduct", pservice.mainBList());
		model.addAttribute("newproduct", pservice.mainNList());
	}
	
	// 브랜드페이지로 이동
	@GetMapping("brand")
	public void brand() {
		System.out.println("resellplace/brand");
	}
	
	// 베스트상품페이지로 이동
	@GetMapping("bestProduct")
	public void bestP(Model model) {
		System.out.println("resellplace/bestProduct");
		//model함수를 써서 데이터베이스를 화면에 뿌린다
		//                  변수이름     데이터
		model.addAttribute("bestList", pservice.bestList());
	}
	
	// 새로운상품페이지로 이동
	@GetMapping("newArrivals")
	public void newP(Model model) {
		System.out.println("resellplace/newArrivals");
		//model함수를 써서 데이터베이스를 화면에 뿌린다
		//                  변수이름     데이터
		model.addAttribute("newList", pservice.newList());
	}
	
	
	
}
