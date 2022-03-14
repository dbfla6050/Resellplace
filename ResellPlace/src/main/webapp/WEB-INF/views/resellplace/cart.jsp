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
    <link rel="stylesheet" type="text/css" href="/resources/css/cart.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="/resources/js/cart.js"></script>
	
	
	<link rel="stylesheet" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" href="/resources/css/magnific-popup.css">
    <link rel="stylesheet" href="/resources/css/jquery-ui.css">
    <link rel="stylesheet" href="/resources/css/owl.carousel.css">
    <link rel="stylesheet" href="/resources/css/owl.theme.default.css">

    <link rel="stylesheet" href="/resources/css/aos.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<%@ include file="header.jsp" %>
	
	
	<div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"> <strong class="text-black">Cart</strong></div>
        </div>
      </div>
    </div>
	
	<div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <form class="col-md-12" role="form" action="/resellplace/cart" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th class="product-thumbnail">Image</th>
                    <th class="product-name">Product</th>
                    <th class="product-price">Price</th>
                    <th class="product-quantity">Quantity</th>
                    <th class="product-total">Total</th>
                    <th class="product-remove">Remove</th>
                  </tr>
                </thead>
                <tbody>
                	<c:if test="${login!=null}">
	                	<c:forEach items="${cartlist}" var="cart">
			                  <tr>
			                    <td class="product-thumbnail">
			                      <input type="hidden" class="cno" name="cno" value="${cart.cno}">
			                      <img src="/resellplace/product/display?fileName=${cart.fileName}" alt="Image" class="img-fluid">
			                    </td>
			                    <td class="product-name">
			                      <h2 class="h5 text-black">${cart.pName}</h2>
			                    </td>
			                    <td><input id="price" class="price" type="text" value="${cart.price}" style="border:0 solid black" disabled></td>
			                    <td>
			                      <div class="input-group mb-3" style="max-width: 120px;">
			                        <div class="input-group-prepend">
			                          <button class="btn btn-outline-primary js-btn-minus" data-price="${cart.price}" data-cno="${cart.cno}"  data-quantity="${cart.quantity}" type="button">&minus;</button>
			                        </div>
			                        <input name="quantity" id="quantity${cart.cno}" type="text" class="form-control quantity" value="${cart.quantity}" readonly placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
			                        <div class="input-group-append">
			                          <button class="btn btn-outline-primary js-btn-plus" data-price="${cart.price}" data-cno="${cart.cno}" data-quantity="${cart.quantity}" type="button">&plus;</button>
			                        </div>
			                      </div>
			
			                    </td>
			                    <td><input id="total${cart.cno}" class="total" type="text" value="${cart.total}" disabled style="border:0 solid black"></td>

			                    <td><button data-cno="${cart.cno}" type="button" class="btn btn-primary height-auto btn-sm">X</button></td>
			                  </tr>
						</c:forEach>
					</c:if>
                  	
                </tbody>
              </table>
              <c:if test="${login==null}">
              	<div class="login">
					<p class="login1">로그인 해주세요</p>
					<a class="login2" href="/resellplace/login">로그인하기</a>
				</div>
              </c:if>
              
            </div>
          </form>
        </div>

        <div class="row">
          <div class="col-md-6">
            <div class="row mb-5">

              <div class="col-md-6">
              	<a href="/resellplace/product/plist" class="btn btn-outline-primary btn-sm btn-block">Continue Shopping</a>
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
                <label class="text-black h4" for="coupon">Coupon</label>
                <p>Enter your coupon code if you have one.</p>
              </div>
              <div class="col-md-8 mb-3 mb-md-0">
                <input type="text" class="form-control coupon" id="coupon" placeholder="Coupon Code">
              </div>
              <div class="col-md-4">
                <button class="btn btn-primary btn-sm px-4">Apply Coupon</button>
              </div>
            </div>
          </div>
          
          <div class="col-md-6 pl-5">
            <div class="row justify-content-end">
              <div class="col-md-7">
                <div class="row">
                  <div class="col-md-12 text-right border-bottom mb-5">
                    <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                  </div>
                </div>
                
                <div class="row mb-5">
                  <div class="col-md-6">
                    <span class="text-black">Total</span>
                  </div>
                  <div class="col-md-6 text-right">
                    <strong class="text-black"><input type="text" id="cartTotal" disabled style="border:0 solid black"></strong>
                  </div>
                </div>

                <div class="row">
                  <div class="col-md-12">
                    <button id="order" type="submit" class="btn btn-primary btn-lg btn-block">주문하기</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>


	<%@ include file="footer.jsp" %>
	  <script type="text/javascript" src="/resources/js/jquery-ui.js"></script>
	  <script type="text/javascript" src="/resources/js/popper.min.js"></script>
	  <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
	  <script type="text/javascript" src="/resources/js/owl.carousel.min.js"></script>
	  <script type="text/javascript" src="/resources/js/jquery.magnific-popup.min.js"></script>
	  <script type="text/javascript" src="/resources/js/aos.js"></script>
	  <script type="text/javascript" src="/resources/js/main.js"></script>
	  

</body>
</html>