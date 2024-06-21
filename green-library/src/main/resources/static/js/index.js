const newbooks = document.querySelector('.newbook');
const popbooks = document.querySelector('.popbook');

const window1 = document.querySelector('.window');
const window2 = document.querySelector('.window2');

const backBtn = document.querySelector('.backBtn');
const goBtn = document.querySelector('.goBtn');
//버튼들도 클래스가 옮겨가게 해보자. 



//const clsname = "on";

//let curlef = parseInt(newbooks.style.left,10)||0;
//let brect = newbooks.getBoundingClientRect();




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

window.onload = slide();



