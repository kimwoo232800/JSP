<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/jsp;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//전송 데이터 수신
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("uid");
	
	// 데이터베이스 작업
	try{
		String host = "jdbc:mysql://127.0.0.1:3306/UserDB";
		String user = "root";
		String pass = "1234";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DELETE FROM `member` WHERE `uid`='"+uid+"'");
		conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	
	// 리스트 이동
	response.sendRedirect("./list.jsp");
%>