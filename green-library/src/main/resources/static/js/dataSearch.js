
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

	function lets_search(event){
		var inputText = document.querySelector('.sel_box2 input[type="text"]').value;
		if(inputText==="" || inputText==="검색어를 입력하세요"){
			alert("검색어를 입력하세요");
		}
	}