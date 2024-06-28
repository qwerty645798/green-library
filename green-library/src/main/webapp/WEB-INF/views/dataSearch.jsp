<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자료 검색</title>

<script src="/js/dataSearchBar.js"></script>
<link rel="stylesheet" type="text/css" href="/css/public/nav.css">
<link rel="stylesheet" type="text/css" href="/css/dataSearchBar.css">
<link rel="stylesheet" type="text/css" href="/css/dataSearch.css">


</head>

<body>

<jsp:include page="index/header.jsp" />

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
				<option>전체</option>
				<option>도서명</option>
				<option>저자</option>
				<option>출판사</option>
				<option>내용</option>
				<option>인기도서</option>
				<option>신착도서</option>
			</select>
		</div>
		<div class="sel_box2">
			<input type="text" value="검색어를 입력하세요" 
			onfocus="want_search(event)" 
			onblur="zero_back(event)" 
			onkeypress="checkEnter(event)">
		</div>
		<div class="sel_box3">
<!--			<input type="button" value="검색" onclick="lets_search()">-->
			<img src="/images/searchBtn.png" onclick="lets_search()">
		</div>
	</div>
</div>

<div class="subtitleContainer1">
	<div class="subtitleContainer2">
		<span class="themeSearch">주제별 검색</span>
	</div>
</div>

	

<div class="first_container">
	<!-- 사진들도 넣을지 -->
	<div class="class_box"><img src="/images/000.png" width="50px"><br>총류</div>
	<div class="class_box"><img src="/images/100.png" width="50px"><br>철학</div>
	<div class="class_box"><img src="/images/200.png" width="50px"><br>종교</div>
	<div class="class_box"><img src="/images/300.png" width="50px"><br>사회과학</div>
	<div class="class_box"><img src="/images/400.png" width="50px"><br>자연과학</div>
	<div class="class_box"><img src="/images/500.png" width="50px"><br>기술과학</div>
	<div class="class_box"><img src="/images/600.png" width="50px"><br>예술</div>
	<div class="class_box"><img src="/images/language.png" width="50px"><br>언어</div>
	<div class="class_box"><img src="/images/dictionary.png" width="50px"><br>문학</div>
	<div class="class_box"><img src="/images/history.png" width="50px"><br>역사</div>
</div>


<div class="subtitleContainer1">
	<div class="subtitleContainer2">
		<span class="themeSearch">주제별 번호 참고</span>
	</div>
</div>
<div class="second_container">
	<div class="img_box">
		<img src="/images/bookCategory.jpg">
	</div>
</div>

</main>

<jsp:include page="index/footer.jsp" />

</body>
</html>
