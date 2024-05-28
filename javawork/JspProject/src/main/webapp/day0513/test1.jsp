<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--????????-->
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!--???-->
<link
	href="https://fonts.googleapis.com/css2?family=Dokdo&family=Dongle&family=Gaegu&family=Gowun+Batang&family=Reem+Kufi+Fun:wght@400..700&family=Song+Myung&family=Dancing+Script&family=Tilt+Neon&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
@font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://fastly.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 400;
	font-style: normal;
}

body * {
	font-family: "Pretendard-Regular";
}
</style>
</head>
<body>
	<h5 class="alert alert-danger">JSTL 공부#1</h5>
	<h6>일단 서블릿에서 저장한 request 변수 읽어오기</h6>
	<h6>메세지 : ${message }, ${requestScope.message }</h6>
	<!--requestScope. 은 생략 가능 -->
	<h6>날짜 : ${today }</h6>
	<h3>숫자 1: ${num1 }</h3>
	<h3>숫자 2: ${num2 }</h3>
	<hr>
	<h3>JSTL의 연산자</h3>
	<h5>더하기 : ${num1+num2}</h5>
	<h5>빼기 : ${num1-num2}</h5>
	<h5>곱하기 : ${num1*num2}</h5>
	<h5>나누기 : ${num1/num2}</h5>
	<h5>나누기 : ${num1 div num2}</h5>
	<h5>나머지 : ${num1%num2}</h5>
	<h5>나머지 : ${num1 mod num2}</h5>
	<hr>
	<h5>간단한 if문 (JSTL 에는 else 문은 없다)</h5>
	<c:if test="${num1>num2 }">
		<h4>숫자 1 이 숫자2 보다 더 큽니다</h4>
	</c:if>
	<c:if test="${num1<num2 }">
		<h4>숫자 1 이 숫자2 보다 더 작습니다</h4>
	</c:if>
	<hr>
	<h5>jsp에서 직접 JSTL로 변수 선언을 하고자 할 경우</h5>
	<c:set var="name" value="이영자"></c:set>
	<c:set var="age" value="19"></c:set>
	<h5>이름 : ${name }</h5>
	<h5>나이 : ${age }</h5>
</body>
</html>