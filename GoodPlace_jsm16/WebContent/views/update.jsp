<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
th {
	margin-right: 10px;
	padding-right: 10px;
}
td {
padding: 10px;
}
</style>
<title>Insert title here</title>
</head>
<%@ include file="./header.jsp"%>
<!-- Header-->
<header class="py-5" style="background-color: #AFD485 !important">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-black">
			<h1 class="display-4">모금함 수정</h1>
			<!-- <p class="lead fw-normal mb-0">Good Place</p> -->
		</div>
	</div>
</header>
<body>
	<div id="wrap" align="center"
		style="margin-top: 50px; margin-bottom: 50px;">
		<form method="post" enctype="multipart/form-data" name="R"
			action="goodUpdate.good?p_id=${good.p_id}">
			<table>
				<tr>
					<th>카테고리 :</th>
					<td><input class="form-control" type="text" name="p_category" value="${good.p_category}" ></td>
				</tr>
				<tr>
					<th>제 목:</th>
					<td><input class="form-control" type="text" name="p_title" size="80" value="${good.p_title}"></td>
				</tr>
				<tr>
					<th>목표액 :</th>
					<td><input class="form-control" type="text" name="p_price" placeholder="숫자만 입력가능합니다." value="${good.p_price}" oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');"></td>
				</tr>
				<tr>
					<th>사 진: </th>
					<td><input class="form-control" type="file" name="p_img" value="${good.p_img}">
					<input class="form-control" type="hidden" name="temp_img" value="${good.getP_img()}">
					</td>
				</tr>
				<tr>
					<th>모금기간 :</th>
					<td><input class="form-control" type="text" name="p_period" value="${good.p_period}"></td>
				</tr>
				<tr>
					<th>모금기관 :</th>
					<td><input class="form-control" type="text" name="p_inst" value="${good.p_inst}"></td>
				</tr>
				<tr>
					<th>설 명: </th>
					<td><textarea class="form-control" cols="80" rows="10" name="p_desc" >${good.p_desc}</textarea></td>
				</tr>
			</table>
			<br> <input type="submit" value="수정" class="btn mb-3"
						style="background-color: #AFD485"> <input type="button" value="목록"
				onclick="location.href='goodList.good'" class="btn mb-3"
						style="background-color: #AFD485">
		</form>
	</div>
	<%@ include file="./footer.jsp"%>
</body>
</html>