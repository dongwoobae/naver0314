<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--��Ʈ��Ʈ��-->
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!--�۲�-->
<link href="https://fonts.googleapis.com/css2?family=Dokdo&family=Dongle&family=Gaegu&family=Gowun+Batang&family=Reem+Kufi+Fun:wght@400..700&family=Song+Myung&family=Dancing+Script&family=Tilt+Neon&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
 <style>
     body *{
         font-family: "Gowun Batang";
     }
 </style>
</head>
<body>
<h5>include1 파일에서 include2 결과 포함시키기</h5>
<%
request.setCharacterEncoding("utf-8");//한글 엔코딩 추가
%>
<div>
<%-- 주석 이안에 html 주석을 포함해서 다른 코드가 들어가면 안됨 --%>
	<jsp:include page="./Ex04_include2.jsp">	
		<jsp:param value="Happy Day!" name="msg"/>
		<jsp:param value="mycar15.png" name="car"/>
	</jsp:include>
</div>
</body>
</html>