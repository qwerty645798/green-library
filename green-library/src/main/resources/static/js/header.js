
//아코디언 함수


    let subMenuTop = document.getElementById('subMenuTop').children;
    let subMenu = document.querySelector('.subMenu');
    let input = document.getElementsByTagName("input");

	let menuHeight = 300;
	
	function accordian(){
    for(let i=0;i<5;i++){

        subMenuTop[i].onclick = () => {
            if(!subMenu.classList.contains("menuopen")){
                subMenu.style.height =  menuHeight + "px";
				subMenu.classList.add("menuopen");
                subMenu.style.zIndex = "10";
                for(let i=0; i<input.length; i++){
					input[i].zIndex = "3";
				}
                
            }else if(subMenu.classList.contains("menuopen")){
                subMenu.style.height =  0 + "px";
				subMenu.classList.remove("menuopen");
                subMenu.style.zIndex = "3";
                for(let i=0; i<input.length; i++){
					input[i].zIndex = "10";
				}
            }
        }
    }

    
}

addLoadEvent(accordian);

//로그인 회원가입 페이지로 이동

	let login = document.querySelector('.loginLink');
	let join = document.querySelector('.joinLink');
	let logo = document.querySelector('.logo');

	//NULL 체크
		if (logo) {
	        logo.onclick = () => {
	            window.location.href = '/';
	        }
	    }

	    if (login) {
	        login.onclick = () => {
	            window.location.href = 'userLogin';
	        }
	    }

	    if (join) {
	        join.onclick = () => {
	            window.location.href = 'userAgreement';
	        }
	    }
		
//헤더 상단 고정

let pageHead = document.querySelector('header');
let headerBar = document.querySelector('.headerBottom');
let whereScroll = document.documentElement.scrollTop;


function headerHang(){
	if(whereScroll>=200){
		headerBar.classList.add("fixUp");
	}else if(whereScroll<200){
		headerBar.classList.remove("fixUp");
	}
}
//function headerHang(){
//	if(whereScroll>=200){
//			headerBar.style.position = "fixed";
//			subMenu.style.position = "fixed"
//			headerBar.style.top = 0 + "px";
//			subMenu.style.top = 56 + "px";
//		}else{
//			headerBar.style.position = "static";
//			subMenu.style.position = "static";
//		}
//}
//
addLoadEvent(headerHang);
	
	    

