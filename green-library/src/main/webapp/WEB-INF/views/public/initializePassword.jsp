<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InitializePassword</title>
<style>
html, body{
	width:100%;
	height:100%;
	display:flex;
	justify-content:center;
	align-items:center;
	flex-direction:column;
	background:#b59981;
	background-image:url("/images/woodLeaf.jpg");
	background-repeat:repeat;
	color:white;
	background-color: rgba(0, 0, 0, 0.2); /* 반투명 검정색 */
    background-blend-mode: multiply; /* 혼합 모드 설정 */
}
form{
	text-align:center;
}
input[type=password]{
	width:300px;
	height:40px;
	font-size:2em;
}
input[type=submit]{
	margin-top:20px;
	width:125px;
	height:50px;
	font-size:1.5em;
	background: green;
	border-radius : 2px;
	border: 1px solid gray;
	cursor: pointer;
	font-weight:bold;
	color:white;
}
h1{
	width:100%;
	text-align:center;
	font-size:3em; 
	margin:0px; 
	padding-top: 20px;
	padding-bottom: 20px;
	color: white;
	
}
</style>
</head>
<body>
<h1>비밀번호 초기화</h1>
<form action="initializePassword" method="post" id="form">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<input type="hidden" name="email" value="${email }">
<h3>새로운 비밀번호를 입력해주십시오.</h3>
	<input type="password" name="user_pass" id="pw">
<h3>다시 한번 더 입력해주십시오.</h3>
	<input type="password" id="pwcheck">
	<h3></h3>
	<input type="submit" value="확인">
</form>
<script>
document.addEventListener('DOMContentLoaded', function() {
    let form = document.getElementById("form");
    form.addEventListener('submit', function(e) {
        e.preventDefault();
        if (!Check()) {
            return;
        }
        const csrfToken = document.querySelector('input[name="_csrf"]').value;
        const formData = new FormData(form);
        formData.append("_csrf", csrfToken);
        fetch('/initializePassword', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            alert(data.message);
            if (data.success) {
                window.close();
            }
        })
        .catch(error => {
            alert("에러가 발생했습니다. 다시 시도해주세요.");
        });
    });

    const pswd = document.getElementById('pw');
    const passCheck = document.getElementById('pwcheck');
    const pswdRegexp = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#^*_])[A-Za-z\d!@#^*_]{8,20}$/;

    function Check() {
        if (pswd.value.length < 8 || pswd.value.length > 20) {
            alert("비밀번호는 8자에서 20자 사이여야 합니다.");
            pswd.focus();
            return false;
        }
        if (!pswdRegexp.test(pswd.value)) {
            alert("비밀번호는 숫자, 영문 대소문자, 특수문자 !, @, #, ^, *, _ 을 섞은 4가지 조합이어야 합니다.");
            pswd.focus();
            return false;
        }
        if (pswd.value !== passCheck.value || !passCheck.value) {
            alert("비밀번호가 틀렸습니다.");
            passCheck.focus();
            return false;
        }
        return true;
    }
});
</script>
</body>
</html>