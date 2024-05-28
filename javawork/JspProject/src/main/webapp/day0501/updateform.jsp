<%@page import="data.dto.StudentDto"%>
<%@page import="data.dao.StudentDao"%>
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
int num=Integer.parseInt(request.getParameter("num"));
StudentDao dao = new StudentDao();
StudentDto dto = dao.getData(num);
%>
<body>
<div style="margin: 10px; width: 400px;">
		<form action="./update.jsp" method="post">
		<input type="text" name="num" value="<%=dto.getNum() %>" hidden>
			<table class="table table-bordered">			
				<caption align="top">
					<b>학생정보수정</b>
				</caption>
				<tr>
					<th class="table-info">이름</th>
					<td><input type="text" name="name" class="form-control"
						style="width: 130px;" required value="<%=dto.getName()%>"></td>
				</tr>
				<tr>
					<th class="table-info">혈액형</th>
					<td><select class="form-select" style="width: 100px;"
						name="blood">
							<option <%=dto.getBlood().equals("A")?"selected":"" %>>A</option>
							<option <%=dto.getBlood().equals("B")?"selected":"" %>>B</option>
							<option <%=dto.getBlood().equals("AB")?"selected":"" %>>AB</option>
							<option <%=dto.getBlood().equals("O")?"selected":"" %>>O</option>
					</select></td>
				</tr>
				<tr>
					<th class="table-info">운전면허</th>
					<td><label> <input type="checkbox" name="license" <%=dto.getLicense()=='y'?"checked":"" %>>보유
					</label></td>
				</tr>
				<tr>
					<th class="table-info">JAVA</th>
					<td><input type="number" name="java" class="form-control"
						style="width: 130px;" required min="0" max="100" value="<%=dto.getJava()%>"></td>
				</tr>
				<tr>
					<th class="table-info">SPRING</th>
					<td><input type="number" name="spring" class="form-control"
						style="width: 130px;" required min="0" max="100" value="<%=dto.getSpring()%>"></td>
				</tr>
				<tr>
					<th class="table-info">HTML</th>
					<td><input type="number" name="html" class="form-control"
						style="width: 130px;" required min="0" max="100" value="<%=dto.getHtml()%>"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" class="btn btn-outline-info"
						onclick="history.back()">뒤로가기</button>
						<button type="submit" class="btn btn-outline-info">수정완료</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>