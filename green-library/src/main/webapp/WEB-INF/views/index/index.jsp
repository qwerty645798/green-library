<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Green Library Main</title>
    <link href="/reset/reset.css" type="text/css" rel="stylesheet">
    <link href="/css/index.css" type="text/css" rel="stylesheet">
    
</head>
<body>



  <jsp:include page="../index/header.jsp" />

<div class="mainPage">

    <div class="bookSearchText">
        <label>
            <div class="customSearchform">
                <select class="searchSel">
                    <option>전체</option>
					<option>도서명</option>
					<option>저자</option>
					<option>출판사</option>
					<option>내용</option>
					<option>인기도서</option>
					<option>신착도서</option>
                </select>
                <input type="text" name="search">
                <input type="button" value="자료 찾기">
            </div>
        </label>
    </div>
    
    <br><br>

    <div id="quickBundle" class="quickBundle">
        <div id="quick1" class="quickPage"><img src="/images/useTime.png">
            이용 시간</div>
        <div id="quick2" class="quickPage"><img src="/images/bookExtension.png">
            대출 연장</div>
        <div id="quick3" class="quickPage"><img src="/images/hopeBook.png">
            희망도서</div>
        <div id="quick4" class="quickPage"><img src="/images/help.png">
            문의사항</div>
        <div id="quick5" class="quickPage"><img src="/images/calendar.png">
            캘린더</div>
    </div>

    <br><br>
    
    <div class="tabCon1">
        <div class="tabCon2">
            <ul class="bookTab">
                <li class="here">신착 도서</li>
                <li>인기 도서</li>
            </ul>
        </div>
    </div>
    
    


    <div class="bookSwipe">
    <div class="backBtn"></div>
        <div class="window">
	        <ul class="newbook">
	        	<li><img src="/images/SmallThingsLikeThis.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        		<li><img src="/images/SmallThingsLikeThis.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        		<li><img src="/images/SmallThingsLikeThis.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        		<li><img src="/images/SmallThingsLikeThis.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        		<li><img src="/images/SmallThingsLikeThis.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
	        	<li><img src="/images/녹나무의여신.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
		        	########################)</div></li>
	        	<li><img src="/images/녹나무의여신.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
		        	########################)</div></li>
	        	<li><img src="/images/녹나무의여신.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
		        	########################)</div></li>
	        	<li><img src="/images/녹나무의여신.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
		        	########################)</div></li>
	        	<li><img src="/images/녹나무의여신.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        		<li><img src="/images/SmallThingsLikeThis.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        		<li><img src="/images/SmallThingsLikeThis.jpg">
	        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
	       
	        </ul>
        </div>
        <div class="goBtn"></div>
    </div>

    <div class="bookSwipe2">
        <div class="backBtn2"></div>
        <div class="window2">
        <ul class="popbook">
        	<li><img src="/images/녹나무의여신.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        	<li><img src="/images/녹나무의여신.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        	<li><img src="/images/녹나무의여신.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        	<li><img src="/images/녹나무의여신.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        	<li><img src="/images/녹나무의여신.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        	<li><img src="/images/SmallThingsLikeThis.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
        	########################)</div></li>
       		<li><img src="/images/SmallThingsLikeThis.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
        	########################)</div></li>
       		<li><img src="/images/SmallThingsLikeThis.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
        	########################)</div></li>
       		<li><img src="/images/SmallThingsLikeThis.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
        	########################)</div></li>
       		<li><img src="/images/SmallThingsLikeThis.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
        	########################)</div></li>
        	<li><img src="/images/녹나무의여신.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        	<li><img src="/images/녹나무의여신.jpg">
        	<div class="bookt">(책 제목만 써주세요. 
	        	########################)</div></li>
        </ul>
        </div>
        <div class="goBtn2"></div>
    </div>

    <br><br>

	<div class="infoBoard1">
		<div class="infoBoard2">
		<div class="titleQuick">
			<span>공지사항</span>
			<img src="/images/gotoPage.png">
		</div>
		
	        <table>
	        	<tr>
	        	<td>(게시자)</td>
	        	<td>(제목)</td>
	        	<td>(게시 날짜)</td>
	        	<tr>
	        	
	        	<tr>
	        	<td>(게시자)</td>
	        	<td>(제목)</td>
	        	<td>(게시 날짜)</td>
	        	<tr>
	        	
	        	<tr>
	        	<td>(게시자)</td>
	        	<td>(제목)</td>
	        	<td>(게시 날짜)</td>
	        	<tr>
	        	
	        	<tr>
	        	<td>(게시자)</td>
	        	<td>(제목)</td>
	        	<td>(게시 날짜)</td>
	        	<tr>
	        	
	        	<tr>
	        	<td>(게시자)</td>
	        	<td>(제목)</td>
	        	<td>(게시 날짜)</td>
	        	<tr>
	        </table>
	    </div>
	</div>
    
    
</div>

 <jsp:include page="../index/footer.jsp" />
 
 <script src="/js/header.js"></script>
 <script src="/js/index.js"></script>
    
</body>
</html>