package org.pyr.mapper;

import java.util.ArrayList;

import org.pyr.domain.ReplyDTO;

public interface ReplyMapper {
	//댓글쓰기와 관련이 되어있는 DB작업-설계
	//insert는 select처럼 resultType이 없기때문에 성공했는지 실패했는지
	//0과1값만 보내준다 컨트롤러까지 보내줘야하기때문에 타입이 void에서 int로 바뀜
	//insert 성공시 ReplyMapper.xml로부터 1을
	//insert 실패시 ReplyMapper.xml로부터 0을
	//값을 리턴받는다
	public int write(ReplyDTO rdto);

	//댓글목록리스트  DB작업-설계
	public ArrayList<ReplyDTO> list(int bno);
	
	//댓글수정을 하기위해 댓글내용 가져오기  DB작업-설계
	//rno는 한건만나오기때문에 arraylist는 필요없다
	public ReplyDTO detail(int rno);
	
	//댓글수정  DB작업 -설계
	//update 성공시 ReplyMapper.xml로부터 1을
	//update 실패시 ReplyMapper.xml로부터 0을
	//값을 리턴받는다, 그래서 int타입가지고옴
	public int update(ReplyDTO rdto);
	
	//댓글삭제 DB작업 -설계
	//remove 성공시 ReplyMapper.xml로부터 1을
	//remove 실패시 ReplyMapper.xml로부터 0을
	//값을 리턴받는다, 그래서 int타입가지고옴
	public int remove(ReplyDTO rdto);
	
}
