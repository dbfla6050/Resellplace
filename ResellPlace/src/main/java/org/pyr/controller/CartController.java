package org.pyr.controller;

import javax.servlet.http.HttpSession;

import org.pyr.domain.CartDTO;
import org.pyr.domain.MemberDTO;
import org.pyr.domain.ReplyDTO;
import org.pyr.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
  
@Controller
@RequestMapping("resellplace")
public class CartController {
	
	@Autowired
	private CartService cservice;

	@GetMapping("cart")
	public void cart(CartDTO cart, Model model, HttpSession session) {
		System.out.println("resellplace/cart");
		//cservice.cartList();
		
		// id가 null이 아니면 장바구니에 카트리스트 뿌려라
		if(session.getAttribute("login")!=null) {
			//세션을 통해서 아이디를 데이터베이스로 보냄
			MemberDTO member = (MemberDTO)session.getAttribute("login");
			cart.setId(member.getId());
			//카트리스트뿌리기
			model.addAttribute("cartlist", cservice.cartList(cart));
		}
	}
	
	@PostMapping("pdetail")
	public String pdetailPost(CartDTO cart, RedirectAttributes rttr) {
		System.out.println("cart post...."+ cart);
		//cart에저장된 데이터를 service으로 전달
		cservice.detailCart(cart);
		
		//디테일페이지로 이동하는데 뒤에 uuid가없어서 페이지안뜰때 RedirectAttributes사용
		//?자동으로 붙고                uuid  =  cart안에있는 uuid번호를 나타냄(cartDTO클래스안의 getUuid()함수사용)
		rttr.addAttribute("uuid", cart.getUuid());
		//디테일페이지로 이동(디테일 컨트롤러를 통해서)
		return "redirect:/resellplace/product/pdetail";
	}

	
	@PostMapping("cart")
	public String cartupdate(CartDTO cart) {
		System.out.println("cartupdate="+cart);
		//cservice.cartupdate(cart);
		return "redirect:/resellplace/main";
	}
	
	//장바구니 상품 데이터베이스에서 삭제시키기
	@DeleteMapping(value="cartRemove",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> cartRemove(@RequestBody CartDTO cart){
		System.out.println("cartRemove="+cart);
		//update 성공시 ReplyServiceImpl.java로부터 1을
		//update 실패시 ReplyServiceInpl.java로부터 0을
		//값을 리턴받는다
		int result=cservice.cartRemove(cart);			
		//값이 참이면 success라는 단어를 리턴한다
		return result==1? new ResponseEntity<>("success",HttpStatus.OK)  //update가 정상적으로 처리되었을때
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  //update가 비정상적으로 처리되었을때
		
		
	}
	
	
	
	
	
	
	
	
}
