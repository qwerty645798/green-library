const usetime = document.getElementById('quick1');
const booklong = document.getElementById('quick2');
const hopebook = document.getElementById('quick3');
const help = document.getElementById('quick4');
const schedule = document.getElementById('quick5');
const notiQuick = document.querySelector('.gotoNotify');

const newbooks = document.querySelector('.newbook');
const popbooks = document.querySelector('.popbook');

const window1 = document.querySelector('.window');
const window2 = document.querySelector('.window2');

const backBtn = document.querySelector('.backBtn');
const goBtn = document.querySelector('.goBtn');
const backBtn2 = document.querySelector('.backBtn2');
const goBtn2 = document.querySelector('.goBtn2');
//버튼들도 클래스가 옮겨가게 해보자. 

const tab = document.querySelectorAll('.bookTab li');
const swipe = document.querySelector('.bookSwipe');
const swipe2 = document.querySelector('.bookSwipe2');

const bookQuick = document.querySelector('.tabCon2 img');





//바로가기 이동 함수
function quickPage(){
	usetime.onclick = () => {window.location.href='placeUsetime';}
	booklong.onclick = () => {window.location.href='bookLoanExtension';}
	hopebook.onclick = () => {window.location.href='hopeBookApply';}
	help.onclick = () => {window.location.href='oftenAsk';}
	schedule.onclick = () => {window.location.href='schedule';}
	notiQuick.onclick = () => {window.location.href='notification';}
}

addLoadEvent(quickPage);
/*window.onload=quickPage();*/

//슬라이드 함수
function slide(){
	
	let curIdx = 0;
	let newWid = 1260;


		if(curIdx===0){
			goBtn.onclick = () => {
				newbooks.style.left = -newWid + 'px';
				newbooks.style.transition = '200ms ease-in-out';
               
                curIdx+=1;
                
			}
			backBtn.onclick = () => {
				newbooks.style.left = 0 + 'px';
			}
		}
	}
function slide2(){
	
	let curIdx = 0;
	let newWid = 1260;


		if(curIdx===0){
			goBtn2.onclick = () => {
				popbooks.style.left = -newWid + 'px';
				popbooks.style.transition = '200ms ease-in-out';
               
                curIdx+=1;
                
			}
			backBtn2.onclick = () => {
				popbooks.style.left = 0 + 'px';
			}
		}
	}


addLoadEvent(slide);
addLoadEvent(slide2);
/*window.onload = slide();
window.onload = slide2();*/




// 여기서부터는 탭 함수



function booktab(){
	if(tab[0].classList.contains("here")){
		bookQuick.onclick = () => {
			window.location.href='initiativeBook';
		}
	}
	tab[0].onclick = () => {
		tab[0].classList.add("here");
		tab[1].classList.remove("here");
		swipe.style.display = "flex";
		swipe2.style.display = "none";
		
	}
	tab[1].onclick = () => {
		tab[0].classList.remove("here");
		tab[1].classList.add("here");
		swipe.style.display = "none";
		swipe2.style.display = "flex";
		bookQuick.onclick = () => {
			window.location.href='popularBook';
		}
	}
}


addLoadEvent(booktab);

/*window.onload = booktab();*/




