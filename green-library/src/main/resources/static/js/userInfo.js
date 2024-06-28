let modalOpenButton = document.getElementById('modalOpenButton');
let modalCloseButton = document.getElementById('modalCloseButton');
let modal = document.getElementById('modalContainer');

let cancel = document.getElementById('cancel');/*이혜민 추가*/

modalOpenButton.addEventListener('click', () => {
  modal.classList.remove('hidden');
});

modalCloseButton.addEventListener('click', () => {
  modal.classList.add('hidden');
});
let modalOpenButton1 = document.getElementById('modalOpenButton1');
let modalCloseButton1 = document.getElementById('modalCloseButton1');
let modal1 = document.getElementById('modalContainer1');


modalOpenButton1.addEventListener('click', () => {
  modal1.classList.remove('hidden');
});

modalCloseButton1.addEventListener('click', () => {
  modal1.classList.add('hidden');
});
//이혜민 추가, 취소 버튼 누르면 모달창이 닫힌다.
cancel.addEventListener('click', () => {
	modal.classList.add('hidden');
});

/*본래 userInfo랑 userUseInformation 맨 아래에 있던 거 옮겨옴 */
document.addEventListener('DOMContentLoaded', function() {
        fetchDataAndSendToIframe('rentHistory');
    });
    
    document.querySelectorAll('.Dheader').forEach(header => {
        header.addEventListener('click', function() {
            let condition = this.getAttribute('data-condition');
            fetchDataAndSendToIframe(condition);
        });
    });

    function initialLoadIframe() {
        fetchDataAndSendToIframe('rentHistory');
    }

    function iframeHeight(condition, data) {
        let iframe = document.getElementById('iframe');
        if (data.length < 10) {
            iframe.style.height = 720 - (10 - data.length) * 34 + "px";
        } else {
            iframe.style.height = "720px";
        }
    }

    function fetchDataAndSendToIframe(condition) {
        fetch(`/getUserData`)
            .then(response => response.json())
            .then(data => {
                let iframe = document.getElementById('iframe');
                iframe.contentWindow.postMessage({ condition: condition, data: data[condition] }, '*');
                iframeHeight(condition, data[condition]);
            })
            .catch(error => console.error('Error fetching data:', error));
    }