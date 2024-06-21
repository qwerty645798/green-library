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

<main><!-- 총 몇권 대출 가능인지 확인 후 개수 추가(현재3개) -->

<div class="sel_All">
    <label for="selectAllBook">
        <input type="checkbox" id="selectAllBook" onclick="toggleAllChxbox(this)">
    </label>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="일괄 대출 연장" onclick="extendAllCheckedbox()">
</div>

<div class="bigbigDiv">
	<c:forEach var="extension" items="${extensions}">
	<div class="bigDiv">
    	<div class="book_container">
			<div class="book_label">
				<label><input type="checkbox" class="book_chxbox" value="book1"></label>
			</div>
    		<div class="book_image">
    			<img src="images\exex.jpg">
    		</div>
    		<div class="book_table">
    			<table>
    				<tr>
    					<th>대출도서명</th><td></td><th>등록 번호</th><td></td>
    				</tr>
    				<tr>
    					<th>저자명</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>대출일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>반납일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<td colspan="4" align="right" class="extends">
                            <input type="button" value="대출 연장" onclick="extendEachBook('book1')">&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
    </c:forEach>
    
    
    
    <div class="bigDiv">
    	<div class="book_container">
			<div class="book_label">
				<label><input type="checkbox" class="book_chxbox" value="book1"></label>
			</div>
    		<div class="book_image">
    			<img src="images\exex.jpg">
    		</div>
    		<div class="book_table">
    			<table>
    				<tr>
    					<th>대출도서명</th><td></td><th>등록 번호</th><td></td>
    				</tr>
    				<tr>
    					<th>저자명</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>대출일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>반납일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<td colspan="4" align="right" class="extends">
                            <input type="button" value="대출 연장" onclick="extendEachBook('book1')">&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
    					<!-- 기능 어떻게 넣을 지 몰라서 일단 버튼으로 생성해둠 -->
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
    <div class="bigDiv">
    	<div class="book_container">
			<div class="book_label">
				<label><input type="checkbox" class="book_chxbox" value="book1"></label>
			</div>
    		<div class="book_image">
    			<img src="images\exex.jpg">
    		</div>
    		<div class="book_table">
    			<table>
    				<tr>
    					<th>대출도서명</th><td></td><th>등록 번호</th><td></td>
    				</tr>
    				<tr>
    					<th>저자명</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>대출일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>반납일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<td colspan="4" align="right" class="extends">
                            <input type="button" value="대출 연장" onclick="extendEachBook('book1')">&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
    					<!-- 기능 어떻게 넣을 지 몰라서 일단 버튼으로 생성해둠 -->
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
</div>
</main>

<footer id="footer" class="footer"></footer>

</body>
</html>