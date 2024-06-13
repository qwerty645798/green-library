<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>문의글 작성</title>

<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/userCreateInquiry.css">

</head>


<body>


<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">문의하기</div> <div class="pageRoute">홈 > 마이페이지 > 문의하기</div>
    </div>
</div>

<header id="header" class="header"></header>

<main>

<div class="first_container">
	<div class="table_container">
		<table>
			<tr>
				<th class="con_table_top"></th>
				<td class="con_table_top">* 표시 항목은 필수 입력 항목입니다.</td>
			</tr>
			<tr>
				<th>&nbsp;&nbsp;* 이름</th>
				<td><input type="text" size="10" style="height:20px;"></td>
			</tr>
			<tr>
				<th>&nbsp;&nbsp;* 제목</th>
				<td><input type="text" style="height:20px;width:95%;"></td>
			</tr>
			<tr>
				<th>&nbsp;&nbsp;* 내용</th>
				<td><textarea rows="20" style="width:95%; resize:none !important;"></textarea></td> <!-- 이거 textarea로? -->
			</tr>
			<tr>
				<th>&nbsp;&nbsp;관련링크</th>
				<td><input type="text" style="height:20px; width:95%;"></td>
			</tr>
		</table>
	</div>
</div>

<div class="second_container">
	<div class="button_container">
		<a href="myWritten"><!-- 임시로 해놓은것 수정해도 됨 -->
			<input type="button" value="취소하기">
		</a>
		<input type="submit" value="등록하기">
		<!-- submit 대신에 button 넣고 주의문 한 번 띄우면서 거기서 submit하게 구현? -->
	</div>
</div>
	



</main>

<footer id="footer" class="footer"></footer>


</body>
</html>