<%@page import="java.text.NumberFormat"%>
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

figure img {
	border-radius: 30px;
	border: 4px inset gold;
}

figure figcaption {
	margin: 10px;
}

div.total {
	border: 1px solid gray;
	width: 500px;
	margin-left: 100px;
	margin-top: 20px;
	border-radius: 20px;
	overflow: hidden;
}

div.tableDiv {
	width: 500px;
	margin-left: 100px;
	overflow: hidden;
}

table {
	border-radius: 20px;
	overflow: hidden;
}

table.alltable {
	display: none;
}
</style>
</head>
<%
int num = Integer.parseInt(request.getParameter("num"));

StudentDao dao = new StudentDao();
StudentDto dto = dao.getData(num);
List<StudentDto> list = dao.getAllStudent();

SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
NumberFormat nf = NumberFormat.getInstance();
nf.setMaximumFractionDigits(2);

double avg = (dto.getJava() + dto.getSpring() + dto.getHtml()) / 3.0;
int allJava = 0, allSpring = 0, allHtml = 0;
for (StudentDto a : list) {
	allJava += a.getJava();
	allSpring += a.getSpring();
	allHtml += a.getHtml();
} ;
double allAvg = (allJava + allSpring + allHtml) / (3.0 * list.size());
%>
<body>
	<div class="total">
		<h3 style="text-align: center; border-collapse: collapse;"
			class="alert alert-primary"><%=dto.getName()%></h3>
		<h6 style="margin: 10px;">
			작성일:
			<%=sdf.format(dto.getWriteday())%></h6>
		<figure align="center">
			<figcaption>
				<h5><%=dto.getName()%>의 드림카
				</h5>
			</figcaption>
			<img src="../image/mycar/mycar<%=dto.getNum()%>.png"
				style="max-width: 300px;">
			<figcaption>
				<h6><%=dto.getLicense() == 'y' ? "사기만 하면됨" : "면허부터 따라"%>&nbsp;&nbsp;&nbsp;&nbsp;
					사고시 수혈: Rh+<%=dto.getBlood()%>형
				</h6>
				<h6></h6>
			</figcaption>
		</figure>
	</div>
	<div class="tableDiv">
		<table class="table table-dark table-hover"
			style="text-align: center;">
			<tr>
				<th>JAVA</th>
				<th>Spring</th>
				<th>HTML</th>
				<th>평균</th>
			</tr>
			<tr>
				<td id="javaScore"><%=dto.getJava()%></td>
				<td id="springScore"><%=dto.getSpring()%></td>
				<td id="htmlScore"><%=dto.getHtml()%></td>
				<td id="avgScore"><%=nf.format(avg)%></td>
			</tr>
			<tr>
				<td colspan="3"><%=avg >= 90 ? "가능성이 보인다 화이팅" : avg >= 80 ? "조금만 더 열심히 해보자" : avg >= 70 ? "열심히 해야겠지?" : "..."%></td>
				<td><button type="button" id="btnShowall"
						class="btn btn-secondary btn-sm">전체평균</button></td>
			</tr>
		</table>

	</div>
	<table class="table table-dark table-hover alltable"
		style="text-align: center; width: 500px; margin-left: 100px;">
		<tr>
			<th>JAVA</th>
			<th>Spring</th>
			<th>HTML</th>
			<th>평균</th>
		</tr>
		<tr>
			<td><%=allJava / list.size()%></td>
			<td><%=allSpring / list.size()%></td>
			<td><%=allHtml / list.size()%></td>
			<td><%=nf.format(allAvg)%></td>
		</tr>
	</table>
	<div style="width: 500px; margin-left: 100px;" align="right" class="buttons">
		<button type="button" class="btn btn-outline-secondary"
			onclick="location.href='./writeform.jsp'">학생 추가</button>
		<button type="button" class="btn btn-outline-secondary" id="btnUpdate">
		점수만 수정</button>
		<button type="button" class="btn btn-outline-secondary" id="btnUpdate2"
		onclick="location.href='./updateform.jsp?num=<%=num%>'">	전체 수정</button>
		<button type="button" class="btn btn-outline-secondary" 
		id="btnDel">정보삭제</button>
		<button type="button" class="btn btn-outline-secondary"
			onclick="location.href='./list.jsp'">목록으로</button>
	</div>
	<script>
		$("#btnShowall").click(function() {
			$(".alltable").slideToggle();			
			$("div.buttons").slideToggle();
		});
		
		$("#btnDel").click(function(){
			let a=confirm("<%=dto.getName()%>님의 정보를 삭제하시겠습니까?");
			if(a){
				location.href="./delete.jsp?num=<%=num%>";
			}
		});
		
		$("#btnUpdate").click(function(){
			$("#javaScore").html('<input type="number" value="<%=dto.getJava()%>" id="jS" style="width:50px;">');
			$("#springScore").html('<input type="number" value="<%=dto.getSpring()%>" id="sS"	style="width:50px;">');
			$("#htmlScore").html('<input type="number" value="<%=dto.getHtml()%>" id="hS"	style="width:50px;">');
			
			$("div.buttons").empty();
			$("div.buttons").html('<button type="button" class="btn btn-outline-secondary" id="btnComplete">수정완료</button>')
		});
		
		$(document).on("click","#btnComplete",function(){
			let num=<%=dto.getNum()%>;
			let name="<%=dto.getName()%>";
			let blood="<%=dto.getBlood()%>";
			let license='<%=dto.getLicense()%>';
			let java=$("#jS").val();
			let spring=$("#sS").val();
			let html=$("#hS").val();
			
			$.ajax({
				url:'./update.jsp',
				method:'post',
				data:{
					num:num,
					name:name,
					blood:blood,
					license:license,
					java:java,
					spring:spring,
					html:html,
		
				},
				success:function(response){
					alert("수정에 성공했습니다");
					location.href='./detail.jsp?num='+num;
				}
			})
		})
	</script>
</body>
</html>