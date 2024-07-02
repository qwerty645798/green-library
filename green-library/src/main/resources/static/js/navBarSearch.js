

let navRouteli = document.querySelectorAll('.useList li');
navRouteli = Array.from(navRouteli);

let imHere = window.location.href.split("/");

//도서관 이용. 바로가기 리스트
navRouteli[0].onclick = () => window.location.href = "/dataSearch";
navRouteli[1].onclick = () => window.location.href = "/popularBook";
navRouteli[2].onclick = () => window.location.href = "/initiativeBook";

if(imHere[3]=="dataSearch"){
	navRouteli[0].classList.add("curPlace");
}
if(imHere[3]=="popularBook"){
	navRouteli[1].classList.add("curPlace");
}
if(imHere[3]=="initiativeBook"){
	navRouteli[2].classList.add("curPlace");
}



