
//아코디언 함수


    let subMenuTop = document.getElementById('subMenuTop').children;
    let subMenu = document.getElementById('subMenu');
    let input = document.getElementsByTagName("input");
function accordian(){
    for(let i=0;i<5;i++){

        subMenuTop[i].onclick = () => {
            if(subMenu.offsetHeight==0){
                subMenu.style.display = "flex";
                subMenu.style.height =  subMenu.scrollHeight + "px";
                subMenu.style.transition = "300ms ease-in-out";
                subMenu.style.zIndex = "10";
                for(let i=0; i<input.length; i++){
					input[i].zIndex = "3";
				}
                
            }else if(subMenu.offsetHeight!=0){
                subMenu.style.display = "none";
                subMenu.style.height =  subMenu.scrollHeight + "px";
                subMenu.style.transition = "300ms ease-in-out";
                subMenu.style.zIndex = "3";
                for(let i=0; i<input.length; i++){
					input[i].zIndex = "10";
				}
            }
        }
    }

    
}

addLoadEvent(accordian);
/*window.onload = accordian();*/

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
	    

//header 아코디언 리스트 링크

let library = document.getElementById('subMenu1').children;
let libraryUse = document.getElementById('subMenu2').children;
let bookSearch = document.getElementById('subMenu3').children;
let help = document.getElementById('subMenu4').children;
let userPage = document.getElementById('subMenu5').children;

if(library){
	library[0].onclick = () => window.location.href="vision";
}	
if(libraryUse){
	libraryUse[0].onclick = () => window.location.href='wayToCome';
	libraryUse[1].onclick = () => window.location.href='placeUsetime';
	libraryUse[2].onclick = () => window.location.href='dataRule';
	libraryUse[3].onclick = () => window.location.href='facilityInfo';
}
if(bookSearch){
	bookSearch[0].onclick = () => window.location.href='dataSearch';
	bookSearch[1].onclick = () => window.location.href='popularBook';
	bookSearch[2].onclick = () => window.location.href='initiativeBook';
}
if(help){
	help[0].onclick = () => window.location.href='notification';
	help[2].onclick = () => window.location.href='oftenAsk';
	help[3].onclick = () => window.location.href='schedule';
}

    






    

    










   
















