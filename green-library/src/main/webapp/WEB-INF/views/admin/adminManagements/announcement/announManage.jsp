<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>announcement</title>
    <link rel="stylesheet" type="text/css" href="admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="admin/css/announManage.css">
</head>

<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>공지 게시판</h3>
        <p>home > management > announcement</p>
    </section>
    <section class="totalContainer">
        <form class="searchContainer" action="">
            <div>
                <select name="" id="">
                    <option value="">제목</option>
                    <option value="">내용</option>
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
                <c:set var="announcementCount" value="${fn:length(announcements)}"/>
                <p>result : ${announcementCount} 개</p>
                <select id="perPageSelect">
                    <option value="5">5개씩</option>
                    <option value="10">10개씩</option>
                    <option value="15">15개씩</option>
                </select>
                <div class="btnWrap">
                    <input class="writeBtn" type="button" value="작성">
                    <input class="deleteBtn" type="button" value="삭제">
                </div>
            </div>
            <div class="dashBoard">
                <table>
                    <tr>
                        <th><input type="checkbox" name="" id=""></th>
                        <th>공지번호</th>
                        <th>제목</th>
                        <th>내용</th>
                        <th>관리자</th>
                        <th>작성일</th>
                        <th>파일</th>
                        <th colspan="2"></th>
                    </tr>
                    <c:forEach var="announcement" items="${announcements}" varStatus="status">
                        <tr>
                            <td><input type="checkbox" name="" id=""></td>
                            <td>${announcement.announcementId}</td>
                            <td>${announcement.announceTitle}</td>
                            <td>${announcement.contents}</td>
                            <td>${announcement.writerId}</td>
                            <td>${announcement.writeDate}</td>
                            <td>${announcement.fileName}</td>
                            <td><input type="button" class="correction"></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="paging">
            <input class="back" type="button">
            <p>페이지</p>
            <input class="next" type="button">
        </div>
    </section>
</main>
<jsp:include page="../../public/adminFooter.jsp"></jsp:include>

<script>
    // JavaScript to handle per page selection and form submission
    document.getElementById('perPageSelect').addEventListener('change', function () {
        var perPage = this.value;
        // Reload the page with the selected perPage value as a query parameter
        window.location.href = window.location.pathname + '?perPage=' + perPage;
    });
</script>
</body>

</html>
