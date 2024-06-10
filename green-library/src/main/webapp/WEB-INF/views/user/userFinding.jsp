<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
.container{
	display:flex;
	justify-content:center;
}
nav{
	width:1520px; 
	height: 90px; 
	border: none; 
	display: flex; 
	justify-content: center; 
	background:   #ECD9BC;
}
main{
	padding-top:30px;
}
input{
	width:400px;
	height:40px;
	box-sizing:border-box;
	font-size:1.3em;
	border:none;
	outline:none;
	cursor:pointer;
}
input#id{
	background:#0D2E8C;
	color:white;
}
input#pw{
	background:#EBEBEB;
	color:black
}
</style>
<script>
	let idconut = 1 , pwcount = 0;
	function ID(){
		if(idconut == 0){
			idconut++;
			pwcount--;
			let span = document.getElementsByClassName("mainName");
			for(let i=0; i<span.length; i++){
				span[i].innerHTML = "아이디 찾기";
			}
			let id = document.getElementById("id");
			let pw = document.getElementById("pw");
			
			id.style.color = "white";
			id.style.background = "#0D2E8C";
			
			pw.style.color = "black";
			pw.style.background = "#EBEBEB";
			
			let choose = document.getElementById("choose");
			choose.innerHTML = "아이디 찾기 본인인증";
			
			let link = document.getElementById("link");
			link.href = "#id";
		}
	}
	function PW(){
		if(pwcount == 0){
			pwcount++;
			idconut--;
			let span = document.getElementsByClassName("mainName");
			for(let i=0; i<span.length; i++){
				span[i].innerHTML = "비밀번호 찾기";
			}
			let id = document.getElementById("id");
			let pw = document.getElementById("pw");
			
			pw.style.color = "white";
			pw.style.background = "#0D2E8C";
			
			id.style.color = "black";
			id.style.background = "#EBEBEB";
			
			let choose = document.getElementById("choose");
			choose.innerHTML = "비밀번호 찾기 본인인증";
			
			let link = document.getElementById("link");
			link.href = "#pw";
		}
	}
</script>
</head>
<body>
	<header id="header" class="header"></header>
	<nav class="roundbox">
		<div style="width: 50%; display: flex; justify-content: center; position: relative">
			<div style="font-size: 2.5em; margin-top: 10px;"><span class="mainName">아이디 찾기</span></div>
			<div style="float: right; position: absolute; right: 20px; margin-top: 60px;">
				<a href="index">홈</a>><span class="mainName">아이디 찾기</span>
			</div>
		</div>
	</nav>
	<main>
		<div class="container">
		<input type="button" onclick="ID()" value="아이디 찾기" id="id"><input type="button" onclick="PW()" value="비밀번호 찾기" id="pw">
		</div><br><br><br>
		<div class="container">
			<div style="display:inline-block; width:25px; height:25px"><img src="images/check-button.jpg" style="width:100%; height:auto;"></div><span style="font-size:1em; font-weight:600;" id="choose">아이디 찾기 본인인증</span>
		</div><Br><br>
		<div style="text-align:center; background:#F5F5F5; height:100px;">
			<a id="link" href="#id" style="height:100px; width:100px; cursor:pointer;"><img src="images/userfind.png" style="height:100%; width:auto;"></a>
		</div>
	</main>
	<footer id="footer" class="footer"></footer>
</body>
</html>