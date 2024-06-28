
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
			switch(i){
				case 0:
					ddHeight = 200;
					break;
				case 1:
					ddHeight = 280;
					break;
				case 2:
					ddHeight = 180;
					break;
				case 3:
					ddHeight = 330;
					break;
				case 4:
					ddHeight = 160;
					break;
				case 5:
					ddHeight = 120;
					break;
				case 6:
					ddHeight = 120;
					break;
				case 7:
					ddHeight = 80;
					break;
				case 8:
					ddHeight = 600;
					break;
				case 9:
					ddHeight = 650;
					break;
				case 10:
					ddHeight = 80;
					break;
				case 11:
					ddHeight = 80;
					break;
				case 12:
					ddHeight = 80;
					break;
				case 13:
					ddHeight = 120;
					break;
			}
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

//window.onload = QnAaccordian();
addLoadEvent(QnAaccordian);
