<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>도서관 일정</title>

<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/schedule.css">

<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js'></script>
<script src="/fullcalendar-6.1.14/fullcalendar-6.1.14/dist/index.global.js"></script>
<script src="js/fullcalendar.js"></script>

</head>

<body>
	
	<jsp:include page="index/header.jsp" />

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">도서관 일정</div> <div class="pageRoute">홈 > 도서관 소식 > 도서관 일정</div>
    </div>
</div>


<main>

<div class="zero_container">
	<h1>도서관 일정</h1>
	<hr>
</div>

<div class="calCon2">
    <div class="calCon">
        <div id="calendar"></div>
        
    </div>
</div>

<!--<div class="first_container">-->
<!--	<div class="date_box">-->
<!--		<input type="button" value="<" onclick="">-->
<!--		<select>-->
<!--			<option>2025</option>-->
<!--			<option selected>2024</option>-->
<!--			<option>2023</option>-->
<!--			<option>2022</option>-->
<!--			<option>2021</option>-->
<!--			<option>2020</option>			-->
<!--		</select>-->
<!--		<select>-->
<!--			<option>1월</option>-->
<!--			<option>2월</option>-->
<!--			<option>3월</option>-->
<!--			<option>4월</option>-->
<!--			<option>5월</option>-->
<!--			<option selected>6월</option>-->
<!--			<option>7월</option>-->
<!--			<option>8월</option>-->
<!--			<option>9월</option>-->
<!--			<option>10월</option>-->
<!--			<option>11월</option>-->
<!--			<option>12월</option>-->
<!--		</select>-->
<!--		<input type="button" value=">" onclick="">-->
<!--	</div>-->
<!--</div>-->

<!--<div class="second_container">-->
<!--	<table class="out_table">-->
<!--		<tr>-->
<!--			<th class="sunday"><p>일</p></th>-->
<!--			<th>월</th>-->
<!--			<th>화</th>-->
<!--			<th>수</th>-->
<!--			<th>목</th>-->
<!--			<th>금</th>-->
<!--			<th class="saturday"><p>토</p></th>-->
<!--		</tr>-->
		
<!--		 기본형. 후에 날짜따라 한줄 추가/제거 기능 필요 -->
<!--		<tr>-->
<!--			<td class="have_table">-->
<!--				<table class="in_table">-->
<!--					<tr>-->
<!--						<td class="td1" id="in_table_sunday">-->
<!--							<p>&nbsp;&nbsp;1</p>-->
<!--						</td>-->
<!--					</tr>-->
<!--					<tr>-->
<!--						<td class="td2"><p>sdgsagsagsadgasdgasdgsadgsagdd</p></td>-->
<!--					</tr>-->
<!--				</table>-->
<!--			</td>-->
<!--			<td class="have_table">-->
<!--				<table class="in_table">-->
<!--					<tr>-->
<!--						<td class="td1">-->
<!--							<p>&nbsp;&nbsp;1</p>-->
<!--						</td>-->
<!--					</tr>-->
<!--					<tr>-->
<!--						<td class="td2"><p>sdgsagsagd</p><p>sdgsagsagsadgasdgasdgsadgsagdd</p></td>-->
<!--					</tr>-->
<!--				</table>-->
<!--			</td>-->
<!--			<td class="have_table">-->
<!--				<table class="in_table">-->
<!--					<tr>-->
<!--						<td class="td1">-->
<!--							<p>&nbsp;&nbsp;1</p>-->
<!--						</td>-->
<!--					</tr>-->
<!--					<tr>-->
<!--						<td class="td2"><p>sdgsagsagd</p><p>sdgsagsagsadgasdgasdgsadgsagdd</p></td>-->
<!--					</tr>-->
<!--				</table>-->
<!--			</td>-->
<!--			<td class="have_table">-->
<!--				<table class="in_table">-->
<!--					<tr>-->
<!--						<td class="td1">-->
<!--							<p>&nbsp;&nbsp;1</p>-->
<!--						</td>-->
<!--					</tr>-->
<!--					<tr>-->
<!--						<td class="td2"><p>sdgsagsagd</p><p>sdgsagsagsadgasdgasdgsadgsagdd</p></td>-->
<!--					</tr>-->
<!--				</table>-->
<!--			</td>-->
<!--			<td class="have_table">-->
<!--				<table class="in_table">-->
<!--					<tr>-->
<!--						<td class="td1">-->
<!--							<p>&nbsp;&nbsp;1</p>-->
<!--						</td>-->
<!--					</tr>-->
<!--					<tr>-->
<!--						<td class="td2"><p><img src="images/exex2.png" width="10px"> sdgsagsagd</p><p>sdgsagsagsadgasdgasdgsadgsagdd</p><p>sdgsagsagsadgasdgasdgsadgsagdd</p><p>sdgsagsagsadgasdgasdgsadgsagdd</p><p>sdgsagsagsadgasdgasdgsadgsagdd</p><p>sdgsagsagd</p></td>-->
<!--					</tr>-->
<!--				</table>-->
<!--			</td>-->
<!--			<td class="have_table">-->
<!--				<table class="in_table">-->
<!--					<tr>-->
<!--						<td class="td1">-->
<!--							<p>&nbsp;&nbsp;1</p>-->
<!--						</td>-->
<!--					</tr>-->
<!--					<tr>-->
<!--						<td class="td2"><p>sdgsagsagd</p><p>sdgsagsagsadgasdgasdgsadgsagdd</p></td>-->
<!--					</tr>-->
<!--				</table>-->
<!--			</td>-->
<!--			<td class="have_table">-->
<!--				<table class="in_table">-->
<!--					<tr>-->
<!--						<td class="td1" id="in_table_saturday">-->
<!--							<p>&nbsp;&nbsp;1</p>-->
<!--						</td>-->
<!--					</tr>-->
<!--					<tr>-->
<!--						<td class="td2"><p>sdgsagsagsadgasdgasdgsadgsagdd</p></td>-->
<!--					</tr>-->
<!--				</table>-->
<!--			</td>-->
		<!-- 기본형 -->	
		
		<!--
		
		 기본형 네줄 복붙 
		 
		 -->
		
		<!-- 밑에 한 줄은 날짜가 위아래로 좀 걸칠때 가끔 필요함-->
		<!-- 기능 추가하면서 복붙 -->
<!--		<tr>-->
<!--			<td class="sunday"><p>&nbsp;&nbsp;</p></td>-->
<!--			<td><p>&nbsp;&nbsp;</p></td>-->
<!--			<td><p>&nbsp;&nbsp;</p></td>-->
<!--			<td><p>&nbsp;&nbsp;</p></td>-->
<!--			<td><p>&nbsp;&nbsp;</p></td>-->
<!--			<td><p>&nbsp;&nbsp;</p></td>-->
<!--			<td class="saturday"><p>&nbsp;&nbsp;</p></td>-->
<!--		</tr>-->
<!--	</table>-->
<!--</div>-->

</main>

<jsp:include page="index/footer.jsp" />

</body>
</html>