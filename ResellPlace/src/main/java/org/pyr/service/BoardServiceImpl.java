package org.pyr.service;

import java.util.ArrayList;

import org.pyr.domain.BoardDTO;
import org.pyr.domain.Criteria;
import org.pyr.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService{
	//객체 생성
	@Autowired
	private BoardMapper bmapper;
	
	
	//게시판 글쓰기 -구현
	public void write(BoardDTO board) {
		//board에저장된 데이터를 bmapper으로 전달
		bmapper.write(board);
	}
	
	//게시판 목록리스트 -구현
	public ArrayList<BoardDTO> list(Criteria cri) {
		//System.out.println("service cri="+cri);
		//System.out.println("service list="+bmapper.list(cri));
		return bmapper.list(cri);
	}
	
	//게시판 페이징에 쓰일 데이터건수 -구현
	//return해서 데이터건수 받아와야함
	public int getTotalCount(Criteria cri) {
		return bmapper.getTotalCount(cri);
	}
	
	//게시판 목록리스트에서 제목을 클릭했을때 내용이 나으는 상세페이지 -구현
	//데이터를 컨트롤러로 반환시키기위해서 타입을 BoardDTO로바꿈
	//조회수+1을 하려면 bno가 필요한데  detail에서 가지고올수있다 
	//@Transactional : 데이터베이스의 상태를 변경하는 작업 또는 한번에 수행되어야 하는 연산
	//detail페이지에서 오류가뜨면 조회수도 +1이 되면 안되기때문에 Transactional사용
	@Transactional
	public BoardDTO detail(BoardDTO board) {
		//board테이블에 조회수 속성에 +1
		bmapper.cntupdate(board);
		//상세페이지 select
		return bmapper.detail(board);
		
	}
	
	//게시판 이전글 - 구현
	public BoardDTO detailPrev(BoardDTO board) {
		return bmapper.detailPrev(board);
	}
	
	//게시판 다음글 - 구현
	public BoardDTO detailNext(BoardDTO board) {
		return bmapper.detailNext(board);
	}
	
	//게시판 글수정 -구현
	//글수정버튼을 클릭하면 데이터가 데이터베이스로가서 업데이트된다
	public void modify(BoardDTO board) {
		bmapper.modify(board);
	}
	
	//게시판 삭제 -구현
	public void remove(BoardDTO board) {
		bmapper.remove(board);
	}
	
	
	
	
}
