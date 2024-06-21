<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대출 연장</title>


<script src="js/bookLoanExtension.js"></script>
<link rel="stylesheet" type="text/css" href="css/bookLoanExtension.css">
<link rel="stylesheet" type="text/css" href="css/public/nav.css">


</head>


<body>

<header id="header" class="header"></header>


<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">도서대출 연장</div> <div class="pageRoute">홈 > 마이페이지 > 도서대출 연장</div>
    </div>
</div>

<main>

<div class="sel_All">
    <label for="selectAllBook">
        <input type="checkbox" id="selectAllBook" onclick="toggleAllChxbox(this)">
    </label>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="일괄 대출 연장" onclick="extendAllCheckedbox()">
</div>

<div class="bigbigDiv">
	<c:forEach var="extension" items="${extensions}" varStatus="num">
	<div class="bigDiv">
    	<div class="book_container">
			<div class="book_label">
				<label><input type="checkbox" class="book_chxbox" value="book${num.index+1}"></label>
			</div>
    		<div class="book_image">
    			<img src="images/${extension.img}">
    		</div>
    		<div class="book_table">
    			<table>
    				<tr>
    					<th>대출도서명</th><td>${extension.title}</td><th>등록 번호</th><td>${extension.isbn}</td>
    				</tr>
    				<tr>
    					<th>저자명</th>
    					<td colspan="3">${extension.authorName}</td>
    				</tr>
    				<tr>
    					<th>대출일자</th>
    					<td colspan="3">${extension.rentHistory}</td>
    				</tr>
    				<tr>
    					<th>반납일자</th>
    					<td colspan="3">${extension.returnDate}</td>
    				</tr>
    				<tr>
                        <form action="bookExtension" method="post">
	                        <td colspan="4" align="right" class="extends">
	                        	<input type="hidden" name="bookId" value="${bookId}">
	                        	<input type="submit" value="대출 연장" onclick="extendEachBook('book${num.index+1}')">&nbsp;&nbsp;&nbsp;&nbsp;
	                        </td>
                        </form>
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
    </c:forEach>
    
</div>
</main>

<footer id="footer" class="footer"></footer>

</body>
</html>