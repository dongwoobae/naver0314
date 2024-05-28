<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.StudentDao"%>
<%@page import="data.dto.StudentDto"%>
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
StudentDto dto=new StudentDto();
StudentDao dao=new StudentDao();

List<StudentDto>list= dao.getAllStudent();

SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
%>
<body>
<div style="width:500px;margin:20px 100px;">
<h4 class="alert alert-success" style="text-align:center">학생 정보 리스트</h4>
<table class="table">
<tr class="alert alert-danger" style="text-align:center">
<th>이름</th>
<th>등록일</th>
<th>상세보기</th>
</tr>
<tr>
<%
for(StudentDto a:list){%>
	<tr style="text-align:center">
	<td><%=a.getName() %></td>
	<td><%=sdf.format(a.getWriteday()) %></td>
	<td><button type="button" class="btn btn-outline-info"
	onclick="location.href='./detail.jsp?num=<%=a.getNum()%>'">more..</button></td>
	</tr>
<%}
%>
</tr>
</table>
</div>
</body>
</html>