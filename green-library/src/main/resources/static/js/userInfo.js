let modalOpenButton = document.getElementById('modalOpenButton');
let modalCloseButton = document.getElementById('modalCloseButton');
let modal = document.getElementById('modalContainer');

modalOpenButton.addEventListener('click', () => {
  modal.classList.remove('hidden');
});

modalCloseButton.addEventListener('click', () => {
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

        function fetchDataAndSendToIframe(condition) {
            fetch(`/getUserData`)
                .then(response => response.json())
                .then(data => {
                    let iframe = document.getElementById('iframe');
                    iframe.contentWindow.postMessage({ condition: condition, data: data[condition] }, '*');
                })
                .catch(error => console.error('Error fetching data:', error));
        }