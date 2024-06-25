const username = document.getElementById('username');
const birthdate = document.getElementById('birthDate');
const userid = document.getElementById('userid');
const pswd = document.getElementById('pswd');
const passCheck = document.getElementById('passCheck');
const email = document.getElementById('email');
const mailspace = document.getElementById('email2');
const eselect = document.getElementById('emailSel');
const form = document.getElementById("form");
const birthRegexp = /(19|20)[0-9]{2}\-[0-9]{1,2}\-[0-9]{1,2}/;
const idRegexp = /[a-z|0-9]{5,}/;
const pswdRegexp = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#^*_])[A-Za-z\d!@#^*_]{8,20}$/;

form.addEventListener('submit', function(e) {
    concatInput();
    if (!joinCheck()) {
        e.preventDefault();
    }
});

function joinCheck() {
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
    if (!pswd.value) {
        alert("비밀번호를 입력해주세요.");
        pswd.focus();
        return false;
    }
    if (pswd.value.length < 8 || pswd.value.length > 20) {
        alert("비밀번호는 8자에서 20자 사이여야 합니다.");
        pswd.focus();
        return false;
    }
    if (pswdRegexp.test(pswd.value) == false) {
        alert("비밀번호는 숫자, 영문 대소문자, 특수문자 !, @, #, ^, *, _ 중 3가지 이상 조합이어야 합니다.");
        pswd.focus();
        return false;
    }
    if (pswd.value !== passCheck.value || !passCheck.value) {
        alert("비밀번호가 틀렸습니다.");
        passCheck.focus();
        return false;
    }
    if (!email.value) {
        alert("이메일을 입력해주세요.");
        email.focus();
        return false;
    }
    if (eselect.value == "") {
        alert("이메일 주소를 선택해주세요.");
        return false;
    }
    alert("가입이 완료되었습니다.");
    return true;
}

function mailText() {
    let va = eselect.value;
    mailspace.value = va;
}

function concatInput() {
    let emailF = document.getElementById("email").value;
    let emailB = document.getElementById("email2").value;
    let fullEmail = document.getElementById("fullEmail");

    fullEmail.value = emailF + "@" + emailB;

    let brief = document.getElementsByClassName("brief");
    let fullPhone = document.getElementById("fullphone");

    fullPhone.value = brief[0].value + "-" + brief[1].value + "-" + brief[2].value;
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('checkUserIdBtn').addEventListener('click', function() {
        let userId = document.getElementById('userid').value;
        let xhr = new XMLHttpRequest();
        xhr.open('GET', '/checkUserId?user_id=' + encodeURIComponent(userId), true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    let response = JSON.parse(xhr.responseText);
                    if (response) {
                        document.getElementById('duplicateIdError').textContent = '아이디가 이미 존재합니다.';
                        document.getElementById('duplicateIdSuccess').textContent = '';
                        alert("아이디가 이미 존재합니다.");
                    } else {
                        document.getElementById('duplicateIdError').textContent = '';
                        document.getElementById('duplicateIdSuccess').textContent = '사용 가능한 아이디입니다.';
                    }
                } else {
                    document.getElementById('duplicateIdError').textContent = '아이디 확인 중 오류가 발생했습니다.';
                    document.getElementById('duplicateIdSuccess').textContent = '';
                }
            }
        };
        xhr.send();
    });
});