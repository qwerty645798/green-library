<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신착 도서</title>

<link rel="stylesheet" type="text/css" href="css/initiativeBook.css">
<link rel="stylesheet" type="text/css" href="css/public/nav.css">

<script src="js/popInitiBook.js"></script>
    
</head>
<body>

<jsp:include page="index/header.jsp" />

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">신착도서</div> <div class="pageRoute">홈 > 자료 검색 > 신착도서</div>
    </div>
</div>

<main>

<c:set var="itemsPerPage" value="8"/>
<c:set var="totalItems" value="${fn:length(items)}" />
<c:set var="totalPages" value="${(totalItems + itemsPerPage - 1) / itemsPerPage}" />

<div id="page_1" class="page">
	<c:forEach var="outerIndex" begin="0" end="3">
        <div class="image_container">
            <c:forEach var="innerIndex" begin="0" end="1">
                <c:set var="index" value="${outerIndex * 2 + innerIndex}" />
                <c:if test="${index < items.size()}">
                    <div class="image_box">
	                    <a href="bookDetail?bookId=${items[index].book_id}">
	                    <div class="blackbox">
	                    <img class="icon" src="images/whiteeye.png">
	                    </div>
                            <img src="images/${items[index].img}">
                        </a>
	                    
                   		<ul class="bookInfo">
                   			<li><span><a href="bookDetail?bookId=${items[index].book_id}">
                   			제목: ${items[index].title}</a></span></li><hr>
                   			<li>저자 <span class="border">|</span> ${items[index].authorName}</li>
                   			<li>출판사 <span class="border">|</span> ${items[index].publisherName}</li>
                   			<li>발행년도 <span class="border">|</span> ${items[index].publicationDate}</li>
                   			<li>대출상태 <span class="border">|</span> ${items[index].availability}</li>
                   		</ul>
                   		
                   		<input type="button" class="takeAlook"
                   		onclick="window.location.href='bookDetail?bookId=${items[index].book_id}'" 
						value="자세히 보기">
                   	
                    </div>
                    
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
</div>

<div id="page_2" class="page hidden">
	<c:forEach var="outerIndex" begin="4" end="7">
        <div class="image_container">
            <c:forEach var="innerIndex" begin="0" end="1">
                <c:set var="index" value="${outerIndex * 2 + innerIndex}" />
                <c:if test="${index < items.size()}">
                    <div class="image_box">
	                    <a class="booklink" href="bookDetail?bookId=${items[index].book_id}">
	                    <div class="blackbox">
	                    <img class="icon" src="images/whiteeye.png">
	                    </div>
                            <img src="images/${items[index].img}">
                        </a>
	                    
                   		<ul class="bookInfo">
                   			<li><span><a href="bookDetail?bookId=${items[index].book_id}">
                   			제목: ${items[index].title}</a></span></li><hr>
                   			<li>저자 <span class="border">|</span> ${items[index].authorName}</li>
                   			<li>출판사 <span class="border">|</span> ${items[index].publisherName}</li>
                   			<li>발행년도 <span class="border">|</span> ${items[index].publicationDate}</li>
                   			<li>대출상태 <span class="border">|</span> ${items[index].availability}</li>
                   		</ul>
                   	
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
</div>

<div id="page_3" class="page hidden">
	<c:forEach var="outerIndex" begin="8" end="11">
        <div class="image_container">
            <c:forEach var="innerIndex" begin="0" end="1">
                <c:set var="index" value="${outerIndex * 2 + innerIndex}" />
                <c:if test="${index < items.size()}">
                    <div class="image_box">
	                    <a href="bookDetail?bookId=${items[index].book_id}">
	                    <div class="blackbox">
	                    <img class="icon" src="images/whiteeye.png">
	                    </div>
                            <img src="images/${items[index].img}">
                        </a>
	                    
                   		<ul class="bookInfo">
                   			<li><span><a href="bookDetail?bookId=${items[index].book_id}">
                   			제목: ${items[index].title}</a></span></li><hr>
                   			<li>저자 <span class="border">|</span> ${items[index].authorName}</li>
                   			<li>출판사 <span class="border">|</span> ${items[index].publisherName}</li>
                   			<li>발행년도 <span class="border">|</span> ${items[index].publicationDate}</li>
                   			<li>대출상태 <span class="border">|</span> ${items[index].availability}</li>
                   		</ul>
                   	
                    </div>
                    
                    
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
</div>

	
	
<div class="arrCon">
	<div class="button_box">
		<c:forEach var="pageIndex" begin="1" end="${totalPages}">
			<input class="orderBtn" type="button" value="${pageIndex}" onclick="showPage(${pageIndex})">
	    </c:forEach>
	</div>
</div>


	

</main>

 <jsp:include page="index/footer.jsp" />
 
</body>
</html>