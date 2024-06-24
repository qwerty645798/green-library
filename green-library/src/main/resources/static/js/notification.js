
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
	    
	    /* hidden form 사용 방법
	    var form = document.createElement('form');
	    form.setAttribute('method', 'post');
	    form.setAttribute('action', '/incrementViewCount');
	    
	    var input = document.createElement('input');
	    input.setAttribute('type', 'hidden');
	    input.setAttribute('name', 'announcementId');
	    input.setAttribute('value', announcementId);
	    
	    form.appendChild(input);
	    document.body.appendChild(form);
	    form.submit();
	    */
	   
	    $.ajax({
        type: "POST",
	        url: "/incrementViewCount", // 컨트롤러에서 매핑한 URL
	        data: {
	            announcementId: announcementId
	        },
	        success: function(response) {
	            // 조회수 증가 성공 후 페이지 이동
	            window.location.href = url;
	        },
	        error: function(xhr, status, error) {
	            console.error("조회수 증가 처리 중 문제 발생 : " + error);
	        }
	    });
	    
	}
	
	
	
	
	
	