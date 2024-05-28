<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--��Ʈ��Ʈ��-->
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!--�۲�-->
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
	이스라엘과 팔레스타인 무장정파 하마스의 휴전협상 진통 속에 가자지구 라파를 중심으로 군사적 충돌이 발생했습니다.

AFP, 로이터 통신 등에 따르면 이스라엘군은 현지 시각 6일 가자지구 남단 라파 근처를 공습했습니다.

다니엘 하가리 이스라엘군 대변인은 "전투기가 라파 근처에 있는 테러리스트 시설 50곳 이상을 타격했다"고 밝혔습니다.

하가리 대변인은 이스라엘군이 라파에서 군사작전을 계속한다며 현지 주민들에게 안전한 곳으로 대피하라고 촉구했습니다.

앞서 이스라엘군은 해당 지역 주민에게 알아와시, 칸유니스 등에 지정된 지역으로 이동하라고 라디오 등을 통해 통보했습니다.

이스라엘군은 이들 지역에서 제한된 군사작전이 있을 것이라고 예고했습니다.

공습의 정확한 피해 규모는 집계되지 않고 있습니다.

다만 라파에 있는 쿠와이티 병원은 이날 이스라엘의 공습 뒤 사망자 5명과 함께 여러 부상자를 받아들였다고 밝혔습니다.

미국은 이날 이스라엘의 라파 공습에 우려를 표명했으나 중대한 군사작전은 아니었다고 로이터 통신에 평가했습니다.

미국 정부의 한 당국자는 미국 정부가 인구 밀도가 높은 라파에 대한 중대 군사작전을 저지하는 데 주력하고 있다고 밝혔습니다.

하마스와 연대한 팔레스타인 무장세력 이슬라믹 지하드는 이스라엘의 공습에 대응해 조직원들이 로켓을 발사했다고 밝혔습니다.
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