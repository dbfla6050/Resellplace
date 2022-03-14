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
	<link rel="stylesheet" type="text/css" href="/resources/css/bestProduct.css">
	
</head>
<body>
	<%@ include file="header.jsp" %>
	
	
	<div id="container">
            <h2>BEST PRODUCT</h2>
            <div class="product">
                <ul>
                	<c:forEach items="${bestList}" var="bList">
	                    <li>
	                        <a href="/resellplace/product/pdetail?uuid=${bList.uuid}">
	                            <p class="itemImg"><img src="/resellplace/product/display?fileName=${bList.fileName}"></p>
	                            <p class="itemBrand">${bList.brand}</p>
	                            <p class="itemName">${bList.pName}</p>
	                            <p class="itemPrice">${bList.price}</p>
	                        </a>
	                    </li>
                    </c:forEach>

                </ul>
            </div>

        </div> <!--#container-->


	<%@ include file="footer.jsp" %>
</body>
</html>