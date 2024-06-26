<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>pronunciation</title>
    <link rel="stylesheet" type="text/css" href="admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="admin/css/bookManage.css">
</head>

<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>장서관리</h3>
        <p>home > book > manage</p>
    </section>
    <section class="totalContainer">
        <form class="searchContainer" action="">
            <div>
                <select name="" id="">
                    <option value="">제목</option>
                    <option value="">저자</option>
                    <option value="">십진분류</option>
                </select>
                <div class="inputBox">
                    <input type="text" id="inputText" class="inputText" name="ss" maxlength="20"
                           placeholder="검색어를 입력하세요" value="" />
                    <button type="submit" id="searchBtn" class="searchBtn"> 검색 </button>
                </div>
            </div>
        </form>
        <!-- board -->
        <div class="outputBoard">
            <div class="results">
                <p>result : </p>
                <select name="" id="">
                    <option value="">5개씩</option>
                    <option value="">10개씩</option>
                    <option value="">15개씩</option>
                </select>
                <div class="btnWrap">
                    <input class="writeBtn" type="button" value="등록">
                    <input class="deleteBtn" type="button" value="삭제">
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
                        <th>십진분류</th>
                        <th>대여유무</th>
                        <th colspan="2"></th>
                    </tr>
                    <c:forEach var="book" items="${bookDTOS}">
                        <tr>
                            <td><input type="checkbox" name="selectedBooks" value="${book.bookId}"></td>
                            <td>${book.bookId}</td>
                            <td>${book.title}</td>
                            <td>${book.authorName}</td>
                            <td>${book.publisherName}</td>
                            <td>${book.publicationDate}</td>
                            <td>${book.genreFullname}</td>
                            <td><input type="checkbox" class="borrowTF" disabled ${book.availability == 1 ? 'checked' : ''}></td>
                            <td><input type="button" class="see" value=""><input type="button" class="correction" value=""><input type="button" class="return" value=""></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="paging">
            <div class="paging">
                <input class="back" type="button">
                <p>page of total</p>
                <input class="next" type="button">
            </div>
        </div>
    </section>
</main>
<jsp:include page="../../public/adminFooter.jsp"></jsp:include>
</body>

</html>
