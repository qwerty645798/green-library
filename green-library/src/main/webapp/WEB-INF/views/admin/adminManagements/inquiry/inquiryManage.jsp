<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>inquiry</title>

        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/reset.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/style.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminHeader.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminFooter.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/inquiryManage.css">
    </head>

    <body>
        <header class="header" id="header"></header>
        <main>
            <section class="banner">
                <h3>문의 게시판</h3>
                <p>home > management > inquiry</p>
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
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>일해라</td>
                                <td>contentscontentscocontentscontentscontentscontentscontentscontentsntents</td>
                                <td>admin</td>
                                <td>2024-06-12</td>
                                <td><input type="checkbox" name="" id="" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="paging">
                    <input class="back" type="button">
                    <p>${page}</p>
                    <input class="next" type="button">
                </div>
            </section>
        </main>
        <footer class="footer" id="footer"></footer>
    </body>

</html>