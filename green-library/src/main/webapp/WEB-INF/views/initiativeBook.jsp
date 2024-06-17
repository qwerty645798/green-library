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

<main><!-- 현재 한 줄에 2권, 3줄만 만들어둠 -->

<c:forEach var="item" items="${items}">
<div class="image_container">
   <div class="image_box">
      <a href="bookDetail?bookId=${item.book_id}">
         <img src="images/${item.img}">
      </a>
   </div>
   <div class="image_box">
      <a href="bookDetail?bookId=${item.book_id}">
         <img src="images/${item.img}">
      </a>
   </div>
</div>
</c:forEach>

</main>

<footer id="footer" class="footer"></footer>

</body>
</html>