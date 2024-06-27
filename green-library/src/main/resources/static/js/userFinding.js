const username = document.getElementById('username');
const birthdate = document.getElementById('birthDate');
let userid;
const email = document.getElementById('email');
const form = document.getElementById("form");

form.addEventListener('submit', function(e) {
    concatInput();
    if (!check()) {
        e.preventDefault();
    }
});


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
		id.style.background = "#155734";

		pw.style.color = "black";
		pw.style.background = "#d8e9d9";

		let choose = document.getElementById("choose");
		choose.innerHTML = "아이디 찾기 본인인증";
		
		table.removeChild(tr);
		let form = document.getElementById("form");
		form.action = "userFindingId";
		console.log(form.action);
	}
}
function PW() {
	if (pwcount == 0) {
		pwcount++;
		idconut--;
		userid = document.getElementById('userid');
		let span = document.getElementsByClassName("mainName");
		for (let i = 0; i < span.length; i++) {
			span[i].innerHTML = "비밀번호 찾기";
		}
		let id = document.getElementById("id");
		let pw = document.getElementById("pw");

		pw.style.color = "white";
		pw.style.background = "#155734";

		id.style.color = "black";
		id.style.background = "#d8e9d9";

		let choose = document.getElementById("choose");
		choose.innerHTML = "비밀번호 찾기 본인인증";
		
		table = document.getElementById("table");
		tr = document.createElement("tr");
		tr.innerHTML = "<td class='text'><div>아이디</div></td><td class='input'><input type='text' name='user_id' id='userid'></td>"
		table.appendChild(tr);
		let form = document.getElementById("form");
		form.action = "userFindingPw";
		console.log(form.action);
	}
}

function concatInput(){
	let input = document.getElementsByClassName("short");
	let email = document.getElementById("email");
	email.value = input[0].value + "@" + input[1].value;
}
function check(){
	if (!username.value) {
        alert("이름을 입력해주세요.");
        username.focus();
        return false;
    }
    if (!birthdate.value || birthRegexp.test(birthdate.value) == false) {
        alert("생년월일을 입력해주세요.");
        birthdate.focus();
        return false;
    }
    if (!userid.value) {
        alert("아이디를 입력해주세요.");
        userid.focus();
        return false;
    }
    if (userid.value.length < 5) {
        alert("아이디는 5글자 이상 입력해주세요.");
        userid.focus();
        return false;
    }
    if (idRegexp.test(userid.value) == false) {
        alert("아이디에는 특수문자가 들어갈 수 없습니다.");
        userid.focus();
        return false;
    }
    if (!email.value) {
        alert("이메일을 입력해주세요.");
        email.focus();
        return false;
    }
    alert("이메일이 발송되었습니다.");
    return true;
}
