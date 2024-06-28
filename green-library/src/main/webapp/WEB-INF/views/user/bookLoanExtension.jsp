<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대출 연장</title>


<script src="/js/bookLoanExtension.js"></script>
<link rel="stylesheet" type="text/css" href="/css/bookLoanExtension.css">
<link rel="stylesheet" type="text/css" href="/css/public/nav.css">


</head>


<body>

<jsp:include page="../index/header.jsp" />


<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">도서대출 연장</div> <div class="pageRoute">홈 > 마이페이지 > 도서대출 연장</div>
    </div>
</div>

<main>



<div class="sel_All">
	<c:choose>
		<c:when test="${!loanExist}">
			<div class="noRents">
				<span>현재 대출 중인 책이 없습니다</span>
			</div>
		</c:when>
		<c:otherwise>
			<label for="selectAllBook">
		        <input type="checkbox" id="selectAllBook" onclick="toggleAllChxbox(this)">
		    </label>
		    &nbsp;&nbsp;&nbsp;&nbsp;
		    <form id="extendForm" action="bookExtensionBatch" method="post" onsubmit="return extendAllCheckedbox()">
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		        <input type="hidden" name="userId" value="${userId}">
		        <input type="submit" value="일괄 대출 연장">
		    </form>
		</c:otherwise>
	</c:choose>
</div>

<div class="bigbigDiv">
    <c:forEach var="extension" items="${extensions}" varStatus="num">
        <div class="bigDiv">
            <div class="book_container" data-rent-history="${extension.rentHistory}" data-return-date="${extension.returnDate}">
                <div class="book_label">
                    <label><input type="checkbox" class="book_chxbox" name="bookIds" value="${extension.bookId}"></label>
                </div>
                <div class="book_image">
                    <img src="/images/${extension.img}">
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
                            <th>반납예정일자</th>
                            <td colspan="3">${extension.returnDate}</td>
                        </tr>
                        <tr>
                            <td colspan="4" align="right" class="extends">
                                <form action="bookExtension" method="post" onsubmit="return extendEachBook('${extension.bookId}', '${extension.rentHistory}', '${extension.returnDate}')">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <input type="hidden" name="userId" value="${userId}">
                                    <input type="hidden" name="bookId" value="${extension.bookId}">
                                    <input type="submit" value="대출 연장">
                                </form>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </c:forEach>
</div>





</main>

<jsp:include page="../index/footer.jsp" />

</body>
</html>