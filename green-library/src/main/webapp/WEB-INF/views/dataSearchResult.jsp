<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자료 검색 결과</title>


<script src="js/dataSearchBar.js"></script>
<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/dataSearchBar.css">
<link rel="stylesheet" type="text/css" href="css/dataSearchResult.css">

<style>
    .hidden {
        display: none;
    }
    
    .button_box{
		display: flex;
		width:1260px;
		margin: 0 auto;
		
		justify-content: center;
		align-items: center;
		margin-top: 20px;
		box-sizing: border-box;
	}
	
	.button_box input[type="button"]{
		background-color: #64B883;
		border-radius : 5px;
		border: none;
		width: 40px;
		margin-right: 10px;
		margin-left:10px;
	}
</style>




</head>

<body>

<header id="header" class="header"></header>


<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">통합 자료 검색</div> <div class="pageRoute">홈 > 자료 검색 > 통합 자료 검색</div>
    </div>
</div>

<main>

<div class="zero_container">
	<div class="sel_box">
		<div class="sel_box1">
			<select>
				<option>전체</option>
				<option>도서명</option>
				<option>저자</option>
				<option>출판사</option>
				<option>내용</option>
				<option>인기도서</option>
				<option>신착도서</option>
			</select>
		</div>
		<div class="sel_box2">
			<input type="text" value="검색어를 입력하세요" onfocus="want_search(event)" onblur="zero_back(event)" onkeypress="checkEnter(event)">
		</div>
		<div class="sel_box3">
			<input type="button" value="검색" onclick="lets_search()">
		</div>
	</div>
</div>

<div class="first_container">
	<div class="text_box">
		<div class="text_box1">
			&nbsp;'${inputCategory}:${inputText}'으로 검색한 결과 : ${items.size()}개 
		</div>
		<div class="text_box2">
			 <form id="itemsPerPageForm" action="/dataSearchResult" method="GET">
                <select id="itemsPerPageSelect" name="itemsPerPage" onchange="this.form.submit()">
                    <option value="5" ${itemsPerPage == 5 ? 'selected' : ''}>5개</option>
                    <option value="10" ${itemsPerPage == 10 ? 'selected' : ''}>10개</option>
                    <option value="20" ${itemsPerPage == 20 ? 'selected' : ''}>20개</option>
                </select>
                <input type="hidden" name="inputCategory" value="${inputCategory}">
                <input type="hidden" name="inputText" value="${inputText}">
            </form>
		</div>
	</div>
</div>

<c:set var="itemsPerPage" value="${itemsPerPage}"/>
<c:set var="totalItems" value="${fn:length(items)}" />
<c:set var="totalPages" value="${(totalItems + itemsPerPage - 1) / itemsPerPage}" />

<div class="second_container">
	<c:forEach var="page" begin="1" end="${totalPages}">
	<div id="page_${page}" class="page ${page==1?'':'hidden'}">
	
		<c:forEach var="item" items="${items}" varStatus="loop">
		<c:if test="${loop.index >= (page - 1) * itemsPerPage && loop.index < page * itemsPerPage}">
            <div class="bigDiv">
                <div class="book_container">
                    <div class="book_image">
                        <a href="bookDetail?bookId=${item.bookId}">
                            <img src="images/${item.img}">
                        </a>
                    </div>
                    <div class="book_table">
                        <table>
                            <tr>
                                <th>도서명</th>
                                <td>${item.title}</td>
                                <th>재고현황</th>
                                <td>${item.availability}</td>
                            </tr>
                            <tr>
                                <th>저자</th>
                                <td>${item.authorName}</td>
                                <th>위치</th>
                                <td>${item.location}</td>
                            </tr>
                            <tr>
                                <th>출판사</th>
                                <td colspan="3">${item.publisherName}</td>
                            </tr>
                            <tr>
                                <th>ISBN</th>
                                <td colspan="3">${item.isbn}</td>
                            </tr>
                            <tr>
                                <th>요약</th>
                                <td colspan="3">${item.summary}</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </c:if>
		</c:forEach>
		
	</div>
	</c:forEach>
	
