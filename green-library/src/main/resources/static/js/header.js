


/*    let subMenuTop = document.getElementById('subMenuTop').children;
    let subMenu = document.getElementById('subMenu').children;
    
function accordian(){
    for(let i=0;i<5;i++){

        subMenuTop[i].onclick = () => {
            if(subMenu[i].scrollHeight==0){
                subMenu[i].style.display = "flex";
                subMenu[i].style.height =  subMenu[i].scrollHeight + "px";
                subMenu[i].style.transition = "height 300ms ease-in-out";
            }else if(subMenu[i].scrollHeight!=0){
                subMenu[i].style.display = "none";
                subMenu[i].style.height =  subMenu[i].scrollHeight + "px";
                subMenu[i].style.transition = "height 300ms ease-in-out";
            }
        }
    }
}*/

	let subMenuTop = document.getElementById('subMenuTop').children;
	let subMenu = document.getElementById('subMenu');
	
	function accordian(){
			
	    for(let i=0;i<5;i++){
	        subMenuTop[i].onclick = () => {
	                if(subMenu.scrollHeight==0){
	                    subMenu.style.display = "flex";
	                    subMenu.style.height =  subMenu.scrollHeight + "px";
	                    subMenu.style.transition = scrollHeight + "1s ease-in-out";
	                }else if(subMenu.scrollHeight!=0){
	                    subMenu.style.display = "none";
	                    subMenu.style.height =  subMenu.scrollHeight + "px";
	                    subMenu.style.transition = scrollHeight + "1s ease-in-out";
	                }
	            }
	        }
	    }
	
	
	window.onload = accordian();
    

    









   
















