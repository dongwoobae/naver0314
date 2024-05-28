<%@page import="java.sql.Timestamp"%>
<%@page import="data.dto.StudentDto"%>
<%@page import="data.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//encoding
request.setCharacterEncoding("UTF-8");
//dao
StudentDao dao = new StudentDao();

String name=request.getParameter("name");
String blood=request.getParameter("blood");
char license=request.getParameter("license")==null?'n':'y';
int java=Integer.parseInt(request.getParameter("java"));
int spring=Integer.parseInt(request.getParameter("spring"));
int html=Integer.parseInt(request.getParameter("html"));
//폼에 어차피 writeday 받는 칸이 없어서 6개만 옮기면 됨

StudentDto dto=new StudentDto();
dto.setName(name);
dto.setBlood(blood);
dto.setJava(java);
dto.setSpring(spring);
dto.setHtml(html);
dto.setLicense(license);

dao.insertStudent(dto);

response.sendRedirect("list.jsp");
%>