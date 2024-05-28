<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//한글 엔코딩
request.setCharacterEncoding("UTF-8");
int num=Integer.parseInt(request.getParameter("num"));
%>
<!-- jsp 액션태그를 이용해서 dto,dao를 선언해보자 -->
<jsp:useBean id="dto" class="data.dto.SawonDto"></jsp:useBean>
<jsp:useBean id="dao" class="data.dao.SawonDao"></jsp:useBean>
<!-- 자동으로 data 읽어서 dto에 넣기 -->
<!-- property에 dto의 변수명을 쓰면 해당 데이터만 읽어옴
단,*를 쓰면 모든 데이터를 읽어온다 -->
<jsp:setProperty name="dto" property="*"/>

<%
dao.updateData(dto);
response.sendRedirect("./sawondetail.jsp?num="+num);
%>