<%@page import="data.dto.FrameDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="data.dao.FrameDao"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
int uploadSize=1024*1024*10;
ServletContext context=getServletContext();
String realFolder=context.getRealPath("/save");

MultipartRequest multi=null;
FrameDao dao = new FrameDao();

try{
multi=new MultipartRequest(request,realFolder,uploadSize,"utf-8",
		new DefaultFileRenamePolicy());
String name=multi.getParameter("name");
String price=multi.getParameter("price");
String company=multi.getParameter("company");
String color=multi.getParameter("color");
String photo=multi.getFilesystemName("photo");

FrameDto dto = new FrameDto();
dto.setColor(color);
dto.setCompany(company);
dto.setName(name);
dto.setPhoto(photo);
dto.setPrice(price);

dao.insertFrame(dto);
response.sendRedirect("frameinsert.jsp");
}catch(Exception e){%>
<script>
	alert("파일 업로드 오류: <%=e.getMessage()%>");
	</script>
<%}

%>
