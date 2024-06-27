function validateForm() {
    var inquiryTitle = document.querySelector('input[name="inquiry_title"]');
    var contents = document.querySelector('textarea[name="contents"]');

   
    if (inquiryTitle.value.trim() === '') {
        alert('제목을 입력해주세요.');
        inquiryTitle.focus();
        return false;
    }
    if (contents.value.trim() === '') {
        alert('내용을 입력해주세요.');
        contents.focus();
        return false;
    }
    return true;
}
	
	function lets_cancel(){
		if( confirm("취소하시겠습니까? 작성한 내용은 저장되지 않습니다.")){
			window.location.href="myWritten";			
		}
	}