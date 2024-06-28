<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>registration</title>
    <link rel="stylesheet" type="text/css" href="/admin/css/public/reset.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminHeader.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/adminFooter.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/public/style.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/bookWrite.css">
</head>

<body>
<jsp:include page="../../public/adminHeader.jsp"></jsp:include>
<main>
    <section class="banner">
        <h3>도서 등록</h3>
        <p>home > book > registration</p>
    </section>
    <section class="viewContainer">
        <table class="bookInfo">
            <tr>
                <th>번호</th>
                <td>1</td>
                <th>십진분류<span>*</span></th>
                <td><input type="text" name="" id=""></td>
            </tr>
            <tr>
                <th>제목<span>*</span></th>
                <td><input type="text" name="" id=""></td>
                <th>저자<span>*</span></th>
                <td><input type="text" name="" id=""></td>
            </tr>
            <tr>
                <th>출판사<span>*</span></th>
                <td><input type="text" name="" id=""></td>
                <th>발간일자<span>*</span></th>
                <td><input type="text" name="" id=""></td>
            </tr>
            <tr>
                <th>ISBN<span>*</span></th>
                <td><input type="text" name="" id=""></td>
                <th>위치<span>*</span></th>
                <td><input type="text" name="" id=""></td>
            </tr>
            <tr>
                <th>이미지</th>
                <td><input type="file" name="" id="">
                    <div id="previewImg" class="previewImg">이미징</div>
                </td>
                <th>내용<span>*</span></th>
                <td><textarea name="" id=""></textarea></td>
            </tr>
        </table>
        <div class="btnWrap">
            <input class="modiBtn" type="button" value="목록">
            <input class="deleteBtn" type="button" value="등록">
        </div>
    </section>
</main>
<jsp:include page="../../public/adminFooter.jsp"></jsp:include>

</body>

</html>