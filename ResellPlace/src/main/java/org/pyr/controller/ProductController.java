package org.pyr.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.pyr.domain.ProductDTO;
import org.pyr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;
  
@Controller
@RequestMapping("resellplace/product")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	
	// 상품등록페이지로 이동
	@GetMapping("pregist")
	public void regist() {
		System.out.println("resellplace/product/pregist");
	}
	
	// 상품등록 화면에서 글을 적고 등록버튼을 클릭하면 database로 저징된다
	@PostMapping("pregist")
	public String registPost(ProductDTO product) {
		System.out.println("regist post...."+ product);
		pservice.regist(product);
		//글을 다쓰면 상품리스트로 돌아온다
		return "redirect:/resellplace/product/plist";
	}
	
	//상품 리스트로 이동, 상품리스트에 데이터를 뿌린다
	@GetMapping("plist")
	public void plist(Model model) {
		System.out.println("resellplace/product/plist");
		
		//model함수를 써서 데이터베이스를 화면에 뿌린다
		//                  변수이름     데이터
		model.addAttribute("productlist", pservice.fileList());
	}
	
	//상품 상세페이지로 이동, 상세페이지에 데이터를 뿌린다
	@GetMapping("pdetail")
	public void pdetail(ProductDTO product, Model model) {
		System.out.println("resellplace/product/pdetail"+ product);
		//System.out.println("aaaaa="+ pservice.pdetail(product));
		//model함수를 써서 데이터베이스를 화면에 뿌린다
		//                  변수이름     데이터
		model.addAttribute("productdetail", pservice.pdetail(product));
	}
	
	
	
	
	
	//년/월/일 폴더의 생성하기 위한 폴더이름 추출하여 리턴
	//자바에는 날짜타입이없기때문에 String타입으로 한다
	private String getFolder() {
		//현재날짜를 추출(Tue Jan 18 09:34:09 KST 2022)
		Date date= new Date();
		
		//Tue Jan 18 09:34:09 KST 2022 -> 2022-01-18(yyyy-mm-dd형식으로 변경),
		//폴더만드는데에 시간은 필요없기때문에 시간은빼야한다
		//SimpleDateFormat : 날짜타입에대해 어떻게 출력시킬것인가에 대한 형식이 들어있는 클래스
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//문자타입으로 저장시킴
		//결과는 2022-01-18로 나옴 -> 폴더로 만들기위해서 2022\01\18로 바꿔야함
		String str=sdf.format(date);
		//-표시를 원화표시로 바꾸세요 ,2022\01\18이렇게 바뀜
		return str.replace("-",File.separator);
	}
	
	
	
	
	//ajax를 이용해서 파일업로드
	@PostMapping(value="uploadAjaxAction", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	//MultipartFile : 파일에관련된 dto,이것은 라이브러리 다운받으면 자동적으로 생ㅇ성되기때문에 따로 생성할필요없음
	//배열로 들어오기때문에 []사용해줘야함
	public ResponseEntity<ArrayList<ProductDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		//AttachFileDTO에 저장되는 값이 여러파일에 대한 값이면 배열로 처리가 되어야 하므로 ArrayList타입이 되어야함
		ArrayList<ProductDTO> list=new ArrayList<>();
				
		
		//파일업로드 할 경로지정
		String uploadFolder="C:\\resellplace_upload";
		
		//폴더 생성                                             (기존 경로,     현재경로) 를 결합
		File uploadPath = new File(uploadFolder,getFolder());
		
		//현재경로를 저장
		String uploadFolderPath=getFolder();
		
		System.out.println("uploadPath="+uploadPath);
		
		//현재 만들려고하는 폴더가 없으면 
		if(uploadPath.exists()==false) {
			//폴더 생성
			//mkdirs : make directory, 폴더를 만들어라
			uploadPath.mkdirs();
		}
		
		//MultipartFile : 파일업로드에 사용하는 스프링에서 제공하고있는 클래스
		//향상된 for문(타입이 배열일때만 사용)
		//      타입                        변수이름                    배열 
		for(MultipartFile multipartFile : uploadFile) {
			//productController에 있는 uploadAjaxAction에서 productDTO를 사용해서 값을 저장해야 되는데
			//이럴경우 productController에 productDTO가 없으면 사용앟수가 없다
			//그래서 productController에 productDTO를 포함시켜서 사용해야됨
			ProductDTO productdto= new ProductDTO();
			
			
			//사용자가 업로드 한 실제 파일이름
			System.out.println("업로드 파일이름="+multipartFile.getOriginalFilename());
			//사용자가 업로드 한 실제 파일크기
			System.out.println("업로드 파일 크기="+multipartFile.getSize()); 
			//사용자가 업로드 한 실제 파일형식
			System.out.println("업로드 파일 형식="+multipartFile.getContentType());   
			//실제파일명을 저장
			String uploadFileName=multipartFile.getOriginalFilename();
			
			
			//실제파일명(uploadFileName)을 productDTO클래스 참조변수(productdto)에 fileName에 저장(setFileName) 
			productdto.setFileName(uploadFileName);
			
			//실제 업로드경로(uploadFolderPath)을 productDTO클래스 참조변수(productdto)에 uploadPath에 저장(setUploadPath)
			productdto.setUploadPath(uploadFolderPath);
			
			//UUID : 중복이 되지않는 문자열을 생성
			//클래스 메소드라서 new없이 바로 호출됨
			UUID uuid = UUID.randomUUID();
			//UUID + "_" + getOriginalFilename()의 조합으로 파일명을 uploadFileName에 저장
			uploadFileName= uuid.toString()+"_"+uploadFileName;
			
			//실제 업로드경로(uuid.toString())을 productDTO클래스 참조변수(productdto)에 uuid에 저장(setUuid)
			//uuid가 UUID타입이라서 String타입으로 바꿔줘야함
			productdto.setUuid(uuid.toString());
			
			
			
			
			//uploadPath에 저장되어있는 경로로 실제 파일명 저장
			File saveFile = new File(uploadPath,uploadFileName);
			
			//실제로 파일을 만들어라
			//transferTo : 반드시 예외처리해서써라, 예외처리안하면 못쓴다
			try {
				//saveFile변수에 저장되어있는 폴더명으로 파일을 보내라
				multipartFile.transferTo(saveFile);
				
				//썸네일 파일을 생성하기전에 썸네일 파일 이름을 추출
				//FileOutputStream : 썸네일파일과 원본파일을 이어주는 통로개념, 썸네일 파일 이름을 추출해서 
				FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
				//getInputStream()함수통해서 다시가지고와서 썸네일을 생성함
				Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,500,500);
				//썸네일 종료(메모리공간 환수)
				thumbnail.close();
				
				list.add(productdto);
				
			} catch (Exception e) {
				e.printStackTrace();
			}//end try
			
		}//for문 end
		
		//통신상태가 정상적(HttpStatus.OK)이면 ArrayList(list)에 저장되어있는 값을 uploadAjax.js에 있는 ajax의 success로 보내라
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	//파일업로드한 파일타입이 이미지일때(.jpg,) 웹브라우저에 이미지를 띄우기위해서
	@GetMapping("display")
	//여기서 String fileName은 uploadajax.js의 114번째줄 fileName="+fileCallPath+"를 가지고 온것
	public ResponseEntity<byte[]> getFile(String fileName){
		System.out.println("url주소를 통한 fileName="+fileName);
		
		//파일이 저장된 경로
		File file = new File("C:\\resellplace_upload\\"+fileName);
		System.out.println("file="+file);
		
		ResponseEntity<byte[]> result=null;
		
		//byte[]로 이미지 파일의 데이터를 전송할때 브라우저에 보내는 MIME타입이 파일의 종류(jpg,png,xls,ppt)에 따라 달라집니다
		//이 부분을 해결하기 위해서 probeContentType()을 이용해서 적절한 MIME타입 데이터를 http의 헤더 메세지에 포함할수 있도록 처리
		//결국 웹페이지에서 이미지 파일인지 아닌지에 대해 판단하기위해 사용
		//이걸 판단하기위해서는 byte[]로밖에 안됨
		try {
			//HttpHeaders : 웹페이지에서 이미지파일인지 아닌지 알수있음
			//FileCopyUtils.copyToByteArray(file) 어떤 파일인지 확인할때 씀
			HttpHeaders header = new HttpHeaders();
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
}
