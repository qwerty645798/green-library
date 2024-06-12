let condition = "${condition}"
let table = document.getElementById("board");
let tr = document.createElement("tr");
let th1, th2, th3, th4, th5, th6, th7;
let caption = document.getElementById("caption");
if(condition == "rentHistory"){
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
