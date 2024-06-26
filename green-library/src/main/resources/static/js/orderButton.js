let order = document.querySelectorAll('.orderBtn');

function orderNum(){
	order[0].onclick = () => {
		order[0].classList.add("curPage");
	}
}

window.onload = orderNum();