
//ask 아코디언 함수



let question = document.querySelectorAll('.dt')
let answer = document.querySelectorAll('.dd');
let arrow = document.querySelectorAll('img');


function QnAaccordian(){
    for(let i=0;i<14;i++){
        question[i].onclick = () =>{
            if(answer[i].scrollHeight==0){
                answer[i].style.display = "flex";
                answer[i].style.height =  answer[i].scrollHeight + "px";
                answer[i].style.transition = "height 300ms ease-in-out";
                arrow[i+1].src="/images/QnAarrowup.jpg";
            }else if(answer[i].scrollHeight!=0){
                answer[i].style.display = "none";
                answer[i].style.height =  answer[i].scrollHeight + "px";
                answer[i].style.transition = "height 300ms ease-in-out";
                arrow[i+1].src="/images/QnAarrowdown.jpg";
            }
        }
    }

   
}






window.onload = QnAaccordian();