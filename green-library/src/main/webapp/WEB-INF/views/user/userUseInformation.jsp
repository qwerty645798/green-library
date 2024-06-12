<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userUseInformation</title>
<link href="css/public/userUseInformation.css" type="text/css" rel="stylesheet">
<link href="css/public/nav.css" type="text/css" rel="stylesheet">
</head>
<body>
	<header id="header" class="header"></header>
	<nav class="bannerBgr">
		<div class="Banner">
			<div class="pageTitle">도서 이용정보</div>
			<div class="pageRoute">홈 > 도서 이용정보</div>
		</div>
	</nav>
	<div class="container" style="margin-top: 64px;">
		<main class="main">
			<div class="container">
				<div class="center btnbox">
					<table class="btn">
						<tr>
							<th>일반 예약</th>
						</tr>
						<tr>
							<td>0 / 3</td>
						</tr>
					</table>
				</div>
				<div style="width: 30px;"></div>
				<div class="center btnbox">
					<table class="btn">
						<tr>
							<th>대출 / 연체</th>
						</tr>
						<tr>
							<td>0 / 0</td>
						</tr>
					</table>
				</div>
				<div style="width: 30px;"></div>
				<div class="center btnbox">
					<table class="btn">
						<tr>
							<th>나의 상태</th>
						</tr>
						<tr>
							<td>대출 가능</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="container" style="margin-top: 48px;">
				<div class="center Dheader"
					onclick="location='userUseInformation?condition=rentHistory'">
					<span>전체 대출이력</span>
				</div>
				<div class="center Dheader"
					onclick="location='userUseInformation?condition=borrow'">
					<span>대출중인 도서</span>
				</div>
				<div class="center Dheader"
					onclick="location='userUseInformation?condition=reserve'">
					<span>신청한 예약도서</span>
				</div>
				<div class="center Dheader"
					onclick="location='userUseInformation?condition=interest'">
					<span>관심도서 조회</span>
				</div>
			</div>
			<div class="container" style="margin-top: 60px;">
				<table id="board">
					<caption id="caption" style="margin-bottom:40px; font-size:2em; font-weight:bold;"></caption>
				</table>
			</div>
		</main>
	</div>
	<footer id="footer" class="footer"></footer>
	<script src="js/userUseInformation.js"></script>
</body>
</html>