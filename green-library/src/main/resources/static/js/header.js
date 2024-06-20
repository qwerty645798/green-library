// const menuTop = document.getElementById('subMenuTop');
// const menuTop2 = document.getElementById('subMenuTop2');
// const menuTop3 = document.getElementById('subMenuTop3');
// const menuTop4 = document.getElementById('subMenuTop4');
// const menuTop5 = document.getElementById('subMenuTop5');

// const subMenu1 = document.getElementById('subMenu1');
// const subMenu2 = document.getElementById('subMenu2');
// const subMenu3 = document.getElementById('subMenu3');
// const subMenu4 = document.getElementById('subMenu4');
// const subMenu5 = document.getElementById('subMenu5');

// function menuOpen1(){
//     if(subMenu1.scrollHeight!=0||subMenu2.scrollHeight!=0){
//         subMenu1.style.display = "none";
//         subMenu1.style.height =  subMenu1.scrollHeight + "px";
//         subMenu1.style.transition = "height 1000ms ease-in-out";
//     }else if(subMenu1.scrollHeight==0){
//         subMenu1.style.display = "flex";
//         subMenu1.style.height =  subMenu1.scrollHeight + "px";
//         subMenu1.style.transition = "height 1000ms ease-in-out";
//     }
    
// }
// function menuOpen2(){
//     subMenu2.style.display = "flex";
//     subMenu2.style.height =  subMenu2.scrollHeight + "px";
//     subMenu2.style.transition = "height 1000ms ease-in-out";
// }
// function menuOpen3(){
//     subMenu3.style.display = "flex";
//     subMenu3.style.height =  subMenu3.scrollHeight + "px";
//     subMenu3.style.transition = "height 1000ms ease-in-out";
// }
// function menuOpen4(){
//     subMenu4.style.display = "flex";
//     subMenu4.style.height =  subMenu4.scrollHeight + "px";
//     subMenu4.style.transition = "height 1000ms ease-in-out";
// }
// function menuOpen5(){
//     subMenu5.style.display = "flex";
//     subMenu5.style.height =  subMenu5.scrollHeight + "px";
//     subMenu5.style.transition = "height 1000ms ease-in-out";
// }

// menuTop.addEventListener("click", menuOpen1);
// menuTop2.addEventListener("click", menuOpen2);
// menuTop3.addEventListener("click", menuOpen3);
// menuTop4.addEventListener("click", menuOpen4);
// menuTop5.addEventListener("click", menuOpen5);


//test용. 반복문.
//함수 실행

// subMenuTop[j].addEventListener("click", accordian);

//아코디언 함수


    let subMenuTop = document.getElementById('subMenuTop').children;
    let subMenu = document.getElementById('subMenu');
    let input = document.getElementsByTagName("input");
function accordian(){
    for(let i=0;i<5;i++){

        subMenuTop[i].onclick = () => {
            if(subMenu.scrollHeight==0){
                subMenu.style.display = "flex";
                subMenu.style.height =  subMenu.scrollHeight + "px";
                subMenu.style.transition = "height 300ms ease-in-out";
                subMenu.style.zIndex = "10";
                for(let i=0; i<input.length; i++){
					input[i].zIndex = "3";
				}
                
            }else if(subMenu.scrollHeight!=0){
                subMenu.style.display = "none";
                subMenu.style.height =  subMenu.scrollHeight + "px";
                subMenu.style.transition = "height 300ms ease-in-out";
                subMenu.style.zIndex = "3";
                for(let i=0; i<input.length; i++){
					input[i].zIndex = "10";
				}
            }
        }
    }

    
}

window.onload = accordian();

    

    








// let a = document.getElementById('userjoin');
// a.onclick = () => {
//     a.style.color = "red";
// }

   
















