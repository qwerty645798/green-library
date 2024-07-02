<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인기 도서</title>


<link rel="stylesheet" type="text/css" href="/css/popularBook.css">
<link rel="stylesheet" type="text/css" href="/css/public/nav.css">

<script src="/js/popInitiBook.js"></script>
<!-- <script src="js/bottomButtonBox.js"></script> -->

</head>
<body>

<jsp:include page="../index/header.jsp" />


<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">인기도서</div> <div class="pageRoute">홈 > 자료 검색 > 인기도서</div>
    </div>
</div>

<div class="title_container">
	<h1>사람들이 많이 찾는 책</h1>
</div>
	<hr class="hr1">
	

<jsp:include page="../public/navBarSearch.jsp"/>

<main>



<c:set var="itemsPerPage" value="10"/>
<c:set var="totalItems" value="${fn:length(items)}" />
<c:set var="totalPages" value="${(totalItems + itemsPerPage - 1) / itemsPerPage}" />

<div id="page_1" class="page">
	<c:forEach var="index" begin="0" end="9">
    	<c:if test="${index < items.size()}">
			<div class="bigDiv">
		        <div class="book_container">
                   <%--  <div class="book_image">
						<img src="/images/${items[index].img}">
					</div> --%>
					<div class="image_box">
						<a href="bookDetail?bookId=${items[index].book_id}">
		                    <div class="blackbox">
		                    <img class="icon" src="/images/whiteeye.png">
		                    </div>
		                    <div class="book_image">
		                    <img class="img" src="/images/${items[index].img}">
		                    </div>
	                    </a>
                    </div>
                    
					<div class="book_table">
						<table>
							<tr>
								
								<td colspan="4">
								<span 
								onclick="window.location.href='bookDetail?bookId=${items[index].book_id}'">
								${items[index].title}</span></td>
							</tr>
							<tr>
								<th>저자명</th>
								<td class="bar" colspan="3">${items[index].authorName}</td>
							</tr>
							<tr>
								<th>출판사</th>
								<td class="bar">${items[index].publisherName}</td>
								<th class="right">발행년도</th>
								<td class="bar">${items[index].publicationDate}</td>
							</tr>
							<tr>
								<th>대출 가능 여부</th>
								<td class="bar" colspan="3">${items[index].availability}</td>
							</tr>
							<tr>
								<td colspan="4" class="more_button" style="border:none;">
									<input type="button" 
									onclick="window.location.href='bookDetail?bookId=${items[index].book_id}'" 
									value="자세히 보기" 
									class="moreInf">
								</td> 
							</tr>
						</table>
						
					</div>
		    	</div>
		    </div>
	    </c:if>
    </c:forEach>
</div>

<div id = "page_2" class="page hidden">
	<c:forEach var="index" begin="10" end="19">
    	<c:if test="${index < items.size()}">
			<div class="bigDiv">
		        <div class="book_container">
                   <%--  <div class="book_image">
						<img src="images/${items[index].img}">
					</div> --%>
					<div class="image_box">
						<a href="bookDetail?bookId=${items[index].book_id}">
		                    <div class="blackbox">
		                    <img class="icon" src="images/whiteeye.png">
		                    </div>
		                    <div class="book_image">
		                    <img class="img" src="images/${items[index].img}">
		                    </div>
	                    </a>
                    </div>
					<div class="book_table">
						<table>
							<tr>
								<td colspan="4">
								<span 
								onclick="window.location.href='bookDetail?bookId=${items[index].book_id}'">
								${items[index].title}</span></td>
							</tr>
							<tr>
								<th>저자명</th>
								<td class="bar" colspan="3">${items[index].authorName}</td>
							</tr>
							<tr>
								<th>출판사</th>
								<td class="bar">${items[index].publisherName}</td>
								<th class="right">발행년도</th>
								<td class="bar">${items[index].publicationDate}</td>
							</tr>
							<tr>
								<th>대출 가능 여부</th>
								<td class="bar" colspan="3">${items[index].availability}</td>
							</tr>
							<tr>
								<td colspan="4" class="more_button" style="border:none;">
									<input type="button" 
									onclick="window.location.href='bookDetail?bookId=${items[index].book_id}'" 
									value="자세히 보기" 
									class="moreInf">
								</td> 
							</tr>
						</table>
						
					</div>
		    	</div>
		    </div>
	    </c:if>
    </c:forEach>
</div>

<div id = "page_3" class="page hidden">
	<c:forEach var="index" begin="20" end="29">
    	<c:if test="${index < items.size()}">
			<div class="bigDiv">
		        <div class="book_container">
                   <%--  <div class="book_image">
						<img src="images/${items[index].img}">
					</div> --%>
					<div class="image_box">
						<a href="bookDetail?bookId=${items[index].book_id}">
		                    <div class="blackbox">
		                    <img class="icon" src="images/whiteeye.png">
		                    </div>
		                    <div class="book_image">
		                    <img class="img" src="images/${items[index].img}">
		                    </div>
	                    </a>
                    </div>
					<div class="book_table">
						<table>
							<tr>
								<td colspan="4">
								<span 
								onclick="window.location.href='bookDetail?bookId=${items[index].book_id}'">
								${items[index].title}</span></td>
							</tr>
							<tr>
								<th>저자명</th>
								<td class="bar" colspan="3">${items[index].authorName}</td>
							</tr>
							<tr>
								<th>출판사</th>
								<td class="bar">${items[index].publisherName}</td>
								<th class="right">발행년도</th>
								<td class="bar">${items[index].publicationDate}</td>
							</tr>
							<tr>
								<th>대출 가능 여부</th>
								<td class="bar" colspan="3">${items[index].availability}</td>
							</tr>
							<tr>
								<td colspan="4" class="more_button" style="border:none;">
									<input type="button" 
									onclick="window.location.href='bookDetail?bookId=${items[index].book_id}'" 
									value="자세히 보기" 
									class="moreInf">
								</td> 
							</tr>
						</table>
						
					</div>
		    	</div>
		    </div>
	    </c:if>
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

 <jsp:include page="../index/footer.jsp" />
 

</body>
</html>