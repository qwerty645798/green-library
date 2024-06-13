<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Green Library</title>
<link href="/css/public/header1.css" type="text/css" rel="stylesheet">
<style>
header {
	height: 146px;
	position: relative;
}
div#menuBarA {
	position: absolute;
	width: 1260px;
	height: 100px;
	top: 0;
}

div#menu {
	display : flex;
	justify-content: center;
	background:#16722a;
	position: absolute;
	width:100%;
	top: 70px;
}

div#menuBarB {
	display: flex;
	width:1260px;
}

div#logo {
	position: absolute;
	width: 100px;
	height: 50px;
	border: 1px black solid;
	top: 0;
	left: 0;
	text-align: center;
}

div#tag {
	position: absolute;
	right: 0;
	top: 0;
}

div#menuBarB>ul {
	flex: 1;
	font-size: 11pt;
	font-weight: bold;
	line-height: 3em;
	list-style-type: none;
	padding: 0;
	background-color: #16722a;
}

div#menuBarB>ul>li {
	text-align: center;
	background-color: #16722a;
}

div#menuBarB>ul>li.hidden {
	display: none;
}

div#menuBarB>ul>li.detail:hover {
	cursor: pointer;
	background: #EEEEEE;
}

.center {
	display: flex;
	justify-content: center;
}
</style>
</head>
<body>
	<header id="header" class="header">
		<div class="center">
			<div id="menuBarA">
				<div id="logo">로고</div>
				<div id="tag">로그인 / 회원가입</div>
			</div>
		</div>
		<div id="menu">
			<div id="menuBarB">
				<ul>
					<li class="menuTitle detail">도서관 소개</li>
					<li class="detail">도서관 비전</li>
					<li class="detail">사업 구조</li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
				<ul>
					<li class="menuTitle detail">도서관 이용</li>
					<li class="detail">오시는 길</li>
					<li class="detail">이용시간 안내</li>
					<li class="detail">자료이용 안내</li>
					<li class="detail">부대시설 소개</li>
					<li class="detail">희망도서 신청</li>
				</ul>
				<ul>
					<li class="menuTitle detail">자료 검색</li>
					<li class="detail">통합자료검색</li>
					<li class="detail">인기 도서</li>
					<li class="detail">신착 도서</li>
					<li></li>
					<li></li>
				</ul>
				<ul>
					<li class="menuTitle detail">도서관 소식</li>
					<li class="detail">공지사항</li>
					<li class="detail">문의사항</li>
					<li class="detail">자주 묻는 질문</li>
					<li class="detail">도서관 일정</li>
					<li></li>
				</ul>
				<ul>
					<li class="menuTitle detail">마이페이지</li>
					<li class="detail">회원정보수정</li>
					<li class="detail">대출 연장</li>
					<li class="detail">약관 재동의</li>
					<li class="detail">내가 쓴 글</li>
					<li></li>
				</ul>
			</div>
		</div>
	</header>
	<script>
		let li = document.getElementsByTagName("li");
		let menuDetail=[];
		for(let i=0; i<li.length; i++){
			if(li[i].innerHTML == ""){
				li[i].innerHTML = "&nbsp;"
			}
			
			if(!li[i].classList.contains('menuTitle')){
				menuDetail.push(li[i]);
				li[i].classList.add('hidden');
			}
		}
		
		let menuTitle = document.getElementsByClassName("menuTitle");
		let ul = document.getElementsByTagName("ul");
		
		for(let i=0; i<menuTitle.length; i++){
			menuTitle[i].addEventListener('click', () => {
				if(menuDetail[0].classList.contains('hidden')){
					for(let j=0; j<menuDetail.length; j++){
						menuDetail[j].classList.remove('hidden');
						
					}
				}else{
					for(let j=0; j<menuDetail.length; j++){
						menuDetail[j].classList.add('hidden');
					}
				}
			});
		}
	</script>
</body>
</html>