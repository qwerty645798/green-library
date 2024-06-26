

//처음에 1에 클래스가 부여된 상태로 시작하자


function showPage(pageNumber) {
	
    document.querySelectorAll('.page').forEach(function(page) {
        page.classList.add('hidden');
    });
    
    document.getElementById('page_' + pageNumber).classList.remove('hidden');
	
	
	
	let order = document.querySelectorAll('.orderBtn');/*lhm 추가 */
		order = Array.from(order);
	
	/*lhm 추가 */
		
		order[pageNumber-1].classList.add("curPage");
			
			order.forEach(function(outord, index){
				if(index!==pageNumber-1){
					outord.classList.remove("curPage");
				}
			});
	
	
}
//맨 처음 버튼, 1번 버튼이 강조된 채로 시작한다.
window.onload = () =>{
	let order = document.querySelectorAll('.orderBtn');
	order[0].classList.add("curPage");
}

