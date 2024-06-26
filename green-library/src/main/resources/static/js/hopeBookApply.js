/*const hopedate= document.getElementById("hopedate");

const title = document.getElementById('title');
const author = document.getElementById('author');
const publisher = document.getElementById('publisher');
const bookYear = document.getElementById('bookYear');
const price = document.getElementById('price');
const isbn = document.getElementById('isbn');

const customText = document.getElementById('customText');*/

//신청일자가 저절로 뜨게 하는 함수
/*function requestDate(){
    let date = new Date();

    let reqYear = date.getFullYear();
    let reqMonth = date.getMonth();
    let reqDate = date.getDate();

    hopedate.textContent = reqYear + "년 " + reqMonth + "월 " +  reqDate + "일";

}
window.onload = requestDate();*/


//유효성 검사.
function hopeApplyCheck(){
	
	/*let form = document.getElementById('form');*/
	let userName = document.getElementById('userName');
    let title = document.getElementById('title');
    let author = document.getElementById('author');
    let publisher = document.getElementById('publisher');
    let bookYear = document.getElementById('bookYear');
    let price = document.getElementById('price');
    let isbn = document.getElementById('isbn');
    
    var hiddenUserId = document.querySelector('input[name="userId"]').value;
    
    if(!userName.value){
        alert("아이디를 입력해 주세요.");
        userName.focus();
		/*form.addEventListener("submit", (e) => {e.preventDefault()});*/
        return false;
    }else if(userName.value !== hiddenUserId.trim()){
		alert('아이디가 일치하지 않습니다.');
        userName.focus();
        return false;
	}
    
    if(!title.value){
        alert("도서명을 입력해 주세요.");
        title.focus();
		/*form.addEventListener("submit", (e) => {e.preventDefault()});*/
        return false;
    }
    if(!author.value){
        alert("저자명을 입력해 주세요.");
        author.focus();
		/*form.addEventListener("submit", (e) => {e.preventDefault()});*/
        return false;
    }
    if(!publisher.value){
        alert("출판사를 입력해 주세요.");
        publisher.focus();
		/*form.addEventListener("submit", (e) => {e.preventDefault()});*/
        return false;
    }
    if(!bookYear.value){
        alert("발행년도를 입력해 주세요.");
        bookYear.focus();
		/*form.addEventListener("submit", (e) => {e.preventDefault()});*/
        return false;
    } else if (!/^\d{4}-\d{2}-\d{2}$/.test(bookYear.value)) {
        alert("발행년도는 YYYY-MM-DD 형식이어야 합니다.");
        bookYear.focus();
        return false;
    } else {
        // 날짜 유효성
        let dateParts = bookYear.value.split("-");
        let year = parseInt(dateParts[0]);
        let month = parseInt(dateParts[1]);
        let day = parseInt(dateParts[2]);
        let date = new Date(year, month - 1, day);
        if(date.getFullYear() !== year || date.getMonth() !== month - 1 || date.getDate() !== day) {
            alert("유효한 날짜를 입력해 주세요.");
            bookYear.focus();
            return false;
        }
    }
    
    if(!price.value){
        alert("가격을 입력해 주세요.");
        price.focus();
		/*form.addEventListener("submit", (e) => {e.preventDefault()});*/
        return false;
    }else if (isNaN(price.value) || parseInt(price.value) <= 0) {
        alert("가격은 양수인 숫자여야 합니다.");
        price.focus();
        event.preventDefault();
        return false;
    }
    
    if(!isbn.value){//숫자만 가능
        alert("ISBN을 입력해 주세요.");
        isbn.focus();
		/*form.addEventListener("submit", (e) => {e.preventDefault()});*/
        return false;
    }    
    
    alert("신청이 완료되었습니다.");
    return true;
    
}



//div로 만든 검색창 위에 첨부파일 명이 뜨게 하는 함수.
//검색창 따로 만들어서 가릴 거다.
function fileText(){
    let namePlace = document.getElementById('bookImg');
    let fileName = namePlace.value;

    customText.innerText = fileName;
}

