<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>수서관리</title>
    <link rel="stylesheet" type="text/css" href="admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="admin/css/bookBuy.css">
</head>

<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>수서관리</h3>
        <p>home > book > buy</p>
    </section>
    <section class="totalContainer">
        <form class="searchContainer" action="/searchWishlist" method="get">
            <div>
                <select name="searchType" id="searchType">
                    <option value="title" ${param.searchType == 'title' ? 'selected' : ''}>제목</option>
                    <option value="author" ${param.searchType == 'author' ? 'selected' : ''}>저자</option>
                    <option value="genre" ${param.searchType == 'genre' ? 'selected' : ''}>십진분류</option>
                </select>
                <div class="inputBox">
                    <input type="text" id="searchKeyword" class="inputText" name="searchKeyword" maxlength="20"
                           placeholder="검색어를 입력하세요" value="${param.searchKeyword}"/>
                    <button type="submit" id="searchBtn" class="searchBtn"> 검색</button>
                </div>
            </div>
        </form>
        <!-- board -->
        <div class="outputBoard">
            <div class="results">
                <c:set var="wishlistCount" value="${fn:length(wishList)}"/>
                <p>result : ${wishlistCount} 개</p>
                <form id="perPageForm" action="/searchWishlist" method="get">
                    <input type="hidden" name="searchType" value="${param.searchType}">
                    <input type="hidden" name="searchKeyword" value="${param.searchKeyword}">
                    <select id="perPageSelect" name="perPage" onchange="document.getElementById('perPageForm').submit()">
                        <option value="5" ${param.perPage == '5' ? 'selected' : ''}>5개씩</option>
                        <option value="10" ${param.perPage == '10' ? 'selected' : ''}>10개씩</option>
                        <option value="15" ${param.perPage == '15' ? 'selected' : ''}>15개씩</option>
                    </select>
                </form>
                <div class="btnWrap">
                    <input class="acceptBtn" type="button" value="승인">
                    <input class="deleteBtn" type="button" value="거부">
                </div>
            </div>
            <div class="dashBoard">
                <table>
                    <tr>
                        <th><input type="checkbox" name="" id=""></th>
                        <th>관리번호</th>
                        <th>제목</th>
                        <th>저자</th>
                        <th>출판사</th>
                        <th>출판년도</th>
                        <th>가격</th>
                        <th colspan="2"></th>
                    </tr>
                    <c:forEach var="wish" items="${wishList}">
                        <tr>
                            <td><input type="checkbox" name="" id=""></td>
                            <td>${wish.wishlistId}</td>
                            <td>${wish.wishTitle}</td>
                            <td>${wish.wishAuthor}</td>
                            <td>${wish.wishPublisher}</td>
                            <td>${wish.wishPublication}</td>
                            <td>${wish.wishPrice}</td>
                            <td><input type="checkbox" name="" id="" disabled ${wish.complete == 1 ? 'checked' : ''}></td>
                            <td><input type="button" class="correction">
                                <input type="button" class="delete">
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="paging">
            <input class="back" type="button">
            <p>page of total</p>
            <input class="next" type="button">
        </div>
    </section>
</main>
<jsp:include page="../../public/adminFooter.jsp"></jsp:include>

<script>
    document.getElementById('perPageSelect').addEventListener('change', function () {
        document.getElementById('perPageForm').submit();
    });
</script>
</body>

</html>
