document.addEventListener('DOMContentLoaded', function() {
	if (localStorage.getItem('rememberMe') === 'true') {
		document.getElementById('id').value = localStorage.getItem('userId');
		document.getElementById('remember-me').checked = true;
	}
});

document.getElementById('form').addEventListener('submit', function(event) {
	if (document.getElementById('remember-me').checked) {
		localStorage.setItem('userId', document.getElementById('id').value);
		localStorage.setItem('rememberMe', 'true');
	} else {
		localStorage.removeItem('userId');
		localStorage.removeItem('rememberMe');
	}
});