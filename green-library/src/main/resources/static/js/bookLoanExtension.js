
function toggleAllChxbox(src){
	const chxboxes = document.querySelectorAll('.book_chxbox');
    chxboxes.forEach((checkbox) => {
        checkbox.checked = src.checked;
    });
	
}

function extendEachBook(book_sel, rentHistory, returnDate, more=false){
	
	const rentHistoryDate = new Date(rentHistory);
    const returnDateDate = new Date(returnDate);
	
	const timeDiff = returnDateDate - rentHistoryDate;
    const dayDiff = timeDiff / (1000 * 3600 * 24);
	
	if (dayDiff > 14) {
        alert("이미 한 번 연장하셨으므로 추가 연장이 불가능합니다.");
        return false;
    } else {
		if (!more) {
            alert("선택하신 책의 대출이 연장되었습니다.");
        }
        return true;
    }
}

function extendAllCheckedbox(){

	const chxboxes = document.querySelectorAll(".book_chxbox:checked");
	
	if(chxboxes.length==0){
		alert("책을 선택해 주십시오.");
		return;
	}
	
	for (const checkbox of chxboxes) {
        const bookContainer = checkbox.closest('.book_container');
        const rentHistory = bookContainer.getAttribute('data-rent-history');
        const returnDate = bookContainer.getAttribute('data-return-date');
        if (!extendEachBook(checkbox.value, rentHistory, returnDate, true)) {
			alert("대출 불가능한 책이 선택되어 있습니다.");
            return;
        }
    }

	alert("선택하신 책들의 대출이 연장되었습니다.");
}