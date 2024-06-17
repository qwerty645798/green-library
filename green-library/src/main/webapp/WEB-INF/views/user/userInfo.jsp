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
                        <td></td>
                        <td class="infoItems">아이디</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="infoItems">생년월일</td>
                        <td></td>
                        <td class="infoItems">휴대폰 번호</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="infoItems">이메일 주소</td>
                        <td colspan="3"></td>
                    </tr>
                </table>
               
            </div>

            <div class="infoBtn">
                <input type="button" value="회원정보 수정">
                <input type="button" value="회원 탈퇴">
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

    
</body>
</html>