<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%-- Fetching request parameters and user agent details --%>
<%
    String ipAddress = request.getRemoteAddr();
    String userAgent = request.getHeader("User-Agent");
    String os = System.getProperty("os.name");
    String browser = "Unknown Browser";

    if (userAgent != null) {
        if (userAgent.contains("Chrome")) {
            browser = "Chrome";
        } else if (userAgent.contains("Firefox")) {
            browser = "Firefox";
        } else if (userAgent.contains("Safari") && !userAgent.contains("Chrome")) {
            browser = "Safari";
        } else if (userAgent.contains("Opera") || userAgent.contains("OPR")) {
            browser = "Opera";
        } else if (userAgent.contains("Edge")) {
            browser = "Edge";
        } else if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            browser = "Internet Explorer";
        }
    }
%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 정보</title>
    <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/adminInfo.css">
</head>

<body>
<jsp:include page="../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>내 정보</h3>
        <p>home > Info</p>
    </section>
    <section class="container">
        <div class="leftContainer">
            <div class="info baseInfo">
                <h3>내 계정</h3>
                <p>이름 : ${my.adminName}</p>
                <p>ID : ${my.adminId}</p>
                <p>PASS : ${my.adminPass}</p>
                <p>권한 등급 : ${my.grantRank}</p>
            </div>
            <div class="info connectInfo">
                <h3>접속 정보</h3>
                <p>IP : <%= ipAddress %></p>
                <p>OS : <%= os %></p>
                <p>Browser : <%= browser %></p>
            </div>
            <div class="info grantLevel">
                <h3>권한 레벨</h3>
                <p>1 : book manage</p>
                <p>2 : board manage</p>
                <p>3 : sys 계정</p>
            </div>
        </div>
        <div class="rightContainer">
            <div class="info adminTable">
                <h3>관리자 목록</h3>
                <div>
                    <table>
                        <thead>
                        <tr>
                            <th>이름</th>
                            <th>아이디</th>
                            <th>이메일</th>
                            <th>권한</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="admin" items="${admins}">
                            <tr>
                                <td>${admin.adminName}</td>
                                <td>${admin.adminId}</td>
                                <td>${admin.adminEmail}</td>
                                <td>${admin.grantRank}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</main>
<jsp:include page="../public/adminFooter.jsp"></jsp:include>
</body>

</html>
