<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

.main {
	width: 1260px;
	display: flex;
	flex-direction: column;
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

table.btn {
	width: 300px;
	height: 150px;
	border-collapse: collapse;
	border-top: 2px #697DA0 solid;
	border-bottom: 2px #697DA0 solid;
}

table.btn th, table.btn td {
	text-align: center;
	vertical-align: middle;
	font-size: 1.5em;
}

table.btn th {
	background: #E3E6E9;
}

table.btn td {
	font-weight: bold;
	color: #666666;
	background: #F2F2F2;
}

.Dheader {
	width: 200px;
	height: 100px;
	font-size: 1.4em;
	margin: 0 50px;
	background: #EBEBEB;
	cursor: pointer;
}

table#board {
	width: 1250px;
	border-collapse: collapse;
	border-top: 2px #ADADAD solid;
	border-bottom: 2px #ADADAD solid;
	border-top: 2px #ADADAD solid;
}

table#board th {
	background: #F7F7F7;
}

table#board th, table#board td {
	height: 50px;
	border-bottom: 2px #D7D7D7 solid;
	text-align: center;
}
</style>

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
	<script>
		let condition = "${condition}"
		let table = document.getElementById("board");
		let tr = document.createElement("tr");
		let th1, th2, th3, th4, th5, th6, th7;
		let caption = document.getElementById("caption");
		if(condition == "rentHistory"){
			th1 = "No";
			th2 = "등록번호";
			th3 = "신청도서정보";
			th4 = "대출일";
			th5 = "반납예정일";
			th6 = "상태";
			th7 = "대출연장";
			caption.innerHTML = "전체 대출 이력";
		}
		else if(condition == "borrow"){
			th1 = "No";
			th2 = "등록번호";
			th3 = "신청도서정보";
			th4 = "대출일";
			th5 = "반납일";
			th6 = "상태";
			th7 = "대출신청";
			caption.innerHTML = "대출중인 도서";
		}
		else if(condition == "reserve"){
			
			th1 = "No";
			th2 = "등록번호";
			th3 = "신청도서정보";
			th4 = "신청일";
			th5 = "반납예정일";
			th6 = "예약순위";
			th7 = "대출연장";
			caption.innerHTML = "신청한 예약도서";
		}
		else if(condition == "interest"){
			th1 = "No";
			th2 = "등록번호";
			th3 = "관심도서제목";
			th4 = "관심도서저자";
			th5 = "상태";
			th6 = "대출신청";
			th7 = "관심도서제거";
			caption.innerHTML = "관심도서 조회";
		}
		tr.innerHTML = `
	        <th>\${th1}</th>
	        <th>\${th2}</th>
	        <th>\${th3}</th>
	        <th>\${th4}</th>
	        <th>\${th5}</th>
	        <th>\${th6}</th>
	        <th>\${th7}</th>
	    `;
		table.appendChild(tr);
		
	</script>
</body>
</html>