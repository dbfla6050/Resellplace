<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<div id="wrap">
        <header id="header">
            <div class="headerIn">
                <h1 class="logo">
                    <a href="/resellplace/main">resell place</a>
                </h1>

                <nav class="gnb">
                    <ul>
                        <li><a href="/resellplace/brand">BRAND</a></li>
                        <li><a href="/resellplace/product/plist">PRODUCT</a></li>
                        <li><a href="/resellplace/board/list">BOARD</a></li>
                    </ul>
                </nav>

                <div class="member">
                	<c:if test="${login!=null}">
	                    <ul>
	                    	<li><a href="#">${login.id} 님</a></li>
	                    	<li><a href="/resellplace/logout">Logout</a></li>
	                        <li class="sc1"><a href="#">검색하기</a></li>
	                        <li class="sc2"><a href="/resellplace/cart">장바구니</a></li>
	                    </ul>
                    </c:if>
                    
                    <c:if test="${login==null}">
	                    <ul>
	                        <li><a href="/resellplace/login">Login</a></li>
	                        <li><a href="/resellplace/member">Register</a></li>
	                        <li class="sc1"><a href="#">검색하기</a></li>
	                        <li class="sc2"><a href="/resellplace/cart">장바구니</a></li>
	                    </ul>
                    </c:if>
                </div>
            </div> <!--.headerIn-->
        </header> <!--#header-->