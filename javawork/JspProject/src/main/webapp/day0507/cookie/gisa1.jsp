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
</style>
</head>
<%
//amho라는 쿠키가 있으면 true, 없으면 false
boolean findAmho = false;
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie ck : cookies) {
		String name = ck.getName();
		if (name.equals("amho")) {
	findAmho = true;
	break;
		}
	}
}
%>
<body>
	<%
	if (findAmho) {
	%>
	<pre>
	바이에른 뮌헨이 1년 만에 김민재 방출을 고려 중이다.

독일 바바리안풋볼은 6일(한국시간) "바이에른 뮌헨이 김민재를 방출 명단에 올렸다. 적절한 제안이 온다면 한 시즌 만에 김민재를 내보낼 준비가 됐다"라고 전했다.

앞서 매체는 김민재가 이적할 생각이 없다고 알렸다. 지난 3일 "전 소속팀 나폴리가 김민재를 다시 데려오는 것에 관심을 보이고 있으나 김민재는 현재 이적을 생각하지 않고 있다"라며 "김민재는 뮌헨에 머물기를 원하지만 팀에서 약간 고립됐다고 느낀다. 구단의 더 많은 지원과 감독 및 동료들과의 더 많은 소통을 원한다"라고 설명했다.

하지만 김민재의 의사와 달리 뮌헨이 김민재를 방출 리스트에 올리면서 팀을 떠날 가능성이 생겨났다.
	</pre>
	<%
	} else {
	%>
	<script>
		alert("먼저 암호를 입력해주세요");
		history.back();
	</script>
	<%
	}
	%>
</body>
</html>