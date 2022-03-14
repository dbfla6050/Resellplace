

$(document).ready(function(){
	// id속성이의 값이 session인 것을 선택한 값의 길이를 session변수에 저장
	var session=$("#session").val().length
	
	console.log(session)
	
	//bno값 가져오기
	//bno는 시작하자마자 들고오는거라서 이벤트밖에 있어야한다
	var bno=$("#bno").html()
	
	
	
	
	//상세페이지에서 댓글등록 버튼을 클릭하면
	$("#replyBtn").on("click",function(){
		//사용자가 입력한 댓글내용을 데이터베이스로 보낸다
		//그러기위해서는 댓글쓰기를 클릭했을때 reply와 replyer을 가지고와야한다
		var reply=$("textarea[name='reply']").val()
		console.log("reply="+reply);
		//사용자가 입력한 댓글작성자를 데이터베이스로 보낸다
		var replyer=$("input[name='replyer']").val()
		
		//add함수를 호출해라
		//replyService.add("댓글내용,"댓글작성자","게시판번호")
		//      ajax로 보내고자하는 json타입   
		replyService.add({reply:reply,replyer:replyer,bno:bno},//함수호출, json타입으로 보내기
				//callback함수호출(result값으로 success가 저장되어 뿌려짐)
				function(result){  //callback함수 호출
								alert("댓글이 저장되었습니다")
								$("input[name='replyer']").val("")
								$("textarea[name='reply']").val("")
								//목록리스트를 처리
								showList();
								}); 
		
	})//상세페이지에 댓글등록버튼을 클릭하면
		
	
	
	
	//detail.jsp을 눌렸을때 바로 화면에 댓글목록리스트가 실행되어야함,그래서 호출을여기에 해야함
	//함수로 묶으면 호출부였던게 선언부가되서 여기에 따로 호출을 해줘야한다
	showList();
		
	//함수선언
	//댓글리스트목록실행이 여러군데 사용되기때문에 함수로 묶어준다,
	//함수로 묶으면 호출부였던게 선언부가되서 따로 호출을 해줘야한다	
	function showList(){
		//댓글리스트 목록실행
		replyService.getList({bno:bno},function(list){
			//callback함수호출
			console.log(list); 
			
			var str="";
			//for문을 이용해 댓글리스트를 뿌림
			for(var i=0; i<list.length; i++){
				//댓글번호를 가지고오기위해서 rno추가
				str+="<li data-rno='"+list[i].rno+"' id='replyAll"+list[i].rno+"' class='replyA'><div id='replyer'><b>"+list[i].replyer+"</b></div>"
				str+="<div id='reply"+list[i].rno+"' contenteditable='false' class='replyP'>"
				str+="<textarea id='replyT"+list[i].rno+"' class='textA' name='reply' disabled rows='5' cols='122'>"+list[i].reply+"</textarea>"
				str+="</div>"
				str+="</li>"
				// 로그인이 되어 있으면
				if(session>0){
					// 밑에꺼 두개 생성
					str+="<button type='button' class='ModBtn' data-rno='"+list[i].rno+"' id='mod"+list[i].rno+"'>댓글 수정</button>"
					str+="<button type='button' class='RemoveBtn' data-rno='"+list[i].rno+"' id='RemoveBtn"+list[i].rno+"'>댓글 삭제</button>"
				}
				
			}
			
			//#relist에 html를 통해 댓글리스트를 뿌림
			$("#relist").html(str);
			
		})
		
	}//showList함수끝
		
		
	
		
	//댓글수정버튼을 누르면 
	//댓글내용을 가지고온다
	 $("#relist").on("click",".ModBtn",function(){ // 이벤트 델리게이트
		//rno값을 가져오기
		//date-rno : data선택자에서 rno를가져온다 
		//this : 내가선택한것에 대한 rno들고와라
		 var rno=$(this).data("rno");
		 
		//댓글수정을 하기위해 댓글내용 가져오기(rno번호가져오면 내용가져올수있음) 함수호출
		 replyService.reDetail(rno,function(detail){
			console.log(detail)
			 
			 
			$("#reply"+detail.rno).attr("contenteditable",true);
			$("#replyT"+detail.rno).attr("disabled",false);
			
			$("#reply"+detail.rno).css("height","100px");
			$("#reply"+detail.rno).css("border","1px solid #777");
			
			var str="";
			str+="<button type='button' class='cancel' id='cancel"+detail.rno+"'>취소</button>"
			str+="<button type='button' class='register' id='register"+detail.rno+"'>등록</button>"
			$("#replyAll"+detail.rno).append(str)
			
			//댓글쓰기 버튼을 클릭하면 댓글 글수정 버튼 비활성화
			$("#mod"+detail.rno).hide();
			$("#RemoveBtn"+detail.rno).hide();
			
			//register함수싫행
			//이함수로 댓글번호를 가지고와서 등록버튼누름
			register(detail.rno);
			//cancel함수싫행
			//댓글번호 가지고와서 취소버튼누름
			cancel(detail.rno);
			 
		 })
		 
	 })//댓글수정버튼을 누르면 
	 
	 
	 
	 
	 function register(rno){
		//댓글수정버튼을 클릭해서 수정한후 등록버튼을 누르면
		 $("#relist").on("click","#register"+rno,function(e){
			 e.preventDefault();
			 //alert("aa")
			 
			var reply=$("#replyT"+rno).val()
			//댓글수정함수를 호출해서 처리
			replyService.reupdate({rno:rno,reply:reply},function(update){
				//콜백영역(update가 정상적으로 처리된 후 조치)
				alert("update작업"+update)
				//목록리스트를 실행
				showList();
			})
			
		 })//댓글수정버튼을 클릭해서 수정한후 등록버튼을 누르면
	 }//register함수

	 
	 
	 function cancel(rno){
		//댓글수정버튼을 클릭하고 다시 취소버튼을 누르면
		 $("#relist").on("click","#cancel"+rno,function(e){
			 e.preventDefault();
			 //alert("rno="+rno)
			 $("#reply"+rno).attr("contenteditable",false);
			 $("#replyT"+rno).attr("disabled",true);
			 
			 $("#reply"+rno).css("height","80px");
			 $("#reply"+rno).css("border","none");
			 
			 //댓글수정버튼과 댓글삭제버튼 다시 보이게하기
			 $("#mod"+rno).show();
			 $("#RemoveBtn"+rno).show();
			 
			 //취소버튼과 등록버튼 숨기기
			 $("#cancel"+rno).hide();
			 $("#register"+rno).hide();
			 
			//목록리스트를 실행
			showList();
		 })
	 }

	 
	 
	 
	//댓글삭제버튼을 클릭하면
	 $("#relist").on("click",".RemoveBtn",function(){
		 //alert("rno=")
		//rno값을 가져오기
		//date-rno : data선택자에서 rno를가져온다 
		//this : 내가선택한것에 대한 rno들고와라
		 var rno=$(this).data("rno");
		 
		//댓글삭제함수를 호출해서 처리
		replyService.remove({rno:rno},function(remove){
			//콜백영역(delete가 정상적으로 처리된 후 조치)
			alert("delete작업"+remove)

			//목록리스트를 실행
			showList();
		})
	 
	 })//댓글삭제버튼을 클릭하면
	 
	 
	 

})//ready끝






