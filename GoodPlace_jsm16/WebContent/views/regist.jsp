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
			<h1 class="display-4">모금함 등록</h1>
			<!-- <p class="lead fw-normal mb-0">Good Place</p> -->
		</div>
	</div>
</header>
<body>
	<div id="wrap" align="center"
		style="margin-top: 50px; margin-bottom: 50px;">
		<form method="post" enctype="multipart/form-data" name="R"
			action="goodRegist.good">
			<table>
				<tr>
					<th>카테고리 :</th>
					<td><input class="form-control" type="text" name="p_category"
						required></td>
				</tr>
				<tr>
					<th>제 목:</th>
					<td><input class="form-control" type="text" name="p_title"
						size="80" required></td>
				</tr>
				<tr>
					<th>목표액 :</th>
					<td><input class="form-control" type="text" name="p_price" placeholder="숫자만 입력해주새요."
						required oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');"></td>

				</tr>
				<tr>
					<th>사 진:</th>
					<td><input class="form-control" type="file" name="p_img"
						required></td>
				</tr>
				<tr>
					<th>모금기간 :</th>
					<td><input class="form-control" type="text" name="p_period"
						required></td>
				</tr>
				<tr>
					<th>모금기관 :</th>
					<td><input class="form-control" type="text" name="p_inst"
						required></td>
				</tr>
				<tr>
					<th>설 명:</th>
					<td><textarea class="form-control" cols="80" rows="10"
							name="p_desc" required></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" value="등록" class="btn mb-3"
				style="background-color: #AFD485"> <input type="reset"
				value="다시작성" class="btn mb-3 " style="background-color: #AFD485">
			<input type="button" value="목록"
				onclick="location.href='goodList.good'" class="btn mb-3"
				style="background-color: #AFD485">
		</form>
	</div>

	<%@ include file="./footer.jsp"%>
</body>
</html>