<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="java.util.Vector"%>
<%@page import="data.dao.ShopDao"%>
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

.smallphoto {
	width: 50px;
	height: 50px;
	border: 1px solid gray;
	margin-right: 5px;
}
</style>
</head>
<%
//dao 선언
ShopDao dao = new ShopDao();
//db에 등록된 상품들 가져오기
List<ShopDto> list = dao.getShopDatas();
//날짜 형식
SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
%>
<body>
	<div style="margin: 10px; width: 400px;">
		<h5 class="alert alert-danger">
			<b>총 <%=list.size()%>개의 상품이 등록되어 있습니다
			</b>
		</h5>
		<button type="button" class="btn btn-outline-primary"
			style="margin-top: 10px; margin-left: 300px;"
			onclick="location.href='./shopform.jsp'">상품 추가</button>
		<table class="table table-bordered" style="text-align: center; margin:10px;">
			<tr>
				<th width="200">상품명</th>
				<th width="100">가격</th>
				<th>등록일</th>
			</tr>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><a href="./shopdetail.jsp?shopidx=<%= list.get(i).getShopidx() %>" 
				style="text-decoration: none; color:black;"> 
				<img class="smallphoto"	src="<%=list.get(i).getSphoto()%>"><%=list.get(i).getSname()%></td>
				</a>
				<td align="right"><%=list.get(i).getSprice()%>원</td>
				<td><%=sdf.format(list.get(i).getWriteday())%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>