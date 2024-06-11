<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="/reset/reset.css" type="text/css" rel="stylesheet">
        <link href="/CSS/hopeBookApply.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <div class="hopeBookPage">
            <form class="requestForm" action="" name="">
                *는 필수 입력 항목입니다.<br><br>
    
                <table>
    
                    <tr>
                        <td class="hopeBook"><p>*</p>신청자 이름</td>
                        <td><input type="text" name="name"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><p>*</p>신청 일자</td>
                        <td><input type="text" name="reqDate"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><p>*</p>도서명</td>
                        <td><input type="text" name="title"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><p>*</p>저자명</td>
                        <td><input type="text" name="author"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><p>*</p>출판사</td>
                        <td><input type="text" name="publisher"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><p>*</p>발행년도</td>
                        <td><input type="text" name="bookYear"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><p>*</p>가격</td>
                        <td><input type="text" name="price"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><p>*</p>ISBN</td>
                        <td><input type="text" name="isbn"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook">휴대폰 번호</td>
                        <td><input type="text" name="phone" placeholder="-를 제외하고 입력해주세요."></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook">첨부파일</td>
                        <td><input type="file" name="bookImg"></td>
                    </tr>
                </table>
    
                <br>
    
                <div class="hopeBtn">
                    <input type="submit" value="신청하기">&nbsp;
                    <input type="button" value="목록으로">
                </div>
    
               
        
            </form>
        </div>
    
    </body>
    </html>