<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인기 도서</title>


<link rel="stylesheet" type="text/css" href="css/popularBook.css">
<link rel="stylesheet" type="text/css" href="css/public/nav.css">

<style>
    .hidden {
        display: none;
    }
    
    .button_box{
		display: flex;
		width:1260px;
		margin: 0 auto;
		
		justify-content: center;
		align-items: center;
		margin-top: 20px;
		box-sizing: border-box;
	}
	
	.button_box input[type="button"]{
		background-color: #64B883;
		border-radius : 5px;
		border: none;
		width: 60px;
		margin-right: 10px;
		margin-left:10px;
	}
</style>

<script>
    function showPage(pageNumber) {
        document.querySelectorAll('.page').forEach(function(page) {
            page.classList.add('hidden');
        });
        
        document.getElementById('page_' + pageNumber).classList.remove('hidden');
    }
</script>

</head>
<body>

<header id="header" class="header"></header>


<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">인기도서</div> <div class="pageRoute">홈 > 자료 검색 > 인기도서</div>
    </div>
</div>

<main><!-- 페이지내 들어갈 개수 / 현재(3개) -->


<c:set var="itemsPerPage" value="10"/>
<c:set var="totalItems" value="${fn:length(items)}" />
<c:set var="totalPages" value="${(totalItems + itemsPerPage - 1) / itemsPerPage}" />

<div id="page_1" class="page">
	<div class="bigDiv">
	<c:forEach var="outerIndex" value="0">
        <div class="book_container">
            <c:forEach var="innerIndex" begin="0" end="9">
                <c:set var="index" value="${outerIndex * 10 + innerIndex}" />
                <c:if test="${index < items.size()}">
                    
                    <div class="book_image">
						<img src="images/${items[index].img}">
					</div>
					<div class="book_table">
						<table>
							<tr>
								<th>책 제목</th>
								<td colspan="3">${items[index].title}</td>
							</tr>
							<tr>
								<th>저자명</th>
								<td colspan="3">${items[index].authorName}</td>
							</tr>
							<tr>
								<th>출판사</th>
								<td colspan="3">${items[index].publisherName}</td>
							</tr>
							<tr>
								<th>대출 가능 여부</th>
								<td colspan="3">${items[index].availability}</td>
							</tr>
							<tr>
								<!-- form-submit? 아니면 그냥 button?  -->
								<td colspan="4" class="more_button" style="border:none;">
									<input type="button" onclick="window.location.href='bookDetail?bookId=${items[index].book_id}'" value="자세히 보기" class="moreInf">
								</td> 
							</tr>
						</table>
					</div>
            	</c:if>
            </c:forEach>
        </div>
    </c:forEach>
    </div>
</div>

<div id = "page_2" class="page hidden">
	<div class="bigDiv">
	<c:forEach var="outerIndex" value="1">
        <div class="book_container">
            <c:forEach var="innerIndex" begin="0" end="9">
                <c:set var="index" value="${outerIndex * 10 + innerIndex}" />
                <c:if test="${index < items.size()}">
                    
                    <div class="book_image">
						<img src="images/${items[index].img}">
					</div>
					<div class="book_table">
						<table>
							<tr>
								<th>책 제목</th>
								<td colspan="3">${items[index].title}</td>
							</tr>
							<tr>
								<th>저자명</th>
								<td colspan="3">${items[index].authorName}</td>
							</tr>
							<tr>
								<th>출판사</th>
								<td colspan="3">${items[index].publisherName}</td>
							</tr>
							<tr>
								<th>대출 가능 여부</th>
								<td colspan="3">${items[index].availability}</td>
							</tr>
							<tr>
								<!-- form-submit? 아니면 그냥 button?  -->
								<td colspan="4" class="more_button" style="border:none;">
									<input type="button" onclick="window.location.href='bookDetail?bookId=${items[index].book_id}'" value="자세히 보기" class="moreInf">
								</td> 
							</tr>
						</table>
					</div>
            	</c:if>
            </c:forEach>
        </div>
    </c:forEach>
    </div>
</div>

<div id = "page_3" class="page hidden">
	<div class="bigDiv">
	<c:forEach var="outerIndex" value="2">
        <div class="book_container">
            <c:forEach var="innerIndex" begin="0" end="9">
                <c:set var="index" value="${outerIndex * 10 + innerIndex}" />
                <c:if test="${index < items.size()}">
                    
                    <div class="book_image">
						<img src="images/${items[index].img}">
					</div>
					<div class="book_table">
						<table>
							<tr>
								<th>책 제목</th>
								<td colspan="3">${items[index].title}</td>
							</tr>
							<tr>
								<th>저자명</th>
								<td colspan="3">${items[index].authorName}</td>
							</tr>
							<tr>
								<th>출판사</th>
								<td colspan="3">${items[index].publisherName}</td>
							</tr>
							<tr>
								<th>대출 가능 여부</th>
								<td colspan="3">${items[index].availability}</td>
							</tr>
							<tr>
								<!-- form-submit? 아니면 그냥 button?  -->
								<td colspan="4" class="more_button" style="border:none;">
									<input type="button" onclick="window.location.href='bookDetail?bookId=${items[index].book_id}'" value="자세히 보기" class="moreInf">
								</td> 
							</tr>
						</table>
					</div>
            	</c:if>
            </c:forEach>
        </div>
    </c:forEach>
    </div>
</div>


<!-- 개별 기본 폼 
<div class="bigDiv">
	<div class="book_container">
		<div class="book_image">
			<img src="images\exex.jpg">
		</div>
		<div class="book_table">
			<table>
				<tr>
					<th>책 제목</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>저자명</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>대출 가능 여부</th>
					<td colspan="3">대출 가능/불가\</td>
				</tr>
				<tr>
					<td colspan="4" class="more_button" style="border:none;">
						<input type="button" onclick="window.location.href='bookDetail?bookId=2'" value="자세히 보기" class="moreInf">
					</td> 
				</tr>
			</table>
		</div>
	</div>
</div>
-->


<div class="button_box">
	<c:forEach var="pageIndex" begin="1" end="${totalPages}">
        <input type="button" value="${pageIndex}" onclick="showPage(${pageIndex})">
    </c:forEach>
</div>

</main>

<footer id="footer" class="footer"></footer>

</body>
</html>