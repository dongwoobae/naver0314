<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	font-family: 'Jua';
}

th, td {
	text-align: center;
}
</style>
</head>
<body>
	<h2 class="alert alert-danger" style="width: 500px;" align="center"
		style="left:40%;" id="head">
		<span id="count">${totalCount}</span> 명의 정보가 있습니다 <span
			style="float: right;">
			<button type="button" class="btn btn-sm btn-success"
				onclick="location.href='./form'">멤버등록</button>
		</span>
	</h2>
	<table style="width: 500px;" class="table table-striped">
		<thead class="table table-danger">
			<tr>
				<th>번호</th>
				<th>회원명</th>
				<th>아이디</th>
				<th>핸드폰</th>
				<th>상세보기</th>
				<!--  <th>삭제</th>-->
			</tr>
		</thead>
		<tbody id="memberTableBody">
		<c:forEach var="item" items="${list}" varStatus="no">
			<tr>
				<td class="row-num">${no.count}
				<span hidden="hidden" class="itemNum">${item.num}</span>
				</td>
				<td><img src="../image/${item.photo}" width="40">${item.name}</td>
				<td>${item.myid}</td>
				<td>${item.hp}</td>
				<td><button type="button"
						onclick="location.href='./detail?myid=${item.myid}'"
						class="btn btn-primary btn-sm">상세보기</button></td>
				<!--  <td><button type="button" class="btn btn-danger btn-sm btndel">삭제</button></td>
			--></tr>
		</c:forEach>
		</tbody>
	</table>
	<script type="text/javascript">
		/*$("button.btndel").on("click",function(){
			var button = $(this);
			var num = $(this).closest("tr").find("td.row-num>span.itemNum").text();
			let a = confirm(myid+"님을 삭제하시겠습니까?");
			if(a){
			$.ajax({
				type:"get",
				dataType:"json",
				url:"./delete",
				data:{"myid":myid},
				success:function(){
					var totCount = $("#count").text();
					totCount--;
					 button.closest("tr").remove();					
					$("#head").html(`<span id="count"></span>
							명의 정보가 있습니다 <span style="float: right;">
							<button type="button" class="btn btn-sm btn-success"
								onclick="location.href='./form'">멤버등록</button>
						</span>
							`);
					$("#count").text(totCount);
					$("#memberTableBody tr").each(function(index) {
                        $(this).find("td.row-num").text(index + 1);
                    });
				},
				error: function(xhr, status, error) {
                    alert("AJAX 오류: " + error);
                }
			});
			}
		});*/
	</script>
</body>
</html>