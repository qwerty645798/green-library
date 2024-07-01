<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="csrf-token" content="${_csrf.token}">
    <title>공지 작성</title>
    <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/announWrite.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>공지 작성</h3>
        <p>home > management > announcement > write</p>
    </section>
    <section class="viewContainer">
        <table class="announcementInfo">
            <tr>
                <th>번호</th>
                <td id="writdIdx"></td>
            </tr>
            <tr>
                <th>제목 <span>*</span></th>
                <td><input type="text" name="" id="announceTitle"></td>
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
                    <textarea name="" id="announceContent"></textarea>
                </td>
            </tr>
            <tr>
                <th>첨부 파일</th>
                <td id="fileRow">
                    <div class="fileDiv">
                        <input type="file" name="" id="fileInput">
                    </div>
                </td>
            </tr>
        </table>
        <div class="btnWrap">
            <input type="button" value="목록" onclick="goToList()">
            <input class="deleteBtn" type="button" value="등록" onclick="uploadAnnounce()">
        </div>
    </section>
</main>
<jsp:include page="../../public/adminFooter.jsp"></jsp:include>
<script>
    $(document).ready(function () {
        const urlParams = new URLSearchParams(window.location.search);
        const announceId = urlParams.get('announceId');
        if (announceId) {
            fetchAnnounceDetails(announceId);
        }
    });

    function fetchAnnounceDetails(announceId) {
        $.ajax({
            url: '/Announcement/getAnnounceById/' + announceId,
            type: 'GET',
            success: function (response) {
                if (response) {
                    $('#writdIdx').text(response.announcementId);
                    $('#announceTitle').val(response.announceTitle);
                    $('#writerId').text(response.writerId);
                    $('#writeDate').text(response.writeDate);
                    $('#announceContent').val(response.contents);
                    if (response.fileName) {
                        $('#fileRow').append('<a href="/resources/static/documents/' + response.fileName + '">' + response.fileName + '</a>');
                    }
                    $('.deleteBtn').val('수정').attr('onclick', 'updateAnnounce(' + response.announcementId + ')');
                }
            },
            error: function (xhr, status, error) {
                console.error("오류 발생: " + error);
                alert('데이터를 불러오는데 실패했습니다. 다시 시도해주세요.');
            }
        });
    }

    function goToList() {
        window.location.href = '/Announcement';
    }

    function uploadAnnounce() {
        const announceTitle = document.getElementById('announceTitle').value.trim();
        const announceContent = document.getElementById('announceContent').value.trim();

        if (!announceTitle || !announceContent) {
            alert('제목과 내용을 모두 입력해 주세요.');
            return;
        }

        if (confirm('등록하시겠습니까?')) {
            const formData = new FormData();
            formData.append('announceTitle', announceTitle);
            formData.append('announceContent', announceContent);
            const fileInput = document.getElementById('fileInput').files[0];
            if (fileInput) {
                formData.append('file', fileInput);
            }

            $.ajax({
                url: '/Announcement/uploadAnnounce',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                beforeSend: function (xhr) {
                    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
                    xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
                },
                success: function (data) {
                    alert('등록이 완료되었습니다.');
                    window.location.href = '/Announcement';
                },
                error: function (xhr, status, error) {
                    console.error("오류 발생: " + error);
                    alert('등록에 실패했습니다. 다시 시도해주세요.');
                }
            });
        }
    }

    function updateAnnounce(announceId) {
        const announceTitle = document.getElementById('announceTitle').value.trim();
        const announceContent = document.getElementById('announceContent').value.trim();

        if (!announceTitle || !announceContent) {
            alert('제목과 내용을 모두 입력해 주세요.');
            return;
        }

        if (confirm('수정하시겠습니까?')) {
            const formData = new FormData();
            formData.append('announceTitle', announceTitle);
            formData.append('announceContent', announceContent);
            formData.append('announceId', announceId);
            const fileInput = document.getElementById('fileInput').files[0];
            if (fileInput) {
                formData.append('file', fileInput);
            }

            $.ajax({
                url: '/Announcement/updateAnnounce',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                beforeSend: function (xhr) {
                    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
                    xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
                },
                success: function (data) {
                    alert('수정이 완료되었습니다.');
                    window.location.href = '/Announcement';
                },
                error: function (xhr, status, error) {
                    console.error("오류 발생: " + error);
                    alert('수정에 실패했습니다. 다시 시도해주세요.');
                }
            });
        }
    }

</script>
</body>

</html>
