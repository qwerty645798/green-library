<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>문의글 작성</title>

<link rel="stylesheet" type="text/css" href="/css/public/nav.css">
<link rel="stylesheet" type="text/css" href="/css/userInquiryCreate.css">

<script src="/js/userCreateInquiry.js"></script>

</head>


<body>

<jsp:include page="../index/header.jsp" />

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">문의하기</div> <div class="pageRoute">홈 > 마이페이지 > 문의하기</div>
    </div>
</div>

<main>

<form action="modifyInquiry" method="post" onsubmit="return validateForm()">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<input type="hidden" name="userId" value="${userId}">
<input type="hidden" name="inquiryId" value="${param.inquiryId }">
<div class="first_container">
	<div class="table_container">
		<table>
			<tr>
				<td colspan="2" class="con_table_top">
				<p class="great_p">&nbsp;*&nbsp;</p>
				표시 항목은 필수 입력 항목입니다.</td>
			</tr>
			<tr>
				<th><p class="great_p">*&nbsp;</p> 아이디</th>
				<td>${userId}</td>
			</tr>
			<tr>
				<th><p class="great_p">*&nbsp;</p> 제목</th>
				<td><input type="text" style="height:20px;width:95%;" name="inquiry_title"></td>
			</tr>
			<tr>
				<th><p class="great_p">*&nbsp;</p> 내용</th>
				<td><textarea rows="20" style="width:95%; resize:none;" name="contents"></textarea></td> 
			</tr>
		</table>
	</div>
</div>

<div class="second_container">
	<div class="button_container">
		<input type="button" value="취소하기" onclick="lets_cancel()">
		<input type="submit" value="등록하기">
	</div>
</div>
	
</form>


</main>

<jsp:include page="../index/footer.jsp" />


</body>
</html>