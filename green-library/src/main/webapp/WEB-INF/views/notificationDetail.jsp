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
				<th>작성자</th>
				<td>익명</td>
				<th>작성일</th>
				<td>${announce.writeDate}</td>
				<th>조회수</th>
				<td>${announce.viewCount}</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="5">${announce.fileName}</td><!-- 이건 나중에 유무 확인해서 텍스트 변환 기능? -->
			</tr>
			<tr>
				<td colspan="6" class="notice_detail">${announce.contents}</td>
			</tr>
		</table>
	</div>
</div>

<div class="second_container">
	<input type="button" value="목록" class="go_notification" onclick="window.location.href='notification'">
</div>




</main>

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

<jsp:include page="index/footer.jsp" />

</body>
</html>