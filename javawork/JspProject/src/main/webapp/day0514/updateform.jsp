<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

.selectavatar {
	border: 2px solid red;
	box-shadow: 3px 3px 3px lightgray;
	border-radius: 5px;
}
</style>
<script type="text/javascript">
	$(function() {
		//첫 아바타는 인덱스가 0번이므로 실제 아바타 값에서 1을 뺀 후 클래스 적용
		$("img.avatar").eq(${dto.avatar}-1).addClass("selectavatar");

		$("img.avatar").click(function() {
			$(this).siblings().removeClass("selectavatar");
			$(this).addClass("selectavatar");
			let n = $(this).attr("n");

			$("#avatar").val(n);
		});
	});
</script>
</head>
<body>
	<div style="margin: 30px;">
		<form action="./update" method="post">
		<input type="hidden" name="num" value="${dto.num }">
		<input type="hidden" name="currentPage" value="${currentPage }">
			<table class="table table-bordered" style="width: 400px;">
				<caption align="top">
					<b>수정하기</b>
				</caption>
				<tr>
					<th class="table-success" width="100">작성자</th>
					<td><input type="text" name="writer" class="form-control" value="${dto.writer }">
					</td>
				</tr>
				<tr>
					<th class="table-success" width="100">아바타</th>
					<td>
						<!-- 확인 후 hidden으로 수정할 예정 --> <input type="hidden" name="avatar"
						id="avatar" value="${dto.avatar }"><br> <!-- 아바타 클릭시 1~10 사이의 숫자가 hidden에 들어가도록 제이쿼리로 코딩 -->
						<c:forEach var="a" begin="1" end="10">
							<img src="../image/snoopyAvata/s${a }.JPG" width="50" height="50"
								border="1" class="avatar" style="cursor: pointer;" n="${a }">
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th class="table-success" width="100">제목</th>
					<td><input type="text" class="form-control" name="subject"
						required="required" value="${dto.subject }"></td>
				</tr>
				<tr>
					<th class="table-success" width="100">내용</th>
					<td><textarea style="width: 100%; height: 120px;"
							name="content" required="required">${dto.content }</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-sm btn-success">게시글
							수정</button>
						<button type="button" class="btn btn-sm btn-danger"
							onclick="history.back()">이전으로</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>