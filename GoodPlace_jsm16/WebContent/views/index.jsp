<%@page import="dto.Cart"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
      rel="stylesheet"
    />
<link href="../resources/css/styles.css" rel="stylesheet" />
<style type="text/css">
* {
  font-family: 'IBM Plex Sans KR', sans-serif;
}
</style>
<title>Good Place</title>
</head>
<body>
<%@ include file="./header.jsp" %>
        <!-- Header-->
        <header class="py-5" style="background-color: #AFD485 !important">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-black">
                    <h1 class="display-4">"당신의 선한 영향력을 사회에 전해주세요."</h1>
                    <!-- <p class="lead fw-normal mb-0">Good Place</p> -->
                </div>
            </div>
        </header>
	<c:if test="${!empty message}">
		    
		<script type="text/javascript">
		window.onload = reload();
		function reload(){
			alert(`${message}`);
		}

		</script>
		</c:if>
<%@ include file="./products.jsp" %>


<%@ include file="./footer.jsp" %>
</body>
</html>