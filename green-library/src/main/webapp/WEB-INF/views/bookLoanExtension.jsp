<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src=""></script>
</head>


<body>

<header id="header" class="header"></header>

<main>

<label for="selectAllBook">
<input type="checkbox" id="selectAllBook" onclick="toggleAllChxbox(this)">
</label>
<input type="button" value="일괄 대출 연장" onclick="extendAllCheckedbox()">

<div>
    <div>
    	<label><input type="checkbox" class="book_chxbox" value="book1"></label>
    	<div>
    		<div>
    			<!-- 이미지 -->
    		</div>
    		<div>
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
    					<td colspan="4"><input type="button" value="대출 연장" onclick="extendEachBook('book1')"></td>
    					<!-- 기능 어떻게 넣을 지 몰라서 일단 버튼으로 생성해둠 -->
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
    <div>
    	<label><input type="checkbox" class="book_chxbox" value="book2"></label>
    	<div>
    		<div>
    			<!-- 이미지 -->
    		</div>
    		<div>
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
    					<td colspan="4"><input type="button" value="대출 연장"></td>
    					<!-- 기능 어떻게 넣을 지 몰라서 일단 버튼으로 생성해둠 -->
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
    <div>
    	<label><input type="checkbox" class="book_chxbox" value="book3" onclick="extendEachBook('book2')"></label>
    	<div>
    		<div>
    			<!-- 이미지 -->
    		</div>
    		<div>
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
    					<td colspan="4"><input type="button" value="대출 연장" onclick="extendEachBook('book3')"></td>
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