const scrollBtn = document.querySelector('.scrollBtn');

const footerPage = document.querySelectorAll('.footPage')

//스크롤 위치 계산하는 함수. 변수만 넣으면 처음 한 번만 계산이 되어서 버튼이 새로고침을 해야만 나타난다.
function scrollPer(){
	let pageHeight = document.documentElement.scrollHeight;
	let windowHeight = document.documentElement.clientHeight;
	let scrollPosition = document.documentElement.scrollTop;
	let scrollPercentage = scrollPosition/(pageHeight-windowHeight)*100;
	return scrollPercentage;
}


//스크롤 버튼이 스크롤 위치에 따라 생겼다가 사라지게 한다.
function scrollUp(){
	if(scrollPer()>=50){
		scrollBtn.style.display = "block";
		scrollBtn.style.transition = "all 300ms ease-in-out";
		
	}else{
		scrollBtn.style.display = "none";
		scrollBtn.style.transition = "all 300ms ease-in-out";
	}
	
};

window.addEventListener("scroll", scrollUp);

//버튼을 누르면 올라가게 한다.
scrollBtn.onclick = () => {
			window.scrollTo({
			top: 0,
			left: 0,
			behavior: "smooth",
			});
		};
		



//footer 페이지 이동
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


