const pswd = document.getElementById('pswd');
const passCheck = document.getElementById('passCheck');
const email = document.getElementById('email');
const mailspace = document.getElementById('email2');
const eselect = document.getElementById('emailSel');

const pswdRegexp = /(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#^*_]){8,20}/;

function modifyCheck(){
	
		let form = document.getElementById('form');
	
		if(!pswd.value){
			alert("비밀번호를 입력해주세요.");
			pswd.focus();
			form.addEventListener("submit", (e) => {e.preventDefault()});
			e.preventDefault();
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
		}else{
	        alert("가입이 완료되었습니다.");
	        return true;
	    }
}

function mailText(){
	let va = eselect.value;
	mailspace.value = va;
	mailspace.textContent = mailspace.value;
}