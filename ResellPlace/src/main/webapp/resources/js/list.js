
$(document).ready(function(){
	
	var actionForm=$("#actionForm");
	//현재페이지 번호를 클릭햐면
	//form태그 안에 있는 값을 가져와라
	$(".paginate_button a").on("click",function(e){
		//a태그눌렀을때 안넘어가게 만듬
		e.preventDefault();
		//.paginate_button a의 href을 input[name='pageNum']에 넣어라
		actionForm.find("input[name='pageNum']").val($(this).attr("href"))
		//원래는 a태그자체가 클릭이벤트가있어서 바로 페이지를 넘기는데 
		//form태그안에 pageNum,amount,search,keyword가 다있기때문에 form을통해서 a태그를 실행시킨다
		//form은 action="/board/list"으로 list컨트롤러를 실행시키고 submit을 통해  criteria모델에 값을 저장시킨다
		//form통해서 a태그실행시키려면 자바스크립트가 필요해서 자바스크립트를 통해 a를 실행시키고 (원래는 a태그자체가 form으로 실행안되서 js씀)
		//form은 submit을 통해서 보내지만 a태그는 submit이 없기때문에 따로 submit을 실행시켜준다
		actionForm.submit();
	})
	
	//검색을 클릭하면 page가 1로 바뀐다
	$("input[type='submit']").on("click",function(e){
		//이 코드를 구현하는데는 필요없음 그러나 혹시 소스볼때나 사용가능
		e.preventDefault();
		//pageNum의 값을 1로 설정
		actionForm.find("input[name='pageNum']").val("1")
		actionForm.submit();
	})
	

	
})