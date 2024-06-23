<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>공지사항</title>

<script src="js/notification.js"></script>
<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/notification.css">

<script src = "js/bottomButtonBox.js"></script>

</head>


<body>

<jsp:include page="index/header.jsp" />
<c:set var="itemsPerPage" value="${itemsPerPage}"/>
<c:set var="totalItems" value="${fn:length(announces)}" />
<%
    int totalItems = (Integer) pageContext.getAttribute("totalItems");
    int itemsPerPage = (Integer) pageContext.getAttribute("itemsPerPage");
    int totalPages = (totalItems + itemsPerPage - 1) / itemsPerPage;
    pageContext.setAttribute("totalPages", totalPages);
    
%>

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">공지사항</div> <div class="pageRoute">홈 > 도서관 소식 > 공지사항</div>
    </div>
</div>

<main>

<div class="first_container">
	<div class="text_box">
		<div class="text_box1">
			&nbsp;&nbsp; Total : ${announces.size()}개
		</div>
		<div class="text_box2">
			<form id="itemsPerPageForm" action="/notification" method="Get">
				<select id="itemsPerPageSelect" name="itemsPerPage" onchange="this.form.submit()" >
					<option value="10" ${itemsPerPage == 10? 'selected' : ''}>10건</option>
					<option value="20" ${itemsPerPage == 20? 'selected' : ''}>20건</option>
				</select>
				<input type="hidden" name="inputCategory" value="${inputCategory}">
                <input type="hidden" name="inputText" value="${inputText}">
			</form>
		</div>
		<div class="text_box3">
			<select>
				<option>제목과 본문</option><!-- 원래는'제목+내용'인데 안되어가지고 '전체'나 '제목과 본문'으로만 바꿨더니 됨.... -->
				<option>제목</option>
				<option>본문</option>
			</select>
		</div>
		<div class="text_box4">
			<input type="text" value="검색어를 입력하세요" onfocus="want_search(event)" onblur="zero_back(event)" onkeypress="checkEnter(event)">
<!--			<input type="button" value="검색" onclick="lets_search(event)">-->
			<img src="/images/searchBtn.png" onclick="lets_search(event)">
		</div>
	</div>
</div>




<div class = "second_container">
	<c:if test="${totalPages<1}">
		<table class="notice_table">
			<tr>
				<th>번호</th>
				<th>관리자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<tr>
				<td colspan="4" style="text-align:center;">공지사항이 없습니다</td>
			</tr>
		</table>
	</c:if>
	<c:forEach var="page" begin="1" end="${totalPages}">
	<div id="page_${page}" class="page ${page==1?'':'hidden'}">
		<table class="notice_table">
			<tr>
				<th>번호</th>
				<th>관리자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="announce" items="${announces}" varStatus="loop">
			<c:if test="${loop.index >= (page-1) * itemsPerPage && loop.index <page*itemsPerPage}">
				<tr onclick="goNoticeDetail(event)">
					<td class="num_table">${announce.announcementId}</td>
					<td class="name_table">${announce.writerId}</td>
					<td class="title_table">${announce.announcementTitle}</td>
					<td class="date_table">${announce.writeDate}</td>
				</tr>
			</c:if>
			</c:forEach>
		</table>
	</div>		
	</c:forEach>
</div>

<!-- dataSearchResult와 컨테이너 동일 -->
<div class="third_container">

	<div class="button_box">
		<input type="button" value="<<" class="goFirst_button " onclick="showPage(1, ${totalPages})">
		<input type="button" value="<" class="goPrevious_button " onclick="goPrevious(${totalPages})">
		
	  	<c:forEach var="groupStart" begin="1" step="5" end="${totalPages}">
		    <c:set var="groupEnd" value="${groupStart + 4}"/>
		    <c:if test="${groupEnd > totalPages}">
		        <c:set var="groupEnd" value="${totalPages}"/>
		    </c:if>
		    <div class="pageGroup " id="pageGroup_${groupStart}">
			    <c:forEach var="pageIndex" begin="${groupStart}" end="${groupEnd}">
			        <input type="button" value="${pageIndex}" onclick="showPage(${pageIndex}, ${totalPages})">
			    </c:forEach>
		    </div>
		</c:forEach>	
	    
		<input type="button" value=">" class="goNext_button " onclick="goNext(${totalPages})">
		<input type="button" value=">>" class="goEnd_button " onclick="showPage(${totalPages}, ${totalPages})">
	</div>

</div>



</main>

<script>
window.onload = function(){
	hideFirstTime(${totalPages});
    showPage(1, ${totalPages});
};
</script>

<jsp:include page="index/footer.jsp" />
<footer id="footer" class="footer"></footer>



</body>
</html>