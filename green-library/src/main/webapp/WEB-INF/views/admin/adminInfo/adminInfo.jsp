<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Infomation</title>
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/reset.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminHeader.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminFooter.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/style.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/adminInfo.css">
    </head>

    <body>
        <header class="header" id="header"></header>
        <main>
            <section class="banner">
                <h3>내 정보</h3>
                <p>home > Info</p>
            </section>
            <section class="container">
                <div class="leftContainer">
                    <div class="info baseInfo">
                        <h3>내 계정</h3>
                        <p>이름</p>
                        <p>ID : </p>
                        <p>PASS : </p>
                        <p>권한 등급 : </p>
                    </div>
                    <div class="info connectInfo">
                        <h3>접속 정보</h3>
                        <p>IP : </p>
                        <p>OS : </p>
                        <p>browser : </p>
                    </div>
                    <div class="info grantLevel">
                        <h3>권한 레벨</h3>
                        <p>1 : asdf</p>
                        <p>2 : asdf</p>
                        <p>3 : super</p>
                    </div>
                </div>
                <div class="rightContainer">
                    <div class="info adminTable">
                        <h3>관리자 목록</h3>
                        <div>
                            <table>
                                <tr>
                                    <th>이름</th>
                                    <th>아이디</th>
                                    <th>이메일</th>
                                    <th>권한</th>
                                </tr>
                                <tr>
                                    <td>이름1</td>
                                    <td>아이디1</td>
                                    <td>이메일1</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <td>이름1</td>
                                    <td>아이디1</td>
                                    <td>이메일1</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <td>이름1</td>
                                    <td>아이디1</td>
                                    <td>이메일1</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <td>이름1</td>
                                    <td>아이디1</td>
                                    <td>이메일1</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <td>이름1</td>
                                    <td>아이디1</td>
                                    <td>이메일1</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <td>이름1</td>
                                    <td>아이디1</td>
                                    <td>이메일1</td>
                                    <td>1</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <footer class="footer" id="footer"></footer>
    </body>

</html>