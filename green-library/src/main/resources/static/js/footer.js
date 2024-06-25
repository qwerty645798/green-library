let pageHeight = document.documentElement.scrollHeight;
let windowHeight = document.documentElement.clientHeight;
let scrollPosition = document.documentElement.scrollTop;
const scrollBtn = document.querySelector('.scrollBtn');
//let scrollPercentage = (scrollPosition*100)/(pageHeight-clientHeight);
let scrollPercentage = scrollPosition/(pageHeight-windowHeight);

const footerPage = document.querySelectorAll('.footPage')

function scrollUp(){
	if(scrollPercentage*100>=50){
		scrollBtn.style.bottom = 300 + "px";
		scrollBtn.style.display = "block";
		scrollBtn.style.transition = "300ms ease-in-out";
		scrollBtn.onclick = () => {
			window.scrollTo({
			top: 0,
			left: 0,
			behavior: "smooth",
			});
		}
		
	}else if(scrollPercentage*100<50){
		scrollBtn.style.bottom = 0 + "px";
		scrollBtn.style.display = "none";
		scrollBtn.style.transition = "300ms ease-in-out";
	}
	
}

window.onload = scrollUp();
//window.addEventListener("scroll", scrollUp);

function gotoFootpage(){
	footerPage[0].onclick = () =>{
		window.location.href = 'privacyPolicy';
	}
	footerPage[1].onclick = () =>{
		window.location.href = 'wayToCome';	
	}
	footerPage[2].onclick = () =>{
		window.location.href = 'wayToCome';	
	}
	footerPage[3].onclick = () =>{
		window.location.href = 'oftenAsk';	
	}
}

window.onload = gotoFootpage();