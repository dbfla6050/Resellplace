

$(document).ready(function(){
	var actionForm=$("#target");
	
	$("#log").on("click",function(e){
		//폼태그<input type="submit">,<a href="">는 기본적으로 클릭하는 태그라서 클릭이벤트를 넣어도 
		//본인들의 클릭을 먼저실행하기때문에 클릭이벤트실행되지않는다 
		//e.preventDefault() : submit과 a태그의 기본적인 클릭을 중단시킨다
		e.preventDefault();
		
		var email1= $("#email1").val();
		var email2= $("#email2").val();
		
		$("input[name='email']").val(email1 + "@" + email2)
		
		actionForm.submit();
		alert("회원가입되었습니다")
		
	})
	
	
	//아이디 유효성검사
	$("#id").change(function(){
		if($("#id").val().length < 8 || $("#id").val().length > 12){
		    alert("아이디의 길이를 8자 이상 12자 이하로 만들어 주세요.");
			//$("#idMsg").html("아이디의 길이를 8자 이상 12자 이하로 만들어 주세요.") ;
			//$("#idMsg").css("color","red");
			$("#id").focus();
			$("#id").select();
		} 
	})
	
	
	//비밀번호 유효성검사
	$("#pass").change(function(){
		if($("#pass").val().length < 8 || $("#pass").val().length > 12){
		    alert("비밀번호를 8자 이상 12자 이하로 만들어 주세요.");
			//$("#idMsg").html("아이디의 길이를 8자 이상 12자 이하로 만들어 주세요.") ;
			//$("#idMsg").css("color","red");
			$("#pass").focus();
			$("#pass").select();
		} 
	})
	
	
	//비밀번호 다시한번 체크
	$("#compare").change(function(){
		if($("#compare").val()!=$("#pass").val()){
			alert("비밀번호가 다릅니다. 다시 확인해주세요.");
			$("#compare").focus();
			$("#compare").select();
		}
	})
	
	
	//이메일 형식 입력
	$("#select").change(function(){
		console.log($("#select").val());
		$("#email2").val($("#select").val())
		
		if($("#select").val().length>0){
			$("#email2").attr("disabled",true);
		}else{
			$("#email2").attr("disabled",false);
		}
	})
	
	
	
	
	
})