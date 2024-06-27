<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
            <!DOCTYPE html>
            <html lang="ko">

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>장서관리</title>
                    <link rel="stylesheet" type="text/css" href="admin/css/public/reset.css">
                    <link rel="stylesheet" type="text/css" href="admin/css/public/adminHeader.css">
                    <link rel="stylesheet" type="text/css" href="admin/css/public/adminFooter.css">
                    <link rel="stylesheet" type="text/css" href="admin/css/public/style.css">
                    <link rel="stylesheet" type="text/css" href="admin/css/bookManage.css">
                    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                </head>

                <body>
                    <jsp:include page="../../public/adminHeader.jsp"></jsp:include>
                    <main>
                        <section class="banner">
                            <h3>장서관리</h3>
                            <p>home > book > manage</p>
                        </section>
                        <section class="totalContainer">
                            <div class="searchContainer">
                                <div>
                                    <select id="searchSelectType">
                                        <option value="title">제목</option>
                                        <option value="author">저자</option>
                                        <option value="genre">십진분류</option>
                                        <option value="all" selected>제목 + 저자</option>
                                    </select>
                                    <div class="inputBox">
                                        <input type="text" id="inputText" class="inputText" name="ss" maxlength="20"
                                            placeholder="검색어를 입력하세요" value="" />
                                        <button type="button" id="searchBtn" class="searchBtn">검색</button>
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
                                        <input class="deleteBtn" type="button" value="일괄 반납" id="returnBooks" onclick="returnBooks()">
                                        <input class="writeBtn" type="button" value="등록" id="createBook" onclick="location.href='/Book/WriteBook'">
                                        <input class="deleteBtn" type="button" value="삭제" id="deleteBook">
                                    </div>
                                </div>
                                <div class="dashBoard">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th><input type="checkbox" id="selectAllCheckbox"></th>
                                                <th>관리번호</th>
                                                <th>제목</th>
                                                <th>저자</th>
                                                <th>출판사</th>
                                                <th>출판년도</th>
                                                <th>십진분류</th>
                                                <th>대여유무</th>
                                                <th colspan="2"></th>
                                            </tr>
                                        </thead>
                                        <tbody id="bookListTBody">
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
                            const userListTBody = $('#bookListTBody');
                            const totalPageElem = $('#totalPage');
                            const selectValue = $('#resultSelect').val();
                            const total = document.getElementById('total');

                            $.ajax({
                                url: '/Book/search',
                                type: 'GET',
                                data: { "searchType": searchType, "searchKeyword": inputText, "pageSize": selectValue },
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
                                            responseText += "<td><input type='checkbox' name='selectedBooks' value='" + response[i].bookId + "'></td>";
                                            responseText += "<td>" + response[i].bookId + "</td>";
                                            responseText += "<td>" + response[i].title + "</td>";
                                            responseText += "<td>" + response[i].authorName + "</td>";
                                            responseText += "<td>" + response[i].publisherName + "</td>";
                                            responseText += "<td>" + response[i].publicationDate + "</td>";
                                            responseText += "<td>" + response[i].genreFullname + "</td>";
                                            responseText += "<td><input type='checkbox' class='borrowTF' disabled " + (response[i].availability == 1 ? "checked" : "") + "></td>";
                                            responseText += "<td><input type='button' class='see' onclick='showBook(" + response[i].bookId + ")'>";
                                            responseText += "<input type='button' class='correction' onclick='modifyBook(" + response[i].bookId + ")'>";
                                            responseText += "<input type='button' class='return' onclick='returnBook(" + response[i].bookId + ")'></td></tr>";
                                        }
                                        userListTBody.html(responseText);
                                        total.innerHTML = "result : " + len + "개";
                                        totalPageElem.html(currentPage + " of " + totalPage);
                                    }
                                }
                            });
                        }


                        function showBook(bookId) {
                            $.ajax({
                                url: '/Book/details',
                                type: 'GET',
                                data: { "bookId": bookId },
                                success: function (response) {
                                    // 서버로부터 받은 데이터를 이용해 책의 상세 정보를 표시합니다.
                                    alert("책 상세 정보: " + JSON.stringify(response));
                                }
                            });
                        }

                        function modifyBook(bookId) {
                            // Book 수정 로직을 구현합니다.
                            $.ajax({
                                url: '/Book/modify',
                                type: 'POST',
                                data: { "bookId": bookId },
                                success: function (response) {
                                    // 수정이 완료된 후의 동작을 구현합니다.
                                    alert("책 수정 완료: " + JSON.stringify(response));
                                    searchBtnEvt(); // 수정 후 목록 갱신
                                }
                            });
                        }

                        // Book 반납 로직을 구현합니다.
                        function returnBook(bookId) {
                            $.ajax({
                                url: '/Book/return',
                                type: 'POST',
                                data: { "bookId": bookId },
                                success: function (response) {
                                    alert("책 반납 완료: " + response);
                                    searchBtnEvt();
                                },
                                error: function (xhr, status, error) {
                                    alert("책 반납 실패: " + error);
                                }
                            });
                        }


                        function returnBooks(bookIds) {
                            $.ajax({
                                url: '/Book/returnMultiple',
                                type: 'POST',
                                data: JSON.stringify(bookIds),
                                contentType: 'application/json; charset=UTF-8',
                                success: function (response) {
                                    alert("선택한 책들 반납 완료: " + response);
                                    searchBtnEvt();
                                },
                                error: function (xhr, status, error) {
                                    alert("책들 반납 실패: " + error);
                                }
                            });
                        }

                    </script>
                </body>

            </html>