<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 글</title>

<script src="/js/myWritten.js"></script>
<link rel="stylesheet" type="text/css" href="/css/myWritten.css">
<link rel="stylesheet" type="text/css" href="/css/public/nav.css">

<script>
	let message = "${message}";
	if(message)
		alert(message);
</script>
</head>


<body>

<jsp:include page="../index/header.jsp" />

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">내가 쓴 글</div> <div class="pageRoute">홈 > 마이 페이지 > 내가 쓴 글</div>
    </div>
</div>

<jsp:include page="../public/navBarMypage.jsp"/>


<main>
	<div class="container">
		<table class="container_table">
			<tr>
				<td class="table_title">&nbsp;&nbsp;&nbsp;희망 도서 신청 내역</td>				
			</tr>
			<tr>
				<td>
					<table class="innerContainer">
						<tr>
							<th style="width: 12%;">번호</th>
							<th style="width: 12%;">아이디</th>
							<th style="width: 12%;">신청일</th>
							<th style="width: 52%;">도서명</th>
							<th style="width: 12%;">승인 상태</th>
						</tr>
						<c:if test="${wishLists == null || wishLists.isEmpty()}">
							<tr>
								<td colspan="5">신청하신 내역이 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach items="${wishLists}" var="wishList"> 
							<tr onclick="goWishBook(event)">
								<td class="wishlistId">${wishList.wishlistId}</td>
								<td>${wishList.userId}</td>
								<td>${wishList.wishDate}</td>
								<td>${wishList.wishTitle}</td>
								<td class="complete">${wishList.complete}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr>
				<td class="go_button"><a href="hopeBookApply">
				<input type="button" value="글쓰기" class="gogo_button"></a></td>
			</tr>
		</table>
	</div>
	
	
	
	<div class="container">
		<table class="container_table">
			<tr>
				<td class="table_title">&nbsp;&nbsp;&nbsp;문의 내역</td>				
			</tr>
			<tr>
				<td>
					<table class="innerContainer">
						<tr>
                            <th style="width: 12%;">번호</th>
							<th style="width: 12%;">아이디</th>
							<th style="width: 12%;">문의 날짜</th>
							<th style="width: 52%;">제목</th>
							<th style="width: 12%;">답변 상태</th>
						</tr>
						<c:if test="${inquiries == null || inquiries.isEmpty()}">
							<tr>
								<td colspan="5">신청하신 내역이 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach items="${inquiries}" var="inquiry"> 
							<tr onclick="goInquiryDetail(event)">
								<td class="inquiryId">${inquiry.inquiryId}</td>
								<td>${inquiry.userId}</td>
								<td>${inquiry.inquiryDate}</td>
								<td>${inquiry.inquiryTitle}</td>
								<td class="responserTF">${inquiry.responserTF}</td>
							</tr>
						</c:forEach>
					</table>	
				</td>
			</tr>
			<tr>
				<td class="go_button"><a href="userInquiryCreate">
				<input type="button" value="글쓰기" class="gogo_button"></a></td>
			</tr>
		</table>
	</div>

</main>

<jsp:include page="../index/footer.jsp" />

</body>
</html>