<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Green Library Main</title>
    <link href="css/public/header.css" type="text/css" rel="stylesheet">
	<link href="css/public/footer.css" type="text/css" rel="stylesheet">
    <link href="/reset/reset.css" type="text/css" rel="stylesheet">
    <link href="/css/index.css" type="text/css" rel="stylesheet">
    
</head>
<body>


<jsp:include page="../index/header.jsp" />

<header id="header" class="header"></header>

<div class="mainPage">

    <div class="bookSearchText">
        <label>
            <div class="customSearchform">
                <select class="searchSel">
                    <option value="도서명">도서명</option>
                    <option value="저자명">저자명</option>
                    <option value="출판사">출판사</option>
                </select>
                <input type="text" name="search">
                <input type="button" value="자료 찾기">
            </div>
        </label>
    </div>
    
    <br><br>

    <div class="quickBundle">
        <div class="quickPage"><img src="/images/clock-nine.png"><!-- 이용 시간 --></div>
        <div class="logoChg"><span>이용시간</span></div>
        <div class="quickPage"><img src="/images/timeforward.png"><!-- 대출 연장 --></div>
        <div class="logoChg"><span>대출연장</span></div>
        <div class="quickPage"><img src="/images/hopebook.jpg"><!-- 희망도서 --></div>
        <div class="logoChg"><span>희망도서</span></div>
        <div class="quickPage"><img src="/images/square-q.png"><!-- 문의사항 --></div>
        <div class="logoChg"><span>문의사항</span></div>
        <div class="quickPage"><img src="/images/calendar-days.png"><!-- 캘린더 --></div>
        <div class="logoChg"><span>캘린더</span></div>
    </div>

    <br><br>

    <div class="bookSwipe">
        <div class="newBooks">
            <img class="movingBook" src="/images/SmallThingsLikeThis.jpg">
            <img class="movingBook" src="/images/SmallThingsLikeThis.jpg">
            <img class="movingBook" src="/images/SmallThingsLikeThis.jpg">
        </div>
    </div>

    <div class="bookSwipe">
        <div class="popularBooks">
            <img class="movingBook" src="/images/녹나무의여신.jpg">
            <img class="movingBook" src="/images/녹나무의여신.jpg">
            <img class="movingBook" src="/images/녹나무의여신.jpg">
        </div>
    </div>

    <br><br>

    <div class="noname">
        <div class="infoBoard">게시판 파트</div>
    </div>
    
</div>

<footer id="footer" class="footer"></footer>  


 
<jsp:include page="../index/footer.jsp" />

<script src="js/header.js" type="text/javascript"></script>
    
</body>
</html>