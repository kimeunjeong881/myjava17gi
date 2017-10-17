<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%

Map<String, Object> model 
=(Map<String, Object>)request.getAttribute("model");
// 키집합에서 각각의 키값 구함 
for(String key:model.keySet()){
	out.print(model.get(key)+"<br>");
}

%>


</body>
</html>