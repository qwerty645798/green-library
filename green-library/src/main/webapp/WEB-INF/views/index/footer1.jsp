<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
footer{
	display:flex;
	flex-direction:column;
	align-items:center;
	background-color: #6c5a3f;
	margin-top: 100px;
}
div#box {
	width: 1260px;
	display: flex;
	flex-direction: column;
	position:relative;
	height:176px;
}
p#footTagA{
	position:absolute;
	top:50px;
	right:50px;
}
p#footTagB{
	position:absolute;
	bottom:0px;
	right:50px;
}
</style>
</head>
<body>
	<footer>
		<div id="box">
			<p>개인정보처리방침 / 찾아오시는 길 / 사이트맵 / 고객센터</p>
			<p>
				locate: 서울특별시 강남구 테헤란로5길 24 <br> 대표전화: 010-0000-0000 <br>
				FAX: 02-111-1111<br> <br>
			</p>
			<p id="footTagA">
				<a href="https://kr.freepik.com/author/freepik/icons/basic-rounded-lineal_4#from_element=families_block">
				Freepik 제작 아이콘</a>
			</p>
			<p id="footTagB">copyright(c) GREENLIBRARY. All rights reserved.</p>
			<div id="footerLogo"></div>
		</div>
	</footer>
</body>
</html>