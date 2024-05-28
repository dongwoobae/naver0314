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
     div.box{
     width:100px;
     heigth:50px;
     border:1px solid gray;
     line-height:50px;
     }
 </style>
</head>
<%
request.setCharacterEncoding("UTF-8");
String weight = request.getParameter("weight");
String birth = request.getParameter("birth");
String color = request.getParameter("color");
String message = request.getParameter("message");
String content = request.getParameter("content");
%>
<body>
<div style="margin:30px; font-size:20px">
	생년월일: <%=birth %><br><br>
	몸무게:<%=weight %>Kg<br><br>
	좋아하는 색상
	<div class="box" style="background-color:<%=color %>; color:<%=color%>"><%=color %></div>
	<br>
	숨겨진 메세지: <%=message %><br><br>
	하고싶은말<br><br>
	<pre><%=content %></pre>
</div>
</body>
</html>