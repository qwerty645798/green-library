
function goWishBook(event){
	var url = "wishBook?wishId="
	var tr = event.currentTarget;
	var wishId = tr.querySelector('.wishlistId').textContent.trim();
	url += wishId;
	
	var complete = tr.querySelector('.complete').textContent.trim();
	
	if(complete == "심사대기"){
		complete = "W";
	}else if(complete =="심사탈락"){
		complete = "Y";
	}else if(complete == "심사통과"){
		complete = "N";
	}
	
	url += "&complete=" + complete;
	window.location.href = url;
}


function goInquiryDetail(event){
	var url = "userInquiryDetail?inquiryId=";
	var tr = event.currentTarget;
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