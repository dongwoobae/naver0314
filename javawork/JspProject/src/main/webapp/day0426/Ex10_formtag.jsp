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
	<h5>폼태그 읽기 문제</h5>
	<form action="./Ex10_action.jsp" method="post">
		<table class="table table-bordered" style="width: 400px;">
			<tr>
				<th class="table-info" width="100">메뉴명</th>
				<td><input type="text" name="menuname" class="form-control"
					required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th class="table-info" width="100">음식사진</th>
				<td class="input-group"><select class="form-select"
					name="foodphoto">
						<option value="../image/food/1.jpg,9000">샌드위치 1</option>
						<option value="../image/food/8.jpg,11000">샌드위치 2</option>
						<option value="../image/food/11.jpg,13000">망고빙수</option>
						<option value="../image/food/10.jpg,8000">햄마요덮밥</option>
				</select> <img src="../image/food/1.jpg" id="photo" width="60" height="60"
					style="margin-left: 10px;"> 
					<!-- 제이쿼리 이벤트는 여기에 -->
					<script>
					$("select[name=foodphoto]").change(function () {
						let foodphoto=$(this).val().split(",");
						$("#photo").attr("src",foodphoto[0]);
					})
					</script>
					</td>
			</tr>
			<tr>
				<th class="table-info" width="100">만족도</th>
				<td><label><input type="radio" name="grade"
						value="매우만족" checked>매우만족</label>
				<label><input type="radio" name="grade" value="만족">만족</label>
				<label><input type="radio" name="grade" value="보통">보통</label>
				<label><input type="radio" name="grade" value="불만족">불만족</label>
				</td>
			</tr>
			<tr>
				<th class="table-info">우수회원</th>
				<td>
				<input type="checkbox" name="member">우수회원
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-success">서버전송</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>