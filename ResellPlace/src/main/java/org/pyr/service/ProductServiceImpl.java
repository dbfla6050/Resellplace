package org.pyr.service;

import java.util.ArrayList;

import org.pyr.domain.ProductDTO;
import org.pyr.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductMapper pmapper;
	
	//상품등록 글쓰기 -구현
	public void regist(ProductDTO product) {
		pmapper.regist(product);
	}
	
	//상품리스트를 화면에 뿌리기 -구현
	public ArrayList<ProductDTO> fileList(){
		return pmapper.fileList();
	}
	
	//상품상세페이지에 데이터 뿌리기 -구현
	public ProductDTO pdetail(ProductDTO product){
		return pmapper.pdetail(product);
	}
	
	//메인에 베스트상품리스트를 화면에 뿌리기 -구현
	public ArrayList<ProductDTO> mainBList(){
		return pmapper.mainBList();
	}
	
	//메인에 새로운상품리스트를 화면에 뿌리기 -구현
	public ArrayList<ProductDTO> mainNList(){
		return pmapper.mainNList();
	}
	
	//베스트상품페이지에 베스트상품리스트를 화면에 뿌리기 -구현
	public ArrayList<ProductDTO> bestList(){
		return pmapper.bestList();
	}
	
	//신상품페이지에 새로운상품리스트를 화면에 뿌리기 -구현
	public ArrayList<ProductDTO> newList(){
		return pmapper.newList();
	}

}
