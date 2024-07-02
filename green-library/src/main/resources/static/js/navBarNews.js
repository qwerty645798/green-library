

let navRouteli = document.querySelectorAll('.useList li');
navRouteli = Array.from(navRouteli);

let imHere = window.location.href.split("/");

//도서관 이용. 바로가기 리스트
navRouteli[0].onclick = () => window.location.href = "/notification";
navRouteli[1].onclick = () => window.location.href = "/oftenAsk";
navRouteli[2].onclick = () => window.location.href = "/schedule";

if(imHere[3]=="notification"){
	navRouteli[0].classList.add("curPlace");
}
if(imHere[3]=="oftenAsk"){
	navRouteli[1].classList.add("curPlace");
}
if(imHere[3]=="schedule"){
	navRouteli[2].classList.add("curPlace");
}



