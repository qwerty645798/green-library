let order = document.querySelectorAll('.orderBtn');

order[0].classList.add("curPage");

function orderNum(){
	order[0].onclick = () => {
		order[0].classList.add("curPage");
	}
}

window.onload = orderNum();