<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userLogin</title>
<link href="css/public/header.css" type="text/css" rel="stylesheet">
<link href="css/public/footer.css" type="text/css" rel="stylesheet">
<link href="css/public/nav.css" type="text/css" rel="stylesheet">
<link href="css/userLogin.css" type="text/css" rel="stylesheet">
</head>
<body> 
	<!-- <img src="images/wood.png" style="width:99%; height:auto; position:absolute; z-index:-1;"> -->
	<jsp:include page="../index/header.jsp" />
	<nav class="bannerBgr">
		<div class="Banner">
			<div class="pageTitle">로그인</div>
			<div class="pageRoute">홈 > 로그인</div>
		</div>
	</nav>
	<br>
	<h1 style="text-align:center; font-size:3em; margin-bottom:0px; color:#492918;">Member Login<br>
	<span style="font-size:0.3em;color:#471C0A; margin:0px; font-weight:900;">로그인을 하시면 더 많은 도서관 서비스를 이용할 수 있습니다.</span>
	</h1>
	<main style="display:flex; justify-content:center;">
		
		<form action="userLogin-perform" method="post">
		<div style=" width:550px; height:350px; padding:0px;">
			<div class="floor"><input type="text" placeholder="아이디" name="#" class="text"><br></div>
			<div class="floor"><input type="password" placeholder="비밀번호" name="#" class="text"><br></div>
			<div class="floor"><input type="checkbox" name="#"> 아이디 저장 
			<div style="width:120px; display:inline-block"> </div> <a href="#">아이디 찾기</a> / <a href="#">비밀번호 초기화</a></div>
			<div class="floor" style="text-align:center;"><input type="submit" value="로그인" style="color:white; background:#535353; width:120px; height:35px; cursor:pointer;"></div>
		</div>
		</form>
	</main>
	<jsp:include page="../index/footer.jsp" />
</body>
</html>