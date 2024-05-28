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
	K푸드 인기에 해외에서 김 인기가 치솟으면서 지난달 김과 가공식품인 맛김 물가가 동시에 큰 폭으로 오른 것으로 나타났다. K푸드 인기에 해외에서 김 인기가 치솟은 것이 주요 원인이다. 김 원재료 가격이 오르면서 김과 맛김에 이어 김밥 물가까지 도미도 상승이 전망된다.

7일 통계청 국가통계포털에 따르면 지난달 김 물가 상승률은 10.0%로 전체 소비자물가 평균(2.9%)의 3.4배였다. 이는 지난해 2월(11.8%) 이후 14개월 만에 가장 높은 수치다.

김 물가 상승률은 올해 1월 1.2%에서 2월 3.1%, 3월 6.6%에 이어 지난달 10.0%로 상승 폭을 계속 키웠다. 맛김 물가 상승률도 1월 -1.0%에서 2월 2.5%, 3월 1.5%에 이어 지난 달 6.1%로 껑충 뛰었다. 지난달 맛김 물가 상승률은 지난해 3월(6.3%) 이후 13개월 만의 최고였다.

이같이 김과 맛김 물가가 상승 곡선을 그린 것은 김 가공 전 원재료인 원초 가격이 급등했기 때문이다. 업계 관계자는 "외국에서 김·김밥이 한류를 타고 K-푸드로 인기를 끌면서 수출 수요가 증가하면서 국내 공급이 줄어들었다"며 "여기에 일본과 중국의 원초 작황 부진으로 한국산 마른김 수요가 늘어 가격이 큰 폭으로 올랐다"고 설명했다.
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