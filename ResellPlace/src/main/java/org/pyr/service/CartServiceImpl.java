package org.pyr.service;

import java.util.ArrayList;

import org.pyr.domain.CartDTO;
import org.pyr.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartMapper cmapper;
	
	//상품상세페이지의 데이터를 cart데이터베이스에 넣기
	public void detailCart(CartDTO cart) {
		cmapper.detailCart(cart);
	}
	
	//카트목록리스트 뿌리기
	public ArrayList<CartDTO> cartList(CartDTO cart){
		return cmapper.cartList(cart);
	}
	
	//상품수량 수정 -구현
	//성공하면1아니면 0값을 가져와야하기때문에 int타입가지고온다
	public int cartupdate(CartDTO cart) {
		return cmapper.cartupdate(cart);
	}
	
	//장바구니 상품 삭제 -구현
	//성공하면1아니면 0값을 가져와야하기때문에 int타입가지고온다
	public int cartRemove(CartDTO cart) {
		return cmapper.cartRemove(cart);
	}
	
}
