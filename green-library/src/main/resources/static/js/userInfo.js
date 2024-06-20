let modalOpenButton = document.getElementById('modalOpenButton');
let modalCloseButton = document.getElementById('modalCloseButton');
let modal = document.getElementById('modalContainer');

modalOpenButton.addEventListener('click', () => {
  modal.classList.remove('hidden');
});

modalCloseButton.addEventListener('click', () => {
  modal.classList.add('hidden');
});