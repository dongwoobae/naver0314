<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Pretendard';
}

div.mainLayout>div{
	border: none;
	position: absolute;
}
div.mainLayout>div a{
	text-decoration: none;
	color: black;
}
div.mainLayout>div.header{
width:100%;
height:150px;
font-size: 35px;
text-align:center;
}
div.mainLayout>div.menu{
	top:100px;
	width:100%;
	height: 70px;
	line-height: 70px;
	
}
div.mainLayout>div.info{
	top:250px;
	left:50px;
	width:200px;
	height:200px;
	border: 2px solid gray;
	border-radius: 20px;	
}

div.mainLayout>div.main{
	top: 210px;
	left:300px;
	width:70%;
	height:auto;
}
</style>
</head>
<body>
	<div class="mainLayout">
		<div class="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="menu">
			<tiles:insertAttribute name="menu" />
		</div>
		<div class="info">
			<tiles:insertAttribute name="info" />
		</div>
		<div class="main">
			<tiles:insertAttribute name="main" />
		</div>
	</div>
</body>
</html>
