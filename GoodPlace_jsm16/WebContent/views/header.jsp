<%@page import="dto.Cart"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link
	href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<link href="../resources/css/styles.css" rel="stylesheet" />
<style type="text/css">
* {
	font-family: 'IBM Plex Sans KR', sans-serif;
}
</style>
<title>Good Place</title>
</head>
<body>

	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg"
		style="border-bottom: 2px solid #14AE5C;">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="./goodList.good"> <img id="logo"
				src="../resources/img/logo.png" width="50" height="50" alt="홈페이지 로고">
				<span class="fw-bold"
				style="color: #086C37; background-color: #EBF5E0">굿 플레이스</span></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="./goodList.good" style="color: black;">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./commingsoon.jsp" style="color: black;">펀딩</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./commingsoon.jsp" style="color: black;">굿액션</a></li>
					<li class="nav-item"><a class="nav-link" href="./regist.jsp"
						style="color: black;">모금함 등록</a></li>
					<!--  <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: black;">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!" >All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li> -->
				</ul>
				<c:if test="${empty loginUser}">
				<div style="margin-right: 10px; text-align: center;">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" style="padding-top: 12px">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="./login.jsp" style="color: black;">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="./join.jsp"
							style="color: black;">Join</a></li>

					</ul>
				</div>
				</c:if>
				<c:if test="${!empty loginUser}">
				<div style="margin-right: 10px;  text-align: center;">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" style="padding-top: 12px">
						<li class="nav-item"><p class="nav-link active">안녕하세요.${loginUser.m_nickname}님</p></li>
								<li class="nav-item"><a class="nav-link" href="./logout.good"
							style="color: black;">Logout</a></li>
						<li class="nav-item"><a class="nav-link" href="./myPage.jsp"
							style="color: black;">Mypage</a></li>

					</ul>
				</div>
				</c:if>
				<form class="d-flex">
					<button class="btn btn-outline-dark" type="button"
						onclick="location.href='goodCartList.good'">
						<c:if test="${cartList != null}">
							<i class="bi-cart-fill me-1"></i>
						Cart <span class="badge bg-dark text-white ms-1 rounded-pill">${cartList.size()}</span>
						</c:if>
												<c:if test="${cartList == null}">
							<i class="bi-cart-fill me-1"></i>
						Cart <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
						</c:if>
					</button>
				</form>
			</div>
		</div>
	</nav>
	<!--         Header
        <header class="py-5" style="background-color: #AFD485 !important">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-black">
                    <h1 class="display-4">"당신의 선한 영향력을 사회에 전해주세요."</h1>
                    <p class="lead fw-normal mb-0">Good Place</p>
                </div>
            </div>
        </header> -->
	<!-- <div  class="jumbotron jumbotron-fluid" style="background-color: #AFD485 !important"> 
	<div class="container text-center">
	<h1 class="display-2 ">&nbsp</h1>
	<h1 class="display-2">"당신의 선한 영향력을 사회에 전해주세요."</h1>	
	<h1 class="display-2">&nbsp</h1>
	
</div> -->

	<!-- style="background-color: #7DB249;" -->
	<!-- <nav class="navbar navbar-expand" style="border-bottom: 2px solid #14AE5C;"> 네이게이션 바 만들기
<div class="container-fluid"> 내용 삽입
<div class="navbar-header"> 헤더
<a class="navbar-brand" href="./index.jsp"> <img id="logo" src="../resources/img/logo.png" width="50" height="50" alt="홈페이지 로고">
                    <span class="fw-bold"  style="color: #086C37;  background-color: #EBF5E0">굿 플레이스</span></a></div>
</div>
</nav>
 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>