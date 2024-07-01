
//ask 아코디언 함수



let question = document.querySelectorAll('dt');
let answer = document.querySelectorAll('dd');
let arrow = document.querySelectorAll('dt img');

const upUrl = "/images/QnAarrowup.jpg";
const downUrl = "/images/QnAarrowdown.jpg";


function QnAaccordian(){
    for(let i=0;i<14;i++){
		
		let ddHeight = answer[i].scrollHeight;
		
        question[i].onclick = () =>{

            if(!answer[i].classList.contains("transition")){
				answer[i].style.height = ddHeight + 40 + "px";
				answer[i].style.padding = 20 + "px";
				answer[i].classList.add("transition");
                arrow[i].src=upUrl;
            }else if(answer[i].classList.contains("transition")){
				answer[i].style.height =  0 + "px";
				answer[i].style.padding = 0 + "px";
				answer[i].classList.remove("transition");
                arrow[i].src=downUrl;
            }
        }
    }
}

//window.onload = QnAaccordian();
addLoadEvent(QnAaccordian);
