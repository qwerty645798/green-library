let idconut = 1, pwcount = 0;
let table, tr;
function ID() {
	if (idconut == 0) {
		idconut++;
		pwcount--;
		let span = document.getElementsByClassName("mainName");
		for (let i = 0; i < span.length; i++) {
			span[i].innerHTML = "아이디 찾기";
		}
		let id = document.getElementById("id");
		let pw = document.getElementById("pw");

		id.style.color = "white";
		id.style.background = "#0D2E8C";

		pw.style.color = "black";
		pw.style.background = "#EBEBEB";

		let choose = document.getElementById("choose");
		choose.innerHTML = "아이디 찾기 본인인증";
		
		table.removeChild(tr);
	}
}
function PW() {
	if (pwcount == 0) {
		pwcount++;
		idconut--;
		let span = document.getElementsByClassName("mainName");
		for (let i = 0; i < span.length; i++) {
			span[i].innerHTML = "비밀번호 찾기";
		}
		let id = document.getElementById("id");
		let pw = document.getElementById("pw");

		pw.style.color = "white";
		pw.style.background = "#0D2E8C";

		id.style.color = "black";
		id.style.background = "#EBEBEB";

		let choose = document.getElementById("choose");
		choose.innerHTML = "비밀번호 찾기 본인인증";
		
		table = document.getElementById("table");
		tr = document.createElement("tr");
		tr.innerHTML = "<td class='text'><div>아이디</div></td><td class='input'><input type='text' name='#'></td>"
		table.appendChild(tr);
	}
}