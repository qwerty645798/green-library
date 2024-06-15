
function toggleAllChxbox(src){
	const chxboxes = document.querySelectorAll('.book_chxbox');
    chxboxes.forEach((checkbox) => {
        checkbox.checked = src.checked;
    });
	
}

function extendEachBook(book_sel, more=false){
	//book_sel로 대출 연장 기능 작성
	if(!more){
		alert("선택하신 책의 대출이 연장되었습니다.");
	}
}

function extendAllCheckedbox(){

	const chxboxes = document.querySelectorAll(".book_chxbox:checked");
	
	if(chxboxes.length==0){
		alert("책을 선택해 주십시오.");
		return;
	}
	
	chxboxes.forEach((checkbox)=>{
		extendEachBook(checkbox.value, true);
	});

	alert("선택하신 책들의 대출이 연장되었습니다.");
}