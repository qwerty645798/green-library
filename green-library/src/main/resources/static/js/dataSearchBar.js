

//검색창(select-text-button) 공용 js임

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
		var inputText = document.querySelector('input[type="text"]').value;
		var inputCategory = document.querySelector(' select').value;
		
		if(inputCategory=="인기도서"){
			window.location.href='popularBook';
		}else if(inputCategory=="신착도서"){
			window.location.href='initiativeBook';
		}else if(inputText==="" || inputText==="검색어를 입력하세요"){
			alert("검색어를 입력하세요");
		}else{
			
			var encodedInputText = encodeURIComponent(inputText);
			
			var url = "dataSearchResult?inputCategory="; 
			url+=inputCategory;
			url+="&inputText="+encodedInputText;
			
			window.location.href = url;
			
		}
	}