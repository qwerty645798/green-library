<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="ko">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <meta name="csrf-token" content="${_csrf.token}">
                <title>사용자 관리</title>
                <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
                <link rel="stylesheet" type="text/css" href="/admin/css/public/adminHeader.css">
                <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
                <link rel="stylesheet" type="text/css" href="/admin/css/public/style.css">
                <link rel="stylesheet" type="text/css" href="/admin/css/users.css">
                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            </head>

            <body>
                <jsp:include page="../../public/adminHeader.jsp"></jsp:include>
                <main>
                    <section class="banner">
                        <h3>이용자 관리</h3>
                        <p>home > management > users</p>
                    </section>
                    <section class="mainContainer">
                        <div class="leftContainer">
                            <div class="searchContainer">
                                <div>
                                    <select name="searchType" id="searchSelectType">
                                        <option value="all">전체</option>
                                        <option value="name">이름</option>
                                        <option value="userId">아이디</option>
                                    </select>
                                    <div class="inputBox">
                                        <input type="text" id="inputText" class="inputText" name="searchKeyword"
                                            maxlength="20" placeholder="검색어를 입력하세요" value="" />
                                        <button type="button" id="searchBtn" class="searchBtn">검색 </button>
                                    </div>
                                </div>
                            </div>
                            <div class="resultContainer">
                                <div class="results">
                                    <p id="total">result : </p>
                                    <select name="pageSize" id="resultSelect">
                                        <option value="10" selected>10개씩</option>
                                        <option value="15">15개씩</option>
                                        <option value="20">20개씩</option>
                                    </select>
                                    <div class="paging">
                                        <input class="back" type="button">
                                        <p id="totalpage"> of </p>
                                        <input class="next" type="button">
                                    </div>
                                </div>
                                <div class="outBoard">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th><input type="checkbox" id="selectAllCheckbox"></th>
                                                <th>아이디</th>
                                                <th>이름</th>
                                                <th>이메일</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody id="userListTBody">
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="rightContainer">
                            <div class="userInfo">
                                <h4>사용자 정보</h4>
                                <p>이름 : <span id="userName"></span></p>
                                <p>아이디 : <span id="userId"></span></p>
                                <p>이메일 : <span id="userEmail"></span></p>
                                <p>전화번호 : <span id="userPhone"></span></p>
                            </div>
                            <div class="loanInfo">
                                <h4>대출 현황</h4>
                                <div class="bookInfo">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>제목</th>
                                                <th>저자</th>
                                                <th>출판사</th>
                                                <th>십진분류번호</th>
                                                <th>빌린 날짜</th>
                                            </tr>
                                        </thead>
                                        <tbody id="loanInfoBody">
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="banInfo">
                                <div class="banList">
                                    <h4>이용 제한 리스트</h4>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>제한 사유</th>
                                                <th>제한 일자</th>
                                                <th>기한</th>
                                                <th>제한 해제</th>
                                            </tr>
                                        </thead>
                                        <tbody id="banInfoBody">
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="btnContainer">
                                <!-- <input type="button" value="서비스 제한" onclick="createSuspen()"> -->
                                <!-- <input type="button" value="제한 해제" onclick="deleteSuspen()"> -->
                                <input type="button" value="영구 삭제" onclick="deleteUsers()">
                            </div>
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
                        });

                        // 전체 선택 & 해제
                        $('#selectAllCheckbox').on('change', function () {
                            $('input[name="userCheckbox"]').prop('checked', this.checked);
                        });

                        // 수정 버튼 클릭 시 사용자 정보 로드
                        $('table').on('click', '.modifyBtn', function () {
                            let userId = $(this).closest('tr').find('td:eq(1)').text().trim(); // 클릭한 버튼의 사용자 ID 가져오기
                            loadUserInfo(userId);
                        });

                        // select 값 변경 시 검색 실행
                        $('#resultSelect').on('change', function () {
                            currentPage = 1;
                            searchBtnEvt();
                        });

                        // 다음 버튼 클릭 시 페이징 처리
                        $('.next').click(function () {
                            if (currentPage < totalPage) {
                                currentPage++;
                                clearCheckboxes();
                                searchBtnEvt();
                            }
                        });

                        // 이전 버튼 클릭 시 페이징 처리
                        $('.back').click(function () {
                            if (currentPage > 1) {
                                currentPage--;
                                clearCheckboxes();
                                searchBtnEvt();
                            }
                        });

                        //초기 로딩
                        // loadUserInfo(userId);
                    });

                    function searchBtnEvt(e) {
                        const inputText = document.getElementById('inputText').value;
                        const searchType = document.getElementById('searchSelectType').value;
                        const userListTBody = document.getElementById('userListTBody');
                        const total = document.getElementById('total');
                        const pages = document.getElementById('totalpage');
                        const selectValue = document.getElementById('resultSelect').value;

                        $.ajax({
                            url: '/User/search',
                            type: 'GET',
                            data: { "searchType": searchType, "searchKeyword": inputText, "pageSize": selectValue },
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
                                            responseText += "<td><input type='checkbox' name='userCheckbox'id='userCheckbox'/></td>";
                                            responseText += "<td>" + response[i].userId + "</td>";
                                            responseText += "<td>" + response[i].userName + "</td>";
                                            responseText += "<td>" + response[i].userEmail + "</td>";
                                            responseText += "<td><input type='button' className='modifyBtn' onclick=loadUserInfo('" + response[i].userId + "') /> </td></tr>";
                                        }
                                    }
                                    else {
                                        totalPage = currentPage;
                                    }
                                    userListTBody.innerHTML = responseText;
                                    total.innerHTML = "result : " + len + "명";
                                    pages.innerHTML = currentPage + " of " + totalPage;
                                }
                            }
                        });
                    }

                    function loadUserInfo(userId) {
                        $.ajax({
                            url: '/User/details',
                            type: 'GET',
                            data: { userId: userId },
                            success: function (response) {
                                if (response) {
                                    $('#userName').text(response.user.userName);
                                    $('#userId').text(response.user.userId);
                                    $('#userEmail').text(response.user.userEmail);
                                    $('#userPhone').text(response.user.userPhone);

                                    // 대출 현황 업데이트
                                    updateLoanInfo(response.loanInfo);

                                    // 이용 제한 리스트 업데이트
                                    updateBanInfo(response.suspensions);
                                }
                            },
                            error: function () {
                                alert('사용자 정보를 불러오는 데 실패하였습니다.');
                            }
                        });
                    }

                    function updateLoanInfo(loanInfo) {
                        var loanInfoBody = $('#loanInfoBody');
                        loanInfoBody.empty(); // 이전 데이터 초기화
                        if (loanInfo && loanInfo.length > 0) {
                            loanInfo.forEach(function (loan) {
                                var row = '<tr>' +
                                    '<td>' + loan.title + '</td>' +
                                    '<td>' + loan.author + '</td>' +
                                    '<td>' + loan.publisher + '</td>' +
                                    '<td>' + loan.classificationNumber + '</td>' +
                                    '<td>' + loan.borrowDate + '</td>' +
                                    '</tr>';
                                loanInfoBody.append(row);
                            });
                        } else {
                            loanInfoBody.append('<tr><td colspan="5">대출 이력이 없습니다.</td></tr>');
                        }
                    }

                    function updateBanInfo(suspensions) {
                        var banInfoBody = $('#banInfoBody');
                        banInfoBody.empty(); // 이전 데이터 초기화
                        if (suspensions && suspensions.length > 0) {
                            suspensions.forEach(function (ban) {
                                var row = '<tr>' +
                                    '<td>' + ban.reason + '</td>' +
                                    '<td>' + ban.startDate + '</td>' +
                                    '<td>' + ban.duration + '</td>' +
                                    '<td><input type="button" value="해제" onclick="releaseBan(' + ban.banId + ')"></td>' +
                                    '</tr>';
                                banInfoBody.append(row);
                            });
                        } else {
                            banInfoBody.append('<tr><td colspan="4">이용 제한 기록이 없습니다.</td></tr>');
                        }
                    }

                    function clearCheckboxes() {
                        $('input[name="userCheckbox"]').prop('checked', false);
                        $('#selectAllCheckbox').prop('checked', false);
                    }

                    // CSRF 토큰을 메타 태그에서 가져옴
                    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');


                    // 유저 영구 삭제 함수
                    function deleteUsers() {
                        let userIds = [];

                        // 체크된 체크박스에서 userId 값을 배열에 저장
                        $('input[name="userCheckbox"]:checked').each(function () {
                            let userId = $(this).closest('tr').find('td:eq(1)').text().trim(); // 각 체크박스가 속한 행의 userId 가져오기
                            userIds.push(userId);
                        });

                        if (userIds.length === 0) {
                            alert('삭제할 사용자를 선택해주세요.');
                            return;
                        }

                        if (confirm('선택한 사용자를 영구 삭제하시겠습니까?')) {
                            console.log(typeof userIds, userIds)

                            $.ajax({
                                url: '/User/deleteUsers',
                                type: 'POST',
                                data: { userIds: userIds },
                                traditional: true, // 배열 데이터 전송을 위한 설정
                                beforeSend: function (xhr) {
                                    // 요청 헤더에 CSRF 토큰을 포함
                                    xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
                                },
                                success: function (response) {
                                    alert('선택한 사용자가 성공적으로 삭제되었습니다.');
                                    // 삭제 후에는 다시 검색을 실행하여 목록을 업데이트합니다.
                                    searchBtnEvt();
                                },
                                error: function () {
                                    alert('사용자 삭제를 실패하였습니다.');
                                }
                            });
                        }
                    }

                    // 제한 해제 함수
                    function releaseBan(banId) {
                        if (confirm('정말로 이 이용 제한을 해제하시겠습니까?')) {
                            $.ajax({
                                url: '/User/releaseBan',
                                type: 'POST',
                                data: { banId: banId },
                                beforeSend: function (xhr) {
                                    // 요청 헤더에 CSRF 토큰을 포함
                                    xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
                                },
                                success: function (response) {
                                    alert('이용 제한이 성공적으로 해제되었습니다.');

                                },
                                error: function () {
                                    alert('이용 제한 해제를 실패하였습니다.');
                                }
                            });
                        }
                    }

                </script>
            </body>

        </html>