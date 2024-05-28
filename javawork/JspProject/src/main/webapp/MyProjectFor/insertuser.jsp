<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<!-- Latest compiled JavaScript -->
<!--�۲�-->
<link
	href="https://fonts.googleapis.com/css2?family=Dokdo&family=Dongle&family=Gaegu&family=Gowun+Batang&family=Reem+Kufi+Fun:wght@400..700&family=Song+Myung&family=Dancing+Script&family=Tilt+Neon&display=swap"
	rel="stylesheet" />
	 	 
	 	
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
	rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link href="./style.css" rel="stylesheet" />
<title>Document</title>
<style type="text/css">
div.userinfoinsert {
	width: 500px;
	height: 400px;
	z-index: 100;
	position: absolute;
	left: 30%;
	top: 20%;
	background-color: rgba(255, 255, 255, 0.4);
	backdrop-filter: blur(100px);
	border: 5px solid white;
}

#showimg {
	position: flex;
	top: -25%;
	width:200px;
	height:auto;
	
}
</style>
</head>
<script>
function(){
	
}
	function preview(tag) {
		//파일 업로드 미리보기 함수
		if (tag.files[0]) {
			let f = tag.files[0];

			if (!f.type.match("image.*")) {
				alert("이미지 파일만 가능합니다");
				return;
			}
			if (f) {
				let reader = new FileReader();
				reader.onload = function(e) {
					$("#showimg").attr("src", e.target.result);
				};
				reader.readAsDataURL(tag.files[0]);
			}
		}
	}
</script>
<body>
	<nav class="sidebar">
		<div class="logo-menu">
			<h2 class="logo">
				<a href="#">비회원</a>
			</h2>
			<i class="bx bx-menu toggle-btn"></i>
		</div>
		<ul class="list">
			<li class="list-item active"><a href="#"> <i
					class="bx bx-grid-alt"></i> <span class="link-name" style="--i: 1">Dashboard</span>
			</a></li>
			<li class="list-item"><a href="#"> <box-icon name='user'></box-icon>
					<span class="link-name" style="--i: 2">User</span>
			</a>
				<ul class="submenu">
					<li>Members</li>
					<li>Ranking</li>
					<li>UserPhotos</li>
				</ul></li>
			<li class="list-item"><a href="#"> <i
					class="bx bx-store-alt"></i> <span class="link-name" style="--i: 3">Bicycle</span>
			</a>
				<ul class="submenu">
					<li>Frame</li>
					<li>Wheel</li>
					<li>Drivetrain</li>
					<li>others</li>
				</ul></li>
			<li class="list-item"><a href="#"> <i
					class="bx bx-menu toggle-btn"></i> <span class="link-name"
					style="--i: 4">Accessories</span>
			</a>
				<ul class="submenu">
					<li>Helmet</li>
					<li>Goggle</li>
					<li>cycling computer</li>
					<li>blackbox</li>
				</ul></li>
			<li class="list-item"><a href="#"> <i
					class="bx bx-navigation"></i> <span class="link-name"
					style="--i: 5">Course</span>
			</a>
				<ul class="submenu">
					<li>east seoul</li>
					<li>west seoul</li>
					<li>gangwondo</li>
					<li>jeju</li>
				</ul></li>
			<li class="list-item"><a href="#"> <i class="bx bx-cart-alt"></i>
					<span class="link-name" style="--i: 6">MyCart</span>
			</a></li>
			<li class="list-item"><a href="#"> <i class="bx bx-cog"></i>
					<span class="link-name" style="--i: 7">Settings</span>
			</a></li>
		</ul>
	</nav>
	<div class="userinfoinsert">
		<form action="memoaction.jsp" method="post"
			enctype="multipart/form-data">
			<table>
				<caption align="top">
					<b class="text text-links">간단가입</b>
				</caption>
				<tr>
				<th>아이디</th>
				<td><input type="text" name="userid"></td>
				</tr>
				<tr>
					<th width="100"><b>이름</b></th>
					<td><input type="text" name="username" required="required"></td>
				</tr>
				<tr>
				<th>나이</th>
				<td><input type="number" name="userage" min="20" max="80" value="30" width="100"></td>
				</tr>
				<tr>
					<th width="100">프로필 사진</th>
					<td><input type="file" name="userphoto"
						onchange="preview(this)" style="width: 200px;"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="useraddr" width="200"></td>
				</tr>
				<tr>				
					<th>회원등급</th>
					<td>
					<select id="grade" name="userclass">
						<option value="admin">admin</option>
						<option value="중급">중급</option>
						<option value="초보">초보</option>
						<option value="입문" selected>입문</option>
					</select>
					</td>				
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-secondary">회원가입</button>
				</tr>
			</table>
		</form>
		<img id="showimg" src="" onerror="this.src='../image/noimage1.png'">
		<%-- 미리보기용 --%>
	</div>
	<script src="script.js"></script>
</body>
</html>
