<%@page import="data.dto.SawonDto"%>
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
div.list{
	float:left;
	margin:10px;
	width:150px;
	height:200px;
	border: 1px solid gray;
	box-shadow: 5px 5px 5px gray;
	border-radius: 20px;
	padding:10px;
	text-align:center;
}
div.list img{
border-radius:20px;
width:100px;
height:110px;
margin-bottom:10px;
}
</style>
</head>
<%
//dao선언
SawonDao dao = new SawonDao();

//list 가져오기
List<SawonDto> list = dao.getAllSawons();
%>
<body>
	<div style="margin: 20px; width: 600px;">
		<div>
			<h5 class="alert alert-danger" style="width: 400px;">
				총
				<%=list.size()%>명의 사원이 있습니다
			</h5>
			<button type="button" class="btn btn-sm btn-info"
				onclick="location.href='sawonform.jsp'" 
				style="margin-left:10px; heigth:50px">사원추가</button>
		</div>
		<div style="margin: 20px;">
			<button type="button" class="btn btn-success"
			style="width:120px;" 
			onclick="location.href='sawongenderanalysis.jsp'">성별 분석표</button>
			<button type="button" class="btn btn-success"
			style="width:120px;" 
			onclick="location.href='sawonbuseoanalysis.jsp'">부서별 분석표</button>		
		</div>
		<%
		for(SawonDto dto:list){%>
			<div class="list">
			<img src='<%=dto.getPhoto().equals("no")?"../image/noimage1.png":dto.getPhoto() %>'>
			<br>
			<%=dto.getName() %> 사원
			<br>
			<button type="button" class="btn btn-sm btn-outline-danger"
			onclick="location.href='sawondetail.jsp?num=<%=dto.getNum()%>'">상세보기</button>
			</div>
		<%}
		%>		
	</div>	
</body>
</html>