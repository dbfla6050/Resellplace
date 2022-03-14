<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ResellPlace</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/resources/css/pregist.css">
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="/resources/js/UploadAjax.js"></script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	
	<div id="container">
            <div class="containerIn">
                <div class="mainslide">
                    <div class="slide-img">
                        <a href="#">슬라이드</a>
                    </div>
                </div> <!--.mainslide-->
                <p class="msname">Resell Place</p>

                <div class="write">
                    <form role="form" action="/resellplace/product/pregist" method="post" id="">
                      <legend>상품 등록</legend>
                        <table>
                          <tr>
                            <td><input name="brand" type="text" placeholder="브랜드명을 입력해주세요." class="regist" id="brand"></td>
                          </tr>
                          <tr>
                            <td><input name="pName" type="text" placeholder="상품명을 입력해주세요." class="regist" id="name"></td>
                          </tr>
                          <tr>
                            <td><input name="price" type="text" placeholder="가격을 입력해주세요." class="regist" id="price"></td>
                          </tr>
                          <tr>
                            <td>
                            	<select name="productType" class="regist" id="productType">
                            		<option value="b">베스트상품</option>
                            		<option value="n">신상품</option>
                            		<option value="s">스테디셀러</option>                            	
                            	</select>
                            </td>
                          </tr>
                        </table>
                    </form>
                        
                        <input type="file" name="uploadFile" multiple>
                        <input type="submit" value="등록" class="sub">
                    
                    <div id="uploadResult">
						<ul></ul>
			  		</div>
		  
                </div>
            </div><!--containerIn-->

        </div> <!--#container-->


	<%@ include file="../footer.jsp" %>
</body>
</html>