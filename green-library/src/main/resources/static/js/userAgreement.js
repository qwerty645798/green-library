let totalCheck = document.getElementById("totalCheck");
let check = document.getElementsByClassName("check");
function checkBtn() {
	if (totalCheck.checked) {
		for (let i = 0; i < check.length; i++) {
			check[i].checked = true;
		}
	}
}
function checkTotalBtn() {
	for (let i = 0; i < check.length; i++) {
		if (!check[i].checked) {
			totalCheck.checked = false;
			break;
		}
	}
}
document.getElementById("myForm").addEventListener("submit", function(event) {
	for (let i = 0; i < 2; i++) {
		if (!check[i].checked) break;
	}
	event.preventDefault();
	alert("필수항목에 동의하셔야 회원가입이 가능합니다.");
});