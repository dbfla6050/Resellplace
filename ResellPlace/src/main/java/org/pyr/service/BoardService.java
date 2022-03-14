package org.pyr.service;

import java.util.ArrayList;

import org.pyr.domain.BoardDTO;
import org.pyr.domain.Criteria;

public interface BoardService {
	//게시판 글쓰기 -설계
	public void write(BoardDTO board);
	
	//게시판 목록리스트 -설계
	public ArrayList<BoardDTO> list(Criteria cri);
	
	//게시판 페이징에 쓰일 데이터건수 -설계
	public int getTotalCount(Criteria cri);
	
	//게시판 목록리스트에서 제목을 클릭했을때 내용이 나오는 상세페이지 -설계
	//데이터를 컨트롤러로 반환시키기위해서 타입을 BoardDTO로바꿈
	public BoardDTO detail(BoardDTO board);
	
	//게시판 이전글 - 설계
	public BoardDTO detailPrev(BoardDTO board);
	
	//게시판 다음글 - 설계
	public BoardDTO detailNext(BoardDTO board);
	
	//게시판 수정페이지 -설계
	//글수정버튼을 클릭하면 데이터가 데이터베이스로가서 업데이트된다
	public void modify(BoardDTO board);
	
	//게시판 삭제페이지 -설계
	public void remove(BoardDTO board);
	
}
