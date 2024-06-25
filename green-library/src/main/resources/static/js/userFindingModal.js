let modalOpenButton = document.getElementById('modalOpenButton');
let modalCloseButton = document.getElementById('modalCloseButton');
let modal = document.getElementById('modalContainer');

modalOpenButton.addEventListener('click', () => {
  modal.classList.remove('hidden');
});

modalCloseButton.addEventListener('click', () => {
  modal.classList.add('hidden');
});

let modalOpenButton1 = document.getElementById('modalOpenButton1');
let modalCloseButton1 = document.getElementById('modalCloseButton1');
let modal1 = document.getElementById('modalContainer');

modalOpenButton1.addEventListener('click', () => {
  modal1.classList.remove('hidden');
});

modalCloseButton1.addEventListener('click', () => {
  modal1.classList.add('hidden');
});
