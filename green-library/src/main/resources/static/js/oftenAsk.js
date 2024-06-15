
//ask 아코디언 함수

let question = document.querySelectorAll('dt');
let answer = document.querySelectorAll('dd');

let dt = document.querySelectorAll('.dt')
let dd = document.querySelectorAll('.dd');


// function QnAaccordian(){
// for(let i=1;i<=14;i++){

//     question[i].onclick = () => {
//         if(answer[i].scrollHeight==0){
//             answer[i].style.display = "flex";
//             answer[i].style.height =  answer[i].scrollHeight + "px";
//             answer[i].style.transition = "height 300ms ease-in-out";
//         }else if(answer[i].scrollHeight!=0){
//             answer[i].style.display = "none";
//             answer[i].style.height =  answer[i].scrollHeight + "px";
//             answer[i].style.transition = "height 300ms ease-in-out";
//         }
//     }
// }
// }

function QnAaccordian(){
    for(let i=0;i<14;i++){
        dt[i].onclick = () =>{
            if(dd[i].scrollHeight==0){
                dd[i].style.display = "flex";
                dd[i].style.height =  dd[i].scrollHeight + "px";
                dd[i].style.transition = "height 300ms ease-in-out";
            }else if(dd[i].scrollHeight!=0){
                dd[i].style.display = "none";
                dd[i].style.height =  dd[i].scrollHeight + "px";
                dd[i].style.transition = "height 300ms ease-in-out";
            }
        }
    }
}






window.onload = QnAaccordian();