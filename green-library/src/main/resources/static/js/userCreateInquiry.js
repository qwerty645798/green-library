function validateForm() {
    var userIdInput = document.querySelector('input[name="user_id"]');
    var inquiryTitle = document.querySelector('input[name="inquiry_title"]');
    var contents = document.querySelector('textarea[name="contents"]');
    var hiddenUserId = document.querySelector('input[name="userId"]').value;

    if (userIdInput.value.trim() === '') {
        alert('아이디를 입력해주세요.');
        userIdInput.focus();
        return false;
    }
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
    if (userIdInput.value.trim() !== hiddenUserId.trim()) {
        alert('아이디가 일치하지 않습니다.');
        userIdInput.focus();
        return false;
    }
    return true;
}
	
	function lets_cancel(){
		if( confirm("취소하시겠습니까? 작성한 내용은 저장되지 않습니다.")){
			window.location.href="myWritten";			
		}
	}