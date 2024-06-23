<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userFinding</title>
<link href="css/userFinding.css" type="text/css" rel="stylesheet">
<link href="css/public/nav.css" type="text/css" rel="stylesheet">
<script src="js/userFinding.js"></script>
<script>
	let message = "${message}";
	if(message)
		alert(message);
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
			<div style="display: inline-block; width: 25px; height: 25px;">
				<img src="images/check-button.jpg"
					style="width: 100%; height: auto;">
			</div>
			<span style="font-size: 1em; font-weight: 600;" id="choose">아이디
				찾기 본인인증</span>
		</div>
		<Br> <br><Br>
		<div class="container">
			<div
				style="width: 1200px; height: 150px; background: #F5F5F5; text-align: center;">
				<a id="modalOpenButton"
					style="height: 100px; width: 100px; cursor: pointer;"><img
					src="images/userfind.png" style="height: 100%; width: auto;"></a>
			</div>
		</div>
	</main>
	<div class="container"
		style="color:#EE0000; margin-top: 10px; font-weight:600;">
		<span>인증을 해주세요.</span>
	</div>


	<div id="modalContainer" class="hidden">
		<div id="modalContent">
			<h3 style="text-align:center;"><b class="mainName">아이디 찾기</b></h3>
			<br>
			<form action="userFinding" method="post" id="form">
				<table id="table" style="border-collapse:collapse;">
					<tr>
						<td class="text"><div>이메일</div></td>
						<td class="input">
						<input type="hidden" id="email" name="email">
						<input type="text" class="short"> @ <input type="text" class="short"></td>
					</tr>
					<tr>
						<td class="text"><div>성명</div></td>
						<td class="input"><input type="text" name="name"></td>
					</tr>
					<tr>
						<td class="text"><div>생년월일</div></td>
						<td class="input"><input type="text" name="birth"><br>
							<span style="color:#DD0000; font-size:0.8em; font-weight:600;">* 입력 예 : 2000-10-10</span>
						</td>
					</tr>
				</table>
				<div style="display:flex; justify-content:center;"><input type="submit" value="확인" onclick="concatInput()"style="color:white; background:#0D2E8C; width:120px; height:35px; margin-top:30px; cursor:pointer;" ></div>
			</form>
			<button id="modalCloseButton"><img src="images/x-icon.png" style="width:100%; height:auto;"></button>
		</div>
	</div>
	<script src="js/userFindingModal.js"></script>
	<jsp:include page="../index/footer.jsp" />
</body>
</html>