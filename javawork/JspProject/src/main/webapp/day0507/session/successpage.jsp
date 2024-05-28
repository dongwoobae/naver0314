<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--????????-->
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!--???-->
<link href="https://fonts.googleapis.com/css2?family=Dokdo&family=Dongle&family=Gaegu&family=Gowun+Batang&family=Reem+Kufi+Fun:wght@400..700&family=Song+Myung&family=Dancing+Script&family=Tilt+Neon&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
 <style>
 @font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://fastly.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}
     body *{
         font-family: "Pretendard-Regular";
     }
     img.photo{
     	width: 100px;
     	height: 120px;
     	border: 1px solid gray;
     	margin:10px;
     	border-radius:10px;
     }
 </style>
</head>
<%
String loginok=(String)session.getAttribute("loginok");//해당 세션이 없을 경우 null
//toString 쓰면 null일경우 널포인트익셉션 뜸
String myid=(String)session.getAttribute("myid");
%>
<body>
<%
if(loginok==null){%>
	<script>
	alert("먼저 로그인을 해주세요");
	location.href="sessionmain.jsp";
	</script>
<%}else{%>
<h5><b><%=myid %>님이 로그인 중입니다</b>
<button type="button" class="btn btn-sm btn-danger"
onclick="location.href='logoutaction.jsp'"
style="margin-left:100px;">로그아웃</button>
</h5>
<h3><b>Shop 상품들</b></h3>
<hr>
<script>
for(let i=1;i<=34;i++){
	let s="../../image/shop/"+i+"."+(i==24?"gif":"jpg");
	document.write(`<img src="\${s}" class="photo">`);
}
</script>
<%}
%>
</body>
</html>