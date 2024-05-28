<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
GuestDto dto = new GuestDto();
dto.setNickname(request.getParameter("nickname"));
dto.setAvatar(request.getParameter("avatar"));
dto.setContent(request.getParameter("content"));

GuestDao dao= new GuestDao();

dao.insertGuest(dto);
%>