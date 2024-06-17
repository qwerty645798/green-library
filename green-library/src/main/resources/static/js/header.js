


/*    let subMenuTop = document.getElementById('subMenuTop').children;
    let subMenu = document.getElementById('subMenu').children;
    let input = document.getElementsByTagName("input");
function accordian(){
    for(let i=0;i<5;i++){

        subMenuTop[i].onclick = () => {
            if(subMenu[i].scrollHeight==0){
                subMenu[i].style.display = "flex";
                subMenu[i].style.height =  subMenu[i].scrollHeight + "px";
                subMenu[i].style.transition = "height 300ms ease-in-out";
                subMenu[i].style.zIndex = "10";
                for(let i=0; i<input.length; i++){
					input[i].zIndex = "3";
				}
                
            }else if(subMenu[i].scrollHeight!=0){
                subMenu[i].style.display = "none";
                subMenu[i].style.height =  subMenu[i].scrollHeight + "px";
                subMenu[i].style.transition = "height 300ms ease-in-out";
                subMenu[i].style.zIndex = "3";
                for(let i=0; i<input.length; i++){
					input[i].zIndex = "10";
				}
            }
        }
    }

    
}

window.onload = accordian();

    

    









   
















