<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userUseInformation</title>
<link href="css/public/header.css" type="text/css" rel="stylesheet">
<link href="css/public/footer.css" type="text/css" rel="stylesheet">
<link href="css/userUseInformation.css" type="text/css" rel="stylesheet">
<link href="css/public/nav.css" type="text/css" rel="stylesheet">
</head>
<body>
    <jsp:include page="../index/header.jsp" />
    <nav class="bannerBgr">
        <div class="Banner">
            <div class="pageTitle">도서 이용정보</div>
            <div class="pageRoute">홈 > 도서 이용정보</div>
        </div>
    </nav>
    <div class="container" style="margin-top: 64px;">
        <main class="main">
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
							        <c:when test="${count.rent_count <= 5}">
							            대출 가능
							        </c:when>
							        <c:otherwise>
							            대출 불가능
							        </c:otherwise>
							    </c:choose>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="container" style="margin-top: 48px;">
                <div class="center Dheader" data-condition="rentHistory">
                    <span>전체 대출이력</span>
                </div>
                <div class="center Dheader" data-condition="borrow">
                    <span>대출중인 도서</span>
                </div>
                <div class="center Dheader" data-condition="reserve">
                    <span>신청한 예약도서</span>
                </div>
                <div class="center Dheader" data-condition="interest">
                    <span>관심도서 조회</span>
                </div>
            </div>
            <div class="container" style="margin-top: 60px;">
                <iframe src="useInformationBoard" width="1300" id="iframe" onload="initialLoadIframe()"></iframe>
            </div>
        </main>
    </div>
    <jsp:include page="../index/footer.jsp" />
    <script>
        
    </script>
</body>
</html>
