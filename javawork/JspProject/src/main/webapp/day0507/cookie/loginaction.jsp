<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//amho를 읽는다
String amho=request.getParameter("amho");
//amho가 1234면 쿠키에 amho라는 이름으로 저장한다
if(amho.equals("1234")){
	Cookie cookie = new Cookie("amho","yes");
	cookie.setPath("/");//저장되는 위치
	cookie.setMaxAge(60*60);//1분 *60 한시간
	//쿠키는 지우는 메소드는 없어서 setMaxAge를 0으로 설정하여서 삭제가능
	response.addCookie(cookie);//브라우저에 쿠키 추가
	
	response.sendRedirect("cookiemain.jsp");
}else{%>
	<script>
	alert("암호가 맞지 않습니다");
	history.back();
	</script>
<%}
%>