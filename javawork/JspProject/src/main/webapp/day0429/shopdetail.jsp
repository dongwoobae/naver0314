<%@page import="java.text.DecimalFormat"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
<%@page import="java.text.SimpleDateFormat"%>
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
.updateColor{
position:relative;
left:80px;
top:-20px;
}
div.selColor{
width: 50px;
height: 50px;
}
</style>
</head>
<%
//shopidx int 타입으로 읽기
int shopidx = Integer.parseInt(request.getParameter("shopidx"));
//dao 선언
ShopDao dao = new ShopDao();
//dto data 가져오기
ShopDto dto = dao.getSangpum(shopidx);
//날짜 포맷 양식 지정
SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
//금액 포맷 지정
DecimalFormat df = new DecimalFormat("###,###,###");
%>
<script>
$(function(){
	$("#updateBtn").click(function () {
		
		$(".name").html("상품명: <input type='text' id='updateName' value='<%=dto.getSname()%>'}>")
		$(document).on("click","#updateName",function(){
			$(this).val("");
		})
		
		$(".price").html("가격: <input type='text' id='updatePrice' value='<%=dto.getSprice()%>'>")
		$(document).on("click","#updatePrice",function(){
			$(this).val("");
		})
		
		$(".color").html("<div class='selColor'></div>"
		+"<input type='color' class='updateColor'>")
		
		$(".total").html("총 금액: <input type='text' readonly class='updateTotal'>");
		
		$(document).on("keyup","#updatePrice",function(){
			var uP=$("#updatePrice").val();
			var uN=$("#updateNum").val();
			
			$(".updateTotal").val(parseInt(uP)*parseInt(uN));			
		})
		
		$(document).on("change","#updateNum",function(){
			var uP=$("#updatePrice").val();
			var uN=$("#updateNum").val();
			
			$(".updateTotal").val(parseInt(uP)*parseInt(uN));			
		})
		
		$(".count").html("수량: <input type='number' id='updateNum' min='1' max='5' value='<%=dto.getScount()%>'>")
							$("#listBtn").remove();
							$("#updateBtn").remove();
							$("#deleteBtn").remove();
							$("#addBtn").remove();
							$(".buttons")
									.html(
											"<button type='button' class='btn btn-outline-danger btn-sm' style='width: 80px' id='doneBtn'>완료</button>")
											
							$(document).on("click","#doneBtn",function(){
								let updateName=$("#updateName").val();
								let updatePrice=$("#updatePrice").val();
								let updateCount=$("#updateNum").val();
								let color=$(".updateColor").val();
								let photo=$(".photo").attr("src");
								
								$.ajax({									
									url:"./shopupdate.jsp",
									method:"post",
									data:{
										
										shopidx:<%=shopidx%>,
										updateName:updateName,
										updatePrice:updatePrice,
										updateCount:updateCount,
										photo:photo,
										color:color
									},
									success:function(response){
										alert("수정이 완료되었습니다");
										location.reload();
									},
									error:function(xhr,status,error){
										console.error(error);
										alert("수정에 실패했습니다");
									}
									
								})
							})
						});
	
		$("#deleteBtn").click(function() {
			let shopidx=<%=shopidx%>;
			let a=confirm(`\${shopidx}번 상품을 삭제할까요?`);
			if(a){
			$.ajax({
				url:"./shopdelete.jsp",
				method:"post",
				data:{
					shopidx:shopidx
				},
				success:function(response){
					alert("삭제에 성공했습니다");
					$("#listBtn").trigger("click");
					//location.href="./shoplist.jsp";
				}
			})}
		})
});
</script>
<body>
	<div style="margin: 10px; width: 500px">
		<h2 class="name">
			상품명:
			<%=dto.getSname()%></h2>
		<span style="font-size: 12px; color: gray;">등록일: <%=sdf.format(dto.getWriteday())%></span><br>
		<table>
			<tr>
				<td><img src="<%=dto.getSphoto()%>"
					style="border: 10px groove orange; margin: 10px; width: 270px;" class="photo"></td>
				<td>
					<h5 class="price">
						가격:
						<%=df.format(dto.getSprice())%>원
					</h5>
					<h5 style="background-color:<%=dto.getScolor()%>" class="color">
						색상:
						<%=dto.getScolor()%></h5>
					<h5 class="count">
						수량:
						<%=dto.getScount()%>개
					</h5>
					<h5 class="total">
						총 금액:
						<%=df.format(dto.getScount() * dto.getSprice())%>원
					</h5>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" class="buttons">
					<button type="button" class="btn btn-outline-danger btn-sm"
						style="width: 80px" onclick="location.href='./shoplist.jsp'"
						id="listBtn">목록</button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						style="width: 80px" id="updateBtn">수정</button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						style="width: 80px" id="deleteBtn">삭제</button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						style="width: 80px" onclick="location.href='./shopform.jsp'"
						id="addBtn">상품추가</button>
				</td>

			</tr>
		</table>



	</div>
</body>
</html>