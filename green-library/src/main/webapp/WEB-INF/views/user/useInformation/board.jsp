<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useInformationBoard</title>
<style>
table#board {
	width: 1250px;
	border-collapse: collapse;
	border-top: 2px #ADADAD solid;
	border-bottom: 2px #ADADAD solid;
	border-top: 2px #ADADAD solid;
}

table#board th {
	background: #F7F7F7;
}

table#board th, table#board td {
	height: 50px;
	border-bottom: 2px #D7D7D7 solid;
	text-align: center;
}
.hidden{
	display:hidden;
}
</style>
</head>
<body>
	<table id="board">
		<caption id="caption"
			style="margin-bottom: 40px; font-size: 2em; font-weight: bold;"></caption>
	</table>
	<script>
	let condition = "${param.condition}"
	let table = document.getElementById("board");
	let tr = document.createElement("tr");
	let th1, th2, th3, th4, th5, th6, th7;
	let caption = document.getElementById("caption");
	if(condition == "rentHistory" || condition == ""){
		th1 = "No";
		th2 = "등록번호";
		th3 = "신청도서정보";
		th4 = "대출일";
		th5 = "반납예정일";
		th6 = "상태";
		th7 = "대출연장";
		caption.innerHTML = "전체 대출 이력";
	}
	else if(condition == "borrow"){
		th1 = "No";
		th2 = "등록번호";
		th3 = "신청도서정보";
		th4 = "대출일";
		th5 = "반납일";
		th6 = "상태";
		th7 = "대출신청";
		caption.innerHTML = "대출중인 도서";
	}
	else if(condition == "reserve"){
		
		th1 = "No";
		th2 = "등록번호";
		th3 = "신청도서정보";
		th4 = "신청일";
		th5 = "반납예정일";
		th6 = "예약순위";
		th7 = "대출연장";
		caption.innerHTML = "신청한 예약도서";
	}
	else if(condition == "interest"){
		th1 = "No";
		th2 = "등록번호";
		th3 = "관심도서제목";
		th4 = "관심도서저자";
		th5 = "상태";
		th6 = "대출신청";
		th7 = "관심도서제거";
		caption.innerHTML = "관심도서 조회";
	}
	tr.innerHTML = `
	       <th>\${th1}</th>
	       <th>\${th2}</th>
	       <th>\${th3}</th>
	       <th>\${th4}</th>
	       <th>\${th5}</th>
	       <th>\${th6}</th>
	       <th>\${th7}</th>
	   `;
	table.appendChild(tr);
	
	</script>
</body>
</html>