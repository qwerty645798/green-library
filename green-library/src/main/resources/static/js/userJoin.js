const username = document.getElementById('username');
const birthdate = document.getElementById('birthDate');
const userid = document.getElementById('userid');
const pswd = document.getElementById('pswd');
const passCheck = document.getElementById('passCheck');
const email = document.getElementById('email');
const mailspace = document.getElementById('email2');
const eselect = document.getElementById('emailSel');

const birthRegexp = /(19|20)[0-9]{2}\-[0-9]{1,2}\-[0-9]{1,2}/;
const idRegexp = /[a-z|0-9]{5,}/;
const pswdRegexp = /(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#^*_]){8,20}/;

const submit = document.getElementById('submit');



function joinCheck(){
	
	let form = document.getElementById('form');
	
	if(!username.value){
		alert("이름을 입력해주세요.");
		username.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
		return false;
	}
	if(!birthdate.value||birthRegexp.test(birthdate.value)==false){
		alert("생년월일을 입력해주세요.");
		birthdate.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
		return false;
	}/*생년월일 유효성체크는 조금 부족함 */
	if(!userid.value){
		alert("아이디를 입력해주세요.");
		userid.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
		return false;
	}
	if(userid.value.length<5){
		alert("아이디는 5글자 이상 입력해주세요.");
		userid.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
		return false;
	}
	if(idRegexp.test(userid.value)==false){
		alert("아이디에는 특수문자가 들어갈 수 없습니다.");
		userid.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
		return false;
	}
	if(!pswd.value){
		alert("비밀번호를 입력해주세요.");
		pswd.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
		return false;
	}
	if(pswd.value.length<8||pswd.value.length>20){
		alert("비밀번호는 8자에서 20자 사이여야 합니다.");
		pswd.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
		return false;	
	}
	if(pswdRegexp.test(pswd.value)==false){
		alert("비밀번호는 숫자, 영문 대소문자,"
		 + "특수문자 !, @, #, ^, *, _ 중" 
		+ " 3가지 이상 조합이어야 합니다.");
		pswd.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
		return false;	
	}
	if(pswd.value!==passCheck.value||!passCheck.value){
		alert("비밀번호가 틀렸습니다.");
		passCheck.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
		return false;
	}
	if(!email.value){
		alert("이메일을 입력해주세요.");
		email.focus();
		form.addEventListener("submit", (e) => {e.preventDefault()});
		return false;
	}
	if(eselect.value==""||eselect.onfocus){
		alert("이메일 주소를 선택해주세요.");
		form.addEventListener("submit", (e) => {e.preventDefault()});
		return false;
	}
	/*if(){
		alert("아이디 중복체크를 해주세요.");
		e.preventDefault();
		return false;
	}*/else{
        alert("가입이 완료되었습니다.");
        return true;
    }
	
}


function mailText(){
	let va = eselect.value;
	mailspace.value = va;
	mailspace.textContent = mailspace.value;
}


 