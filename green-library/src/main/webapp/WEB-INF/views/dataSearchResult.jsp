<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자료 검색 결과</title>


<script src="js/dataSearch.js"></script>
<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/dataSearchResult.css">

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
		width: 40px;
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
        <div class="pageTitle">통합 자료 검색</div> <div class="pageRoute">홈 > 자료 검색 > 통합 자료 검색</div>
    </div>
</div>

<main>

<div class="zero_container">
	<div class="sel_box">
		<div class="sel_box1">
			<select>
				<option>전체</option>
				<option>도서명</option>
				<option>저자</option>
				<option>출판사</option>
				<option>내용</option>
				<option>인기도서</option>
				<option>신착도서</option>
			</select>
		</div>
		<div class="sel_box2">
			<input type="text" value="검색어를 입력하세요" onfocus="want_search(event)" onblur="zero_back(event)">
		</div>
		<div class="sel_box3">
			<input type="button" value="검색" onclick="lets_search(event)" class="zerocon_button">
		</div>
	</div>
</div>

<div class="first_container">
	<div class="text_box">
		<div class="text_box1">
			&nbsp;'${inputCategory}:${inputText}'으로 검색한 결과 : ${items.size()}개 
		</div>
		<div class="text_box2">
			<select>
				<option>5개</option>
				<option>10개</option>
				<option>20개</option>
			</select>
		</div>
	</div>
</div>

<c:set var="itemsPerPage" value="8"/><!-- select.value -->
<c:set var="totalItems" value="${fn:length(items)}" />
<c:set var="totalPages" value="${(totalItems + itemsPerPage - 1) / itemsPerPage}" />

<div class="second_container">
	<c:forEach var="item" items="${items}" varStatus="loop">
	<div id="page_1" class="page">
		<div class="bigDiv">
			<div class="book_container">
				<div class="book_image">
					<a href="bookDetail?bookId=${items.bookId}">
						<img src="images/${items.img}">
					</a>
				</div>
				<div class="book_table">
					<table>
						<tr>
							<th>도서명</th>
							<td>${items.title}</td>
							<th>재고현황</th>
							<td>${items.availability}</td>
						</tr>
						<tr>
							<th>저자</th>
							<td>${items.authorName}</td>
							<th>위치</th>
							<td>${items.location}</td>
						</tr>
						<tr>
							<th>출판사</th>
							<td colspan="3">${items.publisherName}</td>
						</tr>
						<tr>
							<th>ISBN</th>
							<td colspan="3">${items.isbn}</td>
						</tr>
						<tr>
							<th>요약</th>
							<td colspan="3">${items.summary}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
	
	<div id="page_2" class="page hidden"></div>
	<div id="page_3" class="page hidden"></div>
	

</div>

<!-- 여기 버튼 박스 구현 해야됨 복잡할듯? -->
<!-- 위에 리스트 n개씩 출력, 그에 맞춰서 5개씩 페이지 버튼 출력 -->
<!-- 제일 앞에서는 << < 두개 없이, 제일 뒤에서는 > >> 없이 -->
<div class="third_container">
	<div class="button_box">
		<input type="button" value="<<">
		<input type="button" value="<">
		<c:forEach var="pageIndex" begin="1" end="${totalPages}">
	        <input type="button" value="${pageIndex}" onclick="showPage(${pageIndex})">
	    </c:forEach>
		<input type="button" value=">">
		<input type="button" value=">>">
	</div>
</div>

</main>
<footer id="footer" class="footer"></footer>




</body>
</html>

