const hopedate= document.getElementById("hopedate");

const title = document.getElementById('title');
const author = document.getElementById('author');
const publisher = document.getElementById('publisher');
const bookYear = document.getElementById('bookYear');
const price = document.getElementById('price');
const isbn = document.getElementById('isbn');

const customText = document.getElementById('customText');

//신청일자가 저절로 뜨게 하는 함수
function requestDate(){
    let date = new Date();

    let reqYear = date.getFullYear();
    let reqMonth = date.getMonth();
    let reqDate = date.getDate();

    hopedate.textContent = reqYear + "년 " + reqMonth + "월 " +  reqDate + "일";

}

window.onload = requestDate();


//유효성 검사.
function hopeApplyCheck(){
	
	let form = document.getElementById('form');
	
    if(!title.value){
        alert("도서명을 입력해 주세요.");
        title.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
        return false;
    }
    if(!author.value){
        alert("저자명을 입력해 주세요.");
        author.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
        return false;
    }
    if(!publisher.value){
        alert("출판사를 입력해 주세요.");
        publisher.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
        return false;
    }
    if(!bookYear.value){
        alert("발행년도를 입력해 주세요.");
        bookYear.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
        return false;
    }
    if(!price.value){
        alert("가격을 입력해 주세요.");
        price.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
        return false;
    }
    if(!isbn.value){//숫자만 가능
        alert("ISBN을 입력해 주세요.");
        isbn.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
        return false;
    }
    else{
        alert("신청이 완료되었습니다.");
        return true;
    }
}



//div로 만든 검색창 위에 첨부파일 명이 뜨게 하는 함수.
//검색창 따로 만들어서 가릴 거다.
function fileText(){
    let namePlace = document.getElementById('bookImg');
    let fileName = namePlace.value;

    customText.innerText = fileName;
}