<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>wayToCome</title>
<link href="css/public/header.css" type="text/css" rel="stylesheet">
<link href="css/public/footer.css" type="text/css" rel="stylesheet">
<link href="css/public/nav.css" type="text/css" rel="stylesheet">
<link href="css/wayToCome.css" type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="index/header.jsp" />
	<nav class="bannerBgr">
		<div class="Banner">
			<div class="pageTitle">오시는 길</div>
			<div class="pageRoute">홈 > 오시는 길</div>
		</div>
	</nav>
	
	<div class="title_container">
						<h1>그린도서관 오시는 길</h1>
					</div>
					<hr class="hr1">
		
			<div class="outContainer">
				<main>
					
					<br>
					<div class="container"><div id="map" class="map"></div></div>
					<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=91923fd361ed583dba90f7d5171f8349&libraries=services"></script>
					<script src="js/wayToCome.js"></script>
				</main>
				
				<br><br>
				
				<div class="container">
					<div class="address">
						<img src="images/location.png">
						주소: 서울 강남구 테헤란로5길 24 장연빌딩<br>
						<img src="images/call.png">
						전화: 010-0000-0000
					</div>

				</div>
				
				<br>
				
				<div class="container">
					
					<span class="transport">그린도서관 교통편</span> 
				<table>
				<caption><img src="images/subway.png">지하철정보</caption>
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
				<caption><img src="images/bus.png">버스정보</caption>
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
		</div>
		
	
	<jsp:include page="index/footer.jsp" />
</body>
</html>
