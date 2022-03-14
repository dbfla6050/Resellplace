
$(document).ready(function(){
	
	//+버튼을 눌렀을때 수량이 증가하면서 total값을 증가시켜라
	//var quantity=1;
	$(".js-btn-plus").on("click",function(){
		// total = Price * Quantity
		var price=$(this).data("price");
		var cno=$(this).data("cno");
		var quantity=Number($("#quantity"+cno).val())+1;
		
		$("#total"+cno).val(price * quantity)
		
		//+를 눌렸을때 전체 total값이 변하도록
		//함수 실행
		showTotal();
	})
	
	
	//-버튼을 눌렀을때 수량이 감소하면서 total값을 감소시켜라
	$(".js-btn-minus").on("click",function(){
		// total = Price * Quantity
		var price=$(this).data("price");
		var cno=$(this).data("cno");
		var quantity=Number($("#quantity"+cno).val())-1;
		
		$("#total"+cno).val(price * quantity)
		
		//-를 눌렸을때 전체 total값이 변하도록
		//함수 실행
		showTotal();
	})
	
	

	
	//cart.jsp을 눌렸을때 바로 화면에 전체total값을 띄워야함,그래서 호출을여기에 해야함
	//함수로 묶으면 호출부였던게 선언부가되서 여기에 따로 호출을 해줘야한다
	showTotal();
	
	
	//함수선언
	//여러군데 사용되기때문에 함수로 묶어준다,
	//함수로 묶으면 호출부였던게 선언부가되서 따로 호출을 해줘야한다	
	function showTotal(){
		//전체 total값을 띄워라
		var plus=0;
		$(".total").each(function(){
		  var totalC = $(this).val();
		  plus += parseInt(totalC);
		  console.log(plus);
		  
		  $("#cartTotal").val(plus)
		});
	}
	
	
	
	
	
	//주문하기를 누르면 alert창 띄우고 메인으로 돌아간다
	var formObj=$("form[role='form']")
	$("#order").on("click",function(e){
		e.preventDefault();
		
		formObj.submit();
		alert("주문되었습니다.")
	})

	
	
	//장바구니에서 상품삭제 버튼을 클릭하면
	$(".btn-sm").on("click",function(){
		var cno= $(this).data("cno")
		//alert(cno)
		
		//장바구니 상품삭제함수를 호출해서 처리
		cartRemove({cno:cno},function(remove){
			//콜백영역(delete가 정상적으로 처리된 후 조치)
			alert("delete작업"+remove)
			location.reload();
			
		})
	}) //장바구니에서 상품삭제 버튼을 클릭하면
	

})







//장바구니 상품삭제를 하기 위한 함수 선언
function cartRemove(remove,callback){
	$.ajax({
		url:"/resellplace/cartRemove",         //resellplace/cartRemove 컨트롤러로 보냄
		type:"delete",
		data:JSON.stringify(remove),  //자바스크립트를 json타입으로바꿔서 자바로 넘겨준다
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
	
	return {cartRemove:cartRemove}
}











