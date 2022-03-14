package org.pyr.controller;

import java.util.ArrayList;

import org.pyr.domain.ReplyDTO;
import org.pyr.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Rest Controller방식(비동기식)으로 호출하는 경우 데이터 자체를 전송하는 방식으로 처리
//화면이 없다
//정상적으로 처리가 되었는지 비정상적으로 처리가 되었는지에 대한
//결과를 ResponseEntity타입을 통해서 알수 있음
@RequestMapping("resellplace/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService rservice;
	
	//댓글쓰기를 해서 데이터베이스에 insert하기
	//consumes,produces을 쓰게 되면 Mapping을 할때 우리가 원하는 데이터 타입을 강제함으로써 오류상황을 줄일 수 있다
	//consumes : ajax에서 들어오는 데이터타입 정의 (생략가능)
	//produces : 반환하는 데이터 타입 정의(생략가능)
	//생략을 하게되면 웹브라우저가 알아서 타입을 판단
	@PostMapping(value="new",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	//객체타입을 매개변수로 지정해야 되는 경우에는 @RequestBody를 사용해야 됨
	public ResponseEntity<String> create(@RequestBody ReplyDTO rdto){
		System.out.println("ReplyDTO="+rdto);
		
		//insert 성공시 ReplyServiceImpl.java로부터 1을
		//insert 실패시 ReplyServiceInpl.java로부터 0을
		//값을 리턴받는다
		int result=rservice.write(rdto);
		//값이 참이면 success라는 단어를 리턴한다,그래서 리턴타입이 string임
		return result==1? new ResponseEntity<>("success",HttpStatus.OK)  //insert가 정상적으로 처리되었을때
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  //insert가 비정상적으로 처리되었을때
	}
	
	//select해서 댓글들 가져오기
	//Rest Controller방식은 list/뒤에 바로 bno가 와도되도록 되어있다,원래는 list?bno=2....
	//@PathVariable : list/뒤에 바로 bno가 와도되도록 형식을바꿔줌, rest방식에서 주로 사용,url경로의 일부를 파라미터로 사용하고자할때
	@GetMapping(value="list/{bno}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ArrayList<ReplyDTO>> getList(@PathVariable int bno){
		System.out.println(bno);
		return new ResponseEntity<>(rservice.list(bno),HttpStatus.OK);
	
	}
	
	//댓글수정을 하기위해 댓글내용 가져오기
	@GetMapping(value="{rno}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyDTO> getDetail(@PathVariable int rno){
		System.out.println("detail rno="+rno);
		
		//여기서 rservice.list(rno)를 실행시키면 ReplyDTO모델에 데이터를 실어서 가지고온다 
		//하나씩 가지고오기때문에 arraylist는 필요없다
		return new ResponseEntity<>(rservice.detail(rno),HttpStatus.OK);
	}
	
	//수정한 댓글을 데이터베이스로 보내기
	@PutMapping(value="update",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update(@RequestBody ReplyDTO rdto){
		System.out.println("rdto="+rdto);
		//update 성공시 ReplyServiceImpl.java로부터 1을
		//update 실패시 ReplyServiceInpl.java로부터 0을
		//값을 리턴받는다
		int result=rservice.update(rdto);			
		//값이 참이면 success라는 단어를 리턴한다
		return result==1? new ResponseEntity<>("success",HttpStatus.OK)  //update가 정상적으로 처리되었을때
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  //update가 비정상적으로 처리되었을때
	}
	
	//댓글 데이터베이스에서 삭제시키기
	@DeleteMapping(value="remove",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@RequestBody ReplyDTO rdto){
		System.out.println("rdto="+rdto);
		//update 성공시 ReplyServiceImpl.java로부터 1을
		//update 실패시 ReplyServiceInpl.java로부터 0을
		//값을 리턴받는다
		int result=rservice.remove(rdto);			
		//값이 참이면 success라는 단어를 리턴한다
		return result==1? new ResponseEntity<>("success",HttpStatus.OK)  //update가 정상적으로 처리되었을때
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  //update가 비정상적으로 처리되었을때

	}
	
	
	
	
	
	
	
}
