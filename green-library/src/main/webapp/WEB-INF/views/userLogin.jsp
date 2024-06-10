<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: underline;
	color: dodgerblue;
}

.roundbox {
	border-radius: 20px;
}

.floor{
	width:400px;
	height:50px;
	margin:20px 75px;
	font-size:0.8em;
}
.floor > input.text{
	width:400px;
	height:50px;
	border-radius:10px;
	border:1px #AAAAAA solid;
	outline:none;
}
nav{
	width:1520px; 
	height: 90px; 
	border: none; 
	display: flex; 
	justify-content: center; 
	background: #DFD9D0;
}

</style>
</head>
<body>
	<header id="header" class="header"></header>
	<nav class="roundbox">
		<div style="width: 50%; display: flex; justify-content: center; position: relative">
			<div style="font-size: 2.5em; margin-top: 10px;">로그인</div>
			<div style="float: right; position: absolute; right: 20px; margin-top: 60px;">
				<a href="index">홈</a>>로그인
			</div>
		</div>
	</nav>
	<br><br>
	<h1 style="text-align:center; font-size:3em;">Member Login <br>
	<span style="font-size:0.3em;">로그인을 하시면 더 많은 도서관 서비스를 이용할 수 있습니다.</span>
	</h1>
	<main style="display:flex; justify-content:center;">
		
		<form>
		<div style=" width:550px; height:350px; padding:0px;">
			<div class="floor"><input type="text" placeholder="아이디" name="#" class="text"><br></div>
			<div class="floor"><input type="password" placeholder="비밀번호" name="#" class="text"><br></div>
			<div class="floor"><input type="checkbox" name="#"> 아이디 저장 
			<div style="width:120px; display:inline-block"> </div> <a href="#">아이디 찾기</a> / <a href="#">비밀번호 초기화</a></div>
			<div class="floor" style="text-align:center;"><input type="submit" value="로그인" style="color:white; background:#535353; width:120px; height:35px; cursor:pointer;"></div>
		</div>
		</form>
	</main>
	<footer id="footer" class="footer"></footer>
</body>
</html>