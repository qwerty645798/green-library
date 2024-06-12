<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userUseInformation</title>
<style>
a {
	text-decoration: none;
	color: black;
}

a.nav:hover {
	text-decoration: underline;
	color: dodgerblue;
}

.roundbox {
	border-radius: 20px;
}

.container {
	display: flex;
	justify-content: center;
}
.main{
	width:1260px;
}
nav {
	width: 1520px;
	height: 90px;
	border: none;
	display: flex;
	justify-content: center;
	background: #ECD9BC;
}

.center {
	display: flex;
	justify-content: center;
	align-items: center;
}

.btnbox {
	width: 300px;
	height: 150px;
}

.borderbox {
	box-sizing: border-box;
}

table {
	width: 300px;
	height: 150px;
	border-collapse: collapse;
	border-top: 2px #697DA0 solid;
	border-bottom: 2px #697DA0 solid;
}

th, td {
	text-align: center;
	vertical-align: middle;
	font-size: 1.5em;
}

th {
	background: #E3E6E9;
}

td {
	font-weight: bold;
	color: #666666;
	background: #F2F2F2;
}

.Dheader {
	width: 100px;
	height: 50px;
	font-size: 1.4em;
}
</style>
</head>
<body>
	<header id="header" class="header"></header>
	<nav class="roundbox">
		<div
			style="width: 1200px; display: flex; justify-content: center; position: relative">
			<div style="font-size: 2.5em; margin-top: 10px;">도서 이용 정보</div>
			<div
				style="float: right; position: absolute; right: 20px; margin-top: 60px;">
				<a href="index" class="nav">홈</a>>도서 이용 정보
			</div>
		</div>
	</nav>
	<div class="container" style="margin-top: 64px;">
		<div class="main">
			<div class="center btnbox">
				<a href="#">
					<table>
						<tr>
							<th>일반 예약</th>
						</tr>
						<tr>
							<td>0 / 0</td>
						</tr>
					</table>
				</a>
			</div>
			<div style="width: 30px;"></div>
			<div class="center btnbox">
				<a href="#">
					<table>
						<tr>
							<th>대출 연체</th>
						</tr>
						<tr>
							<td>0 / 0</td>
						</tr>
					</table>
				</a>
			</div>
			<div style="width: 30px;"></div>
			<div class="center btnbox">
				<a href="#">
					<table>
						<tr>
							<th>나의 상태</th>
						</tr>
						<tr>
							<td>대출 가능</td>
						</tr>
					</table>
				</a>
			</div>
		</div>
		<div class="container" style="margin-top: 50px;">
			<div class="center Dheader">
				<span>전체 대출이력</span>
			</div>
			<div class="center Dheader">
				<span>대출중인 도서</span>
			</div>
			<div class="center Dheader">
				<span>신청한 예약도서</span>
			</div>
			<div class="center Dheader">
				<span>관심도서 조회</span>
			</div>
			<div class="center Dheader">
				<span>신청한 희망도서</span>
			</div>
			<div class="center Dheader">
				<span>나의 문의내역</span>
			</div>
		</div>
	</div>
	<footer id="footer" class="footer"></footer>
</body>
</html>