<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userFinding</title>
<link href="/css/userFinding.css" type="text/css" rel="stylesheet">
<link href="/css/public/nav.css" type="text/css" rel="stylesheet">
<script>
	let message = "${message}";
	if(message)
		alert(message);
	let userId = "${userId}";
	if(userId) {
		alert("회원님의 아이디는 " + userId + "입니다.");
	}
</script>
</head>
<body>
	<jsp:include page="../index/header.jsp" />
	<nav class="bannerBgr">
		<div class="Banner">
			<div class="pageTitle"><span class="mainName">아이디 찾기</span></div>
			<div class="pageRoute">홈 > <span class="mainName">아이디 찾기</span></div>
		</div>
	</nav><Br><Br>
	<main>
		<div class="container">
			<input type="button" onclick="ID()" value="아이디 찾기" id="id" class="btn"><input
				type="button" onclick="PW()" value="비밀번호 찾기" id="pw" class="btn">
		</div>
		<br> <br> <br>
		<div class="container">
			<div class="chkBtn">
				<img class="chkBtnImg" src="/images/check-button.jpg">
			</div>
			<span class="chkSpan" id="choose">아이디
				찾기 본인인증</span>
		</div>
		<Br> <br><Br>
		<div class="container">
			<div class="modOpBtnBox">
				<a id="modalOpenButton">
				<img class="birthChk" src="/images/calendar_month.png" ">
				</a>
			</div>
		</div>
	</main>
	<div class="container">
		<span>생년월일 인증을 해주세요.</span>
	</div>


	<div id="modalContainer" class="hidden">
		<div id="modalContent">
			<h3 style="text-align:center;"><b class="mainName">아이디 찾기</b></h3>
			<br>
			<form action="userFindingId" method="post" id="form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<table id="table" style="border-collapse:collapse;">
					<tr>
						<td class="text"><div>이메일</div></td>
						<td class="input">
						<input type="hidden" id="email" name="email">
						<input type="text" class="short"> @ <input type="text" class="short"></td>
					</tr>
					<tr>
						<td class="text"><div>성명</div></td>
						<td class="input"><input type="text" name="name" id="username"></td>
					</tr>
					<tr>
						<td class="text"><div>생년월일</div></td>
						<td class="input"><input type="text" name="birth" id="birthDate"><br>
							<span>* 입력 예 : 2000-10-10</span>
						</td>
					</tr>
				</table>
				<div class="subBox">
				<input type="submit" value="확인" onclick="concatInput()">
				</div>
			</form>
			<button id="modalCloseButton"><img class="closeBtn" src="/images/x-icon.png" ></button>
		</div>
	</div>
	<script src="/js/userFindingModal.js"></script>
	<script src="/js/userFinding.js"></script>
	<jsp:include page="../index/footer.jsp" />
</body>
</html>