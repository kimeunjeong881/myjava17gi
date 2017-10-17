<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 비자바코드 (템플릿코드)
 자바변수포함 jsp표현태그
 영역속성포함 EL표현태그) -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 리스트 - 관리자 페이지</h1>
		<table class="list">
			<tr>
			<!-- 상품 등록행 -->
				<td colspan="5" style="border: white; text-align: right"><a
					href="productWrite.do">상품 등록</a></td>
			</tr>
			<tr>
			<!-- 상품 열제목행 -->
				<th>번호</th>
				<th>이름</th>
				<th>가격</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<!--  productList에 저장된 VO를 
			product에 반복 대입 및 출력-->
			<c:forEach var="product" items="${productList}">
				<tr class="record">
				<!-- VO.속성 -->
					<td>${product.code}</td>
					<td>${product.name}</td>
					<td>${product.price} 원</td>
					<!-- 링크에 EL이 허용 -->
					<td><a href="productUpdate.do?code=${product.code}">상품 수정</a></td>
					<td><a href="productDelete.do?code=${product.code}">상품 삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>