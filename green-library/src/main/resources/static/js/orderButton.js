let order = document.querySelectorAll('#orderBtn');

function orderNum(){
	order.onclick = () => {
		order[0].classLIst.add("curPage");
	}
}

window.onload = orderNum();