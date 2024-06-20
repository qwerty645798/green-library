
	function want_search(event){
		if(event.target.value==="검색어를 입력하세요"){
			event.target.value="";
			event.target.style.opacity="1";
			event.target.style.border="none";
		}
	}

	function zero_back(event){
		if(event.target.value===""){
			event.target.value="검색어를 입력하세요";
			event.target.style.opacity="0.5";
		}
	}

	function checkEnter(event) {
        if (event.key === 'Enter') {
            lets_search();
        }
    }
    
	function lets_search(){
		
		var inputText = document.querySelector('.text_box4 input[type="text"]').value;
		var inputCategory = document.querySelector('.text_box3 select').value;
		
		if(inputText==="" || inputText==="검색어를 입력하세요"){
			alert("검색어를 입력하세요");
		}else{
			var url = "notification?inputCategory="; 
			url+=inputCategory;
			url+="&inputText="+inputText;
			
			window.location.href = url;
			
		}
	}
	
	function goNoticeDetail(event){
		var url = "notificationDetail?announcementId=";
		var tr = event.target.closest('tr');
	    var announcementId = tr.querySelector('.num_table').textContent.trim();
	    url += announcementId;
		window.location.href = url;
	}