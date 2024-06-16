<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>문의글 작성</title>

<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/userInquiryCreate.css">

<script>
	function important_check(){
		var userid = document.forms["userInquiryCreate"]["user_id"].value.trim();
		var title = document.forms["userInquiryCreate"]["inquiry_title"].value.trim();
		var contents = document.forms["userInquiryCreate"]["contents"].value.trim();
			
		if(userid==""){
			alert("아이디를 입력하세요.");
			return false;
		}else if(title==""){
			alert("제목을 입력하세요.");
			return false;
		}else if(contents==""){
			alert("내용을 입력하세요. ");
			return false;
		}
		
	
		return true;
	}
	
	function lets_cancel(){
		if( confirm("취소하시겠습니까? 작성한 내용은 저장되지 않습니다.")){
			window.location.href="myWritten";			
		}
	}
</script>

</head>


<body>


<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">문의하기</div> <div class="pageRoute">홈 > 마이페이지 > 문의하기</div>
    </div>
</div>

<header id="header" class="header"></header>


<!-- 로그인 없이 index에서 들어오려 하면 경고문(로그인이 필요합니다) -->
<!-- 요거는 헤더에서 처리하는게 맞는 듯? -->

<main>

<form name="userInquiryCreate" action= "inquiryTest" method="post" onsubmit="return important_check()">

<div class="first_container">
	<div class="table_container"><!-- 등록하기 버튼 - 아이디/제목/내용 입력 안하면 입력하라 경고문 --><!-- 아이디 일치 안하면 일치하지 않습니다 경고문? -->
		<table>
			<tr>
				<th class="con_table_top"></th>
				<td class="con_table_top"><p class="great_p">&nbsp;*&nbsp;</p>표시 항목은 필수 입력 항목입니다.</td>
			</tr>
			<tr>
				<th><p class="great_p">&nbsp;*&nbsp;</p> 아이디</th>
				<td><input type="text" size="10" style="height:20px;" name="user_id"></td>
			</tr>
			<tr>
				<th><p class="great_p">&nbsp;*&nbsp;</p> 제목</th>
				<td><input type="text" style="height:20px;width:95%;" name="inquiry_title"></td>
			</tr>
			<tr>
				<th><p class="great_p">&nbsp;*&nbsp;</p> 내용</th>
				<td><textarea rows="20" style="width:95%; resize:none;" name="contents"></textarea></td> 
			</tr>
		</table>
	</div>
</div>

<div class="second_container">
	<div class="button_container">
		<input type="button" value="취소하기" onclick="lets_cancel()">
		<input type="submit" value="등록하기">
		<!-- submit 대신에 button 넣고 주의문 한 번 띄우면서 거기서 submit하게 구현? -->
	</div>
</div>
	
</form>


</main>

<footer id="footer" class="footer"></footer>


</body>
</html>