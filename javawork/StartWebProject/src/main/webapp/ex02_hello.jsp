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
	<h5>자바영역의 배열 변수를 table을 이용해서 출력해보자</h5>
	<%
	String[] colors = { "red", "orange", "hotpink", "green", "gray" };
	%>
	<table class="table table-striped" style="width: 200px;">
		<caption align="top">
			<b>색상 배열 출력</b>
		</caption>
		<tr class="table-danger">
			<th>번호</th>
			<th>색상</th>
		</tr>
		<%
		for (int i = 0; i < colors.length; i++) {
		%>
		<tr>
			<td><%=i + 1%></td>
			<td style="background-color: <%=colors[i]%>"><%=colors[i]%></td>
		</tr>
		<%
		}
		%>
	</table>
	<hr>
	<%
	String name = "신민아";
	String addr = "서울시 강남구";
	int age = 32;
	String blood = "AB형";
	String photo = "./image/17.jpg";
	String[] hobby = { "자바공부", "스프링공부", "제이쿼리공부", "게임", "웹툰" };
	%>
	<table class="table table-bordered" style="width: 400px;">
		<tr>
			<td width="200" rowspan="4"><img src="<%=photo%>" width="190">
			</td>
			<td width="60" class="table-danger">이름</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=addr%></td>
		</tr>
		<tr>
			<td class="table-danger">혈액형</td>
			<td><%=blood%></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=age%></td>
		</tr>
		<tr>
			<td colspan="3" class="table-danger">취미: <%
			for (int i = 0; i < hobby.length; i++) {
			%>
				<%=hobby[i]%> <%
 }
 %></td>
		</tr>
	</table>
</body>
</html>









