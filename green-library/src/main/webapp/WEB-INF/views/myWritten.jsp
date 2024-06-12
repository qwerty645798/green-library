<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 글</title>


<link rel="stylesheet" type="text/css" href="css/myWritten.css">
<link rel="stylesheet" type="text/css" href="css/nav_hyun.css">


</head>


<body>

<header id="header" class="header"></header>

<nav class="navnav">
	<div class="hyun">
		<div class="big_name">내가 쓴 글</div> 
		<div class="small_name">홈 > 마이 페이지 > 내가 쓴 글</div>
	</div>
</nav>

<main>
	<div class="container">
		<table class="container_table">
			<tr>
				<td style="height: 30px; border-bottom: 1px solid green;">&nbsp;&nbsp;&nbsp;희망 도서 신청 내역</td>				
			</tr>
			<tr>
				<td>
					<table class="innerContainer"><!-- 여기에 데이터 증가/감소 하는거 반영되게 짜면 될 듯 -->
						<tr>
							<th style="width: 12%;">번호</th>
							<th style="width: 12%;">이름</th>
							<th style="width: 12%;">신청일</th>
							<th style="width: 52%;">도서명</th>
							<th style="width: 12%;">승인 상태</th>
						</tr>
						<!-- 이 밑으로 추가/삭제 반영 기능 -->
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
						</tr>
                        <tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
						</tr>
                        <tr>
							<td>1</td>
							<td>2....</td>
							<td>3</td>
							<td>46666666666666666666666<br>66<br>6666666666666666 666666666666666 6666 6666666666666666666666666666666666666666666666666666666666666666666666666666</td>
							<td>5</td>
						</tr>
                        <!-- 이 위로 추가/삭제 반영 기능 -->
					</table>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="container">
		<table class="container_table">
			<tr>
				<td style="height: 30px; border-bottom: 1px solid green;">&nbsp;&nbsp;&nbsp;문의 내역</td>				
			</tr>
			<tr>
				<td>
					<table class="innerContainer"><!-- 여기에 데이터 증가/감소 하는거 반영되게 짜면 될 듯 -->
						<tr>
                            <th style="width: 12%;">번호</th>
							<th style="width: 12%;">이름</th>
							<th style="width: 12%;">문의 날짜</th>
							<th style="width: 52%;">제목</th>
							<th style="width: 12%;">답변 상태</th>
						</tr>
						<!-- 이 밑으로 추가/삭제 반영 기능 -->
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
						</tr>
                        <tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>4</td>
							<td>5</td>
						</tr>
                        <tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
							<td>46666666666666666666666<br>66<br>6666666666666666 666666666666666 6666 6666666666666666666666666666666666666666666666666666666666666666666666666666</td>
							<td>5</td>
						</tr>
                        <!-- 이 위로 추가/삭제 반영 기능 -->
					</table>	
				</td>
			</tr>
		</table>
	</div>

</main>

<footer id="footer" class="footer"></footer>
</body>
</html>