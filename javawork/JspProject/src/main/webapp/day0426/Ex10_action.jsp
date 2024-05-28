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
<%
request.setCharacterEncoding("UTF-8");
String menuname=request.getParameter("menuname");
String foodphoto=request.getParameter("foodphoto");
String grade=request.getParameter("grade");
String member=request.getParameter("member");

String [] arr=foodphoto.split(",");
String src = arr[0];
String price = arr[1];
%>
<body>
<div>
<img src="<%=src %>" style="max-width: 200px;" align="top">
<br>
<h5>메뉴명:&nbsp;<%=menuname %></h5>
<h5>가격:&nbsp;<%=price %>원</h5>
<h5>만족도:&nbsp;<%=grade %></h5>
<h5>회원구분:&nbsp;<%=(member==null?"일반회원":"우수회원") %></h5>
<br>
<a href="javascript:history.back()">다시 선택#1</a>
<br><br>
<a href="Ex10_formtag.jsp">다시 선택#2</a>
</div>
</body>
</html>