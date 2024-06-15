//json으로 header footer 붙여넣는 함수
function comeHeader(){
    let xhr = new XMLHttpRequest();

    xhr.open('GET', '/views/index/header.jsp', true);
    xhr.send();

    xhr.onload = function (){
        document.getElementById('header').innerHTML = xhr.response;
    }

}
function comeFooter(){
    let xhr = new XMLHttpRequest();

    xhr.open('GET', '/views/index/footer.jsp', true);
    xhr.send();

    xhr.onload = function (){
        document.getElementById('footer').innerHTML = xhr.response;
    }
}

window.addEventListener('load',function(){
    comeHeader();
    comeFooter();
})