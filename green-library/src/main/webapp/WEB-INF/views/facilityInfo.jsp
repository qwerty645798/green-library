<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>facilityInfo</title>
<link href="css/public/header.css" type="text/css" rel="stylesheet">
<link href="css/public/footer.css" type="text/css" rel="stylesheet">
<link href="css/public/nav.css" type="text/css" rel="stylesheet">
<link href="css/facilityInfo.css" type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="index/header.jsp" />
		<nav class="bannerBgr">
		<div class="Banner">
			<div class="pageTitle">부대시설 안내</div>
			<div class="pageRoute">홈 > 부대시설 안내</div>
		</div>
	</nav><br><br>
		<main>
			<div class="explain">1F</div>
			<div class="map roundbox">
				<img src="images/floor1F.jpg" class="image">
				
			</div>
			<div class="explain">2F</div>
			<div class="map roundbox">
				<img src="images/floor2F.jpg" class="image">
			</div>
			<div class="explain">3F</div>
			<div class="map roundbox">
				<img src="images/floor3F.jpg" class="image">
			</div>
			<div class="explain">4F</div>
			<div class="map roundbox">
				<img src="images/floor4F.png" class="image">
			</div>
			<div class="explain">B1</div>
			<div class="map roundbox">
				<img src="images/BasementB1.png" class="image">
			</div>
			
		</main>
		<jsp:include page="index/footer.jsp" />
</body>
</html>