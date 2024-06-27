<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inquiry</title>

    <link rel="stylesheet" type="text/css" href="admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="admin/css/inquiryManage.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>문의 게시판</h3>
        <p>home > management > inquiry</p>
    </section>
    <section class="totalContainer">
        <div class="searchContainer">
            <div>
                <select id="searchSelectType">
                    <option value="all" selected>전체</option>
                    <option value="title">제목</option>
                    <option value="contents">내용</option>
                </select>
                <div class="inputBox">
                    <input type="text" id="inputText" class="inputText" name="searchKeyword" maxlength="20"
                           placeholder="검색어를 입력하세요" value=""/>
                    <button type="button" id="searchBtn" class="searchBtn">검색</button>
                </div>
            </div>
        </div>
        <!-- board -->
        <div class="outputBoard">
            <div class="results">
                <p id="total">result : </p>
                <select id="resultSelect" name="pageSize">
                    <option value="5">5개씩</option>
                    <option value="10">10개씩</option>
                    <option value="15" selected>15개씩</option>
                </select>
                <div class="btnWrap">
                    <input type="button" value="답변한 것도 보기">
                    <input type="button" value="답변한 것만 보기">
                    <input class="deleteBtn" type="button" value="삭제">
                </div>
            </div>
            <div class="dashBoard">
                <table>
                    <thead>
                    <tr>
                        <th><input type="checkbox" name="" id="selectAllCheckbox"></th>
                        <th>문의번호</th>
                        <th>제목</th>
                        <th>내용</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>답변 여부</th>
                        <th colspan="2"></th>
                    </tr>
                    </thead>
                    <tbody id="inquiryListTBody">
                    </tbody>
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

    $(document).ready(function () {
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
            currentPage++;
            searchBtnEvt();
        });

        // 이전 버튼 클릭 시
        $('.back').click(function () {
            if (currentPage > 1) {
                currentPage--;
                searchBtnEvt();
            }
        });
    });

    function searchBtnEvt() {
        const inputText = $('#inputText').val();
        const searchType = $('#searchSelectType').val();
        const userListTBody = $('#inquiryListTBody');
        const totalPageElem = $('#totalPage');
        const selectValue = $('#resultSelect').val();
        const total = document.getElementById('total');

        $.ajax({
            url: '/searchInquiries',
            type: 'GET',
            data: {"searchType": searchType, "searchKeyword": inputText, "pageSize": selectValue},
            success: function (response) {
                if (response) {
                    let responseText = '';
                    let len = response.length;
                    let totalPage = Math.ceil(len / selectValue);
                    let startPrint = (currentPage - 1) * selectValue;
                    let endPrint = currentPage * selectValue;
                    if (endPrint > len) {
                        endPrint = len;
                    }
                    for (let i = startPrint; i < endPrint; i++) {
                        responseText += "<tr>";
                        responseText += "<td><input type='checkbox' name='' id=''></td>";
                        responseText += "<td>" + response[i].inquiryId + "</td>";
                        responseText += "<td>" + response[i].inquiryTitle + "</td>";
                        responseText += "<td>" + response[i].contents + "</td>";
                        responseText += "<td>" + response[i].userId + "</td>";
                        responseText += "<td>" + response[i].inquiryDate + "</td>";
                        responseText += "<td><input type='checkbox' name='' id='' disabled " + response[i].responseTF == 1 ? 'checked' : '' + "></td>";
                        responseText += "<td><input type='button' class='correction'>";
                    }
                    userListTBody.html(responseText);
                    total.innerHTML = "result : " + len + "개";
                    totalPageElem.html(currentPage + " of " + totalPage);
                }
            }
        });
    }
</script>
</body>

</html>
