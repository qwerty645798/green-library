<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>agreement</title>
<link href="/css/public/header.css" type="text/css" rel="stylesheet">
<link href="/css/public/footer.css" type="text/css" rel="stylesheet">
<link href="/css/public/nav.css" type="text/css" rel="stylesheet">
<link href="/css/userAgreement.css" type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../index/header.jsp" />
	<nav class="bannerBgr">
		<div class="Banner">
			<div class="pageTitle">회원정보수정</div>
			<div class="pageRoute">홈 > 회원정보수정</div>
		</div>
	</nav>
	
	<jsp:include page="../public/navBarMypage.jsp"/>
	
	<div class="container">
		<main>
			<form action="userJoin" method="get" id="myForm">
				<h2 style="margin-top:60px;">서비스 이용약관</h2>
				<div class="container">
					<div class="content">
						 <jsp:include page="agreement/agreement1.jsp" />
					</div>
				</div>
				<div style="font-weight:600; display:flex; margin-top:10px;"><input class="check" onclick="checkTotalBtn()" type="checkbox" name="agree" style="width:17px; height:17px;"> &nbsp;동의합니다.</div>
				<h2 style="margin-top:90px;">개인정보 수집·이용 안내</h2>
				<div class="container">
					<div class="content">
						<jsp:include page="agreement/agreement2.jsp" />
					</div>
				</div>
				<div style="font-weight:600; display:flex; margin-top:10px;"><input class="check" onclick="checkTotalBtn()" type="checkbox" name="agree" style="width:17px; height:17px;"> &nbsp;동의합니다.</div>
				<h2 style="margin-top:90px;">개인정보 처리 및 위탁 안내</h2>
				<div class="container">
					<div class="content">
						<jsp:include page="agreement/agreement3.jsp" />
					</div>
				</div>
				<div style="font-weight:600; display:flex; margin-top:10px;"><input class="check" onclick="checkTotalBtn()"type="checkbox" name="agree" style="width:17px; height:17px;"> &nbsp;동의합니다.</div>
				<h2 style="margin-top:90px;">개인정보 3자 제공 (선택)</h2>
				<div class="container">
					<div class="content">
						<jsp:include page="agreement/agreement4.jsp" />
					</div>
				</div>
				<div style="font-weight:600; display:flex; margin-top:10px;"><input class="check" onclick="checkTotalBtn()" type="checkbox" name="agree" style="width:17px; height:17px;"> &nbsp;동의합니다.</div>
				<div style="font-weight:600; display:flex; margin-top:10px;"><input id="totalCheck" onclick="checkBtn()" type="checkbox" name="agree" style="width:17px; height:17px;"> &nbsp;전체&nbsp;<span style="color:red;">서비스 이용약관</span>에 동의합니다.</div>
				<div class="container" style="margin-top:50px;">
				<input type="submit" value="확인"></div>
			</form>
		</main>
	</div>
	<jsp:include page="../index/footer.jsp" />
	<script src="/js/userAgreement.js"></script>
</body>
</html>