<%@page import="data.dao.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//num 읽기
int num=Integer.parseInt(request.getParameter("num"));
//dao 생성
SawonDao dao = new SawonDao();
//삭제메서드 호출
dao.deleteSawon(num);
//목록으로 이동
response.sendRedirect("./sawonlist.jsp");
%>