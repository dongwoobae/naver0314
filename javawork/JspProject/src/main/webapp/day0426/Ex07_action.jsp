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
	//post방식으로 읽을 경우 읽기전에 encoding 추가
	request.setCharacterEncoding("utf-8");
	//post방식의 폼데이터 읽기
	String home=request.getParameter("home");
	String email=request.getParameter("email");
	//체크박스는 여러개의 값을 가져와야 하므로
	//선택을 안할경우 null값 반환
	//선택을 할 경우 배열타입으로 반환
	String []hobby= request.getParameterValues("hobby");	
%>
<body>
<h5>
나의 주거지: <b><%=home %></b>
</h5>
<h5>
이메일:<%=email %>
</h5>
<h5>
취미:
<%
if(hobby==null){%>
<b>취미가 없어요</b>
<%}else{
for(String h:hobby){%>
	<b>[<%=h %>]</b>
	<%}
}
%>
</h5>
</body>
</html>