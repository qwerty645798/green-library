
let navRoute = document.querySelectorAll('.useList li a');
let navRouteli = document.querySelectorAll('.useList li');
navRoute = Array.from(navRoute);
navRouteli = Array.from(navRouteli);

//navRoute.forEach((item, i) => {
//	item[i].onclick = () => {
//		item[i].classList.add("curPlace");
//		
//		navRoute.forEach((otherItem, index) => {
//			if(index!=i){
//				otherItem.classList.remove("curPlace");
//			}
//		});
//	}
//});



for(let i=0;i<navRoute.length();i++){
	navRoute[i].onclick = () => {
		navRouteli[i].classList.add('curPlace');
		
//		navRoute.forEach((navRoute, index) => {
//				if(index!=i){
//					navRoute.classList.remove('curPlace');
//				}
//			});
			
	}
	
};

/**
 * 
 */