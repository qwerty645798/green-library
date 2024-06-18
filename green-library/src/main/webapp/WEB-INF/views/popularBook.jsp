<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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


<div id = "page_1" class="page">
</div>

<div id = "page_2" class="page hidden">
</div>

<div id = "page_3" class="page hidden">
</div>


<!-- 개별 기본 폼 -->
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
					<td colspan="3">대출 가능/불가<!-- 대출 가능/불가 여부 확인 후 출력되어있는 기능 --></td>
				</tr>
				<tr>
					<!-- form-submit? 아니면 그냥 button?  -->
					<td colspan="4" class="more_button" style="border:none;">
						<input type="button" onclick="window.location.href='bookDetail?bookId=2'" value="자세히 보기" class="moreInf">
					</td> 
				</tr>
			</table>
		</div>
	</div>
</div>



<div class="button_box">
	<c:forEach var="pageIndex" begin="1" end="${totalPages}">
        <input type="button" value="${pageIndex}" onclick="showPage(${pageIndex})">
    </c:forEach>
</div>

</main>

<footer id="footer" class="footer"></footer>

</body>
</html>