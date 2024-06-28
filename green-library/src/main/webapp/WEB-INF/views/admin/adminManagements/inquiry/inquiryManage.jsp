<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문의 게시판</title>
    <meta name="csrf-token" content="${_csrf.token}">
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
                    <input class="deleteBtn" type="button" value="삭제" onclick="deleteInquiry()">
                </div>
            </div>
            <div class="dashBoard">
                <table>
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="selectAllCheckbox"></th>
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
            <p id="totalPage"> of </p>
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
            if(currentPage < totalPage){
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
    });

    function searchBtnEvt(e) {
        const inputText = document.getElementById('inputText').value;
        const searchType = document.getElementById('searchSelectType').value;
        const inquiryListTBody = document.getElementById('inquiryListTBody');
        const total = document.getElementById('total');
        const pagesParam = document.getElementById('totalpage');
        const selectValue = document.getElementById('resultSelect').value;

        $.ajax({
            url: '/Inquiry/search',
            type: 'GET',
            data: {"searchType": searchType, "searchKeyword": inputText, "pageSize": selectValue},
            success: function (response) {
                if (response) {
                    let responseText = '';
                    let len = response.length;
                    if (len > 0) {
                        let startPrint = currentPage * selectValue - selectValue;
                        let endPrint = currentPage * selectValue;
                        totalPage = Math.ceil(len / selectValue);
                        if (endPrint > len) endPrint = len;
                        for (let i = startPrint; i < endPrint; i++) {
                            responseText += "<tr>";
                            responseText += "<td><input type='checkbox' name='userCheckbox' id=''></td>";
                            responseText += "<td>" + response[i].inquiryId + "</td>";
                            responseText += "<td>" + response[i].inquiryTitle + "</td>";
                            responseText += "<td>" + response[i].contents + "</td>";
                            responseText += "<td>" + response[i].userId + "</td>";
                            responseText += "<td>" + response[i].inquiryDate + "</td>";
                            responseText += "<td><input type='checkbox' name='' id='' disabled " + (response[i].responseTF == 1 ? "checked" : "") + "></td>";
                            responseText += "<td><input type='button' class='correction'>";
                        }
                    } else {
                        totalPage = currentPage;
                    }
                    inquiryListTBody.innerHTML = responseText;
                    total.innerHTML = "result : " + len + "개";
                    pagesParam.html(currentPage + " of " + totalPage);
                }
            }
        });
    }

    function clearCheckboxes() {
        $('input[name="userCheckbox"]').prop('checked', false);
        $('#selectAllCheckbox').prop('checked', false);
    }

    // CSRF 토큰을 메타 태그에서 가져옴
    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');


    // 영구 삭제 함수
    function deleteInquiry() {
        let inquiryIds = [];


        $('input[name="userCheckbox"]:checked').each(function () {
            let inquiryId = $(this).closest('tr').find('td:eq(1)').text().trim();
            inquiryIds.push(inquiryId);
        });

        console.log('Collected inquiryIds:', inquiryIds);

        if (inquiryIds.length === 0) {
            alert('삭제할 목록을 선택해주세요.');
            return;
        }

        if (confirm('선택한 사항을 영구 삭제하시겠습니까?')) {
            $.ajax({
                url: '/Inquiry/deleteInquiry',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(inquiryIds),
                beforeSend: function (xhr) {
                    // 요청 헤더에 CSRF 토큰을 포함
                    xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
                },
                success: function (response) {
                    console.log('Response:', response);
                    alert('선택한 사항들이 성공적으로 삭제되었습니다.');
                    searchBtnEvt();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.error('AJAX Error:', textStatus, errorThrown);
                    alert('사용자 삭제를 실패하였습니다.');
                }
            });
        }
    }
</script>
</body>

</html>
