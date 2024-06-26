
    
//됐고
function hideFirstTime(totalPage){
    document.querySelector('.goFirst_button').classList.add('hidden');
    document.querySelector('.goPrevious_button').classList.add('hidden');
    document.querySelector('.goNext_button').classList.add('hidden');
    document.querySelector('.goEnd_button').classList.add('hidden');
    if(totalPage>5){
		document.querySelector('.goNext_button').classList.remove('hidden');
        document.querySelector('.goEnd_button').classList.remove('hidden');
	}
}

function showPage(pageNumber, totalPage) {
    console.log("Total pages: " + totalPage);
    console.log("PageNumber: " + pageNumber);
    
    
    var totalGroups = Math.ceil(totalPage / 5);
    var currentGroup = Math.ceil(pageNumber / 5);
    
    console.log("totalGroups: " + totalGroups);
    console.log("currentGroup: " + currentGroup);
    
    // > >> 버튼 생성 조건
    //여기만 하면 됨
    if (currentGroup == totalGroups) {
        document.querySelector('.goNext_button').classList.add('hidden');
        document.querySelector('.goEnd_button').classList.add('hidden');
    }else if(totalGroups < 1){
		document.querySelector('.goNext_button').classList.add('hidden');
        document.querySelector('.goEnd_button').classList.add('hidden');
	}
     else {
        document.querySelector('.goNext_button').classList.remove('hidden');
        document.querySelector('.goEnd_button').classList.remove('hidden');
    }
    
    // << < 버튼 생성 조건
    // 됐음
    if(pageNumber <= 5){
        document.querySelector('.goFirst_button').classList.add('hidden');
        document.querySelector('.goPrevious_button').classList.add('hidden');
    } else {
        document.querySelector('.goFirst_button').classList.remove('hidden');
        document.querySelector('.goPrevious_button').classList.remove('hidden');
    }
    
    // 이 밑은 데이터들 출력 페이지
    // 됐음
    document.querySelectorAll('.page').forEach(function(page) {
        page.classList.add('hidden');
    });
    
    document.getElementById('page_' + pageNumber).classList.remove('hidden');
    
    // 다른 그룹들 hidden
    document.querySelectorAll('.pageGroup').forEach(function(group) {
        group.classList.add('hidden');
    });
    
    var k = Math.floor((pageNumber - 1) / 5) * 5 + 1;
	console.log("갸갸갸 : " + k);
	
    document.getElementById('pageGroup_' + k).classList.remove('hidden');
	
	
	//클릭한 버튼만 강조되는 함수/*lhm 추가 */
	let order = document.querySelectorAll('.orderBtn');/*lhm 추가 */
			order = Array.from(order);
		
	order[pageNumber-1].classList.add("curPage");
		
	order.forEach(function(outord, index){
		if(index!==pageNumber-1){
			outord.classList.remove("curPage");
		}
	});
	
}

//됐음
function goPrevious(totalPage) {
	var currentPage = parseInt(document.querySelector('.page:not(.hidden)').id.split('_')[1]);
	var previous = currentPage - 5;
	if(previous<1){
		previous = 1;
	}
    showPage(previous, totalPage);
}

//됐음
function goNext(totalPage) {
	var currentPage = parseInt(document.querySelector('.page:not(.hidden)').id.split('_')[1]);
    var next = currentPage + 5;
    if(next>totalPage){ 
		next = totalPage;
	}
    showPage(next, totalPage);
}