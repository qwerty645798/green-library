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
<style>
.container{
	display:flex;
	justify-content:center;
}
.main{
	display:flex;
	flex-direction:column;
	align-items:center;
}
table{
	border-collapse:collapse;
	border-top: 1px solid #777777;
	border-bottom: 1px solid #777777;
}
td{
	box-sizing:border-box;
	padding:8px 0 8px 20px;
	border-bottom: 1px solid #DDDDDD;
}
.td1{
	width:200px;
	
	background:#F2F2F2;
	color:#646464;
	font-weight:600;
}
.td2{
	width:1060px;
}
.text{
	width:1040px;
	height:200px;
	padding:8px;
	border: 1px solid #e1e1e1;
}
h2{
	margin-top:100px;
	margin-bottom:50px;
}
</style>
</head>
<body>
	<jsp:include page="../index/header.jsp" />
	<nav class="bannerBgr">
		<div class="Banner">
			<div class="pageTitle">나의 문의</div>
			<div class="pageRoute">홈 > 나의 문의</div>
		</div>
	</nav>
	<main class="container">
		<div class="main">
			<h2>문의 세부내역</h2>
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
		</div>
	</main>
	<jsp:include page="../index/footer.jsp" />
</body>
</html>