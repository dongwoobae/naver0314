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
<script type="text/javascript">
$(function () {
	$("div.view").hide();
	$("h5.title").css("cursor","pointer").click(function () {
		//제목을 클릭시 아래의 내용이 보이게 하기
		//그러면서 다른 메뉴는 접기
		$(this).next("div.view").slideToggle();
		$(this).next("div.view").siblings("div.view").slideUp();
	});	
})
</script>
</head>
<body>
	<h3 class="alert alert-danger">Jsp의 Action Tag include</h3>
	<h5 class="title">2024-04-26 1번 예제</h5>
	<div class="view">
		<jsp:include page="./ex01_text.jsp" />
		<%-- 반드시 닫아야 하는 태그 안닫으면 에러남 --%>
	</div>
	<h5 class="title">2024-04-26 2번 예제</h5>
	<div class="view">
		<jsp:include page="./Ex02_구구단.jsp"></jsp:include>
		<!--닫는 방법은 위 두가지가 있다. -->
	</div>
</body>
</html>