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
	<link rel="stylesheet" type="text/css" href="/resources/css/write.css">
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
                    <form action="/resellplace/board/write" method="post" id="target">
                      <legend>글쓰기</legend>
                        <table>
                          <tr>
                            <td><input name="title" type="text" placeholder="제목을 입력해주세요." class="title" id="tCount"></td>
                          </tr>
                          <tr>
                            <td><textarea name="content" id="text" cols="100" rows="15" placeholder="내용을 입력해주세요." class="text"></textarea></td>
                          </tr>
                        </table>
                        <p class="countTitle"><span id="countTi"></span>/100</p>
                        <p class="countText"><span id="countT"></span>/2000</p>
                        <input type="submit" value="등록" class="sub">
                    </form>
                </div>
            </div><!--containerIn-->

        </div> <!--#container-->


	<%@ include file="../footer.jsp" %>
</body>
</html>