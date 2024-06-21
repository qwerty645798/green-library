<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/CSS/userInfo.css" type="text/css" rel="stylesheet">
    <link href="/reset/reset.css" type="text/css" rel="stylesheet">
    <script>
	    let success = "${param.success}";
	    if (success == "true") {
	        alert("회원정보가 수정되었습니다.");
	    }
    </script>
</head>
<body>
<div class="noname">
    <div class="bannerBgr">
        <div class="userInfoBanner">
            <div class="myPage">마이페이지</div> <div class="pageRoute">홈 > 마이페이지</div>
        </div>
    </div>
   

    <div class="userInfoPage">
        <div class="userInfoBox">
            <div class="userImage"><img src=""></div>

            <div class="userInfoContent">

                <table>
                    <tr>
                        <td class="infoItems">이름</td>
                        <td>${userInfo.name }</td>
                        <td class="infoItems">아이디</td>
                        <td>${userInfo.user_id }</td>
                    </tr>
                    <tr>
                        <td class="infoItems">생년월일</td>
                        <td>${userInfo.birth }</td>
                        <td class="infoItems">휴대폰 번호</td>
                        <td>${userInfo.phone }</td>
                    </tr>
                    <tr>
                        <td class="infoItems">이메일 주소</td>
                        <td colspan="3">${userInfo.email }</td>
                    </tr>
                </table>
               
            </div>

            <div class="infoBtn">
                <input type="button" value="회원정보 수정" onclick="location='userInfoModification'">
                <input type="button" value="회원 탈퇴" id="modalOpenButton">
                <form action="logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="submit" value="로그아웃" id="logout"></form>
            </div>
        </div>

        <div class="infoQuicks">
            <div class="userInfoQuick">전체 대출 이력</div>
            <div class="userInfoQuick">대출 중인 도서</div>
            <div class="userInfoQuick">관심도서 조회</div>
            <div class="userInfoQuick">신청한 예약도서</div>
        </div>
        
    </div>
</div>
<div id="modalContainer" class="hidden">
		<div id="modalContent">
			<h3 style="text-align:center;"><b>정말로 계정을 삭제하시겠습니까?</b></h3>
			<br>
			<form action="userDelete" method="post" id="form">
				<div style="display:flex; justify-content:center;"><input type="submit" value="계정삭제" style="color:white; background:#0D2E8C; width:120px; height:35px; margin-top:30px; cursor:pointer;" ></div>
			</form>
			<button id="modalCloseButton"><img src="images/x-icon.png" style="width:100%; height:auto;"></button>
		</div>
	</div>
	<script src="js/userInfo.js"></script>
</body>
</html>