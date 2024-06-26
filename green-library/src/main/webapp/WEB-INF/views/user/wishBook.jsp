<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>신청도서</title>

<link rel="stylesheet" type="text/css" href="css/wishbook.css">
<link rel="stylesheet" type="text/css" href="css/public/nav.css">

</head>


<body>

<jsp:include page="index/header.jsp" />

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">도서 상세 정보</div> 
        <div class="pageRoute">홈 > 마이 페이지 > 신청 도서</div>
    </div>
</div>

<main>


<div class="bigDiv">
	<div class="book_container"><!-- 좌 이미지 우 테이블 -->
		<div class="book_image">
			<img src="images/${book.img}">
		</div>
		<div class="book_table">
			<table>
				<tr>
					<th>현재 상태</th>
					<td>&nbsp;&nbsp;<%-- ${complete} --%></td>
					<th>등록 번호</th>
					<td>&nbsp;&nbsp;${book.isbn}</td>
				</tr>
				<tr>
					<th>저자명</th>
					<td colspan="3">&nbsp;&nbsp;${book.authorName}</td>
				</tr>
				<tr>
					<th>서가 위치</th>
					<td colspan="3">&nbsp;&nbsp;${book.location}</td>
				</tr>
				<tr>
					<th>대출 상태</th>
					
					<td colspan="3">&nbsp;&nbsp;${book.availability}</td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="border:none;">
						<c:if test="${not empty sessionScope.SPRING_SECURITY_CONTEXT}">
						<c:choose>
							<c:when test="${!canReserve}">
								<input type="button" onclick="cantReservation()" value="대출 예약" class="reserve_button hidden" disabled>&nbsp;
							</c:when>
							<c:otherwise>
								<form action="reserveBook" method="post">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<input type="hidden" name="bookId" value="${book.bookId}">
									<input type="hidden" name="userId" value="${userId}">
									<input type="submit" value="대출 예약" class="reserve_button">
								</form>
							</c:otherwise>
						</c:choose>
						</c:if>
						
						<c:if test="${empty sessionScope.SPRING_SECURITY_CONTEXT}">
						<c:choose>
							<c:when test="${!canReserve}">
								<input type="button" onclick="cantReservation()" value="대출 예약" class="reserve_button hidden" disabled>&nbsp;
							</c:when>
							<c:otherwise>
								<input type="button" onclick="Reservation()" value="대출 예약" class="reserve_button">
							</c:otherwise>
						</c:choose>
						</c:if>
					</td>
				</tr>		
			</table>	
		</div>
	</div>
</div>



</main>

 <jsp:include page="index/footer.jsp" />





</body>
</html>