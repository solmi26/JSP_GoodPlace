<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../resources/css/login.css" rel="stylesheet" />
<script type="text/javascript" src="../resources/js/goodPlace.js"></script>
<title>Insert title here</title>
</head>
<%@ include file="./header.jsp"%>
<header class="py-5" style="background-color: #AFD485 !important">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-black">
			<h1 class="display-4">"당신의 선한 영향력을 사회에 전해주세요."</h1>
			<!-- <p class="lead fw-normal mb-0">Good Place</p> -->
		</div>
	</div>
</header>
<body>

	<div class="register-container">
		<div id="register-article">
			<div class="register-title">
				<h2>로그인</h2>
			</div>
			<form action="login.good" method="post">


				<div class="input-box">
					<input id="username" type="text" name="m_id" placeholder="아이디" required="required">
					<label for="username">아이디</label>
				</div>

				<div class="input-box">
					<input id="password" type="password" name="m_pw" required="required"
						placeholder="비밀번호"> <label for="password">비밀번호</label>
				</div>
				<!-- 				<div id="forgot">
					<a href="#">비밀번호 찾기</a>
				</div> -->
				<div class="register-util1" style="text-align: right;">
					<button type="button" id="find" onclick="alert('아직 미구현 기능입니다. 죄송합니다.')">아이디/비밀번호 찾기</button>
	

					<button id="isDuplication" type="button" onclick="location.href='./join.jsp'">
						회원가입</button>
				</div>

				<div style="text-align: center;">
					<input id="submit" type="submit" class="btn btn-lg" value="로그인"
						 />

				</div>
			</form>
		</div>
	</div>
		<c:if test="${!empty message}">
		    
		<script type="text/javascript">
		window.onload = reload();
		function reload(){
			alert(`${message}`);
		}

		</script>
	</c:if>
	<%@ include file="./footer.jsp"%>
</body>
</html>