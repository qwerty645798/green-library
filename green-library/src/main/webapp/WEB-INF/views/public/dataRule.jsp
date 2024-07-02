<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <link href="/css/public/header.css" type="text/css" rel="stylesheet">
	<link href="/css/public/footer.css" type="text/css" rel="stylesheet">
    <link href="/css/dataRule.css" type="text/css" rel="stylesheet">
    <link href="/css/public/nav.css" type="text/css" rel="stylesheet">
</head>
<body>

<jsp:include page="../index/header.jsp" />

    <div class="bannerBgr">
        <div class="Banner">
            <div class="pageTitle">자료 이용 안내</div> <div class="pageRoute">홈 > 이용안내</div>
        </div>
    </div>
    
<div class="title_container">
	<h1>도서관 이용 규칙 안내</h1>
</div>
	<hr class="hr1">
	
	
	
	<jsp:include page="../public/navBarUse.jsp" />
	
	<div class="icon_container">
	<div class="icon_box">
	<img src="/images/calendarColor.png">
	대출 기간 <br> 14일~21일
	</div>
	<div class="icon_box">
	<img src="/images/bookGreen.png">
	대출가능 권수 <br> 1인당 5권
	</div>
	<div class="icon_box">
	<img src="/images/bookGreen.png">
	대출 반납 <br> 도서관 또는 반납함
	</div>
	</div>
	

<div class="useTable">

    <table>

        <tr>
            <td class="useTableItem">대출 자격</td>
            <td>&nbsp;&nbsp;그린도서관 회원이며 회원증이 있는 사람.</td>
        </tr>

        <tr>
            <td class="useTableItem">대출 기간</td>
            <td>
                <ul>
                    <li>14일. 연장은 1회만 가능하며, 1주일 연장하실 수 있습니다. </li>
                    <li>대출 예약이 되어있거나, 하루 이상 연체한 경우 연장이 불가능합니다.</li>
                </ul>
                
                
            </td>
        </tr>

        <tr>
            <td class="useTableItem">대출 권수</td>
            <td>&nbsp;&nbsp;1인당 5권.</td>
        </tr>

        <tr>
            <td class="useTableItem">대출 반납</td>
            <td>
                <ul>
                    <li>도서관 또는 반납함에 반납하실 수 있습니다. </li>
                    <li>반납함은 도서관 운영시간 이후에만 운영되며, 반납함에 반납하신 도서는 다음날 반납 처리됩니다.</li>
                    <li>정해진 기간 내에 반납하지 않으시면 불이익이 있을 수 있습니다. 자세한 건 대출 연체 및 정지 부분 참고.</li>
                </ul>
                
                
               
            </td>
        </tr>

        <tr>
            <td class="useTableItem">대출 연체 및 정지</td>
            <td>
                <ul>
                    <li>연체할 경우 연체한 기간 동안 대출이 불가하며 대출 연장을 하실 수 없습니다. </li>
                    <li>3개월이 지나면 연체 이력이 삭제됩니다.</li>
                    <li>장기 연체(3개월 이상) 경우 해당 회원은 회원 자격을 박탈당합니다.</li>
                </ul>
                
                 
                
            </td>
        </tr>

        <tr>
            <td class="useTableItem">대출 예약</td>
            <td>
                <ul>
                    <li>대출 중인 책일 경우 회원에 한해 대출 예약이 가능합니다. </li>
                    <li>대출 예약 후, 본인의 차례가 왔을 때 3일 내에 대출하지 않으시면 예약이 취소되고 다음 사람에게로 차례가 넘어갑니다.</li>
                    <li>한 도서당 3명까지만 가능합니다. 1인당 한 번에 5권까지만 예약할 수 있습니다.</li>
                </ul>
                
                
                
            </td>
        </tr>

        <tr>
            <td class="useTableItem">도서 변상</td>
            <td>&nbsp;&nbsp;도서를 분실하거나 훼손한 경우, 같은 도서로 구입하여 변상합니다.</td>
        </tr>

    </table>

</div>

<jsp:include page="../index/footer.jsp" />

</body>
</html>