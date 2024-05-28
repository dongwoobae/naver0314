<%@page import="test.data.ShopDto"%>
<%@page import="java.util.Vector"%>
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

div.shop {
	float: left;
	margin: 5px;
	border: 2px solid gray;
	border-radius: 20px;
	padding: 15px;
	width: 200px;
	height: 300px;
}

div.shop img {
	width: 160px;
	heigth: 180px;
	border-radius: 20px;
}
</style>
</head>
<%
List <ShopDto> list = new Vector<>();
//5개의 상품을 리스트에 등록해보자
list.add(new ShopDto("보석머리띠","30.jpg",23000,3,"orange"));
list.add(new ShopDto("화이트자켓","31.jpg",135000,3,"white"));
list.add(new ShopDto("꽃머리끈","26.jpg",5000,3,"yellow"));
list.add(new ShopDto("플렛슈즈","14.jpg",20000,3,"gold"));
list.add(new ShopDto("쁘띠스카프","10.jpg",7000,3,"hotpink"));
%>
<body>
	<%
	for(ShopDto dto:list){%>
	<div class="shop" style="background-color: <%=dto.getColor() %>">
		<img src="./shop/<%=dto.getPhoto() %>" width=150 height=170>
		<h5 align="center"><%=dto.getSangpum() %></h5>
		<h6>가격: <%=dto.getPrice() %>
		&nbsp;&nbsp;&nbsp;&nbsp;재고:<%=dto.getCount() %></h6>		
	</div>
	<%}
%>
</body>
</html>