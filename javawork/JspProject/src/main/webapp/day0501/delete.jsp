<%@page import="data.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//num읽기
int num = Integer.parseInt(request.getParameter("num"));
//dao생성
StudentDao dao=new StudentDao();
//삭제메소드 호출
dao.deleteStudent(num);
//목록으로 이동
response.sendRedirect("./list.jsp");
%>