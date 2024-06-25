const pageHeight = document.documentElement.scrollHeight;
const windowHeight = document.documentElement.clientHeight;
const scrollPosition = document.documentElement.scrollTop;
const scrollBtn = document.querySelector('.scrollBtn');
let scrollPercentage = (scrollPosition*100)/(pageHeight-clientHeight);

function scrollUp(){
	if(scrollPercentage>=50){
		scrollBtn.style.bottom = 400 + "px";
		scrollBtn.style.display = "block";
		scrollBtn.onclick = () => {
			window.scrollTo(0,0);
		}
		
	}else if(scrollPercentage<50){
		scrollBtn.style.bottom = 0 + "px";
		scrollBtn.style.display = "none";
	}
	
}

window.onload = scrollUp();