//get - select(댓글 조회)
//post - insert(댓글 쓰기)
//put - update(댓글 수정)
//delete - delete(댓글 삭제)

//replyService 함수선언
//함수선언하는 이유 : 몇개의 함수를 묶으려고 함수만듬,쓰면 return타입을 한번에 할수있음,꼭안써도됨
	
var replyService=(function(){
	
	//댓글쓰기를 하기 위한 함수 선언
	//함수호출하면 선언부에서 데이터를 받아서 컨트롤러로 넘겨줌
	function add(reply,callback){
		console.log("reply.........")
		$.ajax({
			url:"/resellplace/replies/new",   //replies/new 컨트롤러로 보냄
			type:"post",
			data:JSON.stringify(reply),   //자바스크립트를 json타입으로바꿔서 자바로 넘겨준다
			contentType:"application/json; charset=utf-8",
			success:function(result){     //통신이 정상적으로 처리됬을때
				//통신이 성공했으면 후조치로 callback함수선언해서 화면 띄울수있도록 한다
				if(callback)
					//callback함수를 호출
					//컨트롤러에서 success를 불러와서 result값에 저장시켜서 호출부로  success를 보냄
					callback(result);
			},
			error:function(){             //통신이 비정상적으로 처리가 되어 error가 있으면
	        	
	 		}
		})
		
	}
	
	
	
	//댓글목록리스트를 가져오기위한 함수 선언
	//댓글목록리스트를 가져오기위해서는 bno값을 데이터베이스로 보내야한다
	//param : {bno:bno}이대로 다불러오기때문에 .bno를 통해 bno만 추출
	function getList(param,callback){
		var bno=param.bno;
		console.log(bno);
		
		//타입이 get일때만 $.getJSON쓸수있다, 이렇게쓰면 축약해서 사용가능
		//게시판번호에따라 댓글이 다르기때문에 bno를 가지고와야한다,
		//bno는 위에서 var bno=$("#bno").html();으로 불러왔었어서 그대로 사용
		//callback은 컨트롤러에서 ok사인떨어지면 콜백함수로가서 호출부로 리턴시켜 function(list){}여기에서 화면으로 뿌린다
		$.getJSON(
				"/resellplace/replies/list/"+bno+".json",
				function(data){
					if(callback)
						callback(data);
				})	
	}
	
	
	//댓글수정을 하기위해 댓글내용 가져오기 함수선언
	function reDetail(rno,callback){
		console.log(rno)
		var rno=rno;
		$.getJSON(
				"/resellplace/replies/"+rno+".json",
				function(data){
					if(callback)
						callback(data);
				})
	}
	
	
	
	
	//댓글수정을 하기 위한 함수 선언
	function reupdate(reply,callback){
		$.ajax({
			url:"/resellplace/replies/update",         //replies/new 컨트롤러로 보냄
			type:"put",
			data:JSON.stringify(reply),  //자바스크립트를 json타입으로바꿔서 자바로 넘겨준다
			contentType:"application/json; charset=utf-8",
			success:function(result){           //통신이 정상적으로 처리됬을때
				//통신이 성공했으면 후조치로 callback함수선언해서 화면 띄울수있도록
				//만약에 callback이 있으면
				if(callback)
				//callback함수를 호출
				//컨트롤러에서 success를 불러와서 result값에 저장시켜서 호출부로  success를 보냄
					callback(result);
	         }, 
	        error:function(){             //통신이 비정상적으로 처리가 되어 error가 있으면
	        	
	 		}
		})
	}
	
	
	
	//댓글삭제를 하기 위한 함수 선언
	function remove(reply,callback){
		$.ajax({
			url:"/resellplace/replies/remove",         //replies/new 컨트롤러로 보냄
			type:"delete",
			data:JSON.stringify(reply),  //자바스크립트를 json타입으로바꿔서 자바로 넘겨준다
			contentType:"application/json; charset=utf-8",
			success:function(result){           //통신이 정상적으로 처리됬을때
				//통신이 성공했으면 후조치로 callback함수선언해서 화면 띄울수있도록
				//만약에 callback이 있으면
				if(callback)
				//callback함수를 호출
				//컨트롤러에서 success를 불러와서 result값에 저장시켜서 호출부로  success를 보냄
					callback(result);
	         }, 
	        error:function(){             //통신이 비정상적으로 처리가 되어 error가 있으면
	        	
	 		}
		})
	}
	
	
	
	
	return {add:add,
			getList:getList,
			reDetail:reDetail,
			reupdate:reupdate,
			remove:remove}

	
})()












