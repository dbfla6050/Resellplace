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
	<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
</head>
<body>
	<%@ include file="header.jsp" %>
	
	
	<div id="container">
            <div class="mainslide">
                <div class="slide-img">
                    <a href="#">슬라이드</a>
                </div>
            </div> <!--.mainslide-->
            <p class="msname">Resell Place</p>
            <p class="mstxt1">Resell Place는 믿을 수 있는 중고 명품을 합리적으로 구매할 수 있는</p>
            <p class="mstxt2">No.1 온라인 명품플랫폼 입니다.</p>

            <div class="bestP">
                <h2>#Best Product</h2>
                <ul>
                	<c:forEach items="${bestproduct}" var="bProduct">
	                    <li>
	                        <a href="/resellplace/product/pdetail?uuid=${bProduct.uuid}">
	                            <p class="itemImg"><img src="/resellplace/product/display?fileName=${bProduct.fileName}"></p>
	                            <p class="itemBrand">${bProduct.brand}</p>
	                            <p class="itemName">${bProduct.pName}</p>
	                            <p class="itemPrice">${bProduct.price}</p>
	                        </a>
	                    </li>
                    </c:forEach>
                </ul>

                <p class="more">
                    <a href="/resellplace/bestProduct">더보기<span><img src="/resources/img/icon_plus.png" alt=""></span></a>
                </p>
            </div>

            <div class="newP">
                <h2>#New Arrivals</h2>
                <ul>
                    <c:forEach items="${newproduct}" var="nProduct">
	                    <li>
	                        <a href="/resellplace/product/pdetail?uuid=${nProduct.uuid}">
	                            <p class="itemImg"><img src="/resellplace/product/display?fileName=${nProduct.fileName}"></p>
	                            <p class="itemBrand">${nProduct.brand}</p>
	                            <p class="itemName">${nProduct.pName}</p>
	                            <p class="itemPrice">${nProduct.price}</p>
	                        </a>
	                    </li>
                    </c:forEach>
                </ul>

                <p class="more">
                    <a href="/resellplace/newArrivals">더보기<span><img src="/resources/img/icon_plus.png" alt=""></span></a>
                </p>
            </div>

            <div class="magazine">
                <h2>#magazine</h2>
                <ul>
                    <li>
                        <a href="#">
                            <span class="mTxt1">Weekly Pick</span>
                            <span class="mTxt2">2022 Feb 02</span>
                            <img src="/resources/img/magazine1.png" alt="">
                            <p class="mTxt3">밸런타인데이를 위한 남자친구 선물 아이템</p>
                        </a>
                    </li>

                    <li>
                        <a href="#">
                            <span class="mTxt1">Weekly Pick</span>
                            <span class="mTxt2">2022 Feb 04</span>
                            <img src="/resources/img/magazine2.png" alt="">
                            <p class="mTxt3">올해의 로고플레이 아이템</p>
                        </a>
                    </li>
                </ul>
            </div>

        </div> <!--#container-->


	<%@ include file="footer.jsp" %>
</body>
</html>