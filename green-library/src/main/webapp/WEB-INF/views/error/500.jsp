<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="css/errorPage.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="container">
    <H1>${message }</H1>

    <ul class="helpText">
        <li><span>다음과 같은 방법을 시도해 볼 수 있습니다.</span></li>
        <li>새로고침을 해 주세요.</li>
        <li>와이파이 상태를 확인해 주세요.</li>
        <li>방화벽의 설정을 확인해 주세요.</li>
    </ul>

    <br>

    <ul>
        <li><span>다음과 같은 방법을 시도했음에도 문제가 해결되지 않는다면,<br>
고객센터로 문의해 주세요.</span></li>
        <li>고객센터: 02-222-2222</li>
        <li>이메일: abcabc@naver.com</li>
    </ul>

    <a href="../">
        <img src="images/home.png">
        홈페이지로 돌아가기</a>

</div>



</body>
</html>