<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useInformationBoard</title>
<style>
table#board {
    width: 1250px;
    border-collapse: collapse;
    border-top: 2px #ADADAD solid;
    border-bottom: 2px #ADADAD solid;
}

table#board th {
    background: #F7F7F7;
}

table#board th, table#board td {
    height: 50px;
    border-bottom: 2px #D7D7D7 solid;
    text-align: center;
}
.hidden {
    display: none;
}
</style>
</head>
<body>
    <table id="board">
        <caption id="caption"
            style="margin-bottom: 40px; font-size: 2em; font-weight: bold;"></caption>
        <thead>
            <tr id="table-header"></tr>
        </thead>
        <tbody>
        	<c:choose>
            	<c:when test="${param.condition == 'rentHistory'}">
                    <c:forEach var="history" items="${list}">
                        <tr>
                            <td>${history.no}</td>
                            <td>${history.rentNum}</td>
                            <td>${history.bookTitle}</td>
                            <td>${history.rentDate}</td>
                            <td>${history.returnDate}</td>
                            <td>${history.status}</td>
                            <td><!-- 기록 제거 버튼 또는 기타 내용 --></td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:when test="${param.condition == 'borrow'}">
                    <c:forEach var="borrow" items="${list}">
                        <tr>
                            <td>${borrow.no}</td>
                            <td>${borrow.rentNum}</td>
                            <td>${borrow.bookTitle}</td>
                            <td>${borrow.rentDate}</td>
                            <td>${borrow.returnDate}</td>
                            <td>${borrow.status}</td>
                            <td><!-- 대출 연장 버튼 또는 기타 내용 --></td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:when test="${param.condition == 'reserve'}">
                    <c:forEach var="reserve" items="${list}">
                        <tr>
                            <td>${reserve.no}</td>
                            <td>${reserve.reservationId}</td>
                            <td>${reserve.bookTitle}</td>
                            <td>${reserve.reservationDate}</td>
                            <td>${reserve.reservationRank}</td>
                            <td>${reserve.availability}</td>
                            <td><!-- 예약 취소 버튼 또는 기타 내용 --></td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:when test="${param.condition == 'interest'}">
                    <c:forEach var="interest" items="${list}">
                        <tr>
                            <td>${interest.no}</td>
                            <td>${interest.interestId}</td>
                            <td>${interest.bookTitle}</td>
                            <td>${interest.bookAuthor}</td>
                            <td>${interest.availability}</td>
                            <td><!-- 대출 신청 버튼 --></td>
                            <td><!-- 관심 도서 제거 버튼 --></td>
                        </tr>
                    </c:forEach>
                </c:when>
            </c:choose>
        </tbody>
    </table>
    <script>
    let condition = "${param.condition}";
    let tableHeader = document.getElementById("table-header");
    let caption = document.getElementById("caption");

    let th1, th2, th3, th4, th5, th6, th7;
    if(condition == "rentHistory"){
        th1 = "No";
        th2 = "등록번호";
        th3 = "신청도서정보";
        th4 = "대출일";
        th5 = "반납일";
        th6 = "상태";
        th7 = "기록제거";
        caption.innerHTML = "전체 대출 이력";
    }
    else if(condition == "borrow"){
        th1 = "No";
        th2 = "등록번호";
        th3 = "신청도서정보";
        th4 = "대출일";
        th5 = "반납일";
        th6 = "상태";
        th7 = "대출연장";
        caption.innerHTML = "대출중인 도서";
    }
    else if(condition == "reserve"){
        th1 = "No";
        th2 = "등록번호";
        th3 = "신청도서정보";
        th4 = "신청일";
        th5 = "예약순위";
        th6 = "상태";
        th7 = "예약취소";
        caption.innerHTML = "신청한 예약도서";
    }
    else if(condition == "interest"){
        th1 = "No";
        th2 = "등록번호";
        th3 = "관심도서제목";
        th4 = "관심도서저자";
        th5 = "상태";
        th6 = "대출신청";
        th7 = "관심도서제거";
        caption.innerHTML = "관심도서 조회";
    }
    tableHeader.innerHTML = `
        <th>\${th1}</th>
        <th>\${th2}</th>
        <th>\${th3}</th>
        <th>\${th4}</th>
        <th>\${th5}</th>
        <th>\${th6}</th>
        <th>\${th7}</th>
    `;
    </script>
</body>
</html>
