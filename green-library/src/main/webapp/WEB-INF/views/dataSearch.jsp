<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자료 검색</title>

<script src="js/dataSearch.js"></script>
<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/dataSearch.css">


</head>

<body>

<header id="header" class="header"></header>

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">통합 자료 검색</div> <div class="pageRoute">홈 > 자료 검색 > 통합 자료 검색</div>
    </div>
</div>

<main>

<div class="zero_container">
	<div class="sel_box">
		<div class="sel_box1">
			<select>
				<option>인기도서</option>
				<option>신착도서</option>
				<option>소설</option>
				<option>에세이/시/희곡</option>
				<option>인문</option>
				<option>자기계발</option>
				<option>경제/경영</option>
			</select>
		</div>
		<div class="sel_box2">
			<input type="text" value="검색어를 입력하세요" onfocus="want_search(event)" onblur="zero_back(event)">
		</div>
		<div class="sel_box3">
			<input type="button" value="검색" onclick="lets_search(event)">
		</div>
	</div>
</div>

<div class="first_container">
	<!-- 사진들도 넣을지 -->
	<div class="class_box">총류</div>
	<div class="class_box">철학</div>
	<div class="class_box">종교</div>
	<div class="class_box">사회과학</div>
	<div class="class_box">자연과학</div>
	<div class="class_box">기술과학</div>
	<div class="class_box">예술</div>
	<div class="class_box">언어</div>
	<div class="class_box">문학</div>
	<div class="class_box">역사</div>
</div>

<div class="second_container">
	<!-- 십단위 분류 할 지 어쩔지 몰라서 일단 냅둠-->
	<!-- 여기는 종류별 분류 겹쳐놓고 위에서 클릭하면 분류 젤 위로(z-index)  -->
	아아
</div>

</main>
<footer id="footer" class="footer"></footer>

</body>
</html>
