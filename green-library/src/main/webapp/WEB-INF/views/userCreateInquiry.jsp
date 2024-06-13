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
        <div class="pageTitle">희망도서 신청</div> <div class="pageRoute">홈 > 희망도서 신청</div>
    </div>
</div>

<header id="header" class="header"></header>

<main>

<div class="first_container">
	<div class="table_container">
		<table>
			<tr>
				<th></th>
				<td>* 표시 항목은 필수 입력 항목입니다.</td>
			</tr>
			<tr>
				<th>* 이름</th>
				<td><input type="text"></td>
			</tr>
			<tr>
				<th>* 제목</th>
				<td><input type="text"></td>
			</tr>
			<tr>
				<th>* 내용</th>
				<td><input type="text"></td> <!-- 이거 textarea로? -->
			</tr>
			<tr>
				<th>관련링크</th>
				<td><input type="text"></td>
			</tr>
		</table>
	</div>
</div>

<div class="second_container">
	<div class="button_container">
		<input type="button" value="취소하기">
		<input type="submit" value="등록하기">
		<!-- submit 대신에 button 넣고 주의문 한 번 띄우면서 거기서 submit하게 구현? -->
	</div>
</div>
	



</main>

<footer id="footer" class="footer"></footer>


</body>
</html>