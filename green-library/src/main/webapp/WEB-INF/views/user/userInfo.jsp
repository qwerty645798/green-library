<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="/css/userInfo.css" type="text/css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="/css/public/nav.css">
<link href="/css/userUseInformation.css" type="text/css" rel="stylesheet">
<Script>
	let message = "${message}";
	if(message)
		alert(message);
</Script>
</head>
<body>

	<jsp:include page="../index/header.jsp" />


	<div class="outBanner">
		<div class="bannerBgr">
			<div class="Banner">
				<div class="pageTitle">마이페이지</div>
				<div class="pageRoute">홈 > 마이페이지</div>
			</div>
		</div>
	</div>
	
	<div class="title_container">
	<h1>마이페이지</h1>
</div>
	<hr class="hr1">
	
	<jsp:include page="../public/navBarMypage.jsp"/>

	<div class="outContainer">
		<div class="innerContainer">
			<div class="userInfoPage">
				<div class="userInfoBox">
					<div class="userImage">
						<img src="/images/account_box.png">
					</div>

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
						<input type="button" value="회원정보 수정"
							id="modalOpenButton1"> <input
							type="button" value="회원 탈퇴" id="modalOpenButton">
						<form action="/logout" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="submit" value="로그아웃"
								id="logout">
						</form>
					</div>
				</div>



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
								<td><c:choose>
										<c:when test="${count.rent_count <= 5}">
						            대출 가능
							        </c:when>
										<c:otherwise>
							            대출 불가능
							        </c:otherwise>

									</c:choose></td>
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
			<div class="container">
				<iframe src="/user/useInformationBoard" width="1260" height="600"
					id="iframe" onload="initialLoadIframe()"> </iframe>
			</div>
		</div>

	</div>
	<div id="modalContainer" class="hidden">
		<div id="modalContent">
			<h3 style="text-align: center;">
				<b>정말로 계정을 삭제하시겠습니까?</b>
			</h3>
			<br>
			<form action="userDelete" method="post" id="form">

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div style="display: flex; justify-content: center;">
					<input class="delete" type="submit" value="계정삭제"> <input
						id="cancel" class="cancel" type="button" value="취소">
				</div>


			</form>
			<button id="modalCloseButton">
				<img src="/images/x-icon.png" style="width: 100%; height: auto;">
			</button>
		</div>
	</div>
	<div id="modalContainer1" class="hidden">
		<div id="modalContent1">
			<h4 style="text-align: center; margin-top:30px;">
				<b>회원정보 확인을 위해 비밀번호를 입력해주세요.</b>
			</h4>
			<form action="userPassCheck" method="post" id="form">

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
					
				<div style="display: flex; justify-contents:center; align-items:center; flex-direction:column">
					<input type="password" name="user_pass" style="width:200px; height:30px; font-size:2em; ">
					<input type="submit" value="확인" id="userCheckPass">
				</div>


			</form>
			<button id="modalCloseButton1">
				<img src="/images/x-icon.png" style="width: 100%; height: auto;">
			</button>
		</div>
	</div>
	<script src="/js/userInfo.js"></script>

	<jsp:include page="../index/footer.jsp" />
	<script>
	document.addEventListener('DOMContentLoaded', function() {
        fetchDataAndSendToIframe('rentHistory');
    });
    
    document.querySelectorAll('.Dheader').forEach(header => {
        header.addEventListener('click', function() {
            let condition = this.getAttribute('data-condition');
            fetchDataAndSendToIframe(condition);
        });
    });

    function initialLoadIframe() {
        fetchDataAndSendToIframe('rentHistory');
    }

    function iframeHeight(condition, data) {
        let iframe = document.getElementById('iframe');
        if (data.length < 10) {
            iframe.style.height = 720 - (10 - data.length) * 34 + "px";
        } else {
            iframe.style.height = "720px";
        }
    } 

    function fetchDataAndSendToIframe(condition) {
        fetch(`/user/getUserData`)
            .then(response => response.json())
            .then(data => {
                let iframe = document.getElementById('iframe');
                iframe.contentWindow.postMessage({ condition: condition, data: data[condition] }, '*');
                iframeHeight(condition, data[condition]);
            })
            .catch(error => console.error('Error fetching data:', error));
    }
	</script>
</body>
</html>