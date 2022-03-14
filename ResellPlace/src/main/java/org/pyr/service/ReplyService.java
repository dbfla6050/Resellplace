package org.pyr.service;

import java.util.ArrayList;

import org.pyr.domain.ReplyDTO;

public interface ReplyService {
	//댓글쓰기 -설계
	public int write(ReplyDTO rdto);
	
	//댓글목록리스트 -설계
	public ArrayList<ReplyDTO> list(int bno);
	
	//댓글수정을 하기위해 댓글내용 가져오기 -설계
	public ReplyDTO detail(int rno);
	
	//댓글수정 -설계
	//성공하면1아니면 0값을 가져와야하기때문에 int타입가지고온다
	public int update(ReplyDTO rdto);
	
	//댓글삭제 -설계
	//성공하면1아니면 0값을 가져와야하기때문에 int타입가지고온다
	public int remove(ReplyDTO rdto);
}
