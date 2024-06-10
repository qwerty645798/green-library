
//jsp로 이동하면 bookLoanExtension.jsp로

function toggleAllChxbox(src){
	const chxboxes = document.querySelectorAll('.book_chxbox');
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