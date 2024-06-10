<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신착 도서</title>

<style>

.image_container {
    display: flex;
    width: 1600px;
    height: 500px;
    margin: 0 auto;
}

.image_box{
	display: flex;
	width: 800px;
	height: 500px;
	align-items: center;
    justify-content: center;
	border:1px solid gray;
}

.image_box img{
	width: 250px;
	height: 375px;
	object-fit: cover; /*fill?*/
}
</style>

</head>
<body>

<header id="header" class="header"></header>

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