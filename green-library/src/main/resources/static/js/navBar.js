
let navRoute = document.querySelectorAll('.useList li a');
navRoute = Array.from(navRoute);

let navRouteli = document.querySelectorAll('.useList li');
navRouteli = Array.from(navRouteli);

//다른 페이지로 넘어가는 과정에서 class가 사라지는 것 같다.
//다른 페이지로 넘어가서도 이게 유지되도록 해야 한다.

for(let i=0;i<navRoute.length;i++){
	navRoute[i].onclick = () => {
		navRoute[i].classList.add("curPlace");
		sessionStorage.setItem('selectedNavItem', i);
		
		console.log(window.location.pathname);
		
		navRoute.forEach(function(noVisit, index){
			if(index!==i){
				noVisit.classList.remove("curPlace");
			}
		});
	}
}



//document.addEventListener('DOMContentLoaded', function() {
//    let selectedNavItemIndex = sessionStorage.getItem('selectedNavItem');
//    if (selectedNavItemIndex !== null) {
//        navRouteli[selectedNavItemIndex].classList.add('curPlace');
//    }
//});