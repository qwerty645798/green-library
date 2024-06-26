<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inquiry</title>

    <link rel="stylesheet" type="text/css" href="admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="admin/css/inquiryManage.css">
</head>

<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>문의 게시판</h3>
        <p>home > management > inquiry</p>
    </section>
    <section class="totalContainer">
        <form class="searchContainer" action="/searchInquiries" method="get">
            <div>
                <select name="searchType" id="searchType">
                    <option value="title" ${param.searchType == 'title' ? 'selected' : ''}>제목</option>
                    <option value="contents" ${param.searchType == 'contents' ? 'selected' : ''}>내용</option>
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
                <c:set var="inquiryCount" value="${fn:length(inquiry)}"/>
                <p>result : ${inquiryCount} 개</p>
                <form id="perPageForm" action="/searchInquiries" method="get">
                    <input type="hidden" name="searchType" value="${param.searchType}">
                    <input type="hidden" name="searchKeyword" value="${param.searchKeyword}">
                    <select id="perPageSelect" name="perPage" onchange="document.getElementById('perPageForm').submit()">
                        <option value="5" ${param.perPage == '5' ? 'selected' : ''}>5개씩</option>
                        <option value="10" ${param.perPage == '10' ? 'selected' : ''}>10개씩</option>
                        <option value="15" ${param.perPage == '15' ? 'selected' : ''}>15개씩</option>
                    </select>
                </form>
                <div class="btnWrap">
                    <input type="button" value="답변한 것도 보기">
                    <input type="button" value="답변한 것만 보기">
                    <input class="deleteBtn" type="button" value="삭제">
                </div>
            </div>
            <div class="dashBoard">
                <table>
                    <tr>
                        <th><input type="checkbox" name="" id=""></th>
                        <th>문의번호</th>
                        <th>제목</th>
                        <th>내용</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>답변 여부</th>
                        <th colspan="2"></th>
                    </tr>
                    <c:forEach var="inquiry" items="${inquiry}" varStatus="status">
                        <tr>
                            <td><input type="checkbox" name="" id=""></td>
                            <td>${inquiry.inquiryId}</td>
                            <td>${inquiry.inquiryTitle}</td>
                            <td>${inquiry.contents}</td>
                            <td>${inquiry.userId}</td>
                            <td>${inquiry.inquiryDate}</td>
                            <td>
                                <input type="checkbox" name="" id="" disabled ${inquiry.responseTF == 1 ? 'checked' : ''}>
                            </td>
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
    document.getElementById('perPageSelect').addEventListener('change', function () {
        document.getElementById('perPageForm').submit();
    });
</script>
</body>

</html>
