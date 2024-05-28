<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<h5 class="alert alert-danger">JSTL 공부#2</h5>
	<h5>서블릿에서 request에 저장된 변수 그대로 출력</h5>
	<h6>날짜: ${today }</h6>
	<h6>급여: ${money }</h6>
	<h6>점수: ${score }</h6>
	<hr>
	<h5>JSTL의 fmt 양식을 이용해서 다양하게 출력</h5>
	<h6 class="alert alert-info">다양한 날짜 양식들</h6>
	
	<!-- var로 변수 지정시 출력되지 않고 저장되는 형식 -->
	<h6><fmt:formatDate value="${today }" pattern="yyyy-MM-dd" var="date1"/></h6>
	<h6><fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm"/></h6>
	<h6><fmt:formatDate value="${today }" pattern="yyyy-MM-dd a hh:mm"/></h6>
	<h6><fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE" var="date2"/></h6>
	<h4>date1 : ${date1 }</h4>
	<h5 class="alert alert-success">다양한 숫자 양식들</h5>
	<h6>
		<!-- 앞에 화폐단위가 깨질 수가 있음 -->
		<fmt:formatNumber value="${money }" type="currency"></fmt:formatNumber>
	</h6>
	<h6>
		<fmt:formatNumber value="${money }" type="number"></fmt:formatNumber>원
	</h6>
	<!-- currency를 주면서 symbol에 지정해주면 안깨짐 -->
	<h6>
		<fmt:formatNumber value="${money }" type="currency" currencySymbol="￦"></fmt:formatNumber>
	</h6>
	<h6>
		score: ${score }
	</h6>
	<h6>
		<!-- 소수점 이하 두자리 -->
		<fmt:formatNumber value="${score }" maxFractionDigits="2"></fmt:formatNumber>
	</h6>
	<h6>
		<%-- 똑같이 소수점 2자리 --%>
		<fmt:formatNumber value="${score }" pattern="0.00"></fmt:formatNumber>
	</h6>
	<hr>
	<c:set var="num3" value="45.2"></c:set>
	<c:set var="num4" value="0.034"></c:set>
	<h6>num3: ${num3 }</h6>
	<h6>num4: ${num4 }</h6>
	<h6>
		<!-- #을 쓰면 소수점 이하가 0이면 생략 0을 쓰면 없어도 0으로 찍힌다 -->
		<fmt:formatNumber value="${num3}" pattern="0.00"></fmt:formatNumber>
	</h6>
	<h6>
		<!-- #을 쓰면 소수점 이하가 0이면 생략 0을 쓰면 없어도 0으로 찍힌다 -->
		<fmt:formatNumber value="${num3}" pattern="0.##"></fmt:formatNumber>
	</h6>
	<h6>
		<fmt:formatNumber value="${num4}" type="percent" maxFractionDigits="2"></fmt:formatNumber>
	</h6>
</body>
</html>