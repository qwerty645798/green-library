<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신착 도서</title>


<link rel="stylesheet" type="text/css" href="css/initiativeBook.css">
<link rel="stylesheet" type="text/css" href="css/public/nav.css">



</head>
<body>

<header id="header" class="header"></header>

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">신착도서</div> <div class="pageRoute">홈 > 자료 검색 > 신착도서</div>
    </div>
</div>

<main><!-- 현재 한 줄에 2권, 3줄만 만들어둠 -->

<!-- 한줄 기본 폼 -->
<div class="image_container">
	<div class="image_box">
		<a href="bookDetail?bookId=21"><!-- 밑에 이미지 파일의 exex.jpg부분을 데이터베이스의 img와 비교해 일치하는 데이터의 아이디로 -->
			<img src="images\exex.jpg">
		</a>
	</div>
	<div class="image_box">
		<a href="bookDetail?bookId=1">
			<img src="images\file.png">
		</a>
	</div>
</div>

<!-- 한줄 기본 폼 -->
<div class="image_container">
	<div class="image_box">
		<a href="bookDetail?bookId=21">
			<img src="images\exex.jpg">
		</a>
	</div>
	<div class="image_box">
		<a href="bookDetail?bookId=1">
			<img src="images\file.png">
		</a>
	</div>
</div>

<!-- 한줄 기본 폼 -->
<div class="image_container">
	<div class="image_box">
		<a href="bookDetail?bookId=21">
			<img src="images\exex.jpg">
		</a>
	</div>
	<div class="image_box">
		<a href="bookDetail?bookId=1">
			<img src="images\file.png">
		</a>
	</div>
</div>

</main>

<footer id="footer" class="footer"></footer>

</body>
</html>