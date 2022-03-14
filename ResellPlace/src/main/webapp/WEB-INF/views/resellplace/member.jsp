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
	<link rel="stylesheet" type="text/css" href="/resources/css/member.css">
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="/resources/js/member.js"></script>
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
                <p class="msname">Resell Place</p>

                <div>
                    <h1>회원가입</h1>
                    <form action="/resellplace/member" method="post" id="target">
                        <legend>회원가입</legend>
                        <div><label>이름</label><input name="name" type="text"></div>
                        <div>
                            <label>아이디</label><input name="id" type="text" placeholder=" 8자 이상 12자 이하로 입력해주세요." id="id"><span id="idMsg"></span>
                        </div>
                        <div><label>비밀번호</label><input name="password" type="password" placeholder=" 8자 이상 12자 이하로 입력해주세요." id="pass"><span id="passMsg"></span></div>
                        <div><label>비밀번호확인</label><input type="password" id="compare"><p id="compareMsg"></p></div>
                        <div>
                        	<label>휴대폰</label>
                            <input name="phone" type="text" id="lastNum" placeholder=" -을 빼고 입력해주세요.">
                        </div>
                        
                        <div>
                            <label>이메일</label>
                            <input type="text" id="email1">@
                            <input type="text" id="email2">
                            <input type="hidden" name="email">
                            
                            <select id="select">
                                <option class="emailOp" value="">직접입력</option>
                                <option class="emailOp1" value="naver.com">naver.com</option>
                                <option class="emailOp2" value="gmail.com">gmail.com</option>
                                <option class="emailOp3" value="daum.net">daum.net</option>
                            </select>
                        </div>

                        <div class="sub_btn"><input type="submit" id="log" class="save" value="저    장"></div>
                    </form>
                </div>
            </div><!--containerIn-->

        </div> <!--#container-->


	<%@ include file="footer.jsp" %>
</body>
</html>