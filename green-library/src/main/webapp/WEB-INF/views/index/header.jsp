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
        
        <script src = "/js/commonWindowOnload.js"></script>
        
        
    </head>
    <body>
    
    <header>
    
      <div class="header1">
	      <div class="center">
	        <div class="headerTop">
	          <div class="logo">
	          <a href="/"><img src="/images/로고.png"></a>
	          </div>
		          	<sec:authorize access="isAuthenticated()">
				        <div>환영합니다, <a id="myPage" href="/user/userInfo"><b><sec:authentication property="name"/>님!</b></a> &nbsp;</div>
				        <form action="/logout" method="post"> 
				        <label>
				        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		                <img class="logout" src="/images/logout.png">
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
                  <li><a href="/vision">
                  도서관 비전</a></li>
                  <li></li>
                  <li></li>
                  <li></li>
                  <li></li>
                </ul>
              
                <ul id="subMenu2" class="menuBar">
                  <li><a href="/wayToCome">
                  오시는 길</a></li>
                  <li><a href="/placeUsetime">
                  이용시간 안내</a></li>
                  <li><a href="/dataRule">
                  자료이용 안내</a></li>
                  <li><a href="/facilityInfo">
                  부대시설 소개</a></li>
                  <li><a href="/user/hopeBookApply">
                  희망도서 신청</a></li>
                </ul>
              
                <ul id="subMenu3" class="menuBar">
                  <li><a href="/dataSearch">
                  통합자료검색</a></li>
                  <li><a href="/popularBook">
                  인기 도서</a></li>
                  <li><a href="/initiativeBook">
                  신착 도서</a></li>
                  <li></li>
                  <li></li>
                </ul>
              
                <ul id="subMenu4" class="menuBar">
                  <li><a href="/notification">
                  공지사항</a></li>
                  <li><a href="/oftenAsk">
                  자주 묻는 질문</a></li>
                  <li><a href="/schedule">
                  도서관 일정</a></li>
                  <li></li>
                </ul>
              
                <ul id="subMenu5" class="menuBar">
                  <li><a href="/user/userInfo">
                  내 프로필</a></li>
                  <li><a href="/user/userInfoModification">
                  회원정보수정</a></li>
                  <li><a href="/user/bookLoanExtension">
                  대출 연장</a></li>
                  <li><a href="/public/userAgreement">
                  약관 재동의</a></li>
                  <li><a href="/user/myWritten">
                  내가 쓴 글</a></li>
                  <li><a href="/user/userInquiryCreate">
                  문의하기</a></li>
                </ul>
              </div><!-- testcon -->
              
            </div>
            
         
      </div>
    
     
      
    </header>
    
    <script src="/js/header.js" type="text/javascript"></script>
      
    </body>
    </html>