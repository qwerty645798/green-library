<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="csrf-token" content="${_csrf.token}">
    <title>문의 상세</title>
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
            <input class="responseBtn" type="button" value="답변" onclick="createResponse(${inquiry.inquiryId})">
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
                <span class="tit">이전글</span><a class="con" id="prevCon" href="#"></a>
            </div>
            <div class="nextNav">
                <span class="tit">다음글</span><a class="con" id="nextCon" href="#"></a>
            </div>
        </div>
        <div class="board-btn">
            <a href="/Inquiry" class="listBtn">목록</a>
        </div>
    </section>
</main>
<jsp:include page="../../public/adminFooter.jsp"></jsp:include>
<script>
    $(document).ready(function () {
        const responseTF = ${inquiry.responseTF};
        const inquiryId = ${inquiry.inquiryId};
        prevPage(inquiryId);
        nextPage(inquiryId);
        displayResponseButton(responseTF)
    });

    function displayResponseButton(responseTF) {
        if (responseTF === 1) {
            $(".responseBtn").hide();
        } else {
            $(".responseBtn").show();
        }
    }

    function prevPage(inquiryId) {
        $.ajax({
            url: '/Inquiry/prevInquiry',
            type: 'GET',
            data: { inquiryId: inquiryId },
            beforeSend: function (xhr) {
                const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
                xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
            },
            success: function (data) {
                if (data && data.inquiryTitle && data.inquiryId) {
                    $("#prevCon").text(data.inquiryTitle);
                    $("#prevCon").attr("href", "/Inquiry/DetailInquiry?inquiryId=" + data.inquiryId);
                } else {
                    $("#prevCon").text("이전글이 없습니다.");
                }
            },
            error: function (xhr, status, error) {
                $("#prevCon").text("이전글이 없습니다.");
            }
        });
    }

    function nextPage(inquiryId) {
        $.ajax({
            url: '/Inquiry/nextInquiry',
            type: 'GET',
            data: { inquiryId: inquiryId },
            beforeSend: function (xhr) {
                const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
                xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
            },
            success: function (data) {
                if (data && data.inquiryTitle && data.inquiryId) {
                    $("#nextCon").text(data.inquiryTitle);
                    $("#nextCon").attr("href", "/Inquiry/DetailInquiry?inquiryId=" + data.inquiryId);
                } else {
                    $("#nextCon").text("다음글이 없습니다.");
                }
            },
            error: function (xhr, status, error) {
                $("#nextCon").text("다음글이 없습니다.");
            }
        });
    }

    function createResponse(inquiryId) {
        $.ajax({
            url: '/Inquiry/createBtnClick/' + inquiryId,
            type: 'POST',
            beforeSend: function (xhr) {
                const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
                xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
            },
            success: function (response) {
                // Ajax 요청 성공 시 생성 페이지로 이동
                window.location.href = '/Inquiry/WriteInquiry?inquiryId=' + encodeURIComponent(inquiryId);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('접속에 실패했습니다. 다시 시도해주세요.');
            }
        });
    }
</script>
</body>

</html>
