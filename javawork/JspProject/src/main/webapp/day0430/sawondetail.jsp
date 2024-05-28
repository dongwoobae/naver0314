<%@page import="data.dto.SawonDto"%>
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

div.detailAll {
	width: 500px;
}

div.female {
	height: 200px;
	background-color: rgba(240, 128, 128, 0.2);
	border-radius: 100px;
	justify-content: center;
	align-items: center;
	position:relative;
	left:20px;
}

div.male {
	height: 200px;
	background-color: rgba(135, 206, 250, 0.5);
	border-radius: 100px;
	justify-content: center;
	align-items: center;
	position:relative;
	left:20px;
}
</style>
</head>
<%
//num 갖고오기
int num = Integer.parseInt(request.getParameter("num"));
//dao 선언
SawonDao dao = new SawonDao();
//dao에서 데이터값 갖고오기 
SawonDto dto = dao.getData(num);
%>
<body>
	<div class="detailAll">
		<h3 class="alert alert-success" style="text-align: center;"><%=dto.getName()%></h3>
		<table>
			<tr>
				<td rowspan="1"><img
					src="<%=dto.getPhoto().equals("no") ? "../image/noimage1.png" : dto.getPhoto()%>"
					class="photo" style="width: 250px;"></td>
				<td style="text-align: center;">				
					<div class='<%=dto.getGender().equals("남자") ? "male" : "female"%>'>	
					<br>					
						<h2><%=dto.getGender().equals("남자") ? "\u2642" : "\u2640"%></h2>
						<h4>							
							<%=dto.getAge()%>세
							<%=dto.getBuseo()%></h4>
						<h5>
							생년월일:<%=dto.getBirthday()%></h5>
						<h5>
							주소:
							<%=dto.getAddr()%></h5>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="50">
					<button type="button" class="btn btn-sm btn-outline-info"
						onclick="location.href='./sawonlist.jsp'" id="btnList">사원목록</button>
					<button type="button" class="btn btn-sm btn-outline-info"
						id="btnUpdate" sawonname="<%=dto.getName()%>"
						value="<%=dto.getNum()%>">수정</button>
					<button type="button" class="btn btn-sm btn-outline-info"
						id="btnDelete" sawonname="<%=dto.getName()%>"
						value="<%=dto.getNum()%>">삭제</button>
					<button type="button" class="btn btn-sm btn-outline-info"
						onclick="location.href='./sawonform.jsp'" id="btnAdd">사원추가</button>
			</tr>
		</table>
	</div>
	<script>
	$("#btnDelete").click(function(){
		let a = confirm($(this).attr("sawonname")+"님을 삭제할까요?");
		if(a){
			location.href="sawondelete.jsp?num="+$(this).val();
		}
	})
	
	$("#btnUpdate").click(function(){
		let a = confirm($(this).attr("sawonname")+"님의 정보를 수정하시겠습니까?");
			if (a) {
				location.href="sawonupdateform.jsp?num="+$(this).val();
			}
		})
	</script>
</body>
</html>