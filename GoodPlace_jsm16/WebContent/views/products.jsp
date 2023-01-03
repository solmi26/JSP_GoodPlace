<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="dto.Product"%>
<%@page import="db.JdbcUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
<title>상품</title>
</head>
<body>

	<section class="py-5" id="listForm">


		<div class="container px-4 px-lg-5 mt-5">
<nav class="navbar" style="margin-bottom: 10px">
  <div class="container-fluid justify-content-end">
    <form class="d-flex" action="goodSearch.good">
      <input class="form-control me-2" type="search" placeholder="제목" aria-label="Search" name="search">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>

<c:if test="${goodList != null}">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4justify-content-center">
				<c:forEach var="good" items="${goodList }" varStatus="status">
					<div class="col mb-5">

						<div class="card h-100" style="height: 100%">
							<!-- Product image-->
							<img class="card-img-top" src="../resources/img/${good.p_img}"
								alt="..." style="max-width:100%;height:100%;" 	 /> 
							<!-- Product details-->
							<div class="card-body p-4" style="height: 50%">
								<div class="text-center"  >
									<!-- Product name-->
									<h5 class="fw-bolder">${good.p_title}</h5>
									<!-- Product price-->
									<p></p>
									<h5>목표액: 
									<fmt:formatNumber type="number" maxFractionDigits="3" value="${good.p_price}" />
									원</h5>

								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent" >
								<!-- 상세보기 -->
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto" href="goodView.good?p_id=${good.p_id}">기부하기
										&raquo</a>
								</div>
							</div>
						</div>

					</div>
				</c:forEach>

			</div>
			</c:if>
			<c:if test="${goodList==null }">
			<div style="text-align: center"><img alt="" src="../resources/img/no_result.png" style=""></div>
			</c:if>

		</div>


	</section>







</body>
</html>