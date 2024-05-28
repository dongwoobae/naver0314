<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//dao 선언
ShopDao dao=new ShopDao();
ShopDto dto=new ShopDto();
//shopidx int 타입으로 읽기
String shopidx = request.getParameter("shopidx");

//delete 메소드 호출
dao.deleteShop(Integer.parseInt(shopidx));
//목록으로 이동
response.sendRedirect("shoplist.jsp");
%>
