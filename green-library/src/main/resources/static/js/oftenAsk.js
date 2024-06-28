
//ask 아코디언 함수



let question = document.querySelectorAll('dt');
let answer = document.querySelectorAll('dd');
let arrow = document.querySelectorAll('img');

const upUrl = "/images/QnAarrowup.jpg";
const downUrl = "/images/QnAarrowdown.jpg";

//answer[i].scrollHeight==0

let ddHeight = 400;


function QnAaccordian(){
    for(let i=0;i<14;i++){
        question[i].onclick = () =>{
            if(!answer[i].classList.contains("transition")){
				answer[i].style.height = ddHeight + "px";
				answer[i].style.padding = 20 + "px";
				answer[i].classList.add("transition");
                arrow[i+2].src=upUrl;
            }else if(answer[i].classList.contains("transition")){
				answer[i].style.height =  0 + "px";
				answer[i].style.padding = 0 + "px";
				answer[i].classList.remove("transition");
                arrow[i+2].src=downUrl;
            }
        }
    }
}

window.onload = QnAaccordian();
