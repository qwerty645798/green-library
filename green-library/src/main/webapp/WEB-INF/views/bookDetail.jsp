<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 정보</title>

<link rel="stylesheet" type="text/css" href="css/bookDetail.css">
<link rel="stylesheet" type="text/css" href="css/public/nav.css">

</head>
<body>

<header id="header" class="header"></header>

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">도서 상세 정보</div> <div class="pageRoute">홈 > 도서 상세 정보</div>
    </div>
</div>

<main>


<div class="bigDiv">
	<div class="book_container"><!-- 좌 이미지 우 테이블 -->
		<div class="book_image">
			<img src="images/${book.img}">
		</div>
		<div class="book_table">
			<table>
			
			
				<tr>
					<th>대출도서명</th>
					<td>&nbsp;&nbsp;${book.title}</td>
					<th>등록 번호</th>
					<td>&nbsp;&nbsp;${book.isbn}</td>
				</tr>
				<tr>
					<th>저자명</th>
					<td colspan="3">&nbsp;&nbsp;${book.authorName}</td>
				</tr>
				<tr>
					<th>서가 위치</th>
					<td colspan="3">&nbsp;&nbsp;${book.location}</td>
				</tr>
				<tr>
					<th>대출 상태</th>
					<td colspan="3">&nbsp;&nbsp;${book.availability}</td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="border:none;"><!-- 예약 기능 구현 후 수정 -->
						<form action="" method="">
						<input type="submit" value="대출 예약">
						</form>
					</td>
				</tr>
				
							
			</table>	
		</div>
	</div>
</div>

<div class="book_container2">
	<h2>&nbsp;&nbsp;&nbsp;책소개</h2>
	<hr>
	&nbsp;&nbsp;&nbsp;${book.summary}	
</div>


</main>

<footer id="footer" class="footer"></footer>


</body>
</html> 