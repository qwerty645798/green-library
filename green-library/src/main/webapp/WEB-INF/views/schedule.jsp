<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>도서관 일정</title>

<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/schedule.css">

</head>

<body>

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">도서관 일정</div> <div class="pageRoute">홈 > 도서관 소식 > 도서관 일정</div>
    </div>
</div>

<header id="header" class="header"></header>

<main>

<div class="zero_container">
	<h1>도서관 일정</h1>
	<hr>
</div>

<div class="first_container">
	<div class="date_box">
		<input type="button" value="<" onclick="">
		<select>
			<option>2025</option>
			<option selected>2024</option>
			<option>2023</option>
			<option>2022</option>
			<option>2021</option>
			<option>2020</option>			
		</select>
		<select>
			<option>1월</option>
			<option>2월</option>
			<option>3월</option>
			<option>4월</option>
			<option>5월</option>
			<option selected>6월</option>
			<option>7월</option>
			<option>8월</option>
			<option>9월</option>
			<option>10월</option>
			<option>11월</option>
			<option>12월</option>
		</select>
		<input type="button" value=">" onclick="">
	</div>
</div>

<div class="second_container">
	<table>
		<tr>
			<th class="sunday"><p>일</p></th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th class="saturday"><p>토</p></th>
		</tr>
		<!-- 이중 tr 안됨. 그냥 해당 td를 table 꽉채워서 2중 테이블로 -->
		<!-- 기본형 제작중. css도 수정해야됨-->
		<tr>
			<tr class="date_num">
				<td class="sunday"><p>&nbsp;&nbsp;1</p></td>
				<td><p>&nbsp;&nbsp;2</p></td>
				<td><p>&nbsp;&nbsp;3</p></td>
				<td><p>&nbsp;&nbsp;4</p></td>
				<td><p>&nbsp;&nbsp;5</p></td>
				<td><p>&nbsp;&nbsp;6</p></td>
				<td class="saturday"><p>&nbsp;&nbsp;7</p></td>
			</tr>
			<tr class="date_txt">
				<td>
					<ul>
						<li>일요일은
						<li>매우매우
						<li>격하게
						<li>쉬는날ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
					</ul>
				</td>
				<td></td>
				<td>sdgasgdasgdasgsadgasdfasdfsadgasdgasdfsadfafasdgsadg</td>
				<td></td>
				<td></td>
				<td>sdgasgdasgdasgsadgasdfasdfsadgasdgasdfsadfafasdgsadg</td>
				<td></td>
			</tr>
		</tr>
		<!-- 기본형 제작중. css도 수정해야됨 밑은 어차피 복붙임-->	
		
		
		<tr>
			<td class="sunday"><p>&nbsp;&nbsp;1</p>agfasg</td>
			<td>
				<p>&nbsp;&nbsp;2</p>
				<ul>
					<li>일요일은
					<li>매우매우
					<li>격하게
					<li>쉬는날ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
				</ul>
			</td>
			<td><p>&nbsp;&nbsp;3</p>sdgasgdasgdasgsadgasdfasdfsadgasdgasdfsadfafasdgsadg</td>
			<td><p>&nbsp;&nbsp;4</p>sdgasgdasgdasgsadgasdfasdfsadgasdgasdfsadfafasdgsadg</td>
			<td><p>&nbsp;&nbsp;5</p>sdgasgdasgdasgsadgasdfasdfsadgasdgasdfsadfafasdgsadg</td>
			<td><p>&nbsp;&nbsp;6</p>dgasgdasgdasgsadgasdfasdfsadgasdgasdfsadfafasdgsadg</td>
			<td class="saturday"><p>&nbsp;&nbsp;7</p>sdgasgdaskhgdasgsadgasdfasdfsadgasdgasdfsadfafasdgsadg</td>
		</tr>
		<tr>
			<td class="sunday"><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td class="saturday"><p>&nbsp;&nbsp;</p></td>
		</tr>
		<tr>
			<td class="sunday"><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td class="saturday"><p>&nbsp;&nbsp;</p></td>
		</tr>
		<tr>
			<td class="sunday"><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td class="saturday"><p>&nbsp;&nbsp;</p></td>
		</tr>
		<!-- 밑에 여섯번째는 날짜가 위아래로 좀 걸칠때 가끔 -->
		<tr>
			<td class="sunday"><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td><p>&nbsp;&nbsp;</p></td>
			<td class="saturday"><p>&nbsp;&nbsp;</p></td>
		</tr>
	</table>
</div>

</main>

<footer id="footer" class="footer"></footer>


</body>
</html>