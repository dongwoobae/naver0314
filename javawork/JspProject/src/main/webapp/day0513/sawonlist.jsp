<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

td {
	height: 200px;
	line-height: 200px;
	text-align: center;
}
</style>
</head>
<body>
	<h5 class="alert alert-danger">bitcamp 사원목록</h5>
	<!-- table을 이용해서 사원목록 출력하기
	번호|사진|사원명|부서명|나이|생일 -->
	<fmt:requestEncoding value="UTF-8" />
	<form action="sawon" method="post">
		<b>부서명 입력</b> <input type="text" name="search" style="width: 120px;">
		<button type="submit">검색</button>
	</form>
	<hr>
	<h2>${param.search } 부서직원 검색결과</h2>
	<table class="table table-striped" style="width: 700px;">
		<tr class="alert alert-info" style="text-align: center;">
			<th width="50">번호</th>
			<th width="50">사번</th>
			<th width="200">프로필 사진</th>
			<th width="80">사원명</th>
			<th width="90">부서명</th>
			<th width="50">나이</th>
			<th>생일</th>
		</tr>

		<c:forEach var="a" items="${list }" varStatus="n">
			<c:if test="${fn:containsIgnoreCase(a.buseo,param.search) or param.search eq null}">
				<tr>
					<td>${n.count }</td>
					<td>${a.num }</td>
					<td>
						<!-- <c:if test="${a.photo}"><img~~~></c:if>로 if 문을 써서 처리도 가능 -->
						<img src="${a.photo }" width="180"
						onerror="this.src='../image/noimage1.png'">
					</td>
					<td>${a.name }</td>
					<td>${a.buseo }</td>
					<td>${a.age }세</td>
					<td>${a.birthday }</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>