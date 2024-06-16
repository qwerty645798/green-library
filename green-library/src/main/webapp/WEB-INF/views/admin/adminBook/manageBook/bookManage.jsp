<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>pronunciation</title>
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/reset.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminHeader.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminFooter.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/style.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/bookManage.css">
    </head>

    <body>
        <header class="header" id="header"></header>
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
                        <p>result : ${개}</p>
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
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗ㅁㅁㅁㅁㅁㅁㅁㅁ</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td>
                                    <input type="button" class="see">
                                    <input type="button" class="correction">
                                    <input type="button" class="return">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>2</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>3</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>5</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>10</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>1</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="" id=""></td>
                                <td>15</td>
                                <td>title</td>
                                <td>admin</td>
                                <td>길벗</td>
                                <td>2024-04-01</td>
                                <td>999.9861456</td>
                                <td><input type="checkbox" class="borrowTF" disabled></td>
                                <td><input type="button" class="correction">
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="paging">
                    <div class="paging">
                        <input class="back" type="button">
                        <p>${page} of ${total}</p>
                        <input class="next" type="button">
                    </div>
                </div>
            </section>
        </main>
        <footer class="footer" id="footer"></footer>
    </body>

</html>