
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

window.onload = accordian();

//로그인 회원가입 페이지로 이동


function welcome(){
	
	let login = document.querySelector('.loginLink');
	let join = document.querySelector('.joinLink');
	let logo = document.querySelector('.logo');

	logo.onclick = () => {
		window.location.href = 'index';
	}
	login.onclick = () => {
		window.location.href = 'userLogin';
	}
	join.onclick = () => {
		window.location.href = 'userAgreement';
	}
}

window.onload = welcome();

    

    








// let a = document.getElementById('userjoin');
// a.onclick = () => {
//     a.style.color = "red";
// }

   
















