<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자료 검색 결과</title>


<script src="js/dataSearch.js"></script>
<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/dataSearchResult.css">


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
				<option>전체</option>
				<option>도서명</option>
				<option>저자</option>
				<option>출판사</option>
				<option>내용</option>
				<option>인기도서</option><!-- 인기 신착은 셀렉트+검사하면 그냥 인기 신착 페이지로? -->
				<option>신착도서</option>
			</select>
		</div>
		<div class="sel_box2">
			<input type="text" value="검색어를 입력하세요" onfocus="want_search(event)" onblur="zero_back(event)">
		</div>
		<div class="sel_box3">
			<input type="button" value="검색" onclick="lets_search(event)" class="zerocon_button">
		</div>
	</div>
</div>

<div class="first_container">
	<div class="text_box">
		<div class="text_box1">
			&nbsp;"select된 값" 으로 검색 된 결과 : "??"개 <!-- 이건 나중에 데이터 할 때 구현-->
		</div>
		<div class="text_box2">
			<input type="button" value="??개씩 보기" class="firstcon_button">
		</div>
	</div>
</div>

<div class="second_container">
	
	<div class="bigDiv">
		<div class="book_container">
			<div class="book_image">
				<img src="images/exex.jpg">
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
	
	<div class="bigDiv">
		<div class="book_container">
			<div class="book_image">
				<img src="images/exex.jpg">
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

