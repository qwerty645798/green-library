<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인기 도서</title>


<link rel="stylesheet" type="text/css" href="css/popularBook.css">
<link rel="stylesheet" type="text/css" href="css/public/nav.css">


</head>
<body>

<header id="header" class="header"></header>


<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">인기도서</div> <div class="pageRoute">홈 > 자료 검색 > 인기도서</div>
    </div>
</div>

<main><!-- 페이지내 들어갈 개수 / 현재(3개) -->

<!-- 개별 기본 폼 -->
<div class="bigDiv">
	<div class="book_container">
		<div class="book_image">
			<img src="images\exex.jpg">
		</div>
		<div class="book_table">
			<table>
				<tr>
					<th>책 제목</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>저자명</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>대출 가능 여부</th>
					<td colspan="3">대출 가능/불가<!-- 대출 가능/불가 여부 확인 후 출력되어있는 기능 --></td>
				</tr>
				<tr>
					<!-- form-submit? 아니면 그냥 button?  -->
					<td colspan="4" class="more_button" style="border:none;">
						<input type="button" onclick="window.location.href='bookDetail'" value="자세히 보기" class="moreInf">
					</td> 
				</tr>
			</table>
		</div>
	</div>
</div>

<!-- 개별 기본 폼 -->
<div class="bigDiv">
	<div class="book_container">
		<div class="book_image">
			<img src="images\exex.jpg">
		</div>
		<div class="book_table">
			<table>
				<tr>
					<th>책 제목</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>저자명</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>대출 가능 여부</th>
					<td colspan="3">대출 가능/불가<!-- 대출 가능/불가 여부 확인 후 출력되어있는 기능 --></td>
				</tr>
				<tr>
					<!-- form-submit? 아니면 그냥 button?  -->
					<td colspan="4" class="more_button" style="border:none;">
						<input type="button" onclick="window.location.href='bookDetail'" value="자세히 보기" class="moreInf">
					</td> 
				</tr>
			</table>
		</div>
	</div>
</div>

<!-- 개별 기본 폼 -->
<div class="bigDiv">
	<div class="book_container">
		<div class="book_image">
			<img src="images\exex.jpg">
		</div>
		<div class="book_table">
			<table>
				<tr>
					<th>책 제목</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>저자명</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>대출 가능 여부</th>
					<td colspan="3">대출 가능/불가<!-- 대출 가능/불가 여부 확인 후 출력되어있는 기능 --></td>
				</tr>
				<tr>
					<!-- form-submit? 아니면 그냥 button?  -->
					<td colspan="4" class="more_button" style="border:none;">
						<input type="button" onclick="window.location.href='bookDetail'" value="자세히 보기" class="moreInf">
					</td> 
				</tr>
			</table>
		</div>
	</div>
</div>

</main>

<footer id="footer" class="footer"></footer>

</body>
</html>