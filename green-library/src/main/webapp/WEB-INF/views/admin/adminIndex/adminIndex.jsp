<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>main</title>
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/reset.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminFooter.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/style.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/adminIndex.css">
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
                    <div class="box buying" onclick="navigateTo('buying.jsp')">
                        <div>
                            <img src="../util/buying.png" alt="">
                            <p>수서</p>
                        </div>
                    </div>
                    <div class="box info" onclick="navigateTo('info.jsp')">
                        <div>
                            <img src="../util/adminImg.png" alt="">
                            <p>내 정보</p>
                        </div>
                    </div>
                </div>
                <div class="boxWrap">
                    <div class="box users" onclick="navigateTo('users.jsp')">
                        <div><img src="../util/users.png" alt="">
                            <P>이용자</P>
                        </div>
                    </div>
                    <div class="box others" onclick="navigateTo('others.jsp')">
                        <div><img src="../util/collection.png" alt="">
                            <p>장서관리</p>
                        </div>
                    </div>
                </div>
                <div class="boxWrap">
                    <div class="box inquiry" onclick="navigateTo('inquiry.jsp')">
                        <div><img src="../util/inquiry.png" alt="">
                            <p>문의사항</p>
                        </div>
                    </div>
                    <div class="box announce" onclick="navigateTo('announce.jsp')">
                        <div><img src="../util/announcement.png" alt="">
                            <p>공지사항</p>
                        </div>
                    </div>
                </div>
                <div class="boxWrap">
                    <div class="box userLink" onclick="navigateTo('userLink.jsp')">
                        <div><img src="../util/link.png" alt="">
                            <p>홈페이지</p>
                            <p>바로가기</p>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <footer class="footer" id="footer"></footer>
        <script src="./clock.js"></script>
        <script src="./click.js"></script>
    </body>

</html>