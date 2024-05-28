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

img.photo {
	position: absolute;
	left: 350px;
	top: 50px;
	width: 200px;
	border: 3px solid gray;
}
</style>

</head>
<body>
	<div style="margin: 10px; width: 300px">
		<form action="./shopaction.jsp" method="post">
			<table class="table table-bordered">
				<caption align="top">
					<b>상품등록</b>
				</caption>
				<tr>
					<th width="100" class="table-danger">상품명</th>
					<td><input type="text" name="sname" class="form-control"
						required="required"></td>
				</tr>
				<tr>
					<th width="100" class="table-danger">상품가격</th>
					<td><input type="text" name="sprice" class="form-control"
						required="required"></td>
				</tr>
				<tr>
					<th width="100" class="table-danger">상품개수</th>
					<td><input type="number" name="scount" class="form-control"
						min="1" max="5" step="1" value="1"></td>
				</tr>
				<tr>
					<th width="100" class="table-danger">상품색상</th>
					<td><input type="color" name="scolor" class="form-control"
						value="#ccff00"></td>
				</tr>
				<tr>
					<th width="100" class="table-danger">상품사진</th>
					<td><select name="sphoto" id="sphoto" class="form-select">
							<%
							for (int i = 1; i <= 34; i++) {
							%>
							<option value='../image/shop/<%=i%>.<%=i == 24 ? "gif" : "jpg"%>'>
								상품번호
								<%=i%></option>
							<%
							}
							%>
					</select> <img src="../image/shop/1.jpg" class="photo"> <script
							type="text/javascript">
						$("#sphoto").change(function() {
								$(".photo").attr("src", $(this).val());
							});						
					</script></td>
				</tr>
				<tr>
				<td colspan="2" align="center">
				<button type="submit" class="btn btn-secondary">DB 저장</button>
				</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>