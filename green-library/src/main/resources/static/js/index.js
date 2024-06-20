const newbooks = document.querySelector('.newbook');
const popbooks = document.querySelector('.popbook');

const window1 = document.querySelector('.window');
const window2 = document.querySelector('.window2');

const backBtn = document.querySelector('.backBtn');
const goBtn = document.querySelector('.goBtn');
//버튼들도 클래스가 옮겨가게 해보자. 

const clsname = "on";



//function slide(){
//	backBtn.onclick = () => {
//		newbooks.style.left = -window1.offsetWidth + 'px';
//		newbooks.style.transition = '200ms ease-in-out';
//	}
//	goBtn.onclick = () => {
//		newbooks.style.left = 630 + 'px';
//		newbooks.style.transition = '200ms ease-in-out';
//	}
//
//}
//window.addEventListener('load', slide);

//function back(){
//	newbooks.style.left = -window1.offsetWidth + 'px';
//	newbooks.style.transition = '200ms ease-in-out';
//}
//
//function go(){
//	newbooks.style.left = 0 + 'px';
//	newbooks.style.transition = '200ms ease-in-out';
//}
function slide(){
	if(newbooks.scrollLeft==0){
		goBtn.onclick = () => {
			newbooks.style.left = -window1.offsetWidth + 'px';
			newbooks.style.transition = '200ms ease-in-out';
		}
	}else if(newbooks.scrollLeft==-1260){
		goBtn.onclick = () => {
			newbooks.style.left = (-window1.offsetWidth)*2 + 'px';
			newbooks.style.transition = '200ms ease-in-out';
		}
		backBtn.onclick = () => {
			newbooks.style.left = 0 + 'px';
			newbooks.style.transition = '200ms ease-in-out';
		}
	}else if(newbooks.scrollLeft==-2520){
		goBtn.onclick = () => {
			newbooks.style.left = -window1.offsetWidth*3 + 'px';
			newbooks.style.transition = '200ms ease-in-out';
		}
		backBtn.onclick = () => {
			newbooks.style.left = -window1.offsetWidth + 'px';
			newbooks.style.transition = '200ms ease-in-out';
		}
	}
}

window.onload = slide();



