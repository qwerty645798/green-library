const usetime = document.getElementById('quick1');
const booklong = document.getElementById('quick2');
const hopebook = document.getElementById('quick3');
const help = document.getElementById('quick4');
const schedule = document.getElementById('quick5');

const newbooks = document.querySelector('.newbook');
const popbooks = document.querySelector('.popbook');

const window1 = document.querySelector('.window');
const window2 = document.querySelector('.window2');

const backBtn = document.querySelector('.backBtn');
const goBtn = document.querySelector('.goBtn');
const backBtn2 = document.querySelector('.backBtn2');
const goBtn2 = document.querySelector('.goBtn2');
//버튼들도 클래스가 옮겨가게 해보자. 



//const clsname = "on";

//let curlef = parseInt(newbooks.style.left,10)||0;
//let brect = newbooks.getBoundingClientRect();

//바로가기 이동 함수
function quickPage(){
	usetime.onclick = () => {window.location.href}
	booklong.onclick = () => {window.location.href}
	hopebook.onclick = () => {window.location.href}
	help.onclick = () => {window.location.href}
	schedule.onclick = () => {window.location.href}
}

//슬라이드 함수
function slide(){
	
	let curIdx = 0;
	let newWid = 1260;

//		goBtn.onclick = () => {
//			if(curlef!=0){
//				newbooks.style.left = (curlef-1260) + 'px';
//				newbooks.style.transition = '200ms ease-in-out';
//			}
//			
//		}
//		backBtn.onclick = () => {
//			newbooks.style.left = (brect+1260) + 'px';
//			newbooks.style.transition = '200ms ease-in-out';
//		}
		if(curIdx===0){
			goBtn.onclick = () => {
				newbooks.style.left = -newWid + 'px';
				newbooks.style.transition = '200ms ease-in-out';
               
                curIdx+=1;
                
			}
			backBtn.onclick = () => {
				newbooks.style.left = 0 + 'px';
			}
		}else if(curIdx===1){
			goBtn.onclick = () => {
                alert("oneclick");
				newbooks.style.left = -newWid*2 + 'px';
				newbooks.style.transition = '200ms ease-in-out';
               
                // curIdx++;
			}
			backBtn.onclick = () => {
				newbooks.style.left = curIdx*newWid + 'px';
				newbooks.style.transition = '200ms ease-in-out';
			}
		}else if(curIdx===2){
			goBtn.onclick = () => {
				newbooks.style.left = -curIdx*newWid + 'px';
			}
			backBtn.onclick = () => {
				newbooks.style.left = curIdx*newWid + 'px';
				newbooks.style.transition = '200ms ease-in-out';
			}
		}
}
function slide2(){
	
	let curIdx = 0;
	let newWid = 1260;

//		goBtn.onclick = () => {
//			if(curlef!=0){
//				newbooks.style.left = (curlef-1260) + 'px';
//				newbooks.style.transition = '200ms ease-in-out';
//			}
//			
//		}
//		backBtn.onclick = () => {
//			newbooks.style.left = (brect+1260) + 'px';
//			newbooks.style.transition = '200ms ease-in-out';
//		}
		if(curIdx===0){
			goBtn2.onclick = () => {
				popbooks.style.left = -newWid + 'px';
				popbooks.style.transition = '200ms ease-in-out';
               
                curIdx+=1;
                
			}
			backBtn2.onclick = () => {
				popbooks.style.left = 0 + 'px';
			}
		}else if(curIdx===1){
			goBtn2.onclick = () => {
                alert("oneclick");
				popbooks.style.left = -newWid*2 + 'px';
				popbooks.style.transition = '200ms ease-in-out';
               
                // curIdx++;
			}
			backBtn2.onclick = () => {
				popbooks.style.left = curIdx*newWid + 'px';
				popbooks.style.transition = '200ms ease-in-out';
			}
		}else if(curIdx===2){
			goBtn2.onclick = () => {
				popbooks.style.left = -curIdx*newWid + 'px';
			}
			backBtn2.onclick = () => {
				popbooks.style.left = curIdx*newWid + 'px';
				popbooks.style.transition = '200ms ease-in-out';
			}
		}
}

window.onload = slide();
window.onload = slide2();



// 여기서부터는 탭 함수

let tab = document.querySelectorAll('.bookTab li');
let slides = document.querySelector('.bookSwipe');
let slides2 = document.querySelector('.bookSwipe2');

function booktab(){
    tab[0].onclick = () => {
        slides.style.display= "flex";
        slides2.style.display = "none";
    }
    tab[1].onclick = () => {
        slides.style.display = "none";
        slides2.style.display = "flex";
    }
}

window.onload = booktab();




