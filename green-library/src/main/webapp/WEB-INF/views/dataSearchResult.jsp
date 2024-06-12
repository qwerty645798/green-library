<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자료 검색 결과</title>


<script src="js/dataSearch.js"></script>
<link rel="stylesheet" type="text/css" href="css/nav_hyun.css">
<link rel="stylesheet" type="text/css" href="css/dataSearchResult.css">


</head>

<body>

<header id="header" class="header"></header>

<nav class="navnav">
	<div class="hyun">
		<div class="big_name">통합 자료 검색</div> 
		<div class="small_name">홈 > 자료 검색 > 통합 자료 검색</div>
	</div>
</nav>

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
	<div class="text_box">
		<div class="text_box1">
			&nbsp;"select된 값" 으로 검색 된 결과 : "??"개 <!-- 이건 나중에 데이터 할 때 구현-->
		</div>
		<div class="text_box2">
			<input type="button" value="??개씩 보기">
		</div>
	</div>
</div>

<div class="second_container">
	
	<div class="book_container">
		<div class="book_image">
			<!-- 이미지 -->
		</div>
		<div class="book_table">
			<table>
				<tr>
					<th>도서명</th>
					<td></td>
					<th>재고현황</th>
					<td></td>
				</tr>
				<tr>
					<th>저자</th>
					<td></td>
					<th>위치</th>
					<td></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>ISBN</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">모시깽이</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="book_container">
		<div class="book_image">
			<!-- 이미지 -->
		</div>
		<div class="book_table">
			<table>
				<tr>
					<th>도서명</th>
					<td></td>
					<th>재고현황</th>
					<td></td>
				</tr>
				<tr>
					<th>저자</th>
					<td></td>
					<th>위치</th>
					<td></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>ISBN</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">모시깽이</td>
				</tr>
			</table>
		</div>
	</div>

</div>

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