<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>users</title>
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/reset.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminHeader.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminFooter.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/style.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/users.css">
    </head>

    <body>
        <header class="header" id="header"></header>
        <main>
            <section class="banner">
                <h3>이용자 관리</h3>
                <p>home > management > users</p>
            </section>
            <section class="mainContainer">
                <div class="leftContainer">
                    <form class="searchContainer" action="">
                        <div>
                            <select name="" id="">
                                <option value="">전체</option>
                                <option value="">이름</option>
                                <option value="">아이디</option>
                            </select>
                            <div class="inputBox">
                                <input type="text" id="inputText" class="inputText" name="ss" maxlength="20"
                                    placeholder="검색어를 입력하세요" value="" />
                                <button type="submit" id="searchBtn" class="searchBtn"> 검색 </button>
                            </div>
                        </div>
                    </form>
                    <div class="resultContainer">
                        <div class="results">
                            <p>result : ${개}</p>
                            <select name="" id="">
                                <option value="">10개씩</option>
                                <option value="">15개씩</option>
                                <option value="">20개씩</option>
                            </select>
                            <div class="paging">
                                <input class="back" type="button">
                                <p>${page} of ${total}</p>
                                <input class="next" type="button">
                            </div>
                        </div>
                        <div class="outBoard">
                            <table>
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" name="" id=""></th>
                                        <th>아이디</th>
                                        <th>이름</th>
                                        <th>이메일</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="clickedUser">
                                        <td><input type="checkbox" name="" id=""></td>
                                        <td>hello</td>
                                        <td>사람이름</td>
                                        <td>email@email.com</td>
                                        <td><input type="button" class="modefi" value=""></td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox" name="" id=""></td>
                                        <td>hello</td>
                                        <td>사람이름</td>
                                        <td>email@email.com</td>
                                        <td><input type="button" class="modefi" value=""></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="rightContainer">
                    <div class="userInfo">
                        <h4>이용자 정보</h4>
                        <p>이름 : ${}</p>
                        <p>아이디 : ${}</p>
                        <p>이메일 : ${}</p>
                        <p>전화번호 : ${}</p>
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
                                        <td>길벗</td>
                                        <td>123.45바14-2</td>
                                        <td>2024-06-13</td>
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
                                    <!-- date 동적 추가 -->
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
                        <input type="button" value="영구삭제">
                    </div>
                </div>
            </section>
        </main>
        <footer class="footer" id="footer"></footer>

        <script src="../../util/callHtml.js"></script>
    </body>

</html>