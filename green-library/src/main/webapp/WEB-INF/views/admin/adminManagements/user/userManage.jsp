<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="ko">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                                        <button type="button" id="searchBtn" class="searchBtn" onclick="searchBtnEvt()">
                                            검색
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div class="resultContainer">
                                <div class="results">
                                    <p>검색 결과 : ${users.size()}명</p>
                                    <select name="pageSize">
                                        <option value="10">10개씩</option>
                                        <option value="15">15개씩</option>
                                        <option value="20">20개씩</option>
                                    </select>
                                    <div class="paging">
                                        <input class="back" type="button" value="이전">
                                        <p>페이지 of ${users.size()}</p>
                                        <input class="next" type="button" value="다음">
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
                                        <%--                                                <tr>--%>
                                        <%--                                                    <td colspan="5">검색 결과가 없습니다.</td>--%>
                                        <%--                                                </tr>--%>
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
                                <input type="button" value="서비스 제한">
                                <input type="button" value="제한 해제">
                                <input type="button" value="영구 삭제">
                            </div>
                        </div>
                    </section>
                </main>
                <jsp:include page="../../public/adminFooter.jsp"></jsp:include>
                <script>
                    <%--                    window.onload()--%>
                    $(document).ready(function () {
                        searchBtnEvt();

                        // 수정 버튼 클릭 시 사용자 정보 로드
                        $('table').on('click', '.modifyBtn', function () {
                            var userId = $(this).closest('tr').find('td:eq(1)').text().trim(); // 클릭한 버튼의 사용자 ID 가져오기
                            loadUserInfo(userId);
                        });

                        loadUserInfo(userId);
                    });

                    function searchBtnEvt(e) {
                        const inputText = document.getElementById('inputText');
                        const searchType = document.getElementById('searchSelectType');
                        const userListTBody = document.getElementById('userListTBody');
                        $.ajax({
                            url: '/User/search',
                            type: 'GET',
                            data: {"searchType": searchType.value, "searchKeyword": inputText.value},
                            success: function (response) {
                                if (response) {
                                    let responseText = '';
                                    for (let i = 0; i < response.length; i++){
                                        responseText += "<tr>";
                                        responseText += "<td><input type='checkbox' name='userCheckbox'id='userCheckbox'/></td>";
                                        responseText += "<td>" + response[i].userId + "</td>";
                                        responseText += "<td>" + response[i].userName + "</td>";
                                        responseText += "<td>" + response[i].userEmail + "</td>";
                                        responseText += "<td><input type='button' className='modifyBtn' onclick=loadUserInfo('" + response[i].userId + "') /> </td></tr>";
                                    }

                                    userListTBody.innerHTML = responseText;
                                }
                            }
                        });
                    }

                    function loadUserInfo(userId) {
                        $.ajax({
                            url: '/User/details',
                            type: 'GET',
                            data: {userId: userId},
                            success: function (response) {
                                if (response) {
                                    $('#userName').text(response.user.userName);
                                    $('#userId').text(response.user.userId);
                                    $('#userEmail').text(response.user.userEmail);
                                    $('#userPhone').text(response.user.userPhone);


                                    var loanInfoBody = $('#loanInfoBody');
                                    loanInfoBody.empty();
                                    if (response.loanInfo && response.loanInfo.length > 0) {
                                        response.loanInfo.forEach(function (loan) {
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

                                    // 이용 제한 정보 업데이트
                                    var banInfoBody = $('#banInfoBody');
                                    banInfoBody.empty(); // 이전 데이터 초기화
                                    if (response.suspensions && response.suspensions.length > 0) {
                                        response.suspensions.forEach(function (ban) {
                                            var row = '<tr>' +
                                                '<td>' + ban.reason + '</td>' +
                                                '<td>' + ban.startDate + '</td>' +
                                                '<td>' + ban.duration + '</td>' +
                                                '<td><input type="button" value="해제"></td>' +
                                                '</tr>';
                                            banInfoBody.append(row);
                                        });
                                    } else {
                                        banInfoBody.append('<tr><td colspan="4">이용 제한 기록이 없습니다.</td></tr>');
                                    }
                                }
                            }
                        });
                    }
                    // 유저 목록 태그 생성

                    // <tr>
                    //     <td><input type="checkbox" name="userCheckbox"
                    //                id="userCheckbox"/></td>
                    //     <td></td>
                    //     <td></td>
                    //     <td></td>
                    //     <td><input type="button" className="modifyBtn" value="수정"/></td>
                    // </tr>
                </script>
            </body>

        </html>