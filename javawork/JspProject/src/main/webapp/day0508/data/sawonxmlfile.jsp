<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SawonDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.SawonDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
pageEncoding="UTF-8"%> <%
//전체 사원 데이터 가져오기 List 
SawonDao dao=new SawonDao();
List <SawonDto> list=dao.getAllSawons();
//날짜 포맷 타입
//SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm");
//String이어서 날짜타입 필요없음 Timestamp면 필요
%>
<sawonlist>
<%
for(SawonDto dto:list){%>
	<sawon num="<%=dto.getNum() %>">
		<name><%=dto.getName() %></name>
		<buseo><%=dto.getBuseo() %></buseo>
		<age><%=dto.getAge() %></age>
		<addr><%=dto.getAddr() %></addr>
		<birthday><%=dto.getBirthday() %></birthday>
		<photo><%=dto.getPhoto() %></photo>
		<gender><%=dto.getGender()%></gender>
	</sawon>
<%}
%>
 </sawonlist>
