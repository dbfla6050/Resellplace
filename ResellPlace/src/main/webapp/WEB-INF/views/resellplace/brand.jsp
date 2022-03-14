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
	<link rel="stylesheet" type="text/css" href="/resources/css/brand.css">
	
</head>
<body>
	<%@ include file="header.jsp" %>
	
	
	<div id="container">
            <div class="containerIn">
                <div class="mainslide">
                    <div class="slide-img">
                        <a href="#">슬라이드</a>
                    </div>
                </div> <!--.mainslide-->
                <p class="msname">Brand</p>

                <div class="contents">
                    <div class="bclick">
                        <a href="#">브랜드스토리</a>
                        <a href="#">CI/BI소개</a>
                    </div>

                    <div class="bStory">
                        <h2 class="brandh">브랜드 스토리</h2>
                        <p class="brandT1">Resell Place, 일상을 더욱 풍요롭게 하다.</p>
                        <p class="brandT2">
                            Resell Place는 개인의 개성과 일상의 기분을 존중하며, 
				                            자신의 취향을 마음껏 표현하고자 하는 소비자들이 명품을 보다 합리적인 가격으로 
				                            편리하게 구매할 수 있도록 돕는 온라인 명품 플랫폼 입니다. 
				                            언제나 아름다운 디자인과 높은 퀄리티의 상품을 편리하게 만날 수 있고, 
				                            누구나 합리적인 가격으로 오랫동안 지켜온 명품 브랜드만의 영감을 경험할 수 있습니다. 
				                            일상에 아름다운 디자인과 특별함을 더합니다. Resell Place에선 나의 일상이 더욱 풍요로워집니다.		
                        </p>
                    </div>

                    <ul>
                        <li class="bimg"><img src="/resources/img/brandC1.jpg" alt=""></li>
                        <li class="bimg"><img src="/resources/img/brandC2.jpg" alt=""></li>
                        <li class="bimg"><img src="/resources/img/brandC3.jpg" alt=""></li>
                    </ul>
                </div>
            </div><!--containerIn-->

        </div> <!--#container-->


	<%@ include file="footer.jsp" %>
</body>
</html>