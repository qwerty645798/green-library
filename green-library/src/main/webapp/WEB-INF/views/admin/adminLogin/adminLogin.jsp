<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="admin/css/public/reset.css">
        <link rel="stylesheet" type="text/css" href="admin/css/public/adminFooter.css">
        <link rel="stylesheet" type="text/css" href="admin/css/adminLogin.css">
        <title>Login</title>
    </head>

    <body>
        <main>
            <h1>admin page login</h1>
            <div>
                <div class="adminLogo"><img src="admin/assets/imgs/security.png" alt=""></div>
                <form class="loginContainer" id="loginForm" action="#" method="post">
                    <div>
                        <label for="adminID">ID</label>
                        <input type="text" name="adminID" id="adminID">
                    </div>
                    <div>
                        <label for="adminPASS">PASS</label>
                        <input type="password" name="adminPASS" id="adminPASS" autocomplete="current-password">
                    </div>
                    <div class="autoLoginBox">
                        <input type="checkbox" id="autoLogin" name="autoLogin">
                        <label for="autoLogin">자동 로그인</label>
                    </div>
                    <button type="submit">로그인</button>
                </form>
            </div>
        </main>
        <jsp:include page="../public/adminFooter.jsp"></jsp:include>
    </body>

</html>