<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.SawonDao"%>
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
SawonDao dao = new SawonDao();
List<Map<String, String>> list = dao.getBuseoAnalysis();
%>
<body>
	<div style="width: 300px; margin:50px 100px;">
		<table class="table table-bordered">
			<caption style="text-align: center;" align="top">
				<h3>
					<b>부서별 분석표</b>
				</h3>
			</caption>
			<tr class="table-danger">
				<th>부서</th>
				<th>인원수</th>
				<th>나이</th>
			</tr>
			<%
			for (Map<String, String> map : list) {
			%>
			<tr align="center">
				<td><%=map.get("buseo")%></td>
				<td><%=map.get("count")%>명</td>
				<td><%=map.get("age")%>세</td>
			</tr>
			<%}
%>
			<tr>
			<td colspan="3" align="center">
			<button type="button" class="btn btn-outline-danger"
			onclick="history.back()">이전으로</button>
			</tr>
		</table>
	</div>
</body>
</html>