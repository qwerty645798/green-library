<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="/css/reset/reset.css" type="text/css" rel="stylesheet">
        <link href="/css/public/header.css" type="text/css" rel="stylesheet">
		<link href="/css/public/footer.css" type="text/css" rel="stylesheet">
        <link href="/css/hopeBookApply.css" type="text/css" rel="stylesheet">
        <link href="/css/public/nav.css" type="text/css" rel="stylesheet">
        
    </head>
    <body>
    
        <jsp:include page="index/header.jsp" />
    
          <!-- 배너 시작 -->
          <div class="bannerBgr">
            <div class="Banner">
                <div class="pageTitle">희망도서 신청</div> <div class="pageRoute">홈 > 희망도서 신청</div>
            </div>
        </div>
         <!-- 배너 끝 -->
            
        <div class="hopeBookPage1">
            <div class="hopeBookPage2">
            
            <form id="form" class="requestForm" method = "post" action="wishCreate" onsubmit="return hopeApplyCheck()">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="hidden" name="userId" value="${userId}">
			
                <span class="star">*</span>
                <span class="word">&nbsp;는 필수 입력 항목입니다.</span><br><br>
    
                <table>
    
                    <tr>
                        <td class="hopeBook"><span class="star">*</span> 신청자 이름</td>
                        <td>${userId}</td>
                    </tr>
                    <!-- 접속했을 때 입력할 필요 없이 이미 입력한 상태였으면 좋겠음 -->
    
                    <!-- <tr>
                        <td class="hopeBook"><span>*</span>신청 일자</td>
                        <td><div id="hopedate"></div></td>
                    </tr> -->
                     <!-- 접속했을 때 입력할 필요 없이 이미 입력한 상태였으면 좋겠음 -->
    
                    <tr>
                        <td class="hopeBook"><span class="star">*</span>도서명</td>
                        <td><input type="text" id="title" name="wishTitle"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><span class="star">*</span>저자명</td>
                        <td><input type="text" id="author" name="wishAuthor"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><span class="star">*</span>출판사</td>
                        <td><input type="text" id="publisher" name="wishPublisher"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><span class="star">*</span>발행년도</td>
                        <td><input type="text" id="bookYear" name="wishPublication"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><span class="star">*</span>가격</td>
                        <td><input type="text" id="price" name="wishPrice"></td>
                    </tr>
    
                    <tr>
                        <td class="hopeBook"><span class="star">*</span>ISBN</td>
                        <td><input type="text" id="isbn" placeholder="바코드 위의 숫자를, -를 제외하고 입력해주세요." name = "wishIsbn"></td>
                    </tr>
    
                    <!-- <tr>
                        <td class="hopeBook">휴대폰 번호</td>
                        <td><input type="text" id="phone" placeholder="-를 제외하고 입력해주세요."></td>
                    </tr> -->
    
              
                </table>
    
                <br>
    
                <div class="hopeBtn">
                    <input type="submit" value="신청하기" >&nbsp;
                    <a href="myWritten"><input type="button" value="목록으로"></a>
                </div>
        
            </form>
    
            </div>
        </div>
        
    <jsp:include page="index/footer.jsp" />
  
    <script src="/js/hopeBookApply.js" type="text/javascript"></script>
    </body>
    </html>