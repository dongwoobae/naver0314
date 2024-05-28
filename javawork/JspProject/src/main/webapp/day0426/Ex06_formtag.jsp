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
	<h5>JSP로 폼태그 읽기</h5>
	<form action="./Ex06_action.jsp" method="get">
		<b>이름</b> <input type="text" name="name" required="required">
		<br>
		<br> <b>사진</b>: <select name="photo">
			<option value="../image/talent/17.jpg">신민아</option>
			<option value="../image/talent/15.jpg">설현</option>
			<option value="../image/talent/18.jpg">신세경</option>
			<option value="../image/talent/19.jpg">수지</option>
		</select> <br>
		<br>
		<!-- <button type="submit">서버전송</button>-->
		<!-- 서브밋을 이미지로 나타내고자 할때 -->
		<input type="image" src="../image/mycar/mycar1.png" style="width:70px">
	</form>


</body>
</html>