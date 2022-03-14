package org.pyr.mapper;

import java.util.ArrayList;

import org.pyr.domain.ProductDTO;

public interface ProductMapper {
	//상품등록 글쓰기 db작업 - 설계
	public void regist(ProductDTO product);
	
	//상품리스트를 화면에 뿌리기 db작업 - 설계
	public ArrayList<ProductDTO> fileList();
	
	//상품상세페이지에 데이터 뿌리기 db작업 - 설계
	public ProductDTO pdetail(ProductDTO product);
	
	//메인에 베스트상품리스트를 화면에 뿌리기  db작업 - 설계
	public ArrayList<ProductDTO> mainBList();
	
	//메인에 새로운상품리스트를 화면에 뿌리기  db작업 - 설계
	public ArrayList<ProductDTO> mainNList();
	
	//베스트상품페이지에 베스트상품리스트를 화면에 뿌리기  db작업 - 설계
	public ArrayList<ProductDTO> bestList();
	
	//신상품페이지에 새로운상품리스트를 화면에 뿌리기  db작업 - 설계
	public ArrayList<ProductDTO> newList();

}
