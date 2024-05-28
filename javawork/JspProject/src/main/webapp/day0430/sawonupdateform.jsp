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
img.photo{
position:absolute;
left:340px;
top:250px;
width:150px;
border:2px solid gray;
}
</style>
</head>
<%
//num 받아서 값 정하기
int num = Integer.parseInt(request.getParameter("num"));
//dao 호출해서 값 받기
SawonDao dao=new SawonDao();
SawonDto dto=dao.getData(num);
%>
<script>
$(function(){
	$("select[name='buseo'] option").each(function(){
		if($(this).val() === '<%=dto.getBuseo()%>'){
			$(this).prop("selected",true);
		}
	})
	
	$("input[name='gender']").each(function(){
		if($(this).val()==='<%=dto.getGender()%>'){
			$(this).attr("checked",true);
		}
	})
	
	$("select[name='photo'] option").each(function(){
		if($(this).val()==='<%=dto.getPhoto()%>'){
			$(this).prop("selected",true);
			$(".photo").attr("src",$(this).val());
		}
	})	
})
</script>
<body>
	<div style="margin: 20px; width: 300px;">
		<form action="./sawonupdate.jsp" method="post">
		<input type="text" name="num" hidden="hidden" value="<%=num%>">
			<table class="table table-bordered">
				<caption align="top">
					<h5 class="alert alert-warning">사원수정포맷</h5>
				</caption>				
				<tr>
					<th width="100" class="table-danger">사원명</th>
					<td><input type="text" name="name" class="form-control"
						required="required" value="<%=dto.getName()%>"></td>
				</tr>
				<tr>
					<th width="100" class="table-danger">나이</th>
					<td><input type="number" name="age" class="form-control"
						required="required" min="1" max="100" step="1" value="<%=dto.getAge()%>"></td>
				</tr>
				<tr>
					<th width="100" class="table-danger">주소</th>
					<td><input type="text" name="addr" class="form-control"
						required="required" value="<%=dto.getAddr()%>"></td>
				</tr>
				<tr>
					<th width="100" class="table-danger">부서</th>
					<td><select class="form-select" name="buseo" id="buseo">
					<!-- option 안에 dto.getBuseo().equals(해당부서의이름)?"selected":""
					만일 option이 많으면 for문 돌려서 차례로 넣을 수 있음 -->
							<option>교육부</option>
							<option>인사부</option>
							<option>홍보부</option>
							<option>해외파견부</option>
					</select></td>
				</tr>
				<tr>
					<th width="100" class="table-danger">성별</th>
					<!-- 얘도 똑같이 option안에 자바영역 열고 dto.getGender().equals(각각성별)?"checked":"" -->
					<td><label> <input type="radio" name="gender"
							value="남자">남자
					</label> <label> <input type="radio" name="gender" value="여자">여자
					</label></td>
				</tr>
				<tr>
					<th width="100" class="table-danger">프로필 사진</th>
					<td>
						<img src="" class="photo"
						onerror="this.src='../image/noimage1.png'">
						<select class="form-select" name="photo" id="photo">
						<option value="no">프로필사진없음</option>
						<%for(int i=0;i<=20;i++){
							%><option value="../image/talent/<%=i%>.jpg">프로필사진#<%=i %></option>
						<% }%>
						</select>
						<script type="text/javascript">
						$("#photo").change(function(){
							let src=$(this).val();
							$(".photo").attr("src",src);
						});
						</script>
					</td>
				</tr>
				<tr>
					<th width="100" class="table-danger">생년월일</th>
					<td>
					<input type="date" class="form-control" name="birthday"
					value="<%=dto.getBirthday()%>">
					</td>
				</tr>				
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-secondary btn-sm"
							style="width: 80px;" id="saveBtn"
							>사원저장</button>
						<button type="button" class="btn btn-outline-secondary btn-sm"
							style="width: 80px;" onclick="location.href='sawonlist.jsp'">사원목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>