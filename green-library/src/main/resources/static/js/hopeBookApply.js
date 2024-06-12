//신청일자가 저절로 뜨게 하는 함수
function requestDate(){
    let date = new Date();

    let reqYear = date.getFullYear();
    let reqMonth = date.getMonth();
    let reqDate = date.getDate();

    document.getElementById("reqDate").innerHtml = reqYear + "/" + reqMonth + "/" + reqDate;
    document.write(reqYear + "/" + reqMonth + "/" + reqDate);
    return reqYear + "/" + reqMonth + "/" + reqDate;

}

//유효성 검사.
//경고문은 제대로 뜨는데 포커스가 올라가지도 않고, 싹 다 초기화 되어버린다.
function hopeApplyCheck(){
    if(!title.value){
        alert("도서명을 입력해 주세요.");
        document.title.focus();
        return false;
    }else if(!author.value){
        alert("저자명을 입력해 주세요.");
        document.author.focus();
        return false;
    }else if(!publisher.value){
        alert("출판사를 입력해 주세요.");
        document.publisher.focus();
        return false;
    }else if(!bookYear.value){
        alert("발행년도를 입력해 주세요.");
        document.bookYear.focus();
        return false;
    }else if(!price.value){
        alert("가격을 입력해 주세요.");
        document.price.focus();
        return false;
    }else if(!isbn.value||){//숫자만 가능
        alert("ISBN을 입력해 주세요.");
        document.isbn.focus();
        return false;
    }else{
        return true;
    }

}

//div로 만든 검색창 위에 첨부파일 명이 뜨게 하는 함수.
//검색창 따로 만들어서 가릴 거다.
function fileText(){

}