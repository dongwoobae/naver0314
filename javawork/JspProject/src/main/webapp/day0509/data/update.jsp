<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
GuestDto dto=new GuestDto();
GuestDao dao = new GuestDao();

int num=Integer.parseInt(request.getParameter("num"));
String nickname=request.getParameter("nickname");
String content=request.getParameter("content");

dto.setContent(content);
dto.setNum(num);
dto.setNickname(nickname);

dao.updateGuest(dto);
%>