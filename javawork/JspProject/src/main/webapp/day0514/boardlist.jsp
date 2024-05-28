<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<button type="button" class="btn btn-sm btn-outline-success"
		onclick="location.href='./form'">
		<i class="bi bi-pencil-fill"></i> 글쓰기
	</button>
	<div style="margin: 20px; font-size: 25px;">총 ${totalCount } 개의
		게시글이 있습니다</div>
	<table class="table table-striped"
		style="width: 600px; text-align: center;">
		<tr class="table-danger">
			<th width="50">번호</th>
			<th width="150">제목</th>
			<th width="80">작성자</th>
			<th>작성일</th>
			<th width="50">추천</th>
			<th width="70">조회수</th>
		</tr>
		<c:if test="${totalCount eq 0 }">
			<tr height="100">
				<td colspan="5" align="center" valign="middle">
					<h4>등록된 게시글이 없습니다</h4>
				</td>
			</tr>
		</c:if>
		<c:if test="${totalCount>0 }">
			<c:forEach items="${list }" var="dto" varStatus="n">
				<tr>
					<td>${no}</td>
					<c:set var="no" value="${no-1 }"></c:set>
					<td>
						<!-- 제목 클릭시 detail로 넘겨야하는데 num도 같이 넘겨야한다 
						페이징 처리시 현재페이지도 같이 넘겨야한다--> <a
						href="./detail?num=${dto.num }&currentPage=${currentPage}">${dto.subject }</a>
					</td>
					<td>${dto.writer }</td>
					<td><fmt:formatDate value="${dto.writeday }"
							pattern="yyyy-MM-dd" /></td>
					<td>${dto.chu }</td>
					<td>${dto.readcount }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div style="width: 300px; text-align: center; margin-left: 150px;">
		<a href="./list">first</a>&nbsp;
		<c:if test="${ startPage>1}">
			<a href="./list?currentPage=${startPage-1}">&lt;&lt;</a>
		</c:if>
		<c:forEach var="pp" begin="${startPage }" end="${endPage}">
			<a href="./list?currentPage=${pp }"
				style="text-decoration: none; color:${currentPage eq pp?'red':'black' }">${pp }</a>
		</c:forEach>
		<c:if test="${endPage<totalPage}">
			<a href="./list?currentPage=${endPage+1}">&gt;&gt;</a>
		</c:if>
		&nbsp;
		<a href="./list?currentPage=${totalPage }">last</a>
	</div>
</body>
</html>










