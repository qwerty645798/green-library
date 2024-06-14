<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 정보</title>

<link rel="stylesheet" type="text/css" href="css/bookDetail.css">
<link rel="stylesheet" type="text/css" href="css/public/nav.css">

</head>
<body>

<header id="header" class="header"></header>

<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">도서 상세 정보</div> <div class="pageRoute">홈 > 도서 상세 정보</div>
    </div>
</div>

<main>

<%
	String url ="jdbc:oracle:thin:@//localhost:1521/XE";
	String username ="springboot";
	String password ="1234";
	
	Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try{
       	Class.forName("oracle.jdbc.OracleDriver");
       	conn = DriverManager.getConnection(url, username, password);
       	
       	String sql = "Select books.title, books.isbn, authors.author_name, books.img, books.location, books.availability, books.summary "
       			+"from books join authors on books.author_id = authors.author_id";
       	//+ where books.book_id=?? 같이 조건 추가해서 가져오는? book_id가 pk임
       	pstmt = conn.prepareStatement(sql);
       	rs = pstmt.executeQuery();
       	
       	if(rs.next()){
        	String title = rs.getString("title");
        	int isbn = rs.getInt("isbn");
        	String author_name = rs.getString("author_name");
        	String location = rs.getString("location");
        	String availability = rs.getString("availability");
        	String summary = rs.getString("summary");
        	String img = rs.getString("img");
        	
        	if(availability!=null){
        		if(availability.equals("1")){
            		availability = "대출가능";
            	}else{
            		availability = "대출불가";
            	}
        	}else{
        		availability = "알수없음";
        	}
        			
%>

<div class="bigDiv">
	<div class="book_container"><!-- 좌 이미지 우 테이블 -->
		<div class="book_image">
			<img src="images/<%= img %>">
		</div>
		<div class="book_table">
			<table>
			
			
				<tr>
					<th>대출도서명</th>
					<td>&nbsp;&nbsp;<%= title %></td>
					<th>등록 번호</th>
					<td>&nbsp;&nbsp;<%= isbn %></td>
				</tr>
				<tr>
					<th>저자명</th>
					<td colspan="3">&nbsp;&nbsp;<%= author_name %></td>
				</tr>
				<tr>
					<th>서가 위치</th>
					<td colspan="3">&nbsp;&nbsp;<%= location %></td>
				</tr>
				<tr>
					<th>대출 상태</th>
					<td colspan="3">&nbsp;&nbsp;<%= availability %></td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="border:none;"><!-- 예약 기능 구현 후 수정 -->
						<form action="" method="">
						<input type="submit" value="대출 예약">
						</form>
					</td>
				</tr>
				
							
			</table>	
		</div>
	</div>
</div>

<div class="book_container2">
	<h2>&nbsp;&nbsp;&nbsp;책소개</h2>
	<hr>
	&nbsp;&nbsp;&nbsp;<%= summary %>	
</div>

<%
    	}
	}catch(ClassNotFoundException e){
       	e.printStackTrace();
    }catch(SQLException e){
    	e.printStackTrace();
    }finally{
    	try{
       		if(conn!=null) conn.close();
       		if(pstmt!=null) pstmt.close();
       		if(rs!=null) rs.close();	            		
       	}catch(SQLException e){
       		e.printStackTrace();
       	}
    }
%>
</main>

<footer id="footer" class="footer"></footer>


</body>
</html> 