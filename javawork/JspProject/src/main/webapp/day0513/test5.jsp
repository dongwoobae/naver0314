<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<h5 class="alert alert-danger">JSTL if,choose문 공부</h5>
	<fmt:requestEncoding value="UTF-8"/>
	<form action="./study5" method="post">
		<input type="text" name="nara">
		<br>
		<button type="submit">전송</button>
	</form>
	<c:choose>
		<c:when test="${param.nara=='하와이' }">
			<img src="./image/snoopyAvata/s1.JPG" width="50">
			<b style="color: red; background-color: yellow;">하와이는 바다가 아름다운 섬입니다</b>
		</c:when>
		<c:when test="${param.nara=='미국' }">
		<img src="./image/snoopyAvata/s10.JPG" width="50">
			<b style="color: white; background-color: blue;">미국은 돈이 많은 나라입니다</b>
		</c:when>
		<c:when test="${param.nara=='프랑스' }">
		<img src="./image/snoopyAvata/s5.JPG" width="50">
			<b style="color: red; background-color: blue;">프랑스는 에펠탑이 아름다운 나라입니다</b>
		</c:when>
		<c:when test="${param.nara=='스위스' }">
		<img src="./image/snoopyAvata/s6.JPG" width="50">
			<b style="color: white; background-color: red;">스위스는 알프스가 아름다운 나라입니다</b>
		</c:when>
		<c:otherwise>
		<img src="./image/snoopyAvata/s2.JPG" width="50">
			<b style="color: white; background-color: green;">${param.nara }, 어디가 아름다운 나라인가요?</b>
		</c:otherwise>
	</c:choose>
</body>
</html>











