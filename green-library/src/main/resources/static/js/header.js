
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

   
















