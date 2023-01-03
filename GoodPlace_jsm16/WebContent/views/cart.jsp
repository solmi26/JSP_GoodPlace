<%@page import="dto.Cart"%>
<%@page import="dto.Product"%>
<%@page import="dao.GoodDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../resources/js/goodPlace.js"></script>
<title>장바구니</title>
<style type="text/css">
/* #listForm {
	width: 1000px;
		text-align: center;

} */
h2 {
	text-align: center;
}

thead, tbody, tfoot, tr, td, th {
	border-color: inherit important;
	border-style: solid important;
	border-width: 0.1 important;
	padding: 10px 15px;
}

table {
	width: 1200px;
	border: 1px solid;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	font-size: 16pt;
}

.tr_top {
	background-color: #AFD485;
	height: 50px;
}

.div_empty {
	text-align: center;
}

.td_command {
	text-align: right;
}

#cartImage {
	width: 70px;
	height: 70px;
	border: none;
}

#select {
	text-align: right;
}

#commandList {
	text-align: center;
}
</style>
</head>
<body>
<% int totalPrice=0; %>
	<%@ include file="./header.jsp"%>
	<header class="py-5" style="background-color: #AFD485 !important">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-black">
				<h1 class="display-4">장바구니</h1>
				<!-- <p class="lead fw-normal mb-0">Good Place</p> -->
			</div>
		</div>
	</header>
	<div style="margin: 50px"></div>
	<!-- 	<div id="listForm"> -->
	<c:if test="${cartList != null && cartList.size()>0}">
	<form method="post">
		<table>
			<tr class="tr_top">
				<td><input type="checkbox" id="allCheck" name="allCheck"
					onclick="checkAll(this.form)" /></td>
				<td>번호</td>
				<td>이미지</td>
				<td>제목</td>
				<td>모금기관</td>
				<td>기부금액</td>
			</tr>
				<c:set var = "total" value = "0" />
				<c:forEach var="cart" items="${cartList}" varStatus="status">

					<tr class="border-1">
						<td><input type="checkbox" id="remove" name="remove"
							value="${cart.c_title}" /></td>
						<td>${status.index+1}<!-- 번호값계산 -->
						</td>
						<td><img src="../resources/img/${cart.c_image }"
							id="cartImage" /></td>
						<td>${cart.c_title}</td>
						<td>${cart.c_inst}</td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${cart.c_price }" />원</td>
						<c:set var= "total" value="${total + cart.c_price}"/>
					</tr>
					
				</c:forEach>
				<tr style="text-align: right;">
					<td colspan="6" style="padding: 10px 15px">총 금액 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${total}" />원
						<button type="submit" class="btn btn-md"
							style="background-color: #AFD485; margin-bottom: 0px important"
							formaction="goodCartRemove.good">삭제</button> <!-- 				<input
					type="submit" value="삭제" formaction="goodCartRemove.good" /> -->
					</td>
				</tr>
				<!-- 			<tr style="text-align: right">
				<td colspan="6" >
					<button type="submit" class="btn mb-3 btn-md"
						style="background-color: #AFD485" onclick="location.href='goodCartRemove.good'">삭제</button>
					</td>
			</tr> -->
		

		</table>

	</form>
		</c:if>
	<c:if test="${cartList.size()==0 || cartList == null }">
		<div class="div_empty">
			<img src="../resources/img/cart.jpg"
				style="width: 500p; height: 300px" />
		</div>
	</c:if>


	<nav id="commandList" style="margin-top: 30px">
		<button type="submit" class="btn mb-3 btn-lg"
			style="background-color: #AFD485"
			onclick="location.href='goodList.good'">쇼핑 계속하기</button>
		<!-- 	<a href="goodList.good">쇼핑 계속하기</a> -->
			<button type="submit" class="btn mb-3 btn-lg"
			style="background-color: #AFD485; width: 146px"
			onclick="cash()">결제하기</button>
			<script type="text/javascript">
			function cash(){
				alert(`결제되었습니다. 감사합니다.`);
				location.href='cash.good'
			}
			</script>
	
	</nav>
	<!-- 	</div> -->
	<div style="margin: 50px"></div>
	<%@ include file="./footer.jsp"%>
</body>
</html>