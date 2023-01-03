<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="dto.Product"%>
<%@page import="db.JdbcUtil"%>
<%@page import="dto.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="../resources/js/goodPlace.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<link rel="styleSheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
* {
	font-family: 'IBM Plex Sans KR', sans-serif;
}

td {
	padding-left: 20px;
	padding-bottom: 5px;
}

#sform {
	display: inline-block;
	text-align: center;
	margin-left: 1000px;
}

table {
	border-spacing: 0px;
	border-style: none;
	padding: 0px;
}
</style>
<title>상세보기</title>
</head>
<%@ include file="./header.jsp"%>
<header class="py-5" style="background-color: #AFD485 !important">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-black">
			<h1 class="display-4">${good.p_title}</h1>
			<!-- <p class="lead fw-normal mb-0">Good Place</p> -->
		</div>
	</div>
</header>
<body>

	<div id="wrap" align="center" style="margin: 30px; padding: 30px">
		<!-- 		<div style="float: right; width:100%; text-align:right; padding-right:150px;">
			<button type="submit" class="btn mb-3 btn-sm"
				style="background-color: #AFD485">수정</button>

			<button type="submit" class="btn mb-3 btn-sm"
				style="background-color: #AFD485">삭제</button>
		</div> -->
		<table>
			<tr>
				<th></th>
				<td style="text-align: right; padding: 0px">
					<button type="submit" class="btn mb-3 "
						style="background-color: #AFD485; margin-bottom: 0px"
						onclick="updateCheck()">수정</button>
						<script type="text/javascript">
							var m_class = '<c:out value="${loginUser.m_class}"/>';
							console.log(m_class);
							if (m_class == '' || m_class == 1) {
								function updateCheck() {
								alert(`권한이 없습니다. 관리자로 로그인해주세요.`)}
							} else {
								function updateCheck() {
									
										location.href = "goodUpdateForm.good?p_id=${good.p_id}";
									

								}

							}
						</script>
					<button type="submit" class="btn mb-3 "
						style="background-color: #AFD485; margin-bottom: 0px"
						onclick="deleteCheck()">삭제</button> <script type="text/javascript">
							var m_class = '<c:out value="${loginUser.m_class}"/>';
							console.log(m_class);
							if (m_class == '' || m_class == 1) {
								function deleteCheck() {
								alert(`권한이 없습니다. 관리자로 로그인해주세요.`)}
							} else {
								function deleteCheck() {
									if (confirm("정말 삭제하시겠습니까?")) {
										location.href = "./goodDelete.good?p_id=${good.p_id}";
									}

								}

							}
						</script>
				</td>
			</tr>
			<tr>
				<td><img src="../resources/img/${good.p_img}"
					style="width: 600px; height: 500px; margin-right: 30px; margin-left: 100px; padding-bottom: 0px; margin-bottom: 0px">
				<td>

					<table>
						<tr>
							<th>카테고리:</th>
							<td><input class="form-control" type="text" name="name"
								value="${good.p_category}" readonly="readonly"></td>
						</tr>
						<tr>
							<th>목표액:</th>
							<td><input class="form-control" type="text" name="price"
								value="<fmt:formatNumber type="number" maxFractionDigits="3" value="${good.p_price}" />원"
								readonly="readonly"></td>
						</tr>
						<tr>
							<th>모금기간:</th>
							<td><input class="form-control" type="text" name="name"
								value="${good.p_period}" readonly="readonly"></td>
						</tr>
						<tr>
							<th>모금단체:</th>
							<td><input class="form-control" type="text" name="name"
								value="${good.p_inst}" readonly="readonly"></td>
						</tr>
						<tr>
							<th>소개:</th>
							<td><textarea class="form-control" cols="90" rows="8"
									name="description" readonly="readonly">${good.p_desc}</textarea></td>
						</tr>

					</table>
				</td>
			</tr>
		</table>
		<form action="goodCartAdd.good" method="post" id="frm">
			<div class="row">
				<div class="input-group">
					<div class="input-group-text fw-bold" style="margin-left: 1050px;">기부하기(원):
					</div>
					<input type="text"
						class="col-sm-2 col-form-label col-form-label-lg" id="c_price"
						name="c_price"> <input type="hidden" name="p_id"
						value="${good.p_id}" />
					<div style="margin-left: 10px; margin-top: 10px">

						<%-- <button type="submit" class="btn mb-3 btn-lg"
						style="background-color: #AFD485"
						onclick="location.href='goodCartAdd.good?p_id=${good.p_id}'">장바구니</button> --%>
						<button type="button" class="btn mb-3 btn-lg"
							style="background-color: #AFD485" onclick="cartAdd()">장바구니</button>
						<script type="text/javascript">
							function cartAdd() {

								let val = document.getElementById("c_price").value;
								if (val == null || val == ""
										|| val == undefined || val == 0) {
									alert("1원 이상 후원가능합니다.");
									return false
								} else {
									document.getElementById("frm").submit();
								}
							}
						</script>
						<button type="button" class="btn mb-3 btn-lg"
							style="background-color: #AFD485" onclick="cash()">결제하기</button>
					</div>
					<!-- <script type="text/javascript">
						function cash() {
							alert(`결제되었습니다. 감사합니다.`);
						}
					</script> -->
								<script type="text/javascript">
							function cash() {

								let val = document.getElementById("c_price").value;
								if (val == null || val == ""
										|| val == undefined || val == 0) {
									alert("1원 이상 후원가능합니다.");
									return false
								} else {
									alert(`결제되었습니다. 감사합니다.`);
								}
							}
						</script>
				</div>



			</div>
		</form>


	</div>
	<%@ include file="./footer.jsp"%>
</body>
</html>