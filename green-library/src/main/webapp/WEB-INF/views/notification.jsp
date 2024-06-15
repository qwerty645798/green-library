<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>공지사항</title>

<script src="js/notification.js"></script>
<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/notification.css">

</head>


<body>


<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">공지사항</div> <div class="pageRoute">홈 > 도서관 소식 > 공지사항</div>
    </div>
</div>

<header id="header" class="header"></header>

<main>

<div class="first_container">
	<div class="text_box">
		<div class="text_box1">
			&nbsp;&nbsp; Total : ???개 (page : ? / ??) <!-- 이건 나중에 데이터 할 때 구현-->
		</div>
		<div class="text_box2">
			<select>
				<option>10건</option>
				<option>20건</option>
			</select>
		</div>
		<div class="text_box3">
			<select>
				<option>제목+본문</option>
				<option>제목</option>
				<option>본문</option>
			</select>
		</div>
		<div class="text_box4">
			<input type="text" value="검색어를 입력하세요" onfocus="want_search(event)" onblur="zero_back(event)">
			<input type="button" value="검색" onclick="lets_search(event)">
		</div>
	</div>
</div>

<div class = "second_container">
	<table class="notice_table">
		<tr>
			<th>번호</th>
			<th>관리자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<tr><!-- 이제 이 밑으로 줄이나 제목(td) 클릭하면 해당 상세로 가게 기능 구현 -->
			<td class="num_table">2</td>
			<td class="name_table">그린라이브러리</td>
			<td class="title_table">&nbsp; 우리는</td>
			<td class="date_table">1111/11/11</td>
		</tr>
		<tr>
			<td class="num_table">1</td>
			<td class="name_table">그린라이브러리</td>
			<td class="title_table">&nbsp; 코드를 친다</td>
			<td class="date_table">2222/22/22</td>
		</tr>
	</table>
</div>

<!-- 여기 버튼 박스 구현 해야됨 복잡할듯? -->
<!-- 위에 리스트 n개씩 출력, 그에 맞춰서 5개씩 페이지 버튼 출력 -->
<!-- 제일 앞에서는 << < 두개 없이, 제일 뒤에서는 > >> 없이 -->
<div class="third_container">
	<div class="button_box">
		<div class="button_box1">
			<input type="button" value="<<">
		</div>
		<div class="button_box2">
			<input type="button" value="<">
		</div>
		<div class="button_box3">
			<div class="button_inbox">
				<input type="button" value="1">
			</div>
			<div class="button_inbox">
				<input type="button" value="2">
			</div>
			<div class="button_inbox">
				<input type="button" value="3">
			</div>
			<div class="button_inbox">
				<input type="button" value="4">
			</div>
			<div class="button_inbox">
				<input type="button" value="5">
			</div>
		</div>
		<div class="button_box4">
			<input type="button" value=">">
		</div>
		<div class="button_box5">
			<input type="button" value=">>">
		</div>
	</div>
</div>



</main>

<footer id="footer" class="footer"></footer>


</body>
</html>