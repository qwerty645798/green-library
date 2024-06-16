<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>announcement</title>
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/reset.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminHeader.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminFooter.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/style.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/announManage.css">
    </head>

    <body>
        <header class="header" id="header"></header>
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
                        <p>result : ${개}</p>
                        <select name="" id="">
                            <option value="">5개씩</option>
                            <option value="">10개씩</option>
                            <option value="">15개씩</option>
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
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>아아 제목 늘어나는거 확인겸 길게 써보는 중입니다.</td>
                                <td>title</td>
                                <td>asdfagax...</td>
                                <td>이름이들어가야했지만그러지못했다</td>
                                <td>asdfasdf.pdf</td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="paging">
                        <input class="back" type="button">
                        <p>${page}</p>
                        <input class="next" type="button">
                    </div>
                </div>
            </section>
        </main>
        <footer class="footer" id="footer"></footer>
    </body>

</html>