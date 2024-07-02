<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <link href="/CSS/placeUsetime.css" type="text/css" rel="stylesheet">
    <link href="/CSS/public/nav.css" type="text/css" rel="stylesheet">
</head>
<body>

    <jsp:include page="../index/header.jsp" />

    <div class="bannerBgr">
        <div class="Banner">
            <div class="pageTitle">이용시간</div> <div class="pageRoute">홈 > 이용시간</div>
        </div>
    </div>
    
    <jsp:include page="../public/navBarUse.jsp" />
    
    <div class="title_container">
		<h1>그린도서관 이용 시간 안내</h1>
	</div>
	<hr class="hr1">

    <div class="usetimePage1">
        <div class="usetimePage2">
            <table>
                <tr>
                    <td class="itemBold"></td>
                    <td class="itemBold">평일</td>
                    <td class="itemBold">주말</td>
                </tr>
        
                <tr>
                    <td class="itemBold">어린이 자료실</td>
                    <td>9:00~18:00</td>
                    <td>9:00~17:00</td>
                </tr>
        
                <tr>
                    <td class="itemBold">시각장애인 자료실</td>
                    <td>9:00~18:00</td>
                    <td>9:00~17:00</td>
                </tr>
        
                <tr>
                    <td class="itemBold">종합자료실</td>
                    <td>9:00~21:00</td>
                    <td>9:00~17:00</td>
                </tr>
        
                <tr>
                    <td class="itemBold">디지털 자료실</td>
                    <td>9:00~21:00</td>
                    <td>9:00~17:00</td>
                </tr>
        
                <tr>
                    <td class="itemBold">일반 열람실</td>
                    <td>8:00~23:00</td>
                    <td>8:00~23:00</td>
                </tr>
        
                <tr>
                    <td class="itemBold">늘푸름 카페</td>
                    <td>9:00~22:00</td>
                    <td>9:00~17:00</td>
                </tr>
        
                <tr>
                    <td class="itemBold">휴게실</td>
                    <td>8:00~23:00</td>
                    <td>8:00~23:00</td>
                </tr>
            </table>
        </div>
        
    </div>

    

    <jsp:include page="../index/footer.jsp" />
    
</body>
</html>