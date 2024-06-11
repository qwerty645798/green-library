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

</style>

</head>

<body>

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

</body>
</html>