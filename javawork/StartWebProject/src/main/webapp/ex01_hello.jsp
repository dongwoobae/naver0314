<%@page import="java.util.Date"%>
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
<h3>html 주석과 jsp 주석 비교하기</h3>
<!--html 주석 소스에 들어감 실행은 됨 에러도 뜸 <%=new Date() %>
-->
<%--jsp 주석 소스에도 안들어감 실행도 아예 안됨 에러도 안뜸 <%=new Date() %>
--%>
<!-- 주석입니다 -->
<h5>이름:<%=name %></h5>
나이:<%=age %>세
<%!
//선언문이라고 부른다
//여기서 선언하는 변수는 시블릿으로 변환시 위치상관없이 멤버변수로 취급된다
String name="송혜교";
int age=30;

%><!-- 자바의 영역 -->
<h5>이름2:<%=name %></h5>
<h5>나이 2:(<%=age %>)세</h5>
<%
//스크립트릿 이라고 부른다(scriptlet)
//자바영역: 서블릿 변환시 특정 메소드 내의 지역변수로 선언된다
String addr="서울시 강남구";
//내장 객체중 out을 이용해서 출력해도 된다
out.print("<h5 class='alert alert-danger'>나의 주소는 "+addr+"입니다</h5>");
%>
<h5>주소:<%=addr %></h5>
</body>
</html>