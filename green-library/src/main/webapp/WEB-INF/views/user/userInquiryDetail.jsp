<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/public/header.css" type="text/css" rel="stylesheet">
<link href="css/public/footer.css" type="text/css" rel="stylesheet">
<link href="css/public/nav.css" type="text/css" rel="stylesheet">
<link href="css/userInquiryDetail.css" type="text/css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../index/header.jsp" />
	
	<nav class="bannerBgr">
		<div class="Banner">
			<div class="pageTitle">나의 문의</div>
			<div class="pageRoute">홈 > 마이 페이지 > 나의 문의</div>
		</div>
	</nav>
	
	<h2>문의 세부내역</h2>
			<hr>
	
	<main class="container">
		<div class="main">
			
			<table>
				<caption>
				</caption>
				<tr>
					<td class="td1">제목</td>
					<td class="td2">${inquiryDetail.inquiryTitle}</td>
				</tr>
				<tr>
					<td class="td1">내용</td>
					<td class="td2">
						<div class="text">${inquiryDetail.inquiryContents }</div>
					</td>
				</tr>
				<c:if test="${param.responserTF == 'T'}">
				<tr>
					<td class="td1">답변</td>
					<td class="td2">
						<div class="text">${inquiryDetail.responseContents}</div>
					</td>
				</tr>
				</c:if>
			</table>
			
			<div class="writeBtn">
				<input type="button" value="수정하기">
				<input type="button" value="삭제하기">
				<a href="myWritten"><input type="button" value="목록으로"></a>
			</div>
			
			
		</div>
	</main>
	
	<jsp:include page="../index/footer.jsp" />
</body>
</html>