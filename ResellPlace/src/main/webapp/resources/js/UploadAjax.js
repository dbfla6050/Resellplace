
$(document).ready(function(){
	
	//파일의 크기와 확장자를 검사하는 함수선언
	//서버에서 설정해놓은 파일크기 설정
	var maxSize=5242880;
	//서버에서 허용불가능한 확장자 설정(정규식), 정규식 : 검증이 필요할때
	var regex= new RegExp("(.*?)\.(exe|sh|zip|alz)$")
	
	function checkExtension(fileSize,fileName){
		//사용자가 선택한 파일의 크기가 서버에서 설정해놓은 파일의 크기보다 이상이면,
		if(fileSize>=maxSize){
			alert("파일사이즈초과");
			return false;
		}
		
		//사용자가 선택한 파일의 확장자가 서버에서 설정해놓은 파일의 확장자와 일치하면
		if(regex.test(fileName)){
			alert("해당종류의 파일은 업로드 할 수 없습니다")
			return false;
		}
		
		//위의 두종류가 아니면  true값을 던져라
		return true;
	}
	
	
	
	
	
	
	//글쓰기 버튼을 클릭하면
	//form태그가 있기때문에 가상의 form태그는 안만들어줘도된다
	var formObj=$("form[role='form']")
	$("input[type='submit']").on("click",function(e){
		e.preventDefault();
		
		var str=""
			
		//각 li태그에 있는
		//여기서 obj는 li의 html을 얘기한다 
		$("#uploadResult ul li").each(function(i,obj){
			
			console.log(obj)
			//data선택자를 이용하여 input태그의 value값으로 셋팅
			//data함수
			//<span>
			//$("span").data("age",13) => <span data-age="13"> data함수 괄호안에 매개변수가 두개면 setter
			//<span data-age="13">
			//$("span").data("age") => data함수 괄호안에 매개변수가 두개면 getter
			
			//name='attachList["+i+"].fileName' : boardDTO에 attachList가 참조변수로 되어있음
			str+="<input type='hidden' name='fileName' value='"+$(obj).data("filename")+"'>"
			str+="<input type='hidden' name='uuid' value='"+$(obj).data("uuid")+"'>"
			str+="<input type='hidden' name='uploadPath' value='"+$(obj).data("path")+"'>"
		})	
		//밑에는 html을 쓰고 여기는 append를 쓰는이유 : html은 기존에있던거없애고 덮어쓰기되기때매, append는 기존에있던거밑에 추가가됨
		formObj.append(str).submit();
		//submit을 하면 내용이 write.jsp의 form의 액션으로 감 -> boardcontroller write로 이동
		
	})//글쓰기 버튼을 클릭하면
	
	
	
	
	
	
	
	//파일 선택의 내용이 변경되면
	$("input[type='file']").on("change",function(){
		//가상의 form태그,jsp의 form태그와같은 역활을해주는 객체
		//name을 사용하려면 form태그가 필요함
		var formData = new FormData();
		var inputFile=$("input[name='uploadFile']");
		
		//inputFile[0] : inputFile에 name='uploadFile'을 쓰면 배열로 저장되기때문에(name은 무조건 배열로 저장됨)[]씀
		//.files : html에 들어있는 내장객체
		//파일들을 불러와서 속성을 files에 저장시킨다
		var files=inputFile[0].files;
		
		console.log(files);
		
		for(var i=0;i<files.length;i++){
			//파일의 크기가 설정해놓은크기 이상이면
			//checkExtension : uploadAjax.jsp에 파일의 확장자와 크기를 설정하고,이를 검사하는 함수
			if(!checkExtension(files[i].size,files[i].name)){
				//밑에 있는거 하지마라
				return false;
			}
			//여기서 "uploadFile"은 <input type="file" name="uploadFile">의 name과 이름이 같아야한다
			formData.append("uploadFile",files[i]);
		}
		
		
		//ajax를 이용해서...
		//formData를 데이터로 전송할 때에는
		//processData과 contentType은 반드시 false여아함
		//왜냐면 processData:true이면 텍스트만 전송가능하고 processData:false여야지 텍스트와 파일등을 전송시킬수있다
		$.ajax({
			url:"/resellplace/product/uploadAjaxAction",
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			success:function(result){    //사용자가 선택한 경로에 성공적으로 업로드한 후....
				//showUploadedFile함수 호출
				showUploadedFile(result);
			}
		})//ajax 끝
	})//파일 선택의 내용이 변경되면 끝
	
})//$(document).ready(function() 끝





//사용자가 선택한 파일을 원하는 경로에 성공적으로 업로드 한 후 웹브라우저에 파일을 띄워라에 대한 함수 선언(showUploadedFile)
function showUploadedFile(uploadresultArr){
	var str="";
	//.each : 반복문,세번 반복해라                 인덱스번호,값(callback)
	$(uploadresultArr).each(function(i,obj){
		console.log(obj);
		
		//encodeURIComponent : \를 url형식에 맞게 바꿔줌
		var fileCallPath=encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName)
		
		//img태그를 사용해서 웹브라우저 이미지 출력
		//obj.uploadPath+"/"+obj.fileName -> 2022\01\19/aaa.png로나오기때문에 바꿔주야함
		//li에 data-path,data-uuid등 을 넣는이유는 li에 data선택자를 이용해 값을 넣어서 그값을 name에 넣어 나중에 글쓰기를 통해서 데이터베이스로 이동시키기위해서
		str+="<li data-path='"+obj.uploadPath+"'"
		str+="data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"'>" 
		str+="<img src='/resellplace/product/display?fileName="+fileCallPath+"'></li>"
	})
	console.log(str)
	//id가 uploadResult인것에 str을 뿌려라(html은 기존에있던거없애고 덮어쓰기됨)
	$("#uploadResult ul").html(str)
}













