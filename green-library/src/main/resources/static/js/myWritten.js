


function goInquiryDetail(event){
	var url = "userInquiryDetail?inquiryId=";
	var tr = event.target.closest('tr');
    var inquiryId = tr.querySelector('.inquiryId').textContent.trim();
    url += inquiryId;
    var responserTF = tr.querySelector('.responserTF').textContent.trim();
    if(responserTF == "답변없음")
    	responserTF = "F";
    else 
    	responserTF = "T";
    url += "&responserTF=" + responserTF;
	window.location.href = url;
}