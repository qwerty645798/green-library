<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>공지 상세</title>
        <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
        <link rel="stylesheet" type="text/css" href="/admin/css/public/adminHeader.css">
        <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
        <link rel="stylesheet" type="text/css" href="/admin/css/public/style.css">
        <link rel="stylesheet" type="text/css" href="/admin/css/announDetail.css">
    </head>

    <body>
    <jsp:include page="../../public/adminHeader.jsp"></jsp:include>
        <main>
            <section class="banner">
                <h3>공지 상세</h3>
                <p>home > management > announcement > detail</p>
            </section>
            <section class="viewContainer">
                <div class="btnWrap">
                    <input class="modiBtn" type="button" value="수정">
                    <input class="deleteBtn" type="button" value="삭제">
                </div>
                <table class="announcementInfo">
                    <tr>
                        <th>번호</th>
                        <td id="writdIdx"></td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td id="writdTitle"></td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td id="writerId">작성자 ID</td>
                    </tr>
                    <tr>
                        <th>작성일</th>
                        <td id="writeDate">작성일</td>
                    </tr>
                    <tr>
                        <th>조회수</th>
                        <td id="viewCount">0</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td id="contents">공지 내용이 여기에 표시됩니다.</td>
                    </tr>
                    <tr id="fileRow">
                        <th>첨부 파일</th>
                        <td>
                            <a href="#" id="fileDownload">첨부 파일 다운로드</a>
                        </td>
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
    <jsp:include page="../../public/adminFooter.jsp"></jsp:include>
    </body>

</html>