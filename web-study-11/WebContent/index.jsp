<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//게시글 리스트 보여주기(R) 요청(이동,호출)을 BoardServlet (FC)로 함
response.sendRedirect("BoardServlet?command=board_list");
//response.sendRedirect("/web-study-11/BoardServlet?command=board_list");
//response.sendRedirect("/web-study-11/BoardServlet?command=board_list2");
%>
</body>
</html>