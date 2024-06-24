
function showPage(pageNumber) {
    document.querySelectorAll('.page').forEach(function(page) {
        page.classList.add('hidden');
    });
    
    document.getElementById('page_' + pageNumber).classList.remove('hidden');
}