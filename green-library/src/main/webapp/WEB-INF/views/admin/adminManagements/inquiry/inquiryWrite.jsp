<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inquiryDetail</title>
    <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/inquiryDetail.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>문의 상세</h3>
        <p>home > management > inquiry > detail</p>
    </section>
    <section class="viewContainer">
        <div class="btnWrap">
            <input class="modiBtn" type="button" value="답변">
            <input class="deleteBtn" type="button" value="삭제">
        </div>
        <table class="announcementInfo">
            <tr>
                <th>번호</th>
                <td id="writdIdx">${inquiry.inquiryId}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td id="writdTitle">${inquiry.inquiryTitle}</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td id="writerId">${inquiry.userId}</td>
            </tr>
            <tr>
                <th>작성일</th>
                <td id="writeDate">${inquiry.inquiryDate}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td id="contents">${inquiry.contents}</td>
            </tr>
        </table>
        <div class="boardNav">
            <div class="prevNav">
                <span class="tit">이전글</span><span class="con" id="prevCon"></span>
            </div>
            <div class="nextNav">
                <span class="tit">다음글</span><span class="con" id="nextCon"></span>
            </div>
        </div>
        <div class="board-btn">
            <a href="/Inquiry" class="listBtn">목록</a>
        </div>
    </section>
</main>
<jsp:include page="../../public/adminFooter.jsp"></jsp:include>
<script>
    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');

    $(document).ready(function () {
        prevPage(${inquiry.inquiryId});
        nextPage(${inquiry.inquiryId});
    });

    function prevPage(inquiryId) {
        $.ajax({
            url: '/Inquiry/prevInquiry',
            type: 'GET',
            data: { inquiryId: inquiryId },
            beforeSend: function (xhr) {
                xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
            },
            success: function (data) {
                if (data && data.inquiryTitle && data.inquiryId) {
                    $("#prevCon").text(data.inquiryTitle);
                    $("#prevCon").attr("href", "/Inquiry/Detail?inquiryId=" + data.inquiryId);
                } else {
                    $("#prevCon").text("이전글이 없습니다.");
                }
            },
            error: function (xhr, status, error) {
                console.error("오류 발생: " + error);
            }
        });
    }

    function nextPage(inquiryId) {
        $.ajax({
            url: '/Inquiry/nextInquiry',
            type: 'GET',
            data: { inquiryId: inquiryId },
            beforeSend: function (xhr) {
                xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
            },
            success: function (data) {
                if (data && data.inquiryTitle && data.inquiryId) {
                    $("#nextCon").text(data.inquiryTitle);
                    $("#nextCon").attr("href", "/Inquiry/Detail?inquiryId=" + data.inquiryId);
                } else {
                    $("#nextCon").text("다음글이 없습니다.");
                }
            },
            error: function (xhr, status, error) {
                console.error("오류 발생: " + error);
            }
        });
    }
</script>

</body>

</html>
