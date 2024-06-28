<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/CSS/userInfo.css" type="text/css" rel="stylesheet">
    <link href="/reset/reset.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/public/nav.css">
    <link href="css/userUseInformation.css" type="text/css" rel="stylesheet">
</head>

<jsp:include page="../index/header.jsp" />

<div class="outBanner">
    <div class="bannerBgr">
        <div class="Banner">
            <div class="pageTitle">마이페이지</div> 
            <div class="pageRoute">홈 > 마이페이지</div>
        </div>
    </div>
</div>
    
    <div class="outContainer">
    <div class="innerContainer">
<div class="userInfoPage">
        <div class="userInfoBox">
            <div class="userImage">
            <img src="images/account_box.png"></div>

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
        
        
<!--         위치 -->

                            <div class="container">
                                <div class="center btnbox">
                                    <table class="btn">
                                        <tr>
                                            <th>예약</th>
                                        </tr>
                                        <tr>
                                            <td>${count.reserve_count} / 5</td>
                                        </tr>
                                    </table>
                                </div>
                                <div style="width: 30px;"></div>
                                <div class="center btnbox">
                                    <table class="btn">
                                        <tr>
                                            <th>대출</th>
                                        </tr>
                                        <tr>
                                            <td>${count.rent_count} / 5</td>
                                        </tr>
                                    </table>
                                </div>
                                <div style="width: 30px;"></div>
                                <div class="center btnbox">
                                    <table class="btn">
                                        <tr>
                                            <th>나의 상태</th>
                                        </tr>
                                        <tr>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${count.rent_count <= 5}"> 대출 가능 </c:when>
                                                    <c:otherwise> 대출 불가능 </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="infoQuicks">
                                <div class="userInfoQuick">
                                    <div class="center Dheader" data-condition="rentHistory">
                                        <span>전체 대출이력</span>
                                    </div>
                                </div>
                                <div class="userInfoQuick">
                                    <div class="center Dheader" data-condition="borrow">
                                        <span>대출중인 도서</span>
                                    </div>
                                </div>
                                <div class="userInfoQuick">
                                    <div class="center Dheader" data-condition="reserve">
                                        <span>신청한 예약도서</span>
                                    </div>
                                </div>
                                <div class="userInfoQuick">
                                    <div class="center Dheader" data-condition="interest">
                                        <span>관심도서 조회</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--         여기까지가 infoQuicks -->
                        <div class="container">
                            <iframe src="useInformationBoard" width="1260" height="600" id="iframe"
                                onload="initialLoadIframe()">
                            </iframe>
                        </div>
                    </div>
                </div>


<!--     위치 -->
    
    <div class="container">
                <iframe src="useInformationBoard" 
                width="1260" height="200" 
                id="iframe" onload="initialLoadIframe()">
                </iframe>
            </div>
    
    
<div id="modalContainer" class="hidden">
		<div id="modalContent">
			<h3 style="text-align:center;"><b>정말로 계정을 삭제하시겠습니까?</b></h3>
			<br>
			<form action="userDelete" method="post" id="form">

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div style="display:flex; justify-content:center;">
				<input class="delete" type="submit" value="계정삭제">
				<input id="cancel" class="cancel" type="button" value="취소">
				</div>
				

			</form>
			<button id="modalCloseButton">
			<img src="images/x-icon.png" style="width:100%; height:auto;"></button>
		</div>
	</div>
	
	<script src="js/userInfo.js"></script>
	
	<jsp:include page="../index/footer.jsp" />
	
	
</body>
</html>
