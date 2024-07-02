<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>도서관 일정</title>

<link rel="stylesheet" type="text/css" href="/css/public/nav.css">
<link rel="stylesheet" type="text/css" href="/css/schedule.css">

<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js'></script>
<script src="/js/fullcalendar-6.1.14/fullcalendar-6.1.14/dist/index.global.js"></script>
<script src="/js/fullcalendar.js"></script>

</head>

<body>
	
	<jsp:include page="../index/header.jsp" />

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">도서관 일정</div> <div class="pageRoute">홈 > 도서관 소식 > 도서관 일정</div>
    </div>
</div>

<jsp:include page="../public/navBarNews.jsp"/>


<main>

<div class="title_container">
	<h1>도서관 일정</h1>
	
</div>
<hr class="hr1">

<div class="calCon2">
    <div class="calCon">
        <div id="calendar"></div>
        
    </div>
</div>



</main>

<jsp:include page="../index/footer.jsp" />

</body>
</html>