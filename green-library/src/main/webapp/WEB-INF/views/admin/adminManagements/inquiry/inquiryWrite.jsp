<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="csrf-token" content="${_csrf.token}">
    <title>답변 작성</title>
    <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/inquiryWrite.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>질의 응답</h3>
        <p>home > management > inquiry > write</p>
    </section>
    <section class="viewContainer">
        <table class="usersWriteForm">
            <tr>
                <th>제목</th>
                <td id="writedTitle">${inquiry.inquiryTitle}</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td id="userId">${inquiry.userId}</td>
            </tr>
            <tr>
                <th>작성일</th>
                <td id="userDate">${inquiry.inquiryDate}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td id="usersContents">
                    ${inquiry.contents}
                </td>
            </tr>
        </table>
        <!-- 응답테이블 -->
        <table class="inquiryInfo">
            <tr>
                <th>번호</th>
                <td id="writdIdx"></td>
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
                <th>내용 <span>*</span></th>
                <td id="contents">
                    <textarea name="" id="responseContents"></textarea>
                </td>
            </tr>
        </table>
        <div class="btnWrap">
            <input type="button" value="목록" onclick="goToList()">
            <input class="deleteBtn" type="button" value="등록" onclick="uploadBtn(${inquiry.inquiryId})">
        </div>
    </section>
</main>
<jsp:include page="../../public/adminFooter.jsp"></jsp:include>
<script>
    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');

    function goToList(){
        window.location.href='/Inquiry';
    }

    function uploadBtn(inquiryId) {
        let responseContents = document.getElementById('responseContents').value;

        if (!responseContents || responseContents.trim() === '') {
            console.log(responseContents)
            alert('내용을 입력해 주세요.');
            return; // 내용이 비어 있으면 함수 종료
        }

        if (confirm('등록하시겠습니까?')) {
            $.ajax({
                url: '/Inquiry/UploadInquiry',
                type: 'POST',
                data: { inquiryId: inquiryId, responseContents: responseContents },
                beforeSend: function (xhr) {
                    xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
                },
                success: function (data) {
                    alert('등록이 완료되었습니다.');
                    window.location.href = '/Inquiry';
                },
                error: function (xhr, status, error) {
                    console.error("오류 발생: " + error);
                    alert('등록에 실패했습니다. 다시 시도해주세요.');
                }
            });
        }
    }


</script>

</body>

</html>
