<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대출 연장</title>
<!-- <script src="src/main/resources/static/js/bookLoanExtension_chxbox.js"></script> -->

<script>
function toggleAllChxbox(src){
	const chxboxes = document.querySelectorAll('.book-chxbox');
    chxboxes.forEach((checkbox) => {
        checkbox.checked = src.checked;
    });
	
}

function extendEachBook(book_sel){
	//book_sel로 대출 연장 기능 작성
	alert("선택하신 책의 대출이 연장되었습니다.");
}

function extendAllCheckedbox(){

	const chxboxes = document.querySelectorAll(".book_chxbox:checked");
	chxboxes.forEach((checkbox)=>{
		extendEachBook(checkbox.value);
	});

	alert("선택하신 책들의 대출이 연장되었습니다.");
}
</script>

<style>

input[type="checkbox"] {
    transform: scale(1.3);  
}

.sel_All{
    display: flex;
    width: 1600px;
    margin: 0 auto;
}

.bigbigDiv{
    margin-top : 10px;
}

.bigDiv{
    display: flex;
    width: 1600px;
    height: 320px;
    margin: 0 auto;
}

.book_container{
	display: flex;
	width: 1600px;
    height: 300px;
	margin: 0 auto;
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

</style>

</head>


<body>

<header id="header" class="header"></header>

<main><!-- 총 몇권 대출 가능인지 확인 후 개수 추가(현재3개) -->

<div class="sel_All">
    <label for="selectAllBook">
        <input type="checkbox" id="selectAllBook" onclick="toggleAllChxbox(this)">
    </label>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="일괄 대출 연장" onclick="extendAllCheckedbox()">
</div>

<div class="bigbigDiv">
    <div class="bigDiv">
    	<label><input type="checkbox" class="book_chxbox" value="book1"></label>
    	<div class="book_container">
    		<div class="book_image">
    			<!-- 이미지 -->
    		</div>
    		<div class="book_table">
    			<table>
    				<tr>
    					<th>대출도서명</th><td></td><th>등록 번호</th><td></td>
    				</tr>
    				<tr>
    					<th>저자명</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>대출일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>반납일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<td colspan="4" align="right">
                            <input type="button" value="대출 연장" onclick="extendEachBook('book1')">&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
    					<!-- 기능 어떻게 넣을 지 몰라서 일단 버튼으로 생성해둠 -->
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
    <div class="bigDiv">
    	<label><input type="checkbox" class="book_chxbox" value="book2"></label>
    	<div class="book_container">
    		<div class="book_image">
    			<!-- 이미지 -->
    		</div>
    		<div class="book_table">
    			<table>
    				<tr>
    					<th>대출도서명</th><td></td><th>등록 번호</th><td></td>
    				</tr>
    				<tr>
    					<th>저자명</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>대출일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>반납일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<td colspan="4" align="right">
                            <input type="button" value="대출 연장" onclick="extendEachBook('book2')">&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
    					<!-- 기능 어떻게 넣을 지 몰라서 일단 버튼으로 생성해둠 -->
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
    <div class="bigDiv">
    	<label><input type="checkbox" class="book_chxbox" value="book3"></label>
    	<div class="book_container">
    		<div class="book_image">
    			<!-- 이미지 -->
    		</div>
    		<div class="book_table">
    			<table>
    				<tr>
    					<th>대출도서명</th><td></td><th>등록 번호</th><td></td>
    				</tr>
    				<tr>
    					<th>저자명</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>대출일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<th>반납일자</th>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<td colspan="4" align="right">
                            <input type="button" value="대출 연장" onclick="extendEachBook('book3')">&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
    					<!-- 기능 어떻게 넣을 지 몰라서 일단 버튼으로 생성해둠 -->
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
</div>
</main>

<footer id="footer" class="footer"></footer>

</body>
</html>