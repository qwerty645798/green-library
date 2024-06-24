


function goInquiryDetail(event){
	var url = "userInquiryDetail?inquiryId=";
	var tr = event.target.closest('tr');
    var inquiryId = tr.querySelector('.inquiryId').textContent.trim();
    url += inquiryId;
	window.location.href = url;
}