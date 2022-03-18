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
	<link rel="stylesheet" type="text/css" href="/resources/css/product.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/product2.css">
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	
	<!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
            
            	<form action="/resellplace/cart" method="post" id="cart">
	                <div class="row gx-4 gx-lg-5 align-items-center">
	                	<input name="uuid" type="hidden" value="${productdetail.uuid}">
	                	<input name="pName" type="hidden" value="${productdetail.pName}">
	                	<input name="price" type="hidden" value="${productdetail.price}">
	                	<input name="id" type="hidden" value="${login.id}">
	                	
	                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="/resellplace/product/display?fileName=${productdetail.fileName}" alt="..." /></div>
	                    <div class="col-md-6">
	                        <div class="small mb-1">${productdetail.brand}</div>
	                        <h1 class="display-5 fw-bolder">${productdetail.pName}</h1>
	                        <div class="fs-5 mb-5">
	                            <span>${productdetail.price}원</span>
	                        </div>
	                        
	                        <div class="d-flex">
	                            <input name="quantity" class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
	                            <input type="submit" value="카트 담기" class="btn btn-outline-dark flex-shrink-0">
	                        </div>
	                    </div>
	                </div>
                </form>
            </div>
        </section>

	<%@ include file="../footer.jsp" %>
	
	<!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>