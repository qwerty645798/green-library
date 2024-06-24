<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInfoModification</title>
<link href="css/public/header.css" type="text/css" rel="stylesheet">
<link href="css/public/footer.css" type="text/css" rel="stylesheet">
<link href="css/public/nav.css" type="text/css" rel="stylesheet">
<link href="css/userJoin.css" type="text/css" rel="stylesheet">
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
			<div class="pageTitle">회원정보수정</div>
			<div class="pageRoute">홈 > 회원정보수정</div>
		</div>
	</nav>
	<br>
	<br>
	<main>
		<form action="userInfoModification" method="post" id="form">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="container">
				<table style="border-collapse: collapse;">
					<tr>
						<td class="text"><div>이름</div></td>
						<td class="input">${userInfo.name}</td>
					</tr>
					<tr>
						<td class="text"><div>생년월일</div></td>
						<td class="input">${userInfo.birth}</td>
					</tr>
					<tr>
						<td class="text"><div>아이디</div></td>
						<td class="input">${userInfo.user_id}</td>
					</tr>
					<tr>
						<td class="text"><div>비밀번호</div></td>
						<td class="input"><input type="password" id="pswd" name="user_pass"
							class="middle"> <br>
							<div class="comment">
								비밀번호를 입력하세요(8~20자로 숫자, 영문소, 영문대, 특수문자 중 3가지 이상 조합) <br> <span
									style="font-size: 1.1em; font-weight: 600;">입력가능한 특수문자는
									[ 사용가능 특수문자 : <span style="color: red;">!@#^*_</span>]입니다. <br>
									(지정된 특수문자 외는 입력이 불가능합니다.)
								</span>
							</div></td>
					</tr>
					<tr>
						<td class="text"><div>비밀번호 확인</div></td>
						<td class="input"><input type="password" id="passCheck"
							 class="middle"></td>
					</tr>
					<tr>
						<td class="text"><div>휴대폰번호</div></td>
						<td class="input">
						<input type="hidden" name="phone" value="" id="fullPhone">
						<input type="text"
							class="brief"> - <input type="text"
							class="brief"> - <input type="text"
							class="brief"></td>
					</tr>
					<tr>
						<td class="text"><div>이메일</div></td>
						
						<td class="input"><input type="hidden" id="fullEmail" name="email" value=""><input type="text" id="email" 
							class="short"> @ <input type="text" id="email2"
							class="short" readonly> <select id="emailSel"
							onchange="mailText()">
								<option value="" selected></option>
								<option value="naver.com">naver.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="daum.net">daum.net</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="nate.com">nate.com</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2" style="border: none; text-align: center;"><input
							type="submit" value="확인" onclick="concatInput(), modifyCheck()"></td>
					</tr>
				</table>
			</div>
		</form>
	</main>
	<jsp:include page="../index/footer.jsp" />

	<script src="js/userInfoModification.js" type="text/javascript"></script>

</body>
</html>