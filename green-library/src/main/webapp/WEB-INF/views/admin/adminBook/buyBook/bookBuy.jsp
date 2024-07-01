<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="csrf-token" content="${_csrf.token}">
    <title>수서관리</title>
    <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/bookBuy.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>수서관리</h3>
        <p>home > book > buy</p>
    </section>
    <section class="totalContainer">
        <div class="searchContainer">
            <div>
                <select id="searchSelectType">
                    <option value="title">제목</option>
                    <option value="author">저자</option>
                    <option value="publish">출판사</option>
                    <option value="total" selected>제목 + 저자</option>
                </select>
                <div class="inputBox">
                    <input type="text" id="inputText" class="inputText" name="searchKeyword" maxlength="20"
                           placeholder="검색어를 입력하세요"/>
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
                <div class="radioWrap">
                    <label><input type="radio" name="completeKinds" id="waitItem" value="wait" checked/>승인 대기</label>
                    <label><input type="radio" name="completeKinds" id="acceptItem" value="accept"/> 승인 사항</label>
                    <label><input type="radio" name="completeKinds" id="refuseItem" value="refuse"/> 거부사항</label>
                    <label><input type="radio" name="completeKinds" id="showAll" value="all"/>전체</label>
                </div>
                <div class="btnWrap">
                    <input class="acceptBtn" type="button" value="승인" id="acceptBook" onclick="acceptBooks()">
                    <input class="deleteBtn" type="button" value="거부" id="refuseBook" onclick="refuseBooks()">
                </div>
            </div>
            <div class="dashBoard">
                <table>
                    <thead>
                    <tr>
                        <th><input type="checkbox" name="selectAllCheckbox" id="selectAllCheckbox"></th>
                        <th>관리번호</th>
                        <th>제목</th>
                        <th>저자</th>
                        <th>출판사</th>
                        <th>출판년도</th>
                        <th>가격</th>
                        <th colspan="2"></th>
                    </tr>
                    </thead>
                    <tbody id="buyListTBody">
                    </tbody>
                </table>
            </div>
        </div>
        <div class="paging">
            <input class="back" type="button">
            <p id="totalPage"></p>
            <input class="next" type="button">
        </div>
    </section>
</main>
<jsp:include page="../../public/adminFooter.jsp"></jsp:include>

<script>
    $(document).ready(function () {
        // 초기화
        currentPage = 1;
        totalPage = currentPage;
        searchBtnEvt();

        // 검색 버튼 클릭 시
        $('#searchBtn').click(function () {
            currentPage = 1;
            searchBtnEvt();
        });

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
                searchBtnEvt();
            }
        });

        // 이전 버튼 클릭 시
        $('.back').click(function () {
            if (currentPage > 1) {
                currentPage--;
                searchBtnEvt();
            }
        });

        // 라디오 버튼 변경 시
        $('input[name="completeKinds"]').change(function () {
            currentPage = 1;
            searchBtnEvt();
        });
    });

    function searchBtnEvt() {
        const inputText = $('#inputText').val();
        const searchType = $('#searchSelectType').val();
        const buyListTBody = $('#buyListTBody');
        const totalPageElem = $('#totalPage');
        const selectValue = $('#resultSelect').val();
        const total = document.getElementById('total');
        const completeKind = $('input[name="completeKinds"]:checked').val();

        console.log(completeKind);


        $.ajax({
            url: '/BuyBook/search',
            type: 'GET',
            data: {
                "searchType": searchType,
                "searchKeyword": inputText,
                "pageSize": selectValue,
                "completeKind": completeKind // 라디오 버튼 값 전달
            },
            success: function (response) {
                if (response) {
                    let responseText = '';
                    let len = response.length;
                    totalPage = Math.ceil(len / selectValue);
                    let startPrint = (currentPage - 1) * selectValue;
                    let endPrint = currentPage * selectValue;
                    if (endPrint > len) {
                        endPrint = len;
                    }
                    for (let i = startPrint; i < endPrint; i++) {
                        responseText += "<tr>";
                        responseText += "<td><input type='checkbox' name='selectedBooks' value='" + response[i].wishlistId + "'></td>";
                        responseText += "<td>" + response[i].wishlistId + "</td>";
                        responseText += "<td>" + response[i].wishTitle + "</td>";
                        responseText += "<td>" + response[i].wishAuthor + "</td>";
                        responseText += "<td>" + response[i].wishPublisher + "</td>";
                        responseText += "<td>" + response[i].wishPublication + "</td>";
                        responseText += "<td>" + response[i].wishPrice + "</td>";
                        responseText += "<td><input type='checkbox' disabled " + ((response[i].complete == 'W') ? "" : "checked") + "></td>";
                        responseText += "<td><input type='button' class='correction' onclick='modifyBook(" + response[i].bookId + ")'>";
                        responseText += "</tr>";
                    }
                    buyListTBody.html(responseText);
                    total.innerHTML = "result : " + len + "개";
                    totalPageElem.html(currentPage + " of " + totalPage);
                }
            },
            error: function (xhr, status, error) {
                console.error("Error occurred during book search:", error);
                alert("서버 오류가 발생했습니다. 다시 시도해주세요.");
            }
        });
    }

    // 승인 함수
    function acceptBooks() {
        let bookIds = [];

        $('input[name="selectedBooks"]:checked').each(function () {
            let bookId = $(this).closest('tr').find('td:eq(1)').text().trim();
            bookIds.push(bookId);
        });

        if (bookIds.length === 0) {
            alert('목록을 선택해주세요.');
            return;
        }

        if (confirm('선택한 사항을 승인하시겠습니까?')) {
            $.ajax({
                url: '/BuyBook/acceptBooks',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(bookIds),
                beforeSend: function (xhr) {
                    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
                    xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
                },
                success: function (response) {
                    alert('선택한 사항들이 승인되었습니다.');
                    searchBtnEvt();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert('승인에 실패하였습니다.');
                }
            });
        }
    }

    // 거부 함수
    function refuseBooks() {
        let bookIds = [];

        $('input[name="selectedBooks"]:checked').each(function () {
            let bookId = $(this).closest('tr').find('td:eq(1)').text().trim();
            bookIds.push(bookId);
        });

        if (bookIds.length === 0) {
            alert('목록을 선택해주세요.');
            return;
        }

        if (confirm('선택한 사항을 거부하시겠습니까?')) {
            $.ajax({
                url: '/BuyBook/refuseBooks',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(bookIds),
                beforeSend: function (xhr) {
                    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
                    xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
                },
                success: function (response) {
                    alert('선택한 사항들이 성공적으로 거부되었습니다.');
                    searchBtnEvt();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert('거부에 실패하였습니다.');
                }
            });
        }
    }

</script>
</body>

</html>
