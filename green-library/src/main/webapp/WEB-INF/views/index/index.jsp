<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Green Library Main</title>
    <link href="/css/index.css" type="text/css" rel="stylesheet">
    <script>
   	let message = "${message}";
   	if(message == "userDelete")
   		alert("회원탈퇴가 완료되었습니다.");
    </script>
    
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js'></script>
	<script src="/fullcalendar-6.1.14/fullcalendar-6.1.14/dist/index.global.js"></script>
	<script src="js/fullcalendar.js"></script>
    
</head>
<body>

  <jsp:include page="../index/header.jsp" />

<div class="mainPage">

    <div class="bookSearchText">
       
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
                <input type="text" name="search" onkeypress="checkEnter(event)">
                <img src="/images/searchBtn.png" onclick="lets_search()">
<!--                 <input type="button" value="자료 찾기"> -->
            </div>
        
    </div>
    
    <br><br>

    <div id="quickBundle" class="quickBundle">
    
       	<div id="quick1" class="quickPage">
       	<a href="/placeUsetime">
       	<img src="/images/useTimeGreen.png">
            이용 시간
        </a>
        </div>
        <div id="quick1" class="quickPage">
       	<a href="/user/bookLoanExtension">
       	<img src="/images/bookExtensionGreen.png">
            대출 연장
        </a>
        </div>
        <div id="quick1" class="quickPage">
       	<a href="/user/hopeBookApply">
       	<img src="/images/hopeBookGreen.png">
            희망도서
        </a>
        </div>
        <div id="quick1" class="quickPage">
       	<a href="/oftenAsk">
       	<img src="/images/helpGreen.png">
            문의사항
        </a>
        </div>
        <div id="quick1" class="quickPage">
       	<a href="/schedule">
       	<img src="/images/calendarGreen.png">
            캘린더
        </a>
        </div>
       	
    </div>

    <br><br>
    
    <div class="bookslide">
    
    <div class="tabCon1">
        <div class="tabCon2">
            <ul class="bookTab">
                <li class="here">신착 도서</li>
                <li>인기 도서</li>
            </ul>
            <img src="/images/gotoPage.png">
        </div>
    </div>
	
	<c:set var="itemsPerPage" value="8"/>
	<c:set var="totalPages" value="${(totalItems + itemsPerPage - 1) / itemsPerPage}" />
    
    <div class="bookSwipe">
    <div class="backBtn">
    <img class="arBtn" src="/images/goback.png"></div>
        <div class="window">
	        <ul class="newbook">
				<c:forEach var="num" begin="0" end="9">
					
					
		        	<li>
						<c:set var="index" value="${num}"/>
						<a href="/bookDetail?bookId=${items[index].book_id}">
						<img src="/images/${items[index].img}">
			        	<span class="bookt">
							${items[index].title}
						</span></a>
					</li>
					


	       		</c:forEach>
	        </ul>
        </div>
        <div class="goBtn">
        <img class="arBtn" src="/images/go.png"></div>
    </div>

    <div class="bookSwipe2">
        <div class="backBtn2">
        <img class="arBtn" src="/images/goback.png"></div>
        <div class="window2">
        <ul class="popbook">
			
			<c:forEach var="num" begin="0" end="9">
								
								
	        	<li>
					<c:set var="index" value="${num}"/>
					<a href="/bookDetail?bookId=${pops[index].book_id}">
					<img src="/images/${pops[index].img}">
		        	<span class="bookt">
							${items[index].title}
					</span></a>
				</li>

			</c:forEach>

        </ul>
        </div>
        <div class="goBtn2">
        <img class="arBtn" src="/images/go.png"></div>
    </div>
    </div>
    

    <br><br>

	<div class="infoBoard1">
		<div class="infoBoard2">
		<div class="titleQuick">
			<span>공지사항</span>
			<a href="/notification">
			<img class="gotoNotify" src="/images/gotoPage.png">
			</a>
			
		</div>
		
<!-- 		제일 최근 공지 6개만 뜨게 -->
	        	
<!-- 게시글이 5개 이상일 때 6개씩 뜨게 하려고 조건문 넣었어요. -->

				<c:set var="annoList" value="${fn:length(announce)}"/>

				<c:choose>
					<c:when test="annoList>=6}">
						<c:forEach var="num" begin="${annoList}" end="${annoList-5}">
						<table>
							<tr>
					        	<td>${announce[num].writerId}</td>
					        	<td>${announce[num].announcementTitle}</td>
					        	<td>${announce[num].writeDate}</td>
				        	</tr>
				        	</table>
						</c:forEach>
					</c:when>
					<c:when test="${annoList<6}">
						<c:forEach var="num" begin="0" end="5">
						<table>
							<tr>
					        	<td>${announce[num].writerId}</td>
					        	<td>${announce[num].announcementTitle}</td>
					        	<td>${announce[num].writeDate}</td>
				        	</tr>
				        	</table>
						</c:forEach>
					</c:when>
				</c:choose>
	        
<!-- 	    </div> -->
	</div>
    <div id="calendar" class="infoBoard3">
    
    </div>
    
</div>

 <jsp:include page="../index/footer.jsp" />
 
 <script src="/js/header.js"></script>
 <script src="/js/index.js"></script>
 <script src="/js/dataSearchBar.js"></script>
 <script src="/js/commonWindowOnload.js"></script>
    
</body>
</html>