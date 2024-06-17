<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신착 도서</title>


<link rel="stylesheet" type="text/css" href="css/initiativeBook.css">
<link rel="stylesheet" type="text/css" href="css/public/nav.css">



</head>
<body>

<header id="header" class="header"></header>

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">신착도서</div> <div class="pageRoute">홈 > 자료 검색 > 신착도서</div>
    </div>
</div>

<main>


<div class="first_page">
</div>

<div class="second_page">
</div>

<div class="third_page">
</div>

	
<div class="button_box">
	<input type="button" value="1">
	<input type="button" value="2">
	<input type="button" value="3">
</div>
	
	<!-- 
		<c:forEach var="outerIndex" begin="0" end="3">
	    <div class="image_container">
	        <c:forEach var="innerIndex" begin="0" end="1">
	            <c:set var="index" value="${outerIndex * 2 + innerIndex}" />
	            <c:if test="${index < items.size()}">
	                <div class="image_box">
	                    <a href="bookDetail?bookId=${items[index].book_id}">
	                        <img src="images/${items[index].img}">
	                    </a>
	                </div>
	            </c:if>
	        </c:forEach>
	    </div>
	</c:forEach>
	 -->
	
	
	




</main>

<footer id="footer" class="footer"></footer>

</body>
</html>