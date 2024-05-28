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
//한글 엔코딩
request.setCharacterEncoding("UTF-8");
String name =request.getParameter("name");
String pass =request.getParameter("pass");
String gender =request.getParameter("gender");
String lic =request.getParameter("lic");
String blood =request.getParameter("blood");
String[] itlang=request.getParameterValues("itlang");
%>
<body>
	<div style="font-size: 20px;">
		이름:<%=name %><br> 비밀번호:<%=pass %><br> 성별:<%=gender %><br>
		운전면허:<%=lic %>:<%=lic.equals("on")?"있음":"없음" %><br> 혈액형:<%=blood %><br>
		<%if(itlang.equals("null")){ %>
		가능한 IT 언어 없음<%}else{ %>
		가능한 언어:
		<%for(String i:itlang){ %>
		[<%=i %>]<%} }%>
	</div>
</body>
</html>