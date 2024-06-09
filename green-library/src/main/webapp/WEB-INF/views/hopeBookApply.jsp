<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form class="requestForm" action="" name="">
        *는 필수 입력 항목입니다.

        *신청자 이름:<input type="text" name="name"><br>

        *신청 일자:<input type="text" name="reqDate"><br>

        *도서명:<input type="text" name="title"><br>

        *저자명:<input type="text" name="author"><br>

        *출판사:<input type="text" name="publisher"><br>

        *발행년도:<input type="text" name="bookYear"><br>

        *가격:<input type="text" name="price"><br>

        *ISBN:<input type="text" name="isbn"><br>

        휴대폰 번호:<input type="text" name="phone" placeholder="-를 제외하고 입력해주세요."><br>

        첨부파일:<input type="file" name="bookImg"><br>

        <input type="submit" value="신청하기">&nbsp;
        <input type="button" value="목록으로">

    </form>
</body>
</html>