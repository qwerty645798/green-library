<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 정보</title>

<link rel="stylesheet" type="text/css" href="css/bookDetail.css">
<link rel="stylesheet" type="text/css" href="css/nav_hyun.css">

</head>
<body>

<header id="header" class="header"></header>

<nav class="navnav">
	<div class="hyun">
		<div class="big_name">도서 상세 정보</div> 
		<div class="small_name">홈 > 도서 상세 정보</div>
	</div>
</nav>

<main>


<div class="book_container"><!-- 좌 이미지 우 테이블 -->
	<div class="book_image">
		<!-- 이미지 -->
	</div>
	<div class="book_table">
		<table>
			<tr>
				<th>대출도서명</th>
				<td></td>
				<th>등록 번호</th>
				<td></td>
			</tr>
			<tr>
				<th>저자명</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<th>서가 위치</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<th>대출 상태</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><!-- 예약 기능 구현 후 수정 -->
					<form action="" method="">
					<input type="submit" value="대출 예약">
					</form>
				</td>
			</tr>			
		</table>
	</div>
</div>

<div class="book_container2">
	<h2>&nbsp;&nbsp;&nbsp;책소개</h2>
	<hr>
	&nbsp;&nbsp;&nbsp;가나다<br>라<br>바사
	<!-- 책소개 내용 -->
</div>

</main>

<footer id="footer" class="footer"></footer>


</body>
</html> 