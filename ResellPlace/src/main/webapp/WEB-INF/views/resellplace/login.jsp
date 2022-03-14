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
	<link rel="stylesheet" type="text/css" href="/resources/css/login.css">
</head>
<body>
	<%@ include file="header.jsp" %>
	
	
	<div id="container">
            <div id="loginBox">
                <form action="/resellplace/login" method="post" id="login">
                    <div id="box">
                        <div id="id">
                            <p class="subTxt1">
                                id
                            </p>
                            <p>
                                <input name="id" type="text" id="inputBox">
                            </p>
                            
                        </div>
                        <div id="password" >
                            <p class="subTxt2">
                                Password
                            </p>
                            <p>
                                <input name="password" type="password" id="inputBox">
                            </p>
                        </div>
                    </div>
                    <button class="btnLogin" type="submit">LOGIN</button>
                </form>
            </div>
            
        </div> <!--#container-->


	<%@ include file="footer.jsp" %>
</body>
</html>