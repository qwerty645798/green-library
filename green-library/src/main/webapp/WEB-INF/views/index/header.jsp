<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Green Library</title>
        <link href="/css/public/header.css" type="text/css" rel="stylesheet">
        
    </head>
    <body>
    
    <header>
    
      <div class="header1">
	      <div class="center">
	        <div class="headerTop">
	          <div class="logo">
	          <a href="/">로고</a>
	          </div>
		          	<sec:authorize access="isAuthenticated()">
				        <div>환영합니다, <b><sec:authentication property="name"/>님!</b> &nbsp;</div>
				        <form action="logout" method="post"> 
				        <label>
				        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		                <img class="logout" src="images/logout.png">
		                <input class="bye" type="submit" value="로그아웃" >
				        </label>
		                </form>
				    </sec:authorize>
					</div>
				    <sec:authorize access="!isAuthenticated()">
				        <div id="login" class="loginLink">로그인 /</div>
		          		<div id="userjoin" class="joinLink">회원가입</div>
				    </sec:authorize>
	      </div>
        
          
            <div class="headerBottom">
              <ul id="subMenuTop" class="subMenuTop">
                <li>도서관 소개</li>
                <li>도서관 이용</li>
                <li>자료 검색</li>
                <li>도서관 소식</li>
                <li>마이페이지</li>
              </ul>
            </div>
          
            <div class="menuBarBackground">
              <div id="subMenu" class="subMenu"><!-- 테스트용 -->
                <ul id="subMenu1" class="menuBar">
                  <li>도서관 비전</li>
                  <li>사업 구조</li>
                  <li></li>
                  <li></li>
                  <li></li>
                </ul>
              
                <ul id="subMenu2" class="menuBar">
                  <li>오시는 길</li>
                  <li>이용시간 안내</li>
                  <li>자료이용 안내</li>
                  <li>부대시설 소개</li>
                  <li>희망도서 신청</li>
                </ul>
              
                <ul id="subMenu3" class="menuBar">
                  <li>통합자료검색</li>
                  <li>인기 도서</li>
                  <li>신착 도서</li>
                  <li></li>
                  <li></li>
                </ul>
              
                <ul id="subMenu4" class="menuBar">
                  <li>공지사항</li>
                  <li>문의사항</li>
                  <li>자주 묻는 질문</li>
                  <li>도서관 일정</li>
                  <li></li>
                </ul>
              
                <ul id="subMenu5" class="menuBar">
                  <li>회원정보수정</li>
                  <li>대출 연장</li>
                  <li>약관 재동의</li>
                  <li>내가 쓴 글</li>
                  <li>문의하기</li>
                </ul>
              </div><!-- testcon -->
              
            </div>
            
         
      </div>
    
     
      
    </header>
    
    <script src="/js/header.js" type="text/javascript"></script>
      
    </body>
    </html>