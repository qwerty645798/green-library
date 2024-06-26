
let order = document.querySelectorAll('.orderBtn');/*lhm 추가 */

function showPage(pageNumber) {
    document.querySelectorAll('.page').forEach(function(page) {
        page.classList.add('hidden');
    });
    
    document.getElementById('page_' + pageNumber).classList.remove('hidden');
	
	/*lhm 추가 */
	
	
	order[pageNumber].classList.add("curPage");
}