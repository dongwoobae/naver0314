<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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
<%
String[] flowers = { "장미꽃", "안개꽃", "다알리아", "국화꽃", "프리지아" };
String[] colors = { "orange", "pink", "yellow", "tomato", "gold" };
List<String> list = Arrays.asList("2000원", "3500원", "5000원", "2300원", "9000원");
%>
<body>
	<Table class="table table-bordered" style="width: 400px;">
		<Caption align="top">
			<b>배열 및 리스트 출력</b>
		</Caption>
		<Tr class="table-success">
			<th width="60">번호</th>
			<th width="120">꽃이름</th>
			<th width="120">단가</th>
			<th>색상</th>
		</Tr>
		<%
		for (int i = 0; i < flowers.length; i++) {
		%>
		<tr>
			<td align="center"><%=i + 1%></td>
			<td><%=flowers[i]%></td>
			<td><%=list.get(i)%></td>
			<td style="background-color:<%=colors[i]%>;"><%=colors[i]%></td>
		</tr>
		<%}
%>
	</Table>
</body>
</html>