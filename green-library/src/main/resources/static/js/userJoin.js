const name = document.getElementById('name');
const birthdate = document.getElementById('birthDate');
const userid = document.getElementById('userid');
const pswd = document.getElementById('pswd');
const passCheck = document.getElementById('passCheck');
const email = document.getElementById('email');
const eselect = document.getElementById('emailSel');
const mailspace = document.getElementById('email2');

const submit = document.getElementById('submit');

function joinCheck(){
	if(!name.value){
		alert("이름을 입력해주세요.");
		name.focus();
		 e.preventDefault();
		return false;
	}
	if(!birthdate.value){
		alert("생일을 입력해주세요.");
		birthdate.focus();
		e.preventDefault();
		return false;
	}
	if(!userid.value){
		alert("아이디를 입력해주세요.");
		userid.focus();
		e.preventDefault();
		return false;
	}
	if(!pswd.value){
		alert("비밀번호를 입력해주세요.");
		pswd.focus();
		e.preventDefault();
		return false;
	}
	if(pswd.value!==passCheck.value){
		alert("비밀번호가 틀렸습니다.");
		passCheck.focus();
		e.preventDefault();
		return false;
	}
	if(!email.value){
		alert("이메일을 입력해주세요.");
		email.focus();
		e.preventDefault();
		return false;
	}
	if(!eselect.value){
		alert("이메일 주소를 선택해주세요.");
		name.focus();
		e.preventDefault();
		return false;
	}else{
        alert("가입이 완료되었습니다.");
        return true;
    }
	
}
submit.onclick = joinCheck();

function mailText(){
	
	let v = eselect.children[1].value;
	mailspace.value = v;
}

eselect.addEventListener("change", mailText());

userid.onfocus = () => {userid.style.backgroundColor = "pink";};