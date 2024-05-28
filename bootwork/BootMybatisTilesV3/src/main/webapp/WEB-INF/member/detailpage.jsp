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

th {
	text-align: center;
	font-size: 1.2em;
}

td, th {
	vertical-align: middle;
}
#commentDelete:hover{
	color:red;
	transition:0.5s;
	cursor:pointer;
}
</style>
</head>
<body>
	<table class="table table-bordered" style="width: 500px;">
		<thead class="table table-danger">
			<tr>
				<th colspan="3">${dto.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
					id="detailMyid">${dto.myid}</span></th>
			</tr>
		</thead>
		<tr>
			<td rowspan="5"><img src="../save/${dto.photo}" width="200"
				id="photo"></td>
		</tr>
		<tr>
			<th>핸드폰 번호</th>
			<td>${dto.hp}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${dto.addr}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${dto.email}</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${dto.birthday}</td>
		</tr>
		<tr>
			<td align="center"><input type="file" name="upload"
				id="photoupload" hidden="hidden">
				<button type="button" class="btn btn-info" id="btnUpdatePhoto">사진
					수정</button></td>
			<th>가입일자</th>
			<td><fmt:formatDate value="${dto.gaipday}"
					pattern="yyyy-MM-dd HH:mm" /></td>
		</tr>
		<tr>

			<td colspan="3" align="center">
				<button type="button" class="btn btn-primary"
					onclick="location.href='./updateform?num=${dto.num}'">수정</button>
				<button type="button" onclick="del(${dto.num})"
					class="btn btn-danger">삭제</button>
				<button type="button" onclick="location.href='./list'"
					class="btn btn-secondary">목록으로</button>
			</td>
		</tr>
	</table>
	<form action="../comment/insert" method="post">
		<table style="width: 500px;">
			<caption align="top">댓글</caption>
			<tr>
				<td>ID: <input type="text" name="userid" style="width:100px;">
				<input type="text" name="mynum" hidden="hidden" value="${dto.num}">
				</td>
				<td>PW: <input type="password" name="passwd" style="width:100px;">
				</td>
				<td rowspan="2"><button type="submit"
						class="btn btn-info btn-sm">댓글쓰기</button></td>
			</tr>
			<tr>
				<td colspan="2"><textarea style="width: 400px;" name="content"></textarea></td>
			</tr>			
		</table>
	</form>
	<table>
	<tr>
	<th>${list.size()}개의 댓글이 있습니다</th>
	</tr>
	<c:forEach items="${list}" var="list" varStatus="no">
	<tr>
	<td>${list.userid}</td><td><fmt:formatDate value="${list.writeday}" pattern="yyyy-MM-dd HH:mm"/> </td><td><i class="bi bi-x-circle-fill" id="commentDelete"
	></i></td>
	</tr>
	<tr>
	<td colspan="3">${list.content}</td>
	</tr>
	</c:forEach>
	</table>
	<script type="text/javascript">
	function delcomment(num){
		let del=prompt("비밀번호 입력");
		
		$.ajax({
			type:"post",
			dataType:"json",
			url:"../comment/delete",
			data:{"num":num,"passwd":del},
			success:function(data){
				if(data.status=="success"){
					alert("삭제성공");
					location.reload();
				}else{
				alert("비밀번호 안맞음");
			}			
		}
	});
		}
	
	$("#commentDelete").click(function(){
		delcomment(${dto.num});
	});
		/*$("#btnDelDetail").click(function() {
			let myid = $("#detailMyid").text();
			let a = confirm(myid + "님을 삭제하시겠습니까?");
			if (a) {
				$.ajax({
					type : "get",
					dataType : "json",
					url : "../member/delete",
					data : {
						"myid" : myid
					},
					success : function() {
						location.href = "./list";
					}
				});
			}
		});*/
		function del(num){
			//비밀번호 입력 받기
			let passwd=prompt("비밀번호 입력");
			$.ajax({
				type:"get",
				dataType:"json",
				url:"./deletepasswd",
				data:{"num":num, "passwd":passwd},
				success:function(data){
					if(data.status=="success"){
						alert("삭제완료");
						location.href="./list";
					}else{
						alert("비밀번호가 맞지 않습니다");
					}
				}
			})
		}
		//사진변경 이벤트
		$("#btnUpdatePhoto").click(function(){
			$("#photoupload").click();			
		});
		$("#photoupload").change(function(){
			let num="${dto.num}";
			let form = new FormData();
			
			form.append("upload",$("#photoupload")[0].files[0]);
			form.append("num",num);
			$.ajax({
				type:"post",
				dataType:"json",
				url:"./updatephoto",
				data:form,
				processData:false,
				contentType:false,
				success:function(data){
					//스프링에서 {"photoname":"파일명"}으로 return 할것.
					//프로필 사진 변경 (db변경 후 업로드된 사진파일명을 반환받아서 변경)
					$("#photo").attr("src","../save/"+data.photo);
				}
			});
		});
	</script>
</body>
</html>