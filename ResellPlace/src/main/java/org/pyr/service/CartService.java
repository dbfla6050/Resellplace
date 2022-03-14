package org.pyr.service;

import java.util.ArrayList;

import org.pyr.domain.CartDTO;
import org.pyr.domain.ReplyDTO;

public interface CartService {
	//상품상세페이지의 데이터를 cart데이터베이스에 넣기
	public void detailCart(CartDTO cart);
	
	//카트목록리스트 뿌리기
	public ArrayList<CartDTO> cartList(CartDTO cart);
	
	//상품수량 수정 -설계
	//성공하면1아니면 0값을 가져와야하기때문에 int타입가지고온다
	public int cartupdate(CartDTO cart);
	
	//장바구니 상품 삭제 -설계
	//성공하면1아니면 0값을 가져와야하기때문에 int타입가지고온다
	public int cartRemove(CartDTO cart);
	
}
