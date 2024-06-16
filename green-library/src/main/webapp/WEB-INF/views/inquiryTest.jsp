<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>문의글 등록</title>
</head>
<body>

<%
	String user_id=request.getParameter("user_id");
	String inquiry_title = request.getParameter("inquiry_title");
	String contents = request.getParameter("contents");

	String url ="jdbc:oracle:thin:@//localhost:1521/XE";
	String username ="springboot";
	String password ="1234";
	
	Connection conn = null;
    PreparedStatement pstmt = null;
    
    String sql="Insert into inquiries(user_id, inquiry_title, contents) values(?, ?, ?)";
    
    try{
    	Class.forName("oracle.jdbc.OracleDriver");
    	conn = DriverManager.getConnection(url, username, password);
    	pstmt = conn.prepareStatement(sql);
    	
    	pstmt.setString(1, user_id);
    	pstmt.setString(2, inquiry_title);
    	pstmt.setString(3, contents);
    	
    	int a = pstmt.executeUpdate();
    	
    	response.sendRedirect("myWritten");
    }catch(SQLException e){
    	e.printStackTrace();
    }finally{
    	try {
	    	if (pstmt != null) pstmt.close();
	    	if (conn != null) conn.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    
%>
</body>
</html>