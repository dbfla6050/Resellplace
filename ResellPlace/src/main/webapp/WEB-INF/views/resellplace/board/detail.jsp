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
	<link rel="stylesheet" type="text/css" href="/resources/css/detail.css">
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="/resources/js/detail.js"></script>
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

                <div class="contents">
                    <h3>게시판</h3><input type="hidden" id="session" value="${login}">
                    <div class="btn_m"><a href="/resellplace/board/remove?bno=${detail.bno}">삭제</a></div>
                    <table>
                        <tr>
                            <th>${detail.title}</th>
                        </tr>
                        <tr>
                            <td class="writer">
                            	<span>게시판번호 : </span><span id="bno">${detail.bno}</span>
                                <span>작성자 : ${detail.writer} </span>
                                <span class="w_r">등록일 : ${detail.regdate}</span>
                                <span class="w_rr">조회수 : ${detail.cnt}</span>
                            </td>
                        </tr>
                        <tr class="con">
                            <td>
								${detail.content}
                            </td>
                        </tr>
                    </table>
                    <div class="btn">
                        <div class="btn_r"><a href="/resellplace/board/modify?bno=${detail.bno}">수정</a></div>
                        <div class="btn_l"><a href="/resellplace/board/list">목록보기</a></div>
                    </div>
                    
                    <!-- 댓글목록을 화면에 뿌린다 -->
			        <div>
			        	<ul id="relist"></ul>
			        </div>
                    
                    <div>
	               		<label>Replyer</label>
	               		<input type="text"  name="replyer">
	                </div>
	               
	                <div>
	               		<textarea rows="7" cols="122" name="reply"></textarea>
	                </div>
	               
	                <div>
	               		<button id="replyBtn" type="button">댓글 등록</button>
	                </div>
                    
                    
                    <div class="beforeAfter">
                        <ul>
                        	<c:if test="${detailPrev !=null}">
	                            <li>
	                                <a href="/resellplace/board/detail?bno=${detail.bno-1}">
	                                    <span class="ba_l">이전글</span>
	                                    <span class="ba_r">${detailPrev.title}</span>
	                                </a>
	                            </li>
                            </c:if>
                            
                            <c:if test="${detailNext !=null}">
	                            <li>
	                                <a href="/resellplace/board/detail?bno=${detail.bno+1}">
	                                    <span class="ba_l">다음글</span>
	                                    <span class="ba_r">${detailNext.title}</span>
	                                </a>
	                            </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div><!--containerIn-->

        </div> <!--#container-->


	<%@ include file="../footer.jsp" %>
</body>
</html>