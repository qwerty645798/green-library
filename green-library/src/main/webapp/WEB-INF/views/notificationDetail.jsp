<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>공지사항</title>

<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/notificationDetail.css">

</head>
<body>

<jsp:include page="index/header.jsp" />

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">공지사항</div> <div class="pageRoute">홈 > 도서관 소식 > 공지사항</div>
    </div>
</div>

<main>

<div class="first_container">
	<div class="notice_title">
		<h2>${announce.announceTitle}</h2>
	</div>
	<div class="table_box">
		<table class="notice_table">
			<tr>
				<th>작성일</th>
				<td>${announce.writeDate}</td>
				<th>조회수</th>
				<td>${announce.viewCount}</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3">${announce.fileName}</td><!-- 이건 나중에 유무 확인해서 텍스트 변환 기능? -->
			</tr>
			<tr>
				<td colspan="4" class="notice_detail">${announce.contents}</td>
			</tr>
		</table>
	</div>
</div>

<div class="second_container">
	<input type="button" value="목록" class="go_notification" onclick="window.location.href='notification'">
</div>




</main>

<jsp:include page="index/footer.jsp" />

</body>
</html>