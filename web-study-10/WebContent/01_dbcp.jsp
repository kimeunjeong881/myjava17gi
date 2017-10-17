<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>디비 연동</h4>
	<%
	/*
	JNDI api: 
		자바자원을 디렉토리형식의 이름으로 식별 접근
	*/
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		//context.xml 톰켓DBCP자원 객체명 myoracle이 
		//lookup의 매개변수 일치
		DataSource ds = 
		(DataSource) envContext.lookup("jdbc/myoracle");
		//커넥션 대여 생성
		Connection conn = ds.getConnection();
		out.println("DBCP 연동 성공");
		// 커넥션 반납 해제
		conn.close();
	%>
</body>
</html>