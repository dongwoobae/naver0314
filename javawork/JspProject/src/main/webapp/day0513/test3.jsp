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
	<h5 class="alert alert-danger">JSTL 공부#3</h5>
	<h5>list1 색상표 출력</h5>
	<table class="table table-bordered" style="width: 200px;">
		<tr>
			<th>번호</th>
			<th>색상표</th>
			<th>색상</th>
		</tr>
		<!-- for문 일일히 써넣는거 대신에 c:forEach를 이용해서 가능 -->
		<c:forEach var="s" items="${list1 }" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${s }</td>
				<td style="background-color:${s}"></td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<h5>Shop 데이터 출력</h5>
	<table class="table table-striped"
		style="width: 600px; text-align: center;">
		<tr>
			<th width="50">번호</th>
			<th width="150">상품명</th>
			<th width="100">가격</th>
			<th width="70">수량</th>
			<th width="80">색상</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="dto" items="${shoplist }" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<!-- 이미지의 파일이름만 저장하는것이 좋음
				경로까지 저장 시 현재 파일 기준으로 다시 지정해주어야하는 번거러움이 생김 -->
				<td><img src="${dto.sphoto }"
					style="width: 40px; height: 40px; border: 1px solid gray;">
					${dto.sname }</td>
				<td align="right"><fmt:formatNumber value="${dto.sprice }"
						type="number"></fmt:formatNumber>원</td>
				<td>${dto.scount }개</td>
				<td style="background-color:${dto.scolor}"></td>
				<td><fmt:formatDate value="${dto.writeday }"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>