<%@page import="db.DBCP"%>
<%@page import="bean.CustomerBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/jsp;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	request.setCharacterEncoding("utf-8");
	String custId = request.getParameter("custId");
	
	CustomerBean cb = null;
	
	try{
		Connection conn = DBCP.getConnection();
		
		String sql = "SELECT * FROM `Customer` WHERE `custId`=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, custId);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			cb = new CustomerBean();
			cb.setCustId(rs.getString(1));
			cb.setName(rs.getString(2));
			cb.setAddress(rs.getString(3));
			cb.setPhone(rs.getString(4));
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>


<!DOCTYPE jsp>
<jsp>
	<head>
		<meta charset="UTF-8">
		<title>customer::modify</title>
	</head>
	<body>
		<h3>고객수정</h3>
		
		<a href="./index.jsp">처음으로</a>
		<a href="./list.jsp">고객목록</a>
		
		<form action="./modifyProc.jsp" method="post">
			<table border="1">
				<tr>
					<td>고객번호</td>
					<td><input type="text" name="custId" readonly value="<%= cb.getCustId() %>" /></td>
				</tr>
				<tr>
					<td>고객명</td>
					<td><input type="text" name="name" value="<%= cb.getName() %>"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="<%= cb.getAddress() %>" /></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="phone" value="<%= cb.getPhone() %>"  /></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</jsp>