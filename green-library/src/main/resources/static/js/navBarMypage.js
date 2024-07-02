

let navRouteli = document.querySelectorAll('.useList li');
navRouteli = Array.from(navRouteli);

let imHere = window.location.href.split("/");

//도서관 이용. 바로가기 리스트
navRouteli[0].onclick = () => window.location.href = "/user/userInfo";
navRouteli[1].onclick = () => window.location.href = "/user/bookLoanExtension";
navRouteli[2].onclick = () => window.location.href = "/userAgreement";
navRouteli[3].onclick = () => window.location.href = "/user/myWritten";
navRouteli[4].onclick = () => window.location.href = "/user/userInquiryCreate";

if(imHere[4]=="userInfo"){
	navRouteli[0].classList.add("curPlace");
}
if(imHere[4]=="bookLoanExtension"){
	navRouteli[1].classList.add("curPlace");
}
if(imHere[3]=="userAgreement"){
	navRouteli[2].classList.add("curPlace");
}
if(imHere[4]=="myWritten"){
	navRouteli[3].classList.add("curPlace");
}
if(imHere[4]=="userInquiryCreate"||
imHere[4].includes("userInquiryDetail")||
imHere[4].includes("wishBook")
){
	navRouteli[4].classList.add("curPlace");
}


