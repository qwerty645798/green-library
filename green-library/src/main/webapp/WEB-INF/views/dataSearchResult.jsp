<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자료 검색 결과</title>

<script>

function want_search(event){
	if(event.target.value==="검색어를 입력하세요"){
		event.target.value="";
		event.target.opacity="1";
		event.target.border="none";
	}
}

function zero_back(event){
	if(event.target.value===""){
		event.target.value="검색어를 입력하세요";
		event.target.opacity="0.5";
	}
}

function lets_search(event){
	var inputText = document.querySelector('.sel_box2 input[type="text"]').value;
	if(inputText==="" || inputText==="검색어를 입력하세요"){
		alert("검색어를 입력하세요");
	}
}

</script>

<style>

.zero_container{
	display: flex; 
	width:1600px;
	border: 1px solid red;

	margin: 0 auto;
	padding:10px;
	box-sizing: border-box;/*패딩 마진이 요소의 너비,길이에 포함되게*/
}

.sel_box{
	display: flex;
	border: 1px solid brown;
	height: 30px;
	width: 700px;
	margin: auto;
}

.sel_box1, .sel_box2, .sel_box3 {
	display: flex;
	height:30px;
}
.sel_box1, .sel_box3{
	width:150px;
}
.sel_box2{
	width:400px;
}

.sel_box2 input[type="text"]{
	border: none;
	outline: none;
	opacity: 0.5;
}
.sel_box1 select{
	margin:0 auto;
	width:140px;
}
.sel_box3 input[type="button"]{
	margin:0 auto;
	width: 140px;
}

.first_container{
	display: flex; 
	width:1600px;
	border: 1px solid red;

	margin: 0 auto;
	padding:10px;
	box-sizing: border-box;
}

.text_box{
	display: flex;
	border: 1px solid brown;
	height: 30px;
	width: 700px;
	margin: auto;
}

.text_box1, .text_box2 {
	display: flex;
	height:30px;
}
.text_box1{
	width:550px;
	align-items: center; /* 텍스트를 수직 가운데 */
}
.text_box2{
	width:150px;
}
.text_box2 input[type="button"]{
	margin:0 auto;
	width: 140px;
}

.second_container{
	display: flex; 
	width:1600px;
	border: 1px solid red;

	margin: 0 auto;
	padding:10px;
	box-sizing: border-box;

	flex-direction: column;
}

.book_container{
	display: flex;
	width: 1600px;
    height: 300px;
	margin: 0 auto;
	margin-top:20px;
}

.book_image{
    margin-left: 10px;
	width: 200px;
    border: 2px solid red;
}

.book_table{
	width: 1400px;
}

table{
	border-collapse: collapse;
	width: 1200px;
    height: 300px;
    margin: 0 auto;
}

td{
    width: 300px;
}

th {
    width: 300px;
	text-align: center;
}

td, th{
    border: 1px solid gray;
}

.third_container{
	display: flex;
	width: 1600px;
	margin: 0 auto;
	border: 1px solid red;

	padding:10px;
	box-sizing: border-box;
}

.button_box{
	display: flex;
	border: 1px solid brown;
	height: 50px;
	width: 700px;
	margin: auto;

	align-items: center;
	justify-content: center;
}

.button_box1, .button_box2, .button_box4, .button_box5{
	height: 30px;
	border : 1px solid yellowgreen;
}

.button_box3{
	display: flex;
	height: 30px;
	border : 1px solid yellowgreen;
}

.button_inbox{
	margin-right: 2px;
	margin-left: 2px;
}

.button_box1 input, .button_box2 input, .button_box4 input, .button_box5 input{
	margin-right: 2px;
	margin-left: 2px;
}

</style>

<link rel="stylesheet" type="text/css" href="css/nav_hyun.css">

</head>

<body>

<header id="header" class="header"></header>

<nav class="navnav">
	<div class="hyun">
		<div class="big_name">통합 자료 검색</div> 
		<div class="small_name">홈 > 자료 검색 > 통합 자료 검색</div>
	</div>
</nav>

<main>

<div class="zero_container">
	<div class="sel_box">
		<div class="sel_box1">
			<select>
				<option>인기도서</option>
				<option>신착도서</option>
				<option>소설</option>
				<option>에세이/시/희곡</option>
				<option>인문</option>
				<option>자기계발</option>
				<option>경제/경영</option>
			</select>
		</div>
		<div class="sel_box2">
			<input type="text" value="검색어를 입력하세요" onfocus="want_search(event)" onblur="zero_back(event)">
		</div>
		<div class="sel_box3">
			<input type="button" value="검색" onclick="lets_search(event)">
		</div>
	</div>
</div>

<div class="first_container">
	<div class="text_box">
		<div class="text_box1">
			&nbsp;"select된 값" 으로 검색 된 결과 : "??"개 <!-- 이건 나중에 데이터 할 때 구현-->
		</div>
		<div class="text_box2">
			<input type="button" value="??개씩 보기">
		</div>
	</div>
</div>

<div class="second_container">
	
	<div class="book_container">
		<div class="book_image">
			<!-- 이미지 -->
		</div>
		<div class="book_table">
			<table>
				<tr>
					<th>도서명</th>
					<td></td>
					<th>재고현황</th>
					<td></td>
				</tr>
				<tr>
					<th>저자</th>
					<td></td>
					<th>위치</th>
					<td></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>ISBN</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">모시깽이</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="book_container">
		<div class="book_image">
			<!-- 이미지 -->
		</div>
		<div class="book_table">
			<table>
				<tr>
					<th>도서명</th>
					<td></td>
					<th>재고현황</th>
					<td></td>
				</tr>
				<tr>
					<th>저자</th>
					<td></td>
					<th>위치</th>
					<td></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>ISBN</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">모시깽이</td>
				</tr>
			</table>
		</div>
	</div>

</div>

<div class="third_container">
	<div class="button_box">
		<div class="button_box1">
			<input type="button" value="<<">
		</div>
		<div class="button_box2">
			<input type="button" value="<">
		</div>
		<div class="button_box3">
			<div class="button_inbox">
				<input type="button" value="1">
			</div>
			<div class="button_inbox">
				<input type="button" value="2">
			</div>
			<div class="button_inbox">
				<input type="button" value="3">
			</div>
			<div class="button_inbox">
				<input type="button" value="4">
			</div>
			<div class="button_inbox">
				<input type="button" value="5">
			</div>
		</div>
		<div class="button_box4">
			<input type="button" value=">">
		</div>
		<div class="button_box5">
			<input type="button" value=">>">
		</div>
	</div>
</div>

</main>
<footer id="footer" class="footer"></footer>

</body>
</html>