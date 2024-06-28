<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/adminLogin.css">
    <title>Login</title>
</head>

<body>
<main>
    <h1>admin page login</h1>
    <div>
        <div class="adminLogo"><img src="admin/assets/imgs/security.png" alt="security"></div>
        <form class="loginContainer" id="loginForm" action="/adminIndex" method="post">
<%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
            <div>
                <label for="adminID">ID</label>
                <input type="text" name="adminID" id="adminID" required>
            </div>
            <div>
                <label for="adminPASS">PASS</label>
                <input type="password" name="adminPASS" id="adminPASS" autocomplete="current-password" required>
            </div>
            <div class="autoLoginBox">
                <input type="checkbox" id="autoLogin" name="autoLogin">
                <label for="autoLogin">자동 로그인</label>
            </div>
            <button type="submit">로그인</button>
            <c:if test="${not empty error}">
                <p class="error">${error}</p>
            </c:if>
        </form>
    </div>
</main>
<jsp:include page="../public/adminFooter.jsp"></jsp:include>
</body>

</html>
