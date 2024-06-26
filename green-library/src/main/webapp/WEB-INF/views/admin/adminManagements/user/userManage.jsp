<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사용자 관리</title>
    <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/users.css">
</head>
<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>

<main>
    <section class="banner">
        <h3>이용자 관리</h3>
        <p>home > management > users</p>
    </section>
    <section class="mainContainer">
        <div class="leftContainer">
            <form class="searchContainer" method="get" action="/User/search">
                <div>
                    <select name="searchType">
                        <option value="all">전체</option>
                        <option value="name">이름</option>
                        <option value="userId">아이디</option>
                    </select>
                    <div class="inputBox">
                        <input type="text" id="inputText" class="inputText" name="searchKeyword" maxlength="20" placeholder="검색어를 입력하세요" value="" />
                        <button type="submit" id="searchBtn" class="searchBtn">검색</button>
                    </div>
                </div>
            </form>
            <div class="resultContainer">
                <div class="results">
                    <p>검색 결과 : ${users.size()}명</p>
                    <select name="pageSize">
                        <option value="10">10개씩</option>
                        <option value="15">15개씩</option>
                        <option value="20">20개씩</option>
                    </select>
                    <div class="paging">
                        <input class="back" type="button" value="이전">
                        <p>페이지 of ${users.size()}</p>
                        <input class="next" type="button" value="다음">
                    </div>
                </div>
                <div class="outBoard">
                    <table>
                        <thead>
                        <tr>
                            <th><input type="checkbox" name="selectAll" id="selectAll"></th>
                            <th>아이디</th>
                            <th>이름</th>
                            <th>이메일</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty users}">
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td><input type="checkbox" name="userCheckbox" id="userCheckbox"></td>
                                    <td>${user.userId}</td>
                                    <td>${user.userName}</td>
                                    <td>${user.userEmail}</td>
                                    <td><input type="button" class="modifyBtn" value="수정"></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty users}">
                            <tr>
                                <td colspan="5">검색 결과가 없습니다.</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="rightContainer">
            <div class="userInfo">
                <h4>사용자 정보</h4>
                <p>이름 : </p>
                <p>아이디 : </p>
                <p>이메일 : </p>
                <p>전화번호 : </p>
            </div>
            <div class="loanInfo">
                <h4>대출 현황</h4>
                <div class="bookInfo">
                    <table>
                        <thead>
                        <tr>
                            <th>제목</th>
                            <th>저자</th>
                            <th>출판사</th>
                            <th>십진분류번호</th>
                            <th>빌린 날짜</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>책 제목</td>
                            <td>저자명</td>
                            <td>출판사</td>
                            <td>십진분류번호</td>
                            <td>빌린 날짜</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="banInfo">
                <div class="banList">
                    <h4>이용 제한 리스트</h4>
                    <table>
                        <thead>
                        <tr>
                            <th>제한 사유</th>
                            <th>제한 일자</th>
                            <th>기한</th>
                            <th>제한 해제</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>책 파손</td>
                            <td>2024-06-20</td>
                            <td>무제한</td>
                            <td><input type="button" value="해제"></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="btnContainer">
                <input type="button" value="서비스 제한">
                <input type="button" value="제한 해제">
                <input type="button" value="영구 삭제">
            </div>
        </div>
    </section>
</main>

<jsp:include page="../../public/adminFooter.jsp"></jsp:include>
</body>
</html>
