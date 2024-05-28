<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Jua';
}

th {
	text-align: center;
	font-size: 1.2em;
}

td, th {
	vertical-align: middle;
}

input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}
</style>
</head>
<body>
	<form action="./update" method="post">
		<table class="table table-bordered" style="width: 500px;">
			<thead class="table table-danger">
				<tr>
					<th colspan="3">${dto.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${dto.myid}
						<input type="text" name="num" hidden="hidden" value="${dto.num}">
					</th>
				</tr>
			</thead>
			<tr>
				<td rowspan="6"><img src="../save/${dto.photo}" width="200"
					id="photo"></td>
			</tr>
			<tr>
				<th width="100">핸드폰 번호</th>
				<td><input type="number" name="hp" class="form-control"
					required="required" value="${dto.hp}"
					pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="addr" class="form-control"
					required="required" value="${dto.addr}"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" class="form-control"
					value="${dto.email}"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="birthday" class="form-control"
					value="${dto.birthday}"></td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td><fmt:formatDate value="${dto.gaipday}"
						pattern="yyyy-MM-dd HH:mm" /></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<button type="submit" class="btn btn-primary">수정</button>
					<button type="button" class="btn btn-secondary"
						onclick="location.href='./detail?myid=${dto.myid}'">취소</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>