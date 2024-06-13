
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userFinding</title>
<!-- <link href="../CSS/public/header.css" type="text/css" rel="stylesheet"> -->
<link href="/css/public/footer.css" type="text/css" rel="stylesheet">
<link href="/css/public/header.css" type="text/css" rel="stylesheet">
<link href="/css/public/nav.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="/css/userFindingAlt.css">
</head>
<body>

	

	<div class="testContainer"><!-- IHM 임의로 추가한 컨테이너 박스 -->

		<header id="header" class="footer"></header>
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
				<div class="checkBtn">
					<img src="/images/check-button.jpg"
						style="width: 100%; height: auto;">
				</div>
				<span class="choose" id="choose">아이디
					찾기 본인인증</span>
			</div>
			<Br> <br><Br>
			<div class="container">
				<div class="modalBtnBox">
					<a id="modalOpenButton" class="modalOpenButton"><img
						src="/images/userfind.png" style="height: 100%; width: auto;"></a>
				</div>
			</div>
			<div class="container"> <!-- 위치를 main 바깥에서 main 안으로 변경 -->
				<span class="choose">인증을 해주세요.</span>
			</div>
		</main>
	
	
	
		<div id="modalContainer" class="hidden">
			<div id="modalContent" class="modalContent">
				<h3 style="text-align:center;"><b class="mainName">아이디 찾기</b></h3>
				<br>
				<form action="userFinding-perform" method="post">
					<table id="table">
						<tr>
							<td class="text"><div>이메일</div></td>
							<td class="input"><input type="text" name="#" class="short"> @ <input type="text" name="#" class="short"></td>
						</tr>
						<tr>
							<td class="text"><div>성명</div></td>
							<td class="input"><input type="text" name="#"></td>
						</tr>
						<tr>
							<td class="text"><div>생년월일</div></td>
							<td class="input"><input type="text" name="#"><br>
								<span>* 입력 예 : 2000-10-10</span>
							</td>
						</tr>
					</table>
					<div class="submitBtn"><input type="submit" value="확인"></div>
				</form>
				<button id="modalCloseButton"><img src="/images/x-icon.png" style="width:100%; height:auto;"></button>
			</div>
		</div>

		<footer id="footer" class="footer"></footer>

	</div><!-- 여기까지가 테스트 컨테이너 -->
	
	

	

	<script defer src="/js/HeadFoot.js" type="text/javascript"></script>
	<script src="/js/userFinding.js"></script>
</body>
</html>