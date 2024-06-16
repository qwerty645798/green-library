<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>bookInfo</title>

        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/reset.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminHeader.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminFooter.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/style.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/bookInfo.css">
    </head>

    <body>
        <header class="header" id="header"></header>
        <main>
            <section class="banner">
                <h3>도서 정보</h3>
                <p>home > book > detail</p>
            </section>
            <section class="viewContainer">
                <div class="btnWrap">
                    <input class="deleteBtn" type="button" value="삭제">
                </div>
                <table class="announcementInfo">
                    <table>
                        <tr>
                            <th>번호</th>
                            <td></td>
                            <th>ISBN</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>제목</th>
                            <td></td>
                            <th>저자</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>출판사</th>
                            <td></td>
                            <th>발간일자</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>십진분류</th>
                            <td></td>
                            <th>대여유무</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>위치</th>
                            <td></td>
                            <th>재고량</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>이미지</th>
                            <td><img src="http://example.com/image.jpg" alt="도서 이미지"></td>
                            <th>내용</th>
                            <td></td>
                        </tr>
                    </table>
                    <div class="boardNav">
                        <div class="prevNav">
                            <span class="tit">이전글</span><span class="con">이전글</span>
                        </div>
                        <div class="nextNav">
                            <span class="tit">다음글</span><span class="con">다음글이 없습니다.</span>
                        </div>
                    </div>
                    <div class="board-btn">
                        <a href="#" class="listBtn">목록</a>
                    </div>
            </section>
        </main>
        <footer class="footer" id="footer"></footer>
    </body>

</html>