</div>

<div class="third_container">
	<div class="button_box">
		<input type="button" value="<<" class="goFirst_button " onclick="showPage(1, ${totalPages})">
		<input type="button" value="<" class="goPrevious_button " onclick="goPrevious()">
		
		<c:forEach var="groupStart" begin="1" step="5" end="${totalPages}">
		    <c:set var="groupEnd" value="${groupStart + 4}"/>
		    <c:if test="${groupEnd > totalPages}">
		        <c:set var="groupEnd" value="${totalPages}"/>
		    </c:if>
		    <div class="page-group " id="pageGroup_${groupStart}">
			    <c:forEach var="pageIndex" begin="${groupStart}" end="${groupEnd}">
			        <input type="button" value="${pageIndex}" onclick="showPage(${pageIndex}, ${totalPages})">
			    </c:forEach>
		    </div>
		</c:forEach>
	    
		<input type="button" value=">" class="goNext_button " onclick="goNext()">
		<input type="button" value=">>" class="goEnd_button " onclick="showPage(${Math.floor(totalPages)}, ${totalPages})">
	</div>
</div>

</main>
<footer id="footer" class="footer"></footer>

<script>	
	window.onload = function(){
		console.log("total : ", ${totalPages});
        hideFirstTime(${totalPages});	
        showPage(1,${totalPages});
	};
	
	function hideFirstTime(totalPages){
        document.querySelector('.goFirst_button').classList.add('hidden');
        document.querySelector('.goPrevious_button').classList.add('hidden');
        document.querySelector('.goNext_button').classList.add('hidden');
        document.querySelector('.goEnd_button').classList.add('hidden');
    }
	
    function showPage(pageNumber, totalPage) {
    	// > >> 버튼 생성 조건
    	var totalGroups = Math.ceil(totalPage / 5);
    	if(Math.floor(totalPage)%5===0) totalGroups-=1;
        var currentGroup = Math.ceil(pageNumber / 5);
        if(Math.floor(totalPage)===0) currentGroup = 0;
    	
    	
    	if (currentGroup === totalGroups) {
    	    document.querySelector('.goNext_button').classList.add('hidden');
    	    document.querySelector('.goEnd_button').classList.add('hidden');
    	}else{
    		document.querySelector('.goNext_button').classList.remove('hidden');
        	document.querySelector('.goEnd_button').classList.remove('hidden');
    	} 
    	
    	// << < 버튼 생성 조건
    	if(pageNumber<=5){
     		document.querySelector('.goFirst_button').classList.add('hidden');
     		document.querySelector('.goPrevious_button').classList.add('hidden');
     	}else{
     		document.querySelector('.goFirst_button').classList.remove('hidden');
        	document.querySelector('.goPrevious_button').classList.remove('hidden');
     	} 
    	
    	
    	//이 밑은 데이터들 출력 페이지
        document.querySelectorAll('.page').forEach(function(page) {
            page.classList.add('hidden');
        });
        
        document.getElementById('page_' + pageNumber).classList.remove('hidden');
        
        //다른 그룹들 hidden
        document.querySelectorAll('.page-group').forEach(function(group) {
            group.classList.add('hidden');
        });	
        
        var currentGroupStart = Math.floor((pageNumber - 1) / 5) * 5 + 1;
        document.getElementById('pageGroup_' + currentGroupStart).classList.remove('hidden');
    }
    
    function goPrevious(){
        var currentPage = parseInt(document.querySelector('.page:not(.hidden)').id.split('_')[1]);
        var previousGroupStart = Math.max(currentPage - 5, 1);
        showPage(previousGroupStart, ${totalPages});
    }
   	
   	function goNext(){
        var currentPage = parseInt(document.querySelector('.page:not(.hidden)').id.split('_')[1]);
        var nextGroupStart = currentPage + 5;
        if (nextGroupStart <= ${totalPages}) {
            showPage(nextGroupStart, ${totalPages});
        }
    }
</script>



</body>
</html>

