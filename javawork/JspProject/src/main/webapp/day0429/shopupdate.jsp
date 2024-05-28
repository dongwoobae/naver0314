<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//상품 id와 값을 받아옴
String shopidx = request.getParameter("shopidx");
String updateName= request.getParameter("updateName");
int updatePrice= Integer.parseInt(request.getParameter("updatePrice"));
int updateCount = Integer.parseInt(request.getParameter("updateCount"));
String photo = request.getParameter("photo");
String color=request.getParameter("color");

//dao를 이용한 상품 업데이트
ShopDao dao= new ShopDao();
ShopDto dto = new ShopDto();
dto.setShopidx(shopidx);
dto.setSname(updateName);
dto.setScolor(color);
dto.setSphoto(photo);
dto.setSprice(updatePrice);
dto.setScount(updateCount);
dao.updateShop(dto);
//shopdetail 페이지로 이동
//response.sendRedirect("shopdetail.jsp?shopidx="+shopidx);
%>
