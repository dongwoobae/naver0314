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
	<table class="table table-bordered" style="width: 100%">
		<caption align="top">
			<h3>
				<b>[구구단]</b>
			</h3>
		</caption>
		<tr class="table-Light">
			<%
			for (int dan = 2; dan <= 9; dan++) {
			%>
			<td align="center"><b><%=dan%>단</b></td>
			<%
			}
			%>
		</tr>
		<tr>
			<%
			for (int i = 1; i <= 9; i++) {
				for (int dan = 2; dan <= 9; dan++) {
			%>
			<td class=<%out.print(dan == i ? ("table-warning") : (""));%>
				<%out.print(dan - 2 == i || dan + 2 == i ? ("table-primary") : (""));%>
				<%out.print(dan - 4 == i || dan + 4 == i ? ("table-danger") : (""));%>
				<%out.print(dan - 6 == i || dan + 6 == i ? ("table-info") : (""));%>>
				<%=dan%>X<%=i%>=<%=dan * i%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>


















