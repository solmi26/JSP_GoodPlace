<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link href="../resources/css/join.css" rel="stylesheet" />
<title>회원가입</title>

</head>
<body>
	<%@ include file="./header.jsp"%>
	<header class="py-5" style="background-color: #AFD485 !important">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-black">
				<h1 class="display-4">회원가입</h1>
				<!-- <p class="lead fw-normal mb-0">Good Place</p> -->
			</div>
		</div>
	</header>
	<form name="form" method="post" action="./join.good">
		<div class="register-container">
			<div id="register-article">
				<div class="register-title">
					<h2>가입 정보를 입력해 주세요.</h2>
				</div>

				<strong class="register-tf">아이디</strong>
				<div class="register-subtitle">
					<label for="m_id" class="register-lab"></label> <input
						class="register-input" type="text" id="m_id" placeholder="아이디 입력"
						name="m_id" />
					<div class="register-util1" style="text-align: center;">
						<span style="color: red; display: none;" class="idIsFalse">사용
							중인 아이디입니다.</span> <span style="color: green; display: none;"
							class="idIsTrue">사용 가능한 아이디입니다.</span>
					</div>
				</div>

				<strong class="register-tf">비밀번호</strong>
				<div class="register-subtitle">
					<label for="m_pw" class="register-lab"></label> <input
						class="register-input" type="password" id="m_pw"
						placeholder="비밀번호 입력(영문 대소문자와 숫자 및 특수문자를 포함한 8~16자리)" name="m_pw" />
					<input class="register-input" type="password" id="logo_confirmPwd"
						placeholder="비밀번호 재입력" name="confirmUserPwd" />
					<div class="register-util"></div>
				</div>

				<strong class="register-tf">전화번호</strong>
				<div class="register-subtitle">
					<label for="m_phone" class="register-lab"></label> <input
						class="register-input" type="tel" id="m_phone"
						placeholder="전화번호 입력 (010-0000-0000)" name="m_phone" />
					<div class="register-util1" style="text-align: center;">  
						<span style="color: red; display: none;" class="phIsFalse">이미 가입된 전화번호입니다.</span> <span style="color: green; display: none;"
							class="phIsTrue">사용 가능한 전화번호입니다.</span>
					</div>
				</div>

				<strong class="register-tf">이메일</strong>
				<div class="register-subtitle">
					<label for="m_email" class="register-lab"></label> <input
						class="register-input" type="email" id="m_email"
						placeholder="이메일 입력 (*@*.*)" name="m_email" />
					<div class="register-util1" style="text-align: center;">
						<span style="color: red; display: none;" class="emailIsFalse">
						
							이미 가입된 이메일입니다.</span> <span style="color: green; display: none;"
							class="emailIsTrue">사용 가능한 이메일입니다.</span>
					</div>
				</div>

				<strong class="register-tf">닉네임</strong>
				<div class="register-subtitle">
					<label for="m_nickname" class="register-lab"></label> <input
						class="register-input" type="text" id="m_nickname"
						placeholder="닉네임 입력" name="m_nickname" />
					<div class="register-util1" style="text-align: center;">
						<span style="color: red; display: none;" class="nickIsFalse">사용
							중인 닉네임입니다.</span> <span style="color: green; display: none;"
							class="nickIsTrue">사용 가능한 닉네임입니다.</span>
					</div>
				</div>
				<div style="text-align: center;">
					<input id="submit" type="submit" class="btn btn-lg" value="가입하기"
						onclick="return checkAll()" />
				</div>
			</div>
		</div>
	</form>
	<c:if test="${!empty message}">
		    
		<script type="text/javascript">
		window.onload = reload();
		function reload(){
			alert(`${message}`);
		}

		</script>
	</c:if>
	<script type="text/javascript">
	$(function() {
		$(".idIsFalse .idIsTrue").hide();
	});
	$("input[name='m_id']").on("keyup keypress", function(e) {
		let m_id = $(this).val();
		console.log(m_id)
		$.ajax({
			url : "./idCheck.good",
			type : "post",
			data : {
				userID : m_id
			},
			success : function(res) {
				res = res.replace(/\s/gi, "");

				if (res == 0) {
					$(".idIsFalse").show();
					$(".idIsTrue").hide();
				} else {
					$(".idIsFalse").hide();
					$(".idIsTrue").show();
				}

			},
			error : function(request, status, error) {
				console.log(error);
			}
		});
	});

	</script>
	<script type="text/javascript">
	$(function() {
		$(".nickIsFalse .nickIsTrue").hide();
	});
	$("input[name='m_nickname']").on("keyup keypress", function(e) {
		let m_nickname = $(this).val();
		console.log(m_nickname)
		$.ajax({
			url : "./nickCheck.good",
			type : "post",
			data : {
				userNICK : m_nickname
			},
			success : function(res) {
				res = res.replace(/\s/gi, "");

				if (res == 0) {
					$(".nickIsFalse").show();
					$(".nickIsTrue").hide();
				} else {
					$(".nickIsFalse").hide();
					$(".nickIsTrue").show();
				}

			},
			error : function(request, status, error) {
				console.log(error);
			}
		});
	});

	</script>
	<script type="text/javascript">
	$(function() {
		$(".phIsFalse .phIsTrue").hide();
	});
	$("input[name='m_phone']").on("keyup keypress", function(e) {
		let m_phone = $(this).val();
		$.ajax({
			url : "./phoneCheck.good",
			type : "post",
			data : {
				userPH : m_phone
			},
			success : function(res) {
				res = res.replace(/\s/gi, "");

				if (res == 0) {
					$(".phIsFalse").show();
					$(".phIsTrue").hide();
				} else {
					$(".phIsFalse").hide();
					$(".phIsTrue").show();
				}

			},
			error : function(request, status, error) {
				console.log(error);
			}
		});
	});

	</script>
	<script type="text/javascript">
	$(function() {
		$(".emailIsFalse .emailIsTrue").hide();
	});
	$("input[name='m_email']").on("keyup keypress", function(e) {
		let m_email = $(this).val();
		$.ajax({
			url : "./emailCheck.good",
			type : "post",
			data : {
				userEMAIL : m_email
			},
			success : function(res) {
				res = res.replace(/\s/gi, "");

				if (res == 0) {
					$(".emailIsFalse").show();
					$(".emailIsTrue").hide();
				} else {
					$(".emailIsFalse").hide();
					$(".emailIsTrue").show();
				}

			},
			error : function(request, status, error) {
				console.log(error);
			}
		});
	});

	</script>
	<script type="text/javascript">
		
		// 정규표현식 선언
		var idPattern = /^[A-Za-z]{1}[A-Za-z0-9]{5,16}$/;
		var pwPattern = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
		var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{1,3}$/i;
		var phonePattern = /^01[016789]{1}-?([0-9]{4})-?([0-9]{4})$/;
		var nickPattern = /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣A-Za-z0-9]{2,20}$/;

		const m_id = document.getElementById("m_id");
		const m_pw = document.getElementById("m_pw");
		const confirmUserPwd = document.getElementById("logo_confirmPwd");
		const m_phone = document.getElementById("m_phone");
		const m_email = document.getElementById("m_email");
		const m_nickname = document.getElementById("m_nickname");

		//공백확인 함수
		function checkValue(value, dataName) {
			// 입력(value)로 들어온 값이 공백("")이면
			if (value == "") {
				// dataName을 입력해주세요 알림
				alert(dataName + " 입력해주세요!");
				// 함수 실행 중지
				return false;
			}
			return true;
		}

		//아이디 확인
		function checkID(id) {
			// 들어온 값이 공백일 시 함수 실행 중지
			// !((checkValue 값): false) -> !false -> true / if문 실행
			// !((checkValue 값): true) -> !true -> false / if문 통과
			if (!checkValue(id.value, "아이디를"))
				return false;
			// 정규표현식 유효성 검사
			// test는 유효성 검사 후 true, false 값을 반환한다.
			// test 값이 false일 시 실행
			if (!idPattern.test(id.value)) {
				// 경고창 발생
				alert("아이디는 영문 대소문자와 숫자 6~12자리로 입력해야 합니다!");
				// value값 초기화
				id.value = "";
				// 아이디 focus
				id.focus();
				// 함수 실행 중지
				return false;
			}
			//
			return true;
		}

		//비밀번호 확인
		function checkPwd(pwd, confirmPwd) {
			// 공백확인
			if (!checkValue(pwd.value, "비밀번호를"))
				return false;
			// 정규표현식 유효성 검사
			if (!pwPattern.test(pwd.value)) {
				alert("비밀번호는 영문 대소문자와 숫자 및 특수문자를 포함한 8~16자리로 입력해야 합니다!");
				pwd.value = "";
				pwd.focus();
				return false;
			}
			// 재입력한 패스워드가 처음 입력한 패스워드와 다를 때 사용하는 함수
			if (pwd.value != confirmPwd.value) {
				// 경고창
				alert("비밀번호가 같지 않습니다! 다시 입력해주세요!");
				// value값 초기화
				pwd.value = "";
				confirmPwd.value = "";
				// focus
				pwd.focus();
				return false;
			}

			return true;
		}

		//전화번호 입력
		function checkTel(tel) {
			if (!checkValue(tel.value, "전화번호를"))
				return false;

			if (!phonePattern.test(tel.value)) {
				alert("01x-xxxx-xxxx의 형식을 지켜주세요!");
				tel.value = "";
				tel.focus();
				return false;
			}
			return true;
		}
		//메일 확인
		function checkMail(mail) {
			if (!checkValue(mail.value, "메일을"))
				return false;

			if (!emailPattern.test(userMail.value)) {
				alert("메일 형식을 지켜주세요! ex) abc@naver.com");
				mail.value = "";
				mail.focus();
				return false;
			}
			return true;
		}
		// 닉네임 확인
		function checkNick(nick) {
			if (!checkValue(nick.value, "닉네임을"))
				return false;
			if (!nickPattern.test(userNick.value)) {
				alert("숫자, 영어, 한국어와 언더스코어를 허용하며 최소 2자 이상의 닉네임");
				nick.value = "";
				nick.focus();
				return false;
			}
			return true;
		}

		function checkAll() {
			// checkID값이 false일 시 return false로 함수 중지
			if (!checkID(m_id))
				return false;
			// 값이 잘 들어가는지 로그를 찍어보자
			console.log("아이디 확인");
			if (!checkPwd(m_pw, confirmUserPwd))
				return false;
			console.log("비밀번호 확인");
			if (!checkTel(m_phone))
				return false;
			console.log("전화번호 확인");
			if (!checkMail(m_email))
				return false;
			console.log("메일 확인");
			if (!checkNick(m_nickname))
				return false;
			console.log("닉네임 확인");
			return true;
		}

		// 데이터베이스 미 연동으로 인한 미구현
		//이메일, 전화번호 유니크..
		function isDupli() {
			alert("중복되지 않았습니다.");
			return false;
		}
	</script>
	<%@ include file="./footer.jsp"%>
</body>

</html>