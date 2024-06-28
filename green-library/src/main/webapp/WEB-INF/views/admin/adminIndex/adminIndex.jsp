<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>main</title>
        <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
        <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
        <link rel="stylesheet" type="text/css" href="/admin/css/adminIndex.css">
    </head>

    <body>
        <main>
            <section class="clock" id="clock">
                <div class="time">
                    <div class="time-colon">
                        <div class="time-text">
                            <span class="num hour_num">09</span>
                        </div>
                        <span class="colon">:</span>
                    </div>
                    <div class="time-colon">
                        <div class="time-text">
                            <span class="num min_num">00</span>
                        </div>
                        <span class="colon">:</span>
                    </div>
                    <div class="time-colon">
                        <div class="time-text">
                            <span class="num sec_num">00</span>
                        </div>
                        <span class="am_pm">AM</span>
                    </div>
                </div>
            </section>
            <section class="indexContainer">
                <div class="boxWrap">
                    <div class="box buying" onclick="navigateTo('BuyBook')">
                        <div>
                            <img src="admin/assets/imgs/buying.png" alt="">
                            <p>수서</p>
                        </div>
                    </div>
                    <div class="box info" onclick="navigateTo('adminInfo')">
                        <div>
                            <img src="admin/assets/imgs/adminImg.png" alt="">
                            <p>내 정보</p>
                        </div>
                    </div>
                </div>
                <div class="boxWrap">
                    <div class="box users" onclick="navigateTo('User')">
                        <div><img src="admin/assets/imgs/users.png" alt="">
                            <P>이용자</P>
                        </div>
                    </div>
                    <div class="box others" onclick="navigateTo('Book')">
                        <div><img src="admin/assets/imgs/collection.png" alt="">
                            <p>장서관리</p>
                        </div>
                    </div>
                </div>
                <div class="boxWrap">
                    <div class="box inquiry" onclick="navigateTo('Inquiry')">
                        <div><img src="admin/assets/imgs/inquiry.png" alt="">
                            <p>문의사항</p>
                        </div>
                    </div>
                    <div class="box announce" onclick="navigateTo('announcement')">
                        <div><img src="admin/assets/imgs/announcement.png" alt="">
                            <p>공지사항</p>
                        </div>
                    </div>
                </div>
                <div class="boxWrap">
                    <div class="box userLink" onclick="navigateTo('/')">
                        <div><img src="admin/assets/imgs/link.png" alt="">
                            <p>홈페이지</p>
                            <p>바로가기</p>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <jsp:include page="../public/adminFooter.jsp"></jsp:include>
    <script src="admin/js/clock.js"></script>
    <script src="admin/js/click.js"></script>

    </body>

</html>