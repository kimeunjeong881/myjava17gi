<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>요청파라미터 사용</h3>
<a href="BoardServlet?command=board_reply">답글</a><br>
<a href="BoardServlet2?command=board_reply">답글2</a>
<a href="BoardServlet2?command=board_reply_del">답글2 삭제</a>

<hr>
<h3>요청URI 사용</h3>
<a href="board/reply_add.do">답글2</a>
<a href="board/reply_del.do">답글2 삭제</a>

















</body>
</html>