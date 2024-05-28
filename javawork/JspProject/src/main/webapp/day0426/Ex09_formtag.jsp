<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--��Ʈ��Ʈ��-->
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!--�۲�-->
<link
	href="https://fonts.googleapis.com/css2?family=Dokdo&family=Dongle&family=Gaegu&family=Gowun+Batang&family=Reem+Kufi+Fun:wght@400..700&family=Song+Myung&family=Dancing+Script&family=Tilt+Neon&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
body * {
	font-family: "Gowun Batang";
}
</style>
</head>
<body>
	<h5>폼태그 읽기</h5>
	<form action="./Ex09_action.jsp" method="post">
		<table class="table table-bordered" style="width: 400px;">
			<tr>
				<th class="table-info" width="100">몸무게</th>
				<td><input type="number" name="weight" class="form-control"
					min="40" max="100" step="5" value="50"></td>
			</tr>
			<tr>
				<th class="table-info" width="100">생년월일</th>
				<td><input type="date" name="birth" class="form-control"
					value="2000-01-01"></td>
			</tr>
			<tr>
				<th class="table-info" width="100">좋아하는 색</th>
				<td><input type="color" name="color" value="#fff"></td>
			</tr>
			<tr>
				<th class="table-info" width="100">숨겨진값</th>
				<td><input type="hidden" name="message" value="안녕하세요"></td>
			</tr>
			<tr>
				<th class="table-info" width="100">하고싶은 말</th>
				<td><textarea style="width:100%; height:100px" name="content" required="required"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button type="submit"
					class="btn btn-outline-success">서버전송</button></td>
			</tr>
		</table>
	</form>
</body>
</html>