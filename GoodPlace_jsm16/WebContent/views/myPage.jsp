<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<%@ include file="./header.jsp"%>
	<header class="py-5" style="background-color: #AFD485 !important">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-black">
				<h1 class="display-4">마이페이지</h1>
				<!-- <p class="lead fw-normal mb-0">Good Place</p> -->
			</div>
		</div>
	</header>
<body>

	<div
		style="width: 2000px; height: 400px; text-align: center; margin-top: 150px; padding-right: 30px;">
		<button type="button" class="btn btn-lg btn-outline-success"
			style="width: 250px; height: 200px; margin-right: 30px"
			onclick="location.href='./memberUpdate.jsp'">회원정보수정</button>
		<button type="button" class="btn btn-lg  btn-outline-success"
			style="width: 250px; height: 200px; margin-right: 30px"
			onclick="deleteCheck()">회원탈퇴</button>
		<button type="button" class="btn btn-lg  btn-outline-success"
			style="width: 250px; height: 200px;"
			onclick="location.href='./orderList.jsp'">기부내역</button>
		<script type="text/javascript">
	
				function deleteCheck() {
					if (confirm("정말 삭제하시겠습니까?")) {
						location.href = "memberRemove.good?m_id=${loginUser.m_id}";
					}

				}

		</script>
	</div>
</body>
<%@ include file="./footer.jsp"%>
</html>