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
	<div style="margin: 10px; width: 400px;">
		<form action="./writeaction.jsp" method="post">
			<table class="table table-bordered">
				<caption align="top">
					<b>학생정보입력</b>
				</caption>
				<tr>
					<th class="table-info">이름</th>
					<td><input type="text" name="name" class="form-control"
						style="width: 130px;" required></td>
				</tr>
				<tr>
					<th class="table-info">혈액형</th>
					<td><select class="form-select" style="width: 100px;"
						name="blood">
							<option>A</option>
							<option selected>B</option>
							<option>AB</option>
							<option>O</option>
					</select></td>
				</tr>
				<tr>
					<th class="table-info">운전면허</th>
					<td><label> <input type="checkbox" name="license">보유
					</label></td>
				</tr>
				<tr>
					<th class="table-info">JAVA</th>
					<td><input type="number" name="java" class="form-control"
						style="width: 130px;" required min="0" max="100" value="0"></td>
				</tr>
				<tr>
					<th class="table-info">SPRING</th>
					<td><input type="number" name="spring" class="form-control"
						style="width: 130px;" required min="0" max="100" value="0"></td>
				</tr>
				<tr>
					<th class="table-info">HTML</th>
					<td><input type="number" name="html" class="form-control"
						style="width: 130px;" required min="0" max="100" value="0"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-info">학생정보저장</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>