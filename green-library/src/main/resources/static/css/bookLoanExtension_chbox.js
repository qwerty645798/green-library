

function toggleAllChxbox(source){
	
	
}

function extendEachBook(value){
	//대출 연장
	alert(value+ " 이 책 대출 연장됨");
}

function extendAllCheckedbox(){

	const checkboxes = document.querySelectorAll(".book_chxbox:checked");
	checkboxes.forEach((checkbox)=>{extendEachBook();
		
	}	);
	
}