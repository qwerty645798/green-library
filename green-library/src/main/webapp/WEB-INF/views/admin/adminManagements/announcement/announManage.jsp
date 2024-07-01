<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="csrf-token" content="${_csrf.token}">
    <title>공지 게시판</title>
    <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/announManage.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>공지 게시판</h3>
        <p>home > management > announcement</p>
    </section>
    <section class="totalContainer">
        <div class="searchContainer">
            <div>
                <select name="searchType" id="searchSelectType">
                    <option value="all" selected>전체</option>
                    <option value="title">제목</option>
                    <option value="contents">내용</option>
                </select>
                <div class="inputBox">
                    <input type="text" id="inputText" class="inputText" name="ss" maxlength="20"
                           placeholder="검색어를 입력하세요" value=""/>
                    <button type="button" id="searchBtn" class="searchBtn"> 검색</button>
                </div>
            </div>
        </div>
        <!-- board -->
        <div class="outputBoard">
            <div class="results">
                <p id="total">result : </p>
                <select id="resultSelect">
                    <option value="5">5개씩</option>
                    <option value="10">10개씩</option>
                    <option value="15" selected>15개씩</option>
                </select>
                <div class="btnWrap">
                    <input class="writeBtn" type="button" value="작성" onclick="createAnnounce()">
                    <input class="deleteBtn" type="button" value="삭제" onclick="deleteAnnounce()">
                </div>
            </div>
            <div class="dashBoard">
                <table>
                    <thead>
                    <tr>
                        <th><input type="checkbox" name="" id="selectAllCheckbox"></th>
                        <th>공지번호</th>
                        <th>제목</th>
                        <th>내용</th>
                        <th>관리자</th>
                        <th>작성일</th>
                        <th>파일</th>
                        <th colspan="2"></th>
                    </tr>
                    </thead>
                    <tbody id="announceListTBody"></tbody>
                </table>
            </div>
        </div>
        <div class="paging">
            <input class="back" type="button">
            <p id="totalPage">페이지</p>
            <input class="next" type="button">
        </div>
    </section>
</main>
<jsp:include page="../../public/adminFooter.jsp"></jsp:include>

<script>
    let currentPage = 1;
    let totalPage = currentPage;

    $(document).ready(function () {
        searchBtnEvt();

        $('#searchBtn').click(function () {
            currentPage = 1;
            searchBtnEvt();
        })

        // 전체 선택 & 해제
        $('#selectAllCheckbox').on('change', function () {
            $('input[name="selectedBooks"]').prop('checked', this.checked);
        });

        // select 값 변경 시
        $('#resultSelect').on('change', function () {
            currentPage = 1;
            searchBtnEvt();
        });

        // 다음 버튼 클릭 시
        $('.next').click(function () {
            if (currentPage < totalPage) {
                currentPage++;
                clearCheckboxes();
                searchBtnEvt();
            }
        });

        // 이전 버튼 클릭 시
        $('.back').click(function () {
            if (currentPage > 1) {
                currentPage--;
                clearCheckboxes();
                searchBtnEvt();
            }
        });
    });

    function searchBtnEvt(e) {
        const inputText = document.getElementById('inputText').value;
        const searchType = document.getElementById('searchSelectType').value;
        const announceListTBody = document.getElementById('announceListTBody');
        const total = document.getElementById('total');
        const pages = document.getElementById('totalPage');
        const selectValue = document.getElementById('resultSelect').value;

        $.ajax({
            url: '/Announcement/search',
            type: 'GET',
            data: { "searchType": searchType, "searchKeyword": inputText, "pageSize": selectValue },
            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                let responseText = '';
                if (response) {

                    let len = response.length;
                    totalPage = Math.ceil(len / selectValue);
                    if (len > 0) {
                        let startPrint = (currentPage - 1) * selectValue;
                        let endPrint = currentPage * selectValue;
                        if (endPrint > len) endPrint = len;
                        for (let i = startPrint; i < endPrint; i++) {
                            responseText += "<tr>";
                            responseText += "<td><input type='checkbox' name='selectedBooks' id='selectedBooks'></td>";
                            responseText += "<td>" + response[i].announcementId + "</td>";
                            responseText += "<td>" + response[i].announceTitle + "</td>";
                            responseText += "<td>" + response[i].contents + "</td>";
                            responseText += "<td>" + response[i].writerId + "</td>";
                            responseText += "<td>" + response[i].writeDate + "</td>";
                            if((response[i].fileName).toLowerCase() == 'null')
                            {responseText += "<td>" +' '+ "</td>";}
                            else
                            {responseText += "<td>" + response[i].fileName + "</td>";}
                            responseText += "<td><input type='button' class='correction' onclick='updateAnnounce(" + response[i].announcementId + ")'></td></tr>";
                        }
                    } else {
                        totalPage = currentPage;
                    }
                    announceListTBody.innerHTML = responseText;
                    total.innerHTML = "result : " + len + "개";
                    pages.innerHTML = currentPage + " of " + totalPage;
                }
            }
        });
    }


    function clearCheckboxes() {
        $('input[name="selectedBooks"]').prop('checked', false);
        $('#selectAllCheckbox').prop('checked', false);
    }

    // 삭제
    function deleteAnnounce() {
        let announceIds = [];
        let maxNum = $('input[name="selectedBooks"]');

        $('input[name="selectedBooks"]:checked').each(function () {
            let announceId = $(this).closest('tr').find('td:eq(1)').text().trim(); // 각 체크박스가 속한 행의 announceId 가져오기
            announceIds.push(announceId);
        });

        if (announceIds.length === 0) {
            alert('삭제할 공지를 선택해주세요.');
            return;
        }

        if (confirm('선택한 공지를 삭제하시겠습니까?')) {
            $.ajax({
                url: '/Announcement/deleteAnnounce',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(announceIds),
                traditional: true,
                beforeSend: function (xhr) {
                    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
                    xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
                },
                success: function (response) {
                    alert('선택한 공지가 성공적으로 삭제되었습니다.');
                    searchBtnEvt();
                    clearCheckboxes();
                    if(currentPage == totalPage && announceIds.length >= maxNum.length)
                        currentPage--;
                },
                error: function () {
                    alert('공지 삭제를 실패하였습니다.');
                }
            });
        }
    }

    // 생성
    function createAnnounce() {
        window.location.href = '/Announcement/writingAnnounce';
    }

//     수정
    function updateAnnounce(announceId) {
        $.ajax({
            url: '/Announcement/updateBtnClick/' + announceId,
            type: 'POST',
            beforeSend: function (xhr) {
                const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
                xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
            },
            success: function (response) {
                window.location.href = '/Announcement/updateAnnounce?announceId=' + encodeURIComponent(announceId);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('접속에 실패했습니다. 다시 시도해주세요.');
            }
        });
    }
</script>
</body>

</html>
