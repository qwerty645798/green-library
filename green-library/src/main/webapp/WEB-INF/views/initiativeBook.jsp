<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신착 도서</title>

<link rel="stylesheet" type="text/css" href="src/main/resources/static/css/initiativeBook.css">
<link rel="stylesheet" type="text/css" href="src/main/resources/static/css/nav_hyun.css">

</head>
<body>

<header id="header" class="header"></header>

<nav class="navnav">
	<div class="hyun">
		<div class="big_name">신착도서</div> 
		<div class="small_name">홈 > 자료 검색 > 신착도서</div>
	</div>
</nav>

<main><!-- 현재 한 줄에 2권, 3줄만 만들어둠 -->

<!-- 한줄 기본 폼 -->
<div class="image_container">
	<div class="image_box">
		<a href="bookDetail.jsp">
			<img src="src\main\resources\static\images\exex.jpg">
		</a>
	</div>
	<div class="image_box">
		<a href="bookDetail.jsp">
			<img src="src\main\resources\static\images\exex.jpg">
		</a>
	</div>
</div>

<!-- 한줄 기본 폼 -->
<div class="image_container">
	<div class="image_box">
		<a href="bookDetail.jsp">
			<img src="src\main\resources\static\images\exex.jpg">
		</a>
	</div>
	<div class="image_box">
		<a href="bookDetail.jsp">
			<img src="src\main\resources\static\images\exex.jpg">
		</a>
	</div>
</div>

<!-- 한줄 기본 폼 -->
<div class="image_container">
	<div class="image_box">
		<a href="bookDetail.jsp">
			<img src="src\main\resources\static\images\exex.jpg">
		</a>
	</div>
	<div class="image_box">
		<a href="bookDetail.jsp">
			<img src="src\main\resources\static\images\exex.jpg">
		</a>
	</div>
</div>

</main>

<footer id="footer" class="footer"></footer>

</body>
</html>