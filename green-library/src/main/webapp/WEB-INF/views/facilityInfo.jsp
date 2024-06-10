<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a{
	text-decoration:none;
	color:black;
}
a:hover{
	text-decoration:underline;
	color:dodgerblue;
}
.clearfix::after {
	content: "";
	display: table;
	clear: both;
}
.roundbox{
	border-radius:20px;
}
.map{
	height:300px;
	border:1px black solid;
	padding:10px;
	margin:10px 400px;
}
.explain{
	margin:10px 400px;
}
.image{
	height:100%;
	width:auto;
}
</style>
</head>
<body>
	<header id="header" class="header"></header>
		<nav style="
			height:90px;
			border: 1px black solid;
			display:flex; 
			justify-content:center;
			background:powderblue;
			" 
			class="roundbox">
			<div style="
				width:50%;
				display:flex; 
				justify-content:center;
				position:relative
			">
				<div style="
					font-size:3em; 
					margin-top:10px;
				">부대시설 안내</div>
				<div style="float:right;
					position:absolute;
					right:20px;
					margin-top:60px;
				"><a href="index">홈</a>>부대시설안내
				</div>
			</div>
		</nav><br><br>
		<main>
			<div class="explain">1F</div>
			<div class="map roundbox">
				<img src="images/floor1F.jpg" class="image">
				
			</div>
			<div class="explain">2F</div>
			<div class="map roundbox">
				<img src="images/floor2F.jpg" class="image">
			</div>
			<div class="explain">3F</div>
			<div class="map roundbox">
				<img src="images/floor3F.jpg" class="image">
			</div>
			<div class="explain">4F</div>
			<div class="map roundbox">
				<img src="images/floor4F.png" class="image">
			</div>
			<div class="explain">B1</div>
			<div class="map roundbox">
				<img src="images/BasementB1.png" class="image">
			</div>
			
		</main>

		<footer id="footer" class="footer"></footer>
</body>
</html>