<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/wayToCome.css" type="text/css" rel="stylesheet">
</head>
<body>
	<header id="header" class="header"></header>
	<nav class="roundbox">
		<div
			style="width: 800px; display: flex; justify-content: center; position: relative">
			<div style="font-size: 2.5em; margin-top: 10px;">
				오시는길
			</div>
			<div
				style="float: right; position: absolute; right: 20px; margin-top: 60px;">
				<a href="index">홈</a>>오시는길
			</div>
		</div>
	</nav><Br><br>
	<main>
		<div class="container"><div style="width:800px; font-weight:500; font-size:1.2em;">그린도서관</div></div><br>
		<div class="container"><div id="map" style="width:800px;height:400px;"></div></div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=91923fd361ed583dba90f7d5171f8349&libraries=services"></script>
		<script src="js/wayToCome.js"></script>
	</main><br><br>
	<div class="container"><div style="width:800px; font-weight:500; font-size:1.2em;"><span style="color:red;">그린도서관 교통편</span> 서울 강남구 테헤란로5길 24 장연빌딩</div></div><br>
	<div class="container">
	<table>
	<caption>→지하철정보</caption>
		<tr>
			<th class="text">노선</th>
			<th class="input">출구</th>
		</tr>
		<tr>
			<td class="text">강남역 (2호선,신분당선)</td>
			<td class="input">&#9322;번출구</td>
		</tr>
	</table></div><br>
	<div class="container">
	<table>
	<caption>→버스정보</caption>
		<tr>
			<th class="text">정류장명</th>
			<th class="input">버스번호</th>
		</tr>
		<tr>
			<td class="text">&#9312;강남역.강남역사거리(22167)</td>
			<td class="input">[간선] 146, [간선] 640, [간선] 740, [간선] 8146,<br>[심야] N61, [심야] N64, [심야] N75, [직행] 1700, <Br>[직행] 2000, [직행] 2000-1, [직행] 7007, [직행] 9303</td>
		</tr>
		<tr>
			<td class="text">&#9313;강남역.삼성전자(22859)</td>
			<td class="input">[마을] 서초03, [마을] 서초09</td>
		</tr>
		<tr>
			<td class="text">&#9314;강남역.서초초교앞(22850)</td>
			<td class="input">[마을] 서초03</td>
		</tr>
		<tr>
			<td class="text">&#9315;강남역(23813)</td>
			<td class="input">[공항] 6020</td>
		</tr>
		<tr>
			<td class="text">&#9316;강남역(22173)</td>
			<td class="input">[간선] 640, [지선] 4312, [광역] 9711</td>
		</tr>
	</table>
	</div>
	<footer id="footer" class="footer"></footer>
</body>
</html>
