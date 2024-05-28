<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--????????-->
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!--???-->
<link
	href="https://fonts.googleapis.com/css2?family=Dokdo&family=Dongle&family=Gaegu&family=Gowun+Batang&family=Reem+Kufi+Fun:wght@400..700&family=Song+Myung&family=Dancing+Script&family=Tilt+Neon&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
@font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://fastly.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 400;
	font-style: normal;
}

body * {
	font-family: "Pretendard-Regular";
}
</style>
</head>
<%
String savedId=(String)session.getAttribute("myid");
String saveok=(String)session.getAttribute("saveok");
String savedIdchk="";
String saveokchk="";
if(savedId!=null){
	savedIdchk=savedId;
}
if(saveok!=null){
	saveokchk=saveok;
}
%>
<body>
	<form action="./loginaction.jsp" method="post">
		<table class="table table-bordered" style="width: 250px;">
			<caption align="top">
				<b>회원 로그인</b> <label> <input type="checkbox" name="save"
					style="margin-left: 50px;" <%=saveokchk.equals("yes")?"checked":"" %>>아이디 저장
				</label>
			</caption>
			<tr>
				<th width="100" class="table-success">아이디</th>
				<td><input type="text" name="myid" class="form-control"
				value="<%=saveok.equals("yes")?savedIdchk:""%>">
				</td>
			</tr>
			<tr>
				<th width="100" class="table-success">비밀번호</th>
				<td><input type="password" name="mypass" class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-danger">회원로그인</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>