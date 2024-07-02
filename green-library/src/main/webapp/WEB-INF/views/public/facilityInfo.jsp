<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>facilityInfo</title>
<link href="/css/public/header.css" type="text/css" rel="stylesheet">
<link href="/css/public/footer.css" type="text/css" rel="stylesheet">
<link href="/css/facilityInfo.css" type="text/css" rel="stylesheet">
<link href="/css/public/nav.css" type="text/css" rel="stylesheet">
</head>
<body>
 	<jsp:include page="../index/header.jsp" />
		<nav class="bannerBgr">
		<div class="Banner">
			<div class="pageTitle">부대시설 안내</div>
			<div class="pageRoute">홈 > 부대시설 안내</div>
		</div>
		</nav>
		
		<jsp:include page="../public/navBarUse.jsp" />
		
	<div class="title_container">
		<h1>층별 부대 시설 안내</h1>
	</div>
		<hr class="hr1">
		
		<main>
			<div class="explain borderbox">1F</div>
			<div class="map borderbox">
				<img src="/images/floor1F.jpg" class="image">
				<div class="borderbox column">
					<div class="flex"><b class="btitle">1. 안내 데스크</b>
						<span class="span-explain pb">도서관 위치, 휴관일, 자료이용 등에 관한 궁금한 내용을 물어볼 수 있는 곳입니다.</span>
					</div>
					<div class="flex"><b class="btitle">2. 어린이자료실</b>
						<span class="span-explain pb">유아, 초등학교 저학년 자료와 학년별 교과수록자료 등 을 비치하고 있으며, 자료실에는 아이들에게 책을 읽어 줄 수 있는 '이야기방'과 유아용 자료를 모아 놓은 '그림책나라'가 있습니다.</span>
					</div>
					<div class="flex"><b class="btitle">3. 꿈창작실</b>
						<span class="span-explain pb">공간 미래(아날로그 메이킹 및 복합 체험 활동 공간), 공간 꿈(디지털 제작 장비 활용 메이킹 활동 공간), 첨단기술 체험관(모빌리티 체험 및 로봇 플레이·전시 공간)이 있습니다.</span>
					</div>
					<div class="flex"><b class="btitle">4.가족공작실</b>
						<span class="span-explain pb">자율참여형 메이킹 활동 공간입니다.</span>
					</div>
					<div class="flex"><b class="btitle">5. 수유실</b>
						<span class="span-explain pb">기저귀교환대가 마련되어 있습니다.</span>
					</div>
					<div class="flex" style="border-bottom:none;"><b class="btitle">6. 북카페</b>
						<span class="span-explain pb">음료를 마시며 편하게 책을 읽고 쉴 수 있는 공간입니다.</span>
					</div>
				</div>
			</div>
			<div class="explain borderbox">2F</div>
			<div class="map borderbox">
				<img src="/images/floor2F.jpg" class="image">
				<div class="borderbox column">
					<div class="flex">
						<b class="btitle">1. 희망창작실</b><br><br>
						<span class="span-explain">청소년 대상 자료가 개가제로 비치되어 있으며, 청소년의 디지털 미디어 및 멀티미디어 창작 활동을 위한 ‘공간 희망’과 ‘공간 상상’을 운영하고 있습니다. 특히 ‘공간 상상’은 청소년이 창의적인 디지털 콘텐츠를 제작할 수 있도록 1인 미디어 창작 공간으로 구성되어 있습니다.</span>
					</div>
					<div class="flex">
						<b class="btitle">2. 체험형동화구현실</b><br><br><br>
						<span class="span-explain">대형 스크린 속 가상공간에서 펼쳐지는 다양한 동화를 체험할 수 있습니다.</span>
					</div>
					<div class="flex" style="border-bottom:none;">
						<b class="btitle">3. 전시실</b><br><br><br>
						<span class="span-explain">전시실은 어린이 청소년들의 학술·문화 활동을 지원하기 위하여 국립어린이청소년도서관에서 직접 주관하는 연간 기획전시와 어린이청소년 관련 기관 및 단체의 대관전시로 운영됩니다.</span>
					</div>
				</div>
			</div>
			<div class="explain borderbox">3F</div>
			<div class="map borderbox">
				<img src="/images/floor3F.jpg" class="image">
				<div class="borderbox column">
					<div class="flex">
						<b class="btitle">1. 연구자료실</b><br><br>
						<span class="span-explain">국내외 아동문학상 수상작, 아동문학 연구자료, 세계 여러 나라의 그림책·동화책, 미국교과서 등을 비치하여 다양한 문화를 간접적으로 접할 수 있는 기회를 넓히고 연구자를 위한 공간을 마련하여 아동문학 및 독서 등 관련 연구 활동을 지원하고 있습니다.</span>
					</div>
					<div class="flex">
						<b class="btitle">2. 개인문고</b><br><br>
						<span class="span-explain">한국을 대표하는 아동문학가의 개인문고(강소천, 마해송, 박홍근, 윤석중, 조대현, 조흔파, 홍성찬)의 설치 및 연구자를 위한 공간을 마련하여 아동문학 및 독서 등 관련 연구 활동을 지원하고 있습니다.</span>
					</div>
					<div class="flex">
						<b class="btitle">3. 멀티미디어공간</b><br><br>
						<span class="span-explain">어린이, 청소년 관련 전자자료와 원문정보 등 다양한 콘텐츠를 이용할 수 있습니다.</span>
					</div>
					<div class="flex" style="border:none;">
						<b class="btitle">4. 서고</b><br><br>
						<span class="span-explain">자료실에 비치된 최근자료를 제외한 국내·외 아동서와 청소년자료, 일반자료 등이 서고에 보관되어 있으며, 원하는 자료를 신청하여 이용할 수 있습니다.</span>
					</div>
				</div>
			</div>
			<div class="explain borderbox">4F</div>
			<div class="map borderbox">
				<img src="/images/floor4F.png" class="image">
				<div class="borderbox column">
					<div class="flex">
						<b class="btitle">1. 증강현실 그림책방</b><br><br>
						<span class="span-explain">증강현실 그림책방에서는 설치된 태블릿을 이용하여 AR 책카드, XR 책놀이, AR 그림책을 만날 수 있습니다.</span>
					</div>
					<div class="flex">
						<b class="btitle">2. 강당</b><br><br>
						<span class="span-explain">문화행사, 강연회 등을 개최할 수 있으며 120석의 좌석을 갖추고 있습니다.</span>
					</div>
					<div class="flex">
						<b class="btitle">3. 세미나실</b><br><br>
						<span class="span-explain">회의, 행사 등을 개최하는 세미나실은 25개의 좌석을 갖추고 있습니다.</span>
					</div>
					<div class="flex" style="border:none;">
						<b class="btitle">4. 독서토론실</b><br><br>
						<span class="span-explain">독서토론을 위해 마련된 공간으로 독서토론실I(12), 독서토론실II(8석)으로 구성되어 있습니다.</span>
					</div>
				</div>
			</div>
			<div class="explain borderbox">B1</div>
			<div class="map borderbox">
				<img src="/images/BasementB1.png" class="image">
				<div class="borderbox column">
					<div class="flex">
						<b class="btitle">1. 어린이독도체험관</b><br><br><br><br>
						<span class="span-explain">소중한 우리의 땅 독도,
지금 당장 달려가서 보고 싶지만 어린이들이 쉽게 갈 수 없는 먼 곳에 있어요. 그래서 독도에 대해 배우고, 독도와 함께 놀 수 있는 '작은 독도'를 만들었어요. 부모님과 선생님, 친구들과 함께 '어린이독도체험관'에 오세요. 독도 강치가 여러분을 기다리고 있습니다.</span>
					</div>
					<div class="flex" style="border:none;">
						<b class="btitle">2. 증강현실체험관</b><br><br><br><br>
						<span class="span-explain">증강현실체험관에서는 홀로그램과 증강현실 기술을 활용한 AR 뮤지컬 ‘잃어버린 책을 찾아서＇를 관람할 수 있습니다.</span>
					</div>
				</div>
			</div>
		</main>
		<jsp:include page="../index/footer.jsp" />
</body>
</html>