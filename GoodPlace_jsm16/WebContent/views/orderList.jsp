<%@page import="dto.Cart"%>
<%@page import="dto.OrderList"%>
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
<title>구매목록</title>

</head>
<body>
<% int totalPrice=0; %>
	<%@ include file="./header.jsp"%>
	<header class="py-5" style="background-color: #AFD485 !important">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-black">
				<h1 class="display-4">기부 내역</h1>

			</div>
		</div>
	</header>
	<div style="text-align: center; margin-top: 50px" ><img alt="" src="../resources/img/noorder1.png" style="height: 700px"></div>
	
	<%@ include file="./footer.jsp"%>
</body>
</html>