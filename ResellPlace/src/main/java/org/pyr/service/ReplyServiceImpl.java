package org.pyr.service;

import java.util.ArrayList;

import org.pyr.domain.ReplyDTO;
import org.pyr.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired 
	private ReplyMapper rmapper;

	//댓글쓰기 -구현
	//insert는 select처럼 resultType이 없기때문에 성공했는지 실패했는지
	//0과1값만 보내준다 컨트롤러까지 보내줘야하기때문에 타입이 void에서 int로 바뀜
	//insert 성공시 ReplyMapper.java로부터 1을
	//insert 실패시 ReplyMapper.java로부터 0을
	//값을 리턴받는다
	public int write(ReplyDTO rdto) {
		return rmapper.write(rdto);
	}
	
	//댓글목록리스트 -구현
	public ArrayList<ReplyDTO> list(int bno){
		return rmapper.list(bno);
	}
	
	//댓글수정을 하기위해 댓글내용 가져오기 -구현
	public ReplyDTO detail(int rno) {
		return rmapper.detail(rno);
	}
	
	//댓글수정 설계 -구현
	//성공하면1아니면 0값을 가져와야하기때문에 int타입가지고온다
	public int update(ReplyDTO rdto) {
		return rmapper.update(rdto);
	}
	
	//댓글삭제 설계 -구현
	//성공하면1아니면 0값을 가져와야하기때문에 int타입가지고온다
	public int remove(ReplyDTO rdto) {
		return rmapper.remove(rdto);
	}

}
