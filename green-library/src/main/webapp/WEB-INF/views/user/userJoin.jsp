<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.comment{
	font-size:0.8em; margin:3px; auto;
}
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: underline;
	color: dodgerblue;
}

.roundbox {
	border-radius: 20px;
}

nav{
	width:1520px; 
	height: 90px; 
	border: none; 
	display: flex; 
	justify-content: center; 
	background:   #ECD9BC;
}
form > div.container{
	display:flex;
	justify-content:center;
	margin:10px 310px;
	width:900px;
	padding:0px
}
td{
	border:1px #E2E2E2 solid;
	height:30px;
}
td.text{
	width:160px;
	background:#f2f2f2;
	color:#777977;
	font-weight:600;
	vertical-align:top;
	padding:0;
}
td.text > div{
	margin-left:20px;
	margin-top:2px;
}
td.input{
	width:720px;
	padding-left:20px;
}
input{
	outline:none;
	height:25px;
	border:1px #B2B2B2 solid;
}
input::placeholder{
	color:#B3B3B3;
}
input.long{
	width:240px;
	height:30px;
	border:none;
}
input.middle{
	width:200px;
	
}
input.short{
	width:160px;
	text-align:center;
}
input.brief{
	width:60px;
	text-align:center;
}
</style>
</head>
<body>
	<header id="header" class="header"></header>
	<nav class="roundbox">
		<div style="width: 50%; display: flex; justify-content: center; position: relative">
			<div style="font-size: 2.5em; margin-top: 10px;">회원가입</div>
			<div style="float: right; position: absolute; right: 20px; margin-top: 60px;">
				<a href="index">홈</a>>회원가입
			</div>
		</div>
	</nav>
	<br>
	<br>
	<main>
	<form action="userJoin-perform" method="post">
		<div class="container">
		<table style="border-collapse:collapse;">
			<tr>
				<td class="text"><div>이름</div></td>
				<td class="input"><input type="text" name="#" placeholder="홍길동" class="long"></td>
			</tr>
			<tr>
				<td class="text"><div>생년월일</div></td>
				<td class="input"><input type="text" name="#" placeholder="2000-01-01" class="long"></td>
			</tr>
			<tr>
				<td class="text"><div>성별</div></td>
				<td class="input"><input type="text" name="#" placeholder="남" class="long"></td>
			</tr>
			<tr>
				<td class="text"><div>아이디</div></td>
				<td class="input">
					<input type="text" name="#" class="middle">
					<input type="button" value="아이디 중복 확인" style="color:white; background:#786C67; border:none; height:30px; cursor:pointer;">
					<br>
					<div class="comment">아이디는 영문 또는 숫자(개별 또는 혼용) 5자 이상 가능합니다. 아이디 영문은 모두 소문자입니다.</div>
				</td>
				
			</tr>
			<tr>
				<td class="text"><div>비밀번호</div></td>
				<td class="input"><input type="text" name="#" class="middle">
					<br>
					<div class="comment">비밀번호를 입력하세요(8~20자로 숫자, 영문소, 영문대, 특수문자 중 3가지 이상 조합)
					<br>
					<span style="font-size:1.1em; font-weight:600;">입력가능한 특수문자는 [ 사용가능 특수문자 : <span style="color:red;">!@#^*_</span>]입니다.
					<br>
					(지정된 특수문자 외는 입력이 불가능합니다.)</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="text"><div>비밀번호 확인</div></td>
				<td class="input"><input type="password" name="#" class="middle"></td>
			</tr>
			<tr>
				<td class="text"><div>휴대폰번호</div></td>
				<td class="input"><input type="text" name="#" class="brief"> - <input type="text" name="#" class="brief"> - <input type="text" name="#" class="brief"></td>
			</tr>
			<tr>
				<td class="text"><div>이메일</div></td>
				<td class="input"><input type="text" name="#" class="short"> @ <input type="text" name="#" class="short"></td>
			</tr>
			<tr>
				<td colspan="2" style="border:none;text-align:center;"><input type="submit" value="확인" style="color:white; background:#0D2E8C; width:120px; height:35px; margin-top:30px; cursor:pointer;" ></td>
			</tr>
		</table>
		
		</div>
	</form>
	</main>
	<footer id="footer" class="footer"></footer>
</body>
</html>